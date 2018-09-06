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
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	
	function loadimg(obj) {
		var file = obj.files[0];//获得上传文件组件里的文件对象
		var url = window.URL.createObjectURL(file);//创建文件对象的URL地址
		document.getElementById("img").src = url;//给img标签设置URL地址
	}
</script>
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
    
    <div class="formtitle"><span>修改广告信息</span></div>
    <form method="post" action="${pageContext.request.contextPath}/ads/updateAd.action?pageNo=${pageNo}" enctype="multipart/form-data">
    	<input type="hidden" name="adId" value="${ad.adId}"/>
    	<ul class="forminfo">
	    <li><label>广告类型</label><input name="adType" value="${ad.adType}"  type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
	   
	    
	    <li><label>商品图片</label>
	     	<img id="img" src="${pageContext.request.contextPath}/images/${ad.adUrl}" width="100px" height="100px" />
	     	<input name="file" type="file"  onchange="loadimg(this)"/>
	    </li>
	  
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    
    </form>
    </div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

