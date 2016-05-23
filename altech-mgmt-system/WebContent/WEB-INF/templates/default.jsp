<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/src/css/main.css" type="text/css" rel="stylesheet" "/>
<link href="${pageContext.request.contextPath}/src/css/home.css" type="text/css" rel="stylesheet" "/>
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
</head>
<body>
	<div id="container">

		Welcome to the Altech websource.
		We are not ready yet!
		The site is under construction.
		
		<div id = "header"><tiles:insertAttribute name="header"></tiles:insertAttribute></div>
		<div id = "content"><tiles:insertAttribute name="content"></tiles:insertAttribute></div>
		<div id = "footer"><tiles:insertAttribute name="footer"></tiles:insertAttribute></div>

	</div>
</body>
</html>