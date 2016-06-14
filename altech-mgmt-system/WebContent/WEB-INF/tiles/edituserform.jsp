<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	    	
	    		<header id="hdrTitle">Edit user:</header>
	    		
	    		
	    		<!-- :::::::::::::::::::::: FORM EDIT USER ::::::::::::::::::::: -->
	    		<div id="editUserSection">
	    			<p>Here will be form for user editing.</p>
	    			
	    			
	    			<sf:form method="post" action="${pageContext.request.contextPath}/doupdateuser" id="frmUpdateUser" commandName="user">
	    			
	    				<label class="lbledit" for="firstname">First name: </label>
	    				<sf:input path="firstname" name="firstname" id="firstname" type="text" class="txtedit" />
	    				
	    				<label class="lbledit" for="lastname">Last name: </label>
	    				<sf:input path="lastname" name="lastname" id="lastname" type="text" class="txtedit" />
	    				
	    				<label class="lbledit" for="tel">Telephone: </label>
	    				<sf:input path="tel" name="tel" id="tel" type="text" class="txtedit" />
	    				
	    				<label class="lbledit" for="email">Email: </label>
	    				<sf:input path="email" name="email" id="email" type="text" class="txtedit" />
	    			 
	    			</sf:form>
	    			
	    		</div>