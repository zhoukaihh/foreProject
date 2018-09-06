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
			<span>编辑用户信息</span>
		</div>
		<form
			action="${pageContext.request.contextPath}/users/updateUser.action"
			method="post">
			<input type="hidden" name="uId" value="${user.uId}" /> <input
				type="hidden" name="state" value="${user.state}" />
			<ul class="forminfo">
				<li><label>用户名</label><input name="userLoginName" type="text"
					class="dfinput" value="${user.userLoginName}" /></li>
				<li><label>密码</label><input name="userPwd" type="text"
					class="dfinput" value="${user.userPwd}" /></li>
				<li><label>Phone</label><input name="telphone" type="text"
					class="dfinput" value="${user.telphone}" /></li>
				<li><label>Email</label><input name="email" type="text"
					class="dfinput" value="${user.email}" /></li>

				<li><label>性别</label> <select name="sex" class="dfinput">
						<option value="null"
							<c:if test="${user.userLoginName eq 'null'}">selected="selected"</c:if>>请选择</option>
						<option value="男"
							<c:if test="${user.userLoginName eq '男'}">selected="selected"</c:if>>男</option>
						<option value="女"
							<c:if test="${user.userLoginName eq '女'}">selected="selected"</c:if>>女</option>
				</select></li>

				<li><c:if test="${loginType=='admin'}">
						<label>角色</label>
						<select name="roleName" class="dfinput">
							<option value="admin"
								<c:if test="${identity eq 'admin'}">selected="selected"</c:if>>管理员</option>
							<option value="seller"
								<c:if test="${identity eq 'seller'}">selected="selected"</c:if>>店铺主</option>
							<option value="vip"
								<c:if test="${identity eq 'vip'}">selected="selected"</c:if>>普通客官</option>
						</select>
					</c:if>
			  </li> &nbsp;
				</label>
				<input name="" type="submit" class="btn" value="确认保存" />
				</li>
			</ul>
		</form>
	</div>
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>

