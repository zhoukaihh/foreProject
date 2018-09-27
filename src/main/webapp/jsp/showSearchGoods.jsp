<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>查询结果界面</title>
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


<link rel="stylesheet" href="${pageContext.request.contextPath}/mycss/showSearch.css" type="text/css"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/basic/js/jquery-1.7.min.js"></script>

</head>

<body>

<!-- 页面中最大的div -->
<div class="page">


    <div id="titlefather">
  	            <ul style="position: relative;top:-2px;right:97px;" class="message-r">
					<div class="topMessage home">
						<div class="menu-hd"><a class="font" href="${pageContext.request.contextPath}/shopcar/goToMain" target="_top" class="h">商城首页</a></div>
					</div>
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng"><a class="font" href="" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>&nbsp;&nbsp;&nbsp;<a class="font" href="${pageContext.request.contextPath}/orders/findUserOrdersAll.action">我的订单</a></div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd"><a id="mc-menu-hd" href="${pageContext.request.contextPath}/shopcar/showCar.action" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span class="font">购物车</span><strong id="J_MiniCartNum" class="h"><span style="color: red;" id="nowCarSize">${carsize}<span/></strong></a></div>
					</div>
						<div class="topMessage my-shangcheng">
						<div class="menu-hd"><span ><a class="font" href="${pageContext.request.contextPath}/go/goawaybefore.action">注销帐户</a></span></div>
				</ul>
  	</div>
    <div id="headSearchFather">
         <div style="" id="headSearch">
           <div id="search">
             
              <!-- 这里是搜索参数传值的form表单 -->
             <form id=”searchForm” action="${pageContext.request.contextPath}/goods/searchGoods">
                  <input id="pageNo" type="hidden" name="pageNo" value="1">
                  <input id="searchInfo" name="searchInfo" value="${searchInfo}"/>
                  <input id="searchSubmit" type="submit" value="搜索"/>
             </form>
           </div>
           <!-- 搜索前的logo -->
           <div id="searchBeforeLogo">DDOGGIE 地狗</div>
 
          </div>
    </div>
    <HR style="align=center; width=300; color=#987cb9; SIZE=1;" >
    <!-- <div id="sthOthers">
        其它的一些东西
    </div> -->
    
    <!-- 这里是包含所有商品显示框的父亲 -->
    <div id="showGoodFather" style="height: ${row*366}px">
       
    <!--    一个商品，到时候用foreach -->
       <!-- 商品的外边框 -->
        
          <c:forEach items="${documentList}" var="document">
                 <div class="goodBorder">
		               <div class="oneGood">
		          <%--   <a class="goodPicture"><div class="gPhotoShow" style=" background-image: url('${pageContext.request.contextPath}/images/566.png');background-size: 100% 100%;"><div></a> --%>
		           <a href="#"> <div class="gPhotoShow"><img style="width:203px;height: 212px;" src="${pageContext.request.contextPath}/shoppingImages/${document['goodImage']}" alt="${document['goodName']}" /></div></a>
		          <%-- <a href="#"><img src="${pageContext.request.contextPath}/images/丁/午/17fa2e4c-b144-4c23-a7a9-f8c068bcb6f4_衣服12.jpg" alt="${document["gName"]}" /> </a> --%>
		            <!-- 商品价格 -->
		            <p class="goodPrice"><em><b>￥</b>${document["goodDiscountPrice"]}</em></p>
		            <!-- 商品名字 -->
		            <p class="goodTitle"><a href="${pageContext.request.contextPath}/goods/showGoodById?goodId=${document['goodId']}">${document["goodName"]}</a></p>
		            <div class="goodDes">${document["goodDes"]}</div>
		            <!-- 商品的状态（月销量，总销量，评价） -->
		            <div class="goodSaleInfo"><span>月成交 <em>${document["gms"]}笔</em></span> 
		                                      <span>评价 <a href="#">200</a></span>
		            </div>
		          </div>
		       </div>
          </c:forEach> 
          
          <!-- 这是页码框框 也属于商品展示的模块-->
          <div id="pageDiv">
             <div id="choiceJump">
             
             
             
                 <!-- 普通按钮 -->
                 <b id="pageNum">
                 <!-- 判断上一页是否能点 -->
                       <c:if test="${pageNo<2}">
                             <b class="goPagePrev">上一页</b>
                       </c:if>
                       <c:if test="${pageNo>1}">
                             <a href="${pageContext.request.contextPath}/goods/searchGoods.action?searchInfo=${searchInfo}&pageNo=${(pageNo-1)}" class="goPagePrev">上一页</a>
                       </c:if>      
                     
                    
                    
                 <!--    注意，生成”上一页到中间页的按钮有两种逻辑“ -->
                     <c:if test="${pageNo<7}">
                         <!--  这里就是中间的页数了，逻辑:生成从第一页到当前页的所有按钮（定义一个变量，判断是否等于当前页，每生成一个加一） -->
                           <c:forEach var="nowNum" begin="1" step="1" end="${(pageNo-1)}">
                           <!-- 生成一个该页的a标签 -->
                           <a href="${pageContext.request.contextPath}/goods/searchGoods.action?searchInfo=${searchInfo}&pageNo=${(nowNum)}" class="goPagePrev">${nowNum}</a>
                            </c:forEach>
                     </c:if>
                      
                    <c:if test="${pageNo>=7}">
                        <!--    当当前页数大于7后，就不会在从第一页到当前页一页一页按钮展示，只展示第一二页，后面... 再展示当前页前面两页 -->
                         <a href="${pageContext.request.contextPath}/goods/searchGoods.action?searchInfo=${searchInfo}&pageNo=1" class="goPagePrev">1</a>
                          <a href="${pageContext.request.contextPath}/goods/searchGoods.action?searchInfo=${searchInfo}&pageNo=2" class="goPagePrev">2</a>
                          <span style="float: left;height: 100%;width: 30px;margin-top: 13px;">. . .</span>
                           <a href="${pageContext.request.contextPath}/goods/searchGoods.action?searchInfo=${searchInfo}&pageNo=${(pageNo-2)}" class="goPagePrev">${(pageNo-2)}</a>
                          <a href="${pageContext.request.contextPath}/goods/searchGoods.action?searchInfo=${searchInfo}&pageNo=${(pageNo-1)}" class="goPagePrev">${(pageNo-1)}</a>
                     </c:if>
                    
                    
                    
                   <!--      生成当前页的按钮 -->
                        <b class="nowPage">${pageNo}</b>
                      <!--   生成当前页之后两页的按钮（如果有的话） -->
                      <c:if test="${(pageNo+1)<=allPage}">
                          <a href="${pageContext.request.contextPath}/goods/searchGoods.action?searchInfo=${searchInfo}&pageNo=${(pageNo+1)}" class="goPagePrev">${(pageNo+1)}</a>
                      </c:if>
                      <c:if test="${(pageNo+2)<=allPage}">
                          <a href="${pageContext.request.contextPath}/goods/searchGoods.action?searchInfo=${searchInfo}&pageNo=${(pageNo+2)}" class="goPagePrev">${(pageNo+2)}</a>
                      </c:if>
                      <!-- 如果后面还有，输出”...“ -->
                      <c:if test="${(pageNo+3)<=allPage}">
                          ...
                      </c:if>
                      
                      
                      <c:if test="${pageNo==allPage}">
                            <b class="goPagePrev">下一页>></b>
                      </c:if>
                      <c:if test="${pageNo<allPage}">
                            <a href="${pageContext.request.contextPath}/goods/searchGoods.action?searchInfo=${searchInfo}&pageNo=${(pageNo+1)}" class="goPagePrev">下一页>></a>
                      </c:if>
                  </b>
                 
                 
                 <!--  直接跳转 -->
                 <b id="pageSkip">
                      <form id="goPageForm" style="font-weight: 400;" action="${pageContext.request.contextPath}/goods/searchGoods.action" method="post">
                          <!-- 用户点击跳到多少页 -->
                           <input type="hidden" name="searchInfo" value="${searchInfo}"/>
                                                                                           共有${allPage}页，到第
                           <input class="goPageNoInput" id="goPageNo" type="text" name="pageNo"/>
                                                                                            页
                           <button class="myButton" onclick="goPage();">确定</button>
                      </form>
                 </b>
             </div>
              
              <div style="width: 1187px;height: 66px; border:1px solid red;position: relative;top:104px;"></div>
              
          </div>     
