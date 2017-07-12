<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.infy.managedBeans.CreateNewGroupMB"%>
<%@page import="javax.faces.context.FacesContext"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Group page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<c:if test="${Role=='GS'}">
	<c:redirect url="AccessDeniedPage.jsp"></c:redirect>
</c:if>
<c:if test="${link!='CreateGroupDetails'}">
	<%
	CreateNewGroupMB createNewGroupMB =new CreateNewGroupMB();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("createNewGroupMB", createNewGroupMB);
		
	%>
 	<c:set var="link" value="CreateGroupDetails" scope="session"></c:set>
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
													
													<!--  Changes done by Bhuvana starts -->
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_6" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_6" class="mainnavTABSlinkOFF" href="AboutFRMSHomePage.jsp">About FRMS</a></td>
														</tr>
													</table>
													</td>
													<!--  changes completed -->
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
		 <td class="spaceBetweenVisitedLinks" >
		 	&gt; <h:outputLink value="CreateNewGroup.jsp"  styleClass="anchor" >Create New Group </h:outputLink>
		  </td>
		</tr>
		<tr>
		 <td class="spaceBetweenLinks" >
		 	&gt; <h:outputLink value="ViewGroupDetails.jsp"  styleClass="anchor" >View And Update</h:outputLink>
		  </td>
		</tr>
		
		
</table>

</td>
<td width="1" bgcolor="#269DEB"> </td>
<td >
<center>
<br><span class="contentHEADER">Create New Group</span><br>
<h:form id="CreateNewGroupForm" enctype="multipart/form-data">
		
		<h:panelGrid border="0" columns="3" styleClass="filterBOX" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
			<h:panelGroup style="width: 163px">
			 <h:outputText value="Group Name"></h:outputText>
			 <font color="red"><h:outputLabel value="*"></h:outputLabel></font>
			</h:panelGroup>
			<h:inputText id="txtgroupname" value="#{createNewGroupMB.groupName}" styleClass="contentTEXT" required="true" requiredMessage="Group Name is mandatory"  style="width: 350px">
            	<f:validator validatorId="groupNameValidator"/>
            </h:inputText>
            <h:message for="txtgroupname"></h:message>

			<h:panelGroup style="width: 162px">
			  <h:outputText value="Group Description"></h:outputText>
			  <font color="red"><h:outputLabel value="*"></h:outputLabel></font>
			</h:panelGroup>
			<h:inputTextarea id="txt_groupdescription" value="#{createNewGroupMB.groupDescription}" required="true" styleClass="txtAreaEditable" requiredMessage="Group Description is Mandatory" rows="3">
              <f:validateLength minimum="3" maximum="50"> </f:validateLength>
            </h:inputTextarea>
			<h:message for="txt_groupdescription"></h:message>
			
			<h:panelGroup style="width: 165px">
			 <h:outputText value="Initating Group"></h:outputText>
			 <font color="red"><h:outputLabel value="*"></h:outputLabel></font>
			</h:panelGroup>
			<h:selectOneMenu style="width: 130px" value="#{createNewGroupMB.initatingGroupId}" id="menu_initatinggroup"
			styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{createNewGroupMB.initatingGroupList}"/>
				<f:validator validatorId="selectMenuValidatorId"/>
			</h:selectOneMenu>
			<h:message for="menu_initatinggroup"></h:message>
			
			<h:panelGroup style="width: 165px">
			 <h:outputText value="Source"></h:outputText>
			 <font color="red"><h:outputLabel value="*"></h:outputLabel></font>
			</h:panelGroup>
			<h:selectOneMenu style="width: 130px" value="#{createNewGroupMB.sourceId}" id="menu_source"
			styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{createNewGroupMB.sourceList}"/>
				<f:validator validatorId="selectMenuValidatorId"/>
			</h:selectOneMenu>
			<h:message for="menu_source"></h:message>
			
			<h:panelGroup style="width: 165px">
			 <h:outputText value="Market/Geography"></h:outputText>
			 <font color="red"><h:outputLabel value="*"></h:outputLabel></font>
			</h:panelGroup>
			<h:selectOneMenu style="width: 130px" value="#{createNewGroupMB.locationId}" id="menu_geography"
			styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{createNewGroupMB.locationList}"/>
				<f:validator validatorId="selectMenuValidatorId"/>
			</h:selectOneMenu>
			<h:message for="menu_geography"></h:message>
						
			<h:outputText value="Customer/Prospect"></h:outputText>
			<h:inputText id="txt_CustomerProspect" styleClass="contentTEXT" value="#{createNewGroupMB.customer_prospect}" style="width: 350px">
            </h:inputText>
			<h:message for="txt_CustomerProspect"></h:message>
			
			<h:panelGroup style="width: 163px">
			 <h:outputText value="Req. Group SPOC"></h:outputText>
			 <font color="red"><h:outputLabel value="*"></h:outputLabel></font>
			</h:panelGroup>
			<h:inputText id="txt_GroupSPOC"  styleClass="contentTEXT" value="#{createNewGroupMB.SPOC}" required="true" requiredMessage="Group SPOC is Mandatory" style="width: 350px">
            </h:inputText>
			<h:message for="txt_GroupSPOC"></h:message>
			
			<h:outputText value="Comments"></h:outputText>
			<h:inputText id="txt_Comments" styleClass="contentTEXT" value="#{createNewGroupMB.comment}" style="width: 350px">
            </h:inputText>
			<h:message for="txt_Comments"></h:message>
			
			<h:panelGroup>
				<img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/>
				 <h:outputText value="Attachment 1"></h:outputText>
			 </h:panelGroup> 
			 <t:inputFileUpload id="uploadRequirementFile1" storage="file"  value="#{createNewGroupMB.uploadFile1}"  />
		 	 <h:outputText value=" "></h:outputText>
		 	 
			<h:panelGroup>
				<img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/>
				<h:outputText value="Attachment 2"></h:outputText>
			</h:panelGroup> 
			 <t:inputFileUpload id="uploadRequirementFile2" storage="file"  value="#{createNewGroupMB.uploadFile2}"  />
		 	 <h:outputText value=" "></h:outputText>
		 	 
		 	  <h:panelGroup>
		 	  	<img src="attachment_symbol.png" style="height: 18px; width: 18px;border:none;"/> 
		 	  	<h:outputText value="Attachment 3"></h:outputText>
		 	  </h:panelGroup> 
			 <t:inputFileUpload id="uploadRequirementFile3" storage="file"  value="#{createNewGroupMB.uploadFile3}"  />
		 	 <h:outputText value=" "></h:outputText>
			
		</h:panelGrid>
		<br><br>
			<h:commandButton id="bt_submit"  value="Add Group" styleClass="tableBUTTON" style="width: 95px" action="#{createNewGroupMB.addGroup}" ></h:commandButton> &nbsp;&nbsp;&nbsp;&nbsp;
			<h:commandButton id="bt_reset" type="submit" value="Reset" action="#{createNewGroupMB.reset}" immediate="true" styleClass="tableBUTTON"  style="width: 89px" ></h:commandButton>
		
		<br>
		<h:outputText  styleClass="alertBOX" value="#{createNewGroupMB.successMessage}"></h:outputText>
		<h:outputText  styleClass="alertBOX" value="#{createNewGroupMB.failureMessage}"></h:outputText>
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