<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.infy.managedBeans.GroupDetailsReportsMB"%>
<%@page import="javax.faces.context.FacesContext"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Groups Details Report </title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<f:view>
<jsp:include page="Header.jsp"></jsp:include>
<c:if test="${link!='GroupsDetailsReport'}">
	<%
	GroupDetailsReportsMB groupDetailsReportsMB=new GroupDetailsReportsMB();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("groupDetailsReportsMB", groupDetailsReportsMB);
		
	%>
 	<c:set var="link" value="GroupsDetailsReport" scope="session"></c:set>
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
		 	&gt; <h:outputLink value="ReportsHomePage.jsp" styleClass="anchor">Home</h:outputLink>
		  </td>
		</tr>
		<tr>
		 <td class="spaceBetweenLinks">
		 	&gt; <h:outputLink value="MasterRequirementsReport.jsp" styleClass="anchor"> Master Requirements </h:outputLink>
		  </td>
		</tr>
		<tr>
		 <td class="spaceBetweenLinks">
		 	&gt; <h:outputLink value="ProductRequirementsReport.jsp" styleClass="anchor"> Product Requirements</h:outputLink>
		  </td>
		</tr>
		<tr>
		 <td class="spaceBetweenVisitedLinks">
			&gt; <h:outputLink value="GroupDetailsReport.jsp" styleClass="anchor"> Group Details</h:outputLink>
		  </td>
		</tr>
		
</table>

</td>
<td width="1" bgcolor="#269DEB"> </td>
<td valign="top"> 
<center>
<br>
<h1 class="contentHEADER">Group Details Report </h1>
<h:form id="GroupListForm">
			<h:panelGrid border="0" columns="4" styleClass="filterBOX" style="width: 120px" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign,pannelGridMainColumn,pannegGridColumLeftAllign">
			
			 <h:outputText value="Location/Geography"></h:outputText>
			 <h:selectOneMenu style="width: 130px" value="#{groupDetailsReportsMB.locationId}" binding="#{groupDetailsReportsMB.locationSelectMenu}" id="menu_location" styleClass="listtableWHITESTRIP" >
				<f:selectItem itemValue="0" itemLabel="-Select-"/>
				<f:selectItems value="#{groupDetailsReportsMB.locationList}"/>
			</h:selectOneMenu>
			
			<h:panelGroup >	
			<div style="width: 200px;">				
			<h:selectBooleanCheckbox  id="checkbox_allGroupDetails" value="#{groupDetailsReportsMB.allGroupsDetailStatus}" binding="#{groupDetailsReportsMB.allGroupDetailsCheckBox}" valueChangeListener="#{groupDetailsReportsMB.selectAllGroupDetailsCheckBox}" onclick="submit()"></h:selectBooleanCheckbox>
			<h:outputText style="font-weight: bold; width: 130px;"  value="All Group Details" ></h:outputText>
			</div>
			</h:panelGroup>
			
		</h:panelGrid><br>
		<h:commandButton styleClass="tableBUTTON" value="View" action="#{groupDetailsReportsMB.viewGroupDetails}" type="submit"></h:commandButton>
		&nbsp;&nbsp; 
