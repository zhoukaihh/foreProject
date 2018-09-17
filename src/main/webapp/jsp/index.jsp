<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<title>首页</title>

	<link
		href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css"
		rel="stylesheet" type="text/css" />
	<link
		href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/admin.css"
		rel="stylesheet" type="text/css" />

	<link href="${pageContext.request.contextPath}/basic/css/demo.css"
		rel="stylesheet" type="text/css" />

	<link href="${pageContext.request.contextPath}/css/hmstyle.css"
		rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/skin.css"
		rel="stylesheet" type="text/css" />
	<!-- <script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script> -->
	<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
	<script
		src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
</head>
<body>
	<%@include file="head.jsp"%>
	<div class="banner">
		<!--轮播 -->
		<%--<div class="am-slider am-slider-default" data-am-flexslider id="demo-slider-0">
  			<ul class="am-slides">
    			<li><img src="http://s.amazeui.org/media/i/demos/bing-1.jpg" /></li>
    			<li><img src="http://s.amazeui.org/media/i/demos/bing-2.jpg" /></li>
  			</ul>
		</div>--%>
		<div class="am-slider am-slider-default scoll" data-am-flexslider
			id="demo-slider-0">
			<ul class="am-slides">
				<c:forEach items="${ads}" var="ad">
					<li class="banner1"><a href="introduction.html"> <img
							style="height: 100%; width: 800px"
							src="${pageContext.request.contextPath}/shoppingImages/${ad.imgPath}" />
					</a></li>
				</c:forEach>
				 <li class="banner1"><a href="introduction.html"><img src="${pageContext.request.contextPath}/images/ad1.jpg" /></a></li>
								<li class="banner2"><a><img src="${pageContext.request.contextPath}/images/ad2.jpg" /></a></li>
								<li class="banner3"><a><img src="${pageContext.request.contextPath}/images/ad3.jpg" /></a></li>
								<li class="banner4"><a><img src="${pageContext.request.contextPath}/images/ad4.jpg" /></a></li>
			</ul>
		</div>
		
		
		<div class="clear"></div>
	</div>
	

	<div class="shopNav">
		<div class="slideall">

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

			<!--侧边导航 -->
			<div id="nav" class="navfull">
				<div class="area clearfix">
					<div class="category-content" id="guide_2">
						<c:forEach items="${firstTypes}" var="goodFirstType">

							<div class="category">
								<ul class="category-list" id="js_climit_li">
									<li class="appliance js_toggle relative first">
										<div class="category-info">
											<h3 class="category-name b-category-name">
												<i><img
													src="${pageContext.request.contextPath}/images/send.png"></i><a
													class="ml-22" title="点心">${goodFirstType.firstTypeName}</a>
											</h3>
											<em>&gt;</em>
										</div>
										<div class="menu-item menu-in top">
											<div class="area-in">
												<div class="area-bg">
													<div class="menu-srot">
														<div class="sort-side">
															<c:forEach items="${goodFirstType.secondTypes}"
																var="goodSecondType">
																<dl class="dl-sort">
																	<dt>
																		<span title="${goodSecondType.secondTypeName}">${goodSecondType.secondTypeName}</span>
																	</dt>
																	<c:forEach items="${goodSecondType.wares}" var="good">

																		<dd>
																			<a title="${good.goodName}"
																				href="GoodsInfoServlet?action=getGoodsInfobyId&idStr=${info.id}"><span>${good.goodName}</span></a>
																		</dd>

																	</c:forEach>
																</dl>
															</c:forEach>
														</div>

													</div>
												</div>
											</div>
										</div> <b class="arrow"></b>
									</li>

								</ul>
							</div>

						</c:forEach>
					</div>

				</div>
			</div>


			<!--轮播-->

			<%--<script>
  			$(function() {
   			var $slider = $('#demo-slider-0');
   			var counter = 0;
    		var getSlide = function() {
      		counter++;
      		return '<li><img src="http://s.amazeui.org/media/i/demos/bing-' +
        		(Math.floor(Math.random() * 4) + 1) + '.jpg" />' +
        		'<div class="am-slider-desc">动态插入的 slide ' + counter + '</div></li>';
    		};
  			});
			</script>--%>
			
			<script type="text/javascript">
				(function() {
					$('.am-slider').flexslider();
				});
				$(document)
						.ready(
								function() {
									$("li")
											.hover(
													function() {
														$(
																".category-content .category-list li.first .menu-in")
																.css("display",
																		"none");
														$(
																".category-content .category-list li.first")
																.removeClass(
																		"hover");
														$(this).addClass(
																"hover");
														$(this)
																.children(
																		"div.menu-in")
																.css("display",
																		"block")
													},
													function() {
														$(this).removeClass(
																"hover")
														$(this).children(
																"div.menu-in")
																.css("display",
																		"none")
													});
								})
			</script>



			<!--小导航 -->
			<div class="am-g am-g-fixed smallnav">
				<div class="am-u-sm-3">
					<a href="sort.html"><img
						src="${pageContext.request.contextPath}/images/navsmall.jpg" />
						<div class="title">商品分类</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img
						src="${pageContext.request.contextPath}/images/huismall.jpg" />
						<div class="title">大聚惠</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img
						src="${pageContext.request.contextPath}/images/mansmall.jpg" />
						<div class="title">个人中心</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img
						src="${pageContext.request.contextPath}/images/moneysmall.jpg" />
						<div class="title">投资理财</div> </a>
				</div>
			</div>

			<!--走马灯 -->

			<div class="marqueen">
				<span class="marqueen-title">商城头条</span>
				<div class="demo">

					<ul>
						<li class="title-first"><a target="_blank" href="#"> <img
								src="${pageContext.request.contextPath}/images/TJ2.jpg"></img> <span>[特惠]</span>商城爆品1分秒
						</a></li>
						<li class="title-first"><a target="_blank" href="#"> <span>[公告]</span>商城与广州市签署战略合作协议
								<img src="${pageContext.request.contextPath}/images/TJ.jpg"></img>
								<p>XXXXXXXXXXXXXXXXXX</p>
						</a></li>

						<div class="mod-vip">
							<div class="m-baseinfo">
								<a href="person/index.html"> <img
									src="${pageContext.request.contextPath}/images/getAvatar.do.jpg"></a>
								<em> Hi,<span class="s-name">小叮当</span> <a href="#"><p>点击更多优惠活动</p></a>
								</em>
							</div>
							<div class="member-logout">
								<a class="am-btn-warning btn" href="login.html">登录</a> <a
									class="am-btn-warning btn" href="register.html">注册</a>
							</div>
							<div class="member-login">
								<a href="#"><strong>0</strong>待收货</a> <a href="#"><strong>0</strong>待发货</a>
								<a href="#"><strong>0</strong>待付款</a> <a href="#"><strong>0</strong>待评价</a>
							</div>
							<div class="clear"></div>
						</div>

						<li><a target="_blank" href="#"><span>[特惠]</span>洋河年末大促，低至两件五折</a></li>
						<li><a target="_blank" href="#"><span>[公告]</span>华北、华中部分地区配送延迟</a></li>
						<li><a target="_blank" href="#"><span>[特惠]</span>家电狂欢千亿礼券
								买1送1！</a></li>

					</ul>
					<div class="advTip">
						<img src="${pageContext.request.contextPath}/images/advTip.jpg" />
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<script type="text/javascript">
			if ($(window).width() < 640) {
				function autoScroll(obj) {
					$(obj).find("ul").animate({
						marginTop : "-39px"
					}, 500, function() {
						$(this).css({
							marginTop : "0px"
						}).find("li:first").appendTo(this);
					})
				}
				$(function() {
					setInterval('autoScroll(".demo")', 3000);
				})
			}
		</script>
	</div>
	<div class="shopMainbg">
		<div class="shopMain" id="shopmain">

			<!--今日推荐 -->

			<div class="am-g am-g-fixed recommendation">
				<div class="clock am-u-sm-3"">
					<img src="${pageContext.request.contextPath}/images/2016.png "></img>
					<p>
						今日<br>推荐 
					</p>
				</div>

				<div class="am-u-sm-4 am-u-lg-3 ">
					<div class="info ">
						<h3></h3>
						<h4></h4>
					</div>
					<div class="recommendationMain one">
						<a href="#"><img
							src="${pageContext.request.contextPath}/images/"></img></a>
					</div>
				</div>
			</div>
			<div class="clear "></div>
			<!--热门活动 -->

			<div class="am-container activity ">
				<div class="shopTitle ">
					<h4>活动</h4>
					<h3>每期活动 优惠享不停</h3>
					<span class="more "> <a href="# ">全部活动<i
							class="am-icon-angle-right" style="padding-left: 10px;"></i></a>
					</span>
				</div>
				<div class="am-g am-g-fixed ">

					<c:forEach items="${activities}" var="activity">
						<div class="am-u-sm-3 ">
							<div class="icon-sale one "></div>
							<h4>${activity.acDes}</h4>
							<div class="activityMain ">
								<img
									src="${pageContext.request.contextPath}/images/${activity.acShowPhoto}"></img>
							</div>
							<div class="info ">
								<h3>春节送礼优选</h3>
							</div>
						</div>
					</c:forEach>

					<%-- 		
						<div class="am-u-sm-3 ">
						  <div class="icon-sale two "></div>	
							<h4>特惠</h4>
							<div class="activityMain ">
								<img src="${pageContext.request.contextPath}/images/activity2.jpg "></img>
							</div>
							<div class="info ">
								<h3>春节送礼优选</h3>								
							</div>							
						</div>						
						
						<div class="am-u-sm-3 ">
							<div class="icon-sale three "></div>
							<h4>团购</h4>
							<div class="activityMain ">
								<img src="${pageContext.request.contextPath}/images/activity3.jpg "></img>
							</div>
							<div class="info ">
								<h3>春节送礼优选</h3>
							</div>							
						</div>						

						<div class="am-u-sm-3 last ">
							<div class="icon-sale "></div>
							<h4>超值</h4>
							<div class="activityMain ">
								<img src="${pageContext.request.contextPath}/images/activity.jpg "></img>
							</div>
							<div class="info ">
								<h3>春节送礼优选</h3>
							</div>													
						</div> --%>

				</div>
			</div>
			<div class="clear "></div>


			<script type="text/javascript">
			
			
				//实时更新一级分类页面的ajax
				function loadData(pageNo,gfId) {
					//获取对象
					//alert("pageNo:"+pageNo+"---"+"gfId:"+gfId);
					 var xmlhttp = getXMLHttpRequest();
					xmlhttp.onreadystatechange = function() {
						if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
							var text = xmlhttp.responseText;
						    var jsonObject = JSON.parse(text);
						    var str = "";
							for (var j = 0; j < jsonObject.goods.length; j++) {
								var good = jsonObject.goods[j];
								str = str+ "<div class='am-u-sm-7 am-u-md-4 text-two' onclick='showGood("+good.gId+")'>";
								str = str+ "<div class='outer-con '>";
								str = str+ "<div class='title '>"+ good.gName+ "</div>";
								str = str+ "<div class='sub-title '>"+ good.gDes+ "</div>";
								str = str+ "<i class='am-icon-shopping-basket am-icon-md  seprate'></i>";
								str = str+ "</div>";
								str = str+ "<img src='${pageContext.request.contextPath}/images/"+good.gPhoto+"' style='width: 160px; height: 160px' />";
								if(good.gNum<1){
									str = str+ "<div style='opacity: 0.1;background-size: 100% 100%;background-image:url(${pageContext.request.contextPath}/images/saleout.png); width:240px;height:240px;position:relative;top:-1px;left:-1px;'> </div>";
								}
								str = str+"</div>";
							}
							$('#goods'+gfId).html(str);
							
							
							var pagestr = "<div style='position: relative; top: 520px; left: 900px;'>";
							pagestr = pagestr
									+ "<div style='height: 20px; width: 300px;'>";

							if (!(jsonObject.nowPage == 1)) {
								pagestr = pagestr
										+ "<a href='#' onclick='return loadData(1,"+jsonObject.gfId+");' style='text-decoration: none'>首页</a>&nbsp;&nbsp;";
							}

							if (jsonObject.nowPage > 1) {
								pagestr = pagestr
										+ "<a href='#' onclick='return loadData("+(jsonObject.nowPage-1)+","+jsonObject.gfId+");' style='text-decoration: none'>上一页</a>&nbsp;&nbsp;";
							}
							if (jsonObject.nowPage < jsonObject.allPage) {
								pagestr = pagestr
										+ "<a href='#' onclick='return loadData("+(jsonObject.nowPage+1)+","+jsonObject.gfId+");' style='text-decoration: none'>下一页</a>&nbsp;&nbsp;";
							}

							if (jsonObject.allPage == 1) {
								pagestr = pagestr
										+ " <a href='#' style='text-decoration: none'>仅此一页</a>";
							}

							if (jsonObject.allPage == 0) {
								pagestr = pagestr
										+ " <a href='#' style='text-decoration: none'>暂无商品上架</a>";
							}

							if (!(jsonObject.nowPage == jsonObject.allPage)
									&& !(jsonObject.allPage == 0)) {
								pagestr = pagestr
										+ " <a href='#' onclick='return loadData("+(jsonObject.allPage)+","+jsonObject.gfId+");' style='text-decoration: none'>尾页</a>";
							}
							if(!(jsonObject.allPage==0)){
								pagestr = pagestr+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style='width:80px; height:20px;'>第"+jsonObject.nowPage+"页&nbsp;&nbsp;|&nbsp;&nbsp;共"+jsonObject.allPage+"页</span></div></div>";
							}

							$('#page'+gfId).html(pagestr);

					     }
					}
					var url = "${pageContext.request.contextPath}/showGoods/findFirstTypeGoodsOnePageBygfId.action?pageNo="+pageNo+"&gfId="+gfId;
					xmlhttp.open("get", url);
					xmlhttp.send();
					return false;
				}

				
				
				
				//写个ajax，得到指定一级分类的指定页的商品，重写指定类的div中的商品数据

				$(document).ready(function() {$.get("${pageContext.request.contextPath}/showGoods/findEveryFirstTypeGoodsOnePage.action",
													function(data, status) {
														if (status == 'success') {
															//alert(data);
															//jsonArray = eval("("+data+")");
															var jsonArray = JSON.parse(data.trim());
															for (var i = 0; i < jsonArray.length; i++) {
																//一次循环表示一类商品
																var str = "";
																for (var j = 0; j < jsonArray[i].goods.length; j++) {
																	var good = jsonArray[i].goods[j];
																	str = str+ "<div class='am-u-sm-7 am-u-md-4 text-two' onclick='showGood("+good.gId+")'>";
																	str = str+ "<div class='outer-con '>";
																	str = str+ "<div class='title '>"+ good.gName+ "</div>";
																	str = str+ "<div class='sub-title '>"+ good.gDes+ "</div>";
																	str = str+ "<i class='am-icon-shopping-basket am-icon-md  seprate'></i>";
																	str = str+ "</div>";
																	str = str+ "<img src='${pageContext.request.contextPath}/images/"+good.gPhoto+"' style='width: 160px; height: 160px' />";
																	if(good.gNum<1){
																		str = str+ "<div style='opacity: 0.1;background-size: 100% 100%;background-image:url(${pageContext.request.contextPath}/images/saleout.png); width:240px;height:240px;position:relative;top:-1px;left:-1px;'> </div>";
																	}
																	str = str+"</div>";
																}
																$('#goods'+ jsonArray[i].gfId).html(str);
																var pagestr = "<div style='position: relative; top: 520px; left: 900px;'>";
																pagestr = pagestr
																		+ "<div style='height: 20px; width: 300px;'>";

																if (!(jsonArray[i].nowPage == 1)) {
																	pagestr = pagestr
																			+ "<a href='#' onclick='return loadData(1,"+jsonArray[i].gfId+");' style='text-decoration: none'>首页</a>&nbsp;&nbsp;";
																}

																if (jsonArray[i].nowPage > 1) {
																	pagestr = pagestr
																			+ "<a href='#' onclick='return loadData("+(jsonArray[i].nowPage-1)+","+jsonArray[i].gfId+");' style='text-decoration: none'>上一页</a>&nbsp;&nbsp;";
																}
																if (jsonArray[i].nowPage < jsonArray[i].allPage) {
																	pagestr = pagestr
																			+ "<a href='#' onclick='return loadData("+(jsonArray[i].nowPage+1)+","+jsonArray[i].gfId+");' style='text-decoration: none'>下一页</a>&nbsp;&nbsp;";
																}

																if (jsonArray[i].allPage == 1) {
																	pagestr = pagestr
																			+ " <a href='#' style='text-decoration: none'>仅此一页</a>";
																}

																if (jsonArray[i].allPage == 0) {
																	pagestr = pagestr
																			+ " <a href='#' style='text-decoration: none'>暂无商品上架</a>";
																}

																if (!(jsonArray[i].nowPage == jsonArray[i].allPage)
																		&& !(jsonArray[i].allPage == 0)) {
																	pagestr = pagestr
																			+ " <a href='#' onclick='return loadData("+(jsonArray[i].allPage)+","+jsonArray[i].gfId+");' style='text-decoration: none'>尾页</a>";
																}
																if(!(jsonArray[i].allPage==0)){
																	pagestr = pagestr+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style='width:80px; height:20px;'>第"+jsonArray[i].nowPage+"页&nbsp;&nbsp;|&nbsp;&nbsp;共"+jsonArray[i].allPage+"页</span></div></div>";
																}
																

																$('#page'+ jsonArray[i].gfId).html(pagestr);

															}

															//alert("结束了");
														}

													});
								});
				
				
				function showGood(gId){
					 window.location.href="${pageContext.request.contextPath}/goods/showGoodById.action?gId="+gId;
				}
			</script>


			<c:forEach items="${goodFirstTypes}" var="goodFirstType">

				<div id="f1">
					<!--甜点-->

					<div class="am-container " id="firstType${goodFirstType.gfId}">
						<div class="shopTitle ">
							<h4>${goodFirstType.gfName}</h4>
							<div class="today-brands ">
								<a href="# "></a>
							</div>
							<span class="more "> <a href="# ">更多美味<i
									class="am-icon-angle-right" style="padding-left: 10px;"></i></a>
							</span>
						</div>


						<div id="page${goodFirstType.gfId}"></div>



						<%-- <div style="position: relative; top: 520px; left: 900px;">
							<div style="height: 20px; width: 160px;">
								<a
									href="${pageContext.request.contextPath}/goods/findGoodsByPage.action?pageNo=1"
									style="text-decoration: none">首页</a>
								<c:if test="${currentpage>1}">
									<a
										href="${pageContext.request.contextPath}/goods/findGoodsByPage.action?pageNo=${currentpage-1}"
										style="text-decoration: none">上一页</a>
								</c:if>

								<c:if test="${currentpage < allPage}">
									<a
										href="${pageContext.request.contextPath}/goods/findGoodsByPage.action?pageNo=${currentpage+1}"
										style="text-decoration: none">下一页</a>
								</c:if>


								<a
									href="${pageContext.request.contextPath}/goods/findGoodsByPage.action?pageNo=${allPage}"
									style="text-decoration: none">尾页</a>
							</div>
						</div> --%>
					</div>

					<div class="am-g am-g-fixed floodFour">
						<div class="am-u-sm-5 am-u-md-4 text-one list ">
							<div class="word">
								<a class="outer" href="#"><span class="inner"><b
										class="text">核桃</b></span></a> <a class="outer" href="#"><span
									class="inner"><b class="text">核桃</b></span></a> <a class="outer"
									href="#"><span class="inner"><b class="text">核桃</b></span></a>
								<a class="outer" href="#"><span class="inner"><b
										class="text">核桃</b></span></a> <a class="outer" href="#"><span
									class="inner"><b class="text">核桃</b></span></a> <a class="outer"
									href="#"><span class="inner"><b class="text">核桃</b></span></a>
							</div>
							<a href="# ">
								<div class="outer-con ">
									<div class="title ">开抢啦！</div>
									<div class="sub-title ">零食大礼包</div>
								</div> <img src="${pageContext.request.contextPath}/images/act1.png " />
							</a>
							<div class="triangle-topright"></div>
						</div>

						<c:forEach items="${goodFirstType.goodSecondTypes}"
							var="goodSecondType">

							<%-- 	<div class="am-u-sm-7 am-u-md-4 text-two">
									<div class="outer-con ">
										<div class="title ">${good.gName}</div>
										<div class="sub-title ">${good.gDes}</div>
										<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
									</div>
									<a href="GoodsInfoServlet?method=queryById&id=${good.gId}"><img
										src="${pageContext.request.contextPath}/images/${good.gPhoto}"
										style="width: 160px; height: 160px" /></a>
								</div> --%>

							<div id="goods${goodFirstType.gfId}"></div>


						</c:forEach>
					</div>

					<br /> <br /> <br /> <br />
			</c:forEach>



			<div class="clear "></div>
		</div>
		<div class="footer ">
			<div class="footer-hd ">
				<p>
					<a href="# ">恒望科技</a> <b>|</b> <a href="# ">商城首页</a> <b>|</b> <a
						href="# ">支付宝</a> <b>|</b> <a href="# ">物流</a>
				</p>
			</div>
			<div class="footer-bd ">
				<p>
					<a href="# ">关于恒望</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a> <a
						href="# ">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有</em>
				</p>
			</div>
		</div>

	</div>
	</div>
	<!--引导 -->
	<div class="navCir">
		<li class="active"><a href="home.html"><i
				class="am-icon-home "></i>首页</a></li>
		<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
		<li><a
			href="${pageContext.request.contextPath}/shopcar/showCar.action"><i
				class="am-icon-shopping-basket"></i>购物车</a></li>
		<li><a href="person/index.html"><i class="am-icon-user"></i>我的</a></li>
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
							<a
								href="${pageContext.request.contextPath}/orders/findUserOrdersAll.action"
								class="login_order ">我的订单</a> <a href="# "
								class="login_favorite ">我的收藏</a>
						</div>
						<i class="icon_arrow_white "></i>
					</div>

				</div>
				<div id="shopCart " class="item ">
					<a href="${pageContext.request.contextPath}/shopcar/showCar.action">
						<span class="message "></span>
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
	<script>
		window.jQuery
				|| document
						.write('<script src="basic/js/jquery.min.js "><\/script>');
	</script>
	<script type="text/javascript "
		src="${pageContext.request.contextPath}/basic/js/quick_links.js "></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/my.js"></script>
</body>

</html>