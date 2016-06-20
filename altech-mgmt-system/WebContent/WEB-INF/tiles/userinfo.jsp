<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="userInfoBlock">
	<header id="hdrPersonalInfo">User's Personal Info</header>
	
	<section id="secPersonalInfo">
		<table>
			<tr><td>Name:</td><td></td></tr>
			<tr><td>Username:</td><td></td></tr>
			<tr><td>Telephone number:</td><td></td></tr>
			<tr><td>Email address:</td><td></td></tr>
			<tr><td>Age:</td><td></td></tr>
		</table>
	</section>
	<footer id="ftrPersonalInfo">
		<a href="#"><div class="btmMngUsers" id="btnEditUser">Edit User</div></a>
		<a href="#"><div class="btmMngUsers" id="btnDeleteUser">Delete user</div></a>
		<a href="${pageContext.request.contextPath}/users"><div class="btmMngUsers" id="btnBackToUsers">Back to Search Users</div></a>
	</footer>
</div>