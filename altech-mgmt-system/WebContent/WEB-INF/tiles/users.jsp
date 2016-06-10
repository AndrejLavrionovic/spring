<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    	

	<header id="hdrTitle">Search User:</header>
	
	<div id="searchUserForm">
		<sf:form action="${pageContext.request.contextPath}/getuserbyid" method="post" commandName="empnum">
			<label id="lblFindUserById">Emp No:</label>
			<input type="text" id="txtUserid" name="empnum" />
			<input type="submit" id="btnfindUser" name="findUserById" value="Find" />
		</sf:form>
		
		
		<div id="userbyidBlock">
			<c:if test="${user != null}">
				<table id="tblGetUsers">
		
 				<thead class="tblHeader">
 					<tr><td class="col1">Emp No.</td><td class="col2">Firstname</td><td class="col3">Lastname</td><td class="col4">Email</td><td class="col5">Tel</td></tr>
 				</thead>
 				<tbody class="tblBody">
 					<tr>
 						<td><c:out value="${user.empnum}"></c:out></td>
 						<td><c:out value="${user.firstname}"></c:out></td>
 						<td><c:out value="${user.lastname}"></c:out></td>
 						<td><c:out value="${user.email}"></c:out></td>
 						<td><c:out value="${user.tel}"></c:out></td>
 					</tr>
 				</tbody>
				</table>
				
				<!-- Choose options -->
				<div id="divoptions">
					<a class="btnlink" href="<c:url value='/edituser?u=${user.username}' />" ><div id="btnUser">Edit User</div></a>
					<a class="btnlink" href=""><div id="btnUser">Delete User</div></a>
				</div>
			</c:if>
		</div>
	</div>
	
	<!-- 
	
	<c:if test="${users != null}">
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
	</c:if>
	
	 -->