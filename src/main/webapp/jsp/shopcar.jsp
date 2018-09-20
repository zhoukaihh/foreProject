<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>购物车页面</title>

<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/basic/css/demo.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cartstyle.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/optstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myMath.js"></script>
<script type="text/javascript">
	/* function jian(id,count) {
		if(count > 1){
			window.location="ShopServlet?action=update&goodsInfoIdStr="+id+"&countStr=-1";
		}
	}

	function jia(id,count) {
			window.location="ShopServlet?action=update&goodsInfoIdStr="+id+"&countStr=1";
	}*/
</script> 
</head>

<body>

	<!--顶部导航条 -->
	<%@include file="head.jsp"%>

	<!--购物车 -->
	<form id="carForm" action="${pageContext.request.contextPath}/shopcar/saveCar" method="post">
	<div class="concent">
		<div id="cartTable">
			<div class="cart-table-th">
				<div class="wp" style="height: 70px;">
					<div class="th th-chk">
						<div id="J_SelectAll1" class="select-all J_SelectAll"></div>
					</div>
					<div class="th th-item">
						<div class="td-inner">商品信息</div>
                        <span style="position: relative; top:-50px; left:340px; width:80px; height: 20px;">商品库存</span>
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
					<div class="bundle-hd">
						<div class="bd-promos"></div>
					</div>
					<div class="clear"></div>
					<div class="bundle-main"></div>
				</div>
			</tr>
			<div class="clear"></div>
			
				<tr class="item-list">
					<div class="bundle  bundle-last ">

						<div class="clear"></div>
						<div class="bundle-main">
						
						<!-- 购物车 -->
						<c:set var="goodAllSize" scope="page" value="${0}"></c:set>
						<c:set var="allPrice" scope="page" value="${0}"></c:set>
						<!-- 区分每个购物项的辅助变量 -->
						<c:set var="itemNum" scope="page" value="${0}"></c:set>
						<c:forEach items="${shopCar.items}" var="shopCartItem" >
						     <c:set var="allPrice" scope="page" value="${(allPrice+shopCartItem.money)}"></c:set>
							 <c:set var="goodAllSize" scope="page" value="${(goodAllSize+shopCartItem.count)}"></c:set>
							 <c:set var="itemNum" scope="page" value="${(itemNum+1)}"></c:set>
							<!-- 一个ul是一个购物项 -->
							<ul id="item${itemNum}" style="background-color: white;border:1px solid rgb(287, 236, 120);border-radius:6px;"class="item-content clearfix">
								<li onclick="beCheck('${itemNum}');" class="td td-item">	
								   <div   style="position:relative;top:44px;left:-20px; width:20px; height:20px;" >
								    <input style="width:15px;height:15px; background-color: #F47164;border: 3px solid #F47164;" id="check${itemNum}"  type="checkbox" name="before" value="${itemNum}"/>
								   </div>		  
								  
									<div class="item-pic" style="position:relative; top:-23px;left:4px;">							
										<a target="_blank" class="J_MakePoint"
											data-point="tbcart.8.12"> <img
											src="${pageContext.request.contextPath}/shoppingImages/${shopCartItem.good.goodImage}"
											style="width: 80px; height: 80px" class="itempic J_ItemImg"></a>
									</div>
									<div class="item-info">
										<div class="item-basic-info" style="margin-top: -7px;">
											<a href="${pageContext.request.contextPath}/goods/showGoodById?goodId=${shopCartItem.good.goodId}" target="_blank" title=""
												class="item-title J_MakePoint" data-point="tbcart.8.11">
								                <span style="position:relative; top:22px; left:12px; color:#AAAAAA;font-size: 22px;">${shopCartItem.good.goodName}</span></a>
												<br/>
												<span style="position:relative; top:32px; left:12px; color:#AAAAAA">${shopCartItem.good.goodDes}</span>
										</div>
									</div>
								</li>
								<li class="td td-info">
									<div class="item-props item-props-can" style=" border:0px;">
                                           <span id="goodNums${itemNum}" style="position:relative; top:35px; left:13px;">${shopCartItem.good.goodNums}</span><span id="nomore" style="color:red; width: 30px;height: 10px;position:relative; top:35px; left:33px;"></span>
										<i class="theme-login am-icon-sort-desc"></i>
									</div>
								</li>
								<li class="td td-price">
									<div class="item-price price-promo-promo">
										<div class="price-content" style="position: relative; top:25px; left:6px;">
													<div class="price-line">
														<em class="price-original">${shopCartItem.good.goodPrice}</em>
													</div>
														
													<div class="price-line">
														<em id="goodDiscountPrice${itemNum}" class="J_Price price-now" tabindex="0">${shopCartItem.good.goodDiscountPrice}</em>
													</div>
										</div>
									</div>
								</li>
								<li class="td td-amount">
									<div class="amount-wrapper ">
										<div class="item-amount ">
											<div class="sl" style="position: relative; top:25px; left:7px">
												<input class="min am-btn" name="" type="button" value="-" onclick="changeGood(-1,${itemNum});"/>
											 <input readonly="on" name="count" class="text_box" id="countStr${itemNum}" type="text" onchange="countChange(${itemNum});" value="${shopCartItem.count}" style="width: 30px; text-align: center;" /> 
												<input class="add am-btn" name="" type="button" value="+" onclick="changeGood(1,${itemNum});" />
										
											</div>
										</div>
									</div>
								</li>
								<li class="td td-sum">
									<div class="td-inner" style="position: relative; top:30px; left:6px">
										<em id="itemprice${itemNum}" tabindex="0" class="J_ItemSum number" ><fmt:formatNumber value="${shopCartItem.money}" pattern="#.00"/></em>
									</div>
								</li>
								<li class="td td-op">
									<div class="td-inner" style="position: relative; top:30px; left:47px; width: 50px; height: 20px">
									<a href="#" style=" width:20px;height:10px " data-point-url="#" class="delete" onclick="return deleteItem(${itemNum},${shopCartItem.good.goodId});"> <span style="border: solid 6px red; border-radius:7px; background-color:red;  width:20px;height:10px;color:white;">删除</span></a>
									</div>
								</li>
							    <!-- 作为参数传递给外界 -->
							    <input type="hidden" name="goodId" value="${shopCartItem.good.goodId}"/>
							    
							    <!--点击提交时，将所选的商品id和其数量， 作为参数传给后端 -->
							    <input id="payId${itemNum}" type="hidden" name="goodIdNoChoice" value="${shopCartItem.good.goodId}"/>
							    <input id="payCount${itemNum}" type="hidden" name="countNoChoice" value="0"/>
							    
							</ul>
							
							   
							    
							    
							</c:forEach>
						</div>
					</div>
				</tr>
		</div>
		<div class="clear"></div>

		<div class="float-bar-wrapper">
		   
		            <div class="btn-area" style="position: relative; left:514px; border-radius:7px;">
					   <a href="#" id="J_Go" class="submit-btn submit-btn-disabled"
						aria-label="" onclick="return saveCar();"> <span>保存购物车</span></a>
				    </div>
				 
		        
			<div class="float-bar-right">
			    
				<div class="amount-sum">
					<span class="txt">已选商品</span> <em id="getnum"></em><span
						class="txt">
						<span id="goodAllSize">0</span>
						件</span>
					<div class="arrow-box">
						<span class="selected-items-arrow"></span> <span class="arrow"></span>
					</div>
				</div>
				<div class="price-sum">
					<span class="txt">合计:</span> 
					<strong class="price">
					¥<em id="J_Total"></em>
					<span id="allPrice">0.00</span>
				   </strong>
				</div>
				<div class="btn-area" style="border-radius:7px;">
					<a href="#" id="J_Go" onclick="return goPay();" class="submit-btn submit-btn-disabled"
						aria-label="请注意如果没有选择宝贝，将无法结算"> <span>结&nbsp;算</span></a>
					
				</div>
				
			</div>

		</div>

		<div class="footer">
			<div class="footer-hd">
				<p>
					<a href="#">恒望科技</a> <b>|</b> <a href="${pageContext.request.contextPath}/shopcar/goToMain">商城首页</a> <b>|</b> <a
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
	               <div id="disappare" style="display:none; border:3px solid #ccc;border-radius: 7px;background: #fff;font-size: 35px;
                                        width: 309px;height: 110px; position: relative;top:-304px; left:765px;">
						 <h2 style="color: #B79">温馨提示：</h2>
					     <p style="position:relative;top:18px;left:2px;
					          color: #B79; text-align: center;">您还没有选择要提交的商品哦</p>
				   </div>
	
	</form>

	<!--操作页面-->

	<div class="theme-popover-mask"></div>

	<div class="theme-popover">
		<div class="theme-span"></div>
		<div class="theme-poptit h-title">
			<a href="javascript:;" title="关闭" class="close">×</a>
		</div>
		<div class="theme-popbod dform">
			<form class="theme-signin" name="loginform" action="" method="post">

				<div class="theme-signin-left">

					<li class="theme-options">
						<div class="cart-title">颜色：</div>
						<ul>
							<li class="sku-line selected">12#川南玛瑙<i></i></li>
							<li class="sku-line">10#蜜橘色+17#樱花粉<i></i></li>
						</ul>
					</li>
					<li class="theme-options">
						<div class="cart-title">包装：</div>
						<ul>
							<li class="sku-line selected">包装：裸装<i></i></li>
							<li class="sku-line">两支手袋装（送彩带）<i></i></li>
						</ul>
					</li>
					<div class="theme-options">
						<div class="cart-title number">数量</div>
						<dd>
							<input class="min am-btn am-btn-default" name="" type="button" value="-" />
							 <input class="text_box" name="" type="text" value="1" style="width: 30px;" />
							  <input class="add am-btn am-btn-default" name="" type="button" value="+" /> 
							  <span class="tb-hidden">库存<span class="stock">1000</span>件
							</span>
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
						<img src="${pageContext.request.contextPath}/images/kouhong.jpg_80x80.jpg" />
					</div>
					<div class="text-info">
						<span class="J_Price price-now">¥39.00</span> <span id="Stock"
							class="tb-hidden">库存<span class="stock">1000</span>件
						</span>
					</div>
				</div>

			</form>
		</div>
	</div>
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
   function getAllPrice(){
	   
	   
   }
   function deleteItem(itemNum,goodId){
	   //ajax请求后台在redis中删除该用户该goodId的商品
	   //同时将本页面的该item消失
	   //alert("itemNum:"+itemNum+"---goodId"+goodId);
	   $.get("${pageContext.request.contextPath}/shopcar/removeOneCarItem?goodId="+goodId,function(data,status){
		
		   if(status == 'success'){
			   if(data == 'removeOK'){
				   //得到该购物项的多选框
				   var state = $("#check"+itemNum).prop("name");
				   if(state == 'before'){
					
				   }else{
					   //数量的改变
					   var removeSize = $("#countStr"+itemNum).val();
					   var oldAllSize = $("#goodAllSize").text();
					   $("#goodAllSize").text(numDec(oldAllSize,removeSize));
					   //总价的改变
					   var removePrice = $("#itemprice"+itemNum).text();
					   var oldAllPrice = $("#allPrice").text();
					   $("#allPrice").text(numDec(oldAllPrice,removePrice).toFixed(2));
				   }
				   //改变上面购物车的数字
				   var oldCarSize = $("#nowCarSize").text();
				   $("#nowCarSize").text(numDec(oldCarSize,1));  
				   //将其删除
		           $("#item"+itemNum).remove();  
			   }   
		   }   
	   });
	   return false;
   }
   
   
   //购物项点击加减后调用的函数
   function changeGood(changeNum,itemNum){
     //在此方法中要执行的操作
     //根据点击按钮不同给id为countStr${itemNum}的value进行加减一操作
     //该项的总价，整个car的总价，整个car的商品数量
      var state = $("#check"+itemNum).prop("name");
     if(state == "after"){
    	 var oldItemNum = $("#countStr"+itemNum).val();
         var goodNums = $("#goodNums"+itemNum).text();
         var nowItemNum = numAdd(Number(oldItemNum),Number(changeNum));
         if(nowItemNum>=1 && nowItemNum<=goodNums){
        	 $("#nomore").text("");
        	  $("#countStr"+itemNum).val(nowItemNum);
        	  //获取该商品的卖价
       	      var goodDiscountPrice = $("#goodDiscountPrice"+itemNum).text();
        	  //改变该项的总价
        	  var itemPrice = $("#itemprice"+itemNum).text();
        	  //设置改变后的单项总价
        	  $("#itemprice"+itemNum).text(numAdd(Number(itemPrice),(numMul(Number(goodDiscountPrice),Number(changeNum)))).toFixed(2));
        	  //获取购物车原先的总价
        	  var oldAllPrice = $("#allPrice").text();
    		  $("#allPrice").text(numAdd(Number(oldAllPrice),(numMul(Number(goodDiscountPrice),Number(changeNum)))).toFixed(2));
        	  //改变购物车商品总数
    		  var oldAllSize = $("#goodAllSize").text();
    		  $("#goodAllSize").text(numAdd(Number(oldAllSize),Number(changeNum))); 
         } 
     } 
   }
   
   
   
   //购物项商品数改变执行的函数
   function countChange(itemNum){
	   //获取购物车之前的总数
	     var oldAllSize = $("#goodAllSize").text();
	   //获取该商品的库存
	   var goodNums = $("#goodNums"+itemNum).text();
	  //获取该商品的卖价
	   var goodDiscountPrice = $("#goodDiscountPrice"+itemNum).text();
	   //获取之前它的总价
	   var itemPrice = $("#itemprice"+itemNum).text();
	   //计算之前它的数量
	   var oldCount = numDiv(itemPrice,goodDiscountPrice);
	  
	   //得到它现在的数量
	   var nowCount =Number($("#countStr"+itemNum).val());
	   //得到购物车的原总价
	   var oldAllPrice = $("#allPrice").text();
	   //如果改变后的值小于0
	   if(nowCount<0){  
		   $("#nomore").text("好歹还是买点呀喂！");
		   $("#countStr"+itemNum).val(oldCount);  
	   }else if(nowCount>goodNums){
		   $("#nomore").text("没这么多货，兄弟");
		   $("#countStr"+itemNum).val(oldCount); 
	   }else{
		   //合法的改变，开始更新各值
		   $("#nomore").text("");
		   //更新该项商品总价
		   var nowItemPrice = numDec(itemPrice,(numMul(goodDiscountPrice,numDec(oldCount,nowCount))));
		   
		   $("#itemprice"+itemNum).text(nowItemPrice.toFixed(2));
		   //更新购物车商品总数
		   var nowAllCount = numDec(Number(oldAllSize),numDec(oldCount,nowCount));
		   $("#goodAllSize").text(nowAllCount);
		   //更新购物车总价
		   var nowAllPrice = numDec(oldAllPrice,(numMul(goodDiscountPrice,numDec(oldCount,nowCount))));
		   $("#allPrice").text(nowAllPrice.toFixed(2));   
	   } 
   }
   
   function saveCar(){
	   
        //强制使form表单提交
        $("#carForm").submit();
        return false;
	   
   }
   
   function beCheck(itemNum){
	   //得到多选框
	   var checkbox = $("#check"+itemNum);
	   var numInput = $("#countStr"+itemNum);
	   var state = $("#check"+itemNum).prop("name");
	   //改变各参数：商品总数，商品总价
	   //获取购物车之前的总数
	     var oldAllSize = Number($("#goodAllSize").text());
	   //得到购物车的原总价
	   
		 var oldAllPrice = Number($("#allPrice").text());
		
	   //获得被点击该项的商品数
		 var oldItemNum = Number($("#countStr"+itemNum).val());
	   //获得被点击项的商品总价
	     var itemPrice = Number($("#itemprice"+itemNum).text());
	    
	   //alert("name:"+state);
	   if(state == 'after'){
		   $("#item"+itemNum).css("background-color","white");
		   $("#item"+itemNum).css("border","1px solid rgb(287, 236, 120)");
		   $("#check"+itemNum).prop("name","before");
		   //设置购物车总数
		   $("#goodAllSize").text(numDec(oldAllSize,oldItemNum));
		   //设置购物车总价
		   $("#allPrice").text(numDec(oldAllPrice,itemPrice).toFixed(2)); 
		   //设置为不可改
		   numInput.prop("readonly","on");
		   //设置为不选中
		   checkbox.prop("checked","");
	   }else{
		   $("#item"+itemNum).css("background-color","rgb(241, 259, 194)");
		   $("#item"+itemNum).css("border","1px solid rgb(255, 206, 228)");
		   $("#check"+itemNum).prop("name","after");
		   //设置购物车总数
		   $("#goodAllSize").text(numAdd(oldAllSize,oldItemNum));
		   //设置购物车总价
		   $("#allPrice").text(numAdd(oldAllPrice,itemPrice).toFixed(2));
		 //设置为可改
		   numInput.prop("readonly","");
		 //设置为选中
		   checkbox.prop("checked","true");
		 
	   }  
   }
   
   //提交购物车
   function goPay(){
   //获取当前所选总数目
  
   var nowAllSize =  $("#goodAllSize").text();
   if(nowAllSize == 0){
	  /*  alert("客官，您一件商品都还没选呢，确定要提交？"); */
	  $("#disappare").fadeIn(500).delay(2000).fadeOut(500);
   }else{
	  //遍历每一个购物项，如是被选中的，则将其数量和总价加到 我们的隐藏input中
	  var num = Number(${itemNum});
	  for(i=1; i<=num; i++){
		 //取出该物品的checkbox
		  var state = $("#check"+i).prop("name");
		 if(state == 'after'){
			 //表示该商品被选中，得到该商品的总数
			 var itemCount = Number($("#countStr"+i).val());
			 //将被选项的隐藏表单中payId项的name改变
			 $("#payId"+i).prop("name","payId");
			 //得到原先的payCount值
			 var hideCount = Number($("#payCount"+i).val());
			 //重置payCount的name
			 $("#payCount"+i).prop("name","payCount");
			 $("#payCount"+i).val(itemCount);
		 }  
	  }   
	  //强制使form表单提交
	   $("#carForm").attr("action","${pageContext.request.contextPath}/shopcar/goPay.action");
	   $("#carForm").submit();
   }
  
   return false;
  }
 </script>
</html>