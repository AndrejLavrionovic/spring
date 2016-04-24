<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users management page</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/user.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/main.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/users.css">
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
	            <li id="btn"><a href="${pageContext.request.contextPath}/users">Users</a></li>
	        </ul>
	    </nav>
	    
	    <div id="wrapper">
	    
	    	<aside id="mainAside">
	    		<ul>
	    			<li class="sideNav"><a href="${pageContext.request.contextPath}/users">Find User</a>
	    			<li class="sideNav"><a href="${pageContext.request.contextPath}/create">Create User</a>
	    		</ul>
	    	</aside>
	    	
	    	<section id="mainSection">
	    	
	    		<header id="hdrTitle">Search User:</header>
	    		
	    		<div id="searchUserForm">
	    			<form action="${pageContext.request.contextPath}/getuserbyid" method="post">
	    				<label id="lblFindUserById">Emp No:</label>
	    				<input type="text" id="txtUserid" name="empnum" />
	    				<input type="submit" id="btnfindUser" name="findUserById" value="Find" />
	    			</form>
	    			<form action="${pageContext.request.contextPath}/getuserbyname" method="post">
	    				<label id="lblFindUserById">Firstname:</label>
	    				<input type="text" id="txtUserid" />
	    				<input type="submit" id="btnfindUser" name="findUserByName" value="Find" />
	    			</form>
	    			<br />
	    		</div>
	    		
	    		<div id="getUsers">
	    			<table id="tblGetUsers">
	    			
	    				<thead class="tblHeader">
	    					<tr><td class="col1">Emp No.</td><td class="col2">Firstname</td><td class="col3">Lastname</td><td class="col4">Email</td><td class="col5">Tel</td></tr>
	    				</thead>
	    				<tbody class="tblBody"><c:forEach var="user" items="${users}">
	    					<tr>
	    						<td><c:out value="${user.empnum }"></c:out></td>
	    						<td><c:out value="${user.firstname }"></c:out></td>
	    						<td><c:out value="${user.lastname }"></c:out></td>
	    						<td><c:out value="${user.email }"></c:out></td>
	    						<td><c:out value="${user.tel }"></c:out></td>
	    					</tr>
	    				</c:forEach></tbody>
	    			
	    			</table>
	    		</div>
	    	
	    	</section>
	    </div>
	</div>
	
</body>
</html>