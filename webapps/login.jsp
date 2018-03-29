<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
    <style type="text/css">
    body {
           margin:0;
           padding:0;
           text-align: center;
          background-image:url( ${pageContext.request.contextPath}/backImage?filename=xxx.jpg );
    }
    #first{
        margin :80px;
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
		<jsp:forward page="${pageContext.request.contextPath}/product"></jsp:forward></c:if>
    
	<div id="first">
		

		<!--  判断是否有Sessionn,有就直接跳转,没有就需要登录 -->
    
		<span style="color: red"> ${ErrorMsg}</span>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<input style="margin-bottom: 5px" type="text" name="username"
				value="<c:if test='${!empty USERNAME_IN_SESSION}'>${USERNAME_IN_SESSION}</c:if>"
				placeholder="用户名/邮箱" required /><br /> <input style="margin-bottom: 5px" type="password"
				name="password"
				value="<c:if test='${!empty PASSWORD_IN_SESSION}'>${PASSWORD_IN_SESSION}</c:if>"
				placeholder="密码" required /><br />

			<div>
				<div id="randomcodeinput">
					<input  type="text" name="randomcode" placeholder="验证码" required
						size="5" maxlength="5" />
				</div>
				<div id="randomcode">
					<img  alt="验证码"
						title="看不清,换下张!" id="randomCodeImg" onclick="change();"
						style="cursor: pointer;"
						src="${pageContext.request.contextPath}/randomcode">

				</div>
			</div>

			<input type="submit" value="登录" />

		</form>
	</div>
</body>
</html>