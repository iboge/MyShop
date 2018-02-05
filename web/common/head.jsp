<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--顶部导航条 -->
<div class="hmtop">
<div class="am-container header">
    <ul class="message-l">
        <div class="topMessage">
            <div class="menu-hd">
                <c:choose>
                    <c:when test="${sessionScope.username!=null}">
                        <a target="_top" class="h">欢迎${sessionScope.username}</a>
                        <a href="${ctx}/quit" target="_top">注销</a>
                    </c:when>
                    <c:otherwise>
                    <a href="login.jsp" target="_top" class="h">登录</a>
                    <a href="register.jsp" target="_top">免费注册</a>
                </c:otherwise>
                </c:choose>
            </div>
        </div>
    </ul>
    <ul class="message-r">
        <div class="topMessage home">
            <div class="menu-hd"><a href="home.jsp" target="_top" class="h">商城首页</a></div>
        </div>
        <div class="topMessage my-shangcheng">
            <div class="menu-hd MyShangcheng"><a href="/myshop/queryOrder" target="_top"><i class="am-icon-user am-icon-fw"></i>我的订单</a></div>
        </div>
        <div class="topMessage mini-cart">
            <div class="menu-hd"><a id="mc-menu-hd" href="/myshop/cart" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h"></strong></a></div>
        </div>
        <div class="topMessage favorite">
            <div class="menu-hd"><a href="/myshop/queryCollection" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
        </div>
    </ul>
</div>

<!--悬浮搜索框-->

<div class="nav white">
    <%--<div class="logo"><img src="${ctx}/static/images/wb.jpg" /></div>--%>
    <div class="logoBig">
        <li><img src="${ctx}/static/images/wb.jpg" /></li>
    </div>

    <div class="search-bar pr">
        <%--<a name="index_none_header_sysc" href=""></a>--%>
        <form action="${ctx}/like" method="get">
            <input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
            <input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
        </form>
    </div>
</div>

<div class="clear"></div>
</div>
