<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.infy.managedBeans.ViewUpdateGroupDetailsMB"%>
<%@page import="javax.faces.context.FacesContext"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Group Details page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<f:view>
<jsp:include page="Header.jsp"></jsp:include>
<c:if test="${link!='ViewGroupDetails'}">
	<%
	ViewUpdateGroupDetailsMB viewUpdateGroupDetailsMB =new ViewUpdateGroupDetailsMB();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("viewUpdateGroupDetailsMB", viewUpdateGroupDetailsMB);
		
	%>
 	<c:set var="link" value="ViewGroupDetails" scope="session"></c:set>
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
													<td id="Cell_2" class="mainnavTABSon" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_2" class="mainnavTABSlinkON" href="GroupDetailsHomePage.jsp">Group Details</a></td>
														</tr>
													</table>
													</td>
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_3" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy HomePage" class="mainnavTABSoff">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_3" class="mainnavTABSlinkOFF" href="MasterRequirementsHomePage.jsp" style="height: 4px;">Master Requirements</a></td>
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
													
													<!-- Changes done by Bhuvana starts -->
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_6" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_6" class="mainnavTABSlinkOFF" href="AboutFRMSHomePage.jsp">About FRMS</a></td>
														</tr>
													</table>
													</td>
													<!--  chnages completed -->
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
		 <td class="spaceBetweenLinks" >
		 	&gt; <h:outputLink value="GroupDetailsHomePage.jsp"  styleClass="anchor" >Home </h:outputLink>
		  </td>
		</tr>
		<tr>
		 <td class="spaceBetweenLinks" >
		 	&gt; <h:outputLink value="CreateNewGroup.jsp"  styleClass="anchor" >Create New Group </h:outputLink>
		  </td>
		</tr>
		<tr>
		 <td class="spaceBetweenVisitedLinks" >
		 	&gt; <h:outputLink value="ViewGroupDetails.jsp"  styleClass="anchor" >View And Update</h:outputLink>
		  </td>
		</tr>
		
		
</table>

