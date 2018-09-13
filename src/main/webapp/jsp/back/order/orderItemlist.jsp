<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css" />
<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="css/personal.css" rel="stylesheet" type="text/css" />
<link href="css/orstyle.css" rel="stylesheet" type="text/css" />
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/mycss/showSearch.css" type="text/css"/>

<script src="AmazeUI-2.4.2/assets/js/jquery.min.js" />
<script src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据表</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">

			<ul class="toolbar">
				<li class="click"><span><img src="images/t01.png" /></span><a
					href="back/user/adduser.jsp">添加</a></li>
				<li class="click"><span><img src="images/t02.png" /></span>修改</li>
				<li><span><img src="images/t03.png" /></span>删除</li>
				<li><span><img src="images/t04.png" /></span>统计</li>
			</ul>

			<ul class="toolbar1">
				<li><span><img src="images/t05.png" /></span>设置</li>
			</ul>
		</div>
		<div class="center">
			<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>
				<div class="am-tabs-bd">
					<div class="am-tab-panel am-fade am-in am-active" id="tab1">
						<div class="order-title">
							<div style="max-width: 550px; position: relative;top:0px;left:10px;width:406px;" class="dd-num">
								订单编号：<a href="javascript:;">${order.orderNum}</a>
								&nbsp;&nbsp;${order.user.loginName}
							</div>
							<span>成交时间：</span>${order.orderTime}
						</div>
						<table class="tablelist">
							<thead>
								<tr>
									<th>收货人</th>
									<th>联系电话</th>
									<th>付款方式</th>
									<th>收货地址</th>
									<th>快递方式</th>
								</tr>
							</thead>
							<tbody>
							<tr>
								<td>${order.orderShPeople}</td>
								<td>${order.oderShTel}</td>
								<td>${order.orderPayType}</td>
								<td>${order.orderShAddress}</td>
								<td>${order.orderSendType}</td>
							</tr>
							</tbody>
							<div style="text-align: center; background-color:#dd514c; width:72px; height:28px; border:2px solid #dd514c; border-radius:5px; position: relative; top:115px; left:729px;"><a href="${pageContext.request.contextPath}/orders/findOrderById?orderId=${order.orderId}&flag=editAddress">修改地址</a></div>
						</table>
						<hr />
						<br />
						<br />
						<br />
						<br />
						<br />
						<div class="order-top">
							<div class="th th-item">
								<td class="td-inner">商品</td>
							</div>
							<div class="th th-price">
								<td class="td-inner">单价（元）</td>
							</div>
							<div class="th th-number">
								<td class="td-inner">数量</td>
							</div>
							<div class="th th-operation">
								<td class="td-inner">商品操作</td>
							</div>
							<div class="th th-amount">
								<td class="td-inner">合计</td>
							</div>
							<div class="th th-status">
								<td class="td-inner">交易状态</td>
							</div>
							<div class="th th-change">
								<td class="td-inner">交易操作</td>
							</div>
						</div>

						<div class="order-main">
							<div class="order-list">
								<!--交易成功。-->
								<div class="order-status5">


									<c:forEach items="${order.orderItems}" var="orderItem">
										<div class="order-content">
											<div class="order-left">
												<ul class="item-list">
													<li class="td td-item">
														<div class="item-pic">
															<a href="#" class="J_MakePoint"> <img
																src="${pageContext.request.contextPath}/images/${orderItem.goodImage}"
																class="itempic J_ItemImg"></img>
															</a>
														</div>
														<div class="item-info">
															<div class="item-basic-info">
																<a href="#">
																	<p>${orderItem.goodName} (${orderItem.goodDes})</p>
																</a>
															</div>
														</div>
													</li>
													<li class="td td-price">
														<div class="item-price"><p>${orderItem.goodPrice}<p>
														</div>
													</li>
													<li class="td td-number">
														<div class="item-number">
															<span>×${orderItem.goodNums}</span> 
														</div>
													</li>
													<li class="td td-operation">
														<div class="item-operation"></div>
													</li>
												</ul>
											</div>
											<div class="order-right">
												<li class="td td-amount">
													<div class="item-amount">合计：${orderItem.goodNums*orderItem.goodPrice}</div>
												</li>
												<div class="move-right">
													<li class="td td-status">
														<div class="item-status">
															<p class="Mystatus">交易成功</p>

														</div>
													</li>
													<li class="td td-change">
														<div class="am-btn am-btn-danger anniu"><a href="${pageContext.request.contextPath}/orderItems/deleteOrderItemById.action?orderItemId=${orderItem.orderItemId}&orderId=${order.orderId}">删除</a></div>
													</li>
												</div>
											</div>
										</div>
									</c:forEach>

								</div>
							</div>

						</div>

					</div>



					<div class="tip">
						<div class="tiptop">
							<span>提示信息</span><a></a>
						</div>

						<div class="tipinfo">
							<span><img src="images/ticon.png" /></span>
							<div class="tipright">
								<p>是否确认对信息的修改 ？</p>
								<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
							</div>
						</div>

						<div class="tipbtn">
							<input name="" type="button" class="sure" value="确定" />&nbsp; <input
								name="" type="button" class="cancel" value="取消" />
						</div>

					</div>
				</div>

				<script type="text/javascript">
					$('.tablelist tbody tr:odd').addClass('odd');
				</script>
</body>
</html>
