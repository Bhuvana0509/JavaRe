<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.infy.managedBeans.MasterRequirementsReportsMB" %>
<%@page import="javax.faces.context.FacesContext"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Master Requirements Report</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javaScript" type="text/javascript" src="calendar.js"></script>
<link href="calendar.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>

<!-- calendar starts -->
<table id="calenderTable">
	<tbody id="calenderTableHead">
		<tr>
			<td colspan="4" align="center"><select
				onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,
	           this.selectedIndex, false));"
				id="selectMonth">
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
			</select></td>
			<td colspan="2" align="center"><select
				onChange="showCalenderBody(createCalender(this.value, 
				document.getElementById('selectMonth').selectedIndex, false));"
				id="selectYear">
			</select></td>
			<td align="center"><a href="#" onClick="closeCalender();"><font
				color="#003333" size="+1">X</font></a></td>
		</tr>
	</tbody>
	<tbody id="calenderTableDays">
		<tr style="">
			<td>Sun</td>
			<td>Mon</td>
			<td>Tue</td>
			<td>Wed</td>
			<td>Thu</td>
			<td>Fri</td>
			<td>Sat</td>
		</tr>
	</tbody>
	<tbody id="calender"></tbody>
</table>

<!-- ends -->

<f:view>
<jsp:include page="Header.jsp"></jsp:include>
<c:if test="${link!='MasterRequirementsReport'}">
	<%
	MasterRequirementsReportsMB masterRequirementsReportsMB =new MasterRequirementsReportsMB();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("masterRequirementsReportsMB", masterRequirementsReportsMB);
		
	%>
 	<c:set var="link" value="MasterRequirementsReport" scope="session"></c:set>
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
													<!--  changes done by Bhuvana -->
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
		 <td class="spaceBetweenVisitedLinks" >
		 	&gt; <h:outputLink value="MasterRequirementsReport.jsp"  styleClass="anchor" > Master Requirements </h:outputLink>
		  </td>
		</tr>
		<tr>
		 <td class="spaceBetweenLinks" >
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
<h1 class="contentHEADER">Master Requirements Report </h1>
<h:form id="MasterRequirementForm">

			
			<h:panelGrid border="0" styleClass="filterBOX" columns="4" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign,pannelGridMainColumn,pannegGridColumLeftAllign">
			
			 <h:outputText value="Group" style="width: 130px" ></h:outputText>
			 <h:selectOneMenu style="width: 180px" value="#{masterRequirementsReportsMB.groupId}" binding="#{masterRequirementsReportsMB.groupSelectMenu}" id="menu_group" styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{masterRequirementsReportsMB.groupNamesList}"/>
			</h:selectOneMenu>
			
			
			
			 <h:outputText value="Vertical" ></h:outputText>
			<h:selectOneMenu style="width: 180px" value="#{masterRequirementsReportsMB.verticalId}" binding="#{masterRequirementsReportsMB.verticalSelectMenu}" 
				id="menu_vertical" styleClass="listtableWHITESTRIP" valueChangeListener="#{masterRequirementsReportsMB.getAllModulesByVertical}" onchange="submit()">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{masterRequirementsReportsMB.verticalList}"/>
			</h:selectOneMenu>
			
			<!-- Changes done by Bhuvana starts -->
			
			<h:panelGroup style="width: 100px;">
			     <h:outputText value="Initiated By"></h:outputText>
			</h:panelGroup>
		 
			<h:selectOneMenu style="width: 180px" value="#{masterRequirementsReportsMB.initiatingGroupId}" id="menu_initiatedBy" binding="#{masterRequirementsReportsMB.initiatingGroupSelectMenu}"
			styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{masterRequirementsReportsMB.initiatingGroupList}"/>
			</h:selectOneMenu>
		    <!-- changes complete -->
		    
		     <!-- Changes done by Sanket starts -->
			
			<h:panelGroup style="width: 100px;">
			     <h:outputText value="Module"></h:outputText>
			</h:panelGroup>
		 
			<h:selectOneMenu style="width: 180px" value="#{masterRequirementsReportsMB.moduleId}" id="menu_module" binding="#{masterRequirementsReportsMB.moduleSelectMenu}"
			styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{masterRequirementsReportsMB.modulesList}"/>
			</h:selectOneMenu>
		    <!-- changes complete -->
		    
		    
			 <h:outputText value="Req Status" style="width: 130px"></h:outputText>
			<h:selectOneMenu style="width: 180px" value="#{masterRequirementsReportsMB.reqStatus}" binding="#{masterRequirementsReportsMB.statusSelectMenu}" 
			valueChangeListener="#{masterRequirementsReportsMB.enableCustomization}" id="menu_status" styleClass="listtableWHITESTRIP" onchange="submit()">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItem itemValue="Entered" itemLabel="Entered"/>
				<f:selectItem itemValue="Accepted" itemLabel="Accepted"/>
				<f:selectItem itemValue="Rejected" itemLabel="Rejected"/>
				
			</h:selectOneMenu>
	
			<h:selectBooleanCheckbox id="allMasterReq_CheckBox" value="#{masterRequirementsReportsMB.allMasterReqStatus}" binding="#{masterRequirementsReportsMB.allMasterReqCheckBox}" valueChangeListener="#{masterRequirementsReportsMB.selectallMasterReqCheckBox}" onclick="submit()"  ></h:selectBooleanCheckbox>
			<h:outputText style="font-weight: bold ; width:130px;"  value="All Master Requirements"></h:outputText>
			
			<!--   Changes made by Bhuvana starts  -->
			<h:outputText value="Region" ></h:outputText>
			 <h:selectOneMenu style="width: 180px" value="#{masterRequirementsReportsMB.locationId}"  binding="#{masterRequirementsReportsMB.locationSelectMenu}" id="menu_group1" styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{masterRequirementsReportsMB.locationList}"/>
			</h:selectOneMenu>
			
			<!-- Changes made by Bhuvana ends -->
			
			<!--  changes done by Sanket starts -->			
			
			<h:outputText value="Customization"></h:outputText>
			<h:selectOneMenu style="width: 180px" value="#{masterRequirementsReportsMB.customization}" binding="#{masterRequirementsReportsMB.customizationSelectMenu}" id="customization_status" styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItem itemValue="Yes" itemLabel="Yes"/>
				<f:selectItem itemValue="No" itemLabel="No"/>
			</h:selectOneMenu>
			<!-- changes completed -->
			
			<!-- changes done by Bhuvana starts -->	
			 <h:panelGroup>
			 <h:selectBooleanCheckbox id="chkbxFromdate" value="#{masterRequirementsReportsMB.dateStatus}" binding="#{masterRequirementsReportsMB.fromDateCheckBox}" valueChangeListener="#{masterRequirementsReportsMB.enableDateFields}" onclick="submit()"/>
			 <h:outputText value="From Date" ></h:outputText>
			 </h:panelGroup>
			<h:panelGroup id="fromdate">
		    <h:inputText  id="txtfromDate" value="#{masterRequirementsReportsMB.fromDate}" binding="#{masterRequirementsReportsMB.fromDateInputText}" styleClass="contentTEXT" style="width: 150px">						
			       <f:convertDateTime pattern="dd-MMM-yyyy"/>
		    </h:inputText>
		    
			<h:outputLink id="fromdateCalendarLink" value="#txtfromDate" onclick="setYears(1947, 2012);showMyCalendar(this);">
					<img src="calendar.png" style="height: 20px; width: 21px" border="0"/>
			</h:outputLink>
			
			</h:panelGroup>
			 
			<h:outputText value="To Date"></h:outputText>			
			<h:panelGroup id="todate">
		    <h:inputText  id="txttoDate" value="#{masterRequirementsReportsMB.toDate}"  binding="#{masterRequirementsReportsMB.toDateInputText}"  styleClass="contentTEXT" style="width: 150px">						
			       <f:convertDateTime pattern="dd-MMM-yyyy"/>
		    </h:inputText>
			<h:outputLink id="todateCalendarLink" value="#txttoDate" onclick="setYears(1947, 2012);showMyCalendar(this);">
					<img src="calendar.png" style="height: 20px; width: 21px" border="0"/>
			</h:outputLink>			
			</h:panelGroup>
		
			
			<!-- changes completed -->
			
			<h:panelGroup style="width: 100px;">
			     <h:outputText value="Search by Keywords"></h:outputText>
			</h:panelGroup>
		 <h:inputText id="txtSearchBy" value="#{masterRequirementsReportsMB.searchBy}" binding="#{masterRequirementsReportsMB.searchByInputText}" styleClass="tabletext" style="width: 150px" />
			
			
		</h:panelGrid><br>
		<h:commandButton styleClass="tableBUTTON" value="View" action="#{masterRequirementsReportsMB.viewMasterRequirementsDetails}" type="submit"></h:commandButton>
		
