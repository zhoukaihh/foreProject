<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<div class="hmtop">
			<!--顶部导航条 -->
			<div class="am-container header">
				<ul class="message-l">
					<div class="topMessage">
						<div class="menu-hd">
						
							<a href="login.jsp" target="_top" class="h">${realuser.loginName},欢迎您！</a>
						 
						  <%--  <c:if test="${user != null}"></c:if> --%>
							<%-- <a href="${pageContext.request.contextPath}/login.jsp" target="_top" class="h">亲，请登录！</a>
							<a href="${pageContext.request.contextPath}/register.jsp" target="_top">免费注册</a>  --%>
						</div>
					</div>
				</ul>
				<ul class="message-r">
					<div class="topMessage home">
						<div class="menu-hd">
							<a href="${pageContext.request.contextPath}/shopcar/goToMain" target="_top" class="h">商城首页</a>
						</div>
					</div>
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng">
							<a href="" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>&nbsp;&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath}/orders/findUserOrdersAll.action">我的订单</a>
						</div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd">
							<a id="mc-menu-hd" href="${pageContext.request.contextPath}/shopcar/showCar.action" target="_top">
								<i class="am-icon-shopping-cart  am-icon-fw"></i>
								<span>购物车</span>
								<strong id="J_MiniCartNum" class="h">
								<span id="nowCarSize">${carsize}<span/>
								</strong>
							</a>
						</div>
					</div>
						<div class="topMessage my-shangcheng">
						<div class="menu-hd">
							<a href="${pageContext.request.contextPath}/collection.jsp" target="_top">
								<i class="am-icon-heart am-icon-fw"></i>
								<span><a href="${pageContext.request.contextPath}/go/goawaybefore.action">注销帐户</a></span>
							</a>
						</div>
				</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logo"><img src="" /></div>
					<div class="logoBig">
						<li><img src="${pageContext.request.contextPath}/images/indexlogo.png" /></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form action="${pageContext.request.contextPath}/goods/searchGoods" method="post">
						    <input id="pageNo" type="hidden" name="pageNo" value="1">
							<input id="searchInput" name="searchInfo" type="text" placeholder="搜索" autocomplete="off">
							<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>
		