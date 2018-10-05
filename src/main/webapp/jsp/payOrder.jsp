<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>订单支付页面</title>

<link
	href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/basic/css/demo.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cartstyle.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/optstyle.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/myMath.js"></script>

<style type="text/css">
#headDiv {
	width: 905px;
	position: relative;
	left: 7px;
	top: 0px;
}

#addressDiv {
	width: 905px;
	height: 107px;
	position: relative;
	left: 7px;
	top: 2px;
	/*   border:3px solid red; */
}

#addressInfo {
	position: relative;
	left: 508px;
	top: 0px;
	/*  border:3px solid red; */
	width: 335px;
	height: 101px;
	background-image:
		url("${pageContext.request.contextPath}/images/addressbg.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
}

.addressInfo {
	font-size: 20px;
	color: #AAAC45;
}

#addressONum {
	position: relative;
	left: 22px;
	top: -101px;
	/*  border:3px solid red; */
	width: 335px;
	height: 101px;
}
</style>

</head>

<body>

	<!--顶部导航条 -->
	<%@include file="head.jsp"%>

	<!--购物车 -->
	<form id="carForm"
		action="${pageContext.request.contextPath}/shopcar/saveCar.action"
		method="post">
		<div class="concent">
			<div id="cartTable">
				<div class="cart-table-th">
					<div id="headDiv" class="wp" style="height: 70px;">
						<div class="th th-chk">
							<div id="J_SelectAll1" class="select-all J_SelectAll"></div>
						</div>
						<div class="th th-item">
							<div class="td-inner">商品信息</div>

						</div>
						<div style="position: relative; left: -178px;" class="th th-price">
							<div class="td-inner">单价</div>
						</div>
						<div style="position: relative; left: -41px;" class="th th-amount">
							<div class="td-inner">数量</div>
						</div>
						<div style="position: relative; left: 94px;" class="th th-sum">
							<div class="td-inner">金额</div>
						</div>
					</div>
				</div>
				<div class="clear"></div>

				<tr class="item-list">
					<div style="position: relative; left: 7px; width: 906px;"
						class="bundle  bundle-last ">
						<div style="position: relative; left: 0px; width: 906px;"
							class="bundle-hd">
							<div class="bd-promos"></div>
						</div>
						<div class="clear"></div>
						<div class="bundle-main"></div>
					</div>
				</tr>
				<div class="clear"></div>

				<tr class="item-list">
					<div style="position: relative; left: 9px; width: 902px;"
						class="bundle  bundle-last ">

						<div class="clear"></div>
						<div style="position: relative; left: 0px; width: 900px;"
							class="bundle-main">

							<!-- 购物车 -->
							<!-- 区分每个购物项的辅助变量 -->
							<c:set var="itemNum" scope="page" value="${0}"></c:set>
							<c:forEach items="${order.orderItems}" var="orderItem">
								
								<!-- 一个ul是一个购物项 -->
								<ul id="item${itemNum}"
									style="position: relative; left: 0px; width: 900px; background-color: white; border: 1px solid rgb(287, 236, 120); border-radius: 6px;"
									class="item-content clearfix orderItem">
									<li onclick="beCheck('${itemNum}');" class="td td-item">
										<div
											style="position: relative; top: 44px; left: -20px; width: 20px; height: 20px;">
											<%-- <input style="width:15px;height:15px; background-color: #F47164;border: 3px solid #F47164;" id="check${itemNum}"  type="checkbox" name="before" value="${itemNum}"/> --%>
										</div>

										<div class="item-pic"
											style="position: relative; top: -23px; left: 4px;">
											<a target="_blank" class="J_MakePoint"
												data-point="tbcart.8.12"> <img
												src="${pageContext.request.contextPath}/shoppingImages/${orderItem.goodImage}"
												style="width: 80px; height: 80px" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info" style="margin-top: -7px;">
												<a
													href="${pageContext.request.contextPath}/goods/showGoodById.action?gId=${orderItem.goodId}"
													target="_blank" title="" class="item-title J_MakePoint"
													data-point="tbcart.8.11"> <span
													style="position: relative; top: 22px; left: 12px; color: #AAAAAA; font-size: 22px;">${orderItem.goodName}</span></a>
												<br /> <span
													style="position: relative; top: 32px; left: 12px; color: #AAAAAA">${orderItem.goodDes}</span>
											</div>
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content"
												style="position: relative; top: 25px; left: 6px;">
												<div class="price-line">
													<em class="price-original">${orderItem.goodPrice}</em>
												</div>

												<div class="price-line">
													<em id="gcPrice${itemNum}" class="J_Price price-now"
														tabindex="0">${orderItem.goodPrice}</em>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl"
													style="position: relative; top: 25px; left: 144px">
													<em name="count" class="text_box" style="width: 30px; text-align: center;" >
													${orderItem.buyNum}
													</em>
													
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner"
											style="position: relative; top: 30px; left: 278px">
											<em id="itemprice${itemNum}" tabindex="0"
												class="J_ItemSum number"><fmt:formatNumber
													value="${orderItem.itemTotal}" pattern="#.00" /></em>
										</div>
									</li>
									<!-- 作为参数传递给外界 -->
									<input type="hidden" name="oId" value="${order.orderId}" />
								</ul>
							</c:forEach>
						</div>
					</div>
				</tr>
			</div>
			<div class="clear"></div>

			<div id="addressDiv">
				<div id="addressInfo">
					<span style="position: relative; top: 9px; left: 32px"
						class="addressInfo">${order.orderShAddress}</span><br> <span
						style="position: relative; top: 31px; left: 44px"
						class="addressInfo">${order.oderShTel}：&nbsp;&nbsp;&nbsp;&nbsp;</span>
					<span style="position: relative; top: 31px; left: 21px"
						class="addressInfo">${order.orderShPeople}（收）</span>
				</div>
				<div id="addressONum">
					<span style="position: relative; top: 5px; left: 21px"
						class="addressInfo">订单号：<span>${order.orderNum}</span></span>
				</div>
			</div>
			<div style="position: relative; width: 914px; left: 6px; top: -10px;"
				class="float-bar-wrapper">
				<div class="float-bar-right">
					<div class="amount-sum">
						<span class="txt">已选商品</span> <em id="getnum"></em><span
							class="txt"> <span id="goodAllSize">${allSize}</span>
							件
						</span>
						<div class="arrow-box">
							<span class="selected-items-arrow"></span> <span class="arrow"></span>
						</div>
					</div>
					<div class="price-sum">
						<span class="txt">合计:</span> <strong class="price"> ¥<em
							id="J_Total"></em> <span id="allPrice">${order.orderTotalMoney}</span>
						</strong>
					</div>
					<div class="btn-area" style="border-radius: 7px;">
						<a href="#" id="J_Go" onclick="return goPay(${order.orderId});"
							class="submit-btn submit-btn-disabled"
							aria-label="请注意如果没有选择宝贝，将无法结算"> <span>支&nbsp;付</span></a>

					</div>

				</div>

			</div>

			<div style="position: relative; left: -38px; top: 0px; width: 908px;"
				class="footer">
				<div class="footer-hd">
					<p>
						<a href="#">恒望科技</a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a
							href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
					</p>
				</div>
				<div class="footer-bd">
					<p>
						<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
							href="#">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有</em>
					</p>
				</div>
			</div>

		</div>
		<div id="disappare"
			style="display: none; border: 3px solid #ccc; border-radius: 7px; background: #fff; font-size: 35px; width: 309px; height: 110px; position: relative; top: -304px; left: 765px;">
			<h2 style="color: #B79">温馨提示：</h2>
			<p
				style="position: relative; top: 18px; left: 2px; color: #B79; text-align: center;">您还没有选择要提交的商品哦</p>
		</div>

	</form>

	<!--操作页面-->

	<div class="theme-popover-mask"></div>


	<!--引导 -->
	<div class="navCir">
		<li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
		<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
		<li class="active"><a href="shopcart.html"><i
				class="am-icon-shopping-basket"></i>购物车</a></li>
		<li><a href="person/index.html"><i class="am-icon-user"></i>我的</a></li>
	</div>
</body>
<script type="text/javascript">
   //付钱
   function goPay(orderId){
    //由于付钱的页面还没写，所以用户点击付款就作为付款成功来执行
    window.location.href="${pageContext.request.contextPath}/pay/hasPay?orderId="+orderId;
   return false;
   }

 </script>

<script type="text/javascript">
		 $(".orderItem").mouseenter(function(){
			 //换个背景图
			  /*  没被选中的才变色 */
			 $(this).css("background-color","rgb(241, 259, 194)");
			 $(this).css("border","1px solid rgb(255, 206, 228)");
			 		 
		});
		$(".orderItem").mouseleave(function(){
		    /*  没被选中的才变色 */
			$(this).css("background-color","white");
			$(this).css("border","1px solid rgb(287, 236, 120)");
		
		});
 </script>
</html>