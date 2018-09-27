<%@page import="com.jzh.shopping.pojo.Address"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>结算页面</title>

		<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />

		<link href="${pageContext.request.contextPath}/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/cartstyle.css" rel="stylesheet" type="text/css" />

        <link href="${pageContext.request.contextPath}/css/jsstyle.css" rel="stylesheet" type="text/css" />
  
  
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/mycss/css.css" />


		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
		<script type="text/javascript">
		//创建xmlhttprequest对象
		function getXMLHttpRequest(){
			var xmlhttprequest;
			//判断兼容性
			if(window.XMLHttpRequest){
				xmlhttprequest = new XMLHttpRequest();
			}else{
				xmlhttprequest = new ActiveXObject("Microsoft.XMLHTTP");
			}
			return xmlhttprequest;
		}
		
		function jian(goodsInfoId) {
			var count = document.getElementById("count_"+goodsInfoId);
			if(count.value > 1){//判断库存
				var xmlhttprequest = getXMLHttpRequest();
				xmlhttprequest.onreadystatechange = function(){
					if(xmlhttprequest.readyState == 4){
						if(xmlhttprequest.status == 200){//正常执行的状态码
							var value = xmlhttprequest.responseText;//获取后台数据
							var arr = eval(value);//遍历json
							document.getElementById("J_ActualFee").innerText=arr[0].allMoney;							
							count.value=arr[0].count;							
							document.getElementById("singlePrice_"+goodsInfoId).innerText=arr[0].money;							
						}
					}
				}
				//建立连接
				xmlhttprequest.open("GET","ShopServlet?action=updateAjax&goodsInfoIdStr="+goodsInfoId+"&countStr=-1",true);
				//发送请求
				xmlhttprequest.send();
			}	
		}
		function jia(goodsInfoId) {
			var count = document.getElementById("count_"+goodsInfoId);
				var xmlhttprequest = getXMLHttpRequest();
				xmlhttprequest.onreadystatechange = function(){
					if(xmlhttprequest.readyState == 4){
						if(xmlhttprequest.status == 200){//正常执行的状态码
							var value = xmlhttprequest.responseText;//获取后台数据
							var arr = eval(value);//遍历json
							document.getElementById("J_ActualFee").innerText=arr[0].allMoney;							
							count.value=arr[0].count;							
							document.getElementById("singlePrice_"+goodsInfoId).innerText=arr[0].money;							
						}
					}
				}
				//建立连接
				xmlhttprequest.open("GET","ShopServlet?action=updateAjax&goodsInfoIdStr="+goodsInfoId+"&countStr=1",true);
				//发送请求
				xmlhttprequest.send();
			}
			
			$(function(){
				$("ul[class='addressChoose'] li").each(function(){
						$(this).unbind();
						$(this).click(function(){
							$("ul[class='addressChoose'] li").removeClass("defaultAddr");
							$(this).addClass("defaultAddr");
							var shouhuoren = $("li[class='user-addresslist defaultAddr'] span[class='buy-user']").html();
							var dianhua = $("li[class='user-addresslist defaultAddr'] span[class='buy-phone']").html();
							var dizhi = $("li[class='user-addresslist defaultAddr'] span[class='buy--address-detail']").html();
							$("#buy_user").val(shouhuoren);
							$("#phone").val(dianhua);
							$("#address").val(dizhi);
							
							$("#send").html(dizhi);
							$("#person").html(shouhuoren);
							$("#tel").html(dianhua);	
						})
					})
					
					/* 快递方式的每一个点击事件 */
					$("ul[class='op_express_delivery_hot'] li").each(function(){
						$(this).unbind();
						$(this).click(function(){
							var express = $(this).children("span").attr("id");
							alert(express);
							$("#express").val(express);
							$("ul[class='op_express_delivery_hot'] li").removeClass("selected");
							$(this).addClass("selected");
						})
					})
					
					/* 支付方式的每一个点击事件 */
					$("ul[class='pay-list'] li").each(function(){
						$(this).unbind();
						$(this).click(function(){
							var paytype = $(this).children("span").attr("id");
							alert(paytype);
							$("#paytype").val(paytype);
							$("ul[class='pay-list'] li").removeClass("selected");
							$(this).addClass("selected");
						})
					})
					
				
				$("#go").click(function(){
					//将订单收货人，电话和收货地址加入form表达中
				    //判断用户是否已经选择了快递方式和付款方式
				    if($("#express").val()==""){
				    	$("#info").text("请选择快递方式");
				    	 $("#disappare").fadeIn(500).delay(2000).fadeOut(500);
				    }else if($("#paytype").val()==""){
				    	$("#info").text("您还未选择支付方式");
				    	$("#disappare").fadeIn(500).delay(2000).fadeOut(500);
				    }else{
				    	var dizhi = $(".chicked").find(".addressinfo").text();
						var shouhuoren = $(".chicked").find(".addressinfoname").text();
						var dianhua = $(".chicked").find(".addressinfoper").text();
/* 						alert(dizhi+"--"+shouhuoren+"--"+dianhua); */
						$("#buy_user").val(shouhuoren);
						$("#phone").val(dianhua);
						$("#address").val(dizhi);
						$("#form").submit();  
				    }
					
					
				})
				
			})
			
		
			
		</script>
		
		<style type="text/css">
		  /*  针对所有的地址框的基本样式 */
		  .myAddress{
		       float:left;
		       width:238px;
		       height: 106px;
		       margin-left: 10px;
		       margin-top: 10px;
		  
		  }
		  /*地址框中的地址信息*/
		.addressinfo{
				width:220px; 
				height:18px; 
				position: relative; 
				top:0px;left:0px;
				text-align: center;
		}
		.addressinfoper{
		        width:220px; 
				height:18px; 
				text-align: center;
				position: relative; 
				top:5px;left:-42px;
		}
		.addressinfoname{
		        width:220px; 
				height:18px; 
				text-align: center;
				position: relative; 
				top:-13px;left:42px;
		}
		.addresstitle{
		        position: relative;
		        top:10px;
		        left:10px;
		}
		.showAddressInfo{
		        position:relative; 
		        top:19px;
		        left:8px; 
		        width: 221px;
		        height: 47px; 
		      
		
		}
		.toDefault{
		        width:84px;
		        height:20px;
		        position: relative;
		        top:-57px;
		        left:146px;
		}
		.default{
		        width:84px;
		        height:20px;
		        position: relative;
		        top:-57px;
		        left:146px;
		}
		.editAddress{
		        width:30px;
		        height:20px;
		        position: relative;
		        top:-5px;
		        left:9px;
		
		}
		/* 添加默认和编辑地址是否被选中的样式 */
		.unchick{
		       display: none;
		}
		.chick{
		       display:;
		}
		
		/* 用作编辑的div的样式（最大的那个） */
		#editdiv{
		       width:700px;
		       height: 700px;
		       position: absolute;
		       top:20px;
		       left:325px;
		       border:3px solid red; 
		       background-color: #fff; 
		       z-index:101;
		       display: block;
		}
		.hidediv{
		      /*  background-color: #000; */
		       display:none;
               background:rgba(0,0,0,0.6);
               width:100%;
               height:100%;
               position:fixed;
               top:0;
               left:0;
               z-index:100;
		}
		.showdelete{
		       display:none;
               background:rgba(0,0,0,0.2);
               width:100%;
               height:100%;
               position:fixed;
               top:0;
               left:0;
               z-index:100;
		
		}
		#ifdelete{
		        width:318px;
		       height: 236px;
		       position: absolute;
		       top:277px;
		       left:540px;
		       border:3px solid red; 
		       border-radius:7px;
		       background-color: #fff; 
		       z-index:101;
		       display: block;
		
		}
		/* 地址选择框的相对位移 */
		.content{
		        position: relative;
		        top:10px;
		        left:20px;
		
		}
		
		.deleteAddress{
		        width:40px;
		        height:21px;
		        position: relative;
		        top:-26px;
		        left:174px;

		        border: 2px solid red; 
		        border-radius:4px;
		        background-color:red;
		        text-align: center;     
		}
		
		.deletebutton{
		        width:56px;
		        height:29px; 
		        border:3px solid red;
		        border-radius:4px;
		        font-size: 18px;
		        background-color:red;
		        text-align: center;
		        color: white;
		       
		}
		</style>
		
	</head>

	<body>

	<%@include file="head.jsp" %>
			<div class="concent">
				<!--地址 -->
				<div class="paycont">
			<%-- 		<div class="address">
						<!-- <h3>确认收货地址 </h3>
						<div class="control">
							<div class="tc-btn createAddr theme-login am-btn am-btn-danger"><a href="addAddress.jsp" style="color: white;">使用新地址</a></div>
						</div> -->
						<div class="clear"></div>
						<ul class="addressChoose">
							
								<!-- 默认地址：class="user-addresslist defaultAddr" -->
									<li 
									<c:if test="${address.isdefault eq '是'}">class="user-addresslist defaultAddr"</c:if>
									<c:if test="${address.isdefault eq '否'}">class="user-addresslist "</c:if>
									>
									  <li class="user-addresslist">
										<div class="address-left">
											<div class="user DefaultAddr">
												 <span class="buy-address-detail"></span>
		                  						 <span class="buy-user">${address.addContactName}</span>
												 <span class="buy-phone">${address.addContactPhone}</span>
											</div>
												
											<div class="default-address DefaultAddr">
												<span class="buy-line-title buy-line-title-type">收货地址：</span>
												<span class="buy--address-detail">${address.address}</span>
											</div>
												<ins class="deftip">默认地址</ins>
										</div>
								</li>
								<li class="user-addresslist">
										<div class="address-left">
											<div class="user DefaultAddr">
												 <span class="buy-address-detail"></span>
		                  						 <span class="buy-user">${address.addContactName}</span>
												 <span class="buy-phone">${address.addContactPhone}</span>
											</div>
												
											<div class="default-address DefaultAddr">
												<span class="buy-line-title buy-line-title-type">收货地址：</span>
												<span class="buy--address-detail">${address.address}</span>
											</div>
												<ins class="deftip">默认地址</ins>
										</div>
								</li>
								<li class="user-addresslist">
										<div class="address-left">
											<div class="user DefaultAddr">
												 <span class="buy-address-detail"></span>
		                  						 <span class="buy-user">${address.addContactName}</span>
												 <span class="buy-phone">${address.addContactPhone}</span>
											</div>
												
											<div class="default-address DefaultAddr">
												<span class="buy-line-title buy-line-title-type">收货地址：</span>
												<span class="buy--address-detail">${address.address}</span>
											</div>
												<ins class="deftip">默认地址</ins>
										</div>
								</li>
								<li class="user-addresslist">
										<div class="address-left">
											<div class="user DefaultAddr">
												 <span class="buy-address-detail"></span>
		                  						 <span class="buy-user">${address.addContactName}</span>
												 <span class="buy-phone">${address.addContactPhone}</span>
											</div>
												
											<div class="default-address DefaultAddr">
												<span class="buy-line-title buy-line-title-type">收货地址：</span>
												<span class="buy--address-detail">${address.address}</span>
											</div>
												<ins class="deftip">默认地址</ins>
										</div>
								</li>
						</ul>
						<div class="clear"></div>
					</div> --%>
					
					<!-- 自己写的地址栏 我的地址-->
					<div class="div-showAddress" style="align-content:center; width:1000px; height:111px;">
					         <div id="address1" class="defaultaddress myAddress chicked" data-chick="chicked" style="background-image:url('${pageContext.request.contextPath}/images/clickedAddress.jpg'); ">
					                <span class="addresstitle">收货地址：</span>
					                 
					                <div class="showAddressInfo">
					                       <p class="addressinfo ">${defaultAddress.address}</p>
					                       <p class="addressinfoper">${defaultAddress.addContactPhone}</p>
					                       <p class="addressinfoname">${defaultAddress.addContactName}</p>
					                </div>
					                <div class="default toa dosth chick"><a href="#" id="changedf1" class="aInfo" onclick="return changeDefaultAdd(1,${defaultAddress.addId});">默认地址</a></div>
					                <div class="editAddress dosth chick"><a href="#" onclick="return showEditDiv(1,${defaultAddress.addId});">编辑</a></div>
					                <div class="deleteAddress dosth chick"><a style="color: white;" href="#" onclick="return deleteAddress(1,${defaultAddress.addId});">删除</a></div>
					         </div>
					         
					         <!--记录这是第几个地址 -->
					         <c:set var="item" value="2" scope="page"></c:set>
					         <c:forEach items="${otherAddress}" var="otherAdd">		         
					            <c:if test="${item<5}">
					               <c:set var="item" value="${(item+1)}" scope="page"></c:set>
					               <div id="address${item}" class="myAddress" data-chick="nochicked" style= "background-image:url('${pageContext.request.contextPath}/images/noclickAddress.jpg');">           
					                   <span class="addresstitle">收货地址：</span>
					                
					                  <div class="showAddressInfo">
					                  <p class="addressinfo ">${otherAdd.address}</p>
					                 <%--  <p class="addressinfoper">${otherAdd.addContactPhone}&nbsp;&nbsp;&nbsp;&nbsp;${otherAdd.addContactName}</p> --%>
					               <p class="addressinfoper">${otherAdd.addContactPhone}</p>
					               <p class="addressinfoname">${otherAdd.addContactName}</p>
					                  </div>
					                   <div class="toDefault toa dosth unchick"><a href="#" id="changedf${item}" class="aInfo" onclick="return changeDefaultAdd(${item},${otherAdd.addId});">设为默认地址</a></div>
					                   <div class="editAddress dosth unchick"><a href="#" onclick="return showEditDiv(${item},${otherAdd.addId});">编辑</a></div>
					                   <div class="deleteAddress dosth unchick"><a  href="#" onclick="return deleteAddress(${item},${otherAdd.addId});"><span style="color: white;">删除</span></a></div>
					               </div>
					            </c:if>
					         </c:forEach>    
					</div>
					
					<!-- 判断是否还有更多地址 -->
					<c:if test="${fn:length(otherAddress)>3}">
					<div style="margin-bottom: 23px;margin-top: 23px; border:2px solid rgb(287, 236, 120);border-radius:6px; position: relative;top:12px;left:12px; width:100px;height:27px; text-align: center;">
					   <a id="showmoreaddress" data-show="showmore" href="#" onclick="return showMoreAddress();">显示更多地址</a>
					</div>
					<div style="margin-bottom: 23px; border:2px solid rgb(287, 236, 120);border-radius:6px; position: relative;top:-38px;left:189px; width:100px;height:27px; text-align: center;">
					   <a href="#" onclick="return addoneaddress();">添加地址</a>
					</div>
					
			<!--   显示更多的地址信息，开始时为隐藏 -->
			       <% List<Address> otherAdd = (List<Address>)request.getAttribute("otherAddress");
			          int height = (int)(otherAdd.size()-3)/4+((otherAdd.size()-3)%4>0?1:0);
			          request.setAttribute("height", height);
			       %>
			     <div id="moreAddress" class="moreAddress" style="display: none; margin-top:-40px; align-content:center; width:1000px; height:${height*111}px;">
			        
			               <c:set var="item" value="${(item-4)}" scope="page"></c:set>
					       <c:forEach items="${otherAddress}" var="otherAdd">
					         <c:set var="item" value="${(item+1)}" scope="page"></c:set>
					           <c:if test="${item>4}">
					              <div id="address${item}" data-chick="nochicked" class="myAddress" style= "background-image:url('${pageContext.request.contextPath}/images/noclickAddress.jpg');">           
					                   <span class="addresstitle">收货地址：</span>
					             
					                   <div class="showAddressInfo">
					                    <p class="addressinfo ">${otherAdd.address}</p> 
					                   <%--  <p class="addressinfoper">${otherAdd.addContactPhone}&nbsp;&nbsp;&nbsp;&nbsp;${otherAdd.addContactName}</p> --%>
					               <p class="addressinfoper">${otherAdd.addContactPhone}</p>
					               <p class="addressinfoname">${otherAdd.addContactName}</p>
					                   </div>
					                   <div class="toDefault toa dosth unchick"><a href="#" id="changedf${item}" class="aInfo" onclick="return changeDefaultAdd(${item},${otherAdd.addId});">设为默认地址</a></div>
					                   <div class="editAddress dosth unchick"><a href="#" onclick="return showEditDiv(${item},${otherAdd.addId});">编辑</a></div>
					                   <div class="deleteAddress dosth unchick"><a  style="color: white;" href="#" onclick="return deleteAddress(${item},${otherAdd.addId});">删除</a></div>
					              </div>
					          </c:if>
					      </c:forEach>  
			     </div>
					
					</c:if>
					<div class="clear"></div>
					
					
					
					
					
					<!--物流 -->
					<div class="logistics">
						<h3>选择物流方式</h3>
						<ul class="op_express_delivery_hot">
							<li data-value="yuantong" class="OP_LOG_BTN "><i class="c-gap-right" style="background-position:0px -468px"></i>圆通<span id="圆通"></span></li>
							<li data-value="shentong" class="OP_LOG_BTN "><i class="c-gap-right" style="background-position:0px -1008px"></i>申通<span id="申通"></span></li>
							<li data-value="yunda" class="OP_LOG_BTN "><i class="c-gap-right" style="background-position:0px -576px"></i>韵达<span id="韵达"></span></li>
							<li data-value="zhongtong" class="OP_LOG_BTN op_express_delivery_hot_last"><i class="c-gap-right" style="background-position:0px -324px"></i>中通<span id="中通"></span></li>
							<li data-value="shunfeng" class="OP_LOG_BTN  op_express_delivery_hot_bottom"><i class="c-gap-right" style="background-position:0px -180px"></i>顺丰<span id="顺丰"></span></li>
						</ul>
					</div>
					<div class="clear"></div>

					<!--支付方式-->
					<div class="logistics">
						<h3>选择支付方式</h3>
						<ul class="pay-list">
							<li class="pay card"><img src="${pageContext.request.contextPath}/images/wangyin.jpg" />银联<span id="银联"></span></li>
							<li class="pay qq"><img src="${pageContext.request.contextPath}/images/weizhifu.jpg" />微信<span id="微信"></span></li>
							<li class="pay taobao"><img src="${pageContext.request.contextPath}/images/zhifubao.jpg" />支付宝<span id="支付宝"></span></li>
						</ul>
					</div>
					<div class="clear"></div>

					<!--订单 -->
					<div class="concent">
						<div id="payTable">
							<h3>确认订单信息</h3>
							<div class="cart-table-th">
								<div class="wp">

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
									<div class="th th-oplist">
										<div class="td-inner">配送方式</div>
									</div>

								</div>
							</div>
							<div class="clear"></div>
							
						<!-- 购物车 -->
						<c:set var="goodAllSize" scope="page" value="${0}"></c:set>
						<c:set var="allPrice" scope="page" value="${0}"></c:set>
						<!-- 区分每个购物项的辅助变量 -->
						<c:set var="itemNum" scope="page" value="${0}"></c:set>
						<c:forEach items="${shoppingCar.items}" var="shopCartItem" >
						     <c:set var="allPrice" scope="page" value="${(allPrice+shopCartItem.money)}"></c:set>
							 <c:set var="goodAllSize" scope="page" value="${(goodAllSize+shopCartItem.count)}"></c:set>
							 <c:set var="itemNum" scope="page" value="${(itemNum+1)}"></c:set>
							<!-- 一个ul是一个购物项 -->
							<ul id="item${itemNum}" style="background-color: white;border:1px solid rgb(287, 236, 120);border-radius:6px;"class="item-content clearfix">
								<li class="td td-item">	
								 		  
								  
									<div class="item-pic" style="position:relative; top:-4px;left:4px;">							
										<a target="_blank" class="J_MakePoint"
											data-point="tbcart.8.12"> <img
											src="${pageContext.request.contextPath}/images/${shopCartItem.good.gPhoto}"
											style="width: 80px; height: 80px" class="itempic J_ItemImg"></a>
									</div>
									<div class="item-info">
										<div class="item-basic-info" style="margin-top: -7px;">
											<a href="${pageContext.request.contextPath}/goods/showGoodById.action?gId=${shopCartItem.good.gId}" target="_blank" title=""
												class="item-title J_MakePoint" data-point="tbcart.8.11">
								                <span style="position:relative; top:22px; left:12px; color:#AAAAAA;font-size: 22px;">${shopCartItem.good.gName}</span></a>
												<br/>
												<span style="position:relative; top:32px; left:12px; color:#AAAAAA">${shopCartItem.good.gDes}</span>
										</div>
									</div>
								</li>
								
								<li class="td td-price">
									<div class="item-price price-promo-promo">
										<div class="price-content" style="position: relative; top:25px; left:6px;">
													<div class="price-line">
														<em class="price-original">${shopCartItem.good.gyPrice}</em>
													</div>
														
													<div class="price-line">
														<em id="gcPrice${itemNum}" class="J_Price price-now" tabindex="0">${shopCartItem.good.gcPrice}</em>
													</div>
										</div>
									</div>
								</li>
								<li class="td td-amount">
									<div class="amount-wrapper ">
										<div class="item-amount ">
											<div class="sl" style="position: relative; top:25px; left:1px">
											 <input readonly="readonly" name="count" class="text_box" id="countStr${itemNum}" type="text" value="${shopCartItem.count}" style="width: 30px; text-align: center;" /> 
											</div>
										</div>
									</div>
								</li>
								<li class="td td-sum">
									<div class="td-inner" style="position: relative; top:30px; left:6px">
										<em id="itemprice${itemNum}" tabindex="0" class="J_ItemSum number" ><fmt:formatNumber value="${shopCartItem.money}" pattern="#.00"/></em>
									</div>
								</li>
								<li class="td td-oplist">
												<div class="td-inner" style="position: relative; top:30px;left:2px;">
													<div class="pay-logis">
														快递<b class="sys_item_freprice">包邮</b>
													</div>
												</div>
											</li>
							    <!-- 作为参数传递给外界 -->
							    <input type="hidden" name="gId" value="${shopCartItem.good.gId}"/>
							    
							    <!--点击提交时，将所选的商品id和其数量， 作为参数传给后端 -->
							    <input id="payId${itemNum}" type="hidden" name="gIdNoChoice" value="${shopCartItem.good.gId}"/>
							    <input id="payCount${itemNum}" type="hidden" name="countNoChoice" value="0"/>
							    
							</ul>
							
							   
							    
							    
							</c:forEach>
							
							
							
							
					<%-- 		
					<c:forEach items="${shoppingCar.items}" var="shopCartItem">
							<!-- 购物车 -->
							<tr class="item-list">
								<div class="bundle  bundle-last">

									<div class="bundle-main">
										<ul style="background-color: white;border:1px solid rgb(287, 236, 120);border-radius:6px;" class="item-content clearfix">
											<div class="pay-phone">
												<li class="td td-item">
													<div class="item-pic">
														<a href="#" class="J_MakePoint">
															<img src="${pageContext.request.contextPath}/images/${shopCartItem.good.gPhoto}" style="width: 80px; height: 80px" class="itempic J_ItemImg"></a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a href="#" class="item-title J_MakePoint" data-point="tbcart.8.11">${shopCartItem.good.gDes}</a>
														</div>
													</div>
												</li>						
												<li class="td td-price">
													<div class="item-price price-promo-promo">
														<div class="price-content">
															<div class="price-line">
																<em class="price-original">${shopCartItem.good.gyPrice}</em>
															</div>
															<div class="price-line"> 
																<em class="J_Price price-now" id="priceNow" tabindex="0">${shopCartItem.good.gcPrice}</em>
															</div>
														</div>
													</div>
												</li>
											</div>
											<li class="td td-amount">
												<div class="amount-wrapper ">
													<div class="item-amount ">
														<span class="phone-title">${shopCartItem.count}</span>
														<div class="sl">
															<input class="min am-btn" name="" type="button" value="-" id="jian" onclick="jian(${shopCartItem.good.gId})"/> 
															<input class="text_box" id="count_${shopCartItem.good.gId}" type="text" value="${shopCartItem.count}" 
													          style="width: 30px; text-align: center;"/> 
													          <input class="add am-btn" name="" type="button" value="+"  id="jia" onclick="jia(${shopCartItem.good.gId})"/>
														 <input type="hidden"  value="goodsId">
														</div>
													</div>
												</div>
											</li>
											<li class="td td-sum">
												<div class="td-inner">
													<em tabindex="0" class="J_ItemSum number" id="singlePrice_${shopCartItem.good.gId}">${shopCartItem.money}</em>
												</div>
											</li>
											<li class="td td-oplist">
												<div class="td-inner">
													<span class="phone-title">配送方式</span>
													<div class="pay-logis">
														快递<b class="sys_item_freprice">包邮</b>
													</div>
												</div>
											</li>

										</ul>
										<div class="clear"></div>

									</div>
							</tr>
							
							</c:forEach> --%>
							
							<div class="clear"></div>
							</div>


							<!--信息 -->
							<div style="" class="order-go clearfix">
								<div class="pay-confirm clearfix">
									<div style="width:300px;" class="box">
										<div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
											<span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee">${shoppingCar.prices}</em>
											</span>
										</div>

										<div id="holyshit268" class="pay-address">

											<p class="buy-footer-address">
												<span  class="buy-line-title buy-line-title-type">寄送至：</span>
												<span class="buy--address-detail" id="send">
								  						${defaultAddress.address}
												</span>
											</p>
											<p class="buy-footer-address">
												<span class="buy-line-title">收货人：</span>
						                        <span class="buy-address-detail">   
                                         <span class="buy-user" id="person">${defaultAddress.addContactName}</span>
												<span class="buy-phone" id="tel">${defaultAddress.addContactPhone}</span>
												</span>
												<%--  <p id="addressUser" style="position: relative;top:-28px;left:-11px">${defaultAddress.addContactPhone}&nbsp;&nbsp;&nbsp;&nbsp;${defaultAddress.addContactName}</p> --%>
											</p>
										</div>
									</div>

									<div id="holyshit269" class="submitOrder">
										<div class="go-btn-wrap">
											<a id="go" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
										</div>
										
										<!-- 存放了订单信息的form表达 -->
										<form action="${pageContext.request.contextPath}/pay/makeOrder.action" method="post" id="form">
											<input type="hidden" name="oShPeople" value="" id="buy_user"/>
											<input type="hidden" name="oShTelNum" value="" id="phone"/>
											<input type="hidden" name="oShAddress" value="" id="address"/>
											<input type="hidden" name="oSendType" value="" id="express"/>
											<input type="hidden" name="oPayType" value="" id="paytype"/>
											 <c:forEach items="${payId}" var="onePayId">
							                  <input type="hidden"  name="payId" value="${onePayId}"/>
							                  </c:forEach>
							                  <c:forEach items="${payCount}" var="oneCount">
							                    <input type="hidden" name="payCount" value="${oneCount}"/>
							                  </c:forEach>
										</form>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">恒望科技</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于恒望</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>© 2015-2025 Hengwang.com 版权所有</em>
						</p>
					</div>
				</div>
			</div>
			<div class="theme-popover-mask"></div>
			<div id="disappare" style="display:none; border:3px solid #ccc;border-radius: 7px;background: #fff;font-size: 35px;
                                        width: 309px;height: 110px; position: relative;top:-312px; left:762px;">
						 <h2 style="color: #B79">温馨提示：</h2>
					     <p id="info" style=" position:relative;top:18px;left:2px;
					          color: #B79; text-align: center;">这里是提醒用户选择快递或支付方式的弹窗</p>
			</div>
			<!-- 下面是一个遮罩层 -->
			<div class="hidediv">
			  <div id="editdiv" class="jzh">

				<!--标题 -->
				<div class="am-cf am-padding">
					<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add address</small></div>
				</div>
				<hr/>

				<div class="am-u-md-12">	
					<form id="editaddressform" method="post" action="${pageContext.request.contextPath}/address/updateAddress.action" class="am-form am-form-horizontal">

						<div class="am-form-group">
							<label for="user-name"  class="am-form-label">收货人</label>
							<div class="am-form-content">
								<input type="text" id="username" name="addContactName" placeholder="收货人">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-form-label">手机号码</label>
							<div class="am-form-content">
								<input id="userphone" name="addContactPhone" placeholder="手机号必填" type="email">
							</div>
						</div>