<c:choose>
<c:when test="${not empty masterRequirementsReportsMB.masterReqList}">		
 <h1 class="contentHEADER" style="position: relative;left: 70px;">Master Requirement List &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<span style="position: relative;left: 215px;"><h:commandLink styleClass="tableBUTTON"  action="#{masterRequirementsReportsMB.downloadMasterReqList}" ><img src="download_button.png" style="height: 28px; width: 97px;border:none;"/></h:commandLink></span> </h1><h:dataTable border="1" headerClass="listtableHEADLINE" width="900" rowClasses="listtableWHITESTRIP,listtableGREYSTRIP" value="#{masterRequirementsReportsMB.viewMasterReqPerPageList}" var="masterReq">
				

				<h:column id="column1">
					<f:facet name="header">
						<h:outputText value="Master Req Id"></h:outputText>
					</f:facet>
					<h:outputText value="#{masterReq.masterRequirementId}"></h:outputText>
				</h:column>
			

				<h:column id="column2">
					<f:facet name="header">
						<h:outputText value="Master Req Title"></h:outputText>
					</f:facet>
					<h:outputText value="#{masterReq.masterRequirementTitle}" ></h:outputText>
				</h:column>
				
				<h:column id="column3">
					<f:facet name="header">
						<h:outputText value="External Reference No"></h:outputText>
					</f:facet>
					<h:outputText value="#{masterReq.externalReferenceNumber}"></h:outputText>
				</h:column>
			
				<h:column id="column4">
					<f:facet name="header">
						<h:outputText value="Group Name"></h:outputText>
					</f:facet>
					<h:outputText value="#{masterReq.groupName}"></h:outputText>
				</h:column>
				
				<h:column id="column5">
					<f:facet name="header">
						<h:outputText value="Solution Name"></h:outputText>
					</f:facet>
					<h:outputText value="#{masterReq.solutionName}"></h:outputText>
				</h:column>
				
				<h:column id="column6">
					<f:facet name="header">
						<h:outputText value="Module Name"></h:outputText>
					</f:facet>
					<h:outputText value="#{masterReq.verticalName}"></h:outputText>
				</h:column>
				<!-- changes done by Bhuvana starts -->
				<h:column id="column7">
					<f:facet name="header">
						<h:outputText value="Submodule Name"></h:outputText>
					</f:facet>
					<h:outputText value="#{masterReq.moduleName}"></h:outputText>
				</h:column>
				<!-- changes completed -->
				
				<h:column id="column8">
					<f:facet name="header">
						<h:outputText value="Req Description"></h:outputText>
					</f:facet>
					<h:inputTextarea value="#{masterReq.description}" rows="3" cols="20" readonly="true" styleClass="contentTEXT" style="height: 30px"> </h:inputTextarea>
					
				</h:column>
				<h:column id="column9">
					<f:facet name="header">
						<h:outputText value="Contact Person"></h:outputText>
					</f:facet>
					<h:outputText value="#{masterReq.contactPerson}"></h:outputText>
				</h:column>
				<h:column id="column10">
					<f:facet name="header">
						<h:outputText value="Master Req Status"></h:outputText>
					</f:facet>
					<h:outputText value="#{masterReq.status}"></h:outputText>
				</h:column>
				
				<!-- Changes done by Sanket Mehta starts  -->
				<h:column id="column11">
					<f:facet name="header">
						<h:outputText value="Customization"></h:outputText>
					</f:facet>
						<h:outputText value="#{masterReq.customization}"></h:outputText>
				</h:column>
		        <!-- Changes complted -->
			
				</h:dataTable>
			<br>
	<span style="position:absolute; left:300px; text-align: left;">
			<h:outputText value="#{masterRequirementsReportsMB.pageMessage}" styleClass="formLABEL"></h:outputText>
		</span>
		<span style="position:absolute; left:650px;">
			<h:outputText value="Go to Page  " styleClass="contentTEXT"></h:outputText>&nbsp;&nbsp;&nbsp;
			<h:selectOneMenu id="selectMenuPage" value="#{masterRequirementsReportsMB.displayPageNumber}" styleClass="choiceBOX" valueChangeListener="#{masterRequirementsReportsMB.selectPageNumber}" onchange="submit()">
				<f:selectItem id="firstItem" itemLabel="-Select-" itemValue="0"/>
				<f:selectItems id="listItem" value="#{masterRequirementsReportsMB.pageNumberList}"/>
			</h:selectOneMenu>
		</span>
		<span style="position:absolute; left:1080px;">
			<h:commandLink action="#{masterRequirementsReportsMB.showPreviousRecord}" styleClass="tableBUTTON"><img src="previous_icon.png" style="height: 31px; width: 25px;border:none;"> </h:commandLink>
			&nbsp;&nbsp; <img src="tab_seperate.gif" border="0" style="height: 24px;"> &nbsp;&nbsp;
			<h:commandLink action="#{masterRequirementsReportsMB.showNextRecord}"   styleClass="tableBUTTON"><img src="next_icon.png" style="height: 31px; width: 25px; border:none;"> </h:commandLink>
		</span>
	
	<br>
	<br><br>
				
			</c:when>
			<c:otherwise>
				<br><br><h:outputText styleClass="alertBOX" value="#{masterRequirementsReportsMB.masterReqMessage}"></h:outputText>
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