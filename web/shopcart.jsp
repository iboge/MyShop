<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>购物车页面</title>
    <%@include file="/common/common.jsp"%>
    <link href="${ctx}/static/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/css/cartstyle.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/css/optstyle.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="${ctx}/static/js/jquery.js"></script>
    <script type="application/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("input[name='btn']").click(function () {
                var data = {};
                if($(this).val() == "+"){
                    data.count = Number($(this).prev("input[name='count']").val())+1;
                }else{
                    if($(this).next("input[name='count']").val()==1) {
                        data.count = 1;
                    }else {
                        data.count = Number($(this).next("input[name='count']").val()) - 1;
                    }
                }
                data.gid = $(this).nextAll("input[name='gid']").val();
                console.log(data);
                $.ajax({
                    url:"cartajax",
                    type:"POST",
                    data:data,
                    success:function (result) {
                        var count = $("input[name='count']").val();
                        var price = $("input[name='number']").val();
                        $(".price").text(count * price);
                        location.reload();
                    },
                    error:function () {},
                });
            });
        });
    </script>
    <%--<script type="text/javascript">
           window.onload = function(){
               var items = document.getElementsByName("items[]");
               var all = document.getElementById("J_SelectAllCbx2");
               all.onclick = function(){
                   for(var i=0;i<items.length;i++){
                       items[i].checked=this.checked;
                   }
               };
               for(var i=0;i<items.length;i++){
                   var item = items[i];
                   item.onclick = function(){
                       //默认全选
                       all.checked = true;
                       //判断是否全部选中
                       for(var j=0;j<items.length;j++){
                           if(!items[j].checked){
                               all.checked = false;
                               break;
                           }
                       }
                   }
               }
           };
       </script>--%>
</head>

<body>
<%@include file="/common/head.jsp"%>
<b style="margin-top: -50px" class="line"></b>
<div style="margin-top: 20px" class="clear"></div>
<!--购物车 -->
<form action="${ctx}/order" method="post">
<div class="concent">
    <div id="cartTable">
        <div class="cart-table-th">
            <div class="wp">
                <div class="th th-chk">
                    <div id="J_SelectAll1" class="select-all J_SelectAll">

                    </div>
                </div>
                <div class="th th-item">
                    <div class="td-inner">商品信息</div>
                </div>
                <div class="th th-price">
                    <div class="td-inner">单价</div>
                </div>
                <div class="th th-amount">
                    <div class="td-inner">数量</div>
                </div>
                <div class="th th-sum">
                    <div class="td-inner">金额</div>
                </div>
                <div class="th th-op">
                    <div class="td-inner">操作</div>
                </div>
            </div>
        </div>
        <div class="clear"></div>

        <tr class="item-list">
            <div class="bundle  bundle-last ">

                <div class="clear"></div>
                <div class="bundle-main">
                    <c:forEach items="${requestScope.car}" var="cars">
                        <ul class="item-content clearfix">
                            <%--<li class="td td-chk">
                                <div class="cart-checkbox ">
                                    <input class="check" id="J_CheckBox_170769542747" name="items[]" value="170769542747" type="checkbox">
                                    <label for="J_CheckBox_170769542747"></label>
                                </div>
                            </li>--%>
                            <input type="hidden" name="fid" value="${cars.g_id}"/>
                            <li class="td td-item">
                                <div class="item-pic">
                                    <a href="#" target="_blank" data-title="${cars.g_name}" class="J_MakePoint" data-point="tbcart.8.12">
                                        <img src="${cars.g_image}" class="itempic J_ItemImg" width="90px" height="90px"></a>
                                </div>
                                <div class="item-info">
                                    <div class="item-basic-info">
                                        <a href="#" target="_blank" title="" class="item-title J_MakePoint" data-point="tbcart.8.11">${cars.g_name}</a>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-info">
                                <div style="height: 10px"></div>
                            </li>
                            <li class="td td-price">
                                <div class="item-price price-promo-promo">
                                    <div class="price-content">
                                        <div class="price-line">
                                            <em class="J_Price price-now" tabindex="0">${cars.g_price}</em>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-amount">
                                <div class="amount-wrapper ">
                                    <div class="item-amount ">
                                        <div class="sl">
                                            <input type="hidden" name="price" value="${cars.g_price}"/>
                                            <input class="min" name="btn" type="button" value="-" />
                                            <input class="text_box" name="count" type="text" value="${cars.f_count}" style="width:30px;" />
                                            <input class="add" name="btn" type="button" value="+" />
                                            <input type="hidden" name="gid" value="${cars.g_id}"/>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-sum">
                                <div class="td-inner">
                                    <em tabindex="0" class="number">${cars.g_price * cars.f_count}</em>
                                    <c:set var="cp" value="${cars.g_price * cars.f_count}"></c:set>
                                    <input type="hidden" name="cp" value="${cp}">
                                </div>
                            </li>
                            <li class="td td-op">
                                <div class="td-inner">
                                    <a href="${ctx}/del?id=${cars.g_id}" data-point-url="#" class="delete">删除</a>
                                </div>
                            </li>
                        </ul>
                        <c:set var="sum" value="${sum + cars.g_price * cars.f_count}"></c:set>
                        <c:set var="cou" value="${cou + cars.f_count}"></c:set>
                    </c:forEach>
                </div>
            </div>
        </tr>
    </div>
    <div class="clear"></div>

    <div class="float-bar-wrapper">
        <%--<div id="J_SelectAll2" class="select-all J_SelectAll">
            <div class="cart-checkbox">
                <input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
                <label for="J_SelectAllCbx2"></label>
            </div>
            <span>全选</span>
        </div>--%>
        <div style="margin-left: 20px" class="operations">
            <a href="${ctx}/del" hidefocus="true" class="deleteAll">清空购物车</a>
            <%--<a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a>--%>
        </div>
        <div class="float-bar-right">
            <div class="amount-sum">
                <span class="txt">已选商品</span>
                <em id="J_SelectedItemsCount">${cou}</em><span class="txt">件</span>
                <div class="arrow-box">
                    <span class="selected-items-arrow"></span>
                    <span class="arrow"></span>
                </div>
            </div>
            <div class="price-sum">
                <span class="txt">合计:</span>
                <strong class="price">¥<em id="J_Total">${sum}</em></strong>
                <input type="hidden" name="total" value="${sum}"/>
            </div>
            <div class="btn-area">
                <a id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
                    <input style="display: inline-block;margin-top: 12px" type="submit" value="结算"></a>
            </div>
        </div>

    </div>

</div>
</form>
<%@include file="/common/foot.jsp"%>
<div class="theme-popover-mask"></div>
</body>
</html>