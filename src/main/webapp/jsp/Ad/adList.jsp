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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">




$(document).ready(function(){	
	
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>

</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据表</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
	</div>

	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<li class="click"><a href="${pageContext.request.contextPath}/back/Ad/adadd.jsp"><img
						src="images/t01.png" align="middle" />添加</a></li>
				<li class="click"><span><img src="images/t02.png" /></span>修改</li>
				<li><span><img src="images/t03.png" /></span>删除</li>
				<li><span><img src="images/t04.png" /></span>统计</li>
			</ul>


			<ul class="toolbar1">
				<li><span><img src="images/t05.png" /></span>设置</li>
			</ul>

		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th>广告编号</th>
					<th>广告类型</th>
					<th>图片详情</th>
					<th>添加时间</th>
					<th>操作</th>

				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach items="${ads}" var="ad">
					<tr>
						<td>${ad.adId}</td>
						<td>${ad.adType}</td>
						
						<td align="center"><img src="${pageContext.request.contextPath}/images/${ad.adUrl}"
							style="width: 120px; height: 90px;" align="middle" /></td>
						<td>${ad.adType}</td>
						<td><a
							href="${pageContext.request.contextPath}/ads/findAdById.action?adId=${ad.adId}&pageNo=${currentpage}"
							class="tablelink">编辑</a> <a
							href="${pageContext.request.contextPath}/ads/deleteAdById.action?adId=${ad.adId}&pageNo=${currentpage}"
							class="tablelink"> 删除</a></td>
					</tr>
				</c:forEach>
				<div style="text-align: center;">
					<div
						style="height: 20px; width: 160px; position: absolute; top: 616px; left: 623px";">
						<a href="${pageContext.request.contextPath}/ads/findAdsByPage.action?pageNo=1"
							style="text-decoration: none">首页</a>
						<c:if test="${currentpage>1}">
							<a
								href="${pageContext.request.contextPath}/ads/findAdsByPage.action?pageNo=${currentpage-1}"
								style="text-decoration: none">上一页</a>
						</c:if>
						<c:if test="${currentpage < allPage}">
							<a
								href="${pageContext.request.contextPath}/ads/findAdsByPage.action?pageNo=${currentpage+1}"
								style="text-decoration: none">下一页</a>
						</c:if>
						<a
							href="${pageContext.request.contextPath}/ads/findAdsByPage.action?pageNo=${allPage}"
							style="text-decoration: none">尾页</a>
					</div>
				</div>
				<span
					style="width: 80px; height: 20px; position: absolute; left: 818px; top: 616px">第${currentpage}页&nbsp;&nbsp;|&nbsp;&nbsp;共${allPage}页</span>
			</tbody>
		</table>


		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>

		</div>

	</div>

	<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>



	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>
