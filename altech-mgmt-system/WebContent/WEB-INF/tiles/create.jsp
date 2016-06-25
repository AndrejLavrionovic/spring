<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	    	
	    		<header id="pageTitle">New user registration form.</header>

				<header id="hdrParagraph">
				AMS (Altech Management System) providing the "New user registration form." This page is
				available only for permitted users such as admin and HR.<br />
				Form consist of several text inputs and dropdown lists. All fields must be completed to proceed
				the registration. 
				<p>There is some rules must be followed while registration:</p>
				<ol style="margin-left:16px;">
					<li>Firstname and lastname must not be longer than 45 characters.</li>
					<li>User must be older then 16 and younger than 80.</li>
					<li>Phone number must be with Irish provider (+353)</li>
					<li>Username must be unique.</li>
					<li>Password must be save and must contain atleast one number, one character.</li>
				</ol>
				</header>
	    		
	    		
	    		<!-- :::::::::::::::::::::: FORM NEW USER ::::::::::::::::::::: -->
	    		<div id="newUserSection">
	    			<sf:form method="post" action="${pageContext.request.contextPath}/docreate" id="frmNewUser" commandName="user">
	    			
	    			<div id="frmUser">
	    				<div id="nameBlock">
	    					<div id="lblNameBlock">
	    						<label class="lblNew" id="lblName">User name:</label>
	    					</div>
	    					<div id="txtFirstnameBlock">
	    						<label class="lblTops" id="lblFirstname" for="txtFirstname"t>Firstname:</label>
	    						<sf:input path="firstname" class="txtNew" type="text" id="txtFirstname" name="firstname" />
	    					</div>
	    					<div id="txtLastnameBlock">
	    						<label class="lblTops" id="lblLastname" for="lblLastname"t>Lastname:</label>
	    						<sf:input path="lastname" class="txtNew" type="text" id="txtLastname" name="lastname" />
	    					</div>
	    				</div>
	    				
	    				<div id="divError"><sf:errors path="firstname" cssClass="error"></sf:errors></div></br>
	    				<div id="divError"><sf:errors path="lastname" cssClass="error"></sf:errors></div></br>
	    				
	    				<!-- 	
	    				<label class="lblNew" id="lblEmpnum">Employee Num:</label>
	    				<sf:input path="empnum" class="txtNew" type="text" id="txtEmpnum" name="empnum" />
	    				<div id="divError"><sf:errors path="empnum" cssClass="error"></sf:errors></div></br>
	    				-->
	    				
	    				<div id="blockDob">
							<label class="lblNew" id="lblDatePicker" for="inDatePicker">Date of birth:</label>
							<div id="inDatePicker">
								<sf:select path="month" style="background:url('${pageContext.request.contextPath}/src/img/select_arrow_20x30.png') no-repeat right white; -webkit-appearance: none; -moz-appearance: none;" class="selNew" id="pickMonth"></sf:select>
								<sf:select path="day" style="background:url('${pageContext.request.contextPath}/src/img/select_arrow_20x30.png') no-repeat right white; -webkit-appearance: none; -moz-appearance: none;" class="selNew" id="pickDay"></sf:select>
								<sf:select path="year" style="background:url('${pageContext.request.contextPath}/src/img/select_arrow_20x30.png') no-repeat right white; -webkit-appearance: none; -moz-appearance: none;" class="selNew" id="pickYear"></sf:select>
							</div>
	    				</div>
	    				
	    				
	    				<div id="contactsBlock">
	    					<div id="lblContactsBlock">
	    						<label class="lblNew" id="lblContacts">User Contacts:</label>
	    					</div>
	    					<div id="txtTelBlock">
	    						<label class="lblTops" id="lblTel" for="txtTel"t>Tel. number</label>
	    						<div>
	    							<sf:select path="telPrefix" style="display: inline-block; background:url('${pageContext.request.contextPath}/src/img/select_arrow_20x30.png') no-repeat right white; -webkit-appearance: none; -moz-appearance: none;" class="selNew" id="selTelPrefix"></sf:select>
	    							<sf:input path="telNumber" class="txtNew" type="text" id="txtTel" name="telNumber" style="display: inline-block;" />
	    						</div>
	    						
	    					</div>
	    					<div id="txtEmailBlock">
	    						<label class="lblTops" id="lblEmail" for="txtEmail"t>Email</label>
	    						<sf:input path="email" class="txtNew" type="text" id="txtEmail" name="email" />
	    					</div>
	    				</div>
	    				
	    				
	    				<div id="divError"><sf:errors path="tel" cssClass="error"></sf:errors></div></br>
	    				<div id="divError"><sf:errors path="email" cssClass="error"></sf:errors></div></br>
	    				
	    				<label class="lblNew id="lblStatus">Authority:</label>
	    				
	    				<select class="selNew" name="authority" style="width: 193px; background:url('${pageContext.request.contextPath}/src/img/select_arrow_20x30.png') no-repeat right white; -webkit-appearance: none; -moz-appearance: none;" >
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
	    			
	    			<script src="${pageContext.request.contextPath}/src/js/dataPicker.js"></script>
	    		</div>