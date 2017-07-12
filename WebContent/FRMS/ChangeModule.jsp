<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.infy.managedBeans.AdminTasksMB"%>
<%@page import="javax.faces.context.FacesContext"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Module Page</title>
<link href="style.css" rel="stylesheet" type="text/css">


</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<f:view>
	<jsp:include page="Header.jsp"></jsp:include>
	<c:if test="${link!='ChangeModule'}">
	<%
	AdminTasksMB adminTasksMB=new AdminTasksMB();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adminTasksMB", adminTasksMB);
		
	%>
 	<c:set var="link" value="ChangeModule" scope="session"></c:set>
	</c:if>	
	<div >
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
										id="hypl_1" class="mainnavTABSlinkOFF" href="DashboardHomePage.jsp">Dashboard</a></td>
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
							
							<!-- chnages done by Bhuvana -->
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
							<!-- changes completed -->
							
							
							<c:if test="${Role=='A'}">
							<td class="cellpading0px"><img src="tab_seperate.gif"
								border="0" style="height: 21px;"></td>
							<td id="Cell_5" class="mainnavTABSon" nowrap="nowrap"
								align="Center" valign="Middle">
							<table cellspacing="0" cellpadding="0" border="0"
								style="border-collapse: collapse;" ID="tblMy Finance">
								<tr>
									<td nowrap="nowrap" align="Center" valign="Middle"><a
										id="hypl_5" class="mainnavTABSlinkON"
										href="AdminTasksHomePage.jsp">Admin Tasks</a></td>
								</tr>
							</table>
							</td>
							</c:if>
							
							

						</tr>
					</table>
					</td>
					<td class="mainnavLEFT" width="100%">
					<table id="tblLevelOneLinks" cellspacing="0" cellpadding="0"
						border="0" width="100%" style="border-collapse: collapse;">
						<tr>

							<td vAlign="top" class="mainnavUSER" bordercolor="#ff3300"
								align="right">
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
	<table align="left" cellspacing="0" cellpadding="0"
		style="border-collapse: collapse;">
		<tr>

		</tr>
	</table>

	<table border="0" width="100%" height="355">
		<tr>
			<td valign="top" width="170">


			<table width="100" height="100" border="0" class="navigator_left"
				style="width: 169px">
				<tr>
					<td class="spaceBetweenLinks">&gt; <h:outputLink
						value="AdminTasksHomePage.jsp" styleClass="anchor">Home</h:outputLink> 
					</td>
				</tr>
				<tr>
					<td class="spaceBetweenLinks" >&gt; <h:outputLink value="AddLocation.jsp"
						styleClass="anchor"> Add Location </h:outputLink>
					</td>
				</tr>
				<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink value="AddInitiatingGroup.jsp"
						styleClass="anchor"> Add Initiating Group </h:outputLink>
					</td>
				</tr>
				<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="AddSource.jsp" styleClass="anchor"> Add Source </h:outputLink>
					</td>
				</tr>
				<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="AddSolution.jsp" styleClass="anchor"> Add Solution</h:outputLink>
					</td>
				</tr>
				<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="AddProductVersion.jsp" styleClass="anchor"> Add Product Version</h:outputLink>
					</td>
				</tr>
				<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="AddLocalization.jsp" styleClass="anchor"> Add Localization</h:outputLink>
					</td>
				</tr>
				<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="MaintainVerticalsAndModules.jsp" styleClass="anchor">Maintain Vertical And Modules</h:outputLink>
					</td>
				</tr>
				<!--<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="AddVertical.jsp" styleClass="anchor">Add Vertical</h:outputLink>
					</td>
				</tr>-->
				<!-- changes done by Bhuvana starts -->
				<!--<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="AddNewModule.jsp" styleClass="anchor">Add Module</h:outputLink>
					</td>
				</tr>-->
				<!-- changes completed -->
				<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="AddNewMember.jsp" styleClass="anchor"> Add New User </h:outputLink>
					</td>
				</tr>
				<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="MaintainUser.jsp" styleClass="anchor">Maintain User</h:outputLink>
					</td>
				</tr>
				<!--<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="ChangeVertical.jsp" styleClass="anchor">Change Vertical</h:outputLink>
					</td>
				</tr>
				<tr>
					<td  class="spaceBetweenVisitedLinks">&gt; <h:outputLink
						value="ChangeModule.jsp" styleClass="anchor">Change Module</h:outputLink>
					</td>
				</tr>-->
				<tr>
					<td  class="spaceBetweenLinks">&gt; <h:outputLink
						value="ChangeOthersPassword.jsp" styleClass="anchor">Change Others Password</h:outputLink>
					</td>
				</tr>
			</table>

			</td>
			<td width="1" bgcolor="#269DEB"></td>
			<td valign="top" align="center"><br>
					<span class="contentHEADER">Change Module</span>
			<h:form id="selectSolutionAndModuleForm">

			<h:panelGrid border="0" columns="2" styleClass="filterBOX" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign,pannegGridColumLeftAllign">
			
			<h:outputText value="Solution"></h:outputText>
			 			
			<h:selectOneMenu value="#{adminTasksMB.solutionId}" id="menu_solution"
			styleClass="listtableWHITESTRIP" valueChangeListener="#{adminTasksMB.getVerticalListOfSelectedSolution}" onchange="submit()" style="width: 180px">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{adminTasksMB.solutionList}"/>
			</h:selectOneMenu>
			
								
			 <h:outputText value="Vertical"></h:outputText>
			<h:selectOneMenu value="#{adminTasksMB.verticalId}" id="menu_vertical" binding="#{adminTasksMB.verticalSelectMenu}"
			valueChangeListener="#{adminTasksMB.getAllModulesByVertical}" onchange="submit()" styleClass="listtableWHITESTRIP" style="width: 180px">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>			
				<f:selectItems value="#{adminTasksMB.verticalList}"/>				
			</h:selectOneMenu>
			
			 <h:outputText value="Module"></h:outputText>
			<h:selectOneMenu value="#{adminTasksMB.moduleId}" id="menu_module" binding="#{adminTasksMB.moduleSelectMenu}"
			styleClass="listtableWHITESTRIP" style="width: 180px">
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<c:if test="${not empty adminTasksMB.modulesList}">
				<f:selectItems value="#{adminTasksMB.modulesList}"/>
				</c:if>
			</h:selectOneMenu>
			
			
		</h:panelGrid>
