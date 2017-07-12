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
<script language="javaScript" type="text/javascript" src="calendar.js"></script>
<link href="calendar.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<c:if test="${Role!='PM' and Role!='A'}">
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
<div>
<table cellspacing="0" cellpadding="0" width="100%" border="0" class="mainnavTABLE">
							<tr>
								<td style="width: 100%">
								<table class="mainnavTABLE" borderColor="#ff3300" cellspacing="0" cellpadding="0" width="100%" border="0" ID="tblImgSpacer" align="left">
									<tr style="height: 94px">
										<td class="mainnavLEFT" align="left" width="28%">
										
										<table cellspacing="0" cellpadding="0" border="0" ID="Table2">
												<tr>
													<td id="Cell_1" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy HomePage">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_1" class="mainnavTABSlinkOFF" href="DashboardHomePage.jsp"><font color="white">Dashboard </font></a></td>
														</tr>
													</table>
													</td>
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_2" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_2" class="mainnavTABSlinkOFF" href="GroupDetailsHomePage.jsp"><font color="white">Group Details</font></a></td>
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
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_4" class="mainnavTABSlinkOFF" href="ProductRequirementsHomePage.jsp"><font color="white">Product Requirements</font></a></td>
														</tr>
													</table>
													</td>
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_5" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_5" class="mainnavTABSlinkOFF" href="ReportsHomePage.jsp"><font color="white">Reports</font></a></td>
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
		 <td class="spaceBetweenVisitedLinks">
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
<td valign="top" align="center">
	<br>
	<h1 class="contentHEADER">Update Master Requirement</h1> 
	<br>
	<c:choose>
	<c:when test="${viewAndUpdateMasterReqMB.updateMasterRequirementTO.status=='Entered' or viewAndUpdateMasterReqMB.updateMasterRequirementTO.status=='Accepted'}">
	<h:form enctype="multipart/form-data" >
	
		<h:panelGrid styleClass="filterBOX"  border="1" columns="3" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
					<h:outputText value="Master Requirement ID "></h:outputText>
					<h:outputText value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.masterRequirementId}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					<h:outputText value=""/>  
					 
					<h:panelGroup>  
					<h:outputText value="Master Requirement Title" ></h:outputText>
					<h:outputText value="*" styleClass="fieldMANDATORY"></h:outputText>
					</h:panelGroup>
					<h:inputText id="txtMasterReqTitle" size="50"  value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.masterRequirementTitle}" required="true" requiredMessage="Please enter master requirement title"  styleClass="contentTEXT" style="width: 350px"></h:inputText>
					<h:message for="txtMasterReqTitle"></h:message>
					 
					<h:outputText value="External Reference Number"></h:outputText>
					<h:inputText id="txt_ExternRefNo" value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.externalReferenceNumber}" styleClass="contentTEXT" style="width: 350px"></h:inputText>
					<h:outputText value=" "></h:outputText>					
					<h:outputText value="Master Requirement Description"></h:outputText>
					<h:inputTextarea id="txtAreaDescription" rows="3"  disabled="viewAndUpdateMasterReqMB.updateMasterRequirementTO.status != 'Entered'" value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.description}" style="width: 350px" styleClass="contentTEXT" />
					<h:outputText value=""/>
					
					<!-- changes made by sanket mehta -->
					<h:panelGroup>  
					<h:outputText value="Master Requirement Date" ></h:outputText>
					<h:outputText value="*" styleClass="fieldMANDATORY"></h:outputText>
					</h:panelGroup>
					<h:panelGroup>
					<h:inputText id="txtfromDate" value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.mrDate}" required="true"  requiredMessage="MR Date is Mandatory" styleClass="contentTEXT" style="width: 150px">						
			       	<f:convertDateTime pattern="dd-MMM-yyyy"/>
		    		</h:inputText>
		    		
		    		<h:outputLink id="fromdateCalendarLink" value="#txtfromDate" onclick="setYears(1947, 2020);showMyCalendar(this);">
		    		<img src="calendar.png" style="height: 20px; width: 21px" border="0">
					</h:outputLink>
		    		</h:panelGroup>
					<h:message for="txtfromDate"/>
					<!-- changes completed-->
					
					<h:outputText value="Group Name"></h:outputText>
					<h:outputText value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.groupName}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					<h:outputText value=""/>
					
					<h:panelGroup style="width: 165px">
					 <h:outputText value="Solution"></h:outputText>
					 <h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
					</h:panelGroup>
					<h:selectOneMenu id="selectMenuSolution" styleClass="choiceBOX" value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.solutionId}" valueChangeListener="#{viewAndUpdateMasterReqMB.getModuleListOfSelectedSolution}" onchange="submit()" style="width: 180px"> 
						<f:selectItem itemValue="0" itemLabel="-Select-"/>
						<f:selectItems value="#{viewAndUpdateMasterReqMB.solutionList}" />
						<f:validator validatorId="selectMenuValidatorId"/>
					</h:selectOneMenu>
					<h:message for="selectMenuSolution"></h:message>
					
					
					<h:panelGroup style="width: 165px">
					<h:outputText value="Vertical"></h:outputText>
					<h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
					</h:panelGroup>
					<h:selectOneMenu id="selectMenuVertical" styleClass="choiceBOX" value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.verticalId}"
					 valueChangeListener="#{viewAndUpdateMasterReqMB.getAllModulesByVertical}" onchange="submit()" style="width: 180px">
						<f:selectItem itemValue="0" itemLabel="-Select-"/>
						<c:if test="${not empty viewAndUpdateMasterReqMB.verticalList}">
							<f:selectItems value="#{viewAndUpdateMasterReqMB.verticalList}"/>
						</c:if>
						<f:validator validatorId="selectMenuValidatorId"/>
					</h:selectOneMenu>
					<h:message for="selectMenuVertical"></h:message>
					
					<!-- changes done by Bhuvana starts -->
					<h:panelGroup style="width: 165px">
					 <h:outputText value="Module"></h:outputText>
					<h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
					</h:panelGroup>
					<h:selectOneMenu id="selectMenu_module" styleClass="choiceBOX" value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.moduleId}"  style="width: 180px">
						<f:selectItem itemValue="0" itemLabel="-Select-"/>					
							<f:selectItems value="#{viewAndUpdateMasterReqMB.modulesList}"/>					
						<f:validator validatorId="selectMenuValidatorId"/>
					</h:selectOneMenu>
					<h:message for="selectMenu_module"></h:message>
					<!-- changes completed -->
					
					<h:outputText value="Contact Person"></h:outputText>
					<h:outputText value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.contactPerson}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					<h:outputText value=""/>
					
					<!--  Changes done by Bhuvana starts -->
					<h:outputText value="Customization"></h:outputText>
					
				
				    <h:selectOneRadio style="width: 180px" immediate="true" value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.customization}" id="customizationRadio" disabled="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.status != 'Entered' }" styleClass="listtableWHITESTRIP"> 

					<f:selectItem id="id1" itemLabel="Yes" itemValue="Yes"/>
					<f:selectItem id="id2" itemLabel="No" itemValue="No"/>
				    
					</h:selectOneRadio>
			
					<h:outputText value=" "></h:outputText>
					
					<!--  Changes completed -->
					
					<h:outputText value="Status"></h:outputText>
					<h:outputText value="#{viewAndUpdateMasterReqMB.updateMasterRequirementTO.status}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					<h:outputText value=""/>
					
					 <h:panelGroup><img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/> <h:outputText value="Attachment 1"></h:outputText> </h:panelGroup>
			 		<t:inputFileUpload id="uploadRequirementFile1" storage="file"  value="#{viewAndUpdateMasterReqMB.uploadFile1}"  />
		 	 	 <h:outputText value=""/>
		 	 
				 	  <h:panelGroup><img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/> <h:outputText value="Attachment 2"></h:outputText> </h:panelGroup>
			 		<t:inputFileUpload id="uploadRequirementFile2" storage="file"  value="#{viewAndUpdateMasterReqMB.uploadFile2}"  />
		 	 		 <h:outputText value=""/>
		 	 
				 	 <h:panelGroup><img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/> <h:outputText value="Attachment 3"></h:outputText> </h:panelGroup>
			 		<t:inputFileUpload id="uploadRequirementFile3" storage="file"  value="#{viewAndUpdateMasterReqMB.uploadFile3}"  />
		 	 		 <h:outputText value=""/>
				
				</h:panelGrid>
				<br><br>
				
				<center>
				
				
				<h:commandButton type="submit" action="#{viewAndUpdateMasterReqMB.updateMasterRequirement}" styleClass="tableBUTTON" value="Update" ></h:commandButton>
				&nbsp; &nbsp;&nbsp;
				 
				<h:commandButton type="submit" value="Cancel" styleClass="tableBUTTON" action="cancel"></h:commandButton><br>
				
				<br>
				<h:outputText value="#{viewAndUpdateMasterReqMB.message}" styleClass="alertBOX"></h:outputText>
				</center>
	
	</h:form>
	</c:when>
	<c:otherwise>
	<h:form> 
			<h:outputText value="This Master Requirement is Rejected, so no Updations can be done!" styleClass="alertBOX"></h:outputText>
			<br><br>
			<h:commandButton type="submit" value="Back" styleClass="tableBUTTON" action="cancel"></h:commandButton>
	</h:form><br><br>
	</c:otherwise>
	</c:choose>



</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>