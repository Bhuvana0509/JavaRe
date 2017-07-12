<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="style.css" rel="stylesheet" type="text/css">


</head>
<body>
<f:view>
<jsp:include page="Header.jsp"></jsp:include>

<table align="left" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
						<tr>
							
						</tr>
</table>
<br><br><br><br><br>
		 

<center><span class="contentHEADER">Sign In</span><br><br>
<h:form id="formLogin">

		<h:panelGrid id="loginPannel" border="0" columns="3">
			<h:panelGroup>
			<h:outputText id="labelUser" styleClass="contentTEXT"  value="Enter User ID"></h:outputText><h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel> </h:panelGroup>
			<h:inputText styleClass="contentTEXT" id="employeeId" value="#{loginMB.userId}" required="true" requiredMessage="Please Enter The UserID"   converterMessage="Invalid EmployeeId" style="width: 180px">
			</h:inputText>
			<h:message styleClass="alertBOXSuccess" for="employeeId"></h:message>
			
			<h:panelGroup>
			<h:outputText id="labelPwd" styleClass="contentTEXT" value="Enter Password"></h:outputText><h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel> </h:panelGroup>
			<h:inputSecret styleClass="contentTEXT" id="password" required="true" requiredMessage="Please Enter The Password" value="#{loginMB.password}" style="width: 180px">
			</h:inputSecret>
			<h:message styleClass="alertBOXSuccess" for="password"></h:message>
		</h:panelGrid><br>
 
		

		<h:commandButton styleClass="tableBUTTON" id="buttonLogin" type="submit" value=" Login " action="#{loginMB.authenticate}" ></h:commandButton><br><br>
		
		<h:outputText styleClass="alertBOXSuccess" value="#{loginMB.message}"/>
		<br><br>
		<br><span class="fieldMANDATORY">*</span> <span class="contentTEXT">Mandatory Fields</span>
		
		</h:form>
		<br><br><br><br><br><br>
		 
		</center>
					
<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>