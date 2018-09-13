<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="UTF-8">
		<title>权限的修改</title>
		<style type="text/css">
			* {
				margin: 0px;
				padding: 0px;
			}
			
			body {
				background: #D3D3D3;
			}
			
			form {
				border-radius: 10px;
				margin: 0 auto;
				position: relative;
				top: 150px;
				padding: 20px;
			}
			
			input {
				border-radius: 5px;
				margin-left: 1px;
			}
		</style>
	</head>

	<body>

		<form method="post" action="${pageContext.request.contextPath}/permitions/update" style="width: 400px;height: 400px;background: #FFFFE0;">
			权限的名字:<input name="perName" type="text" value="${perm.perName}" style="margin-top: 50px;" /><br />
			资源的名字:<input type="text" name="resName" value="${perm.resName}"><br>
			资源的路径:<input type="text" name="path" value="${perm.path}"><br>
			<input type="submit" name="" id="" value="修改权限" style="float: right;margin-top: 20px;width: 100px;height: 25px;" />
		</form>

	</body>

</html>