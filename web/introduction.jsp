<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>商品页面</title>
    <%@include file="/common/common.jsp"%>
    <link href="${ctx}/static/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link type="text/css" href="${ctx}/static/css/optstyle.css" rel="stylesheet" />
    <link type="text/css" href="${ctx}/static/css/style.css" rel="stylesheet" />

    <script type="text/javascript" src="${ctx}/static/basic/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/basic/js/quick_links.js"></script>

    <script type="text/javascript" src="${ctx}/static/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/jquery.imagezoom.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/list.js"></script>

</head>

<body>

<%@include file="/common/head.jsp"%>
<div class="clear"></div>
<b class="line"></b>
<div style="margin-top: 50px;" class="listMain">

    <script type="text/javascript">
        $(function() {});
        $(window).load(function() {
            $('.flexslider').flexslider({
                animation: "slide",
                start: function(slider) {
                    $('body').removeClass('loading');
                }
            });
        });
    </script>
    <div class="scoll">
        <section class="slider">
            <div class="flexslider">
                <ul class="slides">
                    <li>
                        <img src="${ctx}/${requestScope.good.image}" title="pic" />
                    </li>
                </ul>
            </div>
        </section>
    </div>

    <!--放大镜-->

    <div class="item-inform">
        <div class="clearfixLeft" id="clearcontent">

            <div class="box">
                <script type="text/javascript">
                    $(document).ready(function() {
                        $(".jqzoom").imagezoom();
                        $("#thumblist li a").click(function() {
                            $(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
                            $(".jqzoom").attr('src', $(this).find("img").attr("mid"));
                            $(".jqzoom").attr('rel', $(this).find("img").attr("big"));
                        });
                    });
                </script>

                <div class="tb-booth tb-pic tb-s310">
                    <a href="${ctx}/${requestScope.good.image}"><img src="${ctx}/${requestScope.good.image}" alt="细节展示放大镜特效" rel="${ctx}/${requestScope.good.image}" class="jqzoom" /></a>
                </div>
                <ul class="tb-thumb" id="thumblist">
                    <li class="tb-selected">
                        <div class="tb-pic tb-s40">
                            <a href="#"><img src="${ctx}/${requestScope.good.image}" mid="${ctx}/${requestScope.good.image}" big="${ctx}/${requestScope.good.image}"></a>
                        </div>
                    </li>
                </ul>
            </div>

            <div class="clear"></div>
        </div>

        <div class="clearfixRight">

            <!--规格属性-->
            <!--名称-->
            <div class="tb-detail-hd">
                <h1>
                    ${requestScope.good.name}
                </h1>
            </div>
            <div class="tb-detail-list">
                <!--价格-->
                <div class="tb-detail-price">
                    <li class="price iteminfo_price">
                        <dt>价格</dt>
                        <dd><em>¥</em><b class="sys_item_price">${requestScope.good.price}</b>  </dd>
                    </li>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
                <hr/>
            </div>
            <div class="clear"></div>

            <div class="btn-op">
                <div class="btn am-btn am-btn-warning">确认</div>
                <div class="btn close am-btn am-btn-warning">取消</div>
            </div>
            <div class="pay">
                <div class="pay-opt">
                    <a href="home.html"><span class="am-icon-home am-icon-fw">首页</span></a>
                    <%--<a><span class="am-icon-heart am-icon-fw">收藏</span></a>--%>

                </div>
                <li>
                    <div class="clearfix tb-btn tb-btn-buy theme-login">
                        <a id="LikBuy" title="点此按钮到下一步确认购买信息" href="${ctx}/addOrder?id=${requestScope.good.id}">立即购买</a>
                    </div>
                </li>
                <li>
                    <div class="clearfix tb-btn tb-btn-basket theme-login">
                        <a id="LikBasket" title="加入购物车" href="${ctx}/favorites?id=${requestScope.good.id}"><i></i>加入购物车</a>
                    </div>
                </li>
                <li>
                    <div style="margin-left: 10px" class="clearfix tb-btn tb-btn-basket theme-login">
                        <a id="LikBasket1" title="加入收藏夹" href="${ctx}/collection?id=${requestScope.good.id}"><i></i>加入收藏夹</a>
                    </div>
                </li>
            </div>
        </div>
        </form>
    </div>
</div>

</dd>
</dl>
<div class="clear"></div>

</div>

</div>

<div class="clear"></div>

</div>
<%@include file="/common/foot.jsp"%>

<div class="clear"></div>

</div>
</body>

</html>