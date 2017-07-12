<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %> 
<%@ taglib prefix="t"  uri="http://myfaces.apache.org/tomahawk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<f:view>
<jsp:include page="Header.jsp"></jsp:include>



<table align="left" cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
						<tr>
							
						</tr>
</table>


 
<br><br><br>
<center><span class="alertBOX">Test Page</span><br><br><br>
		 
<br>
<h:form></h:form>
<t:outputText value="value text3"></t:outputText>

<t:dataList var="masterReq" value="#{masterRequirementMB.ownerMasterRequirementList}" first="0" id="datalist1" layout="simple">
<h:form>
	<t:panelTabbedPane id="tabbedpane2" selectedIndex="0" frame="none" styleClass="tabbedPane"
                  activeTabStyleClass="activeTab"
                  inactiveTabStyleClass="inactiveTab"
                  disabledTabStyleClass="disabledTab"
                  activeSubStyleClass="activeSub"
                  inactiveSubStyleClass="inactiveSub"
                  tabContentStyleClass="tabContent">
		<t:panelTab label="MasterRequirement" >
			
			<br>
				<h:panelGrid border="1" columns="2" style="width: 570px" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign" styleClass="filterBOX">
			
					<h:outputText value="Id" ></h:outputText>
					<h:outputText value="#{masterReq.masterRequirementId}"></h:outputText>
			
					<h:outputText value="Title" ></h:outputText>
					<h:outputText value="#{masterReq.masterRequirementTitle}"></h:outputText>
			
					<h:outputText value="Master Requirement Description"></h:outputText>
					<h:inputTextarea id="txtAreaDescription" style="background-color: #E8F5FD; width: 350px; " rows="3"  readonly="true" value="#{masterReq.description}" styleClass="contentTEXT" />
			
			
				</h:panelGrid>
			
		 	
	 		
		</t:panelTab>
		<t:panelTab label="Product Requirement">
			
			 <br>
			
				<h:panelGrid border="1" columns="2" style="width: 570px" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign" styleClass="filterBOX">
			
					<h:outputText value="GroupName" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.groupName}"></h:outputText>
			
					<h:outputText value="ModuleName" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.moduleName}"></h:outputText>
			
					<h:outputText value="Requirement status" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.status}"></h:outputText>
			
				</h:panelGrid>
			
		 
	 		
		</t:panelTab>
	<t:panelTab label="SRS Details">
			
			<br>
				<h:panelGrid border="1" columns="2" style="width: 570px" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign" styleClass="filterBOX">
			
					<h:outputText value="Id" ></h:outputText>
					<h:outputText value="#{masterReq.masterRequirementId}"></h:outputText>
			
					<h:outputText value="Title" ></h:outputText>
					<h:outputText value="#{masterReq.masterRequirementTitle}"></h:outputText>
			
					<h:outputText value="Master Requirement Description"></h:outputText>
					<h:inputTextarea id="txtAreaDescription" style="background-color: #E8F5FD; width: 350px; " rows="3"  readonly="true" value="#{masterReq.description}" styleClass="contentTEXT" />
			
			
				</h:panelGrid>
			
		 	
	 	
		</t:panelTab>
		<t:panelTab label="FRS Details">
		
			 <br>
			
				<h:panelGrid border="1" columns="2" style="width: 570px" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign" styleClass="filterBOX">
			
					<h:outputText value="GroupName" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.groupName}"></h:outputText>
			
					<h:outputText value="ModuleName" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.moduleName}"></h:outputText>
			
					<h:outputText value="Requirement status" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.status}"></h:outputText>
			
				</h:panelGrid>
			
		 
	 		
		</t:panelTab>
	
	</t:panelTabbedPane>
	</h:form>
	<br><br><br><br><br><br>
</t:dataList>
.........................

<br><br><br><br>

<h:dataTable value="#{masterRequirementMB.ownerMasterRequirementList}" var="masterReq"  > 
 
