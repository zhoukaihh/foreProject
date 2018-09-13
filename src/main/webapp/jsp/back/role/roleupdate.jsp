<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="UTF-8">
		<title>角色修改</title>
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
	    <script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript" charset="utf-8"></script>
		  <script type="text/javascript">
	    	$(document).ready(function(){
	    		//发送ajax请求到服务器获取所有的权限
	    		$.get("${pageContxt.request.contextPath}/permitions/getAll",function(data,state,ajax){
	    			if("success"==state){  //说明请求成功
	    				var jsonArray=data;
	    				//[{},{},{}]
	    				for (var i=0;i<jsonArray.length;i++) {
	    				   var jsonObj=jsonArray[i];
	    				   //假设你要进行判定
	    				  console.log(jsonObj);
	    				   //生成input标签
	    				   $('#role').append(jsonObj.perName+":<input type='checkbox' name='ids' value='"+jsonObj.perId+"'><br />");
	    				}
	    			}
	    		})
	    	});
	    </script>
	</head>

	<body>


		<form method="post" action="${pageContext.request.contextPath}/roles/update" style="width: 400px;height: 400px;background: #FFFFE0;">
			<!--使用影藏域来完成id的传递-->
			<input type="hidden" name="id" value="${role.id}">
			角色的名字:<input name="name" type="text" value="${role.name}" style="margin-top: 50px;" /><br />
			角色的描述:<input name="des" type="text" value="${role.des}" style="margin-top: 50px;" /><br />
			选择色权限:<div id="role" style="margin-top: 10px;">
			</div>
			<input type="submit" name="" id="" value="修改角色" style="float: right;margin-top: 20px;width: 100px;height: 25px;" />
		</form>

	</body>

</html>