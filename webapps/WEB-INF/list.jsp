<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理系统</title>

</head>
<body>

	
	欢迎${sessionScope.USER_IN_SESSION.name}
	<a href="${pageContext.request.contextPath}/logout">注销登录</a>
	<h3 align="left">商品列表123</h3>  
	<form action="/product" method="post">
			<input type="hidden" name="currentPage" value="1" id="currentPageId"/>
			商品名称: <input type="text" name="productName"  value="${po.productName }" />
			零售价:  <input type = "number" min="0" name="minSalePrice" value="${po.minSalePrice}"/>
			到   <input type="number" min="0"  name="maxSalePrice" value=" ${po.maxSalePrice}"/>
			<input type = "submit" value= "点击查询"/>
			
	
	</form>

	<a href="${pageContext.request.contextPath}/add">增加商品</a>  
	${sessionScope.STATU_IN_SESSION}<% request.getSession().removeAttribute("STATU_IN_SESSION");%>
	<table border="1" cellpadding="0" cellspacing="0" width="70%">
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
			<tr style='background: ${vs.count%2==0?"gray":""}'>
				<td>${s.id}</td>
				<td>${s.productName}</td>
				<td>${s.brand}</td>
				<td>${s.supplier}</td>
				<td>${s.salePrice}</td>
				<td>${s.costPrice}</td>
				<td>${s.cutoff}</td>
				<td>${s.dir_id}</td>
				<th><a href="${pageContext.request.contextPath}/product?method=delete&id=${s.id}">删除</a>| <a
					href="${pageContext.request.contextPath}/product?method=find&id=${s.id}">更新</a></th>
			</tr>
		</c:forEach>
		<jsp:include page="/WEB-INF/views/page.jsp"></jsp:include>
		

	</table>
</body>
</html>