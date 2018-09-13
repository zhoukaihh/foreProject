<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8" />
<title>角色用户统计</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<!--写个div容器，盛放图表-->
	<div id="container" style="width: 600px; height: 400px;"></div>

	<script type="text/javascript">
	window.onload = function() {
		var echarts = echarts.init(document.getElementById("container"));
		echarts.setOption({
			 backgroundColor: '#D3D3D3',
			title : {
		        text: '用户角色详情',
		        subtext: '饼状图',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
			series : [ {
				name : '（用户身份：人数）',
				type : 'pie',
				radius : '55%',
			    roseType : 'angle', 
				data : []
			} ]
		}
		);
		 $.get("${pageContext.request.contextPath}/users/roleNums",function(data,state,ajax){
			 console.log(data);
			 echarts.setOption(
			 	{
			 		series : [{
			 		  data : data.items
			 		
			 		}]
			 	}
			 );	
               });
	}
	</script>



</body>
</html>
