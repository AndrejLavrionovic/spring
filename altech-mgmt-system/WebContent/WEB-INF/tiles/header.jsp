<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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