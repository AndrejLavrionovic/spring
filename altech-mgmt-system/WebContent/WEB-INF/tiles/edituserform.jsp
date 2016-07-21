<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	    		
	    		
	    		<!-- :::::::::::::::::::::: FORM EDIT USER ::::::::::::::::::::: -->
	    		<div id="editUserSection">
	    			<header>
	    				<div id="title"><c:out value="${user.firstname}" /> user edit.</div>
	    			</header>
	    			<section>
	    				
	    				
	    				<sf:form method="post" action="${pageContext.request.contextPath}/doupdateuser" id="frmUpdateUser" commandName="user">
	    				
	    					
	    					<input type="hidden" id="day" name="day" value="${user.day}" />
	    					<input type="hidden" id="month" name="month" value="${user.month}" />
	    					<input type="hidden" id="year" name="year" value="${user.year}" />
	    					<input type="hidden" id="telPref" name="telPrefix" value="${user.telPrefix}" />
	    					
			    			<sf:errors path="*" cssClass="error" element="div"></sf:errors>
			    			
			    			<div id="frmUser">
			    				<div id="nameBlock">
			    					<div id="lblNameBlock">
			    						<label class="lblNew" id="lblName">User name:</label>
			    					</div>
			    					<div id="txtFirstnameBlock">
			    						<label class="lblTops" id="lblFirstname" for="txtFirstname">Firstname:<span class="spanModal" id="modalFirstname">(?)</span></label>
			    						<sf:input path="firstname" cssClass="txtNew" cssErrorClass="txtNew txtError" type="text" id="txtFirstname" />
			    					</div>
			    					<div id="txtLastnameBlock">
			    						<label class="lblTops" id="lblLastname" for="lblLastname">Lastname:<span class="spanModal" id="modalLastname">(?)</span></label>
			    						<sf:input path="lastname" cssClass="txtNew" cssErrorClass="txtNew txtError" type="text" id="txtLastname" />
			    					</div>
			    				</div>
			    				
			    				<div id="blockDob">
									<label class="lblNew" id="lblDatePicker" for="inDatePicker">Date of birth:</label>
									<div id="inDatePicker">
										<sf:select path="month" cssClass="selNew" cssErrorClass="selNew selError" id="pickMonth" ></sf:select>
										<sf:select path="day" cssClass="selNew" cssErrorClass="selNew selError" id="pickDay" selected="${user.day}"></sf:select>
										<sf:select path="year" cssClass="selNew" cssErrorClass="selNew selError" id="pickYear"></sf:select>
									</div>
			    				</div>
			    				
			    				
			    				<div id="contactsBlock">
			    					<div id="lblContactsBlock">
			    						<label class="lblNew" id="lblContacts" for="txtTelBlock">User Contacts:</label>
			    					</div>
			    					<div id="txtTelBlock">
			    						<label class="lblTops" id="lblTel" for="txtTel">Tel. number<span class="spanModal" id="modalTel">(?)</span></label>
			    						<div>
			    							<sf:select path="telPrefix" cssClass="selNew" cssErrorClass="selNew selError" id="selTelPrefix"></sf:select>
			    							<sf:input path="telNumber" cssClass="txtNew" cssErrorClass="txtNew txtError" type="text" id="txtTel" style="display: inline-block;" />
			    						</div>
			    						
			    					</div>
			    					<div id="txtEmailBlock">
			    						<label class="lblTops" id="lblEmail" for="txtEmail">Email<span class="spanModal" id="modalEmail">(?)</span></label>
			    						<sf:input path="email" cssClass="txtNew" cssErrorClass="txtNew txtError" type="text" id="txtEmail" />
			    					</div>
			    				</div>
			    			</div>
		    			 
		    			</sf:form>
	    			
	    			
	    			</section>
	    			<footer>

	    			
		    			<div id="frmBtns">
		    				<input class="buttons" type="button" id="btnClear" name="clear" value="Clear" />
		    				<input class="buttons" type="submit" id="btnEditUser" name="edituser" value="Save Updates" />
		    			</div>
		    			
		    			
		    		</footer>
	    			
	    		</div>
	    		
	    		<div id="myModal" class="modal">
		            <div id="modalwindow" class="modalwindow">
		
		                <header id="modalHeader"><img id="imgClose" src="${pageContext.request.contextPath}/src/img/close_32.png" /></header>
		                <section id="modalContent">
		                    <h3 id="fieldName"></h3>
		                    <ul id="conditions">
		                    </ul>
		                </section>
		
		            </div>
		        </div>
	    			
    			<script src="${pageContext.request.contextPath}/src/js/dataPickerEdit.js"></script>
    			<script src="${pageContext.request.contextPath}/src/js/modal.js"></script>