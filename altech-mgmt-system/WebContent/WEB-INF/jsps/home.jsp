<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link href="${pageContext.request.contextPath}/src/css/main.css" type="text/css" rel="stylesheet" "/>
<link href="${pageContext.request.contextPath}/src/css/home.css" type="text/css" rel="stylesheet" "/>


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
	    
	    <div id="body">
	        <div id="mainsection">
	        
	        	<div id="hdrImg">
	        		<img alt="altech_logo" src="${pageContext.request.contextPath}/src/img/altech_logo.png">
	        	</div>
	        	
	        	<div id="homePageText">
	        		<p>Welcome to the AMS (Altech Management System)</p><br>
	        		<p>AMS performs as a readily available source of information between the organisation
	        		and the employee. Contact information, salary information, posts, work schedule,
	        		holidays booking and other features are available for employees and management.
	        		AMS makes it easy to check and track human resources department at the press of a button.</p><br>
	        		<p>A member of the organisation can easily retrieve information such us
	        		employee's details, memos, notifications and be in touch with his/her colleagues.</p><br>
	        		<p>Administrators would be very pleased if users of AMS will leave a notes or featback
	        		about AMS. Problems and issues also will help to improve system performance.</p>
	        	</div>
	        	
	        	<div id="frmDiv">
	        		<sf:form method="post" action="${pageContext.request.contextPath}/createamsmsg" commandName="amsMessage">
	        			<textarea id="notes" name="msg" rows="5" cols="50"></textarea><br>
	        			<input type="submit" name="amsMessage" value="Send message.">
	        		</sf:form>
	        	</div>
	        	
	        	<div id="botomDiv">
	        		<span>Thanks for using AMS.</span>
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
	
	<script src="${pageContext.request.contextPath}/src/js/showdate.js"></script>
</body>
</html>