<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>"/>
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
        <li><span><a href="${pageContext.request.contextPath}/goodTypes/findGoodFirstTypeAll.action"/><img src="images/t01.png" /></span>添加</a></li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><a href="${pageContext.request.contextPath}/back/charts/goodstypecharts.jsp"><span><img src="images/t04.png" /></span>统计</a></li>
        </ul>
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
	    	<tr>
	        <th>商品类别编号<i class="sort"><img src="images/px.gif" /></i></th>
	        <th>商品类别名称</th>
	        <th>父类编号</th>
	        <th>父类名称</th>
	        <th>操作</th>
	        </tr>
        </thead>
        <c:forEach items="${scTypes}" var="goodsType">
        <tbody>
       			<tr>
			        <td>${goodsType.secondTypeId}</td>
			        <td>${goodsType.secondTypeName}</td>
			        <td>${goodsType.firstType.firstTypeId}</td>
			        <td>${goodsType.firstType.firstTypeName}</td>
			        <td>
			        	<a href="${pageContext.request.contextPath}/goodTypes/findGoodSecondType.action?secondTypeId=${goodsType.secondTypeId}">编辑</a> |
			        	<a href="${pageContext.request.contextPath}/goodTypes/deleteGoodSecondType.action?secondTypeId=${goodsType.secondTypeId}&pageNo=${currentpage}">删除</a>
			        </td>
		        </tr> 
        </tbody>
        </c:forEach>
        <div style="text-align: center;">
              <div style="height:20px; width:160px; position:absolute; top:417px; left:623px">
	    		<a href="${pageContext.request.contextPath}/goodTypes/list?pageNo=1" style="text-decoration: none">首页</a>
				<c:if test="${currentpage>1}">
					<a href="${pageContext.request.contextPath}/goodTypes/list?pageNo=${currentpage-1}" style="text-decoration: none">上一页</a>
				</c:if>
				
				<c:if test="${currentpage < allPage}">
					<a href="${pageContext.request.contextPath}/goodTypes/list?pageNo=${currentpage+1}" style="text-decoration: none">下一页</a>
				</c:if>
				<a href="${pageContext.request.contextPath}/goodTypes/list?pageNo=${allPage}" style="text-decoration: none">尾页</a>
        	    </div>
        	    <span style=" width:80px; height:20px; position:absolute; left:818px; top:417px">第${currentpage}页&nbsp;&nbsp;|&nbsp;&nbsp;共${allPage}页</span>
        	</div>
    </table>
    
   
 
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

