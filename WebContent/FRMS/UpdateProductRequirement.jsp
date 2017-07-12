<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t"  uri="http://myfaces.apache.org/tomahawk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product Requirement Page</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javaScript" type="text/javascript" src="calendar.js"></script>
   <link href="calendar.css" rel="stylesheet" type="text/css">

</head>


<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<c:if test="${Role=='GU' or Role=='GS'}">
	<c:redirect url="AccessDeniedPage.jsp"></c:redirect>
</c:if>
<table id="calenderTable">
        <tbody id="calenderTableHead">
          <tr>
            <td colspan="4" align="center">
	          <select onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,
	           this.selectedIndex, false));" id="selectMonth">
	              <option value="0">Jan</option>
	              <option value="1">Feb</option>
	              <option value="2">Mar</option>
	              <option value="3">Apr</option>
	              <option value="4">May</option>
	              <option value="5">Jun</option>
	              <option value="6">Jul</option>
	              <option value="7">Aug</option>
	              <option value="8">Sep</option>
	              <option value="9">Oct</option>
	              <option value="10">Nov</option>
	              <option value="11">Dec</option>
	          </select>
            </td>
            <td colspan="2" align="center">
			    <select onChange="showCalenderBody(createCalender(this.value, 
				document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
				</select>
			</td>
            <td align="center">
			    <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">X</font></a>
			</td>
		  </tr>
       </tbody>
       <tbody id="calenderTableDays">
         <tr style="">
           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
         </tr>
       </tbody>
       <tbody id="calender"></tbody>
    </table>

<f:view>
<jsp:include page="Header.jsp"></jsp:include>

<div>
<table cellspacing="0" cellpadding="0" width="100%" border="0" class="mainnavTABLE">
							<tr>
								<td style="width: 100%;">
								<table class="mainnavTABLE" borderColor="#ff3300" cellspacing="0" cellpadding="0" width="100%" border="0" ID="tblImgSpacer" align="left">
									<tr style="height: 94px">
										<td class="mainnavLEFT" align="left" width="44%">
										
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
	
<table width="100" height="100" border="0" class="navigator_left" style="width: 169px"> 
		<tr>
		 <td class="spaceBetweenLinks">
		  &gt; <a class="anchor" href="ProductRequirementsHomePage.jsp"> Home</a>
		 	
		  </td>
		</tr>
		<tr>
		 <td class="spaceBetweenVisitedLinks">
		 &gt; <a class="anchor" href="ViewProductRequirement.jsp">View And Update</a>
		 	
		  </td>
		</tr>
		
		
		<tr>
				<td class="spaceBetweenLinks">
					  &gt; <h:outputLink value="ProductRequirementsAssignedToMe.jsp" styleClass="anchor">Items assigned to me</h:outputLink>
					</td>
				</tr>
</table>

