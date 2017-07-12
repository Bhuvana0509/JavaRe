<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.infy.managedBeans.ProductRequirementsReportsMB" %>
<%@page import="javax.faces.context.FacesContext"%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Requirements Report Page </title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<f:view>
<jsp:include page="Header.jsp"></jsp:include>

<c:if test="${link!='ProductRequirementsReports'}">
	<%
	ProductRequirementsReportsMB productRequirementsReportsMB =new ProductRequirementsReportsMB();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productRequirementsReportsMB", productRequirementsReportsMB);
		
	%>
 	<c:set var="link" value="ProductRequirementsReports" scope="session"></c:set>
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
													<td id="Cell_5" class="mainnavTABSon" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_5" class="mainnavTABSlinkON" href="ReportsHomePage.jsp">Reports</a></td>
														</tr>
													</table>
													</td>
													<!-- changes done by Bhuvana -->
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
	
<table width="100" height="100" border="0" class= "navigator_left" style="width: 169px" > 
		<tr>
		 <td class="spaceBetweenLinks" >
		 	&gt; <h:outputLink value="ReportsHomePage.jsp"  styleClass="anchor" >Home</h:outputLink>
		  </td>
		</tr>
		<tr>
		 <td class="spaceBetweenLinks" >
		 	&gt; <h:outputLink value="MasterRequirementsReport.jsp"  styleClass="anchor" > Master Requirements </h:outputLink>
		  </td>
		</tr>
		<tr>
		 <td class="spaceBetweenVisitedLinks" >
		 	&gt; <h:outputLink value="ProductRequirementsReport.jsp"  styleClass="anchor" > Product Requirements</h:outputLink>
		  </td>
		</tr>
		<tr>
		 <td class="spaceBetweenLinks">
			 &gt; <h:outputLink value="GroupDetailsReport.jsp"  styleClass="anchor" > Group Details</h:outputLink>
		  </td>
		</tr>
		
</table>

