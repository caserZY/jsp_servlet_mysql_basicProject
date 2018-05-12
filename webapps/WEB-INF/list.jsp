<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
                        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
                        url += request.getContextPath();
                        url += request.getServletPath();
                        url += request.getQueryString() == null ? "" : ("?" + request.getQueryString());
                        //System.out.println(request.getRequestURI());
                        //System.out.println(request.getRequestURL());
                         %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理系统</title>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" />
</head>
<body style="margin: 20px 100px;">


	欢迎${sessionScope.USER_IN_SESSION.name}
	<a href="${pageContext.request.contextPath}/logout">注销登录</a>
	<h3 align="left">商品列表123</h3>
	<form action="/productServlet?action=list" method="post">
		<input type="hidden" name="currentPage" value="1" id="currentPageId" />
		商品名称: <input class="btn btn-default btn-xs" type="text"
			name="productName" value="${po.productName }" /> 零售价: <input
			class="btn btn-default btn-xs" type="number" min="0"
			name="minSalePrice" value="${po.minSalePrice}" /> 到 <input
			class="btn btn-default btn-xs" type="number" min="0"
			name="maxSalePrice" value=" ${po.maxSalePrice}" />
		<sapn class="glyphicon glyphicon-search"></sapn>
		<!-- <input class="btn btn-default btn-xs " type="submit" value= "点击查询"/> -->
		<input class="glyphicon glyphicon-search" type="submit" value="" />

	</form>

	<a href="${pageContext.request.contextPath}/productServlet?action=createToken">增加商品</a>
	${sessionScope.STATU_IN_SESSION}<%
		request.getSession().removeAttribute("STATU_IN_SESSION");
	%>
	<!-- 	   <table border="1" cellpadding="0" cellspacing="0" width="70%"> -->

	<table class="table table-striped table-bordered table-hover">

		<tr>
			<th>商品id</th>
			<th>商品名称</th>
			<th>品牌</th>
			<th>供应商</th>
			<th>零售价</th>
			<th>进货价</th>
			<th>折扣</th>
			<th>分类Id</th>
			<th>功能</th>
		</tr>



		<c:forEach items="${products.pageListData}" var="s" varStatus="vs">
			<tr <%-- style='background: ${vs.count%2==0?"gray":""} --%>'>
				<td>${s.id}</td>
				<td>${s.productName}</td>
				<td>${s.brand}</td>
				<td>${s.supplier}</td>
				<td>${s.salePrice}</td>
				<td>${s.costPrice}</td>
				<td>${s.cutoff}</td>
				<td>${s.dir_id}</td>
				<th><a class="btn btn-link"
					href="${pageContext.request.contextPath}/productServlet?action=delete&id=${s.id}">删除</a>|
					<a class="btn btn-link"
					href="${pageContext.request.contextPath}/productServlet?action=find&id=${s.id}">更新</a></th>
			</tr>
		</c:forEach>






		


	</table>
	<jsp:include page="/WEB-INF/views/page.jsp"></jsp:include>
	
	<script src="../bootstrap/js/jquery.min.js"></script>
	<script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>