package com.hwua.myshop.util;

import java.sql.*;

public class JDBCTemplate {

	//创建数据库连接，并将连接返回
	public Connection getConnection() {
		return JDBCDataSource.getConnection();
	}

	//释放资源
	public void close(ResultSet rs, Statement stm, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}