</td>
<td width="1" bgcolor="#269DEB"> </td>
<td valign="top">
<center>
<br><span class="contentHEADER">View And Update Group Details</span>
<h:form id="ViewGroupdetailsForm">
		<div style=" position:relative; width: 600px;">
		<h:panelGrid border="0" columns="3" styleClass="filterBOX"  columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
		 
		<h:panelGroup  >
		<span style="width: 100px;">
			 <h:outputText value="Market/Geography"></h:outputText>
			 <font color="red"><h:outputLabel value="*"></h:outputLabel></font>
			 </span>
		</h:panelGroup>
		 
		<h:selectOneMenu   value="#{viewUpdateGroupDetailsMB.locationId}" id="menu_geography" style="width: 180px"
			styleClass="listtableWHITESTRIP" valueChangeListener="#{viewUpdateGroupDetailsMB.viewGroupsOfSelectedLocation}" onchange="submit()">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{viewUpdateGroupDetailsMB.locationList}"/>
				
		</h:selectOneMenu>
		<h:message for="menu_geography"></h:message>
		
	
		<c:choose>
		<c:when test="${not empty viewUpdateGroupDetailsMB.groupNameList}">
		
		<h:panelGroup  >
		<span style="width: 100px;">
			 <h:outputText value="Group Name"></h:outputText>
			 <font color="red"><h:outputLabel value="*"></h:outputLabel></font>
		</span>
		</h:panelGroup>
		 
		<h:selectOneMenu  value="#{viewUpdateGroupDetailsMB.groupId}" id="menu_groupnames" style="width: 180px"
			styleClass="listtableWHITESTRIP" valueChangeListener="#{viewUpdateGroupDetailsMB.viewGroupDetail}" onchange="submit()" requiredMessage="Select group name" >
			<f:selectItem itemValue="0" itemLabel="-Select-"/>
			<f:selectItems value="#{viewUpdateGroupDetailsMB.groupNameList}"/>
		
		</h:selectOneMenu>
		<h:message for="menu_groupnames"></h:message>
		</c:when>
		</c:choose>
		</h:panelGrid>
		</div>
			<br>
		
			
		 
		
		
		<c:choose>
		<c:when test="${viewUpdateGroupDetailsMB.groupInfoTO!=null}">
		<h1 class="contentHEADER">Group Details</h1>
		<h:panelGrid border="1" columns="2" styleClass="filterBOX"  width="570"  columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
			
			<h:outputText value="Group Id"></h:outputText>
			 <h:outputText value="#{viewUpdateGroupDetailsMB.groupInfoTO.groupId}" style="width: 350px"></h:outputText>
		 
			 <h:outputText value="Group Name"></h:outputText>
			 <h:outputText value="#{viewUpdateGroupDetailsMB.groupInfoTO.groupName}" style="width: 350px"></h:outputText>
		 
		     <h:outputText value="Req. Group Description"></h:outputText>
		     <h:inputTextarea id="txtAreaGroupDescription" rows="3"  readonly="true" value="#{viewUpdateGroupDetailsMB.groupInfoTO.description}" styleClass="txtAreaNonEditable" />
			 
			         
			 <h:outputText value="Initating Group"></h:outputText>
			 <h:outputText value="#{viewUpdateGroupDetailsMB.groupInfoTO.initiatingGroupName}" style="width: 350px"></h:outputText>
			
			 <h:outputText value="Source"></h:outputText>
			 <h:outputText value="#{viewUpdateGroupDetailsMB.groupInfoTO.sourceName}" style="width: 350px"></h:outputText>
					
			 <h:outputText value="Market/Geography"></h:outputText>
			 <h:outputText value="#{viewUpdateGroupDetailsMB.groupInfoTO.locationName}" style="width: 350px"></h:outputText>
								
			 <h:outputText value="Customer/Prospect"></h:outputText>
			 <h:outputText value="#{viewUpdateGroupDetailsMB.groupInfoTO.customer_prospect}" style="width: 350px"></h:outputText>
								
			 <h:outputText value="Req. Group SPOC"></h:outputText>
			 <h:outputText value="#{viewUpdateGroupDetailsMB.groupInfoTO.SPOC}" style="width: 350px"></h:outputText>
			 		
			 <h:outputText value="Comments"></h:outputText>
			 <h:outputText value="#{viewUpdateGroupDetailsMB.groupInfoTO.comment}" style="width: 350px"></h:outputText>
			
		</h:panelGrid>
		<br>
		
		<c:if test="${not empty viewUpdateGroupDetailsMB.attachmentTOList}">
					 
					<h1 class="contentHEADER">Attachment Details</h1>
					
					<h:dataTable width="570" value="#{viewUpdateGroupDetailsMB.attachmentTOList}" border="1" var="attachment" binding="#{viewUpdateGroupDetailsMB.attachmentHtmlDataTable}" headerClass="listtableHEADLINE" rowClasses="listtableWHITESTRIP,listtableGREYSTRIP">
		<h:column id="column1">
			<f:facet name="header">
				<h:outputText value="Attachment ID"></h:outputText>
			</f:facet>
			<h:outputText value="#{attachment.groupAttachmentId}"></h:outputText>
		</h:column>
		<h:column id="column2">
			<f:facet name="header">
				<h:outputText value="Attachment"></h:outputText>
			</f:facet>
			<h:outputText value="#{attachment.fileName}"><img src="attachment_symbol.png" style="height: 20px; width: 20px;border:none;"/></h:outputText>
		</h:column>
		 
		<h:column id="column3">
			<f:facet name="header">
				<h:outputText value="Download"></h:outputText>
			</f:facet>
			<h:commandLink action="#{viewUpdateGroupDetailsMB.downloadAttachment}">
				<h:panelGroup>
				 <h:outputText value="Download"> </h:outputText>
				</h:panelGroup>	
			</h:commandLink>
		</h:column>
		<h:column id="column4">
			<f:facet name="header">
				<h:outputText value="Delete"></h:outputText>
			</f:facet>
			<h:commandLink action="#{viewUpdateGroupDetailsMB.removeGroupAttachment}">
				<h:panelGroup>
				 <h:outputText value="Remove"> </h:outputText>
				</h:panelGroup>	
			</h:commandLink>
		</h:column>
		 
		
	</h:dataTable>
	</c:if>
		<br><br>
			<h:commandButton value="Click Here to Update" styleClass="tableBUTTON"  action="#{viewUpdateGroupDetailsMB.editGroupDetails}"></h:commandButton>
		</c:when>
		
		
		<c:otherwise>
		<br>
		<h:outputText  styleClass="alertBOX" value="#{viewUpdateGroupDetailsMB.message}"></h:outputText>
		<br>
		</c:otherwise>
		 </c:choose>
		<br><br>
		
		<span class="fieldMANDATORY">*</span><span> Mandatory Fields</span>
		</h:form>
		</center>
</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>