<c:choose>
<c:when test="${not empty groupDetailsReportsMB.groupList}">	
<h1 class="contentHEADER" style="position: relative;left: 70px;" >Groups List &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<span style="position: relative;left: 250px;"><h:commandLink styleClass="tableBUTTON" action="#{groupDetailsReportsMB.downloadGroupList}"><img src="download_button.png" style="height: 28px; width: 97px;border:none;"></h:commandLink> </span></h1>
<h:dataTable border="1" headerClass="listtableHEADLINE" rowClasses="listtableWHITESTRIP,listtableGREYSTRIP" value="#{groupDetailsReportsMB.viewGroupInfoPerPageList}" var="group" width="900">
				

				<h:column id="column1">
					<f:facet name="header">
						<h:outputText value="Group Id" style="width: 20px"></h:outputText>
					</f:facet>
					<h:outputText value="#{group.groupId}" style="width: 20px"></h:outputText>
				</h:column>
			

				<h:column id="column2">
					<f:facet name="header">
						<h:outputText value="Group Name"></h:outputText>
					</f:facet>
					<h:outputText value="#{group.groupName}"></h:outputText>
				</h:column>
				
				<h:column id="column3">
					<f:facet name="header">
						<h:outputText value="Description"></h:outputText>
					</f:facet>
					<h:inputTextarea value="#{group.description}" cols="20" rows="3" style="height: 25px" readonly="true" styleClass="contentTEXT"> </h:inputTextarea>
					
				</h:column>
			
				<h:column id="column4">
					<f:facet name="header">
						<h:outputText value="Initiating Group"></h:outputText>
					</f:facet>
					<h:outputText value="#{group.initiatingGroupName}"></h:outputText>
				</h:column>
				
				<h:column id="column5">
					<f:facet name="header">
						<h:outputText value="Source"></h:outputText>
					</f:facet>
					<h:outputText value="#{group.sourceName}"></h:outputText>
				</h:column>
				
				<h:column id="column6">
					<f:facet name="header">
						<h:outputText value="Location"></h:outputText>
					</f:facet>
					<h:outputText value="#{group.locationName}"></h:outputText>
				</h:column>
				
				<h:column id="column7">
					<f:facet name="header">
						<h:outputText value="Customer/Prospect"></h:outputText>
					</f:facet>
					<h:outputText value="#{group.customer_prospect}"></h:outputText>
				</h:column>
				<h:column id="column8">
					<f:facet name="header">
						<h:outputText value="SPOC" style="width: 20px"></h:outputText>
					</f:facet>
					<h:outputText value="#{group.SPOC}" style="width: 10px"></h:outputText>
				</h:column>
				<h:column id="column9">
					<f:facet name="header">
						<h:outputText value="Comments"></h:outputText>
					</f:facet>
					<h:outputText value="#{group.comment}"></h:outputText>
				</h:column>
			
			</h:dataTable> 
			
			
			<br>
			<span style="position:absolute; left:300px; text-align: left;">
			<h:outputText value="#{groupDetailsReportsMB.pageMessage}" styleClass="formLABEL"></h:outputText>
		</span>
		<span style="position:absolute; left:650px;">
			<h:outputText value="Go to Page  " styleClass="contentTEXT"></h:outputText>&nbsp;&nbsp;&nbsp;
			<h:selectOneMenu id="selectMenuPage" value="#{groupDetailsReportsMB.displayPageNumber}" styleClass="choiceBOX" valueChangeListener="#{groupDetailsReportsMB.selectPageNumber}" onchange="submit()">
				<f:selectItem id="firstItem" itemLabel="-Select-" itemValue="0"/>
				<f:selectItems id="listItem" value="#{groupDetailsReportsMB.pageNumberList}"/>
			</h:selectOneMenu>
		</span>
		<span style="position:absolute; left:1080px;">
			<h:commandLink action="#{groupDetailsReportsMB.showPreviousRecord}" styleClass="tableBUTTON"><img src="previous_icon.png" style="height: 31px; width: 25px;border:none;"> </h:commandLink>
			&nbsp;&nbsp; <img src="tab_seperate.gif" border="0" style="height: 24px;"> &nbsp;&nbsp;
			<h:commandLink action="#{groupDetailsReportsMB.showNextRecord}"   styleClass="tableBUTTON"><img src="next_icon.png" style="height: 31px; width: 25px; border:none;"> </h:commandLink>
		</span>
	
	<br>
	<br><br>
			
			</c:when>
			
			<c:otherwise>
				<br><br><h:outputText styleClass="alertBOX" value="#{groupDetailsReportsMB.groupMessage}"></h:outputText>
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