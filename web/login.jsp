<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head lang="en">
    <title>登录</title>
    <%@include file="/common/common.jsp"%>
    <link rel="stylesheet" href="${ctx}/static/AmazeUI-2.4.2/assets/css/amazeui.css" />
    <link href="${ctx}/static/css/dlstyle.css" rel="stylesheet" type="text/css">
    <style type="text/css">body{background-color: white}</style>
</head>

<body>
<div class="login-boxtitle">
    <a href="home.html"><img alt="logo" src="${ctx}/static/img/lr.jpg" /></a>
</div>

<div class="login-banner">
    <div class="login-main">
        <div class="login-banner-bg"><span></span><img style="margin-top: 100px" src="${ctx}/static/img/lr1.jpg" /></div>
        <div class="login-box">

            <h3 style="margin-top: 25px" class="title">登录商城</h3>
            <p>${requestScope.error}</p>
            <div class="clear"></div>

                <form action="${ctx}/login" method="post">
                    <div style="margin-top: 20px" class="am-tabs-bd">
                        <input type="hidden" name="returnUrl" value="${param.returnUrl}">
                        <div class="user-name">
                            <label for="user"><i class="am-icon-user"></i></label>
                            <input type="text" name="username" id="user" placeholder="请输入用户名">
                        </div>
                        <div class="user-pass">
                            <label for="password"><i class="am-icon-lock"></i></label>
                            <input type="password" name="password" id="password" placeholder="请输入密码">
                        </div>
                        <%--<input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">--%>
                    </div>

                    <div class="login-links">
                        <a href="#" class="am-fr">忘记密码</a>
                        <a href="register.jsp" class="zcnext am-fr am-btn-default">注册</a>
                        <br />
                    </div>
                    <div class="am-cf">
                        <input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
                    </div>
                    <div class="partner">
                        <div class="am-btn-group"></div>
                    </div>
                </form>

        </div>
    </div>
</div>
<%@include file="/common/foot.jsp"%>
</body>

</html>