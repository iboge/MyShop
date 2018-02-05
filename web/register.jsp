<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head lang="en">
    <title>注册</title>
    <%-- 引入common.jsp --%>
    <%@include file="/common/common.jsp"%>
    <link rel="stylesheet" href="${ctx}/static/AmazeUI-2.4.2/assets/css/amazeui.min.css" />
    <link href="${ctx}/static/css/dlstyle.css" rel="stylesheet" type="text/css">
    <script src="${ctx}/static/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
    <script src="${ctx}/static/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
    <style type="text/css">body{background-color: white}</style>
</head>

<body>
<div class="login-boxtitle">
    <a href="home/demo.html"><img alt="" src="${ctx}/static/img/lr.jpg" /></a>
</div>

<div class="res-banner">
    <div class="res-main">
        <div class="login-banner-bg"><span></span><img style="margin-top: 100px" src="${ctx}/static/img/lr1.jpg" /></div>
        <div class="login-box">

            <div style="margin-top: 20px" class="am-tabs" id="doc-my-tabs">
                <ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
                    <li class="am-active"><a href="">注册</a></li>
                </ul>

                <div style="margin-top: -20px" class="am-tabs-bd">
                    <div class="am-tab-panel am-active">
                        <form action="${ctx}/register" method="post">

                            <div class="user-email">
                                <label for="email"><i class="am-icon-envelope-o"></i></label>
                                <input type="email" name="email" id="email" placeholder="请输入邮箱账号">
                            </div>
                            <div class="user-phone">
                                <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
                                <input type="tel" name="tel" id="phone" placeholder="请输入手机号">
                            </div>
                            <div class="user-name">
                                <label for="user"><i class="am-icon-user"></i></label>
                                <input type="text" name="username" id="user" placeholder="请输入用户名">
                            </div>
                            <div class="user-pass">
                                <label for="password"><i class="am-icon-lock"></i></label>
                                <input type="password" name="password" id="password1" placeholder="设置密码">
                            </div>
                            <div class="user-email">
                                <label for="addr"><i class="am-icon-envelope-o"></i></label>
                                <input type="addr" name="addr" id="addr" placeholder="请输入地址">
                            </div>
                        <div class="am-cf">
                            <input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
                        </div>
                        </form>
                    </div>

                    <div class="am-tab-panel">
                        <form method="post">
                            <div class="user-phone">
                                <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
                                <input type="tel" name="" id="phone1" placeholder="请输入手机号">
                            </div>
                            <div class="verification">
                                <label for="code"><i class="am-icon-code-fork"></i></label>
                                <input type="tel" name="" id="code" placeholder="请输入验证码">
                                <a class="btn" href="javascript:void(0);" onclick="sendMobileCode();" id="sendMobileCode">
                                    <span id="dyMobileButton">获取</span></a>
                            </div>
                            <div class="user-pass">
                                <label for="password"><i class="am-icon-lock"></i></label>
                                <input type="password" name="" id="password" placeholder="设置密码">
                            </div>
                            <div class="user-pass">
                                <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
                                <input type="password" name="" id="passwordRepeat" placeholder="确认密码">
                            </div>
                        </form>
                        <div class="login-links">
                            <label for="reader-me">
                                <input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
                            </label>
                        </div>
                        <div class="am-cf">
                            <input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
                        </div>

                        <hr>
                    </div>

                    <script>
                        $(function() {
                            $('#doc-my-tabs').tabs();
                        })
                    </script>

                </div>
            </div>

        </div>
    </div>
<%@include file="/common/foot.jsp"%>
</div>
</body>

</html>