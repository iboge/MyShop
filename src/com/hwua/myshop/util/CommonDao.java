package com.hwua.myshop.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * 通用DAO
 * 
 * @author gujil
 *
 */
public class CommonDao extends JDBCTemplate {

	/**
	 * 此方法用来执行更新操作（增删改）
	 * 
	 * @param sql
	 *            要执行的SQL语句
	 * @param params
	 *            执行SQL所需要参数
	 * @return
	 */
	public int executeUpdate(String sql, Object... params) {
		int result = 0;// 保存执行结果
		// 建立连接
		Connection conn = getConnection();
		// 创建语句对象
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			// 判断是否需要设置占位符
			if (params != null && params.length > 0) {
				// 设置占位符
				for (int i = 0; i < params.length; i++) {
					pstm.setObject(i + 1, params[i]);
				}
			}
			// 执行SQL
			result = pstm.executeUpdate();
			// 释放资源
			close(null, pstm, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 通用的查询方法 将查询结果封装到JavaBean，多个JavaBean放入List
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return 当返回的集合的size > 0时，说明查询到了记录
	 */
	public <T> List<T> query4Bean(String sql, Class<T> clazz, Object... params) {
		List<T> list = new ArrayList<T>();
		// 获取连接
		Connection conn = getConnection();
		// 创建语句对象
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			// 判断是否需要设置占位符
			if (params != null && params.length > 0) {
				// 设置占位符
				for (int i = 0; i < params.length; i++) {
					pstm.setObject(i + 1, params[i]);
				}
			}
			// 执行SQL语句，获取结果集
			ResultSet rs = pstm.executeQuery();
			// 获取元数据
			ResultSetMetaData md = rs.getMetaData();
			// 获取有多少列
			int columnCount = md.getColumnCount();
			// 准备一个字符串数组，用来存在所有字段
			String[] columnNames = new String[columnCount];
			for (int i = 1; i <= columnCount; i++) {
				// 获取字段名
				String name = md.getColumnName(i);
				columnNames[i - 1] = name;
			}
			while (rs.next()) {
				// 创建对象
				T t = clazz.newInstance();
				// 遍历columnNames数组
				for (String columnName : columnNames) {
					// 获取字段的值
					Object obj = rs.getObject(columnName);
					// 获取所有的私有属性
					Field[] fields = clazz.getDeclaredFields();
					// 遍历fields，获取set方法
					for (Field field : fields) {
						// 获取 属性名
						String name = field.getName();
						// 拼接set方法名
						String smn = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
						if (("set" + columnName.replaceAll("_", "")).equalsIgnoreCase(smn)) {
							// System.out.println(smn+"-"+columnName);
							// 获取set方法
							Method sm = clazz.getMethod(smn, field.getType());
							if (obj == null) {
								continue;
							}
							System.out.println(obj + "-" + obj.getClass());
							if (obj instanceof BigDecimal) {
								if (field.getType() == Integer.class) {
									sm.invoke(t, ((BigDecimal) obj).intValue());
								} else if (field.getType() == Double.class) {
									sm.invoke(t, ((BigDecimal) obj).doubleValue());
								}
							} else if (obj instanceof Timestamp) {
								Date date = new Date(((Timestamp) obj).getTime());
								sm.invoke(t, date);
							} else {
								sm.invoke(t, obj);
							}
						}

					}
				}
				list.add(t);
			}
			// 释放资源
			close(rs, pstm, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 通用的查询方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> query4MapList(String sql, Object... params) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			// 获取连接
			Connection conn = getConnection();
			// 创建语句对象
			PreparedStatement pstm = conn.prepareStatement(sql);
			// 判断是否需要设置占位符
			if (params != null && params.length > 0) {
				// 设置占位符
				for (int i = 0; i < params.length; i++) {
					pstm.setObject(i + 1, params[i]);
				}
			}
			// 执行SQL语句
			ResultSet rs = pstm.executeQuery();
			// 获取元数据
			ResultSetMetaData md = rs.getMetaData();
			// 获取列的个数
			int columnCount = md.getColumnCount();
			// 准备String类型的数组用来保存列名
			String[] columnNames = new String[columnCount];
			// 循环获取列名，放入数组
			for (int i = 1; i <= columnCount; i++) {
				// 获取列名
				String columnName = md.getColumnName(i);
				columnNames[i - 1] = columnName;
			}
			// 遍历结果集
			while (rs.next()) {
				// 准备Map，用来存在一条记录
				Map<String, Object> map = new HashMap<String, Object>();
				for (String cn : columnNames) {
					// 获取指定列的值
					Object value = rs.getObject(cn);
					// 将value存入map
					map.put(cn.toLowerCase(), value);
				}
				// 将map放入list
				list.add(map);
			}
			// 释放资源
			close(rs, pstm, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * 查询一条记录
	 * @param sql
	 * @param params
	 * @return
	 */
	public Map<String, Object> query4Map(String sql, Object... params) {
		List<Map<String,Object>> list = query4MapList(sql, params);
		return list.size() > 0 ? list.get(0) : null;
	}

    /**
     * 任意条件的查询多条数据
     * @param sql
     * @param params
     * @return
     */
	public Map<String, Object> query4Map(String sql,Map<String, Object> params){
		List<Map<String, Object>> list = query4MapList(sql, params);
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 任意条件的查询多条数据
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> query4MapList(String sql,Map<String, Object> params){
		//找到ORDER BY的位置
		sql = sql.toLowerCase();
		int index = sql.indexOf("order by");
		String orderBy = null;
		if(index != -1) {
			//截取ORDER BY子句
			orderBy = sql.substring(index);
			//截取不排序的sql
			sql = sql.substring(0, index);
		}
		StringBuilder sb = new StringBuilder(sql);
		sb.append(" WHERE 1 = 1");
		Set<String> keySet = params.keySet();
		Object[] values = new Object[params.size()];
		int i = 0;//
		for (String key : keySet) {
			sb.append(" AND "+ key +" = ?");
			values[i++] = params.get(key);
		}
		if(orderBy != null) {
			sb.append(orderBy);
		}
		return query4MapList(sb.toString(), values);
	}
	
}
