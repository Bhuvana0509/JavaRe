<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="com.infy.managedBeans.ProductRequirementMB"%>
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="com.infy.managedBeans.ViewAndUpdateProductReqMB"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view Product Requirement page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<f:view>
<jsp:include page="Header.jsp"></jsp:include>
<c:if test="${link!='ViewProductRequirement'}">
	<%
	ViewAndUpdateProductReqMB viewAndUpdateProductReqMB =new ViewAndUpdateProductReqMB();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("viewAndUpdateProductReqMB", viewAndUpdateProductReqMB);
		
	%>
 	<c:set var="link" value="ViewProductRequirement" scope="session"></c:set>
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
													
													<!-- changes done by Bhuvana -->
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
	    
	    <tr>
		 <td class="spaceBetweenLinks">
		  &gt; <a class="anchor" href="UploadListOfProductRequirement.jsp">Upload List</a>
		 	
		  </td>
		</tr>
</table>

</td>
<td width="1" bgcolor="#269DEB"> </td>
<td valign="top" align="center"> 

<CENTER>
<br>
<span class="contentHEADER">View And Update Product Requirement</span><br>

<h:form>
	<h:panelGrid border="0" styleClass="filterBOX"  columns="4" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign,pannelGridMainColumn,pannegGridColumLeftAllign">
	<h:outputText value="Select Group"></h:outputText>
					<h:selectOneMenu id="groupMenu" value="#{viewAndUpdateProductReqMB.groupId}" styleClass="choiceBOX"    binding="#{viewAndUpdateProductReqMB.groupSelectMenu}" style="width: 200px">
					<f:selectItem itemLabel="-Select-" itemValue="0" />
						<f:selectItems value="#{viewAndUpdateProductReqMB.groupList}"/>
					</h:selectOneMenu>
					
					<h:panelGroup>
						<h:selectBooleanCheckbox id="chkbxUnassigned" value="#{viewAndUpdateProductReqMB.unAssignedFlag}" binding="#{viewAndUpdateProductReqMB.unAssignedCheckBox}" valueChangeListener="#{viewAndUpdateProductReqMB.selectUnAssignedOption}"  onclick="submit()"></h:selectBooleanCheckbox>
					  	<h:outputText value="UnAssigned"></h:outputText>
					</h:panelGroup>
					 <h:outputText value=""></h:outputText>		
					 
					
					<h:panelGroup> 
					   <h:selectBooleanCheckbox id="chkbxProductReq" value="#{viewAndUpdateProductReqMB.productReqFlag}" binding="#{viewAndUpdateProductReqMB.productCheckBox}" valueChangeListener="#{viewAndUpdateProductReqMB.selectProductReqruiement}" onclick="submit()"></h:selectBooleanCheckbox>
					  <h:outputText value="Product Requirement ID"></h:outputText>
					 </h:panelGroup>
					 <h:inputText id="txtProductReqId" value="#{viewAndUpdateProductReqMB.productRequirementId}"  binding="#{viewAndUpdateProductReqMB.productRequirementInputText}" disabled="true" styleClass="tabletext" style="width: 130px"></h:inputText>
					
					
		

			<h:panelGroup>
				<h:selectBooleanCheckbox id="chkbxMasterReq"
					value="#{viewAndUpdateProductReqMB.masterReqFlag}"
					binding="#{viewAndUpdateProductReqMB.masterCheckBox}"
					valueChangeListener="#{viewAndUpdateProductReqMB.selectMasterRequirement}"
					onclick="submit()"></h:selectBooleanCheckbox>
					<h:outputText value="Master Requirement ID"></h:outputText>
			</h:panelGroup>
			
			<h:inputText id="txtMasterReqId"
						value="#{viewAndUpdateProductReqMB.masterRequirementId}"
						binding="#{viewAndUpdateProductReqMB.masterRequirementInputText}"
						disabled="true" styleClass="tabletext" style="width: 130px">
			</h:inputText>
			
			<h:outputText value="Select Version"></h:outputText>
			<h:selectOneMenu style="width: 200px" value="#{viewAndUpdateProductReqMB.version}" id="versionMenu" binding="#{viewAndUpdateProductReqMB.versionSelectMenu}"
			styleClass="choiceBOX" onchange="submit()">
				<f:selectItem itemValue="0" itemLabel="-Select-" />				
				<f:selectItems value="#{viewAndUpdateProductReqMB.versionList}"/>		
			</h:selectOneMenu>
					
					<h:outputText value="Assigned To"></h:outputText>
					<h:panelGroup >
						<h:inputText id="txtAssignedTo" value="#{viewAndUpdateProductReqMB.assignedToEmpId}" binding="#{viewAndUpdateProductReqMB.assignedToInputText}"   styleClass="contentTEXT" style="width: 130px"> </h:inputText>
						<h:outputText  styleClass="contentTEXT" value="@infosys.com"></h:outputText>
					</h:panelGroup>
					
					<!-- changes done by sanket mehta -->
			
					<h:panelGroup >
					 	<h:outputText value="Select Region"></h:outputText>
					</h:panelGroup>
				 
					<h:selectOneMenu  value="#{viewAndUpdateProductReqMB.locationId}" binding="#{viewAndUpdateProductReqMB.locationSelectMenu}" id="menu_geography" style="width: 200px"
					styleClass="choiceBOX" onchange="submit()">
						<f:selectItem itemValue="0" itemLabel="-Select-"/>
						<f:selectItems value="#{viewAndUpdateProductReqMB.locationList}"/>				
					</h:selectOneMenu>
				
					<!-- changes completed -->
										
					
					
					<!-- changes done by sanket mehta -->
					 <h:panelGroup >
					 	<h:outputText value="Initiated By"></h:outputText>
					</h:panelGroup>
				 
					<h:selectOneMenu  value="#{viewAndUpdateProductReqMB.initiatingGroupId}" binding="#{viewAndUpdateProductReqMB.initiatingGroupSelectMenu}" id="menu_initiatedBy" style="width: 200px"
					styleClass="choiceBOX">
						<f:selectItem itemValue="0" itemLabel="-Select-"/>
						<f:selectItems value="#{viewAndUpdateProductReqMB.initiatingGroupList}"/>				
					</h:selectOneMenu>
					<!-- changes completed-->
					
					<!-- changes done by Bhuvana starts -->
					 <h:outputText value="Select Solution"></h:outputText>
					<h:selectOneMenu id="solutionMenu" 
									value="#{viewAndUpdateProductReqMB.solutionId}" 
									styleClass="choiceBOX"  
									binding="#{viewAndUpdateProductReqMB.solutionSelectMenu}"
									valueChangeListener="#{viewAndUpdateProductReqMB.getAllVerticalsBySolution}"
									onchange="submit()" 
									style="width: 200px">
						<f:selectItem itemLabel="-Select-" itemValue="0" />
						<f:selectItems value="#{viewAndUpdateProductReqMB.solutionList}"/>
					</h:selectOneMenu>
					<!-- changes completed --> 
				 	 
					<h:outputText value="Select Vertical"></h:outputText>
					<h:selectOneMenu id="verticalMenu" 
									value="#{viewAndUpdateProductReqMB.verticalId}" 
									styleClass="choiceBOX"  
									binding="#{viewAndUpdateProductReqMB.verticalSelectMenu}"
									
									onchange="submit()" 
									style="width: 200px">
						<f:selectItem itemLabel="-Select-" itemValue="0" />
						<f:selectItems value="#{viewAndUpdateProductReqMB.verticalList}"/>
					</h:selectOneMenu>

			
			<h:panelGroup style="width: 100px;">
			     <h:outputText value="Select Module"></h:outputText>
			</h:panelGroup>
		 
			<h:selectOneMenu style="width: 200px" value="#{viewAndUpdateProductReqMB.moduleId}" id="moduleMenu" binding="#{viewAndUpdateProductReqMB.moduleSelectMenu}"
			styleClass="choiceBOX" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{viewAndUpdateProductReqMB.moduleList}"/>
			</h:selectOneMenu>

					 
				</h:panelGrid>
				<br>
				<br>
				<h:commandButton value="View " action="#{viewAndUpdateProductReqMB.getFilteredList}" styleClass="tableBUTTON"></h:commandButton>
				<br><br>
				
				<c:choose> 
				<c:when test="${not empty viewAndUpdateProductReqMB.productRequirementTOList}">
				
				<h1 class="contentHEADER" style="position: relative;middle: 45px;">Product Requirements List 
				<span style="position: relative;left: 150px;"><h:commandLink styleClass="tableLink"  action="#{viewAndUpdateProductReqMB.downloadProductReqList}" value="Download PR List"></h:commandLink>&nbsp;&nbsp;
				
				<!-- Added for RCD/RS Tracker -->
				<h:commandLink styleClass="tableLink" action="#{viewAndUpdateProductReqMB.downloadProductReqListAsRCDTracker}" value="Download As RCD"></h:commandLink>&nbsp;&nbsp;
				<h:commandLink styleClass="tableLink" action="#{viewAndUpdateProductReqMB.downloadProductReqListAsRSTracker}" value="Download As RSTracker"></h:commandLink>
				
				</span> </h1>
				
				
 
				<h:dataTable value="#{viewAndUpdateProductReqMB.viewProductReqPerPageList}" border="1" var="productReq" binding="#{viewAndUpdateProductReqMB.viewProductReqDataTable}" width="900" headerClass="listtableHEADLINE" rowClasses="listtableWHITESTRIP,listtableGREYSTRIP">
					<h:column id="column1">
						<f:facet name="header">
								<h:outputText value="Product Requirement ID"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.productRequirementId}"></h:outputText>
					</h:column>
					<h:column id="column2">
						<f:facet name="header">
								<h:outputText value="Master Requirement ID"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.masterRequirementId}"></h:outputText>
					</h:column>
					<h:column id="column3">
						<f:facet name="header">
							<h:outputText value="Product Requirement Title"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.productRequirementTitle}"></h:outputText>
					</h:column>
					<h:column id="column4">
						<f:facet name="header">
							<h:outputText value="Product Requirement Description"></h:outputText>
						</f:facet>
					 
						<h:inputTextarea value="#{productReq.productRequirementDescription}" styleClass="contentTEXT" style="height: 30px" readonly="true"> </h:inputTextarea>
				
					</h:column>
					
					<h:column id="column10">
						<f:facet name="header">
							<h:outputText value="Solution Name"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.solutionName}"></h:outputText>
					</h:column>
					
					<h:column id="column5">
						<f:facet name="header">
							<h:outputText value="Group Name"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.groupName}"></h:outputText>
					</h:column>
					<h:column id="column6">
						<f:facet name="header">
							<h:outputText value="Vertical Name"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.verticalName}"></h:outputText>
					</h:column>
					<!-- changes done by Bhuvana starts -->
					<h:column id="column7">
						<f:facet name="header">
							<h:outputText value="Module Name"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.moduleName}"></h:outputText>
					</h:column>
					<!-- changes completed -->
					<h:column id="column8">
						<f:facet name="header">
							<h:outputText value="Version"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.productVersion}"></h:outputText>
					</h:column>
					<h:column id="column9">
						<f:facet name="header">
							<h:outputText value="View"></h:outputText>
						</f:facet>
						<h:commandLink action="#{viewAndUpdateProductReqMB.getProductRequirementDetails}">
							 <h:outputText value="View Details"></h:outputText> 	
						</h:commandLink>
					</h:column>
				</h:dataTable>
				<br>
				
				<span style="position:absolute; left:300px; text-align: left;">
			<h:outputText value="#{viewAndUpdateProductReqMB.pageMessage}" styleClass="formLABEL"></h:outputText>
		</span>
		<span style="position:absolute; left:650px;">
			<h:outputText value="Go to Page  " styleClass="contentTEXT"></h:outputText>&nbsp;&nbsp;&nbsp;
			<h:selectOneMenu id="selectMenuPage" value="#{viewAndUpdateProductReqMB.displayPageNumber}" styleClass="choiceBOX" valueChangeListener="#{viewAndUpdateProductReqMB.selectPageNumber}" onchange="submit()">
				<f:selectItem id="firstItem" itemLabel="-Select-" itemValue="0"/>
				<f:selectItems id="listItem" value="#{viewAndUpdateProductReqMB.pageNumberList}"/>
			</h:selectOneMenu>
		</span>
		<span style="position:absolute; left:1050px;">
			<h:commandLink action="#{viewAndUpdateProductReqMB.showPreviousRecord}" styleClass="tableBUTTON"><img src="previous_icon.png" style="height: 31px; width: 25px;border:none;"> </h:commandLink>
			&nbsp;&nbsp; <img src="tab_seperate.gif" border="0" style="height: 24px;"> &nbsp;&nbsp;
			<h:commandLink action="#{viewAndUpdateProductReqMB.showNextRecord}"   styleClass="tableBUTTON"><img src="next_icon.png" style="height: 31px; width: 25px; border:none;"> </h:commandLink>
		</span>
			<br><br><br><br>
				</c:when>
				
			  
			  <c:otherwise>
			  	<br>
				<h:outputText value="#{viewAndUpdateProductReqMB.message}" styleClass="alertBOX"/>
				</c:otherwise>
				</c:choose>
			</h:form>
			
			<br><br>
		
				 
			
</CENTER>

</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>