<h:form>
	<t:panelTabbedPane id="tabbedpane2" selectedIndex="0" frame="none" styleClass="tabbedPane"
                  activeTabStyleClass="activeTab"
                  inactiveTabStyleClass="inactiveTab"
                  disabledTabStyleClass="disabledTab"
                  activeSubStyleClass="activeSub"
                  inactiveSubStyleClass="inactiveSub"
                  tabContentStyleClass="tabContent">
		<t:panelTab label="MasterRequirement" >
			
			<br>
				<h:panelGrid border="1" columns="2" style="width: 570px" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign" styleClass="filterBOX">
			
					<h:outputText value="Id" ></h:outputText>
					<h:outputText value="#{masterReq.masterRequirementId}"></h:outputText>
			
					<h:outputText value="Title" ></h:outputText>
					<h:outputText value="#{masterReq.masterRequirementTitle}"></h:outputText>
			
					<h:outputText value="Master Requirement Description"></h:outputText>
					<h:inputTextarea id="txtAreaDescription" style="background-color: #E8F5FD; width: 350px; " rows="3"  readonly="true" value="#{masterReq.description}" styleClass="contentTEXT" />
			
			
				</h:panelGrid>
			
		 	
	 		
		</t:panelTab>
		<t:panelTab label="Product Requirement">
			
			 <br>
			
				<h:panelGrid border="1" columns="2" style="width: 570px" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign" styleClass="filterBOX">
			
					<h:outputText value="GroupName" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.groupName}"></h:outputText>
			
					<h:outputText value="ModuleName" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.moduleName}"></h:outputText>
			
					<h:outputText value="Requirement status" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.status}"></h:outputText>
			
				</h:panelGrid>
			
		 
	 		
		</t:panelTab>
	<t:panelTab label="SRS Details">
			
			<br>
				<h:panelGrid border="1" columns="2" style="width: 570px" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign" styleClass="filterBOX">
			
					<h:outputText value="Id" ></h:outputText>
					<h:outputText value="#{masterReq.masterRequirementId}"></h:outputText>
			
					<h:outputText value="Title" ></h:outputText>
					<h:outputText value="#{masterReq.masterRequirementTitle}"></h:outputText>
			
					<h:outputText value="Master Requirement Description"></h:outputText>
					<h:inputTextarea id="txtAreaDescription" style="background-color: #E8F5FD; width: 350px; " rows="3"  readonly="true" value="#{masterReq.description}" styleClass="contentTEXT" />
			
			
				</h:panelGrid>
			
		 	
	 	
		</t:panelTab>
		<t:panelTab label="FRS Details">
		
			 <br>
			
				<h:panelGrid border="1" columns="2" style="width: 570px" columnClasses="pannelGridMainColumn,pannegGridColumLeftAllign" styleClass="filterBOX">
			
					<h:outputText value="GroupName" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.groupName}"></h:outputText>
			
					<h:outputText value="ModuleName" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.moduleName}"></h:outputText>
			
					<h:outputText value="Requirement status" style="width:130px;"></h:outputText>
					<h:outputText value="#{masterReq.status}"></h:outputText>
			
				</h:panelGrid>
			
		 
	 		
		</t:panelTab>
	
	</t:panelTabbedPane>
	</h:form>
	</h:dataTable>
	......................
	<br><br><br><br><br><br>
 


<t:panelTabbedPane id="tabbedpane1"  selectedIndex="2" frame="none" inactiveTabStyleClass="inactiveTabSubStyle">
<t:panelTab id="tab1" label="1st Tab">
<h:panelGrid columns="2">
<h:outputText value="Tab1text"></h:outputText>
<h:outputText value="Tab1Value"></h:outputText>
</h:panelGrid>
</t:panelTab>

<t:panelTab id="tab2" label="2nd Tab">
<h:panelGrid columns="2">
<h:outputText value="Tab2text"></h:outputText>
<h:outputText value="Tab2Value"></h:outputText>
</h:panelGrid>
</t:panelTab>

<t:panelTab id="tab3" label="3rd Tab">
<h:panelGrid columns="2">
<h:outputText value="Tab3text"></h:outputText>
<h:outputText value="Tab3Value"></h:outputText>
</h:panelGrid>
</t:panelTab>


</t:panelTabbedPane>

<h:outputText value="#{masterRequirementMB.message}"></h:outputText>

</center>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="Footer.jsp"></jsp:include>
</f:view>
</body>
</html>