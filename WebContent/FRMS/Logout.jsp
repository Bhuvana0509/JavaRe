<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.faces.context.FacesContext"%>
<%@page import="javax.faces.context.ExternalContext"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>


<%


FacesContext ctx=FacesContext.getCurrentInstance();
	ExternalContext	etx=ctx.getExternalContext();
	HttpSession	session1=(HttpSession)etx.getSession(true);
	if(session1!=null)
	{
		
		session1.invalidate();
		response.sendRedirect("FRMSLogoutPage.jsp");
		
	}
	

		 
 %>
 
		


	

</body>
</html>