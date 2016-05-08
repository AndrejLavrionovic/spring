<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/src/css/main.css" type="text/css" rel="stylesheet" "/>
<link href="${pageContext.request.contextPath}/src/css/home.css" type="text/css" rel="stylesheet" "/>
<link href="${pageContext.request.contextPath}/src/css/error.css" type="text/css" rel="stylesheet" "/>
<title>Insert title here</title>
</head>
<body>

	
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
	            <sec:authorize access="hasRole('hr')">
	            	<li id="btn"><a href="${pageContext.request.contextPath}/users">Users</a></li>
	            </sec:authorize>
	        </ul>
	    </nav>
	    
	    <div id="timebar">
	    	<div id="datetime"></div>
	    	<sec:authorize access="!isAuthenticated()">
	    		
	    		<div id="blockLogin">
	    			<span>You are not signed in!</span>
	    			<a href="${pageContext.request.contextPath}/login">Sign in</a>
	    		</div>
	    	</sec:authorize>
	    	<sec:authorize access="isAuthenticated()">
	    		<div id="blockWelcome">
		    		<span>Welcome User.</span>
	    		</div>
		    	<div id="blockLogout">
		    		<sf:form method="post" action="${pageContext.request.contextPath}/j_spring_security_logout">
		    			<input class="btnLogout" type="submit" value="Logout" />
		    		</sf:form>
		    	</div>
	    	</sec:authorize>
	    	
	    </div>
	    
	    <div id="body">
	        <div id="mainsection">
	    	
	    		<header id="hdrTitle" style="color: red">Error:</header>
	    		
	    		<div id="errorDiv">
	    			<header id="hError">Datebase Access Error:</header>
	    			<div id="ErrorNote">
	    				<p>Database Access is denied. The entered value might be not valid.</p>
	    			</div>
	    		</div>
	        </div>
	    </div>
	    
	    <footer id="mainFooter">
	    	<div id="ftrRights">
	    		<span>� 2016 Altech Technology. All Rights Reserved.</span>
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
	
	<script src="${pageContext.request.contextPath}/src/js/showdate.js"></script>

</body>
</html>