</td>
<td width="1" bgcolor="#269DEB"> </td>
<td valign="top"> 
<center>
<br>
<h:form id="ProductRequirementForm">
<h1 class="contentHEADER">Product Requirements Report &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h1>
<h:panelGrid border="0" styleClass="filterBOX" columns="4" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign,pannelGridMainColumn,pannegGridColumLeftAllign">
	<h:outputText value="Select Group"/>
					<h:selectOneMenu id="groupMenu"  value="#{productRequirementsReportsMB.groupId}" styleClass="choiceBOX" binding="#{productRequirementsReportsMB.groupSelectMenu}" style="width: 195px">
					<f:selectItem itemLabel="-Select-" itemValue="0" />
						<f:selectItems value="#{productRequirementsReportsMB.groupNamesList}"/>
					</h:selectOneMenu>
												
					<h:outputText value="Assigned to"/>
					<h:inputText id="txtMasterReqId" value="#{productRequirementsReportsMB.assignedToEmpId}" binding="#{productRequirementsReportsMB.assignedToInputText}" disabled="true" styleClass="tabletext" style="width: 125px"/>
								
					 
					<h:outputText value="Select Vertical"/>
					<h:selectOneMenu id="verticalMenu" value="#{productRequirementsReportsMB.verticalId}" styleClass="choiceBOX" binding="#{productRequirementsReportsMB.verticalSelectMenu}" 
									onchange="submit()" style="width: 195px">
						<f:selectItem itemLabel="-Select-" itemValue="0"/>
						<f:selectItems value="#{productRequirementsReportsMB.verticalList}"/>
					</h:selectOneMenu>
					
				
                     					
					  <h:selectBooleanCheckbox value="#{productRequirementsReportsMB.unassignedProductReqStatus}" binding="#{productRequirementsReportsMB.unassignedProductReqCheckBox}" valueChangeListener="#{productRequirementsReportsMB.selectUnassignedProductReqCheckBox}" onclick="submit()"/>
					  <h:outputText style="font-weight: bold"  value="Unassigned Product Req"/>
					  
					  
					<!-- Changes done by Sanket starts -->
			
					<h:panelGroup style="width: 100px;">
			     		<h:outputText value="Select Module"></h:outputText>
					</h:panelGroup>
			 
					<h:selectOneMenu 	style="width: 195px" 
										value="#{productRequirementsReportsMB.moduleId}" 
										id="moduleMenu" 
										binding="#{productRequirementsReportsMB.moduleSelectMenu}" onchange="submit()"
										styleClass="choiceBOX" >
						<f:selectItem itemValue="0" itemLabel="-Select-"/>
							<f:selectItems value="#{productRequirementsReportsMB.modulesList}"/>
					</h:selectOneMenu>
						    <!-- changes complete -->
								 			
					
					
				 <h:selectBooleanCheckbox value="#{productRequirementsReportsMB.allProductReqStatus}" binding="#{productRequirementsReportsMB.allProductReqCheckBox}" valueChangeListener="#{productRequirementsReportsMB.selectallProductReqCheckBox}" onclick="submit()"/>
					  <h:outputText style="font-weight: bold"  value="All Product Requirements"/>
					  
				 <h:outputText value="Select Version"/>
				<h:selectOneMenu id="versionMenu" value="#{productRequirementsReportsMB.version}" styleClass="choiceBOX" binding="#{productRequirementsReportsMB.versionSelectMenu}" style="width: 195px">
						<f:selectItem itemLabel="-Select-" itemValue="0"/>
						<f:selectItems value="#{productRequirementsReportsMB.versionList}"/>
				</h:selectOneMenu>
					  
					  <!--   Changes made by Bhuvana starts  -->
					  
			        <h:outputText value="Select Region"/>
					<h:selectOneMenu id="locationMenu" value="#{productRequirementsReportsMB.locationId}" styleClass="choiceBOX" binding="#{productRequirementsReportsMB.locationSelectMenu}" style="width: 195px">
						<f:selectItem itemLabel="-Select-" itemValue="0"/>
						<f:selectItems value="#{productRequirementsReportsMB.locationList}"/>
					</h:selectOneMenu>
			
			<!-- Changes made by Bhuvana ends -->
			
			<!-- changes done by sanket mehta -->
				 <h:panelGroup >
				 	<h:outputText value="Initiated By"></h:outputText>
				</h:panelGroup>
				 
				<h:selectOneMenu  id="initiatedByMenu" value="#{productRequirementsReportsMB.initiatingGroupId}" binding="#{productRequirementsReportsMB.initiatingGroupSelectMenu}"  style="width: 125px"
				styleClass="choiceBOX">
					<f:selectItem itemValue="0" itemLabel="-Select-"/>
					<f:selectItems value="#{productRequirementsReportsMB.initiatingGroupList}"/>				
				</h:selectOneMenu>
			<!-- changes completed-->
							
				</h:panelGrid><br>
<h:commandButton value="View " action="#{productRequirementsReportsMB.viewProductRequirementsDetails}" styleClass="tableBUTTON"/>
<c:choose>
<c:when test="${not empty productRequirementsReportsMB.productReqList}">

<h1 class="contentHEADER" style="position: relative;left: 45px;">Product Requirements List 

<span style="position: relative;left: 100px;"><h:commandLink styleClass="tableLink"  action="#{productRequirementsReportsMB.downloadProductReqList}" value="Download PR List"></h:commandLink>&nbsp;&nbsp;
				
				<!-- Added for RCD/RS Tracker -->
				<h:commandLink styleClass="tableLink" action="#{productRequirementsReportsMB.downloadProductReqListAsRCDTracker}" value="Download As RCD"></h:commandLink>&nbsp;&nbsp;
				<h:commandLink styleClass="tableLink" action="#{productRequirementsReportsMB.downloadProductReqListAsRSTracker}" value="Download As RSTracker"></h:commandLink>
				
				</span> </h1>

 
