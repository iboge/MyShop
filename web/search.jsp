<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>搜索页面</title>
    <%@include file="/common/common.jsp"%>
    <link href="${ctx}/static/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

    <link href="${ctx}/static/basic/css/demo.css" rel="stylesheet" type="text/css" />

    <link href="${ctx}/static/css/seastyle.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="${ctx}/static/basic/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/script.js"></script>
</head>

<body>
<%@include file="/common/head.jsp"%>

<div class="clear"></div>
<b class="line"></b>
<div class="search">
    <div class="search-list">

        <div style="margin-top:50px;" class="am-g am-g-fixed">
            <div class="am-u-sm-12 am-u-md-12">

                <div class="theme-popover">
                    <ul class="select">
                        <%--<div class="clear"></div>
                        &lt;%&ndash;<li class="select-result">
                            <dl>
                                <dt>已选</dt>
                                <dd class="select-no"></dd>
                                <p class="eliminateCriteria">清除</p>
                            </dl>
                        </li>&ndash;%&gt;
                        <div class="clear"></div>--%>
                        <li class="select-list">
                            <dl id="select1">
                                <dt class="am-badge am-round">品牌</dt>

                                <div class="dd-conent">
                                    <dd class="select-all"><a href="${ctx}/refresh">全部</a></dd>
                                    <c:forEach items="${applicationScope.brand}" var="brands">
                                        <dd><a href="${ctx}/refresh?brand_id=${brands.id}">${brands.name}</a></dd>
                                    </c:forEach>
                                </div>

                            </dl>
                        </li>
                        <li class="select-list">
                            <dl id="select2">
                                <dt class="am-badge am-round">种类</dt>
                                <div class="dd-conent">
                                    <dd class="select-all"><a href="${ctx}/refresh">全部</a></dd>
                                    <c:forEach items="${applicationScope.categorys}" var="category">
                                        <dd><a href="${ctx}/refresh?category_id=${category.id}">${category.name}</a></dd>
                                    </c:forEach>
                                </div>
                            </dl>
                        </li>

                    </ul>
                    <div class="clear"></div>
                </div>
                <div class="search-content">
                    <div class="sort">
                        <li>小二 为您找到了以下商品</li>
                    </div>
                    <div class="clear"></div>
                    <ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
                        <c:forEach items="${requestScope.good}" var="goods">
                            <li>
                                <div class="i-pic limit">
                                    <a href="${ctx}/introduction?id=${goods.id}"><img src="${ctx}/${goods.image}" /></a>
                                    <p class="title fl">${goods.name}</p>
                                    <p class="price fl">
                                        <b>￥</b>
                                        <strong>${goods.price}</strong>
                                    </p>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="search-side">

                    <div class="side-title">
                        推荐
                    </div>
                    <c:forEach items="${applicationScope.allHW}" var="allHWS">

                        <li>
                            <div class="i-pic check">
                                <a href="${ctx}/introduction?id=${allHWS.id}"><img src="${ctx}/${allHWS.image}" /></a>
                                <p class="check-title">${allHWS.name}</p>
                                <p class="price fl">
                                    <b>￥</b>
                                    <strong>${allHWS.price}</strong>
                                </p>
                            </div>
                        </li>

                    </c:forEach>

                </div>
                <div class="clear"></div>

            </div>
        </div>

        <%@include file="/common/foot.jsp"%>
    </div>
</div>

</body>

</html>