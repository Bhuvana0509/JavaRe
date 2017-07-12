<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.faces.context.FacesContext"%>

<%@page import="com.infy.managedBeans.ProductAssignedToMeMB"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Scope Items Assigned to Me page</title>
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
													<h:form>
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy HomePage" class="mainnavTABSoff">
														<tr>
														
															<td nowrap="nowrap" align="Center" valign="Middle">
																
																	<h:outputLink value="MasterRequirementsHomePage.jsp" id="MasterRequirement" styleClass="mainnavTABSlinkOFF" > Master Requirement</h:outputLink>
																
															</td>
																
														</tr>
													</table>
													</h:form>
													</td>
													<td class="cellpading0px"><img src="tab_seperate.gif" border="0" style="height: 21px;"></td>
													<td id="Cell_4" class="mainnavTABSoff" nowrap="nowrap" align="Center" valign="Middle">
													<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;" ID="tblMy Finance">
														<tr>
															<td nowrap="nowrap" align="Center" valign="Middle"><a id="hypl_4" class="mainnavTABSlinkOFF" href="productReq1uirementsHomePage.jsp">Product Requirements</a></td>
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
	
<table width="100" height="100" border="0" class= "navigator_left" style="width: 169px" > 
		<tr>
		 <td   class="spaceBetweenLinks">
		 &gt; <a class="anchor" href="productReq1uirementsHomePage.jsp"> Home</a>
		 	
		  </td>
		</tr>
		<tr>
		 <td   class="spaceBetweenLinks">
		 &gt; <a class="anchor" href="ViewproductReq1uirement.jsp">View And Update</a>
		 	
		  </td>
		</tr>
		
		
		<tr>
		
		<td   class="spaceBetweenVisitedLinks">
		 &gt; <a class="anchor" href="ProductScopeItemsAssignedToMe.jsp">Product Scope Items Assigned To Me</a>
		 	
		  </td>
					
				</tr>
</table>

</td>
<td width="1" bgcolor="#269DEB"> </td>
<td valign="top"> 
 
<CENTER>
 <br>
<h:form>
	<div style="text-align: center;">
		<br>
		<c:choose>
<c:when test="${not empty productAssignedToMeMB.productScopeItemsList}">

