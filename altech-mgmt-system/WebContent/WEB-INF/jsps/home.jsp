<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link href="${pageContext.request.contextPath}/src/css/main.css" type="text/css" rel="stylesheet" "/>
<link href="${pageContext.request.contextPath}/src/css/home.css" type="text/css" rel="stylesheet" "/>
</head>
<body>
	<div id="container">
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
	            <li id="btn"><a href="${pageContext.request.contextPath}/users">Users</a></li>
	        </ul>
	    </nav>
	    <div id="body">
	        <div id="mainsection">
	    	
	    		<header id="hdrTitle">Well come the AMS (Altech Management System):</header>
	    		
	    		<div id="login">
	    			<header id="hLog">Login</header>
	    			<div id="logNotes">
	    				<p>Password must contain both numbers and letters and must be between
	    				8 and 16 characters.</p>
	    			</div>
	    			<section id="sLog">
	    				<form method="post" action="">
		    				<label class="lblLog" id="email">Email:</label>
		    				<input class="txtLog" type="text" name="email" /></br>
		    				<label class="lblLog" id="password">Password:</label>
		    				<input class="txtLog" type="text" name="password" /></br>
		    				<div id="logBtns">
		    					<input type="submit" name="Login" value="Login" />
		    				</div>
	    				</form>
	    			</section>
	    		</div>
	        	
	        </div>
	    </div>
	</div>
</body>
</html>