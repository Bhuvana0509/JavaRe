package com.infy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.print.attribute.standard.PDLOverrideSupported;
import javax.servlet.http.HttpSession;

import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.ImpactDetailsTO;
import com.infy.TOclasses.MasterRequirementTO;
import com.infy.TOclasses.ModuleAnchorTO;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.entity.FRSData;
import com.infy.entity.GroupInfo;
import com.infy.entity.ImpactData;
import com.infy.entity.InitiatingGroup;
import com.infy.entity.MasterRequirement;
import com.infy.entity.ProductRequirement;
import com.infy.entity.SRSData;
import com.infy.entity.Source;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoInitiatingGroupsAvailableException;
import com.infy.exceptions.NoProductReqAvailableException;
import com.infy.exceptions.NoSourceAvailableException;
import com.infy.exceptions.NoVersionFoundException;
import com.infy.exceptions.UserDoesNotExistException;

public class ProductRequirementService {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	EntityManager em = null;
	public List<String> getAllVersions()throws Exception
	{
		EntityManager em = null;
		List<String> versionList = null;

		try 
		{
			em = emf.createEntityManager();
			//Query query = em.createQuery("select distinct p.productVersion from ProductRequirement p");
			Query query = em.createQuery("select p.versionName from ProductVersion p");
			versionList = (List<String>) query.getResultList();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			if (em != null) 
			{
				em.close();
			}
		}
		return versionList;

	}
	
	/*public Map<String,String> getAllVersions()throws Exception
	{
		EntityManager em = null;
		Map<String,String> versionMap = null;

		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();

			Query query= em.createQuery("select distinct p.productVersion from ProductRequirement p");
			
			List<ProductRequirement> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
				for(ProductRequirement pr : rs1)
				{
					versionMap.put(pr.getProductRequirementId(),pr.getProductVersion());

				}
			}
			else
			{
				throw new NoSourceAvailableException();
			}
			et.commit();

		}
		catch(Exception e)
		{
			throw e;
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
		return versionMap;

	}*/

	

	public ProductRequirementTO getProductRequirmentById(String requirmentId) throws Exception {

		try 
		{
			ProductRequirementTO productRequirementTO=null;
			em=emf.createEntityManager();
			ProductRequirement productRequirement=em.find(ProductRequirement.class, requirmentId);
			if(productRequirement!=null)
			{
				productRequirementTO=new ProductRequirementTO();

				productRequirementTO.setApprovedStatus(productRequirement.getApprovedStatus());
				productRequirementTO.setComments(productRequirement.getComments());
				productRequirementTO.setFrsClosureDate(productRequirement.getFrsClosureDate());
				productRequirementTO.setFrsName(productRequirement.getFrsName());
				productRequirementTO.setGroupId(productRequirement.getGroupId());
				productRequirementTO.setMasterRequirementId(productRequirement.getMasterRequirementId());
				productRequirementTO.setProductRequirementDescription(productRequirement.getProductRequirementDescription());
			
				productRequirementTO.setProductRequirementId(productRequirement.getProductRequirementId());
				productRequirementTO.setProductVersion(productRequirement.getProductVersion());
				productRequirementTO.setSrsClosureDate(productRequirement.getSrsClosureDate());
				productRequirementTO.setSrsName(productRequirement.getSrsName());
				productRequirementTO.setProductRequirementTitle(productRequirement.getProductRequirementTitle());
				productRequirementTO.setLocalization(productRequirement.getLocalization());
				productRequirementTO.setFunctionalEffort(productRequirement.getFunctionalEffort());
				productRequirementTO.setDevelopmentEffort(productRequirement.getDevelopmentEffort());
				productRequirementTO.setDgOwner(productRequirement.getDgOwner());

				GroupInfoService groupInfoService=new GroupInfoService();
				String groupName=groupInfoService.getGroupDetailsById(productRequirementTO.getGroupId()).getGroupName();

				productRequirementTO.setGroupName(groupName);


				MasterRequirementService masterRequirementService=new MasterRequirementService();
				MasterRequirementTO masterRequirementTO=masterRequirementService.getMasterReqDetailsById(productRequirement.getMasterRequirementId());

				productRequirementTO.setMasterRequirementTitle(masterRequirementTO.getMasterRequirementTitle());
				productRequirementTO.setMasterRequirementDescription(masterRequirementTO.getDescription());
				//changes done by sanket mehta
				productRequirementTO.setLocationName(masterRequirementTO.getLocationName());
				//productRequirementTO.setSubModuleName(masterRequirementTO.getSubModuleName());
				productRequirementTO.setVerticalName(masterRequirementTO.getVerticalName());
				productRequirementTO.setSolutionName(masterRequirementTO.getSolutionName());
				//changes completed

				ModuleAnchorService moduleAnchorService=new ModuleAnchorService();
				/*String moduleName=moduleAnchorService.getModuleById(masterRequirementTO.getModuleId()).getModuleName();
				productRequirementTO.setModuleName(moduleName);*/
				
				String moduleName=moduleAnchorService.getModuleById(masterRequirementTO.getModuleId()).getModuleName();
				productRequirementTO.setModuleName(moduleName);
				
				Query query=em.createQuery("select frs from FRSData frs where frs.productRequirementId=?1");
				query.setParameter(1, requirmentId);
				List<FRSData> frsDataList=query.getResultList();
				if(!frsDataList.isEmpty())
				{
					for (FRSData data : frsDataList) 
					{
						productRequirementTO.setFrsId(data.getFrsId());
						productRequirementTO.setFRSDocumentName(data.getFRSDocumentName());
						productRequirementTO.setProjectCode(data.getProjectCode());
						productRequirementTO.setFrsOwnerEmailId(data.getFrsOwnerEmailId());
						productRequirementTO.setFrsStatus(data.getFrsStatus());
						productRequirementTO.setPlannedDateForFRS(data.getPlannedDateForFRS());
						productRequirementTO.setActualDateForFRS(data.getActualDateForFRS());
						productRequirementTO.setGroupReviewDateForFRS(data.getGroupReviewDateForFRS());
						productRequirementTO.setFrsRemarks(data.getRemarks());
						productRequirementTO.setFrsCheckedInTFS(data.getCheckedInTFS());
						
					}
				}
				query=em.createQuery("select srs from SRSData srs where srs.productRequirementId=?1");
				query.setParameter(1, requirmentId);
				List<SRSData> srsDataList=query.getResultList();
				if(!srsDataList.isEmpty())
				{
					for (SRSData data : srsDataList) 
					{
						productRequirementTO.setSrsId(data.getSrsId());
						productRequirementTO.setSRSDocumentName(data.getSRSDocumentName());
						productRequirementTO.setSrsOwnerEmailId(data.getSrsOwnerEmailId());
						productRequirementTO.setSrsStatus(data.getSrsStatus());
						productRequirementTO.setPlannedDateForSRS(data.getPlannedDateForSRS());
						productRequirementTO.setActualDateForSRS(data.getActualDateForSRS());
						productRequirementTO.setGroupReviewDateForSRS(data.getGroupReviewDateForSRS());
						productRequirementTO.setSrsRemarks(data.getRemarks());
						productRequirementTO.setSrsCheckedInTFS(data.getCheckedInTFS());
						productRequirementTO.setSrsRAAnchor(data.getRAAnchor());
					}
				}
				query=em.createQuery("select im from ImpactData im where im.productRequirementId=?1");
				query.setParameter(1, requirmentId);
				List<ImpactData> impactDataList=query.getResultList();
				if(!impactDataList.isEmpty())
				{
					for (ImpactData impactData : impactDataList) 
					{
						productRequirementTO.setImpactId(impactData.getImpactId());
						productRequirementTO.setArchieImpact(impactData.getArchieImpact());
						productRequirementTO.setCoreImpact(impactData.getCoreImpact());
						productRequirementTO.setCRMImpact(impactData.getCRMImpact());
						productRequirementTO.setFASImpact(impactData.getFASImpact());
						productRequirementTO.setOdsImpact(impactData.getOdsImpact());
						productRequirementTO.setFiImpact(impactData.getFiImpact());
						productRequirementTO.setEBankingImpact(impactData.getEBankingImpact());
						productRequirementTO.setDirectBankingImpact(impactData.getDirectBankingImpact());
						productRequirementTO.setOriginationImpact(impactData.getOriginationImpact());
						productRequirementTO.setFDMImpact(impactData.getFDMImpact());
						productRequirementTO.setTreasuryImpact(impactData.getTreasuryImpact());
						productRequirementTO.setWMSImpact(impactData.getWMSImpact());
						productRequirementTO.setFinanzToolImpact(impactData.getFinanzToolImpact());
						productRequirementTO.setMultichannelImpact(impactData.getMultichannelImpact());
						productRequirementTO.setSSOImpact(impactData.getSSOImpact());
						productRequirementTO.setAll24By7Impact(impactData.getAll24By7Impact());
						productRequirementTO.setSvsImpact(impactData.getSvsImpact());
						productRequirementTO.setFabImpact(impactData.getFabImpact());
						productRequirementTO.setCsisImpact(impactData.getCsisImpact());
						productRequirementTO.setLOSImpact(impactData.getLOSImpact());
						productRequirementTO.setFCAImpact(impactData.getFCAImpact());
						productRequirementTO.setThirdPartyImpact(impactData.getThirdPartyImpact());
						
					}
				}
				

			}
			return productRequirementTO;

		} 
		catch (Exception e) 
		{
			throw e;
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}

	}

