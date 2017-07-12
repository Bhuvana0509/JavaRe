<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t"  uri="http://myfaces.apache.org/tomahawk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Split product Requirement success page</title>
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
</table>

</td>
<td width="1" bgcolor="#269DEB"> </td>
<td align="center" valign="top"> 
<br>
<span class="contentHEADER">Split Product Requirement</span><br>
<h3 class="contentTEXT"> Product Requirement(s) Created With following Details</h3>


		<t:dataList var="req" value="#{viewAndUpdateProductReqMB.productReqList}" first="0" id="datalist1" layout="simple">
		<br>
		<t:panelTabbedPane id="tabbedpane2" selectedIndex="0" frame="none" styleClass="tabbedPane"
                  activeTabStyleClass="activeTab"
                  inactiveTabStyleClass="inactiveTab"
                  disabledTabStyleClass="disabledTab"
                  activeSubStyleClass="activeSub"
                  inactiveSubStyleClass="inactiveSub"
                  tabContentStyleClass="tabContent">
                  
            <t:panelTab label="ProductRequirement" >
					<h:form>

						<h:panelGrid styleClass="filterBOX" border="1" columns="2" width="550"
							columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
							<h:outputText value="Product Requirement ID" ></h:outputText>
							<h:outputText
								value="#{req.productRequirementId}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Product Requirement Title"></h:outputText>
							<h:outputText
								value="#{req.productRequirementTitle}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Product Requirement Description"></h:outputText>
							<h:inputTextarea id="txtAreaProductReqDescription" rows="3"
								readonly="true"
								value="#{req.productRequirementDescription}"
								styleClass="txtAreaNonEditable" />


							<h:outputText value="Maste Requirement Title"></h:outputText>
							<h:outputText
								value="#{req.masterRequirementTitle}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Maste Requirement Description"></h:outputText>
							<h:inputTextarea id="txtAreaMasterReqDescription" rows="3"
								readonly="true"
								value="#{req.masterRequirementDescription}"
								styleClass="txtAreaNonEditable" />



							<h:outputText value="Product Verstion"></h:outputText>
							<h:outputText
								value="#{req.productVersion}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Group Name"></h:outputText>
							<h:outputText
								value="#{req.groupName}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Module Name"></h:outputText>
							<h:outputText
								value="#{req.moduleName}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Localization"></h:outputText>
							<h:outputText
								value="#{req.localization}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Functional Efforts"></h:outputText>
							<h:outputText
								value="#{req.functionalEffort}"
								style="width: 350px"> 
							</h:outputText>

							<h:outputText value="Developement Efforts"></h:outputText>
							<h:outputText
								value="#{req.developmentEffort}"
								style="width: 350px"></h:outputText>

							<h:outputText value="DG Owner"></h:outputText>
							<h:outputText
								value="#{req.dgOwner}"
								style="width: 350px"> 
							</h:outputText>

							<h:outputText value="Comments"></h:outputText>
							<h:outputText
								value="#{req.comments}"
								style="width: 350px"></h:outputText>


						</h:panelGrid>

				
						
					</h:form>
				</t:panelTab>
				
				 <t:panelTab label="FRS Details" >
					<h:form>

						<h:panelGrid styleClass="filterBOX" border="1" columns="2" width="550"
							columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
							
							<h:outputText value="Product Requirement ID"  ></h:outputText>
							<h:outputText
								value="#{req.productRequirementId}"
								style="width: 350px;"></h:outputText>

							<h:outputText value="FRS ID" ></h:outputText>
							<h:outputText
								value="#{req.frsId}"
								style="width: 350px;"></h:outputText>

							<h:outputText value="FRS Document Name" ></h:outputText>
								<h:outputText
								value="#{req.projectCode}"
								style="width: 350px;" styleClass="contentTEXT"></h:outputText>
							 
							 


							<h:outputText value="Project Code" ></h:outputText>
							<h:outputText
								value="#{req.projectCode}"
								style="width: 350px !important;"></h:outputText>

							<h:outputText value="FRS Owner" ></h:outputText>
							<h:outputText
								value="#{req.frsOwnerEmailId}"
								style="width: 350px;"></h:outputText>



							<h:outputText value="FRS Status" ></h:outputText>
							<h:outputText
								value="#{req.frsStatus}"
								style="width: 350px;"></h:outputText>

							<h:outputText value="Planned Date" ></h:outputText>
							<h:outputText
								value="#{req.plannedDateForFRS}"
								style="width: 350px;">
								<f:convertDateTime pattern="dd-MMM-yyyy" />
								</h:outputText>

							<h:outputText value="Actual Date" ></h:outputText>
							<h:outputText
								value="#{req.actualDateForFRS}"
								style="width: 350px;">
								<f:convertDateTime pattern="dd-MMM-yyyy" />
								</h:outputText>

							<h:outputText value="Group Review Date" ></h:outputText>
						<h:outputText
								value="#{req.groupReviewDateForFRS}"
								style="width: 350px;">
								<f:convertDateTime pattern="dd-MMM-yyyy" />
								</h:outputText>
							<h:outputText value="Frs Remarks" ></h:outputText>
							<h:outputText
								value="#{req.frsRemarks}"
								style="width: 350px;">
								 
							</h:outputText>

							<h:outputText value="Checked In TFS" ></h:outputText>
							<h:outputText
								value="#{req.frsCheckedInTFS}"
								style="width: 350px;"></h:outputText>

							 

						</h:panelGrid>

						
					</h:form>
				</t:panelTab>
				
				 <t:panelTab label="SRS Details" >
					<h:form>

						<h:panelGrid styleClass="filterBOX" border="1" columns="2" width="550"
							columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
							
							<h:outputText value="Product Requirement ID"></h:outputText>
							<h:outputText
								value="#{req.productRequirementId}"
								style="width: 350px"></h:outputText>

							<h:outputText value="SRS ID"></h:outputText>
							<h:outputText
								value="#{req.srsId}"
								style="width: 350px"></h:outputText>

							<h:outputText value="SRS Document Name"></h:outputText>
							<h:outputText
								value="#{req.SRSDocumentName}"
								style="width: 350px"></h:outputText>


							
							<h:outputText value="SRS Owner"></h:outputText>
							<h:outputText
								value="#{req.srsOwnerEmailId}"
								style="width: 350px"></h:outputText>



							<h:outputText value="SRS Status"></h:outputText>
							<h:outputText
								value="#{req.srsStatus}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Planned Date"></h:outputText>
							<h:outputText
								value="#{req.plannedDateForSRS}"
								style="width: 350px">
								<f:convertDateTime pattern="dd-MMM-yyyy" />
								</h:outputText>

							<h:outputText value="Actual Date"></h:outputText>
							<h:outputText
								value="#{req.actualDateForSRS}"
								style="width: 350px">
								<f:convertDateTime pattern="dd-MMM-yyyy" />
								</h:outputText>

							<h:outputText value="Group Review Date "></h:outputText>
						<h:outputText
								value="#{req.groupReviewDateForSRS}"
								style="width: 350px">
								<f:convertDateTime pattern="dd-MMM-yyyy" />
								</h:outputText>
							<h:outputText value="SRS Remarks"></h:outputText>
							<h:outputText
								value="#{req.srsRemarks}"
								style="width: 350px">
								 
							</h:outputText>

							<h:outputText value="Checked In TFS"></h:outputText>
							<h:outputText
								value="#{req.srsCheckedInTFS}"
								style="width: 350px"></h:outputText>
								
								
								<h:outputText value="RA Anchor"></h:outputText>
								<h:outputText
								value="#{req.srsRAAnchor}"
								style="width: 350px"></h:outputText>
						 

						</h:panelGrid>

				
						
					</h:form>
				</t:panelTab>
				
				 <t:panelTab label="Impact Details" >
					<h:form>

						<h:panelGrid styleClass="filterBOX" border="1" columns="2" width="550"
							columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign">
							<h:outputText value="Product Requirement ID"></h:outputText>
							<h:outputText
								value="#{req.productRequirementId}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Impact Id"></h:outputText>
							<h:outputText
								value="#{req.impactId}"
								style="width: 350px"></h:outputText>

							<h:outputText value="Archie Impact"></h:outputText>
							<h:outputText
								value="#{req.archieImpact}"
								style="width: 350px"></h:outputText>
							<h:outputText value="Core Impact"></h:outputText>
							<h:outputText
								value="#{req.coreImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="CRM Impact"></h:outputText>
							<h:outputText
								value="#{req.CRMImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="FAS Impact"></h:outputText>
							<h:outputText
								value="#{req.FASImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="ODS Impact"></h:outputText>
							<h:outputText
								value="#{req.odsImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="FI Impact"></h:outputText>
							<h:outputText
								value="#{req.fiImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="E-Banking Impact"></h:outputText>
							<h:outputText
								value="#{req.EBankingImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="Direct Banking Impact"></h:outputText>
							<h:outputText
								value="#{req.directBankingImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="Origination Impact"></h:outputText>
							<h:outputText
								value="#{req.originationImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="FDMI Impact"></h:outputText>
							<h:outputText
								value="#{req.FDMImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="Treasury Impact"></h:outputText>
							<h:outputText
								value="#{req.treasuryImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="WMS Impact"></h:outputText>
							<h:outputText
								value="#{req.WMSImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="Finanz Tool Impact"></h:outputText>
							<h:outputText
								value="#{req.finanzToolImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="Multichannel Impact"></h:outputText>
							<h:outputText
								value="#{req.multichannelImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="SSO Impact"></h:outputText>
							<h:outputText
								value="#{req.SSOImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="24 BY 7 Impact"></h:outputText>
							<h:outputText
								value="#{req.all24By7Impact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="SVS Impact"></h:outputText>
							<h:outputText
								value="#{req.svsImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="Fab Impact"></h:outputText>
							<h:outputText
								value="#{req.fabImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="CSIS Impact"></h:outputText>
							<h:outputText
								value="#{req.csisImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="LOS Impact"></h:outputText>
							<h:outputText
								value="#{req.LOSImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="FCA Impact"></h:outputText>
							<h:outputText
								value="#{req.FCAImpact}"
								style="width: 350px"></h:outputText>
							
							<h:outputText value="Third partyImpact"></h:outputText>
							<h:outputText
								value="#{req.thirdPartyImpact}"
								style="width: 350px"></h:outputText>
							
						</h:panelGrid>

			
						
					</h:form>
					
				</t:panelTab>
				
			</t:panelTabbedPane>
			<br/><br/>
		</t:dataList>
		
	
	<h:form>	 
		<h:commandButton value="Ok" style="width:80px;" styleClass="tableBUTTON" action="ok"></h:commandButton>
		
</h:form>

</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>