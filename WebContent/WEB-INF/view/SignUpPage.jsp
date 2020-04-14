
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
			
			<div id="SignUp">
				<form:form action="saveUser" modelAttribute="user" method="POST">
					<table>
						<tr>
							<td>
								<form:input path="firstName" placeholder="firstName*"/>
								<br>
								<form:errors path="firstName" cssClass="error"/>
							</td>
						
							<td> <input type="text" name="lastName" placeholder="LastName*"/>
								<br>
								<form:errors path="lastName" cssClass="error"/>
						 	</td>
						</tr>
						<tr>
							<td> <input type="text" name="email" placeholder="email*"/>
									<br>
								<form:errors path="email" cssClass="error"/>
							
							</td>
							<td> 
								<select class="input" name="country" id="countries">
									<option value="0" disabled selected>Select Country:</option>
									<c:forEach var="temp" items="${countries}">
										<option value="${temp}">${temp}</option>
									</c:forEach>
								</select>								
								<br>
								<form:errors path="country" cssClass="error"/>
						</td>
						</tr>
						<tr>
							<td> <input type="text" name="username" placeholder="username*"/>															
								<br>
								<form:errors path="username" cssClass="error"/>
							</td>
							
							<td> <input type="password" name="password" placeholder="password*"/>								
								<br>
								<form:errors path="password" cssClass="error"/>
							</td>
						</tr>
						<tr>
	
						</tr>
					
					</table>
					
					<label for="ManagerLbl">Manager</label>	
					<label for="Customer">Employee</label>
					<br>		
					<input type="radio" id="Manager" name="role" class="radioBtn" value="Manager"/>
					
					<input type="radio" id="Customer" name="role" class="radioBtn" value="Employee"/>
  					<br>
  					<form:errors path="role" cssClass="error"/>
					
					<br>
					<input type="submit" id="submit" value="Submit"/>
				</form:form>
			</div>
			
		</div>
		
		
		<script src="${pageContext.request.contextPath}/resources/js/index.js">		</script>
	</body>
</html>
