<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="userInfoBlock">

	<div id="blcUserPersonalInformation">
	
		<header id="hdrPersonalInfo">
			<div id="title">User's Personal Info</div>
			<div id="controls">
				<div><a href="<c:url value='/edituser?u=${user.username}' />"><img class="imgusermanagement" alt="Edit user" src="${pageContext.request.contextPath}/src/img/user_edit_16.png"></a></div>
			</div>
		</header>
		<section id="secPersonalInfo">
			<div id="leftBlock">
				<img src="${pageContext.request.contextPath}/src/img/profile_default_f_100.png">
			</div>
			<div id="mainBlock">
				<div id="usrName"><c:out value="${user.firstname} ${user.lastname}" /></div>
				<table>
					<tr><td class="infoname">Emp. number:</td><td class="infovalue"><c:out value="${user.empnum}" /></td></tr>
					<tr><td class="infoname">Username:</td><td class="infovalue"><c:out value="${user.username}" /></td></tr>
					<tr><td class="infoname">Telephone number:</td><td class="infovalue"><c:out value="${user.tel}" /></td></tr>
					<tr><td class="infoname">Email address:</td><td class="infovalue"><c:out value="${user.email}" /></td></tr>
					<tr><td class="infoname">Age:</td><td class="infovalue"><c:out value="${age }" /></td></tr>
				</table>
			</div>
		</section>
		<footer id="ftrPersonalInfo">
		<!-- 
			<a href="<c:url value='/edituser?u=${user.username}' />"><div class="btmMngUsers" id="btnEditUser">Edit User</div></a>
			<a href="<c:url value='/deleteuser?u=${user.username}' />"><div class="btmMngUsers" id="btnDeleteUser">Delete user</div></a>
			<a href="${pageContext.request.contextPath}/users"><div class="btmMngUsers" id="btnBackToUsers">Back to Search Users</div></a>
		-->
		</footer>
		
	</div>
</div>