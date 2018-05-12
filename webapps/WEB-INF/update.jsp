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
	<form action="${pageContext.request.contextPath}/productServlet?action=update"
		method="post">
		<table>
			<tr>
				<td>商品id</td>
				<td><input type="text" name="id" value=${product.id }
					readonly="readonly" /></td>

			</tr>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="productName"
					value=${product.productName } /></td>
			</tr>
			<tr>
				<td>品牌</td>
				<td><input type="text" name="brand" value=${product.brand } /></td>
			</tr>
			<tr>
				<td>供应商</td>
				<td><input type="text" name="supplier"
					value=${product.supplier } /></td>
			</tr>
			<tr>
				<td>零售价</td>
				<td><input type="text" name="salePrice"
					value=${product.salePrice } /></td>
			</tr>
			<tr>
				<td>进货价</td>
				<td><input type="text" name="costPrice"
					value=${product.costPrice } /></td>
			</tr>
			<tr>
				<td>折扣</td>
				<td><input type="text" name="cutoff" value=${product.cutoff } /></td>
			</tr>
			<tr>
				<td>分类Id</td>
				<td><input type="text" name="dir_id" value=${product.dir_id } /></td>
			</tr>
			<tr>
				<td align="center" colspan="8"><input type="submit" value="更新" /></td>
			</tr>


		</table>

	</form>


</body>
</html>