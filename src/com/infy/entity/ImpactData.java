package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRMS_Impact")
public class ImpactData {
	@Id
	private String impactId;
	private String productRequirementId;
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
	public String getImpactId() {
		return impactId;
	}
	public void setImpactId(String impactId) {
		this.impactId = impactId;
	}
	public String getProductRequirementId() {
		return productRequirementId;
	}
	public void setProductRequirementId(String productRequirementId) {
		this.productRequirementId = productRequirementId;
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
	
	
}
