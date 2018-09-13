<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="UTF-8">
		<title>角色管理</title>

		<style type="text/css">
			body {
				background: #D3D3D3;
			}
			
			table {
				border-collapse: collapse;
				width: 500px;
				text-align: center;
				margin-top: 150px;
			}
			#addRole{
				width: 100px;
				height: 30px;
				display:inline-block;
				border:1px solid blue;
				text-align: center;
				line-height: 30px;
				border-radius: 5px;
				margin: 5px;
				text-decoration: none;
			}
		</style>
	</head>

	<body>

		<a href="${pageContext.request.contextPath}/jsp/back/menu/permAdd.jsp">权限添加</a>
		<div id="roleShow">
			<table border="1" cellspacing="" cellpadding="" align="center">
				<tr>
					<th>权限的id</th>
					<th>权限的名字</th>
					<th>权限的描述</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${perms}" var="perm">
				<tr>
					<td>${perm.perId}</td>
					<td>${perm.perName}</td>
					<td>${perm.perDes}</td>
					<td>
					    <!--构建一个修改数据的路径-->
					    <c:url var="update" value="/permitions/update">
					       <!--下面就构建这个路劲上锁需要的数据-->
					       <c:param name="permId" value="${perm.perId}"></c:param>
					    </c:url>
					    <!--构建一个删除数据的路径-->
					    <c:url var="delete" value="/permitions/delete">
					       <!--下面就构建这个路劲上锁需要的数据-->
					       <c:param name="permId" value="${perm.perId}"></c:param>
					    </c:url>
					
						<a href="${update}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="${delete}">删除</a>
					</td>
				</tr>
				</c:forEach>

			</table>
		</div>

	</body>

</html>