<!-- 
						<div class="am-form-group">
							<label for="user-phone" class="am-form-label">所在地</label>
							<div class="am-form-content address">
								<select data-am-selected>
									<option value="a">浙江省</option>
									<option value="b">湖北省</option>
								</select>
								<select data-am-selected>
									<option value="a">温州市</option>
									<option value="b">武汉市</option>
								</select>
								<select data-am-selected>
									<option value="a">瑞安区</option>
									<option value="b">洪山区</option>
								</select>
							</div>
						</div> -->
						
						 <div id="citychonce" style="width:1000px;height: 300px; position: relative; top:0px; left: 48px;">
                                          <!--注意选DOM结构不要随便更改，可能会导致出错-->
											<ul class="listArea">
												<li class="summary-stock">
													<div style="position: relative;left:-55px;" class="dt">地&nbsp;址&nbsp;选&nbsp;择</div>
													<div style="position: relative;left:-22px;" class="dd" id="infoAddress">
													    <div  class="addrID"><div></div><b></b></div> 
														<div class="store-selector">
															<div class="text"><div></div><b></b></div>                   
															<div onclick="$(this).parent().removeClass('hover')" class="close"></div>
														</div>
													</div>
												</li>
											</ul>
								<br />             
                         </div>
                         
                         

						<div class="am-form-group">
							<label for="user-intro" class="am-form-label">详细地址</label>
							<div class="am-form-content">
								<textarea class="" name="addressmore" rows="3" id="userintro" placeholder="输入详细地址"></textarea>
								<small>100字以内写出你的详细地址...</small>
							</div>
						</div>
                                          
						<div class="am-form-group theme-poptit">
							<div class="am-u-sm-9 am-u-sm-push-3">
							
							     <input id="putAddress" type="hidden" name="address" value="">
							     <input id="addressId" type="hidden" name="addId" value="0">
							     <c:forEach items="${payId}" var="onePayId">
							        <input type="hidden"  name="payIds" value="${onePayId}"/>
							     </c:forEach>
							     <c:forEach items="${payCount}" var="oneCount">
							         <input type="hidden" name="payCounts" value="${oneCount}"/>
							     </c:forEach>
							    
								<div class="am-btn am-btn-danger" onclick="editAddressSave();">保存</div>
								<div class="am-btn am-btn-danger close" onclick="colseHideDiv();">取消</div>
							</div>
						</div>
					</form>
				  </div>

			      </div>
			
			
			</div>
			
			<!-- 遮罩层结束 -->
			
			<div class="clear">
			</div>
			
			<!-- 用户点击删除时将会显示的界面 -->
			<div class="showdelete">
			    <div id="ifdelete">
			         <div style="align-content:center; font-size:20px; width:275px;height:123px; position: relative;top:70px;left:68px;color:red;">确定要删除此地址？</div>
			         <div class="deletebutton" style="position: relative;top:50px;left:26px"><a id="deleteAId" style="color: white;" href="#" >删除</a></div>
			         <div class="deletebutton" style="position: relative;top:22px;left:228px"><a href="#" style="color: white;" onclick="return goback();">取消</a></div>
			      
			         <form id="deleteAddressForm" action="${pageContext.request.contextPath}/address/deleteAddress.action" method="post">
			                     <c:forEach items="${payId}" var="onePayId">
							        <input type="hidden"  name="payId" value="${onePayId}"/>
							     </c:forEach>
							     <c:forEach items="${payCount}" var="oneCount">
							         <input type="hidden" name="payCount" value="${oneCount}"/>
							     </c:forEach>
			                      <input id="deleteAddId" type="hidden" name="addId" value="0"/>
			         </form>
			    </div>
			</div>
			<!-- 点击编辑后将会弹出的div，用来编辑用户信息 -->
			
	</body>
     
     
     <script type="text/javascript">
     function stopBubbling(e) {
         e = window.event || e;
         if (e.stopPropagation) {
             e.stopPropagation();      //阻止事件 冒泡传播
         } else {
             e.cancelBubble = true;   //ie兼容
         }
     }
     //点击查看更多地址信息的点击事件
     function showMoreAddress(){
    	 var show = $("#showmoreaddress").data("show");

    	 if(show == 'showmore'){
    		 $("#moreAddress").css("display",""); 
    		 $("#showmoreaddress").text("收回更多地址");
    		 $("#showmoreaddress").data("show","backmore");
    	 }else{
    		 $("#moreAddress").css("display","none"); 
    		 $("#showmoreaddress").text("显示更多地址");
    		 $("#showmoreaddress").data("show","showmore");
    	 }
    	 return false;	 
     }

    	 
      $(".myAddress").mouseenter(function(){
    		 //换个背景图
    		  /*  没被选中的才变色 */
    		 var chick = $(this).data("chick");
    		 if(chick == 'nochicked'){
    			 $(this).css("background-image","url('${pageContext.request.contextPath}/images/clickAddress.jpg')");
    		 }		 
     });
      $(".myAddress").mouseleave(function(){
    	    /*  没被选中的才变色 */
    		 var chick = $(this).data("chick");
    		 if(chick == 'nochicked'){
    	     $(this).css("background-image","url('${pageContext.request.contextPath}/images/noclickAddress.jpg')");
    		 }
       });
      
      $(".myAddress").click(function(){
    	  var chick = $(this).data("chick");
 		 if(chick == 'nochicked'){
 			 //得到之前的被选标签
 			 $(".chicked").data("chick","nochicked");
 			 //改变原标签背景
 			 $(".chicked").css("background-image","url('${pageContext.request.contextPath}/images/noclickAddress.jpg')");
 			 //删除原标签的chicked类
 			 $(".chicked").removeClass("chicked");
 			 //将目前标签class增加chicked
 			 $(this).addClass("chicked");
 			 //chick设置为被选
 			 $(this).data("chick","chicked");
 			 //改变当前背景
 			 $(this).css("background-image","url('${pageContext.request.contextPath}/images/clickedAddress.jpg')");
 			 //改变下面的收货信息
 			 //获得该地址栏中的各项信息
 			 var address = $(this).find(".addressinfo").text();
 			 var addressphone = $(this).find(".addressinfoper").text();
 			 var addressName = $(this).find(".addressinfoname").text();
 			 //设置
 			 $("#send").text(address);
 			 $("#tel").text(addressphone);
 			 $("#person").text(addressName);
 			 //将之前的编辑设为unchick，将本标签设为chick
            $(".chick").addClass("unchick");
            $(".chick").removeClass("chick");
            $(this).find(".dosth").removeClass("unchick");
            $(this).find(".dosth").addClass("chick");
            
 		 }  
      });
      
    /*  function enter(item){
    	 alert(item);
    	 
     } */
     
     function changeDefaultAdd(item,addId){
         //Ajax请求后台修改默认地址
         $.get("${pageContext.request.contextPath}/address/changeDefaultAddress.action?addId="+addId,function(data,state){
        	 if(state == 'success'){
            	 //得到两边的div元素
            	 var oldDiv = $(".defaultaddress");
            	 var newDiv = $("#address"+item);
            	  //得到两边div元素的id
            	 var oldId = oldDiv.attr("id");
            	 var newId = newDiv.attr("id");
            	 //交换两边的id
            	 oldDiv.attr("id",newId);
            	 newDiv.attr("id",oldId);
            	 //得到两边a标签中的内容
            	 var oldAInfo = oldDiv.find(".aInfo").text();
            	 var newAInfo = $("#changedf"+item).text();
            	 //交换两边a标签内的值
            	 oldDiv.find(".aInfo").text(newAInfo);
            	 $("#changedf"+item).text(oldAInfo); 
            	 //设置双方data-chick
            	  newDiv.data("chick","nochicked");
            	 oldDiv.data("chick","chicked"); 
            	 //移出和添加类中的chicked
            	 newDiv.removeClass("chicked");
            	 oldDiv.addClass("chicked"); 
            	 //交换两边的html
            	  var oldHtml = oldDiv.html();
            	 var newHtml = newDiv.html();
            	 oldDiv.html(newHtml);
            	 newDiv.html(oldHtml);  
            	 //修改两边div的背景图 */
            	 newDiv.css("background-image","url('${pageContext.request.contextPath}/images/noclickAddress.jpg')");
            	 oldDiv.css("background-image","url('${pageContext.request.contextPath}/images/clickedAddress.jpg')");
            	 stopBubbling(item); 
            	 return false;
        	 } 
         });
     }
     
     function showEditDiv(item,addId){
    	 //点击编辑后，显示编辑的遮罩层，并将数据写到上面
    	 //得到遮罩层标签
    	 $(".hidediv").css("display","block");
    	 //将数据写到上面
    	 //得到当前的地址栏div
    	 var nowDiv = $("#address"+item);
    	 var address = nowDiv.find(".addressinfo").text(); 
    	 var addressbefore = address.split("-")[0];
    	 var addressmore = address.split("-")[1];
	     var addressphone = nowDiv.find(".addressinfoper").text();
	     var addressName = nowDiv.find(".addressinfoname").text();
    	 //将上面的数据写到编辑界面
    	 $("#username").val(addressName);
    	 $("#userphone").val(addressphone);
    	 //将地址写入地址框
	     $(".text").find("div").text(addressbefore);
    	 //将详细地址写入详细地址框
    	 $("#userintro").val(addressmore);
    	 //设置隐藏表单的addId项
    	 $("#addressId").val(addId);
    	 stopBubbling(addId); 
    	 return false;
    	 
     }
     
     function colseHideDiv(){
    	 //编辑地址界面点取消后的点击事件
    	 $(".hidediv").css("display","none"); 
     }
     
     //编辑地址信息后的保存按钮的点击事件
     function editAddressSave(){
    	 //组装address
    	 var addressbefore = $(".text").find("div").text();
    	 var addressmore = $("#userintro").val();
    	 var address = addressbefore+"-"+addressmore;
    	 $("#putAddress").val(address);
    	 alert("拼装完后的地址："+address);
    	 //提交form表单
    	 $("#editaddressform").submit(); 
     }
     
     //点击添加后的点击事件
     function addoneaddress(){
    	 //就将编辑界面显示出来就是类
    	 $(".hidediv").css("display","block");
    	 $("#addressId").val(0);
    	 stopBubbling(addId); 
    	 return false; 
     }
     //点击删除后的点击事件
     function deleteAddress(item,addId){
    	  //打开  是否删除  界面
    	 $(".showdelete").css("display","block");
    	 $("#deleteAId").click(function(){
    		 $("#deleteAddId").val(addId);
    		 //提交form表单
    		 $("#deleteAddressForm").submit();
    		 
    	 }); 
     }
     
     function goback(){
    	 $(".showdelete").css("display","none"); 
    	 return false;
     }
     
     </script>

     
     
     
     
    <script src="${pageContext.request.contextPath}/myjs/jquery-1.9.1.js"></script>
    <script src="${pageContext.request.contextPath}/myjs/location.js"></script>
    <script>
    //如果初始化为其他地区的，需要注意选择器的修改，传递不同的proid（省id），cityid：(市id) areaid：（县id），省市对应ID在location.js里面有定义，县id从京东动态加载
    $('ul.listArea').Address({ proid: 1152, cityid: 1153, areaid: 1154 });//初始化Tab中的地址
    /* $(".store-selector").find(".text div").html("山东济南");//初始化文本框显示的地址 */
    </script>
</html>