</div>
 

  	


<!--菜单 -->
	<div class=tip>
		<div id="sidebar">
			<div id="wrap">
				<div id="prof" class="item ">
					<a href="# "> <span class="setting "></span>
					</a>
					<div id="showUser" class="ibar_login_box status_login ">
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
							<a href="${pageContext.request.contextPath}/orders/findUserOrdersAll.action" class="login_order ">我的订单</a> <a href="# "
								class="login_favorite ">我的收藏</a>
						</div>
						<i class="icon_arrow_white "></i>
					</div>

				</div>
				<div id="shopCart " class="item ">
					<a href="${pageContext.request.contextPath}/shopcar/showCar"> <span class="message "></span>
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


</body>
  <script type="text/javascript">
          
  
  
		  $(".goodBorder").mouseenter(function(){
				 //换个背景图
				  /*  没被选中的才变色 */
				 /* var chick = $(this).data("chick");
				 if(chick == 'nochicked'){
					 $(this).css("background-image","url('${pageContext.request.contextPath}/images/clickAddress.jpg')");
				 }		 */ 
				 
				 /* 修改其边框样式（加边框） */
				 $(this).css("border","4px solid red");
				 
		});
		$(".goodBorder").mouseleave(function(){
			    /*  没被选中的才变色 */
				/*  var chick = $(this).data("chick");
				 if(chick == 'nochicked'){
			     $(this).css("background-image","url('${pageContext.request.contextPath}/images/noclickAddress.jpg')");
				 } */
				 
			 /* 修改其边框样式（去边框） */
			 $(this).css("border","");
				 
		});
		
		
		$("#prof").mouseenter(function(){
			 $(this).find("#showUser").css("display","block");
			 
	    });
	    $("#prof").mouseleave(function(){
		   
	    	$(this).find("#showUser").css("display","none");
			 
	});
		
	    /* function goPage(){
		    用户自己输入页数，点击button后的点击事件 
		   //获得用户输入的值，判断合法性，大于最大页就跳到最大页，
		   //小于最小页就跳到最小页
		   //不是数字也跳到最小页
		   var pageNo = Number($("#goPageNo").val());
		   if(pageNo<1){
			   $("#goPageNo").val(1)
		   }else if(${allPage}<pageNo){
			   alert("pageNo>allPage");
			   $("#goPageNo").val(${allPage})
		   }
		   //提交该form表单
		   $("#goPageForm").submit();  
	   }*/
</script>

</html>
