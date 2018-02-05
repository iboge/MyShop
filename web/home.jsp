<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <%-- 引入common.jsp --%>
    <%@include file="/common/common.jsp"%>
    <link href="${ctx}/static/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/css/hmstyle.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/static/css/skin.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/static/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
    <script src="${ctx}/static/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

</head>
<body>
    <%@include file="/common/head.jsp"%>

<div class="banner">
    <!--轮播 -->
    <div class="am-slider am-slider-default scoll" data-am-flexslider id="demo-slider-0">
        <ul class="am-slides">
            <li style="margin-left: -50px"><a href="${ctx}/search"><img src="${ctx}/static/images/bdfl.jpg" /></a></li>
            <li><a href="${ctx}/search"><img src="${ctx}/static/images/dws.jpg" /></a></li>
            <li><a href="${ctx}/search"><img src="${ctx}/static/images/kew.jpg" /></a></li>
        </ul>
    </div>
    <div class="clear"></div>
</div>
        <%@include file="/common/navigation.jsp"%>
<div class="shopMainbg">
    <div class="shopMain" id="shopmain">
    <div class="clear "></div>
    <div id="f1">

        <!--机械表-->

        <div class="am-container ">
            <div class="shopTitle ">
                <h4>机械表</h4>
                <h3>每一只腕表都有一个故事</h3>
            </div>
        </div>

        <div class="am-g am-g-fixed floodFour">
            <div class="am-u-sm-5 am-u-md-4 text-one list ">
                <div class="word">
                    <span>机械表（mechanical watch ）通常可分为下列两种：手上链及自动上链手表两种。这两款机械的动力来源皆是靠机芯内的发条为动力，
                        带动齿轮进而推动表针，只是动力来源的方式有异。机械表由机芯和外观部件组成。</span>
                </div>
                <a href="${ctx}/search ">
                    <img src="${ctx}/static/img/ts01.jpg" />
                </a>
                <div class="triangle-topright"></div>
            </div>

            <c:forEach items="${applicationScope.good1}" var="goods" end="3">

                <div class="am-u-sm-3 am-u-md-2 text-three last big ">
                    <div class="outer-con ">
                        <div class="title ">
                            ${goods.name}
                        </div>
                        <div class="sub-title ">
                            ￥${goods.price}
                        </div>
                        <%--<i class="am-icon-shopping-basket am-icon-md  seprate"></i>--%>
                    </div>
                    <a href="${ctx}/introduction?id=${goods.id}"><img src="${ctx}/${goods.image}" /></a>
                </div>

            </c:forEach>

        </div>
        <div class="clear "></div>
    </div>

    <!--石英表-->

    <div id="f2">
        <div class="am-container ">
            <div class="shopTitle ">
                <h4>石英表</h4>
                <h3>每一只腕表都有一个故事</h3>
            </div>
        </div>

        <div class="am-g am-g-fixed floodFour">
            <div class="am-u-sm-5 am-u-md-4 text-one list ">
                <div class="word">
                    <span>石英表是腕表种类之一，英文是quartz watch。 将石英晶体运用在钟表上是一种现代的发明，
                        第一只石英表在1969年首度出现。在这一年，日本的精工公司发现了如何将石英制成音叉的方法。</span>
                </div>
                <a href="${ctx}/search ">
                    <img src="${ctx}/static/img/jj01.jpg" />
                </a>
                <div class="triangle-topright"></div>
            </div>

            <c:forEach items="${applicationScope.good2}" var="goods" end="3">

                <div class="am-u-sm-3 am-u-md-2 text-three last big ">
                    <div class="outer-con ">
                        <div class="title ">
                                ${goods.name}
                        </div>
                        <div class="sub-title ">
                            ￥${goods.price}
                        </div>
                        <%--<i class="am-icon-shopping-basket am-icon-md  seprate"></i>--%>
                    </div>
                    <a href="${ctx}/introduction?id=${goods.id}"><img src="${ctx}/${goods.image}" /></a>
                </div>

            </c:forEach>

        </div>
        <div class="clear "></div>

    </div>


    <div id="f3">

        <!--智能表-->

        <div class="am-container ">
            <div class="shopTitle ">
                <h4>智能表</h4>
                <h3>每一只腕表都有一个故事</h3>
            </div>
        </div>

        <div class="am-g am-g-fixed floodFour">
            <div class="am-u-sm-5 am-u-md-4 text-one list ">
                <div class="word">
                    <span>智能手表是具有信息处理能力，符合手表基本技术要求的手表。其功能相似于一台个人数码助理，
                        除指示时间之外，还应具有提醒、 导航、校准、监测、交互等其中一种或者多种功能。</span>
                </div>
                <a href="${ctx}/search ">
                    <img src="${ctx}/static/img/hw3.jpg " />
                </a>
                <div class="triangle-topright"></div>
            </div>

            <c:forEach items="${applicationScope.good3}" var="goods" end="3">

                <div class="am-u-sm-3 am-u-md-2 text-three last big ">
                    <div class="outer-con ">
                        <div class="title ">
                                ${goods.name}
                        </div>
                        <div class="sub-title ">
                                ￥${goods.price}
                        </div>
                        <%--<i class="am-icon-shopping-basket am-icon-md  seprate"></i>--%>
                    </div>
                    <a href="${ctx}/introduction?id=${goods.id}"><img src="${ctx}/${goods.image}" /></a>
                </div>

            </c:forEach>

        </div>
        <div class="clear "></div>
    </div>

<%@include file="/common/foot.jsp"%>

</div>
</div>


</div>
</body>

</html>
