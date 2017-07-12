<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Master Requirement Page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<c:if test="${Role!='PM' and Role!='A'}">
	<c:redirect url="AccessDeniedPage.jsp"></c:redirect>
</c:if>
<f:view>
<jsp:include page="Header.jsp"></jsp:include>
<div>
<table cellspacing="0" cellpadding="0" width="100%" border="0"
		class="mainnavTABLE">
		<tr>
			<td style="width: 100%">
			<table class="mainnavTABLE" borderColor="#ff3300" cellspacing="0"
				cellpadding="0" width="100%" border="0" ID="tblImgSpacer"
				align="left">
				<tr style="height: 94px">
					<td class="mainnavLEFT" align="left" width="14%">

					<table cellspacing="0" cellpadding="0" border="0" ID="Table2">
						<tr>
							<td id="Cell_1" class="mainnavTABSon" nowrap="nowrap"
								align="Center" valign="Middle">
							<table cellspacing="0" cellpadding="0" border="0"
								style="border-collapse: collapse;" ID="tblMy HomePage">
								<tr>
									<td nowrap="nowrap" align="Center" valign="Middle"><a
										id="hypl_1" class="mainnavTABSlinkON" href="DashboardHomePage.jsp">Dashboard</a></td>
								</tr>
							</table>
							</td>
							<td class="cellpading0px"><img src="tab_seperate.gif"
								border="0" style="height: 21px;"></td>
							<td id="Cell_2" class="mainnavTABSoff" nowrap="nowrap"
								align="Center" valign="Middle">
							<table cellspacing="0" cellpadding="0" border="0"
								style="border-collapse: collapse;" ID="tblMy Finance">
								<tr>
									<td nowrap="nowrap" align="Center" valign="Middle"><a
										id="hypl_2" class="mainnavTABSlinkOFF"
										href="GroupDetailsHomePage.jsp">Group Details</a></td>
								</tr>
							</table>
							</td>
							<td class="cellpading0px"><img src="tab_seperate.gif"
								border="0" style="height: 21px;"></td>
							<td id="Cell_3" class="mainnavTABSoff" nowrap="nowrap"
								align="Center" valign="Middle">
							<table cellspacing="0" cellpadding="0" border="0"
								style="border-collapse: collapse;" ID="tblMy HomePage"
								class="mainnavTABSoff">
								<tr>
									<td nowrap="nowrap" align="Center" valign="Middle"><a
										id="hypl_3" class="mainnavTABSlinkOFF"
										href="MasterRequirementsHomePage.jsp" style="height: 4px;">Master
									Requirements</a></td>
								</tr>
							</table>
							</td>
							<td class="cellpading0px"><img src="tab_seperate.gif"
								border="0" style="height: 21px;"></td>
							<td id="Cell_4" class="mainnavTABSoff" nowrap="nowrap"
								align="Center" valign="Middle">
							<table cellspacing="0" cellpadding="0" border="0"
								style="border-collapse: collapse;" ID="tblMy Finance">
								<tr>
									<td nowrap="nowrap" align="Center" valign="Middle"><a
										id="hypl_4" class="mainnavTABSlinkOFF"
										href="ProductRequirementsHomePage.jsp">Product
									Requirements</a></td>
								</tr>
							</table>
							</td>
							<td class="cellpading0px"><img src="tab_seperate.gif"
								border="0" style="height: 21px;"></td>
							<td id="Cell_5" class="mainnavTABSoff" nowrap="nowrap"
								align="Center" valign="Middle">
							<table cellspacing="0" cellpadding="0" border="0"
								style="border-collapse: collapse;" ID="tblMy Finance">
								<tr>
									<td nowrap="nowrap" align="Center" valign="Middle"><a
										id="hypl_5" class="mainnavTABSlinkOFF"
										href="ReportsHomePage.jsp">Reports</a></td>
								</tr>
							</table>
							</td>
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
					<td class="mainnavLEFT" width="90%" align="right">
					<table id="tblLevelOneLinks" cellspacing="0" cellpadding="0"
						border="0" width="100%" style="border-collapse: collapse;">
						<tr>

							<td vAlign="top" class="mainnavUSER" bordercolor="#ff3300"
								align="right"><span id="blUsername" >

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
	
<table width="100" height="100" border="0" class="navigator_left" style="width: 169px">
				<tr>
					<td class="spaceBetweenLinks">&gt; <h:outputLink value="DashboardHomePage.jsp" styleClass="anchor">Home</h:outputLink>
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenVisitedLinks">&gt; <h:outputLink value="MasterRequirementAddedByMe.jsp" styleClass="anchor">Master requirements Added by me </h:outputLink>
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenLinks"> &gt; <h:outputLink value="ProductRequirementsAssignedToMe.jsp" styleClass="anchor">Product scope items assigned to me</h:outputLink>
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenLinks">&gt; <h:outputLink value="ChangePassword.jsp" styleClass="anchor">Change Password</h:outputLink>
					</td>
				</tr>
				
				
			</table>


</td>
<td width="1" bgcolor="#269DEB"> </td>
<td valign="top" align="center">
	<br>
	<h1 class="contentHEADER">Update Master Requirement Details</h1> 
	
	 
	<h:form>
	
		<h:panelGrid styleClass="filterBOX"  border="1" columns="2" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
					<h:outputText value="Master Requirement ID "></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.masterRequirementId}" style="width: 350px"></h:outputText>
					
					<h:outputText value="Master Requirement Title" ></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.masterRequirementTitle}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					
					 
					<h:outputText value="External Reference Number"></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.externalReferenceNumber}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					
					<h:outputText value="Maste Requirement Description"></h:outputText>
					<h:inputTextarea id="txtAreaDescription"  rows="3" readonly="true" value="#{masterRequirementMB.updateMasterRequirementTO.description}" styleClass="txtAreaNonEditable" />
					
					
					<h:outputText value="Group Name"></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.groupName}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					
					<h:outputText value="Solution Name"></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.solutionName}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					
					<h:outputText value="Module Name"></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.moduleName}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					
					<h:outputText value="Contact Person"></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.contactPerson}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					
					
					<h:outputText value="Status"></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.status}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					
					 <!-- Changes made by Bhuvana starts  -->
				     <c:if test="${masterRequirementMB.updateMasterRequirementTO.status!=null}">
					 <h:outputText value="Customization"></h:outputText>
						
						<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.customization}" style="width: 350px"></h:outputText>
						</c:if>
						<h:outputText value=" "></h:outputText>
						<!-- Changes made by Bhuvana end --> 
	
				</h:panelGrid>
				<br><br>
				<center>
				 
				
				 
				  
				<h:commandButton type="submit" value="     Ok     " styleClass="tableBUTTON" action="ok"></h:commandButton><br><br>
				
				<br>
					<h:outputText value="#{masterRequirementMB.message}" styleClass="alertBOX"></h:outputText>
				<br>
				<br>
				</center>
	 
	</h:form>
	

	
</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>