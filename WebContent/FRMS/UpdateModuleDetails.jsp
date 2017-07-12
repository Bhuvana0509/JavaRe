<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Module Details Page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<c:if test="${Role!='A'}">
	<c:redirect url="AccessDeniedPage.jsp"></c:redirect>
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
					<td class="spaceBetweenLinks">> <h:outputLink value="AdminTasksHomePage.jsp" styleClass="anchor">Home</h:outputLink> 
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenLinks">> <h:outputLink value="AddLocation.jsp" styleClass="anchor"> Add Location </h:outputLink>
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenLinks">> <h:outputLink value="AddInitiatingGroup.jsp" styleClass="anchor"> Add Initiating Group </h:outputLink>
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenLinks">> <h:outputLink value="AddSource.jsp" styleClass="anchor"> Add Source </h:outputLink>
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenLinks">> <h:outputLink value="AddSolution.jsp" styleClass="anchor"> Add Solution</h:outputLink>
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenLinks">> <h:outputLink value="MaintainVerticalsAndModules.jsp" styleClass="anchor">Maintain Vertical And Modules</h:outputLink>
					</td>
				</tr>
				<!--<tr>
					<td class="spaceBetweenLinks">> <h:outputLink value="AddVertical.jsp" styleClass="anchor">Add Vertical</h:outputLink>
					</td>
				</tr>
				
				<tr>
					<td class="spaceBetweenLinks">> <h:outputLink value="AddNewModule.jsp" styleClass="anchor">Add Module</h:outputLink>
					</td>
				</tr>-->
				
				<tr>
					<td class="spaceBetweenLinks">> <h:outputLink value="AddNewMember.jsp" styleClass="anchor"> Add New User </h:outputLink>
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenLinks">> <h:outputLink value="MaintainUser.jsp" styleClass="anchor">Maintain User</h:outputLink>
					</td>
				</tr>
				<!--<tr>
					<td class="spaceBetweenLinks">> <h:outputLink value="ChangeVertical.jsp" styleClass="anchor">Change Vertical</h:outputLink>
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenVisitedLinks">> <h:outputLink value="ViewModuleDetails.jsp" styleClass="anchor">Change Module</h:outputLink>
					</td>
				</tr>-->
				<tr>
					<td class="spaceBetweenLinks">> <h:outputLink value="ChangeOthersPassword.jsp" styleClass="anchor">Change Others Password</h:outputLink>
					</td>
				</tr>
			</table>

</td>
<td width="1" bgcolor="#269DEB"> </td>
<td >
<center>
 
<h:form id="ViewModuledetailsForm" enctype="multipart/form-data">
		 <br>
		<h1 class="contentHEADER">Module Details</h1>
		<h:panelGrid border="1" columns="3" styleClass="filterBOX" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
			
			<h:outputText value="Solution ID"></h:outputText>
						
			<h:outputText value="#{adminTasksMB.updateModuleAnchorTO.solutionId}" style="width: 180px"/>
			<h:outputText value=""></h:outputText>
		
			<h:panelGroup style="width: 165px">
			 <h:outputText value="Vertical"></h:outputText>
			</h:panelGroup>
			<h:selectOneMenu style="width: 130px" value="#{adminTasksMB.updateModuleAnchorTO.verticalId}" id="menu_vertical"
			styleClass="choiceBOX" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{adminTasksMB.verticalList}"/>
				<f:validator validatorId="selectMenuValidatorId"/>
			</h:selectOneMenu>
			<h:message for="menu_vertical"></h:message>
						
			<h:panelGroup style="width: 163px">
			 <h:outputText value="Module Name"></h:outputText>
			 <font color="red"><h:outputLabel value="*"></h:outputLabel></font>
			</h:panelGroup>
			<h:inputText id="txt_moduleName" value="#{adminTasksMB.updateModuleAnchorTO.moduleName}" required="true" requiredMessage="Module Name is Mandatory" styleClass="contentTEXT" style="width: 180px">
            </h:inputText>
			<h:message for="txt_moduleName"></h:message>
			<h:outputText value="Module Anchor"></h:outputText>
			
            <h:selectOneMenu value="#{adminTasksMB.updateModuleAnchorTO.anchorName}" id="moduleAnchor" styleClass="choiceBOX" style="width: 200px">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{adminTasksMB.loginList}"/>
				
			</h:selectOneMenu>
            
			<h:message for="moduleAnchor"></h:message>
			
			
		</h:panelGrid>
		<br><br>
			<h:commandButton id="submit" value="Save Changes" style="width: 111px" action="#{adminTasksMB.updateModule}" styleClass="tableBUTTON"></h:commandButton> &nbsp;
			&nbsp;
				<h:commandButton id="back" type="button" value="Back" style="width: 89px" action="back" styleClass="tableBUTTON"></h:commandButton>
				
				<br><br><br>
			<h:outputText  styleClass="alertBOX" value="#{adminTasksMB.message}"></h:outputText>
	
		
		 
		
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