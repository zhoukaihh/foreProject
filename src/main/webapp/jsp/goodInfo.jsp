<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>商品页面</title>

<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/basic/css/demo.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="${pageContext.request.contextPath}/css/optstyle.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />

<script type="text/javascript" src="${pageContext.request.contextPath}/basic/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/basic/js/quick_links.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.imagezoom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/list.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>

</head>

<body>


	<!--顶部导航条 -->
	<jsp:include page="head.jsp"></jsp:include>

	<div class="clear"></div>
	<b class="line"></b>
	<div class="listMain">

		<!--分类-->
		<div class="nav-table">
			<div class="long-title">
				<span class="all-goods">全部分类</span>
			</div>
			<div class="nav-cont">
				<ul>
					<li class="index"><a href="#">首页</a></li>
					<li class="qc"><a href="#">闪购</a></li>
					<li class="qc"><a href="#">限时抢</a></li>
					<li class="qc"><a href="#">团购</a></li>
					<li class="qc last"><a href="#">大包装</a></li>
				</ul>
				<div class="nav-extra">
					<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
					<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
				</div>
			</div>
		</div>
		<ol class="am-breadcrumb am-breadcrumb-slash">
			<li><a href="#">首页</a></li>
			<li><a href="#">分类</a></li>
			<li class="am-active">内容</li>
		</ol>
		<!-- <script type="text/javascript">
					$(function() {});
					$(window).load(function() {
						$('.flexslider').flexslider({
							animation: "slide",
							start: function(slider) {
								$('body').removeClass('loading');
							}
						});
					});
				</script> -->

		<!--放大镜-->

		<div class="item-inform">
			<div class="clearfixLeft" id="clearcontent">

				<div class="box">
					<!-- <script type="text/javascript">
								$(document).ready(function() {
									$(".jqzoom").imagezoom();
									$("#thumblist li a").click(function() {
										$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
										$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
										$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
									});
								});
							</script> -->

					<div class="tb-booth tb-pic tb-s310">
						<a href="#"><img src="${pageContext.request.contextPath}/shoppingImages/${good.goodImage}"
							style="width: 350px; height: 350px" alt="细节展示放大镜特效" rel=""
							class="jqzoom" /></a>
					</div>

				</div>

				<div class="clear"></div>
			</div>

			<div class="clearfixRight">

				<!--规格属性-->
				
				<div class="tb-detail-hd">
					<h1>${good.goodName}</h1><!--名称-->
				</div>
				<div class="tb-detail-list">
					<!--价格-->
					<div class="tb-detail-price">
					
						<li class="price iteminfo_price">
							<dt>促销价</dt>
							<dd>
								<em>¥</em><b class="sys_item_price">${good.goodDiscountPrice}</b>
							</dd>
						</li>
						<li class="price iteminfo_mktprice">
							<dt>原价</dt>
							<dd>
								<em>¥</em><b class="sys_item_mktprice">${good.goodPrice}</b>
							</dd>
						</li>
						<div class="clear"></div>
					</div>


					<!--销量-->
					<ul class="tm-ind-panel">
						<li class="tm-ind-item tm-ind-sellCount canClick">
							<div class="tm-indcon">
								<span class="tm-label">月销量</span><span class="tm-count">${good.gms}</span>
							</div>
						</li>
						<li class="tm-ind-item tm-ind-sumCount canClick">
							<div class="tm-indcon">
								<span class="tm-label">累计销量</span><span class="tm-count">${good.gams}</span>
							</div>
						</li>
						<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
							<div class="tm-indcon">
								<span class="tm-label">累计评价</span><span class="tm-count">这里是累计评价</span>
							</div>
						</li>
					</ul>
					<div class="clear"></div>

					<!--各种规格-->
					<dl class="iteminfo_parameter sys_item_specpara">
						<dt class="theme-login">
							<div class="cart-title">
								可选规格<span class="am-icon-angle-right"></span>
							</div>
						</dt>
						<dd>
							<!--操作页面-->

							<div class="theme-popover-mask"></div>

							<div class="theme-popover">
								<div class="theme-span"></div>
								<div class="theme-poptit">
									<a href="javascript:;" title="关闭" class="close">×</a>
								</div>
								<div class="theme-popbod dform">
									<form class="theme-signin" action="" method="post">

										<div class="theme-signin-left">


											<div class="theme-options">
												<div class="cart-title number">数量</div>
												<dd>
													<input id="min"  class="am-btn am-btn-default" name="" type="button" value="-" />
													
													
													
													
													
													<!-- 如果该商品已经没货了，数量框应该写为0，而且不可修改 -->
													 <c:if test="${(good.goodNums<1)}">
													     <input readonly="readonly" id="value" name="pic" type="text" value="0" style="width: 30px;" />
													 </c:if>
													 <c:if test="${(good.goodNums>0)}">
													     <input id="value" name="pic" type="text" value="1" style="width: 30px;" />
													 </c:if>
													<input id="add"  class="am-btn am-btn-default" name="" type="button" value="+" /> 
													<span id="Stock" class="tb-hidden">库存
													<c:if test="${(good.goodNums<1)}">
													    <span class="stock" id="stock">${(good.goodNums)}</span>件
													 </c:if>
													 <c:if test="${(good.goodNums>0)}">
													    <span class="stock" id="stock">${(good.goodNums-1)}</span>件
													 </c:if>
													
													</span><span id="nomore" style="color:red; width: 30px;height: 10px;"></span>
												</dd>

											</div>
											<div class="clear"></div>

											<div class="btn-op">
												<div class="btn am-btn am-btn-warning">确认</div>
												<div class="btn close am-btn am-btn-warning">取消</div>
											</div>
										</div>
										<div class="theme-signin-right">
											<div class="img-info">
												<img src="${pageContext.request.contextPath}/images/songzi.jpg" />
											</div>
											<div class="text-info">
												<span class="J_Price price-now">¥${good.goodDiscountPrice}</span> <span
													id="Stock" class="tb-hidden">库存<span class="stock">${good.goodNums}</span>件
												</span>
											</div>
											
										</div>

									</form>
								</div>
							</div>

						</dd>
					</dl>
					<div class="clear"></div>
					<!--活动	-->
					<div class="shopPromotion gold">
						<div class="hot">
							<dt class="tb-metatit">店铺优惠</dt>
							<div class="gold-list">
								<p>
									购物满2件打8折，满3件7折</span>
								</p>
							</div>
						</div>
						<div class="clear"></div>
						<div class="coupon">
							<dt class="tb-metatit">优惠券</dt>
							<div class="gold-list">
								<ul>
									<li>125减5</li>
									<li>198减10</li>
									<li>298减20</li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="pay">
					<div class="pay-opt">
						<a href="home.html"><span class="am-icon-home am-icon-fw">首页</span></a>
						<a><span class="am-icon-heart am-icon-fw">收藏</span></a>

					</div>
					<li>
						<div class="clearfix tb-btn tb-btn-buy theme-login">
							<a id="buy" title="点此按钮到下一步确认购买信息" >立即购买</a>
						</div>
					</li>
					<li>
						<div class="clearfix tb-btn tb-btn-basket theme-login">
							<a id="LikBasket" title="加入购物车"><i></i>加入购物车</a>
						</div>
					</li>
				</div>

			</div>

			<div class="clear"></div>

		</div>


		<div class="footer">
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

	</div>
	</div>
	<!--菜单 -->
	<div class=tip>
		<div id="sidebar">
			<div id="wrap">
				<div id="prof" class="item ">
					<a href="# "> <span class="setting "></span>
					</a>
					<div class="ibar_login_box status_login ">
						<div class="avatar_box ">
							<p class="avatar_imgbox ">
								<img
									src="${pageContext.request.contextPath}/images/yuezicopy.jpg" />
							</p>
							<ul class="user_info ">
								<li>用户名:${realuser.loginName}</li>
								<li>级&nbsp;别:${loginType}</li>
							</ul>
						</div>
						<div class="login_btnbox ">
							<a href="# " class="login_order ">我的订单</a> <a href="# "
								class="login_favorite ">我的收藏</a>
						</div>
						<i class="icon_arrow_white "></i>
					</div>

				</div>
				<div id="shopCart " class="item ">
					<a href="${pageContext.request.contextPath}/shopcar/showCar.action"> <span class="message "></span>
					</a>
					<p>购物车</p>
					<p class="cart_num ">${carsize}</p>
				</div>
				<div id="asset " class="item ">
					<a href="# "> <span class="view "></span>
					</a>
					<div class="mp_tooltip ">
						我的资产 <i class="icon_arrow_right_black "></i>
					</div>
				</div>

				<div id="foot " class="item ">
					<a href="# "> <span class="zuji "></span>
					</a>
					<div class="mp_tooltip ">
						我的足迹 <i class="icon_arrow_right_black "></i>
					</div>
				</div>

				<div id="brand " class="item ">
					<a href="#"> <span class="wdsc "><img
							src="${pageContext.request.contextPath}/images/wdsc.png " /></span>
					</a>
					<div class="mp_tooltip ">
						我的收藏 <i class="icon_arrow_right_black "></i>
					</div>
				</div>

				<div id="broadcast " class="item ">
					<a href="# "> <span class="chongzhi "><img
							src="${pageContext.request.contextPath}/images/chongzhi.png " /></span>
					</a>
					<div class="mp_tooltip ">
						我要充值 <i class="icon_arrow_right_black "></i>
					</div>
				</div>

				<div class="quick_toggle ">
					<li class="qtitem "><a href="# "><span class="kfzx "></span></a>
						<div class="mp_tooltip ">
							客服中心<i class="icon_arrow_right_black "></i>
						</div></li>
					<!--二维码 -->
					<li class="qtitem "><a href="#none "><span
							class="mpbtn_qrcode "></span></a>
						<div class="mp_qrcode " style="display: none;">
							<img
								src="${pageContext.request.contextPath}/images/weixin_code_145.png " /><i
								class="icon_arrow_white "></i>
						</div></li>
					<li class="qtitem "><a href="#top " class="return_top "><span
							class="top "></span></a></li>
				</div>

				<!--回到顶部 -->
				<div id="quick_links_pop " class="quick_links_pop hide "></div>

			</div>

		</div>
		<div id="prof-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>我</div>
		</div>
		<div id="shopCart-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>购物车</div>
		</div>
		<div id="asset-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>资产</div>

			<div class="ia-head-list ">
				<a href="# " target="_blank " class="pl ">
					<div class="num ">0</div>
					<div class="text ">优惠券</div>
				</a> <a href="# " target="_blank " class="pl ">
					<div class="num ">0</div>
					<div class="text ">红包</div>
				</a> <a href="# " target="_blank " class="pl money ">
					<div class="num ">￥0</div>
					<div class="text ">余额</div>
				</a>
			</div>

		</div>
		<div id="foot-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>足迹</div>
		</div>
		<div id="brand-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>收藏</div>
		</div>
		<div id="broadcast-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>充值</div>
		</div>
	</div>
