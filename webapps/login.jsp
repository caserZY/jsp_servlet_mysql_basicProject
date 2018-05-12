<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<title>登录</title>
<style type="text/css">
body {
	min-width: 420px;
	margin: 0;
	padding: 0;
	background-position: center center;
	background-size: cover;
	background-repeat: no-repeat;
	background-color: #28353E;
	box-shadow: inset 0 -36px 15px -10px #28353E;
	background-image:
		url( ${pageContext.request.contextPath}/backImage?filename=xxx.jpg );
	background-size: cover;
	background-repeat: no-repeat;
	background-color: #28353E;
	box-shadow: inset 0 -36px 15px -10px #28353E;
}

#emailLabel{box-sizing: border-box;
font-family: "Open Sans", sans-serif;
font-size: 16px;
margin-bottom: 20px;
margin-left: 0px;
margin-right: 0px;
margin-top: 30px;
text-align: center;
color: rgb(255, 255, 255);

}
</style>
<script type="text/javascript">
	function change() {
		var imgEl = document.getElementById("randomCodeImg");
		imgEl.src = "${pageContext.request.contextPath}/randomcode?"
				+ new Date().getTime();
	}
</script>
</head>
<body>

 	<c:if test="${! empty sessionScope.USER_IN_SESSION}">
		<jsp:forward page="${pageContext.request.contextPath}/productServlet?action=list"></jsp:forward></c:if>
 



	<!--  判断是否有Sessionn,有就直接跳转,没有就需要登录 -->

	<span style="color: red"> ${ErrorMsg}</span>


	<div style="padding: 100px 100px 10px;" class="container text-center">
		
		 <div id="emailLabel">       <p>Let's get started with your email</p>     </div>  
		 
		<form style="padding: 10px 100px 10px;"
			class="bs-example bs-example-form " role="form"
			action="${pageContext.request.contextPath}/login" method="post">
			
			<div style="margin: 0 auto;" class="input-group text-center">
				<!-- <span  class="input-group-addon">@</span>  -->
				<!-- <button class="btn btn-default">账号</button> -->
				<input class="btn btn-default btn-lg " type="text" name="username"
					value="<c:if test='${!empty USERNAME_IN_SESSION}'>${USERNAME_IN_SESSION}</c:if>"
					placeholder="username/email" required /><br />
			</div>
			<br>
			<div style="margin: 0 auto;" class="input-group text-center ">
				<!-- <span class="input-group-addon">&nbsp $ </span>  -->
				<!-- <button class="btn btn-default">密码</button> -->
				<!-- <div class="input-group-addon">密码</div> -->
				<input class="btn btn-default  btn-lg" type="password" name="password"
					value="<c:if test='${!empty PASSWORD_IN_SESSION}'>${PASSWORD_IN_SESSION}</c:if>"
					placeholder="password" required /><br />
			</div>
			<br>
			<div style="margin: 0 auto;" class="input-group text-center ">
				<input class="btn btn-default btn-lg" type="text" name="randomcode"
					placeholder="验证码" required size="5" maxlength="5" /> <img class="img-rounded "
					style="margin: auto;" alt="验证码" title="看不清,换下!"
					id="randomCodeImg" onclick="change();" style="cursor: pointer;"
					src="${pageContext.request.contextPath}/randomcode">
			</div>
			<!--  -->
			<div style="margin: 10px auto 0 auto;" class="input-group">
				<input
					style="background-color: rgb(175, 8, 6); color: rgb(255, 255, 255);"
					class="btn btn-default" type="submit" name="randomcode" value="登录"
					size="5" maxlength="5" />
			</div>

		</form>
	</div>

	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>