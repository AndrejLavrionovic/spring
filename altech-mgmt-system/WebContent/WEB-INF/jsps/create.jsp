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
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/newUser.css">
<title>Register new user.</title>
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
		    		<span>Welcome User.</span>
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
	    	
	    		<header id="hdrTitle">Register new user:</header>
	    		
	    		
	    		<!-- :::::::::::::::::::::: FORM NEW USER ::::::::::::::::::::: -->
	    		<div id="newUserSection">
	    			<sf:form method="post" action="${pageContext.request.contextPath}/docreate" id="frmNewUser" commandName="user">
	    			
	    			<div id="frmUser">
	    				<label class="lblNew" id="lblFirstname">Firstname:</label>
	    				<sf:input path="firstname" class="txtNew" type="text" id="txtFirstname" name="firstname" />
	    				<div id="divError"><sf:errors path="firstname" cssClass="error"></sf:errors></div></br>
	    				<label class="lblNew" id="lblLastname">Lastname:</label>
	    				<sf:input path="lastname" class="txtNew" type="text" id="txtLastname" name="lastname" />
	    				<div id="divError"><sf:errors path="lastname" cssClass="error"></sf:errors></div></br>
	    				<label class="lblNew" id="lblEmpnum">Employee Num:</label>
	    				<sf:input path="empnum" class="txtNew" type="text" id="txtEmpnum" name="empnum" />
	    				<div id="divError"><sf:errors path="empnum" cssClass="error"></sf:errors></div></br>
	    				<label class="lblNew" id="lblTel">Telephone Num:</label>
	    				<sf:input path="tel" class="txtNew" type="text" id="txtTel" name="tel" />
	    				<div id="divError"><sf:errors path="tel" cssClass="error"></sf:errors></div></br>
	    				<label class="lblNew" id="lblEmail">Email:</label>
	    				<sf:input path="email" class="txtNew" type="text" id="txtEmail" name="email" />
	    				<div id="divError"><sf:errors path="email" cssClass="error"></sf:errors></div></br>
	    				
	    				<label class="lblNew id="lblStatus">Authority:</label>
	    				
	    				<select class="txtNew" name="authority" style="width: 220px; height: 22px">
	    					<option selected="selected" value="0"></option>
							<option value="user" >Employee</option>
						 	<option value="man">Office Manager</option>
						 	<option value="head">Head Manager</option>
						 	<option value="hr">HR Admin</option>
					 	</select>
	    				</br>
	    			</div>
	    			
	    			<div id="login">
	    				<label class="lblNew" id="lblUsername">Username:</label>
	    				<sf:input path="username" class="txtNew" type="text" id="txtUsername" name="username" />
	    				<div id="divError"><sf:errors path="username" cssClass="error"></sf:errors></div></br>
	    				<label class="lblNew" id="lblPassword">Password:</label>
	    				<sf:input path="password" class="txtNew" type="text" id="txtPassword" name="password" />
	    				<div id="divError"><sf:errors path="password" cssClass="error"></sf:errors></div></br>
	    				<label class="lblNew" id="lblConfirm">Confirm password:</label>
	    				<input class="txtNew" type="text" id="txtConfirm" name="confirm" /></br>
	    			</div>

	    			
	    			<div id="frmBtns">
	    				<input class="buttons" type="submit" id="btnNewUser" name="newUser" value="Create" />
	    				<input class="buttons" type="button" id="btnClear" name="clear" value="Clear" />
	    				<input class="buttons" type="button" id="btnBack" name="back" value="Back" />
	    			</div>
	    			
	    			</sf:form>
	    		</div>
	    	
	    	</section>
	    	
	    </div>
		
	</div>
	
	<script src="${pageContext.request.contextPath}/src/js/showdate.js"></script>

</body>
</html>