<!-- 我自己的javascript -->
<script type="text/javascript">
    $("#addgood1").click(function(){
    	alert("我进来了");
    });

</script>
<script type="text/javascript">
	
	    $("#value").change(function(){
	    	var value = $("#value").val();
	    	var goodNums = ${good.goodNums};
	    	var before = $("#stock").text();
	    //	alert("value:"+value+"--goodNums:"+goodNums);
			if(value <= goodNums){
				$("#stock").text(goodNums-value);
				$("#nomore").text("");
			}else{
				$("#value").val(goodNums-before);
				$("#nomore").text("没有更多的了啊喂！");
				
			}
			if(value<1){
				$("#nomore").text("好歹还是买点呀喂！");
				$("#value").val(goodNums-before);
			}	
	    })
	
	 	//减少商品数量
		$("#min").click(function() {
			var value = $("#value").val();
			 var stock = $("#stock").text();
			if(value > 1){
				$("#value").val(parseInt(value)-1);
				$("#stock").text(parseInt(stock)+1);
				$("#nomore").text("");
			}else{
				$("#nomore").text("好歹还是买点呀喂！");
			}
		});
		//添加商品数量
		$("#add").click(function() {
			 var value = $("#value").val();
			 var stock = $("#stock").text();
			
			 
			var goodNums = ${good.goodNums};
			if(value < goodNums){
				$("#value").val(parseInt(value)+1);
				$("#stock").text(parseInt(stock)-1);
				$("#nomore").text("");
			}else{
				$("#nomore").text("没这么多货了，老铁");
			}
		
		});
		//加入购物车功能
		$("#LikBasket").click(function() {
			//如果是没有商品可以添加，将加入购物车和立即购买变灰
			var value = Number($('#value').val());
			var goodNums = Number($('#stock').text());
			if((value+goodNums) == 0){
				//表示该商品已经没货了
				
			}else{
				window.location.href = "${pageContext.request.contextPath}/shopcar/add?goodId="+${good.goodId}+"&count="+$('#value').val();	
			}
			
			
			
		});
		//立即购买
		$("#buy").click(function(){
			//window.location = "ShopServlet?action=buynow&goodsInfoIdStr="+${goodsInfo.id}+"&countStr="+$('#value').val()+"&key="+${key};
		}); 
		
	    $(document).ready(function(){
	    	var value = Number($('#value').val());
			var goodNums = Number($('#stock').text());
			if((value+goodNums) == 0){
				//表示该商品已经没货了，改变两个按钮的颜色
				$("#LikBasket").css("background-color","#bfbfbf");
				$("#buy").css("background-color","#bfbfbf");
				$("#buy").css("border-color","#bfbfbf");
				$("#LikBasket").css("border-color","#bfbfbf");
				$("#buy").css("color","white");
			}
	    });
	
</script>

</html>