<h:dataTable border="1" headerClass="listtableHEADLINE" rowClasses="listtableWHITESTRIP,listtableGREYSTRIP" width="1000" value="#{productRequirementsReportsMB.viewProductReqPerPageList}" var="productReq">
				

				<h:column id="column1">
					<f:facet name="header">
						<h:outputText value="Product Req Id" style="width: 20px"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.productRequirementId}" style="width: 20px"></h:outputText>
				</h:column>
			

				<h:column id="column2" >
					<f:facet name="header">
						<h:outputText value="Product req Title" style="width: 20px" ></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.productRequirementTitle}" style="width: 20px" ></h:outputText>
				</h:column>
				<h:column id="column3">
					<f:facet name="header">
						<h:outputText value="Product Req Version"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.productVersion}"></h:outputText>
				</h:column>
				<h:column id="column4">
					<f:facet name="header">
						<h:outputText value="Product Req Description"></h:outputText>
					</f:facet>
					<h:inputTextarea value="#{productReq.productRequirementDescription}" rows="3" cols="20" readonly="true" styleClass="contentTEXT" style="height: 60px" > </h:inputTextarea>
				</h:column>
				<h:column id="column5">
						<f:facet name="header">
								<h:outputText value="Master Requirement ID"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.masterRequirementId}"></h:outputText>
					</h:column>
					
				<h:column id="column6">
					<f:facet name="header">
						<h:outputText value="Master Req Title"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.masterRequirementTitle}"></h:outputText>
				</h:column>
			
				<h:column id="column7">
					<f:facet name="header">
						<h:outputText value="Group Name"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.groupName}"></h:outputText>
				</h:column>
				
				<h:column id="column8">
						<f:facet name="header">
							<h:outputText value="Vertical Name"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.verticalName}"></h:outputText>
				</h:column>
				<!-- changes done by Bhuvana starts -->
				<h:column id="column9">
						<f:facet name="header">
							<h:outputText value="Module Name"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.moduleName}"></h:outputText>
				</h:column>
				<!-- changes completed -->
					
				<h:column id="column10">
					<f:facet name="header">
						<h:outputText value="FRS ID"></h:outputText>
						</f:facet>
					<h:outputText value="#{productReq.frsId}"></h:outputText>
				</h:column>
				<h:column id="column11">
					<f:facet name="header">
						<h:outputText value="FRS Owner">
					 
						</h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.frsOwnerEmailId}"></h:outputText>
				</h:column>
				<h:column id="column12">
					<f:facet name="header">
						<h:outputText value="SRS ID"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.srsId}"></h:outputText>
				</h:column>
				
				<h:column id="column13">
					<f:facet name="header">
						<h:outputText value="SRS Owner">
						 
						</h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.srsOwnerEmailId}"></h:outputText>
				</h:column>
			
			<h:column id="column14">
					<f:facet name="header">
						<h:outputText value="Approval Status"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.approvedStatus}"></h:outputText>
			</h:column>
			<h:column id="column15">
					<f:facet name="header">
						<h:outputText value="Comments"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.comments}"></h:outputText>
			</h:column>
				
			</h:dataTable>
			<br>
			<span style="position:absolute; left:232px; text-align: left;">
			<h:outputText value="#{productRequirementsReportsMB.pageMessage}" styleClass="formLABEL"></h:outputText>
		</span>
		<span style="position:absolute; left:650px;">
			<h:outputText value="Go to Page  " styleClass="contentTEXT"></h:outputText>&nbsp;&nbsp;&nbsp;
			<h:selectOneMenu id="selectMenuPage" value="#{productRequirementsReportsMB.displayPageNumber}" styleClass="choiceBOX" valueChangeListener="#{productRequirementsReportsMB.selectPageNumber}" onchange="submit()">
				<f:selectItem id="firstItem" itemLabel="-Select-" itemValue="0"/>
				<f:selectItems id="listItem" value="#{productRequirementsReportsMB.pageNumberList}"/>
			</h:selectOneMenu>
		</span>
		<span style="position:absolute; left:1090px;">
			<h:commandLink action="#{productRequirementsReportsMB.showPreviousRecord}" styleClass="tableBUTTON"><img src="previous_icon.png" style="height: 31px; width: 25px;border:none;"> </h:commandLink>
			&nbsp;&nbsp; <img src="tab_seperate.gif" border="0" style="height: 24px;"> &nbsp;&nbsp;
			<h:commandLink action="#{productRequirementsReportsMB.showNextRecord}"   styleClass="tableBUTTON"><img src="next_icon.png" style="height: 31px; width: 25px; border:none;"> </h:commandLink>
		</span>
			<br><br><br><br>
			</c:when>
			<c:otherwise>
			<br><br><h:outputText styleClass="alertBOX" value="#{productRequirementsReportsMB.productReqMessage}"></h:outputText>
			</c:otherwise>
			</c:choose>
			
			</h:form>
			</center>
</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>