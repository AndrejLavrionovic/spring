<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/main.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/css/userCreated.css">
<title>User created</title>
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
	            <li id="btn"><a href="/">Home</a></li>
	            <li id="btn"><a href="/">Click in</a></li>
	            <li id="btn"><a href="/">Payroll</a></li>
	            <li id="btn"><a href="/">Hollidays</a></li>
	            <li id="btn"><a href="/">Messanger</a></li>
	            <li id="btn"><a href="user.jsp">Users</a></li>
	        </ul>
	    </nav>
	    
	    <div id="wrapper">
	    
	    	<aside id="mainAside">
	    		<ul>
	    			<li class="sideNav"><a href="user.jsp">Find User</a>
	    			<li class="sideNav"><a href="createUser.jsp">Create User</a>
	    		</ul>
	    	</aside>
	    	
	    	<section id="mainSection">
	    		
	    		<!-- :::::::::::::::::::::: USER CREATED ::::::::::::::::::::: -->
	    		<div id="usercreated">
	    			
	    		</div>
	    	
	    	</section>
	    	
	    	
	    	
	    </div>
	    
	    <footer>
	    
	    </footer>
		
	</div>
</body>
</html>