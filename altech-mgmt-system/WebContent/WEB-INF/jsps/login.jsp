<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/src/css/main.css" type="text/css" rel="stylesheet" "/>
<link href="${pageContext.request.contextPath}/src/css/login.css" type="text/css" rel="stylesheet" "/>
<title>Login page</title>
</head>
<body onload='document.f.j_username.focus();'>

	<div id="container">
	    <header id="hd">
	        <img src="${pageContext.request.contextPath}/src/img/hdAlmaxx.png" width="800"></a>
	    </header>
	    <nav id="nav">
	        <ul>
	            <li id="btn"><a href="${pageContext.request.contextPath}/">Home</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/clock">Clock IN/OUT</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/payroll">Payroll</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/hollidays">Hollidays</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/msg">Messanger</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/users">Users</a></li>
	        </ul>
	    </nav>
	    
	    <div id="body">
	        <div id="mainsection">
	    	
	    		<header id="hdrTitle">Login to the system here:</header>
	    		
	    		<div id="login">
	    			<header id="hLog">Login</header>
	    			<div id="logNotes">
	    				<p>Password must contain both numbers and letters and must be between
	    				8 and 16 characters.</p>
	    			</div>
	    			<section id="sLog">
	    				<form name='f' method="post" action='${pageContext.request.contextPath}/j_spring_security_check'>
		    				<label class="lblLog" id="email">Username:</label>
		    				<input class="txtLog" type="text" name="j_username"/></br>
		    				<label class="lblLog" id="password">Password:</label>
		    				<input class="txtLog" type="password" name="j_password""/></br>
		    				
		    				<!-- ::::::ERROR (USERNAME OR PASSWORD IS NOT CORRECT):::::: -->
		    				<c:if test="${param.error != null }">
		    					<div id="loginError">
		    						<img alt="error" src="${pageContext.request.contextPath}/src/img/error_20.png">
		    						<span>Username or password is not correct.</span>
		    					</div>
		    				</c:if>
		    				
		    				<div id="logBtns">
		    					<input type="submit" name="submit" value="Login" />
		    				</div>
	    				</form>
	    			</section>
	    		</div>
	        	
	        </div>
	    </div>
	    
	    <footer id="mainFooter">
	    	<div id="ftrRights">
	    		<span>© 2016 Altech Technology. All Rights Reserved.</span>
	    	</div>
	    	<div id="ftrAddress">
	    		<p>Email: service@altech.com</p>
	    		<p>Tel: (+353) 91 123456</p>
	    		<p>Address:</p>
	    		
	    		<div id="address">
	    			<p>GMIT</p>
	    			<p>Old Dublin Road</p>
	    			<p>Galway, Republic of Ireland</p>
	    		</div>
	    	</div>
	    </footer>
	</div>
</body>
</html>