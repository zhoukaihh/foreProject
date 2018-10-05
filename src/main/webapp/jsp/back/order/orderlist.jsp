<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css" />
<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="css/personal.css" rel="stylesheet" type="text/css" />
<link href="css/orstyle.css" rel="stylesheet" type="text/css" />
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
					href="/jsp/back/user/adduser.jsp">添加</a></li>
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
						<div class="order-top">
							<div class="th th-item">
								<td class="td-inner">订单</td>
							</div>
					        <div style="position: relative; left:263px;" class="th th-amount">
								<td class="td-inner">合计</td>
							</div>
							<div style="position: relative; left:280px;" class="th th-status">
								<td class="td-inner">交易状态</td>
							</div>
							<div style="position: relative; left:280px;" class="th th-status">
								<td class="td-inner">交易操作</td>
							</div> 
						</div>

						<div class="order-main">							

								<div class="order-list">
									<!--交易成功。-->
								<c:forEach items="${orders}" var="order">
									<div class="order-status5">
										
										<div class="order-title">
											<div class="dd-num">
												订单编号：<a href="javascript:;">${order.orderNum}</a>
												
											</div>
											
											<span>成交时间：${order.orderTime}</span>
										</div>
										<div class="order-content">
											<div class="order-left">
												<ul class="item-list">
													<li class="td td-item">
														<div class="item-pic">
															<a href="#" class="J_MakePoint"> <img src="${pageContext.request.contextPath}/shoppingImages/no-img_mid_.jpg"
																class="itempic J_ItemImg"></img>
															</a>
														</div>
														<div class="item-info">
															<div class="item-basic-info">
																<a href="#">
																	<p>Id为："${order.user.id}"</p>
																	<p>用户名为："${order.user.loginName}"</p>
																   <p>一条订单记录，详情请点击“订单详情”</p>
																</a>
															</div>
														</div>
													</li>
					
													<li class="td td-operation">
														<div class="item-operation"></div>
													</li>
												</ul>
											</div>
											<div class="order-right">
												<li class="td td-amount">
													<div class="item-amount">合计：${order.orderTotalMoney}</div>
												</li>
												<div class="move-right">
													<li class="td td-status">
														<div class="item-status">
															<p class="Mystatus">交易成功</p>
															<p class="order-info">
																<a href="${pageContext.request.contextPath}/orders/findOrderById?orderId=${order.orderId}&flag=show">订单详情</a>
															</p>
														</div>
													</li>
												</div>
											</div>
										</div>
									</div>
	        			</c:forEach>
					</div>
				

					<div style="text-align: center;">
						<div
							style="height: 20px; width: 160px; position: relative; top: 36px; left: 520px";">
							<a
								href="${pageContext.request.contextPath}/orders/list?pageNo=1"
								style="text-decoration: none">首页</a>
							<c:if test="${currentpage>1}">
								<a
									href="${pageContext.request.contextPath}/orders/list?pageNo=${currentpage-1}"
									style="text-decoration: none">上一页</a>
							</c:if>
							<c:if test="${currentpage < allPage}">
								<a
									href="${pageContext.request.contextPath}/orders/list?pageNo=${currentpage+1}"
									style="text-decoration: none">下一页</a>
							</c:if>
							<a
								href="${pageContext.request.contextPath}/orders/list?pageNo=${allPage}"
								style="text-decoration: none">尾页</a>
						</div>
					</div>
					<span style="width: 160px; height: 20px; position: relative; left: 743px; top: 16px">
						第${currentpage}页&nbsp;&nbsp;|&nbsp;&nbsp;共${allPage}页</span>

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
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
