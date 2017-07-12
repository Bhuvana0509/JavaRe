<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.infy.managedBeans.ViewAndUpdateMasterReqMB"%>
<%@page import="javax.faces.context.FacesContext"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Master Requirement page</title>

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
	<c:if test="${link!='ViewMasterRequirement'}">
	<%
	ViewAndUpdateMasterReqMB viewAndUpdateMasterReqMB =new ViewAndUpdateMasterReqMB();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("viewAndUpdateMasterReqMB", viewAndUpdateMasterReqMB);
		
	%>
 	<c:set var="link" value="ViewMasterRequirement" scope="session"></c:set>
	</c:if>	
	
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
							
							<!--  Changes done by Bhuvana starts -->
							<td class="cellpading0px"><img src="tab_seperate.gif"
								border="0" style="height: 21px;"></td>
							<td id="Cell_6" class="mainnavTABSoff" nowrap="nowrap"
								align="Center" valign="Middle">
							<table cellspacing="0" cellpadding="0" border="0"
								style="border-collapse: collapse;" ID="tblMy Finance">
								<tr>
									<td nowrap="nowrap" align="Center" valign="Middle"><a
										id="hypl_6" class="mainnavTABSlinkOFF"
										href="AboutFRMSHomePage.jsp">About FRMS</a></td>
								</tr>
							</table>
							</td>
							<!-- chnages completed -->
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
								align="right">
								<span id="blUsername" >

													<h:outputText styleClass="emailLink" value="#{loginMB.emailId}" ></h:outputText> </span>
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
			<td valign="top" align="center"><br>
			

			
			<h1 class="contentHEADER">View And Update Master Requirement Details</h1>
			
			
			<h:form id="viewmasterreqform">
				 
				<h:panelGrid border="0" columns="4" styleClass="filterBOX" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign,pannelGridMainColumn,pannegGridColumLeftAllign">
			
			 <h:outputText value="Group"></h:outputText>
			 <h:selectOneMenu style="width: 180px" value="#{viewAndUpdateMasterReqMB.groupId}" binding="#{viewAndUpdateMasterReqMB.groupSelectMenu}" id="menu_group" styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
					<f:selectItems value="#{viewAndUpdateMasterReqMB.groupNamesList}" />
			</h:selectOneMenu>
			
		
		    
			
			<!-- Changes done by Bhuvana starts -->
			
			<h:panelGroup style="width: 100px;">
			     <h:outputText value="Initiated By"></h:outputText>
			</h:panelGroup>
		 
			<h:selectOneMenu style="width: 180px" value="#{viewAndUpdateMasterReqMB.initiatingGroupId}" id="menu_initiatedBy" binding="#{viewAndUpdateMasterReqMB.initiatingGroupSelectMenu}"
			styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{viewAndUpdateMasterReqMB.initiatingGroupList}"/>
			</h:selectOneMenu>
		    <!-- changes complete -->
		    
		   
			
			<h:outputText value="Req Status"></h:outputText>
			<h:selectOneMenu style="width: 180px" value="#{viewAndUpdateMasterReqMB.masterReqStatus}" binding="#{viewAndUpdateMasterReqMB.statusSelectMenu}" 
			valueChangeListener="#{viewAndUpdateMasterReqMB.enableCustomization}" id="menu_status" styleClass="listtableWHITESTRIP">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItem itemValue="Entered" itemLabel="Entered"/>
				<f:selectItem itemValue="Accepted" itemLabel="Accepted"/>
				<f:selectItem itemValue="Rejected" itemLabel="Rejected"/>
				<f:selectItem itemValue="Abandoned" itemLabel="Abandoned"/>
							
			</h:selectOneMenu>					
				
					<h:panelGroup style="width: 264px"> 
					 <h:selectBooleanCheckbox id="chkbxMasterReq" value="#{viewAndUpdateMasterReqMB.masterReqIdStatus}" binding="#{viewAndUpdateMasterReqMB.masterReqIdCheckBox}" valueChangeListener="#{viewAndUpdateMasterReqMB.selectMasterRequirementId}" onclick="submit()" ></h:selectBooleanCheckbox>
					 <h:outputText value="Master Requirement ID"></h:outputText>
					</h:panelGroup>
					<h:inputText id="txtMasterReqId" value="#{viewAndUpdateMasterReqMB.masterRequirementId}" binding="#{viewAndUpdateMasterReqMB.masterReqIdInputText}" styleClass="tabletext" style="width: 130px"></h:inputText>
					
			<!-- changes done by sanket mehta -->
			
			<h:panelGroup style="width: 100px;">
			 	<h:outputText value="Region"></h:outputText>

			</h:panelGroup>
		 
			<h:selectOneMenu   value="#{viewAndUpdateMasterReqMB.locationId}" binding="#{viewAndUpdateMasterReqMB.locationSelectMenu}" id="menu_geography" style="width: 180px"
			styleClass="listtableWHITESTRIP">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{viewAndUpdateMasterReqMB.locationList}"/>
				
		    </h:selectOneMenu>
		    
			<!-- changes completed -->	
						
			<!--  changes done by Bhuvana starts -->
			
			<h:outputText value="Customization"></h:outputText>
			<h:selectOneMenu style="width: 180px" value="#{viewAndUpdateMasterReqMB.customization}" binding="#{viewAndUpdateMasterReqMB.customizationSelectMenu}" id="customization_menu" styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItem itemValue="Yes" itemLabel="Yes"/>
				<f:selectItem itemValue="No" itemLabel="No"/>
			</h:selectOneMenu>
			
			 <!-- changes done by Bhuvana starts -->	
			 <h:panelGroup>
			 <h:selectBooleanCheckbox id="chkbxFromdate" value="#{viewAndUpdateMasterReqMB.dateStatus}" binding="#{viewAndUpdateMasterReqMB.fromDateCheckBox}" valueChangeListener="#{viewAndUpdateMasterReqMB.enableDateFields}" onclick="submit()"/>
			 <h:outputText value="From Date" ></h:outputText>
			 </h:panelGroup>
			<h:panelGroup id="fromdate">
		    <h:inputText  id="txtfromDate" value="#{viewAndUpdateMasterReqMB.fromDate}" binding="#{viewAndUpdateMasterReqMB.fromDateInputText}" styleClass="contentTEXT" style="width: 150px">						
			       <f:convertDateTime pattern="dd-MMM-yyyy"/>
		    </h:inputText>
		    
			<h:outputLink id="fromdateCalendarLink" value="#txtfromDate" onclick="setYears(1947, 2020);showMyCalendar(this);">
					<img src="calendar.png" style="height: 20px; width: 21px" border="0"/>
			</h:outputLink>
			 <h:message for="txtfromDate"/>
			 
			</h:panelGroup>
			
			 
			<h:outputText value="To Date"></h:outputText>			
			<h:panelGroup id="todate">
		    <h:inputText  id="txttoDate" value="#{viewAndUpdateMasterReqMB.toDate}" binding="#{viewAndUpdateMasterReqMB.toDateInputText}" styleClass="contentTEXT" style="width: 150px">						
			       <f:convertDateTime pattern="dd-MMM-yyyy"/>
		    </h:inputText>
			<h:outputLink id="todateCalendarLink" value="#txttoDate" onclick="setYears(1947, 2012);showMyCalendar(this);">
					<img src="calendar.png" style="height: 20px; width: 21px" border="0"/>
			</h:outputLink>	
			<h:message for="txttoDate"/>
					
			</h:panelGroup>
			
			<!-- changes done by Bhuvana for solution dropdown addition -->
		   <h:panelGroup style="width: 100px;">
			 	<h:outputText value="Solution"></h:outputText>
		   </h:panelGroup>
		 
			<h:selectOneMenu   value="#{viewAndUpdateMasterReqMB.solutionId}" binding="#{viewAndUpdateMasterReqMB.solutionSelectMenu}" 
			id="menu_solution" style="width: 180px"
			styleClass="listtableWHITESTRIP">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{viewAndUpdateMasterReqMB.solutionList}"/>
				
		    </h:selectOneMenu>
		    <!-- changes completed -->
		    
		    <h:panelGroup style="width: 100px;">
			    <h:outputText value="Vertical"></h:outputText>
			</h:panelGroup>
			<h:selectOneMenu style="width: 180px" value="#{viewAndUpdateMasterReqMB.verticalId}" binding="#{viewAndUpdateMasterReqMB.verticalSelectMenu}"
			 valueChangeListener="#{viewAndUpdateMasterReqMB.getAllModulesByVertical}" id="menu_vertical" styleClass="listtableWHITESTRIP" onchange="submit()">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
					<f:selectItems value="#{viewAndUpdateMasterReqMB.verticalList}" />
			</h:selectOneMenu>
			 
			  <!-- Changes done by Sanket starts -->
			
			<h:panelGroup style="width: 100px;">
			     <h:outputText value="Module"></h:outputText>
			</h:panelGroup>
		 
			<h:selectOneMenu style="width: 180px" value="#{viewAndUpdateMasterReqMB.moduleId}" id="menu_subModule" binding="#{viewAndUpdateMasterReqMB.moduleSelectMenu}"
			styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{viewAndUpdateMasterReqMB.modulesList}"/>
			</h:selectOneMenu>
		    <!-- changes complete -->
		
			<h:panelGroup style="width: 100px;">
			     <h:outputText value="Search by Keywords"></h:outputText>
			</h:panelGroup>
		 <h:inputText id="txtSearchBy" value="#{viewAndUpdateMasterReqMB.searchBy}" binding="#{viewAndUpdateMasterReqMB.searchByInputText}" styleClass="tabletext" style="width: 130px" />
			
			
		</h:panelGrid>
		 
		
				<br><br>
				<h:commandButton styleClass="tableBUTTON" value=" View " action="#{viewAndUpdateMasterReqMB.viewMasterRequirementsDetails}" type="submit"></h:commandButton>
				<br>
				
				<c:choose>
				<c:when	test="${ not empty viewAndUpdateMasterReqMB.viewMasterRequirementTOList}">
				
				
				<h1 class="contentHEADER" style="position: relative;left: 50px;">Master Requirement List <span style="position: relative;left: 250px;">
				 <h:commandLink styleClass="tableBUTTON"  action="#{viewAndUpdateMasterReqMB.downloadMasterReqList}" >
				 <img src="download_button.png" style="height: 28px; width: 97px;border:none;"/>
				 </h:commandLink>
					 </span>
					 </h1>
					
				
				<h:dataTable value="#{viewAndUpdateMasterReqMB.viewMasterReqPerPageList}" width="900" border="1" var="masterReq" binding="#{viewAndUpdateMasterReqMB.viewMasterReqHtmlDataTable}" headerClass="listtableHEADLINE" rowClasses="listtableWHITESTRIP,listtableGREYSTRIP">
		<h:column id="column1">
			<f:facet name="header">
				<h:outputText value="Requirement ID"></h:outputText>
			</f:facet>
			<h:outputText value="#{masterReq.masterRequirementId}"></h:outputText>
		</h:column>
		<h:column id="column2">
			<f:facet name="header">
				<h:outputText value="Requirement Title"></h:outputText>
			</f:facet>
			<h:outputText value="#{masterReq.masterRequirementTitle}"></h:outputText>
		</h:column>
		<h:column id="column3">
			<f:facet name="header">
				<h:outputText value="Description"></h:outputText>
			</f:facet>
			<h:inputTextarea value="#{masterReq.description}" rows="3" cols="20" readonly="true" styleClass="contentTEXT" style="height: 30px"> </h:inputTextarea>
		</h:column>
		<h:column id="column4">
			<f:facet name="header">
				<h:outputText value="Group Name"></h:outputText>
			</f:facet>
			<h:outputText value="#{masterReq.groupName}"></h:outputText>
		</h:column>
		
		<h:column id="column10">
			<f:facet name="header">
				<h:outputText value="Solution Name"></h:outputText>
			</f:facet>
			<h:outputText value="#{masterReq.solutionName}"></h:outputText>
		</h:column>
		
		<h:column id="column5">
			<f:facet name="header">
				<h:outputText value="Vertical Name"></h:outputText>
			</f:facet>
			<h:outputText value="#{masterReq.verticalName}"></h:outputText>
		</h:column>
		
		<!-- changes done by Bhuvana starts -->
		<h:column id="column6">
			<f:facet name="header">
				<h:outputText value="Module Name"></h:outputText>
			</f:facet>
			<h:outputText value="#{masterReq.moduleName}"></h:outputText>
		</h:column>
		<!-- changes completed -->
		
		<h:column id="column7">
			<f:facet name="header">
				<h:outputText value="Status"></h:outputText>
			</f:facet>
			<h:outputText value="#{masterReq.status}"></h:outputText>
		</h:column>
		
		<!-- Changes done by Bhuvana starts  -->
		<h:column id="column8">
			<f:facet name="header">
				<h:outputText value="Customization"></h:outputText>
			</f:facet>
			<h:outputText value="#{masterReq.customization}"></h:outputText>
		</h:column>
		<!-- Changes complted -->
		
		<h:column id="column9">
			<f:facet name="header">
				<h:outputText value="Change Status"></h:outputText>
			</f:facet>
			<h:commandLink action="#{viewAndUpdateMasterReqMB.getMasterReqDetails}">
					 <h:outputText value="View Details">
					  </h:outputText> 
				 
			</h:commandLink>
		</h:column>
	</h:dataTable>
	<br>
	<span style="position:absolute; left:300px; text-align: left;">
			<h:outputText value="#{viewAndUpdateMasterReqMB.pageMessage}" styleClass="formLABEL"></h:outputText>
		</span>
		<span style="position:absolute; left:650px;">
			<h:outputText value="Go to Page  " styleClass="contentTEXT"></h:outputText>&nbsp;&nbsp;&nbsp;
			<h:selectOneMenu id="selectMenuPage" value="#{viewAndUpdateMasterReqMB.displayPageNumber}" styleClass="choiceBOX" valueChangeListener="#{viewAndUpdateMasterReqMB.selectPageNumber}" onchange="submit()">
				<f:selectItem id="firstItem" itemLabel="-Select-" itemValue="0"/>
				<f:selectItems id="listItem" value="#{viewAndUpdateMasterReqMB.pageNumberList}"/>
			</h:selectOneMenu>
		</span>
		<span style="position:absolute; left:1080px;">
			<h:commandLink action="#{viewAndUpdateMasterReqMB.showPreviousRecord}" styleClass="tableBUTTON"><img src="previous_icon.png" style="height: 31px; width: 25px;border:none;"> </h:commandLink>
			&nbsp;&nbsp; <img src="tab_seperate.gif" border="0" style="height: 24px;"> &nbsp;&nbsp;
			<h:commandLink action="#{viewAndUpdateMasterReqMB.showNextRecord}"   styleClass="tableBUTTON"><img src="next_icon.png" style="height: 31px; width: 25px; border:none;"> </h:commandLink>
		</span>
	
	<br>
	<br><br>
	</c:when>
	<c:otherwise> 
	<br> 
	<h:outputText value="#{viewAndUpdateMasterReqMB.message}" styleClass="alertBOX">
	</h:outputText>
	
	
	</c:otherwise>
	</c:choose>
	</h:form></td>
		</tr>
	</table>

	<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>