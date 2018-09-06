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
	$(function(){
		$("#gfId").change(function(){
			if($("#gfId").val() == 0){
				$("#gsId").html("<option value='0'>无</option>");
			}else {
				$.ajax({
					type:"get",
					url:"${pageContext.request.contextPath}/goods/findSecondTypesBygfId.action",
					data:"gfId="+$("#gfId").val(),
					async:true,
					success:function(data){
						data = JSON.parse(data);
						var str = "<option value='0'>无</option>";
						$.each(data,function(index,goodsType){
							str += "<option value='"+goodsType.id+"'>"+goodsType.goodsTypeName+"</option>";
						})
						$("#gsId").html(str);
					}
				})
			}
		})
	})
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
    
    <div class="formtitle"><span>修改商品信息</span></div>
    <form method="post" action="${pageContext.request.contextPath}/goods/updateGood.action?pageNo=${pageNo}" enctype="multipart/form-data">
    	<input type="hidden" name="gId" value="${good.gId}"/>
    	<ul class="forminfo">
	    <li><label>商品名称</label><input name="gName" value="${good.gName}"  type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
	    <li><label>所属大类</label>
	    	<select name="gfId" id="gfId">
	    		<option value="0">无</option>
	    		 <c:forEach items="${goodFirstTypes}" var="goodsType">
    			    		<c:choose>
    			    			<c:when test="${good.goodSecondType.goodFirstType.gfId == goodsType.gfId}">
    			    				<option value="${goodsType.gfId}" selected="selected">${goodsType.gfName}</option>
    			    			</c:when>
    			    			<c:otherwise>
    			    				<option value="${goodsType.gfId}">${goodsType.gfName}</option>
    			    			</c:otherwise>
    			    		</c:choose>
    			    </c:forEach>
	    	</select>
	    </i></li>
	    <li><label>所属小类</label>
	    	<select name="gsId" id="gsId">
	    	<option value="0">无</option>
	    		 <c:forEach items="${goodSecondTypes}" var="goodSecondType">
    			    		<c:choose>
    			    			<c:when test="${good.goodSecondType.gsId == goodSecondType.gsId}">
    			    				<option value="${goodSecondType.gsId}" selected="selected">${goodSecondType.gsName}</option>
    			    			</c:when>
    			    			<c:otherwise>
    			    				<option value="${goodSecondType.gsId}">${goodSecondType.gsName}</option>
    			    			</c:otherwise>
    			    		</c:choose>
    			    </c:forEach>
	    	</select>
	    </i></li>
	    <li><label>商品原价</label><input name="gyPrice" type="text" class="dfinput" value="${good.gyPrice}"/></li>  
	    <li><label>商品现价</label><input name="gcPrice" type="text" class="dfinput" value="${good.gcPrice}"/></li>
	    <li><label>店铺优惠</label><input name="gDiscount" type="text" class="dfinput" value="${good.gDiscount}"/></li>
	    <li><label>商品库存</label><input name="gNum" type="text" class="dfinput" value="${good.gNum}"/></li>
	    <li><label>锁定库存的数量</label><input name="gLNum" type="text" class="dfinput" value="${good.gLNum}"/></li>
	    <li><label>预警数量</label><input name="gewNum" type="text" class="dfinput" value="${good.gewNum}"/></li>
	    
	    
	    <li><label>商品图片</label>
	     	<img id="img" src="${pageContext.request.contextPath}/images/${good.gPhoto}" width="100px" height="100px" />
	     	<input name="file" type="file"  onchange="loadimg(this)"/>
	     	<input type="hidden" name="gPhoto" value="${good.gPhoto}" />
	     	<input type="hidden" name="gms" value="${good.gms}" />
	     	<input type="hidden" name="gams" value="${good.gams}" />
	     	<input type="hidden" name="version" value="${good.version}" />
	     	
	    </li>
	    <li><label>商品描述</label><textarea rows="8" cols="40" name="gDes"  >${good.gDes}</textarea><i>标题不能超过30个字符</i></li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    
    </form>
    </div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

