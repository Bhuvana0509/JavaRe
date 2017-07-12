<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Master Requirement page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<f:view>
	<jsp:include page="Header.jsp"></jsp:include>
	<c:set var="link" value="ViewMasterRequirement" scope="session"></c:set>
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
							<td id="Cell_1" class="mainnavTABSoff" nowrap="nowrap"
								align="Center" valign="Middle">
							<table cellspacing="0" cellpadding="0" border="0"
								style="border-collapse: collapse;" ID="tblMy HomePage">
								<tr>
									<td nowrap="nowrap" align="Center" valign="Middle"><a
										id="hypl_1" class="mainnavTABSlinkOFF"
										href="DashboardHomePage.jsp">Dashboard</a></td>
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
							<td id="Cell_3" class="mainnavTABSon" nowrap="nowrap"
								align="Center" valign="Middle">
							<table cellspacing="0" cellpadding="0" border="0"
								style="border-collapse: collapse;" ID="tblMy HomePage"
								class="mainnavTABSon">
								<tr>
									<td nowrap="nowrap" align="Center" valign="Middle"><a
										id="hypl_3" class="mainnavTABSlinkON"
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
					<td class="mainnavLEFT">
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
	<table align="left" cellspacing="0" cellpadding="0"
		style="border-collapse: collapse;">
		<tr>

		</tr>
	</table>
	<table border="0" width="100%" height="355">
		<tr>
			<td width="170" valign="top">

			<table width="100" height="100" border="0" class="navigator_left" style="width: 169px" bgcolor="#A0BC31"> 
		<tr>
		 <td class="spaceBetweenLinks">
		 	&gt; <h:outputLink value="MasterRequirementsHomePage.jsp" styleClass="anchor">Home</h:outputLink>
		  </td>
		</tr>
		
		<tr>
		 <td class="spaceBetweenLinks">
		&gt; <h:outputLink value="AddNewMasterRequirement.jsp" styleClass="anchor">Add New </h:outputLink>
		 </td>
		</tr>
		
		<tr>
		 <td class="spaceBetweenVisitedLinks">
		  &gt; <h:outputLink value="ViewMasterRequirement.jsp" styleClass="anchor">View/Update </h:outputLink>
		 </td>
		</tr>
		<tr>
		 <td class="spaceBetweenLinks">
		  &gt; <h:outputLink value="UploadListOfMasterRequirement.jsp" styleClass="anchor">Upload list</h:outputLink>
		 </td>
		</tr>
		 
</table>

			</td>
			<td width="1" bgcolor="#269DEB"></td>
			<td valign="top" align="center"> 
			<br>
 					<h1 class="contentHEADER">Master Requirement Details</h1>
			<h:form id="viewmasterreqform">
			
				
	 			
 					<h:panelGrid styleClass="filterBOX" border="1" columns="2" width="570" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
						<h:outputText value="Master Requirement ID "></h:outputText>
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.masterRequirementId}" style="width: 350px"></h:outputText>
						<h:outputText value="Master Requirement Title "></h:outputText>
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.masterRequirementTitle}" style="width: 350px"></h:outputText>
						<h:outputText value="External Reference No."></h:outputText>
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.externalReferenceNumber}" style="width: 350px"></h:outputText>
						<h:outputText value="Master Requirement Description"></h:outputText>
						<h:inputTextarea id="txtAreaDescription" rows="3"  readonly="true" value="#{viewAndUpdateMasterReqMB.masterRequirementTO.description}" styleClass="txtAreaNonEditable" />
						
						<!-- changes done by sanket mehta -->
						<h:outputText value="Master Requirement Date"></h:outputText>
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.mrDate}" styleClass="contentTEXT" style="width: 350px">
						<f:convertDateTime pattern="dd-MMM-yyyy"/>
						</h:outputText>
						<!-- changes completed -->
						
						<h:outputText value="Group Name"></h:outputText>
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.groupName}" style="width: 350px"></h:outputText>
						<h:outputText value="Solution"></h:outputText>
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.solutionName}" style="width: 350px"></h:outputText>
						<h:outputText value="Vertical"></h:outputText>
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.verticalName}" style="width: 350px"></h:outputText>
						<h:outputText value="Module"></h:outputText>
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.moduleName}" style="width: 350px"></h:outputText>
						<h:outputText value="Contact For Master Requirement"></h:outputText>
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.contactPerson}" style="width: 350px"></h:outputText>
						<h:outputText value="Master Requirement Status"></h:outputText>
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.status}" style="width: 350px"></h:outputText>
						
						<h:outputText value="Comments"></h:outputText>
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.comments}" style="width: 350px"></h:outputText>
						
						<!-- Changes made by Bhuvana starts  -->
				     	<c:if test="${viewAndUpdateMasterReqMB.masterRequirementTO.status!=null}">
						<h:outputText value="Customization"></h:outputText>
						
						<h:outputText value="#{viewAndUpdateMasterReqMB.masterRequirementTO.customization}" style="width: 350px"></h:outputText>
						</c:if>
						<!-- Changes made by Bhuvana end -->
						
						
						
					</h:panelGrid>
					
					
					
					
					
					<c:if test="${not empty viewAndUpdateMasterReqMB.attachmentTOList}">
					<br>
					<h1 class="contentHEADER">Attachment Details</h1>
					
					<h:dataTable width="570" value="#{viewAndUpdateMasterReqMB.attachmentTOList}" border="1" var="attachment" binding="#{viewAndUpdateMasterReqMB.attachmentHtmlDataTable}" headerClass="listtableHEADLINE" rowClasses="listtableWHITESTRIP,listtableGREYSTRIP">
		<h:column id="column1">
			<f:facet name="header">
				<h:outputText value="Attachment ID"></h:outputText>
			</f:facet>
			<h:outputText value="#{attachment.MRAttachmentId}"></h:outputText>
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
			<h:commandLink action="#{viewAndUpdateMasterReqMB.downloadAttachment}">
				<h:panelGroup>
				 <h:outputText value="Download"> </h:outputText>
				</h:panelGroup>	
			</h:commandLink>
		</h:column>
		 
		
	</h:dataTable>
	</c:if>
					<br>
					<br>
					<c:if test="${viewAndUpdateMasterReqMB.masterRequirementTO.status=='Entered' and viewAndUpdateMasterReqMB.masterRequirementTO.ownerEmployeeId==EmployeeId or Role=='A' or Role=='PM'}">
					
					<h:commandButton value="Update" type="submit"
						action="#{viewAndUpdateMasterReqMB.prepareUpdate}" styleClass="tableBUTTON" ></h:commandButton> &nbsp; &nbsp; &nbsp; &nbsp;
					   
						<h:commandButton value="Accept/Reject"  action="#{viewAndUpdateMasterReqMB.acceptRejectMasterRequirement}" styleClass="tableBUTTON" disabled="#{viewAndUpdateMasterReqMB.disable1}"></h:commandButton>
					  					   
					 </c:if>
					 &nbsp; &nbsp; &nbsp; &nbsp;
					 <h:commandButton value="Back"  action="back" styleClass="tableBUTTON"></h:commandButton>
				      
			 
				<br>
				<br>
				<h:outputText value="#{viewAndUpdateMasterReqMB.message}" styleClass="alertBOX"></h:outputText>
				



			</h:form></td>
		</tr>
	</table>

	<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>