<h1 class="contentHEADER" style="position: relative;left: 45px;">Product Scope Items Assigned List 
<span style="position: relative;left: 250px;"><h:commandLink styleClass="tableBUTTON"  action="#{productAssignedToMeMB.downloadproductReq1List}" ><img src="download_button.png" style="height: 28px; width: 97px;border:none;"/></h:commandLink></span> </h1>

 
<h:dataTable border="1" headerClass="listtableHEADLINE" rowClasses="listtableWHITESTRIP,listtableGREYSTRIP" width="1000" value="#{productAssignedToMeMB.viewProductScopeItemsPerPageList}" var="productReq1">
				

				<h:column id="column1">
					<f:facet name="header">
						<h:outputText value="Product Req Id" style="width: 20px"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq1.productRequirementId}" style="width: 20px"></h:outputText>
				</h:column>
			

				<h:column id="column2" >
					<f:facet name="header">
						<h:outputText value="Product req Title" style="width: 20px" ></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq1.productRequirementTitle}" style="width: 20px" ></h:outputText>
				</h:column>
				<h:column id="column3">
					<f:facet name="header">
						<h:outputText value="Product Req Version"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq1.productVersion}"></h:outputText>
				</h:column>
				<h:column id="column4">
					<f:facet name="header">
						<h:outputText value="Product Req Description"></h:outputText>
					</f:facet>
					<h:inputTextarea value="#{productReq1.productRequirementDescription}" cols="20" rows="3" styleClass="contentTEXT" style="height: 30px" readonly="true"> </h:inputTextarea>
				</h:column>
				<h:column id="column5">
						<f:facet name="header">
								<h:outputText value="Master Requirement ID"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq1.masterRequirementId}"></h:outputText>
					</h:column>
					
				<h:column id="column6">
					<f:facet name="header">
						<h:outputText value="Master Req Title"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq1.masterRequirementTitle}"></h:outputText>
				</h:column>
			
				<h:column id="column7">
					<f:facet name="header">
						<h:outputText value="Group Name"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq1.groupName}"></h:outputText>
				</h:column>
				
				<h:column id="column8">
						<f:facet name="header">
							<h:outputText value="Module Name"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq1.moduleName}"></h:outputText>
				</h:column>
					
				<h:column id="column9">
					<f:facet name="header">
						<h:outputText value="Master Owner EmploeeID"></h:outputText>
						</f:facet>
					<h:outputText value="#{productReq1.ownerEmployeeId}"></h:outputText>
				</h:column>
				<h:column id="column10">
					<f:facet name="header">
						<h:outputText value="Product Owner EmploeeID"></h:outputText>
						</f:facet>
					<h:outputText value="#{productReq1.ownerEmployeeId}"></h:outputText>
				</h:column>
				<h:column id="column11">
					<f:facet name="header">
						<h:outputText value="Product Manager"></h:outputText>
						</f:facet>
					<h:outputText value="#{productReq1.productManager}"></h:outputText>
				</h:column>
				
				<h:column id="column12">
					<f:facet name="header">
						<h:outputText value="FRS Owner">
					 
						</h:outputText>
					</f:facet>
					<h:outputText value="#{productReq1.frsOwnerEmailId}"></h:outputText>
				</h:column>
				
				<h:column id="column13">
					<f:facet name="header">
						<h:outputText value="SRS Owner">
						 
						</h:outputText>
					</f:facet>
					<h:outputText value="#{productReq1.srsOwnerEmailId}"></h:outputText>
				</h:column>
				
			<h:column id="column14">
					<f:facet name="header">
						<h:outputText value="RA Anchor">
						 
						</h:outputText>
					</f:facet>
					<h:outputText value="#{productReq1.srsRAAnchor}"></h:outputText>
				</h:column>
			
			<h:column id="column15">
					<f:facet name="header">
						<h:outputText value="Approval Status"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq1.approvedStatus}"></h:outputText>
			</h:column>
			<h:column id="column16">
					<f:facet name="header">
						<h:outputText value="Comments"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq1.comments}"></h:outputText>
			</h:column>
				
			</h:dataTable>
			<br>
			<span style="position:absolute; left:232px; text-align: left;">
			<h:outputText value="#{productAssignedToMeMB.pageMessage}" styleClass="formLABEL"></h:outputText>
		</span>
		<span style="position:absolute; left:650px;">
			<h:outputText value="Go to Page  " styleClass="contentTEXT"></h:outputText>&nbsp;&nbsp;&nbsp;
			<h:selectOneMenu id="selectMenuPage" value="#{productAssignedToMeMB.displayPageNumber}" styleClass="choiceBOX" valueChangeListener="#{productAssignedToMeMB.selectPageNumber}" onchange="submit()">
				<f:selectItem id="firstItem" itemLabel="-Select-" itemValue="0"/>
				<f:selectItems id="lastItem" value="#{productAssignedToMeMB.pageNumberList}"/>
			</h:selectOneMenu>
		</span>
		<span style="position:absolute; left:1090px;">
			<h:commandLink action="#{productAssignedToMeMB.showPreviousRecord}" styleClass="tableBUTTON"><img src="previous_icon.png" style="height: 31px; width: 25px;border:none;"> </h:commandLink>
			&nbsp;&nbsp; <img src="tab_seperate.gif" border="0" style="height: 24px;"> &nbsp;&nbsp;
			<h:commandLink action="#{productAssignedToMeMB.showNextRecord}"   styleClass="tableBUTTON"><img src="next_icon.png" style="height: 31px; width: 25px; border:none;"> </h:commandLink>
		</span>
			<br><br><br><br>
			</c:when>
			<c:otherwise>
			<h1 class="contentHEADER" style="position: relative;">Product Scope Items List</h1>
			<br><br><h:outputText styleClass="alertBOX" value="#{productAssignedToMeMB.message}"></h:outputText>
			</c:otherwise>
			</c:choose>
				 
	</div>
</h:form>
	<br>
	<br>
	 
	</CENTER>
</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>