	public boolean updateProductRequirement(ProductRequirementTO productRequirementTO) throws Exception
	{
		try
		{
			em=emf.createEntityManager();
			em.getTransaction().begin();
			ProductRequirement productRequirement=em.find(ProductRequirement.class, productRequirementTO.getProductRequirementId());
			SRSData srsData=em.find(SRSData.class, productRequirementTO.getSrsId());
			FRSData frsData=em.find(FRSData.class, productRequirementTO.getFrsId());
			ImpactData impactData=em.find(ImpactData.class, productRequirementTO.getImpactId());
			
			if(productRequirement!=null)
			{
				productRequirement.setProductRequirementTitle(productRequirementTO.getProductRequirementTitle());
				productRequirement.setProductRequirementDescription(productRequirementTO.getProductRequirementDescription());
				productRequirement.setProductVersion(productRequirementTO.getProductVersion());
				/*productRequirement.setFrsName(productRequirementTO.getFrsName());
				productRequirement.setFrsClosureDate(productRequirementTO.getFrsClosureDate());
				productRequirement.setSrsName(productRequirementTO.getSrsName());
				productRequirement.setSrsClosureDate(productRequirementTO.getSrsClosureDate());*/
				productRequirement.setLocalization(productRequirementTO.getLocalization());
				productRequirement.setFunctionalEffort(productRequirementTO.getFunctionalEffort());
				productRequirement.setDevelopmentEffort(productRequirementTO.getDevelopmentEffort());
				productRequirement.setDgOwner(productRequirementTO.getDgOwner());
				productRequirement.setComments(productRequirementTO.getComments());
				
				frsData.setFrsId(productRequirementTO.getFrsId());
				frsData.setFRSDocumentName(productRequirementTO.getFRSDocumentName());
				frsData.setProjectCode(productRequirementTO.getProjectCode());
				frsData.setFrsOwnerEmailId(productRequirementTO.getFrsOwnerEmailId());
				frsData.setFrsStatus(productRequirementTO.getFrsStatus());
				frsData.setPlannedDateForFRS(productRequirementTO.getPlannedDateForFRS());
				frsData.setActualDateForFRS(productRequirementTO.getActualDateForFRS());
				frsData.setGroupReviewDateForFRS(productRequirementTO.getGroupReviewDateForFRS());
				frsData.setRemarks(productRequirementTO.getFrsRemarks());
				frsData.setCheckedInTFS(productRequirementTO.getFrsCheckedInTFS());
				
				
				srsData.setSrsId(productRequirementTO.getSrsId());
				srsData.setSRSDocumentName(productRequirementTO.getSRSDocumentName());
				srsData.setSrsOwnerEmailId(productRequirementTO.getSrsOwnerEmailId());
				srsData.setSrsStatus(productRequirementTO.getSrsStatus());
				srsData.setPlannedDateForSRS(productRequirementTO.getPlannedDateForSRS());
				srsData.setActualDateForSRS(productRequirementTO.getActualDateForSRS());
				srsData.setGroupReviewDateForSRS(productRequirementTO.getGroupReviewDateForSRS());
				srsData.setRemarks(productRequirementTO.getSrsRemarks());
				srsData.setCheckedInTFS(productRequirementTO.getSrsCheckedInTFS());
				srsData.setRAAnchor(productRequirementTO.getSrsRAAnchor());
				
				
				impactData.setImpactId(productRequirementTO.getImpactId());
				impactData.setArchieImpact(productRequirementTO.getArchieImpact());
				impactData.setCoreImpact(productRequirementTO.getCoreImpact());
				impactData.setCRMImpact(productRequirementTO.getCRMImpact());
				impactData.setFASImpact(productRequirementTO.getFASImpact());
				impactData.setOdsImpact(productRequirementTO.getOdsImpact());
				impactData.setFiImpact(productRequirementTO.getFiImpact());
				impactData.setEBankingImpact(productRequirementTO.getEBankingImpact());
				impactData.setDirectBankingImpact(productRequirementTO.getDirectBankingImpact());
				impactData.setOriginationImpact(productRequirementTO.getOriginationImpact());
				impactData.setFDMImpact(productRequirementTO.getFDMImpact());
				impactData.setTreasuryImpact(productRequirementTO.getTreasuryImpact());
				impactData.setWMSImpact(productRequirementTO.getWMSImpact());
				impactData.setFinanzToolImpact(productRequirementTO.getFinanzToolImpact());
				impactData.setMultichannelImpact(productRequirementTO.getMultichannelImpact());
				impactData.setSSOImpact(productRequirementTO.getSSOImpact());
				impactData.setAll24By7Impact(productRequirementTO.getAll24By7Impact());
				impactData.setSvsImpact(productRequirementTO.getSvsImpact());
				impactData.setFabImpact(productRequirementTO.getFabImpact());
				impactData.setCsisImpact(productRequirementTO.getCsisImpact());
				impactData.setLOSImpact(productRequirementTO.getLOSImpact());
				impactData.setFCAImpact(productRequirementTO.getFCAImpact());
				impactData.setThirdPartyImpact(productRequirementTO.getThirdPartyImpact());
				
				em.getTransaction().commit();
				return true;
			}
			return false;

		}
		catch (Exception e) {
			throw e;
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}

	}

