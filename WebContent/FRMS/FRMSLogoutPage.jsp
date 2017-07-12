<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.faces.context.FacesContext"%>
<%@page import="javax.faces.context.ExternalContext"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout page</title>
<script type="text/javascript">
script type="text/javascript">
window.history.length=0;
</script>

</head>
<body>
<f:view>
<jsp:include page="Header.jsp"></jsp:include>



<table align="left" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
						<tr>
							
						</tr>
</table>


 
<br><br><br><br><br><br>
<center><span class="contentHEADER">You are Successfully Logged Out</span><br><br><br>
		<span ><h:outputLink value="FRMSLoginPage.jsp"> <font face="Verdana"  size="2" color="##52A3CC">Login Again</font> </h:outputLink></span>
<br>

</center>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>