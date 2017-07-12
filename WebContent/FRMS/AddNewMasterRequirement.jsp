<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="com.infy.managedBeans.AddMasterRequirementMB"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Master Requirement Page</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javaScript" type="text/javascript" src="calendar.js"></script>
<link href="calendar.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<c:if test="${Role=='GS'}">
	<c:redirect url="AccessDeniedPage.jsp"></c:redirect>
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
	<c:if test="${link!='AddNewMasterRequirement'}">
	<%
	AddMasterRequirementMB addMasterRequirementMB =new AddMasterRequirementMB();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("addMasterRequirementMB", addMasterRequirementMB);
	
		
	%>
 	<c:set var="link" value="AddNewMasterRequirement" scope="session"></c:set>
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
													
													<!-- changes done by Bhuvana starts -->
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
		 <td class="spaceBetweenVisitedLinks" >
		&gt; <h:outputLink value="AddNewMasterRequirement.jsp" styleClass="anchor" >Add New </h:outputLink>
		 </td>
		</tr>
		
		<tr>
		 <td class="spaceBetweenLinks">
		  &gt; <h:outputLink value="ViewMasterRequirement.jsp" styleClass="anchor" >View/Update </h:outputLink>
		 </td>
		</tr>
		<tr>
		 <td class="spaceBetweenLinks">
		  &gt; <h:outputLink value="UploadListOfMasterRequirement.jsp" styleClass="anchor" >Upload list</h:outputLink>
		 </td>
		</tr>
		 
</table>

