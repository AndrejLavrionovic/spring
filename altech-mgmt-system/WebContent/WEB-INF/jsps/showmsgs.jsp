<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/user.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/main.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/showmsgs.css">
<title>System messages.</title>
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
	            <li id="btn"><a href="${pageContext.request.contextPath}/clock">Clock IN/OUT</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/payroll">Payroll</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/hollidays">Hollidays</a></li>
	            <li id="btn"><a href="${pageContext.request.contextPath}/msg">Messanger</a></li>
	            <sec:authorize access="hasAnyRole('hr', 'admin')">
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
	    			<c:if test="${username != null}">
		    		<span>Welcome <c:out value="${username}"></c:out>.</span>
		    		</c:if>
	    		</div>
		    	<div id="blockLogout">
		    		<sf:form method="post" action="${pageContext.request.contextPath}/j_spring_security_logout">
		    			<input class="btnLogout" type="submit" value="Logout" />
		    		</sf:form>
		    	</div>
	    	</sec:authorize>
	    	
	    </div>
	    
	    
	    <div id="wrapper">
	    
	    	<aside id="mainAside">
	    		<ul>
	    			<li class="sideNav"><a href="${pageContext.request.contextPath}/users">Find User</a>
	    			<li class="sideNav"><a href="${pageContext.request.contextPath}/create">Create User</a>
	    			<li class="sideNav"><a href="${pageContext.request.contextPath}/showmsgs">Messages</a>
	    		</ul>
	    	</aside>
	    	
	    	<section id="mainSection">
	    	
	    		<header id="hdrTitle">Messages:</header>
	    		
	    		<!-- ::::::::::::::TABLE WITH CONTENT:::::::::::::::::: -->
	    		<div id="msgsBlock">
	    			<table>
	    				<thead>
	    					<tr><th class="col1">Date</td><th class="col2">Username</td><th class="col3">Message</td></tr>
	    				</thead>
	    				<tbody id="msgContent"><c:forEach var="msg" items="${msgs}">
	    					<tr>
	    						<td><c:out value="${msg.date}"></c:out></td>
	    						<td><c:out value="${msg.getUsername()}"></c:out></td>
	    						<td><c:out value="${msg.msg}"></c:out></td>
	    					</tr>
	    				</c:forEach></tbody>
	    			</table>
	    		</div>
	    	
	    	</section>
	    </div>
	</div>
	
	<script src="${pageContext.request.contextPath}/src/js/showdate.js"></script>
	

</body>
</html>