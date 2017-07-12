<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.faces.context.FacesContext"%>
<%@page import="com.infy.managedBeans.MasterRequirementMB"%>
<%@page import="com.infy.managedBeans.ProductRequirementMB"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details of Product Requirement Assigned To Me </title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<f:view>
<jsp:include page="Header.jsp"></jsp:include>

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
													<td id="Cell_3" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<h:form>
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy HomePage" class="mainnavTABSoff">
														<tr>
														
															<td nowrap="nowrap" align="Center" valign="Middle">
																
																	<h:outputLink value="MasterRequirementsHomePage.jsp" id="MasterRequirement" styleClass="mainnavTABSlinkOFF" > Master Requirement</h:outputLink>
																
															</td>
																
														</tr>
													</table>
													</h:form>
													</td>
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_4" class="mainnavTABSon" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_4" class="mainnavTABSlinkON" href="ProductRequirementsHomePage.jsp">Product Requirements</a></td>
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
	
<table width="100" height="100" border="0" class= "navigator_left" style="width: 169px" > 
		<tr>
		 <td   class="spaceBetweenLinks">
		 &gt; <a class="anchor" href="ProductRequirementsHomePage.jsp"> Home</a>
		 	
		  </td>
		</tr>
		<tr>
		 <td   class="spaceBetweenLinks">
		 &gt; <a class="anchor" href="ViewProductRequirement.jsp">View And Update</a>
		 	
		  </td>
		</tr>
		
		
		<tr>
					<td class="spaceBetweenVisitedLinks">&gt; <h:outputLink value="ProductRequirementsAssignedToMe.jsp"
						styleClass="anchor">Items assigned to me</h:outputLink>
					</td>
				</tr>
</table>

</td>
<td width="1" bgcolor="#269DEB"> </td>
<td valign="top" align="center"> 
<br>
<span class="contentHEADER">Product Requirement Details</span> 

<h:form>

		<h:panelGrid styleClass="filterBOX"  border="1" columns="2" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
					<h:outputText value="Product Requirement Title" ></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.productRequirementTitle}" style="width: 350px"></h:outputText>
					
					<h:outputText value="Product Requirement Description"></h:outputText>	
					<h:inputTextarea rows="3" style="background-color: #E8F5FD;width: 350px;"  readonly="true"  value="#{productRequirementMB.productRequirementTO.productRequirementDescription}" styleClass="contentTEXT"/>
		
					<h:outputText value="Maste Requirement Title"></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.masterRequirementTitle}" style="width: 350px"></h:outputText>
					
					<h:outputText value="Product Verstion"></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.productVersion}" style="width: 350px"></h:outputText>
					
					<h:outputText value="Group Name"></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.groupName}" style="width: 350px"></h:outputText>
					
					<h:outputText value="Module Name"></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.moduleName}" style="width: 350px"></h:outputText>
					
					<!-- changes done by sanket starts -->
					<h:outputText value="SubModule Name"></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.subModuleName}" style="width: 350px"></h:outputText>
					<!-- changes completed -->
					
					<h:outputText value="FRS Name"></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.frsName}" style="width: 350px"></h:outputText>
					
					<h:outputText value="FRS Closure Date"></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.frsClosureDate}" style="width: 350px">
						<f:convertDateTime pattern="dd-MMM-yyyy"/>
					</h:outputText>
					
					<h:outputText value="SRS Name"></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.srsName}" style="width: 350px"></h:outputText>
					
					<h:outputText value="SRS Closure Date"></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.srsClosureDate}" style="width: 350px">
						<f:convertDateTime pattern="dd-MMM-yyyy"/>
					</h:outputText>
					
					<h:outputText value="Comments"></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.comments}" style="width: 350px"></h:outputText>
					
					<h:outputText value="Status"></h:outputText>
					<h:outputText value="#{productRequirementMB.productRequirementTO.approvedStatus}" style="width: 350px"></h:outputText>


				</h:panelGrid>
				<br><br>
				<span class="contentHEADER">Master Requirement Details</span> 
				<br><br>
				<h:panelGrid styleClass="filterBOX" border="1" columns="2" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
					<h:outputText value="Master Requirement Title "></h:outputText>
					<h:outputText value="#{productRequirementMB.masterRequirementTO.masterRequirementTitle}" style="width: 350px"></h:outputText>
					
					<h:outputText value="External Reference No."></h:outputText>
					<h:outputText value="#{productRequirementMB.masterRequirementTO.externalReferenceNumber}" style="width: 350px"></h:outputText>
					
					<h:outputText value="Master Requirement Description"></h:outputText>
					<h:inputTextarea rows="3"  style="background-color: #E8F5FD; width:350px; "  readonly="true"  value="#{productRequirementMB.masterRequirementTO.description}" styleClass="contentTEXT"/>
		
					<h:outputText value="Group Name"></h:outputText>
					<h:outputText value="#{productRequirementMB.masterRequirementTO.groupName}" style="width: 350px"></h:outputText>
					
					<h:outputText value="Solution"></h:outputText>
					<h:outputText value="#{productRequirementMB.masterRequirementTO.solutionName}" style="width: 350px"></h:outputText>
					
					<h:outputText value="Module"></h:outputText>
					<h:outputText value="#{productRequirementMB.masterRequirementTO.moduleName}" style="width: 350px"></h:outputText>
					
					<h:outputText value="Contact For Master Requirement"></h:outputText>
					<h:outputText value="#{productRequirementMB.masterRequirementTO.contactPerson}" style="width: 350px"></h:outputText>
					
					<h:outputText value="Master Requirement Status"></h:outputText>
					<h:outputText value="#{productRequirementMB.masterRequirementTO.status}" style="width: 350px"></h:outputText>
					
					
		</h:panelGrid>
		
		<br><br>
		<h:outputLink value="ProductRequirementsAssignedToMe.jsp" styleClass="anchor">Back</h:outputLink>
			
</h:form>
</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>