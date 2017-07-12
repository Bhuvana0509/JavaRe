<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.faces.context.FacesContext"%>
<%@page import="com.infy.managedBeans.MasterRequirementMB"%>
<%@page import="com.infy.managedBeans.ProductRequirementMB"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Requirements Assigned to Me page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:if test="${loginMB.emailId==null}">
<c:redirect url="ErrorPage.jsp"></c:redirect>
</c:if>
<f:view>
<jsp:include page="Header.jsp"></jsp:include>

<c:if test="${link!='myProductRequirement'}">
<%
	ProductRequirementMB productRequirementMB=new ProductRequirementMB();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productRequirementMB", productRequirementMB);
 %>
 <c:set var="link" value="myProductRequirement"></c:set>
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
	
<table width="100" height="100" border="0" class= "navigator_left" style="width: 169px" > 
		<tr>
		 <td   class="spaceBetweenLinks">
		 &gt; <a class="anchor" href="ProductRequirementsHomePage.jsp"> Home</a>
		 	
		  </td>
		</tr>
		<tr>
		 <td   class="spaceBetweenLinks">
		 &gt; <a class="anchor" href="ViewProductRequirement.jsp">View And Update</a>
		 	
		  </td>
		</tr>
		
		
		<tr>
					<td class="spaceBetweenVisitedLinks">&gt; <h:outputLink value="ProductRequirementsAssignedToMe.jsp"
						styleClass="anchor">Items assigned to me</h:outputLink>
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
<c:when test="${not empty productRequirementMB.productRequirementsAssignedList}">
<h1 class="contentHEADER" style="position: relative;left: 45px;">Product Requirements List 
<span style="position: relative;left: 250px;"><h:commandLink styleClass="tableBUTTON"  action="#{productRequirementMB.downloadProductReqList}" ><img src="download_button.png" style="height: 28px; width: 97px;border:none;"/></h:commandLink></span> </h1>
 
<h:dataTable border="1" headerClass="listtableHEADLINE" rowClasses="listtableWHITESTRIP,listtableGREYSTRIP" width="1000" value="#{productRequirementMB.viewProductReqPerPageList}" var="productReq">
				

				<h:column id="column1">
					<f:facet name="header">
						<h:outputText value="Product Req Id" style="width: 20px"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.productRequirementId}" style="width: 20px"></h:outputText>
				</h:column>
			

				<h:column id="column2" >
					<f:facet name="header">
						<h:outputText value="Product req Title" style="width: 20px" ></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.productRequirementTitle}" style="width: 20px" ></h:outputText>
				</h:column>
				<h:column id="column3">
					<f:facet name="header">
						<h:outputText value="Product Req Version"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.productVersion}"></h:outputText>
				</h:column>
				<h:column id="column4">
					<f:facet name="header">
						<h:outputText value="Product Req Description"></h:outputText>
					</f:facet>
					<h:inputTextarea value="#{productReq.productRequirementDescription}" cols="20" rows="3" styleClass="contentTEXT" style="height: 30px" readonly="true"> </h:inputTextarea>
				</h:column>
				<h:column id="column5">
						<f:facet name="header">
								<h:outputText value="Master Requirement ID"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.masterRequirementId}"></h:outputText>
					</h:column>
					
				<h:column id="column6">
					<f:facet name="header">
						<h:outputText value="Master Req Title"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.masterRequirementTitle}"></h:outputText>
				</h:column>
			
				<h:column id="column7">
					<f:facet name="header">
						<h:outputText value="Group Name"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.groupName}"></h:outputText>
				</h:column>
				
				<h:column id="column8">
						<f:facet name="header">
							<h:outputText value="Module Name"></h:outputText>
						</f:facet>
						<h:outputText value="#{productReq.moduleName}"></h:outputText>
				</h:column>
					
				<h:column id="column9">
					<f:facet name="header">
						<h:outputText value="FRS ID"></h:outputText>
						</f:facet>
					<h:outputText value="#{productReq.frsId}"></h:outputText>
				</h:column>
				<h:column id="column10">
					<f:facet name="header">
						<h:outputText value="FRS Owner">
					 
						</h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.frsOwnerEmailId}"></h:outputText>
				</h:column>
				<h:column id="column11">
					<f:facet name="header">
						<h:outputText value="SRS ID"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.srsId}"></h:outputText>
				</h:column>
				
				<h:column id="column12">
					<f:facet name="header">
						<h:outputText value="SRS Owner">
						 
						</h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.srsOwnerEmailId}"></h:outputText>
				</h:column>
			
			<h:column id="column13">
					<f:facet name="header">
						<h:outputText value="Approval Status"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.approvedStatus}"></h:outputText>
			</h:column>
			<h:column id="column14">
					<f:facet name="header">
						<h:outputText value="Comments"></h:outputText>
					</f:facet>
					<h:outputText value="#{productReq.comments}"></h:outputText>
			</h:column>
				
			</h:dataTable>
			<br>
			<span style="position:absolute; left:232px; text-align: left;">
			<h:outputText value="#{productRequirementMB.pageMessage}" styleClass="formLABEL"></h:outputText>
		</span>
		<span style="position:absolute; left:650px;">
			<h:outputText value="Go to Page  " styleClass="contentTEXT"></h:outputText>&nbsp;&nbsp;&nbsp;
			<h:selectOneMenu id="selectMenuPage" value="#{productRequirementMB.displayPageNumber}" styleClass="choiceBOX" valueChangeListener="#{productRequirementMB.selectPageNumber}" onchange="submit()">
				<f:selectItem id="firstItem" itemLabel="-Select-" itemValue="0"/>
				<f:selectItems id="listItem" value="#{productRequirementMB.pageNumberList}"/>
			</h:selectOneMenu>
		</span>
		<span style="position:absolute; left:1090px;">
			<h:commandLink action="#{productRequirementMB.showPreviousRecord}" styleClass="tableBUTTON"><img src="previous_icon.png" style="height: 31px; width: 25px;border:none;"> </h:commandLink>
			&nbsp;&nbsp; <img src="tab_seperate.gif" border="0" style="height: 24px;"> &nbsp;&nbsp;
			<h:commandLink action="#{productRequirementMB.showNextRecord}"   styleClass="tableBUTTON"><img src="next_icon.png" style="height: 31px; width: 25px; border:none;"> </h:commandLink>
		</span>
			<br><br><br><br>
			</c:when>
			<c:otherwise>
			<h1 class="contentHEADER" style="position: relative;">Product Requirements List</h1>
			<br><br><h:outputText styleClass="alertBOX" value="#{productRequirementMB.message}"></h:outputText>
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