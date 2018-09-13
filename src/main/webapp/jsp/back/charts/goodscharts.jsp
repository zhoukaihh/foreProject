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
			//获取documnet对象并初始化echarts
			var myCharts1 = echarts.init(document.getElementById('main'));
			//设置数据了
			var Option({
				title: {
					text: '价格区间和商品种类'
				},
				tooltip: {},
				legend: {
					data: ['商品种类']
				},
				xAxis: {
					data: []
				},
				yAxis: {},
				series: [{
					name: '商品种类',
					type: 'bar',
					data: []
				}]
			});
			myCharts1.setOption(option);
			//下面就要通过异步请求来获取服务器的数据了
			$.get("${pageContext.request.contextPath}/echarts/getGoodsNumByPrice.action", function(data, state, ajax) {
				data=JSON.parse(data);
				// 填入数据
				myChart.setOption({
					xAxis: {
						data: data.categories
					},
					series: [{
						// 根据名字对应到相应的系列
						name: '商品种类',
						data: data.data
					}]
				});
			});
		</script>

	</body>

</html>