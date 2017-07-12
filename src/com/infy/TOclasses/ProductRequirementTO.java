package com.infy.TOclasses;

import java.util.Date;




public class ProductRequirementTO 
{
	
	private String productRequirementId;
	private String masterRequirementId;
	private String groupId;
	private String productVersion;
	private String productRequirementDescription;
	private String frsName;
	private Date frsClosureDate;
	private String srsName;
	private Date srsClosureDate;
	private String comments;
	private String approvedStatus;
	private String productRequirementTitle;
	private String groupName;
	private String moduleName;
	private String masterRequirementTitle;
	private String masterRequirementDescription;
	private String productRequirementStatus;
	private String remark;
	private String localization;
	private String functionalEffort;
	private String developmentEffort;
	private String dgOwner;
	
	public String getProductManager() {
		return productManager;
	}
	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}
	public String getOwnerEmployeeId() {
		return ownerEmployeeId;
	}
	public void setOwnerEmployeeId(String ownerEmployeeId) {
		this.ownerEmployeeId = ownerEmployeeId;
	}
	private String emailId;
	private String productManager;
	private String ownerEmployeeId;
	private String anchorName;
	
	
	public String getAnchorName() {
		return anchorName;
	}
	public void setAnchorName(String anchorName) {
		this.anchorName = anchorName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	private String functionalPLM;
	private String moduleAnchor;
	private String customer;
	private String source;
	private String droppedFromScope;
	private String enhancementType;	
	
	public String getEnhancementType() {
		return enhancementType;
	}
	public void setEnhancementType(String enhancementType) {
		this.enhancementType = enhancementType;
	}
	public String getFunctionalPLM() {
		return functionalPLM;
	}
	public void setFunctionalPLM(String functionalPLM) {
		this.functionalPLM = functionalPLM;
	}
	public String getModuleAnchor() {
		return moduleAnchor;
	}
	public void setModuleAnchor(String moduleAnchor) {
		this.moduleAnchor = moduleAnchor;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDroppedFromScope() {
		return droppedFromScope;
	}
	public void setDroppedFromScope(String droppedFromScope) {
		this.droppedFromScope = droppedFromScope;
	}
	public String getsRSDocumentName() {
		return sRSDocumentName;
	}
	public void setsRSDocumentName(String sRSDocumentName) {
		this.sRSDocumentName = sRSDocumentName;
	}
	public String getfRSDocumentName() {
		return fRSDocumentName;
	}
	public void setfRSDocumentName(String fRSDocumentName) {
		this.fRSDocumentName = fRSDocumentName;
	}
	public String getcRMImpact() {
		return cRMImpact;
	}
	public void setcRMImpact(String cRMImpact) {
		this.cRMImpact = cRMImpact;
	}
	public String getfASImpact() {
		return fASImpact;
	}
	public void setfASImpact(String fASImpact) {
		this.fASImpact = fASImpact;
	}
	public String geteBankingImpact() {
		return eBankingImpact;
	}
	public void seteBankingImpact(String eBankingImpact) {
		this.eBankingImpact = eBankingImpact;
	}
	public String getfDMImpact() {
		return fDMImpact;
	}
	public void setfDMImpact(String fDMImpact) {
		this.fDMImpact = fDMImpact;
	}
	public String getwMSImpact() {
		return wMSImpact;
	}
	public void setwMSImpact(String wMSImpact) {
		this.wMSImpact = wMSImpact;
	}
	public String getsSOImpact() {
		return sSOImpact;
	}
	public void setsSOImpact(String sSOImpact) {
		this.sSOImpact = sSOImpact;
	}
	public String getlOSImpact() {
		return lOSImpact;
	}
	public void setlOSImpact(String lOSImpact) {
		this.lOSImpact = lOSImpact;
	}
	public String getfCAImpact() {
		return fCAImpact;
	}
	public void setfCAImpact(String fCAImpact) {
		this.fCAImpact = fCAImpact;
	}
	//changes done by sanket mehta
	private String locationName;
	private String subModuleId;
	private String subModuleName;
	private String verticalName;
	private String solutionName;
	
	private String versionId;
	/*private String localizationId;
	private String localizationName;
	
	//changes completed
	
	//SRS related Data
	
	public String getLocalizationId() {
		return localizationId;
	}
	public void setLocalizationId(String localizationId) {
		this.localizationId = localizationId;*/
	//}
	public String getVersionId() {
		return versionId;
	}
	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}
	/*public String getLocalizationName() {
		return localizationName;
	}
	public void setLocalizationName(String localizationName) {
		this.localizationName = localizationName;
	}*/
	public String getSolutionName() {
		return solutionName;
	}
	public void setSolutionName(String solutionName) {
		this.solutionName = solutionName;
	}
	public String getVerticalName() {
		return verticalName;
	}
	public void setVerticalName(String verticalName) {
		this.verticalName = verticalName;
	}
	private String srsId;
	private String sRSDocumentName;
	private String srsOwnerEmailId;
	private String srsStatus;
	private Date plannedDateForSRS;
	private Date actualDateForSRS;
	private Date groupReviewDateForSRS;
	private String srsRemarks;
	private String srsCheckedInTFS ="No";
	private String srsRAAnchor;
	
	//FRS Related Data
	
	private String frsId;
	private String fRSDocumentName;
	private String 	projectCode;
	private String 	frsOwnerEmailId;
	private String 	frsStatus;
	private Date 	plannedDateForFRS;
	private Date 	actualDateForFRS;
	private Date 	groupReviewDateForFRS;
	private String 	frsRemarks;
	private String 	frsCheckedInTFS = "No";
	
	//Impact Related Data
	
	private String impactId;
	private String archieImpact;
	private String coreImpact;
	private String cRMImpact;
	private String fASImpact;
	private String odsImpact;
	private String fiImpact;
	private String eBankingImpact;
	private String directBankingImpact;
	private String originationImpact;
	private String fDMImpact;
	private String treasuryImpact;
	private String wMSImpact;
	private String finanzToolImpact;
	private String multichannelImpact;
	private String sSOImpact;
	private String all24By7Impact;
	private String svsImpact;
	private String fabImpact;
	private String csisImpact;
	private String lOSImpact;
	private String fCAImpact;
	private String thirdPartyImpact;
	
	// Changes done by sanket
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}
	public String getSubModuleName() {
		return subModuleName;
	}
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	//changes completed
	
	public String getMasterRequirementDescription() {
		return masterRequirementDescription;
	}
	public void setMasterRequirementDescription(String masterRequirmentDescription) {
		this.masterRequirementDescription = masterRequirmentDescription;
	} 
	public String getProductRequirementTitle() {
		return productRequirementTitle;
	}
	public void setProductRequirementTitle(String productRequirmentTitle) {
		this.productRequirementTitle = productRequirmentTitle;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getMasterRequirementTitle() {
		return masterRequirementTitle;
	}
	public void setMasterRequirementTitle(String masterRequirmentTitle) {
		this.masterRequirementTitle = masterRequirmentTitle;
	}
	public String getProductRequirementId() {
		return productRequirementId;
	}
	public void setProductRequirementId(String productRequirementId) {
		this.productRequirementId = productRequirementId;
	}
	public String getMasterRequirementId() {
		return masterRequirementId;
	}
	public void setMasterRequirementId(String masterRequirementId) {
		this.masterRequirementId = masterRequirementId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getProductVersion() {
		return productVersion;
	}
	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}
	public String getProductRequirementDescription() {
		return productRequirementDescription;
	}
	public void setProductRequirementDescription(
			String productRequirementDescription) {
		this.productRequirementDescription = productRequirementDescription;
	}
	public String getFrsName() {
		return frsName;
	}
	public void setFrsName(String frsName) {
		this.frsName = frsName;
	}
	public Date getFrsClosureDate() {
		return frsClosureDate;
	}
	public void setFrsClosureDate(Date frsClosureDate) {
		this.frsClosureDate = frsClosureDate;
	}
	public String getSrsName() {
		return srsName;
	}
	public void setSrsName(String srsName) {
		this.srsName = srsName;
	}
	public Date getSrsClosureDate() {
		return srsClosureDate;
	}
	public void setSrsClosureDate(Date srsClosureDate) {
		this.srsClosureDate = srsClosureDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getApprovedStatus() {
		return approvedStatus;
	}
	public void setApprovedStatus(String approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
 
	public String getProductRequirementStatus() {
		return productRequirementStatus;
	}
	public void setProductRequirementStatus(String productRequirementStatus) {
		this.productRequirementStatus = productRequirementStatus;
	}
	 
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ProductRequirementTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getLocalization() {
		return localization;
	}
	public void setLocalization(String localization) {
		this.localization = localization;
	}
	public String getFunctionalEffort() {
		return functionalEffort;
	}
	public void setFunctionalEffort(String functionalEffort) {
		this.functionalEffort = functionalEffort;
	}
	public String getDevelopmentEffort() {
		return developmentEffort;
	}
	public void setDevelopmentEffort(String developmentEffort) {
		this.developmentEffort = developmentEffort;
	}
	public String getDgOwner() {
		return dgOwner;
	}
	public void setDgOwner(String dgOwner) {
		this.dgOwner = dgOwner;
	}
	
	
	
	//---SRS Related 	
	
	public String getSrsId() {
		return srsId;
	}
	public void setSrsId(String srsId) {
		this.srsId = srsId;
	}
	public String getSRSDocumentName() {
		return sRSDocumentName;
	}
	public void setSRSDocumentName(String documentName) {
		sRSDocumentName = documentName;
	}
	public String getSrsOwnerEmailId() {
		return srsOwnerEmailId;
	}
	public void setSrsOwnerEmailId(String srsOwnerEmailId) {
		this.srsOwnerEmailId = srsOwnerEmailId;
	}
	public String getSrsStatus() {
		return srsStatus;
	}
	public void setSrsStatus(String srsStatus) {
		this.srsStatus = srsStatus;
	}
	public Date getPlannedDateForSRS() {
		return plannedDateForSRS;
	}
	public void setPlannedDateForSRS(Date plannedDateForSRS) {
		this.plannedDateForSRS = plannedDateForSRS;
	}
	public Date getActualDateForSRS() {
		return actualDateForSRS;
	}
	public void setActualDateForSRS(Date actualDateForSRS) {
		this.actualDateForSRS = actualDateForSRS;
	}
	public Date getGroupReviewDateForSRS() {
		return groupReviewDateForSRS;
	}
	public void setGroupReviewDateForSRS(Date groupReviewDateForSRS) {
		this.groupReviewDateForSRS = groupReviewDateForSRS;
	}
	 
	public String getSrsRemarks() {
		return srsRemarks;
	}
	public void setSrsRemarks(String srsRemarks) {
		this.srsRemarks = srsRemarks;
	}
	public String getSrsCheckedInTFS() {
		return srsCheckedInTFS;
	}
	public void setSrsCheckedInTFS(String srsCheckedInTFS) {
		this.srsCheckedInTFS = srsCheckedInTFS;
	}
	public String getSrsRAAnchor() {
		return srsRAAnchor;
	}
	public void setSrsRAAnchor(String srsRAAnchor) {
		this.srsRAAnchor = srsRAAnchor;
	}
	
	
	//--FRS Related
	
	
	public String getFrsId() {
		return frsId;
	}
	public void setFrsId(String frsId) {
		this.frsId = frsId;
	}
	public String getFRSDocumentName() {
		return fRSDocumentName;
	}
	public void setFRSDocumentName(String documentName) {
		fRSDocumentName = documentName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getFrsOwnerEmailId() {
		return frsOwnerEmailId;
	}
	public void setFrsOwnerEmailId(String frsOwnerEmailId) {
		this.frsOwnerEmailId = frsOwnerEmailId;
	}
	public String getFrsStatus() {
		return frsStatus;
	}
	public void setFrsStatus(String frsStatus) {
		this.frsStatus = frsStatus;
	}
	public Date getPlannedDateForFRS() {
		return plannedDateForFRS;
	}
	public void setPlannedDateForFRS(Date plannedDateForFRS) {
		this.plannedDateForFRS = plannedDateForFRS;
	}
	public Date getActualDateForFRS() {
		return actualDateForFRS;
	}
	public void setActualDateForFRS(Date actualDateForFRS) {
		this.actualDateForFRS = actualDateForFRS;
	}
	
	public Date getGroupReviewDateForFRS() {
		return groupReviewDateForFRS;
	}
	public void setGroupReviewDateForFRS(Date groupReviewDateForFRS) {
		this.groupReviewDateForFRS = groupReviewDateForFRS;
	}
	 
	public String getFrsRemarks() {
		return frsRemarks;
	}
	public void setFrsRemarks(String frsRemarks) {
		this.frsRemarks = frsRemarks;
	}
	public String getFrsCheckedInTFS() {
		return frsCheckedInTFS;
	}
	public void setFrsCheckedInTFS(String frsCheckedInTFS) {
		this.frsCheckedInTFS = frsCheckedInTFS;
	}
	
	//---Impact Related
	
	public String getImpactId() {
		return impactId;
	}
	public void setImpactId(String impactId) {
		this.impactId = impactId;
	}
	public String getArchieImpact() {
		return archieImpact;
	}
	public void setArchieImpact(String archieImpact) {
		this.archieImpact = archieImpact;
	}
	public String getCoreImpact() {
		return coreImpact;
	}
	public void setCoreImpact(String coreImpact) {
		this.coreImpact = coreImpact;
	}
	public String getCRMImpact() {
		return cRMImpact;
	}
	public void setCRMImpact(String impact) {
		cRMImpact = impact;
	}
	public String getFASImpact() {
		return fASImpact;
	}
	public void setFASImpact(String impact) {
		fASImpact = impact;
	}
	public String getOdsImpact() {
		return odsImpact;
	}
	public void setOdsImpact(String odsImpact) {
		this.odsImpact = odsImpact;
	}
	public String getFiImpact() {
		return fiImpact;
	}
	public void setFiImpact(String fiImpact) {
		this.fiImpact = fiImpact;
	}
	public String getEBankingImpact() {
		return eBankingImpact;
	}
	public void setEBankingImpact(String bankingImpact) {
		eBankingImpact = bankingImpact;
	}
	public String getDirectBankingImpact() {
		return directBankingImpact;
	}
	public void setDirectBankingImpact(String directBankingImpact) {
		this.directBankingImpact = directBankingImpact;
	}
	public String getOriginationImpact() {
		return originationImpact;
	}
	public void setOriginationImpact(String originationImpact) {
		this.originationImpact = originationImpact;
	}
	public String getFDMImpact() {
		return fDMImpact;
	}
	public void setFDMImpact(String impact) {
		fDMImpact = impact;
	}
	public String getTreasuryImpact() {
		return treasuryImpact;
	}
	public void setTreasuryImpact(String treasuryImpact) {
		this.treasuryImpact = treasuryImpact;
	}
	public String getWMSImpact() {
		return wMSImpact;
	}
	public void setWMSImpact(String impact) {
		wMSImpact = impact;
	}
	public String getFinanzToolImpact() {
		return finanzToolImpact;
	}
	public void setFinanzToolImpact(String finanzToolImpact) {
		this.finanzToolImpact = finanzToolImpact;
	}
	public String getMultichannelImpact() {
		return multichannelImpact;
	}
	public void setMultichannelImpact(String multichannelImpact) {
		this.multichannelImpact = multichannelImpact;
	}
	public String getSSOImpact() {
		return sSOImpact;
	}
	public void setSSOImpact(String impact) {
		sSOImpact = impact;
	}
	public String getAll24By7Impact() {
		return all24By7Impact;
	}
	public void setAll24By7Impact(String all24By7Impact) {
		this.all24By7Impact = all24By7Impact;
	}
	public String getSvsImpact() {
		return svsImpact;
	}
	public void setSvsImpact(String svsImpact) {
		this.svsImpact = svsImpact;
	}
	public String getFabImpact() {
		return fabImpact;
	}
	public void setFabImpact(String fabImpact) {
		this.fabImpact = fabImpact;
	}
	public String getCsisImpact() {
		return csisImpact;
	}
	public void setCsisImpact(String csisImpact) {
		this.csisImpact = csisImpact;
	}
	public String getLOSImpact() {
		return lOSImpact;
	}
	public void setLOSImpact(String impact) {
		lOSImpact = impact;
	}
	public String getFCAImpact() {
		return fCAImpact;
	}
	public void setFCAImpact(String impact) {
		fCAImpact = impact;
	}
	public String getThirdPartyImpact() {
		return thirdPartyImpact;
	}
	public void setThirdPartyImpact(String thirdPartyImpact) {
		this.thirdPartyImpact = thirdPartyImpact;
	}
	public ProductRequirementTO(ProductRequirementTO productRequirementTO)
	{
		if(productRequirementTO.productRequirementDescription!=null)
		this.productRequirementDescription=new String(productRequirementTO.productRequirementDescription);
		
		if(productRequirementTO.productRequirementTitle!=null)
		this.productRequirementTitle=new String(productRequirementTO.productRequirementTitle.getBytes());
		
		if(productRequirementTO.approvedStatus!=null)
		this.approvedStatus=productRequirementTO.approvedStatus;
		if(productRequirementTO.comments!=null)
		this.comments=productRequirementTO.comments;
		if(productRequirementTO.frsClosureDate!=null)
		this.frsClosureDate=productRequirementTO.frsClosureDate;
		if(productRequirementTO.frsName!=null)
		this.frsName=productRequirementTO.frsName;
		if(productRequirementTO.groupId!=null)
		this.groupId=productRequirementTO.groupId;
		if(productRequirementTO.groupName!=null)
		this.groupName=productRequirementTO.groupName;
		if(productRequirementTO.masterRequirementDescription!=null)
		this.masterRequirementDescription=productRequirementTO.masterRequirementDescription;
		if(productRequirementTO.masterRequirementId!=null)
		this.masterRequirementId=productRequirementTO.masterRequirementId;
		if(productRequirementTO.masterRequirementTitle!=null)
		this.masterRequirementTitle=productRequirementTO.masterRequirementTitle;
		if(productRequirementTO.moduleName!=null)
		this.moduleName=productRequirementTO.moduleName;
		//this.productRequirementDescription=productRequirementTO.productRequirementDescription;
		if(productRequirementTO.productRequirementId!=null)
		this.productRequirementId=productRequirementTO.productRequirementId;
		//this.productRequirementTitle=productRequirementTO.productRequirementTitle;
		if(productRequirementTO.productVersion!=null)
		this.productVersion=productRequirementTO.productVersion;
		if(productRequirementTO.srsClosureDate!=null)
		this.srsClosureDate=productRequirementTO.srsClosureDate;
		if(productRequirementTO.srsName!=null)
		this.srsName=productRequirementTO.srsName;
		if(productRequirementTO.localization!=null)
		this.localization=productRequirementTO.localization;
		if(productRequirementTO.functionalEffort!=null)
		this.functionalEffort=productRequirementTO.functionalEffort;
		if(productRequirementTO.developmentEffort!=null)
		this.developmentEffort=productRequirementTO.developmentEffort;
		if(productRequirementTO.dgOwner!=null)
		this.dgOwner=productRequirementTO.dgOwner;
		
		if(productRequirementTO.srsId!=null)
		this.srsId=productRequirementTO.srsId;
		if(productRequirementTO.sRSDocumentName!=null)
		this.sRSDocumentName=productRequirementTO.sRSDocumentName;
		if(productRequirementTO.srsOwnerEmailId!=null)
		this.srsOwnerEmailId=productRequirementTO.srsOwnerEmailId;
		if(productRequirementTO.srsStatus!=null)
		this.srsStatus=productRequirementTO.srsStatus;
		if(productRequirementTO.plannedDateForSRS!=null)
		this.plannedDateForSRS=productRequirementTO.plannedDateForSRS;
		if(productRequirementTO.actualDateForSRS!=null)
		this.actualDateForSRS=productRequirementTO.actualDateForSRS;
		if(productRequirementTO.groupReviewDateForSRS!=null)
		this.groupReviewDateForSRS=productRequirementTO.groupReviewDateForSRS;
		if(productRequirementTO.srsRemarks!=null)
		this.srsRemarks=productRequirementTO.srsRemarks;
		if(productRequirementTO.srsCheckedInTFS!=null)
		this.srsCheckedInTFS=productRequirementTO.srsCheckedInTFS;
		if(productRequirementTO.srsRAAnchor!=null)
		this.srsRAAnchor=productRequirementTO.srsRAAnchor;
		
		//FRS Related Data
		if(productRequirementTO.frsId!=null)
		this.frsId=productRequirementTO.frsId;
		if(productRequirementTO.fRSDocumentName!=null)
		this.fRSDocumentName=productRequirementTO.fRSDocumentName;
		if(productRequirementTO.projectCode!=null)
		this.projectCode=productRequirementTO.projectCode;
		if(productRequirementTO.frsOwnerEmailId!=null)
		this.frsOwnerEmailId=productRequirementTO.frsOwnerEmailId;
		if(productRequirementTO.frsStatus!=null)
		this.frsStatus=productRequirementTO.frsStatus;
		if(productRequirementTO.plannedDateForFRS!=null)
		this.plannedDateForFRS=productRequirementTO.plannedDateForFRS;
		if(productRequirementTO.actualDateForFRS!=null)
		this.actualDateForFRS=productRequirementTO.actualDateForFRS;
		if(productRequirementTO.groupReviewDateForFRS!=null)
		this.groupReviewDateForFRS=productRequirementTO.groupReviewDateForFRS;
		if(productRequirementTO.frsRemarks!=null)
		this.frsRemarks=productRequirementTO.frsRemarks;
		if(productRequirementTO.frsCheckedInTFS!=null)
		this.frsCheckedInTFS=productRequirementTO.frsCheckedInTFS;
		
		//Impact Related Data
		if(productRequirementTO.impactId!=null)
		this.impactId=productRequirementTO.impactId;
		if(productRequirementTO.archieImpact!=null)
		this.archieImpact=productRequirementTO.archieImpact;
		if(productRequirementTO.coreImpact!=null)
		this.coreImpact=productRequirementTO.coreImpact;
		if(productRequirementTO.cRMImpact!=null)
		this.cRMImpact=productRequirementTO.cRMImpact;
		if(productRequirementTO.fASImpact!=null)
		this.fASImpact=productRequirementTO.fASImpact;
		if(productRequirementTO.odsImpact!=null)
		this.odsImpact=productRequirementTO.odsImpact;
		if(productRequirementTO.fiImpact!=null)
		this.fiImpact=productRequirementTO.fiImpact;
		if(productRequirementTO.eBankingImpact!=null)
		this.eBankingImpact=productRequirementTO.eBankingImpact;
		if(productRequirementTO.directBankingImpact!=null)
		this.directBankingImpact=productRequirementTO.directBankingImpact;
		if(productRequirementTO.originationImpact!=null)
		this.originationImpact=productRequirementTO.originationImpact;
		if(productRequirementTO.fDMImpact!=null)
		this.fDMImpact=productRequirementTO.fDMImpact;
		if(productRequirementTO.treasuryImpact!=null)
		this.treasuryImpact=productRequirementTO.treasuryImpact;
		if(productRequirementTO.wMSImpact!=null)
		this.wMSImpact=productRequirementTO.wMSImpact;
		if(productRequirementTO.finanzToolImpact!=null)
		this.finanzToolImpact=productRequirementTO.finanzToolImpact;
		if(productRequirementTO.multichannelImpact!=null)
		this.multichannelImpact=productRequirementTO.multichannelImpact;
		if(productRequirementTO.sSOImpact!=null)
		this.sSOImpact=productRequirementTO.sSOImpact;
		if(productRequirementTO.all24By7Impact!=null)
		this.all24By7Impact=productRequirementTO.all24By7Impact;
		if(productRequirementTO.svsImpact!=null)
		this.svsImpact=productRequirementTO.svsImpact;
		if(productRequirementTO.fabImpact!=null)
		this.fabImpact=productRequirementTO.fabImpact;
		if(productRequirementTO.csisImpact!=null)
		this.csisImpact=productRequirementTO.csisImpact;
		if(productRequirementTO.lOSImpact!=null)
		this.lOSImpact=productRequirementTO.lOSImpact;
		if(productRequirementTO.fCAImpact!=null)
		this.fCAImpact=productRequirementTO.fCAImpact;
		if(productRequirementTO.thirdPartyImpact!=null)
		this.thirdPartyImpact=productRequirementTO.thirdPartyImpact;
		
		
	
	}
	public ProductRequirementTO getCloneObject()
	{
		try
		{
			ProductRequirementTO requirementTO=(ProductRequirementTO)this.clone();
			
			return requirementTO;
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}

	}
	
}