<br>
<br>

		<h:commandButton value="View" action="#{adminTasksMB.viewModuleDetails}" styleClass="tableBUTTON"></h:commandButton>
		&nbsp;&nbsp;<br><br>

	</h:form>
	
	<c:if test="${adminTasksMB.moduleAnchorTO!=null}">
	<span class="contentHEADER">Module Details</span>
<h:form id="ModuleDetailForm">
<h:panelGrid border="1" columns="3" styleClass="filterBOX" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign,pannegGridColumLeftAllign">
			
			<h:outputText value="Solution ID"/>
			<h:outputText id="solutionId" style="width: 130px" value="#{adminTasksMB.solutionId}" styleClass="contentTEXT">
			</h:outputText><h:outputText/>
			
			<h:panelGroup style="width: 165px">
			<h:outputText value="Vertical"></h:outputText>
					<h:outputLabel value="*" styleClass="fieldMANDATORY"></h:outputLabel>
					</h:panelGroup>
					<h:selectOneMenu id="selectMenuVertical" styleClass="choiceBOX" value="#{adminTasksMB.verticalId}"
					 onchange="submit()" style="width: 130px">
						<f:selectItem itemValue="0" itemLabel="-Select-"/>
						   <f:selectItems value="#{adminTasksMB.verticalList}"/>
				
					</h:selectOneMenu>
					<h:message for="selectMenuVertical"></h:message>
			
			<h:panelGroup>
			<h:outputText value="Module Name"/><span class="fieldMANDATORY">*</span></h:panelGroup>
			<h:inputText id="moduleName" style="width: 180px" required="true" requiredMessage="Please Enter The Module Name" value="#{adminTasksMB.moduleName}" styleClass="contentTEXT">
			</h:inputText>
			<h:message for="moduleName"/>
			
			<h:panelGroup>
			<h:outputText value="Module Anchor"/><span class="fieldMANDATORY">*</span></h:panelGroup>
			<h:inputText id="moduleAnchor" style="width: 180px" required="true" requiredMessage="Please Enter The Module Anchor Name" value="#{adminTasksMB.moduleAnchorName}" styleClass="contentTEXT">
			</h:inputText>
			<h:message for="moduleAnchor"/>
		
			
		</h:panelGrid><br>
		<h:commandButton value="Save Changes" action="#{adminTasksMB.saveEditedModuleAnchorDetails}" styleClass="tableBUTTON"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h:commandButton value=" Cancel " action="#{adminTasksMB.cancelModuleAnchorChanges}" styleClass="tableBUTTON"/>
</h:form>
</c:if>
<h:outputText styleClass="alertBOX" value="#{adminTasksMB.message}"></h:outputText>
		<br><br><br><span class="fieldMANDATORY">*</span><span> Mandatory Fields</span>
		
		<br><br>
			
			</td>
		</tr>
	</table>

	<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>