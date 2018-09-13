<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<script src="${pageContext.request.contextPath}/js/echarts.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>

		<div id="main" style="width: 600px; height: 400px;">

		</div>

		<script type="text/javascript">
			//获取documnet对象
			var docObj = document.getElementById('main');
			//初始化
			var myChart = echarts.init(docObj);
			//设置数据了
			myChart.setOption({
				title: {
					text: '商品类别及子类数目'
				},
				tooltip: {},
				legend: {
					data: ['商品类别']
				},
				xAxis: {
					data: []
				},
				yAxis: {},
				series: [{
					name: '商品类别',
					type: 'bar',
					data: []
				}]
			});
			//下面就要通过异步请求来获取服务器的数据了
			$.get("${pageContext.request.contextPath}/echarts/getSecondSizeFromFirst.action", function(data, state, ajax) {
				data=JSON.parse(data);
				// 填入数据
				myChart.setOption({
					xAxis: {
						data: data.categories
					},
					series: [{
						// 根据名字对应到相应的系列
						name: '商品类别',
						data: data.data
					}]
				});
			})
		</script>

	</body>

</html>