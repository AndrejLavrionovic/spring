<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	    	
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
	    				
	    				<select class="txtNew" name="authority" style="width: 193px; height: 22px">
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