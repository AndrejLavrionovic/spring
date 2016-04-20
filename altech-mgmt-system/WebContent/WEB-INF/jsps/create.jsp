<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
	    				<label class="lblNew" id="lblNationality">Nationality:</label>
	    				<sf:input path="nationality" class="txtNew" type="text" id="txtNationality" name="nationality" />
	    				<div id="divError"><sf:errors path="nationality" cssClass="error"></sf:errors></div></br>
	    				<label class="lblNew id="lblPosid">Position:</label>
	    				
	    				<select class="txtNew" name="posid" style="width: 222px; height: 22px">
	    					<option selected="selected" value="0"></option>
							<option value="1" >Customer Support Administrator</option>
						 	<option value="2">Customer Support Specialist</option>
						 	<option value="3">Database Administrator</option>
						 	<option value="4">Front End Developer</option>
							<option value="5">Help Desk Specialist</option>
						 	<option value="6">Junior Software Engineer</option>
						 	<option value="7">Network Architect</option>
						 	<option value="8">Network Engineer</option>
							<option value="9">Network Systems Administrator</option>
						 	<option value="10">Programmer Analyst</option>
						 	<option value="11">Security Specialist</option>
						 	<option value="12">Senior Database Administrator</option>
							<option value="13">Senior Software Engineer</option>
						 	<option value="14">Software Architech</option>
						 	<option value="15">Software Engineer</option>
						 	<option value="16">Software Quality Assurance Analyst</option>
							<option value="17">Systems Administrator</option>
						 	<option value="18">System Architect</option>
						 	<option value="19">Web Administrator</option>
						 	<option value="20">Web Developer</option>
					 	</select>
	    				</br>
	    				
	    				<label class="lblNew id="lblStatus">Admin Status:</label>
	    				
	    				<select class="txtNew" name="statusid" style="width: 222px; height: 22px">
	    					<option selected="selected" value="0"></option>
							<option value="1" >Employee</option>
						 	<option value="2">Office Manager</option>
						 	<option value="3">Head Manager</option>
						 	<option value="4">HR Admin</option>
					 	</select>
	    				</br>
	    			</div>
	    
<!-- 
	    			<div id="frmAddress">
	    				<label class="lblNew" id="lblAddress1">Address1 :</label>
	    				<input class="txtNew" type="text" id="txtAddress2" name="address1" /></br>
	    				<label class="lblNew" id="lblAddress2">Address2:</label>
	    				<input class="txtNew" type="text" id="txtAddress2" name="address2" /></br>
	    				<label class="lblNew" id="lblTown">Town/City:</label>
	    				<input class="txtNew" type="text" id="txtTown" name="town" /></br>
	    				<label class="lblNew" id="lblCounty">County:</label>
	    				
	    				<select class="txtNew" name="county" style="width: 222px; height: 22px">
	    					<option selected="selected" value="0"></option>
							<option value="Antrim" >Antrim</option>
						 	<option value="Armagh">Armagh</option>
						 	<option value="Carlow">Carlow</option>
						 	<option value="Cavan">Cavan</option>
							<option value="Clare">Clare</option>
						 	<option value="Cork">Cork</option>
						 	<option value="Donegal">Donegal</option>
						 	<option value="Down">Down</option>
							<option value="Dublin">Dublin</option>
						 	<option value="Fermanagh">Fermanagh</option>
						 	<option value="Galway">Galway</option>
						 	<option value="Kerry">Kerry</option>
							<option value="Kildare">Kildare</option>
						 	<option value="Kilkenny">Kilkenny</option>
						 	<option value="Laois">Laois</option>
						 	<option value="Leitrim">Leitrim</option>
							<option value="Limerick">Limerick</option>
						 	<option value="Londonderry">Londonderry</option>
						 	<option value="Longford">Longford</option>
						 	<option value="Louth">Louth</option>
							<option value="Mayo">Mayo</option>
						 	<option value="Meath">Meath</option>
						 	<option value="Monaghan">Monaghan</option>
						 	<option value="Offaly">Offaly</option>
						 	<option value="Roscommon">Roscommon</option>
						 	<option value="Sligo">Sligo</option>
						 	<option value="Tipperary">Tipperary</option>
							<option value="Tyrone">Tyrone</option>
						 	<option value="Waterford">Waterford</option>
						 	<option value="Westmeath">Westmeath</option>
						 	<option value="Wexford">Wexford</option>
							<option value="Wicklow">Wicklow</option>
					 	</select> </br>
	    			</div>
-->
	    			
	    			<div id="frmBtns">
	    				<input class="buttons" type="submit" id="btnNewUser" name="newUser" value="Create" />
	    				<input class="buttons" type="button" id="btnClear" name="clear" value="Clear" />
	    				<input class="buttons" type="button" id="btnBack" name="back" value="Back" />
	    			</div>
	    			
	    			</sf:form>
	    		</div>
	    	
	    	</section>
	    	
	    </div>
	    
	    <footer>
	    
	    </footer>
		
	</div>

</body>
</html>