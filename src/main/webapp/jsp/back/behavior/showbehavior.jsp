<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/mycss/showSearch.css" type="text/css"/>

<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">




$(document).ready(function(){	
	
  $(".click").click(function(){
  $(".tip").fadeIn(2000);
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
					<th>用户行为编号</th>
					<th>操作时间</th>
					<th>操作详情</th>
					<th>操作人</th>
					<th>处理</th>

				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach items="${behaviors}" var="behaviour">
					<tr>
						<td>${behaviour.behaviorId}</td>
						<td><fmt:formatDate value="${behaviour.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						
						<td>${behaviour.behavior}</td>
						<td>${behaviour.user.loginName}</td>
						<td>
							<a href="${pageContext.request.contextPath}/behaviours/deleteBehaviourById.action?behaviorId=${behaviour.behaviorId}&pageNo=${currentpage}"
							class="tablelink"> 删除</a></td>
					</tr>
				</c:forEach>
				<%-- <div style="text-align: center;height:50px; width: 400px;">
					<div
						style="height: 20px; width: 160px; position: absolute; top: 616px; left: 623px";">
						<a href="${pageContext.request.contextPath}/behaviour/list?pageNo=1"
							style="text-decoration: none">首页</a>
						<c:if test="${currentpage>1}">
							<a
								href="${pageContext.request.contextPath}/behaviour/list?pageNo=${currentpage-1}"
								style="text-decoration: none">上一页</a>
						</c:if>
						<c:if test="${currentpage < allPage}">
							<a
								href="${pageContext.request.contextPath}/behaviour/list?pageNo=${currentpage+1}"
								style="text-decoration: none">下一页</a>
						</c:if>
						<a
							href="${pageContext.request.contextPath}/behaviour/list?pageNo=${allPage}"
							style="text-decoration: none">尾页</a>
					</div>
					
				</div> 
				<span
					style="width: 100px; height: 20px; position: absolute; left: 818px; top: 616px">第${currentpage}页&nbsp;&nbsp;|&nbsp;&nbsp;共${allPage}页</span>
			    --%>
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
    
   




    <!-- 这是页码框框 也属于商品展示的模块-->
          <div id="pageDiv">
             <div id="choiceJump">
             
             
             
                 <!-- 普通按钮 -->
                 <b id="pageNum">
                 <!-- 判断上一页是否能点 -->
                       <c:if test="${currentpage<2}">
                             <b class="goPagePrev">上一页</b>
                       </c:if>
                       <c:if test="${currentpage>1}">
                             <a href="${pageContext.request.contextPath}/behaviour/list?pageNo=${currentpage-1}" class="goPagePrev">上一页</a>
                       </c:if>   
                       
                          
                          
                          
                     <c:if test="${currentpage<7}">
                         <!--  这里就是中间的页数了，逻辑:生成从第一页到当前页的所有按钮（定义一个变量，判断是否等于当前页，每生成一个加一） -->
                           <c:forEach var="nowNum" begin="1" step="1" end="${(currentpage-1)}">
                           <!-- 生成一个该页的a标签 -->
                           <a href="${pageContext.request.contextPath}/behaviour/list?pageNo=${nowNum}" class="goPagePrev">${nowNum}</a>
                            </c:forEach>
                     </c:if>
                      
                    <c:if test="${currentpage>=7}">
                        <!--    当当前页数大于7后，就不会在从第一页到当前页一页一页按钮展示，只展示第一二页，后面... 再展示当前页前面两页 -->
                         <a href="${pageContext.request.contextPath}/behaviour/list?pageNo=1" class="goPagePrev">1</a>
                          <a href="${pageContext.request.contextPath}/behaviour/list?pageNo=2" class="goPagePrev">2</a>
                          <span style="float: left;height: 100%;width: 30px;margin-top: 13px;">. . .</span>
                           <a href="${pageContext.request.contextPath}/behaviour/list?pageNo=${currentpage-2}" class="goPagePrev">${(currentpage-2)}</a>
                          <a href="${pageContext.request.contextPath}/behaviour/list?pageNo=${currentpage-1}" class="goPagePrev">${(currentpage-1)}</a>
                     </c:if>
                    
                    
                    
                    
                   <!--      生成当前页的按钮 -->
                        <b class="nowPage">${currentpage}</b>
                      <!--   生成当前页之后两页的按钮（如果有的话） -->
                      <c:if test="${(currentpage+1)<=allPage}">
                          <a href="${pageContext.request.contextPath}/behaviour/list?pageNo=${currentpage+1}" class="goPagePrev">${(currentpage+1)}</a>
                      </c:if>
                      <c:if test="${(currentpage+2)<=allPage}">
                          <a href="${pageContext.request.contextPath}/behaviour/list?pageNo=${currentpage+2}" class="goPagePrev">${(currentpage+2)}</a>
                      </c:if>
                      <!-- 如果后面还有，输出”...“ -->
                      <c:if test="${(currentpage+3)<=allPage}">
                         <span style="float: left;height: 100%;width: 30px;margin-top: 13px;">. . .</span>
                      </c:if>
                      
                      
                      
                      <c:if test="${currentpage==allPage}">
                            <b class="goPagePrev">下一页>></b>
                      </c:if>
                      <c:if test="${currentpage<allPage}">
                            <a href="${pageContext.request.contextPath}/behaviour/list?pageNo=${currentpage+1}" class="goPagePrev">下一页>></a>
                      </c:if>
                  </b>
                 
                 
                 
                 
                 <!--  直接跳转 -->
                 <b id="pageSkip">
                      <form id="goPageForm" style="font-weight: 400;" action="${pageContext.request.contextPath}/behaviour/list" method="post">
                          <!-- 用户点击跳到多少页 -->
                           <input type="hidden" name="searchInfo" value="${searchInfo}"/>
                                                                                           共有${allPage}页，到第
                           <input class="goPageNoInput" id="goPageNo" type="text" name="pageNo"/>
                                                                                            页
                           <button class="myButton" onclick="goPage();">确定</button>
                      </form>
                 </b>
             </div>
              
              
          </div>     
</div>

<%-- 
	<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	 function goPage(){
		   /* 用户自己输入页数，点击button后的点击事件 */
		   //获得用户输入的值，判断合法性，大于最大页就跳到最大页，
		   //小于最小页就跳到最小页
		   //不是数字也跳到最小页
		   var pageNo = Number($("#goPageNo").val());
		   if(pageNo<1){
			   $("#goPageNo").val(1)
		   }else if(${allPage}<pageNo){
			   alert("pageNo>allPage");
			   $("#goPageNo").val(${allPage})
		   }
		   //提交该form表单
		   $("#goPageForm").submit();  
	   }
	</script>--%>



	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>
