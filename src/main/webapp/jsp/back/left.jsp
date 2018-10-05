<%@page import="java.util.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.auth.com" prefix="auth"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span>通讯录
	</div>

	<dl class="leftmenu">

		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /></span>管理信息
			</div>
			<ul class="menuson">
				<auth:hasRole token="${loginType}" role="admin">
					<li><cite></cite><a
						href="${pageContext.request.contextPath}/roles/list"
						target="rightFrame">角色管理</a><i></i></li>
					<li><cite></cite><a
						href="${pageContext.request.contextPath}/permitions/list"
						target="rightFrame">权限管理</a><i></i></li>
					<li><cite></cite><a
						href="${pageContext.request.contextPath}/users/list"
						target="rightFrame">用户管理</a><i></i></li>
				</auth:hasRole>
				<li class="active"><cite></cite><a
					href="${pageContext.request.contextPath}/goodTypes/list?pageNo=1" target="rightFrame">商品类别管理</a><i></i></li>
				<li><cite></cite><a
					href="${pageContext.request.contextPath}/goods/list?pageNo=1" target="rightFrame">商品管理</a><i></i></li>
				<li><cite></cite><a
					href="${pageContext.request.contextPath}/ads/list?pageNo=1" target="rightFrame">广告管理</a><i></i></li>
				<li><cite></cite><a href="${pageContext.request.contextPath}/orders/list?pageNo=1" target="rightFrame">订单管理</a><i></i></li>
				<li><cite></cite><a
					href="${pageContext.request.contextPath}/behaviour/list?pageNo=1" target="rightFrame">角色行为查看</a><i></i></li>
				<li><cite></cite><a
					href="GoodsInfoServlet?action=goodsInfoList" target="rightFrame">系统管理</a><i></i></li>
				
			</ul>
		</dd>
</body>
</html>
