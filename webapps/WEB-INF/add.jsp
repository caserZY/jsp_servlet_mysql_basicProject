<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/product?method=add"
		method="post">
		<input type="hidden" name="token" value="${token}" />
		<table>
			<tr>

				<td>商品名称</td>
				<td><input type="text" name="productName" required="required" /></td>
			</tr>
			<tr>
				<td>品牌</td>
				<td><input type="text" name="brand" required="required" /></td>
			</tr>
			<tr>
				<td>供应商</td>
				<td><input type="text" name="supplier" required="required" /></td>
			</tr>
			<tr>
				<td>零售价</td>
				<td><input type="text" name="salePrice" required="required" /></td>
			</tr>
			<tr>
				<td>进货价</td>
				<td><input type="text" name="costPrice" required="required" /></td>
			</tr>
			<tr>
				<td>折扣</td>
				<td><input type="text" name="cutoff" required="required" /></td>
			</tr>
			<tr>
				<td>分类Id</td>
				<td><input type="text" name="dir_id" required="required" /></td>
			</tr>
			<tr>
				<td align="center" colspan="8"><input type="submit" value="更新" /></td>
			</tr>


		</table>

	</form>




</body>
</html>