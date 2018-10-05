<%@page import="com.qf.shopping.dto.OrderDto"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />
</head>

<body class="main">
	<jsp:include page="${pageContext.request.contextPath}/jsp/head.jsp" />
	<jsp:include page="${pageContext.request.contextPath}/jsp/menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="25%"><table width="100%" border="0" cellspacing="0"
						style="margin-top:30px">
						<tr>
							<td class="listtitle">我的帐户</td>
						</tr>
						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath}/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath}/jsp/modifyuserinfo.jsp">用户信息修改</a>
							</td>
						</tr>

						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath}/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="showorder">订单查询</a>
							</td>
						</tr>
						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath}/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="#">用戶退出</a></td>
						</tr>
















					</table>
				</td>
				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath}/jsp/index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath}/jsp/myAccount.jsp">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单查询
					</div>





					<table cellspacing="0" class="infocontent">
						<tr>
							<td style="padding:20px"><p>欢迎xxx光临商城！</p>
								<p>
									您有<font style="color:#FF0000">xx</font>个订单
								</p>
								<table width="100%" border="0" cellspacing="0" class="tableopen">
									<tr>
										<td bgcolor="#A3E6DF" class="tableopentd01">序号</td>
										<td bgcolor="#A3D7E6" class="tableopentd01">收件人</td>
										<td bgcolor="#A3CCE6" class="tableopentd01">订单时间</td>
										<td bgcolor="#A3B6E6" class="tableopentd01">状态</td>
										<td bgcolor="#A3E2E6" class="tableopentd01">操作</td>
									</tr>


									<%
									List<OrderDto> orders=(List<OrderDto>)request.getAttribute("orders");
									for(int i=0;i<orders.size();i++){
										OrderDto order=orders.get(i);
										String payState=order.getState();
										
										out.print("<tr><td class='tableopentd02'>"+(i+1)+"</td>");
										out.print("<td class='tableopentd02'>"+order.getOrderShPeople()+"</td>");
										out.print("<td class='tableopentd02'>"+order.getOrderTime()+"</td>");
										out.print("<td class='tableopentd02'>"+payState+"</td>");
										out.print("<td class='tableopentd03'><a href='showorderbyid?id="+order.getOrderId()+"'>查看</a>&nbsp;&nbsp;");
										out.print("<a href='delorderbyid?id="+order.getOrderId()+"'>刪除</a></td></tr>");
									}
									%>
									
										
										
										
										
									
									
									
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="${pageContext.request.contextPath}/images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" />
				</td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a>
				</td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; eShop All Rights RESERVED.</b> </font>
				</td>
			</tr>
		</table>
	</div>


</body>
</html>