</td>
<td width="1" bgcolor="#269DEB"> </td>
<td >
<center>
<br>
<span class="contentHEADER">View And Update Product Requirement</span>

		<h:form id="updateForm">
		
		<t:panelTabbedPane id="Updatetabbedpane" selectedIndex="0" frame="none" styleClass="tabbedPane"
                  activeTabStyleClass="activeTab"
                  inactiveTabStyleClass="inactiveTab"
                  disabledTabStyleClass="disabledTab"
                  activeSubStyleClass="activeSub"
                  inactiveSubStyleClass="inactiveSub"
                  tabContentStyleClass="tabContent">
                  
            <t:panelTab label="ProductRequirement" id="productPanelTab">
 		<h:panelGrid styleClass="filterBOX"  border="1" columns="3" id="updateGrid" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
					<h:outputText value="Product Requirement Id"></h:outputText>
					<h:outputText value="#{viewAndUpdateProductReqMB.productRequirementTO.productRequirementId}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					<h:outputText value=""></h:outputText>
					
					<h:panelGroup>
						<h:outputText value="Product Requirement Title" ></h:outputText>
						<h:outputText value="*" styleClass="fieldMANDATORY"></h:outputText>
					</h:panelGroup>
					<h:inputText id="txtProductReqTitle" size="50"  value="#{viewAndUpdateProductReqMB.productRequirementTO.productRequirementTitle}" required="true" requiredMessage="Product Requirment Title is mandatory"  styleClass="contentTEXT" style="width: 350px"></h:inputText>
					<h:message for="txtProductReqTitle"></h:message>

					<h:panelGroup>
						<h:outputText value="Product Requirement Description"></h:outputText>
						<h:outputText value="*" styleClass="fieldMANDATORY"></h:outputText>
					</h:panelGroup>
					<h:inputTextarea id="txtAreaProductDescription" rows="3"  value="#{viewAndUpdateProductReqMB.productRequirementTO.productRequirementDescription}" required="true" requiredMessage="Product Requirment Description is mandatory" styleClass="txtAreaEditable" ></h:inputTextarea>
					<h:message for="txtAreaProductDescription"></h:message>
					
					<h:outputText value="Master Requirement Id"></h:outputText>
					<h:outputText value="#{viewAndUpdateProductReqMB.productRequirementTO.masterRequirementId}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					<h:outputText value=""></h:outputText>
					
					<h:outputText value="Master Requirement Title"></h:outputText>
					<h:outputText value="#{viewAndUpdateProductReqMB.productRequirementTO.masterRequirementTitle}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					<h:outputText value=""></h:outputText>
					
					<h:outputText value="Master Requirement Description"></h:outputText>
					<h:inputTextarea id="txtAreaMasterDescription"  rows="3" readonly="true" value="#{viewAndUpdateProductReqMB.productRequirementTO.masterRequirementDescription}" styleClass="txtAreaNonEditable" />
					<h:outputText value=""></h:outputText>
					
					<h:panelGroup>
						<h:outputText value="Product Version"></h:outputText>
					</h:panelGroup>
					
					
					<h:selectOneMenu id="versionMenu" value="#{viewAndUpdateProductReqMB.productRequirementTO.productVersion}" styleClass="choiceBOX" style="width: 200px">
						        <f:selectItem itemLabel="-Select-" itemValue="0" />
						        <f:selectItems value="#{viewAndUpdateProductReqMB.versionList}"/>
					            </h:selectOneMenu>					            								
								<h:message for="versionMenu"></h:message>
					
					<h:outputText value="Group Name"></h:outputText>
					<h:outputText value="#{viewAndUpdateProductReqMB.productRequirementTO.groupName}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					<h:outputText value=""></h:outputText>
					
					<h:outputText value="Vertical Name"></h:outputText>
					<h:outputText value="#{viewAndUpdateProductReqMB.productRequirementTO.verticalName}" style="width: 350px"></h:outputText>
					<h:outputText value=""></h:outputText>
					
					<!-- changes done by Bhuvana starts -->
					<h:outputText value="Module Name"></h:outputText>
					<h:outputText value="#{viewAndUpdateProductReqMB.productRequirementTO.moduleName}" style="width: 350px"></h:outputText>
					<h:outputText value=""></h:outputText>
					<!-- changes completed -->
					
					<h:panelGroup>
						<h:outputText value="Localization"></h:outputText>
					</h:panelGroup>
										
					<h:selectOneMenu id="localizationMenu" value="#{viewAndUpdateProductReqMB.productRequirementTO.localization}" binding="#{viewAndUpdateProductReqMB.localizationSelectMenu}" styleClass="choiceBOX" style="width: 200px">
						        <f:selectItem itemLabel="-Select-" itemValue="0" />
						        <f:selectItems value="#{viewAndUpdateProductReqMB.localizationList}"/>
					            </h:selectOneMenu>
					<h:message for="localizationMenu"></h:message>
					
					<h:panelGroup>
						<h:outputText value="Functional Effort"></h:outputText>
					</h:panelGroup>
					<h:inputText  id="txtfunctionalEffort" value="#{viewAndUpdateProductReqMB.productRequirementTO.functionalEffort}" styleClass="contentTEXT" style="width: 350px">
					</h:inputText> 
					<h:message for="txtfunctionalEffort"></h:message>
					
					<h:panelGroup>
						<h:outputText value="Development Effort"></h:outputText>
					</h:panelGroup>
					<h:inputText id="txtdevelopmentEffort" size="50" value="#{viewAndUpdateProductReqMB.productRequirementTO.developmentEffort}" styleClass="contentTEXT" style="width: 350px"></h:inputText>
					<h:message for="txtdevelopmentEffort"></h:message>
					
					<h:panelGroup>
						<h:outputText value="DG Owner"></h:outputText>
					</h:panelGroup>
					
					<h:selectOneMenu value="#{viewAndUpdateProductReqMB.productRequirementTO.emailId}" id="menu_dgOwner"
			                styleClass="listtableWHITESTRIP" onchange="submit()" style="width: 200px">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{addMasterRequirementMB.loginList}"/>				
			</h:selectOneMenu>
						
					<h:message for="menu_dgOwner"></h:message>
						
					
					<h:panelGroup>
						<h:outputText value="Comments"></h:outputText>
					</h:panelGroup>
					<h:inputText id="txtComments" size="50" value="#{viewAndUpdateProductReqMB.productRequirementTO.comments}" styleClass="contentTEXT" style="width: 350px"></h:inputText>
					<h:message for="txtComments"></h:message>

				</h:panelGrid>
				
				</t:panelTab>
				
				<t:panelTab label="FRS Details" id="frsPanelTab">
					

						<h:panelGrid styleClass="filterBOX" border="1" columns="2" width="550"
							columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
							
							<h:outputText value="Product Requirement ID"  ></h:outputText>
							<h:outputText
								value="#{viewAndUpdateProductReqMB.productRequirementTO.productRequirementId}"
								style="width: 350px;"></h:outputText>

							<h:outputText value="FRS ID" ></h:outputText>
							<h:outputText
								value="#{viewAndUpdateProductReqMB.productRequirementTO.frsId}"
								style="width: 350px;"></h:outputText>

							<h:outputText value="FRS Document Name" ></h:outputText>
							<h:inputText 
							id="txtFrsName" value="#{viewAndUpdateProductReqMB.productRequirementTO.FRSDocumentName}" 
							 style="width: 350px" styleClass="contentTEXT" />
								
							 
							 


							<h:outputText value="Project Code" ></h:outputText>
							<h:inputText 
							id="txtFrsProjectCode" value="#{viewAndUpdateProductReqMB.productRequirementTO.projectCode}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 

							<h:outputText value="FRS Owner" ></h:outputText>
							<h:panelGroup>
							<h:inputText 
							id="txtFRSOwner" value="#{viewAndUpdateProductReqMB.productRequirementTO.frsOwnerEmailId}" 
							 style="width: 250px" styleClass="contentTEXT" />
							 <h:outputText  styleClass="contentTEXT" value="@infosys.com"></h:outputText>
							 </h:panelGroup>



							<h:outputText value="FRS Status" ></h:outputText>
							<h:selectOneMenu value="#{viewAndUpdateProductReqMB.productRequirementTO.frsStatus}" 
							styleClass="selectOneMenu" style="width: 150px" >
								<f:selectItem itemLabel="Yet To Start" itemValue="Yet To Start"/>
								<f:selectItem itemLabel="WIP" itemValue="WIP"/>
								<f:selectItem itemLabel="Draft Ready" itemValue="Draft Ready"/>
								<f:selectItem itemLabel="Group 	Reviewed" itemValue="Group 	Reviewed"/>
								<f:selectItem itemLabel="Baselined" itemValue="Baselined"/>
								<f:selectItem itemLabel="CR To Drop" itemValue="CR To Drop"/>
								<f:selectItem itemLabel="Not Applicable" itemValue="Not Applicable"/>
								
							</h:selectOneMenu>
							 
							<h:outputText value="Planned Date" ></h:outputText>
							<h:panelGroup id="frsPlannedDateGroupPanel">
								<h:inputText  id="txtplannedDateForFRS" 
						    		 value="#{viewAndUpdateProductReqMB.productRequirementTO.plannedDateForFRS}"  
						    		  styleClass="contentTEXT" style="width: 150px">
						
									<f:convertDateTime pattern="dd-MMM-yyyy"/>
								</h:inputText>
								<a href="#txtplannedDateForFRS" id="linktag" onClick="setYears(1947, 2012);showCalender(this, 'updateForm:frsPanelTab:txtplannedDateForFRS');">
      								<img src="calendar.png" style="height: 20px; width: 21px" border="0" />
      							</a>	
							</h:panelGroup>
							 

							<h:outputText value="Actual Date" ></h:outputText>
							<h:panelGroup id="frsActualDateGroupPanel">
								<h:inputText  id="txtActualDateForFRS" 
						    		 value="#{viewAndUpdateProductReqMB.productRequirementTO.actualDateForFRS}"  
						    		  styleClass="contentTEXT" style="width: 150px">
						
									<f:convertDateTime pattern="dd-MMM-yyyy"/>
								</h:inputText>
								<a href="#txtActualDateForFRS" id="linktag" onClick="setYears(1947, 2012);showCalender(this, 'updateForm:frsPanelTab:txtActualDateForFRS');">
      								<img src="calendar.png" style="height: 20px; width: 21px" border="0" />
      							</a>	
							</h:panelGroup>
							 

							<h:outputText value="Group Review Date" ></h:outputText>
							<h:panelGroup id="frsGRGroupPanel">
								<h:inputText  id="txtGroupReviewDateForFRS" 
						    		 value="#{viewAndUpdateProductReqMB.productRequirementTO.groupReviewDateForFRS}"  
						    		  styleClass="contentTEXT" style="width: 150px">
						
									<f:convertDateTime pattern="dd-MMM-yyyy"/>
								</h:inputText>
								<a href="#txtGroupReviewDateForFRS" id="linktag" onClick="setYears(1947, 2012);showCalender(this, 'updateForm:frsPanelTab:txtGroupReviewDateForFRS');">
      								<img src="calendar.png" style="height: 20px; width: 21px" border="0" />
      							</a>	
							</h:panelGroup>
						 
							<h:outputText value="FRS Remarks" ></h:outputText>
							<h:inputText 
							id="txtFRSRemarks" value="#{viewAndUpdateProductReqMB.productRequirementTO.frsRemarks}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 

							<h:outputText value="Checked In TFS" ></h:outputText>
							<h:selectOneRadio id="radioFRSTFS" value="#{viewAndUpdateProductReqMB.productRequirementTO.frsCheckedInTFS}"
							styleClass="filterBOX">
								<f:selectItem itemLabel="Yes" itemValue="Yes"/>
								<f:selectItem itemLabel="No" itemValue="No"/>
							
							</h:selectOneRadio>
							 
							 
							 

							 

						</h:panelGrid>

						
				
				</t:panelTab>
				
				 <t:panelTab label="SRS Details" id="srsPanelTab">
				

						<h:panelGrid styleClass="filterBOX" border="1" columns="2" width="550"
							columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
							
							<h:outputText value="Product Requirement ID"></h:outputText>
							<h:outputText
								value="#{viewAndUpdateProductReqMB.productRequirementTO.productRequirementId}"
								style="width: 350px"></h:outputText>

							<h:outputText value="SRS ID"></h:outputText>
							<h:outputText
								value="#{viewAndUpdateProductReqMB.productRequirementTO.srsId}"
								style="width: 350px"></h:outputText>

							<h:outputText value="SRS Document Name"></h:outputText>
							<h:inputText id="txtSrsName" value="#{viewAndUpdateProductReqMB.productRequirementTO.SRSDocumentName}"
							 style="width: 350px" styleClass="contentTEXT"/>


							
							<h:outputText value="SRS Owner"></h:outputText>
							<h:panelGroup>
								<h:inputText id="txtSrsOwnerId" value="#{viewAndUpdateProductReqMB.productRequirementTO.srsOwnerEmailId}"
								 style="width: 250px" styleClass="contentTEXT"/>
								 <h:outputText  styleClass="contentTEXT" value="@infosys.com"></h:outputText>
							</h:panelGroup>



							<h:outputText value="SRS Status"></h:outputText>
							<h:selectOneMenu id="selectMenuSRSStatus" value="#{viewAndUpdateProductReqMB.productRequirementTO.srsStatus}" 
							styleClass="selectOneMenu" style="width: 150px" >
								<f:selectItem itemLabel="Yet To Start" itemValue="Yet To Start"/>
								<f:selectItem itemLabel="WIP" itemValue="WIP"/>
								<f:selectItem itemLabel="Draft Ready" itemValue="Draft Ready"/>
								<f:selectItem itemLabel="Group 	Reviewed" itemValue="Group 	Reviewed"/>
								<f:selectItem itemLabel="Baselined" itemValue="Baselined"/>
								<f:selectItem itemLabel="CR To Drop" itemValue="CR To Drop"/>
								<f:selectItem itemLabel="Not Applicable" itemValue="Not Applicable"/>
								
							</h:selectOneMenu>
						 
							<h:outputText value="Planned Date" ></h:outputText>
							<h:panelGroup id="srsPlannedDateGroupPanel">
								<h:inputText  id="txtplannedDateForSRS" 
						    		 value="#{viewAndUpdateProductReqMB.productRequirementTO.plannedDateForSRS}"  
						    		  styleClass="contentTEXT" style="width: 150px">
						
									<f:convertDateTime pattern="dd-MMM-yyyy"/>
								</h:inputText>
								<a href="#txtplannedDateForSRS" id="linktag" onClick="setYears(1947, 2012);showCalender(this, 'updateForm:srsPanelTab:txtplannedDateForSRS');">
      								<img src="calendar.png" style="height: 20px; width: 21px" border="0" />
      							</a>	
							</h:panelGroup>
							 

							<h:outputText value="Actual Date" ></h:outputText>
							<h:panelGroup id="srsActualGroupPanel">
								<h:inputText  id="txtActualDateForSRS" 
						    		 value="#{viewAndUpdateProductReqMB.productRequirementTO.actualDateForSRS}"  
						    		  styleClass="contentTEXT" style="width: 150px">
						
									<f:convertDateTime pattern="dd-MMM-yyyy"/>
								</h:inputText>
								<a href="#txtActualDateForSRS" id="linktag" onClick="setYears(1947, 2012);showCalender(this, 'updateForm:srsPanelTab:txtActualDateForSRS');">
      								<img src="calendar.png" style="height: 20px; width: 21px" border="0" />
      							</a>	
							</h:panelGroup>
							 

							<h:outputText value="Group Review Date" ></h:outputText>
							<h:panelGroup id="srsGRDGroupPanel">
								<h:inputText  id="txtGroupReviewDateForSRS" 
						    		 value="#{viewAndUpdateProductReqMB.productRequirementTO.groupReviewDateForSRS}"  
						    		  styleClass="contentTEXT" style="width: 150px">
						
									<f:convertDateTime pattern="dd-MMM-yyyy"/>
								</h:inputText>
								<a href="#txtGroupReviewDateForSRS" id="linktag" onClick="setYears(1947, 2012);showCalender(this, 'updateForm:srsPanelTab:txtGroupReviewDateForSRS');">
      								<img src="calendar.png" style="height: 20px; width: 21px" border="0" />
      							</a>	
							</h:panelGroup>
						 
							<h:outputText value="SRS Remarks" ></h:outputText>
							<h:inputText 
							id="txtSRSRemarks" value="#{viewAndUpdateProductReqMB.productRequirementTO.srsRemarks}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 

							<h:outputText value="Checked In TFS" ></h:outputText>
							<h:selectOneRadio id="radioSRSTFS" value="#{viewAndUpdateProductReqMB.productRequirementTO.srsCheckedInTFS}"
							styleClass="filterBOX">
								<f:selectItem itemLabel="Yes" itemValue="Yes"/>
								<f:selectItem itemLabel="No" itemValue="No"/>
							
							</h:selectOneRadio>
							 
							 
							 
						</h:panelGrid>

				
						
				
				</t:panelTab>
				
				 <t:panelTab label="Impact Details" id="impactPanelTab">
					

						<h:panelGrid styleClass="filterBOX" border="1" columns="2" width="550"
							columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
							<h:outputText value="Product Requirement ID"></h:outputText>
							<h:outputText
								value="#{viewAndUpdateProductReqMB.productRequirementTO.productRequirementId}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Impact Id"></h:outputText>
							<h:outputText
								value="#{viewAndUpdateProductReqMB.productRequirementTO.impactId}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Archie Impact"></h:outputText>
							<h:inputText 
							id="txtArchieImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.archieImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							
							<h:outputText value="Core Impact"></h:outputText>
							<h:inputText 
							id="txtcoreImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.coreImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="CRM Impact"></h:outputText>
							<h:inputText 
							id="txtCRMImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.CRMImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="FAS Impact"></h:outputText>
							<h:inputText 
							id="txtFASImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.FASImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="ODS Impact"></h:outputText>
							<h:inputText 
							id="txtodsImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.odsImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
						 
							
							<h:outputText value="FI Impact"></h:outputText>
							<h:inputText 
							id="txtfiImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.fiImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="E-Banking Impact"></h:outputText>
							<h:inputText 
							id="txtEBankingImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.EBankingImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="Direct Banking Impact"></h:outputText>
							<h:inputText 
							id="txtdirectBankingImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.directBankingImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="Origination Impact"></h:outputText>
							<h:inputText 
							id="txtoriginationImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.originationImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="FDMI Impact"></h:outputText>
							<h:inputText 
							id="txtFDMImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.FDMImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							<h:outputText value="Treasury Impact"></h:outputText>
							<h:inputText 
							id="txttreasuryImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.treasuryImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="WMS Impact"></h:outputText>
							<h:inputText 
							id="txtWMSImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.WMSImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="Finanz Tool Impact"></h:outputText>
							<h:inputText 
							id="txtfinanzToolImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.finanzToolImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="Multichannel Impact"></h:outputText>
							<h:inputText 
							id="txtmultichannelImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.multichannelImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="SSO Impact"></h:outputText>
							<h:inputText 
							id="txtSSOImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.SSOImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="24 BY 7 Impact"></h:outputText>
							<h:inputText 
							id="txtall24By7Impact" value="#{viewAndUpdateProductReqMB.productRequirementTO.all24By7Impact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="SVS Impact"></h:outputText>
							<h:inputText 
							id="txtsvsImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.svsImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="Fab Impact"></h:outputText>
							<h:inputText 
							id="txtfabImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.fabImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="CSIS Impact"></h:outputText>
							<h:inputText 
							id="txtcsisImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.csisImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
						 
							
							<h:outputText value="LOS Impact"></h:outputText>
							<h:inputText 
							id="txtLOSImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.LOSImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="FCA Impact"></h:outputText>
							<h:inputText 
							id="txtFCAImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.FCAImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
							<h:outputText value="Third partyImpact"></h:outputText>
							<h:inputText 
							id="txtthirdPartyImpact" value="#{viewAndUpdateProductReqMB.productRequirementTO.thirdPartyImpact}" 
							 style="width: 350px" styleClass="contentTEXT" />
							 
							
						</h:panelGrid>

			
						
					
				</t:panelTab>
			</t:panelTabbedPane>
				
			
				
				<br><br>
				<h:commandButton type="submit" action="#{viewAndUpdateProductReqMB.updateProductRequirements}" styleClass="tableBUTTON" value="Update" ></h:commandButton>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<h:commandButton type="submit" action="#{viewAndUpdateProductReqMB.cancelUpdate}" immediate="true" styleClass="tableBUTTON" value="Cancel" ></h:commandButton>
				
				<br><br><br>
				<h:outputText value="#{viewAndUpdateProductReqMB.message}" styleClass="alertBOX"></h:outputText>

			</h:form>
			
			
			
			
			</center>
				
				</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>