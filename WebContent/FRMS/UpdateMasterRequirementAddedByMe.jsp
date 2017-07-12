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
	<br>
	<c:if test="${masterRequirementMB.masterRequirementTO.status=='Entered' or masterRequirementMB.masterRequirementTO.status=='Accepted' }"> 
	<h:form enctype="multipart/form-data" >
	
		<h:panelGrid styleClass="filterBOX"  border="1" columns="3" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
					<h:outputText value="Master Requirement ID "></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.masterRequirementId}" style="width: 350px" styleClass="contentTEXT" ></h:outputText>
					 <h:outputText value=" "></h:outputText>
					
					<h:panelGroup style="width: 163px">
			 			<h:outputText value="Master Requirement Title"></h:outputText>
			 			<h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
					</h:panelGroup>
					<h:inputText id="txt_masterReqTitle" size="50"  value="#{masterRequirementMB.updateMasterRequirementTO.masterRequirementTitle}"  required="true" requiredMessage="Master Requirement Title is Mandatory" styleClass="contentTEXT" style="width: 350px"></h:inputText>
					<h:message for="txt_masterReqTitle"></h:message>
					
					<h:outputText value="External Reference Number"></h:outputText>
					<h:inputText id="txt_ExternRefNo" value="#{masterRequirementMB.updateMasterRequirementTO.externalReferenceNumber}" styleClass="contentTEXT" style="width: 350px"></h:inputText>
					<h:outputText value=" "></h:outputText>

					<h:outputText value="Maste Requirement Description"></h:outputText>
					<h:inputTextarea id="txtAreaDescription" rows="3"  disabled="masterRequirementMB.updateMasterRequirementTO.status != 'Entered'" value="#{masterRequirementMB.updateMasterRequirementTO.description}" styleClass="contentTEXT" style="width: 350px" />
					<h:outputText value=" "></h:outputText>
					
					
					<!-- changes made by sanket mehta -->
					<h:panelGroup>  
					<h:outputText value="Master Requirement Date" ></h:outputText>
					<h:outputText value="*" styleClass="fieldMANDATORY"></h:outputText>
					</h:panelGroup>
					<h:panelGroup>
					<h:inputText id="txtfromDate" value="#{masterRequirementMB.updateMasterRequirementTO.mrDate}" required="true" requiredMessage="MR Date is Mandatory" styleClass="contentTEXT" style="width: 150px">						
			       	<f:convertDateTime pattern="dd-MMM-yyyy"/>
		    		</h:inputText>
		    		
		    		<h:outputLink id="fromdateCalendarLink" value="#txtfromDate" onclick="setYears(1947, 2020);showMyCalendar(this);">
		    		<img src="calendar.png" style="height: 20px; width: 21px" border="0"/>
					</h:outputLink>
		    		</h:panelGroup>
					<h:message for="txtfromDate"/>
					<!-- changes completed-->
					
					<h:outputText value="Group Name"></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.groupName}" style="width: 350px" styleClass="contentTEXT" ></h:outputText>
					<h:outputText value=" "></h:outputText>
					
					<h:panelGroup style="width: 165px">
			 			<h:outputText value="Solution"></h:outputText>
			 			<h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
					</h:panelGroup>
					<h:selectOneMenu id="menu_solution" styleClass="choiceBOX" value="#{masterRequirementMB.updateMasterRequirementTO.solutionId}"  onchange="submit()" style="width: 130px"> 
						<f:selectItem itemValue="0" itemLabel="-Select-"/>
						<f:selectItems value="#{masterRequirementMB.solutionList}" />
						<f:validator validatorId="selectMenuValidatorId"/>
					</h:selectOneMenu>
					<h:message for="menu_solution"></h:message>
					
					<h:panelGroup style="width: 165px">
			 			<h:outputText value="Vertical"></h:outputText>
						<h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
					</h:panelGroup>
					<h:selectOneMenu id="menu_vertical" styleClass="choiceBOX" value="#{masterRequirementMB.updateMasterRequirementTO.verticalId}" onchange="submit()" style="width: 130px">
						<f:selectItem itemValue="0" itemLabel="-Select-"/>
						<c:if test="${not empty masterRequirementMB.verticalList}">
							<f:selectItems value="#{masterRequirementMB.verticalList}"/>
						</c:if>
						<f:validator validatorId="selectMenuValidatorId"/>
					</h:selectOneMenu>
				<h:message for="menu_vertical"></h:message>
				
				<!-- changes done by Bhuvana starts -->
					<h:panelGroup style="width: 165px">
					 <h:outputText value="Module"></h:outputText>
					<h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
					</h:panelGroup>
					<h:selectOneMenu id="selectMenu_module" styleClass="choiceBOX" value="#{masterRequirementMB.updateMasterRequirementTO.moduleId}" onchange="submit()" style="width: 130px">
						<f:selectItem itemValue="0" itemLabel="-Select-"/>					
							<f:selectItems value="#{masterRequirementMB.modulesList}"/>					
						<f:validator validatorId="selectMenuValidatorId"/>
					</h:selectOneMenu>
					<h:message for="selectMenu_module"></h:message>
					<!-- changes completed -->
					
					<h:outputText value="Contact Person"></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.contactPerson}" styleClass="contentTEXT" style="width: 350px"></h:outputText>
					 <h:outputText value=" "></h:outputText>
					
					<h:outputText value="Status"></h:outputText>
					<h:outputText value="#{masterRequirementMB.updateMasterRequirementTO.status}" style="width: 350px" styleClass="contentTEXT" ></h:outputText>
					 <h:outputText value=" "></h:outputText>
					 
					
					 <!-- Changes done by Bhuvana starts -->
					<h:outputText value="Customization"></h:outputText>			
					<h:selectOneRadio style="width: 180px" immediate="true" value="#{masterRequirementMB.updateMasterRequirementTO.customization}" id="statusRadio" styleClass="listtableWHITESTRIP">
						<f:selectItem id="id4" itemLabel="Yes" itemValue="Yes"/>
						<f:selectItem id="id5" itemLabel="No" itemValue="No"/>
					
					</h:selectOneRadio>
					<h:outputText value=" "></h:outputText>
					<!--  Changes completed -->
					
					<h:panelGroup><img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/> <h:outputText value="Attachment 1"></h:outputText> </h:panelGroup>
			 		<t:inputFileUpload id="uploadRequirementFile1" storage="file"  value="#{masterRequirementMB.uploadFile1}"  />
		 	 	 	 <h:outputText value=" "></h:outputText>
		 	 
				 	  <h:panelGroup><img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/> <h:outputText value="Attachment 2"></h:outputText> </h:panelGroup>
			 		<t:inputFileUpload id="uploadRequirementFile2" storage="file"  value="#{masterRequirementMB.uploadFile2}"  />
		 	 	 		 <h:outputText value=" "></h:outputText>
		 	 
				 	  <h:panelGroup><img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/> <h:outputText value="Attachment 3"></h:outputText> </h:panelGroup>
			 		<t:inputFileUpload id="uploadRequirementFile3" storage="file"  value="#{masterRequirementMB.uploadFile3}"  />
						 <h:outputText value=" "></h:outputText>
				</h:panelGrid>
				<br><br>
				<center>
				 
				
				<h:commandButton type="submit" action="#{masterRequirementMB.updateMasterRequirement}" styleClass="tableBUTTON" value="Update" ></h:commandButton>
				&nbsp; &nbsp;&nbsp;
				 
				<h:commandButton type="submit" value="Cancel" styleClass="tableBUTTON" action="cancel"></h:commandButton><br><br>
				
				<br>
				<h:outputText value="#{masterRequirementMB.message}" styleClass="alertBOX"></h:outputText>
				</center>
	
	</h:form>
	</c:if>

	<c:if test="${masterRequirementMB.masterRequirementTO.status!='Entered'}">
		<h:outputText value="This requirement can not be updated, Requirement is 'Rejected'" styleClass="alertBOX"></h:outputText>
	</c:if>
</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>