<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">表单</a></li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>地址信息修改</span>
		</div>
		<form
			action="${pageContext.request.contextPath}/orders/updateorder"
			method="post">
			<input type="hidden" name="orderId" value="${order.orderId}" />
			 <input type="hidden" name="orderNum" value="${order.orderNum}" />
			<input type="hidden" name="orderTotalMoney" value="${order.orderTotalMoney}" /> 

			
			<ul class="forminfo">
				<li><label>收货人</label><input name="orderShPeople" type="text"
					class="dfinput" value="${order.orderShPeople}" /></li>
				<li><label>联系电话</label><input name="oderShTel" type="text"
					class="dfinput" value="${order.oderShTel}" /></li>
				<li><label>付款方式</label><input name="orderPayType" type="text"
					class="dfinput" value="${order.orderPayType}" /></li>
				<li><label>收货地址</label><input name="orderShAddress" type="text"
					class="dfinput" value="${order.orderShAddress}" /></li>
                <li><label>快递方式</label><input name="orderSendType" type="text"
					class="dfinput" value="${order.orderSendType}" /></li>
				<li><input name="" type="submit" class="btn" value="确认保存" /></li>
			
			</ul>
		</form>
	</div>
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>

