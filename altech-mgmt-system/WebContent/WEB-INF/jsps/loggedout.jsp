<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/main.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/loggedout.css">
<title>Logged out.</title>
</head>
<body>

<!-- ::::::::::::::::::::::::MAIN CONTAINER:::::::::::::::::::::::::: -->
	<div id="container">
	
		<!-- ::::::::::::::::: TOP IMAGE :::::::::::::::::: -->
	    <header id="hd">
	        <img src="${pageContext.request.contextPath}/src/img/hdAlmaxx.png" width="800"></a>
	    </header>
	    
	    <!-- :::::::::::::::::: NAVIGATION ::::::::::::::::: -->
	    <nav id="nav">
	        <ul>
	            <li id="btn"><a href="${pageContext.request.contextPath}/">Home</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/">Clock IN/OUT</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/">Payroll</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/">Hollidays</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/">Messanger</a></li>
	            <sec:authorize access="hasAnyRole('hr', 'admin')">
	            	<li id="btn"><a href="${pageContext.request.contextPath}/users">Users</a></li>
	            </sec:authorize>
	        </ul>
	    </nav>
	    
	    <div id="body">
	    	<section id="mainsection">
	    	
	    		<div id="msgblock">
	    			<header id="hloggedout">Logging out:</header>
	    			<div id="loggedoutNote">
	    				<p>You've being successfully logged out.</p>
	    			</div>
	    		</div>
	    	
	    	</section>
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