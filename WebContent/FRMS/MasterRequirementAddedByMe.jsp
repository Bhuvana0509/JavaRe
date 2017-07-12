<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Master Requirement Added By Me Page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
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
													<td id="Cell_1" class="mainnavTABSon" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy HomePage">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_1" class="mainnavTABSlinkON" href="DashboardHomePage.jsp">Dashboard</a></td>
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
													<td id="Cell_5" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_5" class="mainnavTABSlinkOFF" href="ReportsHomePage.jsp">Reports</a></td>
														</tr>
													</table>
													</td>
													
													<!--  Chnages done Bhuvana -->
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_6" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_6" class="mainnavTABSlinkOFF" href="AboutFRMSHomePage.jsp">About FRMS</a></td>
														</tr>
													</table>
													</td>
													<!--  Changes completed -->
													
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
	
<table width="100" height="100" border="0" class="navigator_left"
				style="width: 169px">
				<tr>
					<td class="spaceBetweenLinks">&gt; <h:outputLink
						value="DashboardHomePage.jsp" styleClass="anchor">Home</h:outputLink>
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenVisitedLinks" >&gt; <h:outputLink value="MasterRequirementAddedByMe.jsp"
						styleClass="anchor">Master requirements Added by me </h:outputLink>
					</td>
				</tr>
				<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink value="ProductRequirementsAssignedToMe.jsp"
						styleClass="anchor">Product scope items assigned to me</h:outputLink>
					</td>
				</tr>
				<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="ChangePassword.jsp" styleClass="anchor">Change Password</h:outputLink>
					</td>
				</tr>
				
				
			</table>


</td>
<td width="1" bgcolor="#269DEB"> </td>
<td align="center" valign="top"> 
<br>
<h:form>
<c:choose>
<c:when test="${not empty masterRequirementMB.ownerMasterRequirementList}">
				<h1 class="contentHEADER" style="position: relative;left: 50px;">Master Requirement Added By Me <span style="position: relative;left: 200px;"> 
				<h:commandLink styleClass="tableBUTTON"  action="#{masterRequirementMB.downloadMasterReqList}" >
				<img src="download_button.png" style="height: 28px; width: 95px;border:none;"/>
				</h:commandLink>
					 </span>
					 </h1>
		
	<h:dataTable value="#{masterRequirementMB.ownerMasterRequirementList}" width="900" border="1" var="masterReq" binding="#{masterRequirementMB.ownerMasterReqHtmlDataTable}" headerClass="listtableHEADLINE" rowClasses="listtableWHITESTRIP,listtableGREYSTRIP">
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
		<h:column id="column5">
			<f:facet name="header">
				<h:outputText value="Vertical Name"></h:outputText>
			</f:facet>
			<h:outputText value="#{masterReq.verticalName}"></h:outputText>
		</h:column>
		<!-- chnages done by Bhuvana starts -->
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
		
		<!-- Changes done by Bhuvana -->
		<h:column id="column8">
			<f:facet name="header">
				<h:outputText value="Customization"></h:outputText>
			</f:facet>
			<h:outputText value="#{masterReq.customization}"></h:outputText>
		</h:column>
		<!-- Changes completed -->
		
		<h:column id="column9">
			<f:facet name="header">
				<h:outputText value="Change Status"></h:outputText>
			</f:facet>
			
			
			<h:commandLink action="#{masterRequirementMB.editMasterRequirement}">
				 <h:outputText value="Edit"></h:outputText> 	
			</h:commandLink>
			
		</h:column>
	</h:dataTable>
		
		<br>
		<span style="position:absolute; left:330px; text-align: left;">
			<h:outputText value="#{masterRequirementMB.pageMessage}" styleClass="formLABEL"></h:outputText>
		</span>
		<span style="position:absolute; left:650px;">
			<h:outputText value="Go to Page  " styleClass="contentTEXT"></h:outputText>&nbsp;&nbsp;&nbsp;
			<h:selectOneMenu id="selectMenuPage" value="#{masterRequirementMB.displayPageNumber}" styleClass="choiceBOX" valueChangeListener="#{masterRequirementMB.selectPageNumber}" onchange="submit()">
				<f:selectItem id="firstItem" itemLabel="-Select-" itemValue="0"/>
				<f:selectItems id="listItem" value="#{masterRequirementMB.pageNumberList}"/>
			</h:selectOneMenu>
		</span>
		<span style="position:absolute; left:1070px;">
			<h:commandLink action="#{masterRequirementMB.showPreviousRecord}" styleClass="tableBUTTON"><img src="previous_icon.png" style="height: 31px; width: 25px;border:none;"> </h:commandLink>
			&nbsp;&nbsp; <img src="tab_seperate.gif" border="0" style="height: 24px;"> &nbsp;&nbsp;
			<h:commandLink action="#{masterRequirementMB.showNextRecord}"   styleClass="tableBUTTON"><img src="next_icon.png" style="height: 31px; width: 25px; border:none;"> </h:commandLink>
		</span>
	
		
		
	</c:when>
	<c:otherwise>
		<h1 class="contentHEADER" >Master Requirement Added By Me</h1>
		<br>
		<br>
	<h:outputText value="#{masterRequirementMB.message}" styleClass="alertBOXSuccess"></h:outputText>
	</c:otherwise>
	</c:choose>
	
</h:form>
<br><br><br>
</td>
</tr>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>