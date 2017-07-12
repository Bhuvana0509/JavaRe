<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.infy.managedBeans.UploadListMB"%>
<%@page import="javax.faces.context.FacesContext"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload List Of Master Requirement Page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<c:if test="${Role=='GS'}">
	<c:redirect url="AccessDeniedPage.jsp"></c:redirect>
</c:if>
<f:view >
<jsp:include page="Header.jsp"></jsp:include>
<c:if test="${link!='UploadListOfMasterRequirement'}">
	<%
	UploadListMB uploadListMB =new UploadListMB();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uploadListMB", uploadListMB);
		
	%>
 	<c:set var="link" value="UploadListOfMasterRequirement" scope="session"></c:set>
	</c:if>	

<div>
<table cellspacing="0" cellpadding="0" width="100%" border="0" class="mainnavTABLE">
							<tr>
								<td style="width: 100%">
								<table class="mainnavTABLE" borderColor="#ff3300" cellspacing="0" cellpadding="0" width="100%" border="0" ID="tblImgSpacer" align="left">
									<tr style="height: 94px">
										<td class="mainnavLEFT" align="left" width="14%">
										
										<table cellspacing="0" cellpadding="0" border="0" ID="Table2">
												<tr>
													<td id="Cell_1" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy HomePage">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_1" class="mainnavTABSlinkOFF" href="DashboardHomePage.jsp">Dashboard</a></td>
														</tr>
													</table>
													</td>
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_2" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_2" class="mainnavTABSlinkOFF" href="GroupDetailsHomePage.jsp">Group Details</a></td>
														</tr>
													</table>
													</td>
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_3" class="mainnavTABSon" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy HomePage" class="mainnavTABSon">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_3" class="mainnavTABSlinkON" href="MasterRequirementsHomePage.jsp" style="height: 4px;">Master Requirements</a></td>
														</tr>
													</table>
													</td>
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_4" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_4" class="mainnavTABSlinkOFF" href="ProductRequirementsHomePage.jsp">Product Requirements</a></td>
														</tr>
													</table>
													</td>
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_5" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_5" class="mainnavTABSlinkOFF" href="ReportsHomePage.jsp">Reports</a></td>
														</tr>
													</table>
													</td>
													
													<!-- Chnages done by Bhuvana -->
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_6" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_6" class="mainnavTABSlinkOFF" href="AboutFRMSHomePage.jsp">About FRMS</a></td>
														</tr>
													</table>
													</td>
													<!-- changes completed -->
													<c:if test="${Role=='A'}">
														<td class="cellpading0px"><img src="tab_seperate.gif"
															border="0" style="height: 21px;"></td>
														<td id="Cell_5" class="mainnavTABSoff" nowrap="nowrap"
															align="Center" valign="Middle">
														<table cellspacing="0" cellpadding="0" border="0"
															style="border-collapse: collapse;" ID="tblMy Finance">
															<tr>
																<td nowrap="nowrap" align="Center" valign="Middle"><a
																	id="hypl_5" class="mainnavTABSlinkOFF"
																	href="AdminTasksHomePage.jsp">Admin Tasks</a></td>
															</tr>
														</table>
														</td>
														</c:if>
													
												</tr>
											</table>
										</td>
										<td class="mainnavLEFT">
										<table id="tblLevelOneLinks" cellspacing="0" cellpadding="0" border="0" width="100%" style="border-collapse: collapse;">
											<tr>
												
												<td vAlign="top" class="mainnavUSER" bordercolor="#ff3300" align="right">
												<span id="blUsername" >

													<h:outputText styleClass="emailLink" value="#{loginMB.emailId}"></h:outputText> </span>
													<h:form style="height: 38px; width: 168px">
														<a href="Logout.jsp" ><img src="logout_button.png" style="height: 21px; width: 81px; border:rgb(1,117,193);"></a>
													</h:form>
												</td>
											</tr>
										</table>
										</td>
									</tr>
								</table>
								</td>
							</tr>
							
							
</table>
</div>
<table align="left" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
						<tr>
							
						</tr>
</table>
<table border="0" width="100%" height="355">
<tr>
<td width="170" valign="top">
	
<table width="100" height="100" border="0" class= "navigator_left"  style="width: 169px" bgcolor="#A0BC31" > 
		<tr>
		 <td class="spaceBetweenLinks">
		 	&gt; <h:outputLink value="MasterRequirementsHomePage.jsp" styleClass="anchor">Home</h:outputLink>
		  </td>
		</tr>
		
		<tr>
		 <td  class="spaceBetweenLinks">
		&gt; <h:outputLink value="AddNewMasterRequirement.jsp" styleClass="anchor" >Add New </h:outputLink>
		 </td>
		</tr>
		
		<tr>
		 <td class="spaceBetweenLinks">
		  &gt; <h:outputLink value="ViewMasterRequirement.jsp" styleClass="anchor" >View/Update </h:outputLink>
		 </td>
		</tr>
		<tr>
		 <td class="spaceBetweenVisitedLinks">
		  &gt; <h:outputLink value="UploadListOfMasterRequirement.jsp" styleClass="anchor" >Upload list</h:outputLink>
		 </td>
		</tr>
		 
</table>


</td>
<td width="1" bgcolor="#269DEB"> </td>
<td align="center"> 
<br>
	<h1 class="contentHEADER">Upload Master Requirement Details</h1> 
	<br>
<h:form id="uploadMRForm" enctype="multipart/form-data"  >
	
	   &nbsp;&nbsp;
	 <span>
	  <t:inputFileUpload  id="uploadRequirementFile" storage="file"  value="#{uploadListMB.uploadedFile}"  />

	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  
 	 <h:commandButton styleClass="tableBUTTON" value="Submit" type="submit" action="#{uploadListMB.uploadData}" />
 	 </span> <br><br><br><br>
 	 <h:outputText styleClass="alertBOX" value ="#{uploadListMB.message}"></h:outputText>
 	 
 	 
	</h:form>
	
	

	<div style="position: relative;text-align: left;left: 100px;" class="bodyTEXT">
	<h:form>
	<ul>
 	 	<li>Upload the File with .XLS extension only ( Microsoft Excel 97-2003 format )</li>
 	 	<li>Before uploading make sure that Requirements entered are in correct format as that of the Template</li>
 	 	<li>You can download Template Here -  
 	 	<h:commandLink action="#{uploadListMB.downloadTemplate}"><font face="Verdana"  size="2" color="##52A3CC">Download Template</font></h:commandLink>
 	 	  </li> 
 	 	  
 	 </ul>
 	 </h:form>
 	 </div>
 	 
 	 <br><br>
 	 
 	

</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>