<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="UTF-8">
		<title>角色添加</title>
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
	    			console.log(state)
	    			if("success"==state){  //说明请求成功
	    				console.log(data)
	    				var jsonArray=data;
	    				//[{},{},{}]
	    				for (var i=0;i<jsonArray.length;i++) {
	    				   var jsonObj=jsonArray[i];
	    				   //生成input标签
	    				   $('#role').append(jsonObj.perName+":<input type='checkbox' name='ids' value='"+jsonObj.perId+"'><br />");
	    				}
	    			}
	    		})
	    	});
	    </script>
	</head>

	<body>

		<form method="post" action="${pageContext.request.contextPath}/roles/create" 
		style="width: 400px;height: 380px;background: #FFFFE0;">
			角色的名字:<input name="name" type="text" style="margin-top: 50px;" /><br />
			角色的描述:<input name="des" type="text" style="margin-top: 50px;" /><br />
			<div id="role" style="margin-top: 10px">
			</div>
			
			<input type="submit" name="" id="" value="确认添加" style="margin-top: 20px;width: 100px;height: 25px;" />
			
			
		    <input type="reset" value="重置" style="margin-top: 50px;width: 100px;height: 25px;"/>
			
			<input type="button" onclick='location.href=("${pageContext.request.contextPath}/roles/list")'
			  style="margin-top: 80px;width: 100px;height: 25px;" value="取消操作">
			

		</form>

	</body>

</html>