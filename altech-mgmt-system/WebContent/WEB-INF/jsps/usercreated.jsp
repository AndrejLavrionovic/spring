<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/user.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/main.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/userCreated.css">
<title>User created</title>
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
	            <sec:authorize access="hasRole('hr')">
	            	<li id="btn"><a href="${pageContext.request.contextPath}/users">Users</a></li>
	            </sec:authorize>
	        </ul>
	    </nav>
	    
	    <div id="timebar">
	    	<sec:authorize access="isAuthenticated()">
		    	<div id="blockLogout">
		    		<sf:form method="post" action="${pageContext.request.contextPath}/j_spring_security_logout">
		    			<input class="btnLogout" type="submit" value="Logout" />
		    		</sf:form>
		    	</div>
	    	</sec:authorize>
	    	</div>
	    </div>
	    
	    
	    <div id="wrapper">
	    
	    	<aside id="mainAside">
	    		<ul>
	    			<li class="sideNav"><a href="${pageContext.request.contextPath}/users">Find User</a>
	    			<li class="sideNav"><a href="${pageContext.request.contextPath}/create">Create User</a>
	    		</ul>
	    	</aside>
	    	
	    	<section id="mainSection">
	    	
	    	<header id="hdrTitle">Well done:</header>
	    		
	    		<!-- :::::::::::::::::::::: USER CREATED ::::::::::::::::::::: -->
	    		
	    		<div id="usercreated">
	    			<header id="hcreated">Congratulations:</header>
	    			<div id="createdNote">
	    				<p>New user had being created successfully.</p>
	    			</div>
	    		</div>
	    	
	    	</section>
	    </div>
		
	</div>
</body>
</html>