</td>
<td width="1" bgcolor="#269DEB"> </td>
<td > 
<center>
<br>
<h:form id="AddNewMasterRequirementForm" enctype="multipart/form-data" >
		<h1 class="contentHEADER">Add New Master Requirement </h1>
		<h:panelGrid border="0" columns="3" styleClass="filterBOX"  columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
			<h:panelGroup style="width: 163px">
			 <h:outputText value="Master Requirement Title"></h:outputText>
			 <h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
			</h:panelGroup>
			<h:inputText id="txt_masterReqTitle" value="#{addMasterRequirementMB.masterRequirementTO.masterRequirementTitle}" required="true" requiredMessage="Master Requirement Title is Mandatory" styleClass="contentTEXT" style="width: 350px">
            </h:inputText>
			<h:message for="txt_masterReqTitle"></h:message>
			
      		  <h:outputText value="External Reference No."></h:outputText>
			  <h:inputText id="txt_externalreferenceno" value="#{addMasterRequirementMB.masterRequirementTO.externalReferenceNumber}"  styleClass="contentTEXT" style="width: 350px">
              </h:inputText>	
			  <h:outputText value=" "></h:outputText>
			 
			 <h:panelGroup style="width: 165px">
			 <h:outputText value="Group Name"></h:outputText>
			<h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
			</h:panelGroup>
			<h:selectOneMenu  value="#{addMasterRequirementMB.masterRequirementTO.groupId}" id="menu_groupname"
			styleClass="listtableWHITESTRIP" style="width: 180px" >
				
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{addMasterRequirementMB.groupNamesList}"/>
				<f:validator validatorId="selectMenuValidatorId"/>
			</h:selectOneMenu>
			<h:message for="menu_groupname"></h:message>
			
			<h:panelGroup style="width: 165px">
			 <h:outputText value="Solution"></h:outputText>
			 <h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
			</h:panelGroup>
			<h:selectOneMenu value="#{addMasterRequirementMB.masterRequirementTO.solutionId}" id="menu_solution"
			styleClass="listtableWHITESTRIP" valueChangeListener="#{addMasterRequirementMB.getVerticalListOfSelectedSolution}" onchange="submit()" style="width: 180px">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{addMasterRequirementMB.solutionList}"/>
					<f:validator validatorId="selectMenuValidatorId"/>
			</h:selectOneMenu>
			<h:message for="menu_solution"></h:message>
			
			<h:panelGroup style="width: 165px">
			 <h:outputText value="Vertical"></h:outputText>
			<h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
			</h:panelGroup>
			<h:selectOneMenu value="#{addMasterRequirementMB.masterRequirementTO.verticalId}"  id="menu_vertical"
			styleClass="listtableWHITESTRIP" valueChangeListener="#{addMasterRequirementMB.getAllModulesByVertical}" onchange="submit()" style="width: 180px">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<c:if test="${not empty addMasterRequirementMB.verticalList}">
				<f:selectItems value="#{addMasterRequirementMB.verticalList}"/>
				</c:if>
					<f:validator validatorId="selectMenuValidatorId"/>
			</h:selectOneMenu>
			<h:message for="menu_vertical"></h:message>
			
			<!-- changes done by Bhuvana -->
			<c:choose>
		<c:when test="${not empty addMasterRequirementMB.modulesList1}">
		
		<h:panelGroup  >
		<span style="width: 100px;">
			 <h:outputText value="Module"></h:outputText>
			 <font color="red"><h:outputLabel value="*"></h:outputLabel></font>
		</span>
		</h:panelGroup>
		 
		<h:selectOneMenu  value="#{addMasterRequirementMB.masterRequirementTO.moduleId}" id="menu_modules" style="width: 180px"
			styleClass="listtableWHITESTRIP" onchange="submit()">
			<f:selectItem itemValue="0" itemLabel="-Select-"/>
			<f:selectItems value="#{addMasterRequirementMB.modulesList1}"/>
			
		       <f:validator validatorId="selectMenuValidatorId"/>
		</h:selectOneMenu>
		<h:message for="menu_modules"></h:message>
		</c:when>
		</c:choose>
		<!-- changes completed -->
								
			 <h:panelGroup style="width: 163px">
			 <h:outputText value="Requirement Description"></h:outputText>
			 <h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
			 </h:panelGroup>
			 <h:inputTextarea id="txt_requirementdescription" value="#{addMasterRequirementMB.masterRequirementTO.description}" required="true" requiredMessage="Requirement Description is Mandatory" styleClass="txtAreaEditable"  rows="3">
              <f:validateLength minimum="3" maximum="500"> </f:validateLength>
              </h:inputTextarea>
              <h:message for="txt_requirementdescription"></h:message>
             
              
             <!-- changes done by Bhuvana starts -->
             <h:panelGroup style="width: 163px">
              <h:outputText value="MR Date"></h:outputText>
              <h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
              </h:panelGroup>
              <h:panelGroup id="mrdate">
              <h:inputText id="txt_mrdate" value="#{addMasterRequirementMB.masterRequirementTO.mrDate}" styleClass="contentTEXT"  style="width: 120px" required="true" requiredMessage="MR Date is Mandatory" onchange="submit();">
               <f:convertDateTime pattern="dd-MMM-yyyy"/>
              </h:inputText>
              <h:outputLink id="mrdateCalendarLink" value="#txt_mrdate" onclick="setYears(1947, 2012);showMyCalendar(this);">
					<img src="calendar.png" style="height: 20px; width: 21px" border="0"/>
			  </h:outputLink>
			  </h:panelGroup>    
			  <h:message for="txt_mrdate"/>      
              <!-- changes completed -->
              
	             <!--  changes done by Bhuvana starts -->
				<h:outputText value="Customization"></h:outputText>
				
				<h:selectOneRadio style="width: 180px" value="#{addMasterRequirementMB.masterRequirementTO.customization}" id="customizationRadio" styleClass="listtableWHITESTRIP"> 

					<f:selectItem id="id1" itemLabel="Yes" itemValue="Yes"/>
					<f:selectItem id="id2" itemLabel="No" itemValue="No"/>
				
				</h:selectOneRadio>
				<h:outputText value=" "></h:outputText>
				<!-- changes completed -->	
			 
			 <h:panelGroup style="width: 165px">
			 <h:outputText value="Contact Person"></h:outputText>
			 <h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
			</h:panelGroup>
			<h:selectOneMenu value="#{addMasterRequirementMB.masterRequirementTO.emailId}" id="menu_contactperson"
			styleClass="listtableWHITESTRIP" onchange="submit()" style="width: 180px">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{addMasterRequirementMB.loginList}"/>
				
			</h:selectOneMenu>
			<h:message for="menu_contactperson"></h:message>
			 
			<h:panelGroup><img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/> <h:outputText value="Attachment 1"></h:outputText> </h:panelGroup> 
			 <t:inputFileUpload id="uploadRequirementFile1" storage="file"  value="#{addMasterRequirementMB.uploadFile1}"  />
		 	 <h:outputText value=" "></h:outputText>
		 	 
             <h:panelGroup><img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/> <h:outputText value="Attachment 2"></h:outputText> </h:panelGroup> 
			 <t:inputFileUpload id="uploadRequirementFile2" storage="file"  value="#{addMasterRequirementMB.uploadFile2}"  />
		 	 <h:outputText value=" "></h:outputText>
		 	 
		 	  <h:panelGroup><img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/> <h:outputText value="Attachment 3"></h:outputText> </h:panelGroup> 
			 <t:inputFileUpload id="uploadRequirementFile3" storage="file"  value="#{addMasterRequirementMB.uploadFile3}"  />
		 	 <h:outputText value=" "></h:outputText>
			 
					
		</h:panelGrid> 
		<br><br>
			<h:commandButton styleClass="tableBUTTON" id="bt_submit"  value="Add Master Requirement" style="width: 176px" action="#{addMasterRequirementMB.addNewMasterRequirement}"></h:commandButton> &nbsp;
			<h:commandButton styleClass="tableBUTTON" id="bt_reset" immediate="true" action="#{addMasterRequirementMB.reset}" value="Reset" style="width: 89px"></h:commandButton><br>
		
		<br>
		<h:outputText  styleClass="alertBOX" value="#{addMasterRequirementMB.message}"></h:outputText>
		 
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