
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title> Main </title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index.css">
		
	</head> 
	
	<body id="body">
		<div id="templateForm">
			
			<div id="btn-group"> 
				<button type="button" id="SignInBtn" onclick="window.location.href = '${pageContext.request.contextPath}/showSignInPage'"> Sign In </button>
				<button type="button" id="SignUpBtn" onclick="window.location.href = '${pageContext.request.contextPath}/showSignUpPage'"> Sign Up </button>
			</div>
			
			<div id="SignIn">
				<form>
					<input type="text" placeholder="username*"/>
					<br>
					<input type="text" placeholder="password*"/>
					<br>
					<button type="submit" id="submit"> Login </button>
				</form>
			</div>		
		</div>
		
		
		<script src="${pageContext.request.contextPath}/resources/js/index.js">		</script>
	</body>
</html>
