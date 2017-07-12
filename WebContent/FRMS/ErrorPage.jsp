<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body >
<f:view>
<div>
<center>
<table cellspacing="0" cellpadding="0" width="100%" class="headertable100percent" border="0" bordercolor="#6600ff" ID="tblHeaderLogo" style="height: 57px">
		<tr>
			<td align="center" rowspan="2"  class="headerLEFT" style="width: 100%"><center> This Page Cannot Be Displayed 
			 </center></td>
		</tr>
</table>
</center>
</div>

<table align="left" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
						<tr>
							
						</tr>
</table>


 
<br>
<center><br><br><br><br><br>
<span class="contentHEADER">You Are Not Logged In!!!</span><br><br>
<h:outputLink value="FRMSLoginPage.jsp" ><font face="Verdana"  size="2" color="##52A3CC"> Click Here To Login</font> </h:outputLink>

</center><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="Footer.jsp"></jsp:include>

</f:view>
</body>
</html>