	public List<ProductRequirementTO> getProductRequirementsByMasterId(String masterRequirementId) throws Exception
	{
		try
		{
			List<ProductRequirementTO> productRequirementToList=null;
			em=emf.createEntityManager();
		
			Query selectQuery=em.createQuery("select p from ProductRequirement p where p.masterRequirementId=?1");
			selectQuery.setParameter(1, masterRequirementId);
			List<ProductRequirement> list= selectQuery.getResultList();

			if(!list.isEmpty())
			{
				productRequirementToList=new ArrayList<ProductRequirementTO>();
				for (ProductRequirement productRequirement : list) 
				{
					ProductRequirementTO productRequirementTO=new ProductRequirementTO();
					productRequirementTO=new ProductRequirementTO();

					productRequirementTO.setApprovedStatus(productRequirement.getApprovedStatus());
					productRequirementTO.setComments(productRequirement.getComments());
					productRequirementTO.setFrsClosureDate(productRequirement.getFrsClosureDate());
					System.out.println("FRMS NNN"+productRequirement.getFrsName());
					productRequirementTO.setFrsName(productRequirement.getFrsName());
					productRequirementTO.setGroupId(productRequirement.getGroupId());
					productRequirementTO.setMasterRequirementId(productRequirement.getMasterRequirementId());
					productRequirementTO.setProductRequirementDescription(productRequirement.getProductRequirementDescription());
					productRequirementTO.setProductRequirementId(productRequirement.getProductRequirementId());
					productRequirementTO.setProductVersion(productRequirement.getProductVersion());
					productRequirementTO.setSrsClosureDate(productRequirement.getSrsClosureDate());
					productRequirementTO.setSrsName(productRequirement.getSrsName());
					productRequirementTO.setProductRequirementTitle(productRequirement.getProductRequirementTitle());
					productRequirementTO.setLocalization(productRequirement.getLocalization());
					productRequirementTO.setFunctionalEffort(productRequirement.getFunctionalEffort());
					productRequirementTO.setDevelopmentEffort(productRequirement.getDevelopmentEffort());
					productRequirementTO.setDgOwner(productRequirement.getDgOwner());

					

					GroupInfoService groupInfoService=new GroupInfoService();
					String groupName=groupInfoService.getGroupDetailsById(productRequirementTO.getGroupId()).getGroupName();

					productRequirementTO.setGroupName(groupName);


					MasterRequirementService masterRequirementService=new MasterRequirementService();
					MasterRequirementTO masterRequirementTO=masterRequirementService.getMasterReqDetailsById(productRequirement.getMasterRequirementId());

					productRequirementTO.setMasterRequirementTitle(masterRequirementTO.getMasterRequirementTitle());
					productRequirementTO.setMasterRequirementDescription(masterRequirementTO.getDescription());
					//changes done by sanket mehta
					productRequirementTO.setLocationName(masterRequirementTO.getLocationName());					
					//changes completed
					
					//changes done by Bhuvana
					//productRequirementTO.setSubModuleName(masterRequirementTO.getSubModuleName());
					productRequirementTO.setVerticalName(masterRequirementTO.getVerticalName());
					productRequirementTO.setModuleName(masterRequirementTO.getModuleName());
					//changes completed

					ModuleAnchorService moduleAnchorService=new ModuleAnchorService();
					String moduleName=moduleAnchorService.getModuleById(masterRequirementTO.getModuleId()).getModuleName();

					productRequirementTO.setModuleName(moduleName);
					
					Query query=em.createQuery("select frs from FRSData frs where frs.productRequirementId=?1");
					query.setParameter(1, productRequirementTO.getProductRequirementId());
					System.out.println("req id"+productRequirementTO.getProductRequirementId());
					List<FRSData> frsDataList=query.getResultList();
					if(!frsDataList.isEmpty())
					{
						for (FRSData data : frsDataList) 
						{
							System.out.println("FRMS EMID"+data.getFrsOwnerEmailId());
							productRequirementTO.setFrsId(data.getFrsId());
							productRequirementTO.setFRSDocumentName(data.getFRSDocumentName());
							productRequirementTO.setProjectCode(data.getProjectCode());
							productRequirementTO.setFrsOwnerEmailId(data.getFrsOwnerEmailId());
							productRequirementTO.setFrsStatus(data.getFrsStatus());
							productRequirementTO.setPlannedDateForFRS(data.getPlannedDateForFRS());
							productRequirementTO.setActualDateForFRS(data.getActualDateForFRS());
							productRequirementTO.setGroupReviewDateForFRS(data.getGroupReviewDateForFRS());
							productRequirementTO.setFrsRemarks(data.getRemarks());
							productRequirementTO.setFrsCheckedInTFS(data.getCheckedInTFS());
							
						}
					}
					query=em.createQuery("select srs from SRSData srs where srs.productRequirementId=?1");
					query.setParameter(1, productRequirementTO.getProductRequirementId());
					List<SRSData> srsDataList=query.getResultList();
					if(!srsDataList.isEmpty())
					{
						for (SRSData data : srsDataList) 
						{
							productRequirementTO.setSrsId(data.getSrsId());
							productRequirementTO.setSRSDocumentName(data.getSRSDocumentName());
							productRequirementTO.setSrsOwnerEmailId(data.getSrsOwnerEmailId());
							productRequirementTO.setSrsStatus(data.getSrsStatus());
							productRequirementTO.setPlannedDateForSRS(data.getPlannedDateForSRS());
							productRequirementTO.setActualDateForSRS(data.getActualDateForSRS());
							productRequirementTO.setGroupReviewDateForSRS(data.getGroupReviewDateForSRS());
							productRequirementTO.setSrsRemarks(data.getRemarks());
							productRequirementTO.setSrsCheckedInTFS(data.getCheckedInTFS());
							productRequirementTO.setSrsRAAnchor(data.getRAAnchor());
						}
					}
					query=em.createQuery("select im from ImpactData im where im.productRequirementId=?1");
					query.setParameter(1, productRequirementTO.getProductRequirementId());
					List<ImpactData> impactDataList=query.getResultList();
					if(!impactDataList.isEmpty())
					{
						for (ImpactData impactData : impactDataList) 
						{
							productRequirementTO.setImpactId(impactData.getImpactId());
							productRequirementTO.setArchieImpact(impactData.getArchieImpact());
							productRequirementTO.setCoreImpact(impactData.getCoreImpact());
							productRequirementTO.setCRMImpact(impactData.getCRMImpact());
							productRequirementTO.setFASImpact(impactData.getFASImpact());
							productRequirementTO.setOdsImpact(impactData.getOdsImpact());
							productRequirementTO.setFiImpact(impactData.getFiImpact());
							productRequirementTO.setEBankingImpact(impactData.getEBankingImpact());
							productRequirementTO.setDirectBankingImpact(impactData.getDirectBankingImpact());
							productRequirementTO.setOriginationImpact(impactData.getOriginationImpact());
							productRequirementTO.setFDMImpact(impactData.getFDMImpact());
							productRequirementTO.setTreasuryImpact(impactData.getTreasuryImpact());
							productRequirementTO.setWMSImpact(impactData.getWMSImpact());
							productRequirementTO.setFinanzToolImpact(impactData.getFinanzToolImpact());
							productRequirementTO.setMultichannelImpact(impactData.getMultichannelImpact());
							productRequirementTO.setSSOImpact(impactData.getSSOImpact());
							productRequirementTO.setAll24By7Impact(impactData.getAll24By7Impact());
							productRequirementTO.setSvsImpact(impactData.getSvsImpact());
							productRequirementTO.setFabImpact(impactData.getFabImpact());
							productRequirementTO.setCsisImpact(impactData.getCsisImpact());
							productRequirementTO.setLOSImpact(impactData.getLOSImpact());
							productRequirementTO.setFCAImpact(impactData.getFCAImpact());
							productRequirementTO.setThirdPartyImpact(impactData.getThirdPartyImpact());
							
						}
					}
					
					productRequirementToList.add(productRequirementTO);
	
				}

			}
			return productRequirementToList;
		}
		catch (Exception e) 
		{
			throw e;
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}

	}
	public void saveSplitedRequriements(List<ProductRequirementTO> productRequirementTOList) throws Exception
	{
		try
		{
			Integer pid=99;
			String productReqId;
			em=emf.createEntityManager();
			em.getTransaction().begin();
			Query query=em.createQuery("select max(p.productRequirementId) from ProductRequirement p");
			String productId=(String)query.getSingleResult();
			if(productId!=null)
			{
				pid=Integer.parseInt(productId.substring(2,productId.length()));
			}
			 
			for (ProductRequirementTO productRequirementTO : productRequirementTOList) 
			{
				ProductRequirement productRequirement=new ProductRequirement();
				if(productRequirementTO.getProductRequirementId()==null)
				{
					productReqId="PR"+String.valueOf(++pid);
					productRequirement.setProductRequirementId(productReqId);
					productRequirementTO.setProductRequirementId(productReqId);
				}
				else
				{
					productRequirement.setProductRequirementId(productRequirementTO.getProductRequirementId());
				
				}
				
				productRequirement.setProductRequirementTitle(productRequirementTO.getProductRequirementTitle());
				productRequirement.setProductRequirementDescription(productRequirementTO.getProductRequirementDescription());
				productRequirement.setProductVersion(productRequirementTO.getProductVersion());
				productRequirement.setFrsName(productRequirementTO.getFrsName());
				productRequirement.setFrsClosureDate(productRequirementTO.getFrsClosureDate());
				productRequirement.setSrsName(productRequirementTO.getSrsName());
				productRequirement.setSrsClosureDate(productRequirementTO.getSrsClosureDate());
				productRequirement.setComments(productRequirementTO.getComments());
				productRequirement.setMasterRequirementId(productRequirementTO.getMasterRequirementId());
				productRequirement.setGroupId(productRequirementTO.getGroupId());
				productRequirement.setApprovedStatus(productRequirementTO.getApprovedStatus());
				productRequirement.setRemark(productRequirementTO.getRemark());
				em.merge(productRequirement);
			}
			em.getTransaction().commit();
		}
		catch (Exception e) {
			//em.getTransaction().rollback();
			throw e;
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
	}

	//get all product requirements
	@SuppressWarnings("unchecked")
	public List<ProductRequirementTO> getAllProductRequirements()throws NoProductReqAvailableException,Exception
	{
		EntityManager em=null;
		List<ProductRequirementTO> toProductReq = new ArrayList<ProductRequirementTO>() ;
		
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();
			
			Query query1= em.createQuery("select pr from ProductRequirement pr");
					
			List<ProductRequirement> rs1 = query1.getResultList();
			
			if(!rs1.isEmpty())
			{
				for(ProductRequirement productReq : rs1)
					{
						ProductRequirementTO productRequirementTO = new ProductRequirementTO();
						
                  		
						productRequirementTO.setProductRequirementId(productReq.getProductRequirementId());
						productRequirementTO.setProductRequirementTitle(productReq.getProductRequirementTitle());
						productRequirementTO.setProductRequirementDescription(productReq.getProductRequirementDescription());
						productRequirementTO.setProductVersion(productReq.getProductVersion());
						productRequirementTO.setApprovedStatus(productReq.getApprovedStatus());
						productRequirementTO.setComments(productReq.getComments());
						productRequirementTO.setFrsClosureDate(productReq.getFrsClosureDate());
						productRequirementTO.setFrsName(productReq.getFrsName());
						productRequirementTO.setSrsClosureDate(productReq.getSrsClosureDate());
						productRequirementTO.setSrsName(productReq.getSrsName());
						
						productRequirementTO.setGroupId(productReq.getGroupId());
						GroupInfoService groupService = new GroupInfoService();
						productRequirementTO.setGroupName(groupService.getGroupDetailsById(productReq.getGroupId()).getGroupName());
												
						productRequirementTO.setMasterRequirementId(productReq.getMasterRequirementId());
						MasterRequirementService masterReqService = new MasterRequirementService();
						MasterRequirementTO masterRequirementTO=masterReqService.getMasterReqDetailsById(productReq.getMasterRequirementId());
						productRequirementTO.setMasterRequirementTitle(masterRequirementTO.getMasterRequirementTitle());
						productRequirementTO.setMasterRequirementDescription(masterRequirementTO.getDescription());
						//changes done by sanket mehta
						productRequirementTO.setLocationName(masterRequirementTO.getLocationName());
						//productRequirementTO.setSubModuleName(masterRequirementTO.getSubModuleName());
						productRequirementTO.setVerticalName(masterRequirementTO.getVerticalName());
						System.out.println("module name in PR Reports: "+masterRequirementTO.getModuleName());
						//changes completed
						productRequirementTO.setProductRequirementTitle(productReq.getProductRequirementTitle());
						productRequirementTO.setLocalization(productReq.getLocalization());
						productRequirementTO.setFunctionalEffort(productReq.getFunctionalEffort());
						productRequirementTO.setDevelopmentEffort(productReq.getDevelopmentEffort());
						productRequirementTO.setDgOwner(productReq.getDgOwner());
						
						ModuleAnchorTO moduleAnchorTO=new ModuleAnchorService().getModuleById(masterRequirementTO.getModuleId());
						productRequirementTO.setModuleName(moduleAnchorTO.getModuleName());	
						
						Query query=em.createQuery("select frs from FRSData frs where frs.productRequirementId=?1");
						query.setParameter(1, productRequirementTO.getProductRequirementId());
						List<FRSData> frsDataList=query.getResultList();
						if(!frsDataList.isEmpty())
						{
							for (FRSData data : frsDataList) 
							{
								productRequirementTO.setFrsId(data.getFrsId());
								productRequirementTO.setFRSDocumentName(data.getFRSDocumentName());
								productRequirementTO.setProjectCode(data.getProjectCode());
								productRequirementTO.setFrsOwnerEmailId(data.getFrsOwnerEmailId());
								productRequirementTO.setFrsStatus(data.getFrsStatus());
								productRequirementTO.setPlannedDateForFRS(data.getPlannedDateForFRS());
								productRequirementTO.setActualDateForFRS(data.getActualDateForFRS());
								productRequirementTO.setGroupReviewDateForFRS(data.getGroupReviewDateForFRS());
								productRequirementTO.setFrsRemarks(data.getRemarks());
								productRequirementTO.setFrsCheckedInTFS(data.getCheckedInTFS());
								
							}
						}
						query=em.createQuery("select srs from SRSData srs where srs.productRequirementId=?1");
						query.setParameter(1, productRequirementTO.getProductRequirementId());
						List<SRSData> srsDataList=query.getResultList();
						if(!srsDataList.isEmpty())
						{
							for (SRSData data : srsDataList) 
							{
								productRequirementTO.setSrsId(data.getSrsId());
								productRequirementTO.setSRSDocumentName(data.getSRSDocumentName());
								productRequirementTO.setSrsOwnerEmailId(data.getSrsOwnerEmailId());
								productRequirementTO.setSrsStatus(data.getSrsStatus());
								productRequirementTO.setPlannedDateForSRS(data.getPlannedDateForSRS());
								productRequirementTO.setActualDateForSRS(data.getActualDateForSRS());
								productRequirementTO.setGroupReviewDateForSRS(data.getGroupReviewDateForSRS());
								productRequirementTO.setSrsRemarks(data.getRemarks());
								productRequirementTO.setSrsCheckedInTFS(data.getCheckedInTFS());
								productRequirementTO.setSrsRAAnchor(data.getRAAnchor());
							}
						}
						query=em.createQuery("select im from ImpactData im where im.productRequirementId=?1");
						query.setParameter(1, productRequirementTO.getProductRequirementId());
						List<ImpactData> impactDataList=query.getResultList();
						if(!impactDataList.isEmpty())
						{
							for (ImpactData impactData : impactDataList) 
							{
								productRequirementTO.setImpactId(impactData.getImpactId());
								productRequirementTO.setArchieImpact(impactData.getArchieImpact());
								productRequirementTO.setCoreImpact(impactData.getCoreImpact());
								productRequirementTO.setCRMImpact(impactData.getCRMImpact());
								productRequirementTO.setFASImpact(impactData.getFASImpact());
								productRequirementTO.setOdsImpact(impactData.getOdsImpact());
								productRequirementTO.setFiImpact(impactData.getFiImpact());
								productRequirementTO.setEBankingImpact(impactData.getEBankingImpact());
								productRequirementTO.setDirectBankingImpact(impactData.getDirectBankingImpact());
								productRequirementTO.setOriginationImpact(impactData.getOriginationImpact());
								productRequirementTO.setFDMImpact(impactData.getFDMImpact());
								productRequirementTO.setTreasuryImpact(impactData.getTreasuryImpact());
								productRequirementTO.setWMSImpact(impactData.getWMSImpact());
								productRequirementTO.setFinanzToolImpact(impactData.getFinanzToolImpact());
								productRequirementTO.setMultichannelImpact(impactData.getMultichannelImpact());
								productRequirementTO.setSSOImpact(impactData.getSSOImpact());
								productRequirementTO.setAll24By7Impact(impactData.getAll24By7Impact());
								productRequirementTO.setSvsImpact(impactData.getSvsImpact());
								productRequirementTO.setFabImpact(impactData.getFabImpact());
								productRequirementTO.setCsisImpact(impactData.getCsisImpact());
								productRequirementTO.setLOSImpact(impactData.getLOSImpact());
								productRequirementTO.setFCAImpact(impactData.getFCAImpact());
								productRequirementTO.setThirdPartyImpact(impactData.getThirdPartyImpact());
								
							}
						}
						
						toProductReq.add(productRequirementTO);
						
					}
			}
			else
			{
				throw new NoProductReqAvailableException();
			}
			
			et.commit();
				
		}
		catch(NoProductReqAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
		return toProductReq;
	}
	
	//Product Requirement Assigned to Employee
	public List<ProductRequirementTO> getAllProductRequirementAssignedToEmployee(String employeeId) throws Exception
	{
		EntityManager em=null;
		List<ProductRequirementTO> toProductReq = new ArrayList<ProductRequirementTO>() ;
		
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();
			
			Query query= em.createQuery("select pr from ProductRequirement pr,ModuleAnchor ma,MasterRequirement mr where pr.masterRequirementId=mr.masterRequirementId and mr.moduleId=ma.moduleId and ma.anchorEmployeeId=?1 ");
			query.setParameter(1, employeeId);		
			List<ProductRequirement> rs1 = query.getResultList();
			
			if(!rs1.isEmpty())
			{
				for(ProductRequirement productReq : rs1)
					{
						ProductRequirementTO productRequirementTO = new ProductRequirementTO();
						
						productRequirementTO.setProductRequirementId(productReq.getProductRequirementId());
						productRequirementTO.setProductRequirementTitle(productReq.getProductRequirementTitle());
						productRequirementTO.setProductRequirementDescription(productReq.getProductRequirementDescription());
						productRequirementTO.setProductVersion(productReq.getProductVersion());
						productRequirementTO.setApprovedStatus(productReq.getApprovedStatus());
						productRequirementTO.setComments(productReq.getComments());
						productRequirementTO.setFrsClosureDate(productReq.getFrsClosureDate());
						productRequirementTO.setFrsName(productReq.getFrsName());
						productRequirementTO.setSrsClosureDate(productReq.getSrsClosureDate());
						productRequirementTO.setSrsName(productReq.getSrsName());
						
						productRequirementTO.setGroupId(productReq.getGroupId());
						GroupInfoService groupService = new GroupInfoService();
						productRequirementTO.setGroupName(groupService.getGroupDetailsById(productReq.getGroupId()).getGroupName());
												
						productRequirementTO.setMasterRequirementId(productReq.getMasterRequirementId());
						MasterRequirementService masterReqService = new MasterRequirementService();
						MasterRequirementTO masterRequirementTO=masterReqService.getMasterReqDetailsById(productReq.getMasterRequirementId());
						productRequirementTO.setMasterRequirementTitle(masterRequirementTO.getMasterRequirementTitle());
						//changes done by sanket mehta
						productRequirementTO.setLocationName(masterRequirementTO.getLocationName());
						//changes completed
						
						ModuleAnchorTO moduleAnchorTO=new ModuleAnchorService().getModuleById(masterRequirementTO.getModuleId());
						productRequirementTO.setModuleName(moduleAnchorTO.getModuleName());	
						toProductReq.add(productRequirementTO);
						
					}
			}
			 
			
			et.commit();
				
		}
		 
		catch(Exception e)
		{
			throw e;
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
		return toProductReq;
	}
	
	
	// View and update--
	
	
	public List<ProductRequirementTO> getProductRequirements(String... searchObjects)throws Exception
	{

		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();	
			List<ProductRequirementTO> productReqTOList=new ArrayList<ProductRequirementTO>();
			
			String queryString="select pr,sr,fr,im,gi from ProductRequirement pr,FRSData fr, SRSData sr,ImpactData im, MasterRequirement mr, GroupInfo gi where " +
					"pr.masterRequirementId=mr.masterRequirementId " +
					"and sr.productRequirementId=pr.productRequirementId " +
					"and fr.productRequirementId=pr.productRequirementId " +
					"and mr.groupId=gi.groupId " +
					"and im.productRequirementId=pr.productRequirementId";
			
			for(int i=0,j=1;i<searchObjects.length;i++)
			{
				if(i%2==0)
				{
					if(searchObjects[i].equals("assignedTo"))
					{
						queryString+=" and (sr.srsOwnerEmailId=?"+j+" or fr.frsOwnerEmailId=?"+j+")";
					}
					else if(searchObjects[i].equals("productVersion"))
					{
						queryString+=" and pr.";
						queryString+=searchObjects[i]+"=?"+j;
					}
					
				    //changes done by sanket mehta
					else if(searchObjects[i].equals("locationId"))
					{
						queryString+=" and gi.";
						queryString+=searchObjects[i]+"=?"+j;
					}
					else if(searchObjects[i].equals("initiatingGroupId"))
					{
						queryString+=" and gi.";
						queryString+=searchObjects[i]+"=?"+j;
					}
					//changes complete		
					else
					{
						queryString+=" and mr.";
						queryString+=searchObjects[i]+"=?"+j;
					}
					j++;
					System.out.println("search objects length"+searchObjects.length);
					
				}
			}
			System.out.println(" ****** QueryString *****"+ queryString);
			Query query= em.createQuery(queryString);
			System.out.println(" ******** Query *******"+query);
			for(int i=0,j=1;i<searchObjects.length;i++)
			{
				if(i%2!=0)
				{
					query.setParameter(j, searchObjects[i]);
					j++;
				}
				System.out.println("object length: "+searchObjects.length);
			}
			
			//Query query= em.createQuery("select pr from ProductRequirement pr, MasterRequirement mr where pr.masterRequirementId=mr.masterRequirementId and mr.groupId=?1 and mr.moduleId=?2 and pr.productVersion=?3");
			 
			//List<ProductRequirement> rs1 = query.getResultList();
			
			//if(!rs1.isEmpty())
			//{
				
				//for(ProductRequirement productReq : rs1)
					//{
			List objList=query.getResultList();
		
			
			for (int i = 0; i < objList.size(); i++) {
				
				Object objArray[]=(Object[])objList.get(i);
				ProductRequirement productReq=(ProductRequirement)objArray[0];
				SRSData srsData=(SRSData)objArray[1];
				FRSData frsData=(FRSData)objArray[2];
				ImpactData impactData=(ImpactData)objArray[3];
				
				ProductRequirementTO productRequirementTO = new ProductRequirementTO();

				productRequirementTO.setProductRequirementId(productReq.getProductRequirementId());
				productRequirementTO.setProductRequirementTitle(productReq.getProductRequirementTitle());
				productRequirementTO.setProductRequirementDescription(productReq.getProductRequirementDescription());
				productRequirementTO.setProductVersion(productReq.getProductVersion());
				productRequirementTO.setApprovedStatus(productReq.getApprovedStatus());
				productRequirementTO.setComments(productReq.getComments());
				productRequirementTO.setFrsClosureDate(productReq.getFrsClosureDate());
				productRequirementTO.setFrsName(productReq.getFrsName());
				
				productRequirementTO.setFrsOwnerEmailId(productReq.getFrsName());
				//System.out.println("FRS name: "+productReq.getFrsName());
				productRequirementTO.setSrsClosureDate(productReq.getSrsClosureDate());
				productRequirementTO.setSrsName(productReq.getSrsName());
				productRequirementTO.setLocalization(productReq.getLocalization());
				productRequirementTO.setFunctionalEffort(productReq.getFunctionalEffort());
				productRequirementTO.setDevelopmentEffort(productReq.getDevelopmentEffort());
				productRequirementTO.setDgOwner(productReq.getDgOwner());

				productRequirementTO.setGroupId(productReq.getGroupId());
				GroupInfoService groupService = new GroupInfoService();
				productRequirementTO.setGroupName(groupService.getGroupDetailsById(productReq.getGroupId()).getGroupName());
                productRequirementTO.setSource(groupService.getGroupDetailsById(productReq.getGroupId()).getSourceName());
                productRequirementTO.setCustomer(groupService.getGroupDetailsById(productReq.getGroupId()).getCustomer_prospect());
				productRequirementTO.setMasterRequirementId(productReq.getMasterRequirementId());
				MasterRequirementService masterReqService = new MasterRequirementService();
				MasterRequirementTO masterRequirementTO=masterReqService.getMasterReqDetailsById(productReq.getMasterRequirementId());
				productRequirementTO.setMasterRequirementTitle(masterRequirementTO.getMasterRequirementTitle());
				
				productRequirementTO.setMasterRequirementDescription(masterRequirementTO.getDescription());
				//changes done by sanket mehta
				
				productRequirementTO.setLocationName(masterRequirementTO.getLocationName());
				//productRequirementTO.setSubModuleName(masterRequirementTO.getSubModuleName());
				productRequirementTO.setVerticalName(masterRequirementTO.getVerticalName());
				productRequirementTO.setSolutionName(masterRequirementTO.getSolutionName());
				//changes completed

				ModuleAnchorTO moduleAnchorTO=new ModuleAnchorService().getModuleById(masterRequirementTO.getModuleId());
				
				productRequirementTO.setModuleName(moduleAnchorTO.getModuleName());	
				productRequirementTO.setModuleAnchor(moduleAnchorTO.getAnchorName());
				if(masterRequirementTO.getStatus().equalsIgnoreCase("Abandoned"))
				productRequirementTO.setDroppedFromScope(masterRequirementTO.getStatus());
				productRequirementTO.setFrsId(frsData.getFrsId());
				
				productRequirementTO.setFRSDocumentName(frsData.getFRSDocumentName());
				productRequirementTO.setProjectCode(frsData.getProjectCode());
				productRequirementTO.setFrsOwnerEmailId(frsData.getFrsOwnerEmailId());
				//System.out.println("FRS email id: "+frsData.getFrsOwnerEmailId());
				productRequirementTO.setFrsStatus(frsData.getFrsStatus());
				productRequirementTO.setPlannedDateForFRS(frsData.getPlannedDateForFRS());
				productRequirementTO.setActualDateForFRS(frsData.getActualDateForFRS());
				productRequirementTO.setGroupReviewDateForFRS(frsData.getGroupReviewDateForFRS());
				productRequirementTO.setFrsRemarks(frsData.getRemarks());
				productRequirementTO.setFrsCheckedInTFS(frsData.getCheckedInTFS());				
				productRequirementTO.setFrsName(productReq.getFrsName());
				
				
				productRequirementTO.setSrsId(srsData.getSrsId());
				productRequirementTO.setSRSDocumentName(srsData.getSRSDocumentName());
				productRequirementTO.setSrsOwnerEmailId(srsData.getSrsOwnerEmailId());
				productRequirementTO.setSrsStatus(srsData.getSrsStatus());
				productRequirementTO.setPlannedDateForSRS(srsData.getPlannedDateForSRS());
				productRequirementTO.setActualDateForSRS(srsData.getActualDateForSRS());
				productRequirementTO.setGroupReviewDateForSRS(srsData.getGroupReviewDateForSRS());
				productRequirementTO.setSrsRemarks(srsData.getRemarks());
				productRequirementTO.setSrsCheckedInTFS(srsData.getCheckedInTFS());
				productRequirementTO.setSrsRAAnchor(srsData.getRAAnchor());
				
				productRequirementTO.setImpactId(impactData.getImpactId());
				productRequirementTO.setArchieImpact(impactData.getArchieImpact());
				productRequirementTO.setCoreImpact(impactData.getCoreImpact());
				productRequirementTO.setCRMImpact(impactData.getCRMImpact());
				productRequirementTO.setFASImpact(impactData.getFASImpact());
				productRequirementTO.setOdsImpact(impactData.getOdsImpact());
				productRequirementTO.setFiImpact(impactData.getFiImpact());
				productRequirementTO.setEBankingImpact(impactData.getEBankingImpact());
				productRequirementTO.setDirectBankingImpact(impactData.getDirectBankingImpact());
				productRequirementTO.setOriginationImpact(impactData.getOriginationImpact());
				productRequirementTO.setFDMImpact(impactData.getFDMImpact());
				productRequirementTO.setTreasuryImpact(impactData.getTreasuryImpact());
				productRequirementTO.setWMSImpact(impactData.getWMSImpact());
				productRequirementTO.setFinanzToolImpact(impactData.getFinanzToolImpact());
				productRequirementTO.setMultichannelImpact(impactData.getMultichannelImpact());
				productRequirementTO.setSSOImpact(impactData.getSSOImpact());
				productRequirementTO.setAll24By7Impact(impactData.getAll24By7Impact());
				productRequirementTO.setSvsImpact(impactData.getSvsImpact());
				productRequirementTO.setFabImpact(impactData.getFabImpact());
				productRequirementTO.setCsisImpact(impactData.getCsisImpact());
				productRequirementTO.setLOSImpact(impactData.getLOSImpact());
				productRequirementTO.setFCAImpact(impactData.getFCAImpact());
				productRequirementTO.setThirdPartyImpact(impactData.getThirdPartyImpact());
				
				productReqTOList.add(productRequirementTO);

			}

			 return productReqTOList;
			
		}
		catch (Exception e) {
			throw e;
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
	}
	
	// new function added for email validation
	
	public boolean validateEmailId(String email){
		boolean result = false;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpSession session = (HttpSession)externalContext.getSession(true);
		String ownerEmpId=(String)session.getAttribute("EmployeeId");
		System.out.println("owner id "+ownerEmpId);
		  Query query1 = em.createQuery( " select l.emailId from  Login l where l.emailId=?1");
	        query1.setParameter(1,email);
	        String emailId = null;
	        
	        try{
	         emailId = (String) query1.getSingleResult();}
	        catch (Exception e) {
	        	 result =false;
			}
	        
	        
	        if(emailId!=null && !emailId.isEmpty())
	        	result=true;
	        else result =false;
	        
	        return result;
	}
	
	
	
	public ProductRequirementTO saveNewProductRequirement(ProductRequirementTO productRequirementTO)throws Exception
	{
		try
		{
			Integer pid=99;
			String productReqId;
			//String empId = null;
			em=emf.createEntityManager();
			em.getTransaction().begin();
	
			if(productRequirementTO.getDgOwner()!=null && !productRequirementTO.getDgOwner().isEmpty() && !validateEmailId(productRequirementTO.getDgOwner())){

				throw new UserDoesNotExistException();
		    }
			if(productRequirementTO.getFrsOwnerEmailId()!=null && !productRequirementTO.getFrsOwnerEmailId().isEmpty() && !validateEmailId(productRequirementTO.getFrsOwnerEmailId())){

					throw new UserDoesNotExistException();
			}			
			if(productRequirementTO.getSrsOwnerEmailId()!=null && !productRequirementTO.getSrsOwnerEmailId().isEmpty() && !validateEmailId(productRequirementTO.getSrsOwnerEmailId())){

				throw new UserDoesNotExistException();
		    }
			if(productRequirementTO.getSrsRAAnchor()!=null && !productRequirementTO.getSrsRAAnchor().isEmpty() && !validateEmailId(productRequirementTO.getSrsRAAnchor())){

				throw new UserDoesNotExistException();
		    }
			
			Query query=em.createQuery("select max(p.productRequirementId) from ProductRequirement p");
			Query query1=em.createQuery("select m.ownerEmployeeId from MasterRequirement m where m.masterRequirementId=?1");
			query1.setParameter(1, productRequirementTO.getMasterRequirementId());
			String ownerEmployeeId=(String)query1.getSingleResult();
			
			Query query3=em.createQuery("select l.emailId from Login l where l.empId=?1");
			query3.setParameter(1, ownerEmployeeId);
			String ownerEmailId=(String)query3.getSingleResult();
			//Query query=em.createQuery("select max(p.productRequirementId) from ProductRequirement p");
			
			String productId=(String)query.getSingleResult();
			if(productId!=null)
			{
				pid=Integer.parseInt(productId.substring(2,productId.length()));
			}
			productReqId="PR"+String.valueOf(++pid);

			ProductRequirement productRequirement=new ProductRequirement();
			productRequirementTO.setProductRequirementId(productReqId);
			
			productRequirement.setProductRequirementId(productReqId);
			productRequirement.setMasterRequirementId(productRequirementTO.getMasterRequirementId());
			productRequirement.setProductRequirementTitle(productRequirementTO.getProductRequirementTitle());
			productRequirement.setGroupId(productRequirementTO.getGroupId());
			productRequirement.setProductVersion(productRequirementTO.getProductVersion());
			productRequirement.setProductRequirementDescription(productRequirementTO.getProductRequirementDescription());	
			productRequirement.setOwnerEmployeeId(ownerEmailId);
			/*productRequirement.setFrsName(productRequirementTO.getFrsName());
			productRequirement.setFrsClosureDate(productRequirementTO.getFrsClosureDate());
			productRequirement.setSrsName(productRequirementTO.getSrsName());
			productRequirement.setSrsClosureDate(productRequirementTO.getSrsClosureDate());*/
			productRequirement.setLocalization(productRequirementTO.getLocalization());
			//System.out.println("localization name: "+productRequirementTO.getLocalizationName());
			productRequirement.setFunctionalEffort(productRequirementTO.getFunctionalEffort());
			productRequirement.setDevelopmentEffort(productRequirementTO.getDevelopmentEffort());
			productRequirement.setDgOwner(productRequirementTO.getDgOwner());
			System.out.println("DG Owner: "+productRequirementTO.getDgOwner());
			productRequirement.setComments(productRequirementTO.getComments());			
			productRequirement.setApprovedStatus(productRequirementTO.getApprovedStatus());
			productRequirement.setRemark(productRequirementTO.getRemark());
			
			em.persist(productRequirement);
			
			query=em.createQuery("select max(frs.frsId) from FRSData frs");
			int id=99;
			String frsId=(String)query.getSingleResult();
			 
			if(frsId!=null)
			{
				id=Integer.parseInt(frsId.substring(3,frsId.length()));
			}
			frsId="FRS"+String.valueOf(++id);
			
			FRSData frsData=new FRSData();
			frsData.setFrsId(frsId);
			frsData.setProductRequirementId(productReqId);
			frsData.setFRSDocumentName(productRequirementTO.getFRSDocumentName());
			frsData.setProjectCode(productRequirementTO.getProjectCode());
			
			/*if ((productRequirementTO.getFrsOwnerEmailId()+"@infosys.com"!= null)) {
				Query query2 = em.createQuery("select l.empId from Login l where l.emailId=?1");
				System.out.println("Query2 " + query2);
				query2.setParameter(1, empId);
				try {

					empId = (String) query2.getSingleResult();

					System.out.println("FRS Owner Id: " + empId);
					frsData.setFrsOwnerEmailId(empId);
					// empId=(String) query2.getSingleResult();
				} catch (Exception e) {
					throw new UserDoesNotExistException();
				}
			}*/
			
			frsData.setFrsOwnerEmailId(productRequirementTO.getFrsOwnerEmailId());
			System.out.println("FRS Owner: "+productRequirementTO.getFrsOwnerEmailId());
			frsData.setFrsStatus(productRequirementTO.getFrsStatus());
			frsData.setPlannedDateForFRS(productRequirementTO.getPlannedDateForFRS());
			frsData.setActualDateForFRS(productRequirementTO.getActualDateForFRS());
			frsData.setGroupReviewDateForFRS(productRequirementTO.getGroupReviewDateForFRS());
			frsData.setRemarks(productRequirementTO.getFrsRemarks());
			frsData.setCheckedInTFS(productRequirementTO.getFrsCheckedInTFS());
			
			em.persist(frsData);
			
			query=em.createQuery("select max(srs.srsId) from SRSData srs");
			id=99;
			String srsId=(String)query.getSingleResult();
			 
			if(srsId!=null)
			{
				id=Integer.parseInt(srsId.substring(3,srsId.length()));
			}
			srsId="SRS"+String.valueOf(++id);
			SRSData srsData=new SRSData();
			
			
			srsData.setSrsId(srsId);
			srsData.setProductRequirementId(productReqId);
			srsData.setSRSDocumentName(productRequirementTO.getSRSDocumentName());
			srsData.setSrsOwnerEmailId(productRequirementTO.getSrsOwnerEmailId());
			System.out.println("SRS Owner: "+productRequirementTO.getSrsOwnerEmailId());
			srsData.setSrsStatus(productRequirementTO.getSrsStatus());
			srsData.setPlannedDateForSRS(productRequirementTO.getPlannedDateForSRS());
			srsData.setActualDateForSRS(productRequirementTO.getActualDateForSRS());
			srsData.setGroupReviewDateForSRS(productRequirementTO.getGroupReviewDateForSRS());
			srsData.setRemarks(productRequirementTO.getSrsRemarks());
			srsData.setCheckedInTFS(productRequirementTO.getSrsCheckedInTFS());
			srsData.setRAAnchor(productRequirementTO.getSrsRAAnchor());
			
			em.persist(srsData);
			
			query=em.createQuery("select max(im.impactId) from ImpactData im");
			id=99;
			String impactId=(String)query.getSingleResult();
			if(impactId!=null)
			{
				id=Integer.parseInt(impactId.substring(2,impactId.length()));
			}
			impactId="IM"+String.valueOf(++id);
			ImpactData impactData=new ImpactData();
			
			impactData.setImpactId(impactId);
			impactData.setProductRequirementId(productReqId);
			impactData.setArchieImpact(productRequirementTO.getArchieImpact());
			impactData.setCoreImpact(productRequirementTO.getCoreImpact());
			impactData.setCRMImpact(productRequirementTO.getCRMImpact());
			impactData.setFASImpact(productRequirementTO.getFASImpact());
			impactData.setOdsImpact(productRequirementTO.getOdsImpact());
			impactData.setFiImpact(productRequirementTO.getFiImpact());
			impactData.setEBankingImpact(productRequirementTO.getEBankingImpact());
			impactData.setDirectBankingImpact(productRequirementTO.getDirectBankingImpact());
			impactData.setOriginationImpact(productRequirementTO.getOriginationImpact());
			impactData.setFDMImpact(productRequirementTO.getFDMImpact());
			impactData.setTreasuryImpact(productRequirementTO.getTreasuryImpact());
			impactData.setWMSImpact(productRequirementTO.getWMSImpact());
			impactData.setFinanzToolImpact(productRequirementTO.getFinanzToolImpact());
			impactData.setMultichannelImpact(productRequirementTO.getMultichannelImpact());
			impactData.setSSOImpact(productRequirementTO.getSSOImpact());
			impactData.setAll24By7Impact(productRequirementTO.getAll24By7Impact());
			impactData.setSvsImpact(productRequirementTO.getSvsImpact());
			impactData.setFabImpact(productRequirementTO.getFabImpact());
			impactData.setCsisImpact(productRequirementTO.getCsisImpact());
			impactData.setLOSImpact(productRequirementTO.getLOSImpact());
			impactData.setFCAImpact(productRequirementTO.getFCAImpact());
			impactData.setThirdPartyImpact(productRequirementTO.getThirdPartyImpact());
			
			em.persist(impactData);
			
			em.getTransaction().commit();
			
			productRequirementTO.setSrsId(srsId);
			productRequirementTO.setFrsId(frsId);
			productRequirementTO.setImpactId(impactId);
			return productRequirementTO;
		
		}
		catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
	}
	
	
	public int checkMRid (String mrID){
		Integer checkstatus=0;
		Long checkstatusresult ;
		String masterReq = mrID;
		 EntityManager em=null;
		   EntityTransaction et=null;
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
		   em=emf.createEntityManager();
		   et=em.getTransaction();
		   et.begin();
		   Query query=em.createQuery("select count(m) from MasterRequirement m where m.masterRequirementId=?1 and m.status=?2");
		   query.setParameter(1, masterReq);
		   query.setParameter(2, "Accepted");
		 
				   checkstatusresult=(Long) query.getSingleResult();
				   checkstatus=checkstatusresult.intValue();
		   System.out.println("check service Mrid"+checkstatus);
		return checkstatus;
	}
	
	//product req file uploading
	
	@SuppressWarnings("unchecked")
	public void uploadProductReqList(List<ProductRequirementTO> productReqListTo) throws Exception
	   {
		   EntityManager em=null;
		   EntityTransaction et=null;
		   try 
		   {
			   EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			   em=emf.createEntityManager();
			   et=em.getTransaction();
			   et.begin();
			   Integer pid=100;
			   String productId;
			   String impactId;
			   Integer impactid=100;
			   
			  // String impactId;
			   
//			   Query query=em.createQuery("select max(m.masterRequirementId) from MasterRequirement m");
			  Query query=em.createQuery("select p.productRequirementId from ProductRequirement p");
			   
			  Query impactQuery=em.createQuery("select i.impactId from ImpactData i");

			  //FRS details	
			  String frsId;
			  Integer frsid=100;
			  Query frsDetails = em.createQuery("select f.frsId from FRSData f");
			  List<String> frsIdList =  frsDetails.getResultList();
	           List<Integer> frsids;
	           Integer frstemp = 100;
	           if(!frsIdList.isEmpty())
	           {
	                  
	                  for(String Id : frsIdList)
	                  {
	                	  //System.out.println("@@@"+Id.substring(3, Id.length()));
	                	  //System.out.println("@@@"+Id.substring(1, Id.length()));
	                	  //System.out.println("@@@"+Id.substring(0, Id.length()));
	                	  frstemp = Integer.parseInt(Id.substring(3, Id.length()));
	                	  frsid = frstemp > frsid ? frstemp : frsid; 
	                  }
	                  
	           }	           
	           frsId="FRS"+String.valueOf(frsid);			  
	           FRSData entity2 =null;	
	           //FRS Details ends
	           
	         //SRS details	
				  String srsId;
				  Integer srsid=100;
				  Query srsDetails = em.createQuery("select s.srsId from SRSData s");
				  List<String> srsIdList =  srsDetails.getResultList();
		           List<Integer> srsids;
		           Integer srstemp = 100;
		           if(!srsIdList.isEmpty())
		           {
		                  
		                  for(String Id : srsIdList)
		                  {
		                	  srstemp = Integer.parseInt(Id.substring(3, Id.length()));
		                	  srsid = srstemp > srsid ? srstemp : srsid; 
		                  }
		                  
		           }	           
		           srsId="SRS"+String.valueOf(srsid);			  
		           SRSData entity3 =null;	
		           //SRS Details ends
	           
			  
	           List<String> IMIdList =  impactQuery.getResultList();
	           List<Integer> Imids;
	           Integer imtemp = 100;
	           if(!IMIdList.isEmpty())
	           {
	                  
	                  for(String Id : IMIdList)
	                  {
	                        imtemp = Integer.parseInt(Id.substring(2, Id.length()));
	                        impactid = imtemp > impactid ? imtemp : impactid; 
	                  }
	                  
	           }
	           
	           impactId="IM"+String.valueOf(impactid);
			   
	           List<String> PRIdList =  query.getResultList();
	           List<Integer> Ids;
	           Integer temp = 100;
	           if(!PRIdList.isEmpty())
	           {
	                  
	                  for(String Id : PRIdList)
	                  {
	                        temp = Integer.parseInt(Id.substring(2, Id.length()));
	                        pid = temp > pid ? temp : pid; 
	                  }
	                  
	           }
	        //   pid++;
	           productId="PR"+String.valueOf(pid);

//			   String masterReqId=(String)query.getSingleResult();
//			   if(masterReqId!=null)
//			   {
//				   mid=Integer.parseInt(masterReqId.substring(2, masterReqId.length()));
//				   			    
//			   }
	          
			   ImpactData entity1 =null;
			   MasterRequirement entity_accepted = new MasterRequirement();
			   
			   ProductRequirement entity=null;
			   
			   for(int i=1;i<productReqListTo.size();i++ )
			   {
				    productId="PR"+String.valueOf(++pid);
				   
				   entity = new ProductRequirement();
				   
				   ProductRequirementTO toObj = productReqListTo.get(i);
                   
				   entity.setMasterRequirementId(toObj.getMasterRequirementId());
				   //newquery1.
				   String groupId=null;
				   if((toObj.getMasterRequirementId()!=null)){
				   Query query1= em.createQuery("select mr.groupId from MasterRequirement mr where mr.masterRequirementId=?1");
				   query1.setParameter(1, toObj.getMasterRequirementId());
				   groupId=(String) query1.getSingleResult();
				   //System.out.println("query1 "+query1);
				   //System.out.println("groupId "+groupId);
				   //System.out.println("toObj.getMasterRequirementId()"+toObj.getMasterRequirementId());
				
				   //System.out.println("Group Id "+toObj.getGroupId());
				   
				   }
				   //
				   
				   ///
				   
				   entity.setProductRequirementId(productId);
				   entity.setProductRequirementTitle(toObj.getProductRequirementTitle());
				   entity.setProductRequirementDescription(toObj.getProductRequirementDescription());				   
				   entity.setProductVersion(toObj.getProductVersion());
				   entity.setGroupId(groupId);
				   entity.setLocalization(toObj.getLocalization());
				   entity.setFunctionalEffort(toObj.getFunctionalEffort());
				   entity.setDevelopmentEffort(toObj.getDevelopmentEffort());
				   entity.setDgOwner(toObj.getDgOwner());
				   entity.setComments(toObj.getComments());
				   entity.setFrsName(toObj.getFrsName());
				   entity.setFrsClosureDate(toObj.getPlannedDateForFRS());
				   entity.setSrsName(toObj.getSrsName());
				   entity.setSrsClosureDate(toObj.getPlannedDateForSRS());
				   
                   impactId="IM"+String.valueOf(++impactid);
				   
				   entity1 = new ImpactData();
				  // ImpactDetailsTO toObj = impactDetailsTO.get(i);
                   
				   entity1.setProductRequirementId(productId);
				   entity1.setImpactId(impactId);
				   entity1.setArchieImpact(toObj.getArchieImpact());
				   entity1.setCoreImpact(toObj.getCoreImpact());				   
				   entity1.setCRMImpact(toObj.getCRMImpact());
				   entity1.setFASImpact(toObj.getFASImpact());
				   entity1.setOdsImpact(toObj.getOdsImpact());
				   entity1.setFiImpact(toObj.getFiImpact());
				   entity1.setEBankingImpact(toObj.getEBankingImpact());
				   entity1.setDirectBankingImpact(toObj.getDirectBankingImpact());
				   entity1.setOriginationImpact(toObj.getOriginationImpact());
				   entity1.setFDMImpact(toObj.getFDMImpact());
				   entity1.setTreasuryImpact(toObj.getTreasuryImpact());
				   entity1.setWMSImpact(toObj.getWMSImpact());
				   entity1.setFinanzToolImpact(toObj.getFinanzToolImpact());
				   entity1.setMultichannelImpact(toObj.getMultichannelImpact());
				   entity1.setSSOImpact(toObj.getSSOImpact());
				   entity1.setAll24By7Impact(toObj.getAll24By7Impact());
				   entity1.setSvsImpact(toObj.getSvsImpact());
				   entity1.setFabImpact(toObj.getFabImpact());
				   entity1.setCsisImpact(toObj.getCsisImpact());
				   entity1.setLOSImpact(toObj.getLOSImpact());
				   entity1.setFCAImpact(toObj.getFCAImpact());
				   entity1.setThirdPartyImpact(toObj.getThirdPartyImpact());
				//   entity_accepted.setStatus("Accepted");
				   
				   //FRS Details
				   frsId="FRS"+String.valueOf(++frsid);
				   entity2 = new FRSData();
				   entity2.setProductRequirementId(productId);
				   entity2.setFrsId(frsId);
				   entity2.setFrsOwnerEmailId(toObj.getFrsOwnerEmailId());
				   
				   //SRS Details
				   srsId="SRS"+String.valueOf(++srsid);
				   entity3 = new SRSData();
				   entity3.setProductRequirementId(productId);
				   entity3.setSrsId(srsId);
				   entity3.setSrsOwnerEmailId(toObj.getSrsOwnerEmailId());
				  
				  
				   em.persist(entity1);
				 //em.persist(entity_accepted);
				   em.persist(entity);
				   em.persist(entity2);
				   em.persist(entity3);
				   Query updateQuery = em.createQuery("UPDATE MasterRequirement mr SET mr.status=?1 where mr.masterRequirementId=?2");
				   updateQuery.setParameter(1, "Accepted");
				   updateQuery.setParameter(2, toObj.getMasterRequirementId()); 
				   updateQuery.executeUpdate();
				   }
			   
			   //Impact Details
			   /*   String impactId;
			   Integer impactid=100;
			   ImpactData entity1 =null;*/
			  
			   /*List<ImpactDetailsTO> impactDetailsTO = null;
			   
			   entity1 = new ImpactData();
			   for(int i=1;i<impactDetailsTO.size();i++ )
			   {
				    impactId="IM"+String.valueOf(++impactid);
				   
				   entity1 = new ImpactData();
				   ImpactDetailsTO toObj = impactDetailsTO.get(i);
                   
				   entity1.setProductRequirementId(productId);
				   entity1.setImpactId(impactId);
				   entity1.setArchieImpact(toObj.getArchieImpact());
				   entity1.setCoreImpact(toObj.getCoreImpact());				   
				   entity1.setCRMImpact(toObj.getCrmImpact());
				   entity1.setFASImpact(toObj.getFasImpact());
				   entity1.setOdsImpact(toObj.getOdsImpact());
				   entity1.setFiImpact(toObj.getFiImpact());
				   entity1.setEBankingImpact(toObj.geteBankingImpact());
				   entity1.setDirectBankingImpact(toObj.getDirectBankingImpact());
				   entity1.setOriginationImpact(toObj.getOriginationImpact());
				   entity1.setFDMImpact(toObj.getFdmImpact());
				   entity1.setTreasuryImpact(toObj.getTreasuryImpact());
				   entity1.setWMSImpact(toObj.getWmsImpact());
				   entity1.setFinanzToolImpact(toObj.getFinanzToolImpact());
				   entity1.setMultichannelImpact(toObj.getMultiChannelImpact());
				   entity1.setSSOImpact(toObj.getSsoImpact());
				   entity1.setAll24By7Impact(toObj.getAll24By7Impact());
				   entity1.setSvsImpact(toObj.getSvsImpact());
				   entity1.setFabImpact(toObj.getFabImpact());
				   entity1.setCsisImpact(toObj.getCsisImpact());
				   entity1.setLOSImpact(toObj.getLosImpact());
				   entity1.setFCAImpact(toObj.getFcaImpact());
				   entity1.setThirdPartyImpact(toObj.getThirdPartyImpact());
				   
				   em.persist(entity1);
				   }*/
			   //Impact Details ends
			   et.commit(); 
		   }

		   catch(Exception e)
		   {
			   if(et!=null)
			   {
				   
				   et.rollback();
			   }
			   e.printStackTrace();
			   throw e;
		   }
		   finally
		   {
			   if(em!=null) 
			   {
				   em.close();
			   }
		   }
	   }
	
	public GroupInfoTO getGroupIdByName(String groupName)throws  NoGroupsAvailableException,Exception
	   {
	        EntityManager em=null;
	         GroupInfoTO toObj = new GroupInfoTO();
	         try 
	         {
	               EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	               em=emf.createEntityManager();
	               EntityTransaction et= em.getTransaction();

	               //et.begin();
	               Query query= em.createQuery("select gi from GroupInfo gi where gi.groupName= ?1");
	               groupName = groupName.trim();
	               System.out.println("group name is: " + groupName);
	               query.setParameter(1,groupName);
	               
	               List<GroupInfo> rs1 = query.getResultList();
//	               GroupInfo rs1 = (GroupInfo)query.getSingleResult();
	               System.out.println("total size of group querylist is: "  + rs1.size());
	            
	               if(!rs1.isEmpty())
	               {
//	            	   System.out.println(" Hello ");
	                     for(GroupInfo groupInfo : rs1)
	                     {
	                           toObj.setGroupId(groupInfo.getGroupId());
	                           toObj.setComment(groupInfo.getComments());
	                           toObj.setCustomer_prospect(groupInfo.getCustomer_prospect());
	                           toObj.setDescription(groupInfo.getDescription());
	                           toObj.setGroupName(groupInfo.getGroupName());
	                           toObj.setInitatingGroupId(groupInfo.getInitiatingGroupId());
	                           toObj.setLocationId(groupInfo.getLocationId());
	                           toObj.setSourceId(groupInfo.getSourceId());
	                           toObj.setSPOC(groupInfo.getSPOC());
	                           
	                     }
	                     return toObj;
	               }
	               else
	               {
	                     throw new NoGroupsAvailableException();
	               }

	         }
	         catch(Exception e)
	         {
	               throw e;
	         }
	         finally 
	         { 
	               if(em!=null) {
	                     em.close();
	               }
	         }
	   }


}
