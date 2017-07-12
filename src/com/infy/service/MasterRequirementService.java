package com.infy.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.io.FilenameUtils;

import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.MasterRequirementAttachmentTO;
import com.infy.TOclasses.MasterRequirementTO;
import com.infy.TOclasses.ModuleAnchorTO;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.TOclasses.SolutionTO;
import com.infy.TOclasses.SubModuleTO;
import com.infy.TOclasses.VerticalTO;
import com.infy.entity.FRSData;
import com.infy.entity.GroupInfo;
import com.infy.entity.Location;
import com.infy.entity.Login;
import com.infy.entity.MasterRequirement;
import com.infy.entity.MasterRequirmentAttachment;
import com.infy.entity.Module;
import com.infy.entity.ModuleAnchor;
import com.infy.entity.ProductRequirement;
import com.infy.entity.SRSData;
import com.infy.entity.Solution;
import com.infy.entity.SubModule;
import com.infy.entity.Vertical;
import com.infy.exceptions.InvalidDateException;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoLocationsAvailableException;
import com.infy.exceptions.NoMasterReqAvailableException;
import com.infy.exceptions.NoModuleAvailableException;
import com.infy.exceptions.NoModulesAvailableForGivenSolutionException;
import com.infy.exceptions.NoSolutionsAvailableException;
import com.infy.exceptions.NoSubModuleAvailableForGivenModuleException;
import com.infy.exceptions.UserDoesNotExistException;
import com.infy.managedBeans.LoginMB;




public class MasterRequirementService 
{
	 

	
	public String addMasterRequirement(MasterRequirementTO masterReqTo, String emailId2) throws Exception
    {
           EntityManager em=null;
           try 
           {
           EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
           em=emf.createEntityManager();
           Integer mid=100;
           MasterRequirement entity = new MasterRequirement();
           String emailId = emailId2;
           String productManager = null;
           Query query=em.createQuery("select m.masterRequirementId from MasterRequirement m");
           Query ModuleOwnerquery=em.createQuery("select m.anchorName from Module m where m.moduleId=?1");
           ModuleOwnerquery.setParameter(1,masterReqTo.getModuleId() );
           
           String moduleOwner = (String) ModuleOwnerquery.getSingleResult();
           String masterReqId;
           List<String> MRIdList =  query.getResultList();
           List<Integer> Ids;
           Integer temp = 100;
           if(!MRIdList.isEmpty())
           {
                  
                  for(String Id : MRIdList)
                  {
                        temp = Integer.parseInt(Id.substring(2, Id.length()));
                        mid = temp > mid ? temp : mid; 
                  }
                  
           }
           
           //System.out.println("max id is: " + mid);
           mid++;
         /* if(masterReqId!=null)
          {
                mid=Integer.parseInt(masterReqId.substring(2, masterReqId.length()));
                mid++;
          }*/
           String masterId="MR"+String.valueOf(mid);                        
              
                  EntityTransaction et= em.getTransaction();
           
                  entity.setMasterRequirementId(masterId);
                  entity.setMasterRequirementTitle(masterReqTo.getMasterRequirementTitle());
                  entity.setExternalReferenceNumber(masterReqTo.getExternalReferenceNumber());
                  entity.setDescription(masterReqTo.getDescription());
                  System.out.println("email Id: "+masterReqTo.getEmpId()==null);
                  System.out.println("email22 Id: "+masterReqTo.getEmailId());
                  LoginMB emailId1 = new LoginMB();
                
                  System.out.println("login  Id: "+  emailId);
                
                  if(masterReqTo.getEmailId()!=null && !masterReqTo.getEmailId().equalsIgnoreCase("0"))
                  entity.setContactPerson(masterReqTo.getEmailId());
                  else
                  entity.setContactPerson(emailId);
                  
                  /*if(masterReqTo.getProductManager()==null)
                  {
                	  System.out.println("inside if block");
                	  Query query2 = em.createQuery("select m.anchorName from Module m where m.moduleId=?1");
                	  try {

  						productManager = (String) query2.getSingleResult();

  						System.out.println("Module Anchor Id: " + productManager);
  						entity.setProductManager(productManager);
  						// empId=(String) query2.getSingleResult();
  					} catch (Exception e) {
  						throw new UserDoesNotExistException();
  					}
                	  		
                  }*/
                  entity.setProductManager(moduleOwner);
                  
                  
                  entity.setGroupId(masterReqTo.getGroupId());
                  entity.setSolutionId(masterReqTo.getSolutionId());
                  entity.setModuleId(masterReqTo.getModuleId());
                  entity.setVerticalId(masterReqTo.getVerticalId());
                  entity.setOwnerEmployeeId(masterReqTo.getOwnerEmployeeId());
                  // Changes made by Bhuvana starts
                  entity.setMRDate(masterReqTo.getMrDate());
                  System.out.println("****** MR Date :"+masterReqTo.getMrDate());
                  entity.setCustomization(masterReqTo.getCustomization());
                  // Changes completed
                  entity.setStatus("Entered");
                                      
                  et.begin();
                  em.persist(entity);
                  et.commit();
                  
                  masterReqTo.setMasterRequirementId(entity.getMasterRequirementId());
                  masterReqTo.setVerticalName(getVerticalNameById(masterReqTo.getVerticalId()));
                  //changes completed
                  masterReqTo.setModuleName(getModuleNameByModuleId(masterReqTo.getModuleId()));
                  masterReqTo.setSolutionName(getSolutionNameById(masterReqTo.getSolutionId()));
                  masterReqTo.setGroupName(getGroupNameById(masterReqTo.getGroupId()));
                  
         
				//for fetching email ids
                  System.out.println("email ssssId: "+emailId1==null);
                //  masterReqTo.setContactPerson(emailId);                  
                  System.out.println("email Id: "+masterReqTo.getEmpId());
                  
                  
                  masterReqTo.setStatus(entity.getStatus());
                  masterReqId= masterReqTo.getMasterRequirementId();
                  return masterReqId;
           }
           
           catch(Exception e)
           {
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

	
	//get All Group names
	@SuppressWarnings("unchecked")
	public Map<String,String> getAllGroupNames()throws NoGroupsAvailableException,Exception
	{
		EntityManager em=null;
		Map<String, String> groupNamesMap = new TreeMap<String, String>();
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();
			
			Query query= em.createQuery("select gi from GroupInfo gi ");
					
			List<GroupInfo> rs1 = query.getResultList();
			
			if(!rs1.isEmpty())
			{
				for(GroupInfo group : rs1)
					{
					groupNamesMap.put(group.getGroupId(), group.getGroupName());
						
					}
			}
			else
			{
				throw new NoGroupsAvailableException();
			}
			
			et.commit();
				
		}
		catch(NoGroupsAvailableException e)
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
		return groupNamesMap;
		
	}
	
	
	//get All solutions
	@SuppressWarnings("unchecked")
	public Map<String,String> getAllSolutions()throws NoSolutionsAvailableException,Exception
	{
		EntityManager em=null;
		Map<String, String> solutionsMap = new TreeMap<String, String>();
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();
			
			Query query= em.createQuery("select sl from Solution sl ");
					
			List<Solution> rs1 = query.getResultList();
			
			if(!rs1.isEmpty())
			{
				for(Solution solution : rs1)
					{
						solutionsMap.put(solution.getSolutionId(), solution.getSolutionName());
					}
			}
			else
			{
				throw new NoSolutionsAvailableException();
			}
			
			et.commit();
				
		}
		catch(NoSolutionsAvailableException e)
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
		return solutionsMap;
		
	}
	
	//get All modules of selected solution
	@SuppressWarnings("unchecked")
	public Map<String,String> getAllModulesBySolution(String solutionId)throws NoModulesAvailableForGivenSolutionException,Exception
	{
		EntityManager em=null;
		Map<String, String> modulesMap = new TreeMap<String, String>();
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();
			
			Query query= em.createQuery("select m from ModuleAnchor m where m.solutionId= ?1 ");
			//System.out.println("***solution Id: "+solutionId);
			query.setParameter(1,solutionId);
					
			List<ModuleAnchor> rs1 = query.getResultList();
			
			if(!rs1.isEmpty())
			{
				for(ModuleAnchor module : rs1)
					{
						modulesMap.put(module.getModuleId(), module.getModuleName());
					}
			}
			else
			{
				throw new NoModulesAvailableForGivenSolutionException();
			}
			
			et.commit();
				
		}
		catch(NoModulesAvailableForGivenSolutionException e)
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
		return modulesMap;
		
	}
	
	//get All modules of selected solution
		@SuppressWarnings("unchecked")
		public Map<String,String> getAllVerticalsBySolution(String solutionId)throws NoModulesAvailableForGivenSolutionException,Exception
		{
			EntityManager em=null;
			Map<String, String> verticalMap = new TreeMap<String, String>();
			try 
			{
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
				em=emf.createEntityManager();
				EntityTransaction et= em.getTransaction();
				et.begin();
				
				Query query= em.createQuery("select v from Vertical v where v.solutionId= ?1 ");
				query.setParameter(1,solutionId);
				List<Vertical> rs1 = query.getResultList();
				
				if(!rs1.isEmpty())
				{
					
					for(Vertical vertical : rs1)
						{
						
						verticalMap.put(vertical.getVerticalId(), vertical.getVerticalName());
						}
				}
				else
				{
					throw new NoModulesAvailableForGivenSolutionException();
				}
				
				et.commit();
					
			}
			catch(NoModulesAvailableForGivenSolutionException e)
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
			
			return verticalMap;
			
		}
	
	//changes done by sanket mehta
	//get All sub modules of selected module
		@SuppressWarnings("unchecked")
		public Map<String,String> getAllSubModulesByModule(String moduleId)throws NoSubModuleAvailableForGivenModuleException,Exception
		{
			EntityManager em=null;
			Map<String, String> subModulesMap = new TreeMap<String, String>();
			try 
			{
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
				em=emf.createEntityManager();
				EntityTransaction et= em.getTransaction();
				et.begin();
				//"select mr from MasterRequirement mr, GroupInfo gi where mr.groupId = gi.groupId and "
				Query query= em.createQuery("select s from SubModule s, ModuleSubModuleMapping ms where s.subModuleId = ms.subModuleId and ms.moduleId= ?1 ");
				query.setParameter(1,moduleId);
						
				List<SubModule> rs1 = query.getResultList();
				
				if(!rs1.isEmpty())
				{
					for(SubModule subMmodule : rs1)
					{
						subModulesMap.put(subMmodule.getSubModuleId(), subMmodule.getSubModuleName());
					}
				}
				else
				{
					throw new NoSubModuleAvailableForGivenModuleException();
				}
				
				et.commit();
					
			}
			catch(NoSubModuleAvailableForGivenModuleException e)
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
			return subModulesMap;
			
		}
		//changes completed
		
	//get All modules 
	@SuppressWarnings("unchecked")
	public Map<String,String> getAllModules()throws NoModulesAvailableForGivenSolutionException,Exception
	{
		EntityManager em=null;
		Map<String, String> modulesMap = new TreeMap<String, String>();
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();
			
			Query query= em.createQuery("select m from ModuleAnchor m ");
							
			List<ModuleAnchor> rs1 = query.getResultList();
			
			if(!rs1.isEmpty())
			{
				for(ModuleAnchor module : rs1)
				{
					modulesMap.put(module.getModuleId(), module.getModuleName());
				}
			}
			else
			{
				throw new NoModulesAvailableForGivenSolutionException();
			}
			
			et.commit();
				
		}
		catch(NoModulesAvailableForGivenSolutionException e)
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
		return modulesMap;
	}
	
	
	//get All Master Requirements By Group
	@SuppressWarnings("unchecked")
	public List<MasterRequirementTO> getAllMasterReqByGroup (String groupId)throws NoMasterReqAvailableException,Exception
	{
		EntityManager em=null;
		List<MasterRequirementTO> masterReqTOList=null;
		 
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			
			
			Query query= em.createQuery("select mr from MasterRequirement mr where mr.groupId= ?1 ");
			query.setParameter(1,groupId);
					
			List<MasterRequirement> rs1 = query.getResultList();
			MasterRequirementTO masterReqTo;
			masterReqTOList=new ArrayList<MasterRequirementTO>();

			if(!rs1.isEmpty())
			{
				for(MasterRequirement masterReq : rs1)
				{
					masterReqTo=new MasterRequirementTO();
					masterReqTo.setMasterRequirementId(masterReq.getMasterRequirementId());
					masterReqTo.setMasterRequirementTitle(masterReq.getMasterRequirementTitle());
					masterReqTo.setExternalReferenceNumber(masterReq.getExternalReferenceNumber());
					masterReqTo.setDescription(masterReq.getDescription());
					masterReqTo.setContactPerson(masterReq.getContactPerson());
					masterReqTo.setGroupId(masterReq.getGroupId());
					masterReqTo.setSolutionId(masterReq.getSolutionId());
					masterReqTo.setModuleId(masterReq.getModuleId());
					masterReqTo.setStatus(masterReq.getStatus());
					masterReqTo.setGroupName(getGroupNameById(masterReq.getGroupId()));
					masterReqTo.setSolutionName(getSolutionNameById(masterReq.getSolutionId()));
					masterReqTo.setModuleName(getModuleNameById(masterReq.getModuleId()));
					masterReqTo.setOwnerEmployeeId(masterReq.getOwnerEmployeeId());
					// Changes made by Bhuvana starts
					masterReqTo.setCustomization(masterReq.getCustomization());
					// Changes Completed
					masterReqTOList.add(masterReqTo);

				}
			}

			else
			{
				throw new NoMasterReqAvailableException();
			}

			
				
		}
		catch(NoMasterReqAvailableException e)
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
		return masterReqTOList;
		
	}
	
	//get All Master Requirements By Module
	@SuppressWarnings("unchecked")
	public List<MasterRequirementTO> getAllMasterReqByModule (String moduleId)throws NoMasterReqAvailableException,Exception
	{
		EntityManager em=null;
		List<MasterRequirementTO> masterReqTOList=null;
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
		
			Query query= em.createQuery("select mr from MasterRequirement mr where mr.moduleId= ?1 ");
			query.setParameter(1,moduleId);
					
			List<MasterRequirement> rs1 = query.getResultList();
			MasterRequirementTO masterReqTo;
			masterReqTOList=new ArrayList<MasterRequirementTO>();
			
			if(!rs1.isEmpty())
			{
				for(MasterRequirement masterReq : rs1)
				{
					masterReqTo=new MasterRequirementTO();
					masterReqTo.setMasterRequirementId(masterReq.getMasterRequirementId());
					masterReqTo.setMasterRequirementTitle(masterReq.getMasterRequirementTitle());
					masterReqTo.setExternalReferenceNumber(masterReq.getExternalReferenceNumber());
					masterReqTo.setDescription(masterReq.getDescription());
					masterReqTo.setContactPerson(masterReq.getContactPerson());
					masterReqTo.setGroupId(masterReq.getGroupId());
					masterReqTo.setSolutionId(masterReq.getSolutionId());
					masterReqTo.setModuleId(masterReq.getModuleId());
					masterReqTo.setStatus(masterReq.getStatus());
					masterReqTo.setGroupName(getGroupNameById(masterReq.getGroupId()));
					masterReqTo.setSolutionName(getSolutionNameById(masterReq.getSolutionId()));
					masterReqTo.setModuleName(getModuleNameById(masterReq.getModuleId()));
					masterReqTo.setOwnerEmployeeId(masterReq.getOwnerEmployeeId());
					// Changes made by Bhuvana starts
					masterReqTo.setCustomization(masterReq.getCustomization());
					// Changes completed
					masterReqTOList.add(masterReqTo);

				}
			}
			else
			{
				throw new NoMasterReqAvailableException();
			}
			
	 
				
		}
		catch(NoMasterReqAvailableException e)
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
		return masterReqTOList;
		
	}
	
	//get All Master Requirements By Status
	@SuppressWarnings("unchecked")
	public List<MasterRequirementTO> getAllMasterReqByStatus (String status)throws NoMasterReqAvailableException,Exception
	{
		EntityManager em=null;
		List<MasterRequirementTO> masterReqTOList=null;
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
		
			Query query= em.createQuery("select mr from MasterRequirement mr where mr.status= ?1 ");
			query.setParameter(1,status);
					
			List<MasterRequirement> rs1 = query.getResultList();
			MasterRequirementTO masterReqTo;
			masterReqTOList=new ArrayList<MasterRequirementTO>();
			
			if(!rs1.isEmpty())
			{
				for(MasterRequirement masterReq : rs1)
				{
					masterReqTo=new MasterRequirementTO();
					masterReqTo.setMasterRequirementId(masterReq.getMasterRequirementId());
					masterReqTo.setMasterRequirementTitle(masterReq.getMasterRequirementTitle());
					masterReqTo.setExternalReferenceNumber(masterReq.getExternalReferenceNumber());
					masterReqTo.setDescription(masterReq.getDescription());
					masterReqTo.setContactPerson(masterReq.getContactPerson());
					masterReqTo.setGroupId(masterReq.getGroupId());
					masterReqTo.setSolutionId(masterReq.getSolutionId());
					masterReqTo.setModuleId(masterReq.getModuleId());
					masterReqTo.setStatus(masterReq.getStatus());
					masterReqTo.setGroupName(getGroupNameById(masterReq.getGroupId()));
					masterReqTo.setSolutionName(getSolutionNameById(masterReq.getSolutionId()));
					masterReqTo.setModuleName(getModuleNameById(masterReq.getModuleId()));
					masterReqTo.setOwnerEmployeeId(masterReq.getOwnerEmployeeId());
					// Changes made by Bhuvana starts
					masterReqTo.setCustomization(masterReq.getCustomization());
					// Changes Completed
					masterReqTOList.add(masterReqTo);

				}
			}
			else
			{
				throw new NoMasterReqAvailableException();
			}
			
	 
				
		}
		catch(NoMasterReqAvailableException e)
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
		return masterReqTOList;
		
	}
	

	
	
	//get All Master Requirement details By Id
	@SuppressWarnings("unchecked")
	public MasterRequirementTO getMasterReqDetailsById(String masterReqId)throws NoMasterReqAvailableException,Exception
	{
		EntityManager em=null;
		MasterRequirementTO masterReqTo = new MasterRequirementTO();
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();
			
			Query query= em.createQuery("select mr from MasterRequirement mr where mr.masterRequirementId=?1");
			query.setParameter(1,masterReqId);
					
			List<MasterRequirement> rs1 = query.getResultList();
			
			if(!rs1.isEmpty())
			{
				for(MasterRequirement masterReq : rs1)
					{
					masterReqTo.setMasterRequirementId(masterReq.getMasterRequirementId());
					masterReqTo.setMasterRequirementTitle(masterReq.getMasterRequirementTitle());
					masterReqTo.setExternalReferenceNumber(masterReq.getExternalReferenceNumber());
					masterReqTo.setDescription(masterReq.getDescription());
					masterReqTo.setContactPerson(masterReq.getContactPerson());
					masterReqTo.setGroupId(masterReq.getGroupId());
					masterReqTo.setSolutionId(masterReq.getSolutionId());
					masterReqTo.setVerticalId(masterReq.getVerticalId());
					masterReqTo.setModuleId(masterReq.getModuleId());
					masterReqTo.setStatus(masterReq.getStatus());
					// Changes done by Bhuvana starts
					masterReqTo.setCustomization(masterReq.getCustomization());
					masterReqTo.setMrDate(masterReq.getMRDate());
					// Changes completed
					//changes done by sanket mehta
					
					//masterReqTo.setSolutionId(getSubModuleNameById(masterReq.getSubModuleId()));
					masterReqTo.setLocationName(getLocationNameById(masterReq.getGroupId()));
					//masterReqTo.setInitiatingGroupName(getinitiatingGroupById(masterReq.getGroupId()));
					//changes completed
					masterReqTo.setGroupName(getGroupNameById(masterReq.getGroupId()));
					masterReqTo.setSolutionName(getSolutionNameById(masterReq.getSolutionId()));
					//changes done by Bhuvana starts
					masterReqTo.setVerticalName(getVerticalNameById(masterReq.getVerticalId()));
					//changes completed
					masterReqTo.setModuleName(getModuleNameByModuleId(masterReq.getModuleId()));
					masterReqTo.setOwnerEmployeeId(masterReq.getOwnerEmployeeId());
				
					
					}
			}
			else
			{
				throw new NoMasterReqAvailableException();
			}
			
			et.commit();
				
		}
		catch(NoMasterReqAvailableException e)
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
		return masterReqTo;
		
	}
	
	
	// get group name by id
	@SuppressWarnings("unchecked")
	public String getGroupNameById(String groupId)throws NoGroupsAvailableException,Exception
	{
		
		EntityManager em=null;
		String groupName=null;
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
									
			et.begin();
			Query query= em.createQuery("select gi from GroupInfo gi where gi.groupId= ?1");
			query.setParameter(1, groupId);
			
			List<GroupInfo> rs1 = query.getResultList();
			
			if(!rs1.isEmpty())
			{
				for(GroupInfo group : rs1)
					{
						groupName =group.getGroupName();
					}
			}
			else
			{
				throw new NoGroupsAvailableException();
			}
			et.commit();
			
			
			return groupName;
					
		}
		
		catch( NoGroupsAvailableException e)
		{
			throw e;
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
	
	// get solution name by id
	@SuppressWarnings("unchecked")
	public String getSolutionNameById(String solutionId)throws NoSolutionsAvailableException,Exception
	{
		
		EntityManager em=null;
		String solutionName=null;
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
									
			et.begin();
			Query query= em.createQuery("select sl from Solution sl where sl.solutionId= ?1");
			query.setParameter(1, solutionId);
			
			List<Solution> rs1 = query.getResultList();
			
			if(!rs1.isEmpty())
			{
				for(Solution sol : rs1)
					{
					solutionName =sol.getSolutionName();
					}
			}
			else
			{
				throw new NoSolutionsAvailableException();
			}
			et.commit();
			
			
			return solutionName;
					
		}
		
		catch( NoSolutionsAvailableException e)
		{
			throw e;
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
	
	/*// get module name by id
	@SuppressWarnings("unchecked")
	public String getModuleNameById(String moduleId)throws NoModuleAvailableException,Exception
	{
		
		EntityManager em=null;
		String moduleName=null;
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
									
			et.begin();
			//Query query= em.createQuery("select ma from ModuleAnchor ma where ma.moduleId= ?1");
			Query query= em.createQuery("select m from Module m where m.moduleId= ?1");
		
			query.setParameter(1, moduleId);
			
			List<Module> rs1 = query.getResultList();
			
			if(!rs1.isEmpty())
			{
				for(Module module : rs1)
					{
						moduleName =module.getModuleName();
					}
			}
			else
			{
				throw new NoModuleAvailableException();
			}
			et.commit();
			
			
			return moduleName;
					
		}
		
		catch( NoModuleAvailableException e)
		{
			throw e;
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
	}*/
	
	
	// get group name by id
		@SuppressWarnings("unchecked")
		public String getModuleNameById(String moduleId)throws NoModuleAvailableException,Exception
		{
			
			EntityManager em=null;
			String moduleName=null;
			try 
			{
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
				em=emf.createEntityManager();
				EntityTransaction et= em.getTransaction();
										
				et.begin();
				Query query= em.createQuery("select mo from Module mo where mo.moduleId= ?1");
				query.setParameter(1, moduleId);
				
				List<Module> rs1 = query.getResultList();
				
				if(!rs1.isEmpty())
				{
					for(Module module : rs1)
						{
						moduleName =module.getModuleName();
						}
				}
				else
				{
					throw new NoModuleAvailableException();
				}
				et.commit();
				
				
				return moduleName;
						
			}
			
			catch( NoModuleAvailableException e)
			{
				throw e;
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
	
	
	//changes done by Bhuvana starts
	// get sub module name by id
		@SuppressWarnings("unchecked")
		public String getSubModuleNameById(String subModuleId) throws NoSubModuleAvailableForGivenModuleException,Exception
		{
			
			EntityManager em=null;
			String subModuleName=null;
			try 
			{
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
				em=emf.createEntityManager();
				EntityTransaction et= em.getTransaction();
				//System.out.println("submodule id: " +subModuleId);
				et.begin();
				Query query= em.createQuery("select s from SubModule s where s.subModuleId= ?1");
				query.setParameter(1, subModuleId);		
				List<SubModule> rs1 = query.getResultList();
				
				if(!rs1.isEmpty())
				{
					for(SubModule subModule : rs1)
						{
							subModuleName = subModule.getSubModuleName();
						}
				}
				else
				{
					throw new NoSubModuleAvailableForGivenModuleException();
				}
				et.commit();
				
				
				return subModuleName;
						
			}
			
			catch( NoSubModuleAvailableForGivenModuleException e)
			{
				throw e;
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
	public void updateMasterRequirement(MasterRequirementTO masterRequirementTO) throws Exception
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
		EntityManager em=null;
		
		try
		{
			em=emf.createEntityManager();
			em.getTransaction().begin();
			
			 
	       
	           Query ModuleOwnerquery=em.createQuery("select m.anchorName from Module m where m.moduleId=?1");
	           ModuleOwnerquery.setParameter(1,masterRequirementTO.getModuleId() );
	           
	           String moduleOwner = (String) ModuleOwnerquery.getSingleResult();
			MasterRequirement masterReq=new MasterRequirement();
			masterReq.setMasterRequirementId(masterRequirementTO.getMasterRequirementId());
			masterReq.setMasterRequirementTitle(masterRequirementTO.getMasterRequirementTitle());
			masterReq.setExternalReferenceNumber(masterRequirementTO.getExternalReferenceNumber());
			masterReq.setDescription(masterRequirementTO.getDescription());
			masterReq.setContactPerson(masterRequirementTO.getContactPerson());
			masterReq.setGroupId(masterRequirementTO.getGroupId());
			masterReq.setSolutionId(masterRequirementTO.getSolutionId());
			//masterReq.setModuleId(masterRequirementTO.getModuleId());
			masterReq.setVerticalId(masterRequirementTO.getVerticalId());
			// Changes done by Bhuvana starts
			//masterReq.setSubModuleId(masterRequirementTO.getSubModuleId());
			masterReq.setModuleId(masterRequirementTO.getModuleId());
			//System.out.println("module id in MRService: "+masterRequirementTO.getModuleId());
		    masterReq.setProductManager(moduleOwner);
		    // changes completed
			masterReq.setStatus(masterRequirementTO.getStatus());
			masterReq.setOwnerEmployeeId(masterRequirementTO.getOwnerEmployeeId());
			// Changes made by Bhuvana
			masterReq.setCustomization(masterRequirementTO.getCustomization());
			masterReq.setComments(masterRequirementTO.getComments());
			
			// changes complete
			
			//changes done by sanket mehta
			Date date = masterRequirementTO.getMrDate();
			if(date != null)
			{
				masterReq.setMRDate(date);
			}
			else
			{
				throw new InvalidDateException();
			}
			//changes completed
			//System.out.println("customization set at updation: "+masterReq.getCustomization());
			//changes completed		
			
			em.merge(masterReq);
			em.getTransaction().commit();
			
			
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
	
	//get all master requirements
    @SuppressWarnings("unchecked")
    public List<MasterRequirementTO> getAllMasterRequirements()throws NoMasterReqAvailableException,Exception
    {
          EntityManager em=null;
          List<MasterRequirementTO> toMasterReq = new ArrayList<MasterRequirementTO>() ;
          
          try 
          {
                EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
                em=emf.createEntityManager();
                EntityTransaction et= em.getTransaction();
                et.begin();
                
                Query query= em.createQuery("select mr from MasterRequirement mr");
                            
                List<MasterRequirement> rs1 = query.getResultList();
                
                if(!rs1.isEmpty())
                {
                      for(MasterRequirement masterReq : rs1)
                            {
                                  MasterRequirementTO masterReqTo = new MasterRequirementTO();
                                  
                                  masterReqTo.setMasterRequirementId(masterReq.getMasterRequirementId());
                                  masterReqTo.setMasterRequirementTitle(masterReq.getMasterRequirementTitle());
                                  masterReqTo.setExternalReferenceNumber(masterReq.getExternalReferenceNumber());
                                  masterReqTo.setDescription(masterReq.getDescription());
                                  masterReqTo.setContactPerson(masterReq.getContactPerson());
                                  masterReqTo.setGroupId(masterReq.getGroupId());
                                  masterReqTo.setSolutionId(masterReq.getSolutionId());
                                  //masterReqTo.setModuleId(masterReq.getModuleId());
                                  masterReqTo.setVerticalId(masterReq.getVerticalId());
                                  masterReqTo.setModuleId(masterReq.getModuleId());
                                  masterReqTo.setVerticalName(getVerticalNameById(masterReq.getVerticalId()));
                                  masterReqTo.setStatus(masterReq.getStatus());
                                  masterReqTo.setGroupName(getGroupNameById(masterReq.getGroupId()));
                                  masterReqTo.setSolutionName(getSolutionNameById(masterReq.getSolutionId())); 
                                  
                                  masterReqTo.setModuleName(getModuleNameByModuleId(masterReq.getModuleId()));
                                    
                                  //changes made by sanket mehta
                                  masterReqTo.setCustomization(masterReq.getCustomization());
                                  Date date = masterReq.getMRDate();
                                  if(date != null)
                                  {
                                	  masterReqTo.setMrDate(date);
                                  }
                                  //changes completed
                         
                                  
                                  toMasterReq.add(masterReqTo);
                                  
                            }
                }
                else
                {
                      throw new NoMasterReqAvailableException();
                }
                
                et.commit();
                      
          }
          catch(NoMasterReqAvailableException e)
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
          return toMasterReq;
    }
    
   @SuppressWarnings("unchecked")
public void abandonMasterRequirement(MasterRequirementTO masterRequirementTO) throws Exception
   {
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	   EntityManager em=null;
	   try
	   {
		   
		   em=emf.createEntityManager();
		   em.getTransaction().begin();
		   Query query=em.createQuery("select p from ProductRequirement p where p.masterRequirementId=?1");
		   query.setParameter(1, masterRequirementTO.getMasterRequirementId());
		   List<ProductRequirement> list=query.getResultList();
		   for (ProductRequirement productRequirement : list) 
		   {
			   productRequirement.setApprovedStatus("Abandoned");
		   }
		   em.getTransaction().commit();
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
   }
	
   public List<MasterRequirementTO> getMasterRequirementListByOwner(String ownerEmpId) throws Exception
   {
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	   EntityManager em=null;
	   try
	   {

		   em=emf.createEntityManager();
		   Query query=em.createQuery("select m from MasterRequirement m where m.ownerEmployeeId=?1");
		   query.setParameter(1,ownerEmpId);
		   List<MasterRequirement> list=query.getResultList();
		   List<MasterRequirementTO> masterReqTOList=new ArrayList<MasterRequirementTO>();
		   for(MasterRequirement masterReq : list)
           {
                 MasterRequirementTO masterReqTo = new MasterRequirementTO();
                 
                 masterReqTo.setMasterRequirementId(masterReq.getMasterRequirementId());
                 masterReqTo.setMasterRequirementTitle(masterReq.getMasterRequirementTitle());
                 masterReqTo.setExternalReferenceNumber(masterReq.getExternalReferenceNumber());
                 masterReqTo.setDescription(masterReq.getDescription());
                 masterReqTo.setContactPerson(masterReq.getContactPerson());
                 masterReqTo.setGroupId(masterReq.getGroupId());
                 masterReqTo.setSolutionId(masterReq.getSolutionId());
                 masterReqTo.setVerticalId(masterReq.getVerticalId());
                 masterReqTo.setModuleId(masterReq.getModuleId());
                 masterReqTo.setModuleName(getModuleNameByModuleId(masterReq.getModuleId()));
                 System.out.println("Master Req Id: "+masterReq.getModuleId());
                 
                 masterReqTo.setStatus(masterReq.getStatus());
                 masterReqTo.setGroupName(getGroupNameById(masterReq.getGroupId()));
                 masterReqTo.setSolutionName(getSolutionNameById(masterReq.getSolutionId()));
                 masterReqTo.setVerticalName(getVerticalNameById(masterReq.getVerticalId()));
                 //masterReqTo.setModuleName(getModuleNameById(masterReq.getModuleId()));
                 
                 
                 //changes done by sanket mehta
                 masterReqTo.setLocationName(getLocationNameById(masterReq.getGroupId()));
                 masterReqTo.setMrDate(masterReq.getMRDate());
                 
//                 System.out.println("date fetched in service class: " + masterReq.getMRDate());
                 //changes completed
                 
                 // Changes done by Bhuvana starts
                 masterReqTo.setCustomization(masterReq.getCustomization());
                 // Changes completed
                 
                 masterReqTOList.add(masterReqTo);
                 
           }
		   return masterReqTOList;
			
		
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   throw e;
	   }
	   finally {
		   if(em!=null) {
			   em.close();
		   }
	   }

   }
   
   
   public List<ProductRequirementTO> getProductRequirementsAssignedToMe(String ownerEmpId) throws Exception
   {
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	   EntityManager em=null;
	   try
	   {

		   em=emf.createEntityManager();
		   /*Query query=em.createQuery("select p,sr,fr,im from ProductRequirement p,FRSData fr, SRSData sr,ImpactData im where p.masterRequirementId" +
		   		                      " in(select m.masterRequirementId from MasterRequirement m where m.ownerEmployeeId=?1)"+		   
                                      "and sr.productRequirementId=p.productRequirementId " +
                                      "and fr.productRequirementId=p.productRequirementId " +
                                      "and im.productRequirementId=p.productRequirementId");*/
		   
		 /*  
		   Query query = em.createQuery("select p,sr,fr,im from ProductRequirement p, FRSData fr,  SRSData sr, Impact im where" 
		   		                    
                                    +" p.ProductRequirementId in (select frs.ProductRequirementId from  FRSData frs where frs.FRSOwnerEmailId in (SELECT SUBSTRING ( (select l.EmailId from  Login l where l.EmpId=?1 ),1, CHARINDEX('@',(select l1.EmailId from  Login l1 where l1.EmpId=?1) )-1) )" 
                                    +" or p.ProductRequirementId in (select srs.ProductRequirementId from  SRSData srs where srs.SRSOwnerEmailId in (SELECT SUBSTRING ( (select l.EmailId from  Login l where l.EmpId=?1 ),1, CHARINDEX('@',(select l1.EmailId from  Login l1 where l1.EmpId=?1) )-1) )))"
                                      +" and fr.productRequirementId=p.productRequirementId"
                                      + " and im.productRequirementId=p.productRequirementId" 
                                      +" and sr.ProductRequirementId=p.ProductRequirementId");*/
		   
		   /* +" or p.ProductRequirementId in (select srs.ProductRequirementId from  SRSData srs " 
           + "where srs.SRSOwnerEmailId =  SUBSTRING ( 'ann_thomas01@infosys.com',1,10)"*/
		   Query query1 = em.createQuery( " select l.emailId from  Login l where l.empId=?1");
	        query1.setParameter(1,ownerEmpId);
	        String emailId = (String) query1.getSingleResult();
	        
	        //String userId = emailId.substring(0, emailId.indexOf("@"));
	        
	        //System.out.println("@@@@@@@@@@@@@@@@@@  userID "+emailId);
		   
		   
		   
		   /*Query query = em.createQuery("select p,sr,fr,im from ProductRequirement p, FRSData fr,  SRSData sr, ImpactData im where" 	                    
                                       +" (p.productRequirementId in (select frs.productRequirementId from  FRSData frs "
                                       + " where frs.frsOwnerEmailId ="+"'"+emailId+"'"+")"
                                       +" or"
                                       + " p.productRequirementId in (select srs.productRequirementId from  SRSData srs "
                                       + " where srs.srsOwnerEmailId ="+"'"+emailId+"'"+"))"
                                       +" and fr.productRequirementId=p.productRequirementId"
                                       + " and im.productRequirementId=p.productRequirementId" 
                                       +" and sr.productRequirementId=p.productRequirementId");*/
		   
		   Query query = em.createQuery("select p,sr,fr from ProductRequirement p, FRSData fr,  SRSData sr where" 	                    
                   +" (p.productRequirementId in (select frs.productRequirementId from  FRSData frs "
                   + " where frs.frsOwnerEmailId ="+"'"+emailId+"'"+")"
                   +" or"
                   + " p.productRequirementId in (select srs.productRequirementId from  SRSData srs "
                   + " where srs.srsOwnerEmailId ="+"'"+emailId+"'"+"))"
                   +" and fr.productRequirementId=p.productRequirementId"
                   +" and sr.productRequirementId=p.productRequirementId");
		   
   
		   /*Query query = em.createQuery("select p,sr,fr from ProductRequirement p,FRSData fr, SRSData sr " +
		   		 "where p.dgOwner=sr.srsOwnerEmailId " +
		   		 "and sr.srsOwnerEmailId=fr.frsOwnerEmailId " +
		   		 "and p.dgOwner=?1");
		   query.setParameter(1,dgOwner);*/
		  
		  // List<ProductRequirement> list=query.getResultList();
		   List<ProductRequirementTO> productReqTOList=new ArrayList<ProductRequirementTO>();
		   @SuppressWarnings("unchecked")
		List<Object> objList=query.getResultList();
		   for (int i = 0; i < objList.size(); i++) {
				
				Object objArray[]=(Object[])objList.get(i);
				ProductRequirement productReq=(ProductRequirement)objArray[0];
				SRSData srsData=(SRSData)objArray[1];
				FRSData frsData=(FRSData)objArray[2];
				//ImpactData impactData=(ImpactData)objArray[3];
				
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
						
				productRequirementTO.setLocationName(masterRequirementTO.getLocationName());
				//productRequirementTO.setSubModuleName(masterRequirementTO.getSubModuleName());
				productRequirementTO.setVerticalName(masterRequirementTO.getVerticalName());
				productRequirementTO.setSolutionName(masterRequirementTO.getSolutionName());
			
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
				
				/*productRequirementTO.setImpactId(impactData.getImpactId());
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
				productRequirementTO.setThirdPartyImpact(impactData.getThirdPartyImpact());*/
				
				productReqTOList.add(productRequirementTO);
                 
           }
		   return productReqTOList;
			
		
	   }
	   catch(Exception e)
	   {
		   System.out.println("@**entity**@@71" );
		   e.printStackTrace();
		   throw e;
	   }
	   finally {
		   if(em!=null) {
			   em.close();
		   }
	   }

   }
   
   //get product scope items list
   public List<ProductRequirementTO> getProductScopeItemsList(String ownerEmpId) throws Exception
   {
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	   EntityManager em=null;
	   try
	   {

		   em=emf.createEntityManager();
		   //System.out.println("I wanted to populate the product scope list "+ownerEmpId);
	        
	 /*       		   
		   Query query = em.createQuery("select p,sr,fr from ProductRequirement p, FRSData fr,  SRSData sr where" 	                    
                   +" (p.productRequirementId in (select frs.productRequirementId from  FRSData frs "
                   + " where frs.frsOwnerEmailId ="+"'"+emailId+"'"+")"
                   +" or"
                   + " p.productRequirementId in (select srs.productRequirementId from  SRSData srs "
                   + " where srs.srsOwnerEmailId ="+"'"+emailId+"'"+"))"
                   +" and fr.productRequirementId=p.productRequirementId"
                   +" and sr.productRequirementId=p.productRequirementId");*/
		 
		   
		   /* Query is for only  mr.productManager = m.anchorName ,output is same for all users*/
	       /* Query query = em.createQuery("select frs.frsOwnerEmailId, mr.productManager, pr.ownerEmployeeId, pr.dgOwner, srs.srsOwnerEmailId, srs.rAAnchor ,m.anchorName ,mr.masterRequirementId from FRSData frs , ProductRequirement pr, SRSData srs, MasterRequirement mr, Module m where"+
	        " mr.masterRequirementId = pr.masterRequirementId  and"+ 
	        " pr.productRequirementId = srs.productRequirementId and"+
	        " pr.productRequirementId = frs.productRequirementId and"+
	        " mr.moduleId = m.moduleId and"+
	        " mr.productManager = m.anchorName");*/
		   
		   /*Query query = em.createQuery("select pr.productRequirementId, pr.productRequirementTitle, pr.productVersion, pr.productRequirementDescription, mr.masterRequirementId, mr.masterRequirementTitle, " +
		   		"mr.groupId, mr.moduleId, mr.ownerEmployeeId, pr.ownerEmployeeId, mr.productManager, frs.frsOwnerEmailId, srs.srsOwnerEmailId, srs.rAAnchor, pr.approvedStatus, pr.comments from FRSData frs , ProductRequirement pr, SRSData srs, MasterRequirement mr, Module m where"+
			        " mr.masterRequirementId = pr.masterRequirementId  and"+ 
			        " pr.productRequirementId = srs.productRequirementId and"+
			        " pr.productRequirementId = frs.productRequirementId and"+
			        " mr.moduleId = m.moduleId");
			        
		   
		   
		    Query query2 = em.createQuery("select l.emailId from Login l where l.empId=?1");
		    query2.setParameter(1, ownerEmpId);
		    String ownerEmailID=(String)query2.getSingleResult();*/
		    
		   
		   Query query1 = em.createQuery( " select l.emailId from  Login l where l.empId=?1");
	        query1.setParameter(1,ownerEmpId);
	        String emailId = (String) query1.getSingleResult();
	        
	          
		   Query query = em.createQuery("select pr.productRequirementId, pr.productRequirementTitle, pr.productVersion, " +
		   		" pr.productRequirementDescription, mr.masterRequirementId, mr.masterRequirementTitle, mr.groupId, mr.moduleId, mr.ownerEmployeeId, pr.ownerEmployeeId, fr.frsOwnerEmailId, sr.srsOwnerEmailId, sr.rAAnchor, pr.approvedStatus, pr.comments from MasterRequirement mr, ProductRequirement pr, FRSData fr,  SRSData sr, Module m where"
		   		+" mr.masterRequirementId = pr.masterRequirementId  and"+ 
		        " pr.productRequirementId = sr.productRequirementId and"+
		        " pr.productRequirementId = fr.productRequirementId and"+
		        " mr.moduleId = m.moduleId and "
                  + "(mr.productManager ="+"'"+emailId+"'"
                  +" or"
                  + " mr.contactPerson ="+"'"+emailId+"'"
                  +" or"
                  + " pr.dgOwner ="+"'"+emailId+"'"
                  +" or"
                  + " pr.ownerEmployeeId ="+"'"+emailId+"'"
                  +" or"
                  + " sr.srsOwnerEmailId ="+"'"+emailId+"'"
                  +" or"
                  + " sr.rAAnchor ="+"'"+emailId+"'"
                  +" or"
                  + " fr.frsOwnerEmailId ="+"'"+emailId+"'"
                  +" or"
                  + " m.anchorName ="+"'"+emailId+"'" +")");        
		    
		   /*  Query is for only  mr.productManager = m.anchorName ,output is depends on login user
	        Query query = em.createQuery("select frs.frsOwnerEmailId, mr.productManager, pr.ownerEmployeeId, pr.dgOwner, srs.srsOwnerEmailId, srs.rAAnchor ,m.anchorName ,mr.masterRequirementId from FRSData frs , ProductRequirement pr, SRSData srs, MasterRequirement mr, Module m where"+
	    	        " mr.masterRequirementId = pr.masterRequirementId  and"+ 
	    	        " pr.productRequirementId = srs.productRequirementId and"+
	    	        " pr.productRequirementId = frs.productRequirementId and"+
	    	        " mr.moduleId = m.moduleId and"+
	    	        " mr.productManager=?1 and"+
	    	        " mr.productManager = m.anchorName");
	        query.setParameter(1, ownerEmailID);*/
	        
   
		List<ProductRequirementTO> productReqTOListtoMe=new ArrayList<ProductRequirementTO>();
		   @SuppressWarnings("unchecked")
		List<Object> objList=query.getResultList();
		   for (int i = 0; i < objList.size(); i++) {
				
				Object objArray[]=(Object[])objList.get(i);
			
				String productRequirementId = (String)objArray[0];
				String productRequirementTitle = (String)objArray[1];
				String productVersion = (String)objArray[2];
				String productRequirementDescription = (String)objArray[3];
				
				String masterRequirementId = (String)objArray[4];
				String masterRequirementTitle = (String)objArray[5];
				String groupName = (String)objArray[6];
				String moduleName = (String)objArray[7];
				//String ownerEmployeeIdMr = (String)objArray[8];
				String ownerEmployeeIdPr = (String)objArray[8];
				String productManager = (String)objArray[9];
				
				String frsOwnerEmailId = (String)objArray[10];
				String srsOwnerEmailId = (String)objArray[11];
				String rAAnchor = (String)objArray[12];
				String approvalStatus = (String)objArray[13];
				String comments=(String)objArray[14];
				
				
				ProductRequirementTO productRequirementTO = new ProductRequirementTO();

				productRequirementTO.setProductRequirementId(productRequirementId);
				productRequirementTO.setProductRequirementTitle(productRequirementTitle);
				productRequirementTO.setProductVersion(productVersion);
				productRequirementTO.setProductRequirementDescription(productRequirementDescription);
				
				productRequirementTO.setMasterRequirementId(masterRequirementId);
				productRequirementTO.setMasterRequirementTitle(masterRequirementTitle);
				
				
				MasterRequirementService masterReqService = new MasterRequirementService();
				productRequirementTO.setGroupName(masterReqService.getGroupNameById(groupName));
				productRequirementTO.setModuleName(masterReqService.getModuleNameById(moduleName));
				
				//productRequirementTO.setGroupName(groupName);				
				//productRequirementTO.setModuleName(moduleName);
				//productRequirementTO.setOwnerEmployeeId(ownerEmployeeIdMr);
				productRequirementTO.setOwnerEmployeeId(ownerEmployeeIdPr);
				productRequirementTO.setProductManager(productManager);
				
				
	productRequirementTO.setFrsOwnerEmailId(frsOwnerEmailId);	
	productRequirementTO.setSrsOwnerEmailId(srsOwnerEmailId);
	productRequirementTO.setSrsRAAnchor(rAAnchor);
	productRequirementTO.setApprovedStatus(approvalStatus);
	productRequirementTO.setComments(comments);
			
				
	productReqTOListtoMe.add(productRequirementTO);
                 
           }
		   return productReqTOListtoMe;
			
		
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   throw e;
	   }
	   finally {
		   if(em!=null) {
			   em.close();
		   }
	   }

   }
   
   
   public void uploadMasterReqList(List<MasterRequirementTO> masterReqListTo) throws Exception
   {
	   EntityManager em=null;
	   EntityTransaction et=null;
	   try 
	   {
		   EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
		   em=emf.createEntityManager();
		   et=em.getTransaction();
		   et.begin();
		   Integer mid=100;
		   String masterId;
//		   Query query=em.createQuery("select max(m.masterRequirementId) from MasterRequirement m");
		   Query query=em.createQuery("select m.masterRequirementId from MasterRequirement m");
		   String masterReqId;
           List<String> MRIdList =  query.getResultList();
           List<Integer> Ids;
           Integer temp = 100;
           if(!MRIdList.isEmpty())
           {
                  
                  for(String Id : MRIdList)
                  {
                        temp = Integer.parseInt(Id.substring(2, Id.length()));
                        mid = temp > mid ? temp : mid; 
                  }
                  
           }
           mid++;
           masterId="MR"+String.valueOf(mid);

//		   String masterReqId=(String)query.getSingleResult();
//		   if(masterReqId!=null)
//		   {
//			   mid=Integer.parseInt(masterReqId.substring(2, masterReqId.length()));
//			   			    
//		   }
		   
		   MasterRequirement entity=null;
		   
		   for(int i=1;i<masterReqListTo.size();i++ )
		   {
			    masterId="MR"+String.valueOf(++mid);
			   
			   entity = new MasterRequirement();
			   MasterRequirementTO toObj = masterReqListTo.get(i);

			   
			   entity.setMasterRequirementId(masterId);
			   entity.setMasterRequirementTitle(toObj.getMasterRequirementTitle());
			   entity.setExternalReferenceNumber(toObj.getExternalReferenceNumber());
			   entity.setDescription(toObj.getDescription());
			   entity.setContactPerson(toObj.getContactPerson());
			   entity.setCustomization(toObj.getCustomization());
			   entity.setStatus("Entered");
			   entity.setSolutionId(getSolutionIdByName(toObj.getSolutionName()).getSolutionId());
			   //entity.setModuleId(getModuleIdByName(toObj.getModuleName()).getModuleId());
			   entity.setVerticalId(getVerticalIdByName(toObj.getVerticalName()).getVerticalId());
			   entity.setModuleId(getModuleIdByName(toObj.getModuleName()).getModuleId());
			   entity.setGroupId(getGroupIdByName(toObj.getGroupName()).getGroupId());
			   entity.setOwnerEmployeeId(toObj.getOwnerEmployeeId());
			   //changes made by sanket mehta
			   entity.setMRDate(toObj.getMrDate());
			   //entity.setSubModuleId(getSubModuleIdByName(toObj.getSubModuleName()).getSubModuleId());
			   //changes complete
			   em.persist(entity);
			   }
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
               //System.out.println("group name is: " + groupName);
               query.setParameter(1,groupName);
               
               List<GroupInfo> rs1 = query.getResultList();
//               GroupInfo rs1 = (GroupInfo)query.getSingleResult();
              // System.out.println("total size of group querylist is: "  + rs1.size());
            
               if(!rs1.isEmpty())
               {
//            	   System.out.println(" Hello ");
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
   
   
   public SolutionTO getSolutionIdByName(String solutionName)throws NoSolutionsAvailableException, Exception
   {
         EntityManager em=null;
        SolutionTO solTo = new SolutionTO();
         try 
         {
               EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
               em=emf.createEntityManager();
               EntityTransaction et= em.getTransaction();

               //et.begin();
               Query query= em.createQuery("select sl from Solution sl where sl.solutionName= ?1");
               query.setParameter(1,solutionName);

               List<Solution> rs1 = query.getResultList();
              // System.out.println("total size of solution querylist is: "  + rs1.size());
               if(!rs1.isEmpty())
               {
                     for(Solution sol : rs1)
                     {
                    	  solTo.setSolutionId(sol.getSolutionId()); 
                    	  solTo.setSolutionName(sol.getSolutionName());
                    	                
                     }
                     return solTo;
               }
               else
               {
            	   throw new NoSolutionsAvailableException();
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
   
   public SubModuleTO getSubModuleIdByName(String subModuleName)throws Exception
   {
         EntityManager em=null;
         SubModuleTO modTo = new SubModuleTO();
         try 
         {
               EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
               em=emf.createEntityManager();
               EntityTransaction et= em.getTransaction();

               //et.begin();
               Query query= em.createQuery("select ms from SubModule ms where ms.subModuleName= ?1");
               query.setParameter(1,subModuleName);
              // System.out.println("*** Sub Module Name*** "+subModuleName);

               List<SubModule> rs1 = query.getResultList();
               //System.out.println("total size of subModule querylist is: "  + rs1.size());
               if(!rs1.isEmpty())
               {
                     for(SubModule mod : rs1)
                     {
                    	 modTo.setSubModuleId(mod.getSubModuleId()); 
                    	 modTo.setSubModuleName(mod.getSubModuleName());
                    	                
                     }
                     return modTo;
               }
               else
               {
            	   throw new NoSubModuleAvailableForGivenModuleException();
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
   
   public ModuleAnchorTO getModuleIdByName(String moduleName)throws Exception
   {
         EntityManager em=null;
         ModuleAnchorTO modTo = new ModuleAnchorTO();
         try 
         {
               EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
               em=emf.createEntityManager();
               EntityTransaction et= em.getTransaction();

               //et.begin();
               Query query= em.createQuery("select ma from Module ma where ma.moduleName= ?1");
               query.setParameter(1,moduleName);
              // System.out.println("*** Module Name*** "+moduleName);

               List<Module> rs1 = query.getResultList();
               //System.out.println("total size of module querylist is: "  + rs1.size());
               if(!rs1.isEmpty())
               {
                     for(Module mod : rs1)
                     {
                    	 modTo.setModuleId(mod.getModuleId()); 
                    	 modTo.setModuleName(mod.getModuleName());
                    	                
                     }
                     return modTo;
               }
               else
               {
            	   throw new NoModuleAvailableException();
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
   
   @SuppressWarnings("unchecked")
/*public List<MasterRequirementTO> getMasterRequirements(String... searchObjects)throws Exception
	{
	   EntityManager em=null;

		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();	
			List<MasterRequirementTO>masterReqTOList=new ArrayList<MasterRequirementTO>();
			
			String queryString="select mr from MasterRequirement mr, GroupInfo gi where mr.groupId = gi.groupId and ";
			int count =1;
			for(int i=0,j=1;i<searchObjects.length;i++)
			{
				  //queryString+=" and mr.";
				if(i%2==0)
				{

					if(searchObjects[i].equals("locationId"))
					{
						queryString+=" mr.groupId = gi.groupId and gi.";
						queryString+=searchObjects[i]+"=?"+j;
					}
				
					else if(searchObjects[i].equals("initiatingGroupId"))
					{
						queryString+=" gi.";
						queryString+=searchObjects[i]+"=?"+j;
					}
					
					// added for search filed
					else if(searchObjects[i].equals("searchBy"))
					{
						
						String searchWord = searchObjects[i+1];
						System.out.println("typed word"+searchWord);
						String[] searchSeparator = null;
						
						if(searchWord.contains(","))	
						{
						searchSeparator = searchWord.split(",");
						System.out.println("searchSeparator "+searchSeparator.length);
						}
					
						if(searchSeparator!=null && searchSeparator.length>=2 ){
							for(int z=0 ;z<searchSeparator.length;z++){
							
							queryString+=" (mr.masterRequirementTitle";
							
							//queryString+=" LIKE ?1"+searchObjects[i+1]+"%'";
							queryString+=" LIKE ?"+count;
							queryString+=" OR mr.description ";
					
							queryString+=" LIKE ?"+count+" )";
							
							if(z<(searchSeparator.length-1)){
								queryString+=" OR ";
								count++;
								
							 }		
							
							}
							System.out.println("searchSeparator for query string"+queryString);
						}else{
						queryString+=" (mr.masterRequirementTitle";
						
						//queryString+=" LIKE ?1"+searchObjects[i+1]+"%'";
						queryString+=" LIKE ?"+j;
						queryString+=" OR mr.description ";
				
						queryString+=" LIKE ?"+j+" )";}
					
					}
					//changes completed
					
					else if(searchObjects[i].equals("status") && searchObjects[i+1].equalsIgnoreCase("customization") )
					{
						//System.out.println("getMasterRequirementsgetMasterRequirements search engine");
						queryString+=" mr.customization " + "=?"+ j;
//						queryString+=searchObjects[i]+"=?"+j;
					}
					//changes done by sanket mehta
					else if(searchObjects[i].equals("fromDate"))
					{
						queryString+=" mr.MRDate " + ">=?"+ j;
					}
					else if(searchObjects[i].equals("toDate"))
					{
						queryString+=" mr.MRDate " + "<=?"+ j;
					}
					//changes complete
					
					
					else
					{
						queryString+="  mr."+searchObjects[i]+"=?"+j;
					}
					if(i<(searchObjects.length-2))
					  {
						  queryString+=" and " ; 
					  }
					  j++;
				}
			}
			
			System.out.println("query is:main " + queryString);
			Query query= em.createQuery(queryString);
			//query.setFirstResult(1);
			for(int i=0,j=1;i<searchObjects.length;i++)
			{
				//System.out.println("query is: in for loop" + queryString);
				
				if(i%2!=0 )
				{
					if(searchObjects[i].equalsIgnoreCase("customization") )
				    {
					
						query.setParameter(j, "yes");
						
					}
					
					
					
					//changes done by sanket mehta
					if(searchObjects[i-1].equalsIgnoreCase("fromDate") || searchObjects[i-1].equalsIgnoreCase("toDate"))
				    {	
						
						Date newdate = new  SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH).parse(searchObjects[i]);
						query.setParameter(j, newdate);
					}
					//changes completed
					else
					{
						
						if(searchObjects[i-1].equals("searchBy"))
							
						{System.out.println("typed word"+searchObjects[i]);
							System.out.println("search has commas"+count);
							if(count>1){
								String value=searchObjects[i];
								String[] searchSeparator = null;
								String SearchWord =null;
								
								if(value.contains(","))	
								{
								searchSeparator = value.split(",");
								}
								//System.out.println("value at setting parameter"+searchSeparator.length);
								//System.out.println("leangth of separator"+searchSeparator.length);
								for(int k=0;k<searchSeparator.length && count>0;k++){
									SearchWord=searchSeparator[k];
									SearchWord = "%"+SearchWord+"%";
									System.out.println("search word parameter"+SearchWord);
									System.out.println("setting parameter"+count);
									query.setParameter(count, SearchWord);
									count--;
								}
								
								
							}else{
							String value=searchObjects[i];
							value = searchObjects[i].trim();
							value = "%"+value+"%";
						query.setParameter(j, value);}
						
						}
						else{
							query.setParameter(j, searchObjects[i]);
							}
					}
					j++;			
					
				}
				
				
				else{
					if(searchObjects[i].equalsIgnoreCase("searchBy") )
				    {
						
						System.out.println("searchObjects[i+1]" + searchObjects[i+1]);
						query.setParameter(j, searchObjects[i+1]+"_%");
						
					}
					
				}
			
			}
			
			//Query query= em.createQuery("select pr from ProductRequirement pr, MasterRequirement mr where pr.masterRequirementId=mr.masterRequirementId and mr.groupId=?1 and mr.moduleId=?2 and pr.productVersion=?3");
			
			List<MasterRequirement> rs1 = query.getResultList();
			Set<MasterRequirement> rs3 = new HashSet<MasterRequirement>(rs1);
			System.out.println("list of accepted req"+rs3.size());
			
			if(!rs3.isEmpty())
            {
                  for(MasterRequirement masterReq : rs3)
                        {
                	  System.out.println("result"+masterReq.getMasterRequirementId());
                              MasterRequirementTO masterReqTo = new MasterRequirementTO();
                              
                              masterReqTo.setMasterRequirementId(masterReq.getMasterRequirementId());
                              masterReqTo.setMasterRequirementTitle(masterReq.getMasterRequirementTitle());
                              masterReqTo.setExternalReferenceNumber(masterReq.getExternalReferenceNumber());
                              masterReqTo.setDescription(masterReq.getDescription());
                              masterReqTo.setContactPerson(masterReq.getContactPerson());
                              masterReqTo.setGroupId(masterReq.getGroupId());
                              masterReqTo.setSolutionId(masterReq.getSolutionId());
                              masterReqTo.setVerticalId(masterReq.getVerticalId());
                              masterReqTo.setStatus(masterReq.getStatus());
                              masterReqTo.setGroupName(getGroupNameById(masterReq.getGroupId()));
                              masterReqTo.setSolutionName(getSolutionNameById(masterReq.getSolutionId()));
                         
                             // masterReqTo.setModuleName(getModuleNameById(masterReq.getModuleId()));
                              masterReqTo.setLocationName(getLocationNameById(masterReq.getGroupId()));
                              // Changes made by Sanket starts
                             // masterReqTo.setSubModuleId(masterReq.getSubModuleId());
                              masterReqTo.setModuleId(masterReq.getModuleId());
                              masterReqTo.setVerticalName(getVerticalNameById(masterReq.getVerticalId()));
                              masterReqTo.setModuleName(getModuleNameByModuleId(masterReq.getModuleId()));
                              //masterReqTo.setSearchMRByTitle(masterReq.getMasterRequirementTitle());
                            
                              //System.out.println("module");
                             
                              masterReqTo.setCustomization(masterReq.getCustomization());
                              masterReqTo.setMrDate(masterReq.getMRDate());
                              // Changes made by Sanket ends
                              Query query1= em.createQuery("select mra from MasterRequirmentAttachment mra where mra.masterRequirementId= ?1");
                              query1.setParameter(1,masterReq.getMasterRequirementId() );
                              List<MasterRequirmentAttachment> rs2 = query.getResultList();
                              if(!rs2.isEmpty())
                              {
                            	  masterReqTo.setAttachmentStatus("present");
                              }
                              else
                              {
                            	  masterReqTo.setAttachmentStatus(null);
                              }
                              
                              masterReqTOList.add(masterReqTo);
                              
                        }
            }
            
			 return masterReqTOList;
			
		}
		catch (Exception e) {
			throw e;
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
	}*/
   
   public List<MasterRequirementTO> getMasterRequirements(String... searchObjects)throws Exception
	{
	   EntityManager em=null;

		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();	
			List<MasterRequirementTO>masterReqTOList=new ArrayList<MasterRequirementTO>();
			
			String queryString="select mr from MasterRequirement mr, GroupInfo gi where mr.groupId = gi.groupId and ";
			
			for(int i=0,j=1;i<searchObjects.length;i++)
			{
				  //queryString+=" and mr.";
				if(i%2==0)
				{

					if(searchObjects[i].equals("locationId"))
					{
						queryString+=" mr.groupId = gi.groupId and gi.";
						queryString+=searchObjects[i]+"=?"+j;
					}
				
					else if(searchObjects[i].equals("initiatingGroupId"))
					{
						queryString+=" gi.";
						queryString+=searchObjects[i]+"=?"+j;
					}
					
					// added for search filed
					else if(searchObjects[i].equals("searchBy"))
					{
						/*queryString+=" mr.masterRequirementTitle like ?"+j ;
						
						System.out.println("Query String "+queryString);*/
					
						queryString+=" (mr.masterRequirementTitle";
						
						//queryString+=" LIKE ?1"+searchObjects[i+1]+"%'";
						queryString+=" LIKE ?"+j;
						queryString+=" OR mr.description ";
				
						queryString+=" LIKE ?"+j+" )";
						  
						//System.out.println("Query String "+queryString);
					}
					//changes completed
					
					else if(searchObjects[i].equals("status") && searchObjects[i+1].equalsIgnoreCase("customization") )
					{
						//System.out.println("getMasterRequirementsgetMasterRequirements search engine");
						queryString+=" mr.customization " + "=?"+ j;
//						queryString+=searchObjects[i]+"=?"+j;
					}
					//changes done by sanket mehta
					else if(searchObjects[i].equals("fromDate"))
					{
						queryString+=" mr.MRDate " + ">=?"+ j;
					}
					else if(searchObjects[i].equals("toDate"))
					{
						queryString+=" mr.MRDate " + "<=?"+ j;
					}
					//changes complete
					
					
					else
					{
						queryString+="  mr."+searchObjects[i]+"=?"+j;
					}
					if(i<(searchObjects.length-2))
					  {
						  queryString+=" and " ; 
					  }
					  j++;
				}
			}
			
			//System.out.println("query is: " + queryString);
			Query query= em.createQuery(queryString);
			for(int i=0,j=1;i<searchObjects.length;i++)
			{
				//System.out.println("query is: in for loop" + queryString);
				
				if(i%2!=0 )
				{
					if(searchObjects[i].equalsIgnoreCase("customization") )
				    {
					
						query.setParameter(j, "yes");
						
					}
					
					
					
					//changes done by sanket mehta
					if(searchObjects[i-1].equalsIgnoreCase("fromDate") || searchObjects[i-1].equalsIgnoreCase("toDate"))
				    {	
						
						Date newdate = new  SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH).parse(searchObjects[i]);
						query.setParameter(j, newdate);
					}
					//changes completed
					else
					{
						
						if(searchObjects[i-1].equals("searchBy"))
							
						{
							String value=searchObjects[i];
							/*String value=searchObjects[i];
							if(value.equals(""))
							{
								value = value.replaceAll("", " ");
							}
							//String replace = value.concat("");
							System.out.println("searchBysearchBy" + queryString);*/
							//System.out.println("search field" + value);
							value = searchObjects[i].trim();
							//System.out.println("search field" + value);
							value = "%"+value+"%";
							//System.out.println("search field" + value);
						query.setParameter(j, value);
						//System.out.println("search field" + value);
						}
						else{
							query.setParameter(j, searchObjects[i]);
							}
					}
					j++;			
					
				}
				
				
				/*else{
					if(searchObjects[i].equalsIgnoreCase("searchBy") )
				    {
						
						System.out.println("searchObjects[i+1]" + searchObjects[i+1]);
						query.setParameter(j, searchObjects[i+1]+"_%");
						
					}
					
				}*/
			
			}
			
			//Query query= em.createQuery("select pr from ProductRequirement pr, MasterRequirement mr where pr.masterRequirementId=mr.masterRequirementId and mr.groupId=?1 and mr.moduleId=?2 and pr.productVersion=?3");
			 
			List<MasterRequirement> rs1 = query.getResultList();
			//System.out.println("list of accepted req"+rs1.size());
			
			if(!rs1.isEmpty())
           {
                 for(MasterRequirement masterReq : rs1)
                       {
                             MasterRequirementTO masterReqTo = new MasterRequirementTO();
                             
                             masterReqTo.setMasterRequirementId(masterReq.getMasterRequirementId());
                             masterReqTo.setMasterRequirementTitle(masterReq.getMasterRequirementTitle());
                             masterReqTo.setExternalReferenceNumber(masterReq.getExternalReferenceNumber());
                             masterReqTo.setDescription(masterReq.getDescription());
                             masterReqTo.setContactPerson(masterReq.getContactPerson());
                             masterReqTo.setGroupId(masterReq.getGroupId());
                             masterReqTo.setSolutionId(masterReq.getSolutionId());
                             masterReqTo.setVerticalId(masterReq.getVerticalId());
                             masterReqTo.setStatus(masterReq.getStatus());
                             masterReqTo.setGroupName(getGroupNameById(masterReq.getGroupId()));
                             masterReqTo.setSolutionName(getSolutionNameById(masterReq.getSolutionId()));
                        
                            // masterReqTo.setModuleName(getModuleNameById(masterReq.getModuleId()));
                             masterReqTo.setLocationName(getLocationNameById(masterReq.getGroupId()));
                             // Changes made by Sanket starts
                            // masterReqTo.setSubModuleId(masterReq.getSubModuleId());
                             masterReqTo.setModuleId(masterReq.getModuleId());
                             masterReqTo.setVerticalName(getVerticalNameById(masterReq.getVerticalId()));
                             masterReqTo.setModuleName(getModuleNameByModuleId(masterReq.getModuleId()));
                             masterReqTo.setComments(masterReq.getComments());
                             //masterReqTo.setSearchMRByTitle(masterReq.getMasterRequirementTitle());
                           
                             //System.out.println("module");
                            
                             masterReqTo.setCustomization(masterReq.getCustomization());
                             masterReqTo.setMrDate(masterReq.getMRDate());
                             // Changes made by Sanket ends
                             Query query1= em.createQuery("select mra from MasterRequirmentAttachment mra where mra.masterRequirementId= ?1");
                             query1.setParameter(1,masterReq.getMasterRequirementId() );
                             List<MasterRequirmentAttachment> rs2 = query.getResultList();
                             if(!rs2.isEmpty())
                             {
                           	  masterReqTo.setAttachmentStatus("present");
                             }
                             else
                             {
                           	  masterReqTo.setAttachmentStatus(null);
                             }
                             
                             masterReqTOList.add(masterReqTo);
                             
                       }
           }
           
			 return masterReqTOList;
			
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
	
   public MasterRequirementAttachmentTO uploadMasterRequirementAttachment(MasterRequirementAttachmentTO attachmentTO) throws Exception
   {
	   EntityManager em=null;
      
       try 
       {
             EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
             em=emf.createEntityManager();
           
             Query query=em.createQuery("select max(ma.mrAttachmentId) from MasterRequirmentAttachment ma");
             String attachmentId=(String)query.getSingleResult();
             int id=100;
        
             if(attachmentId!=null)
             {
            	id=Integer.parseInt(attachmentId.substring(2, attachmentId.length()));
     			id++;
             }
             String masterAttachmentId="MA"+String.valueOf(id);
             String extension=FilenameUtils.getExtension(attachmentTO.getFileName());
             String fileName= FilenameUtils.getBaseName(attachmentTO.getFileName());
             fileName=fileName+masterAttachmentId+"."+extension;
             MasterRequirmentAttachment attachment=new MasterRequirmentAttachment();
             attachment.setFileName(fileName);
             attachment.setMrAttachmentId(masterAttachmentId);
             attachment.setMasterRequirementId(attachmentTO.getMasterRequirementId());
             em.getTransaction().begin();
             em.persist(attachment);
             em.getTransaction().commit();
             attachmentTO.setFileName(fileName);
             attachmentTO.setMRAttachmentId(masterAttachmentId);
             return attachmentTO;
       }
       catch(Exception e)
       {
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
   
   public List<MasterRequirementAttachmentTO> getAttachmentsByMasterReqId(String masterRequirementId)throws Exception
   {
	   EntityManager em=null;
      
       try 
       {
    	    
             EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
             em=emf.createEntityManager();
           
             Query query=em.createQuery("select ma from MasterRequirmentAttachment ma where ma.masterRequirementId=?1");
             query.setParameter(1, masterRequirementId);
             List<MasterRequirmentAttachment> attachmentList=query.getResultList();
             List<MasterRequirementAttachmentTO> attachmentTOList=new ArrayList<MasterRequirementAttachmentTO>();
             if(!attachmentList.isEmpty())
             {
            	 for (MasterRequirmentAttachment masterRequirmentAttachment : attachmentList) {
            		 MasterRequirementAttachmentTO attachmentTO=new MasterRequirementAttachmentTO();
            		 attachmentTO.setFileName(masterRequirmentAttachment.getFileName());
            		 attachmentTO.setMasterRequirementId(masterRequirementId);
            		 attachmentTO.setMRAttachmentId(masterRequirmentAttachment.getMrAttachmentId());
            		 attachmentTOList.add(attachmentTO);
            	 }
             }
             return attachmentTOList;
             
       }
       catch (Exception e) {
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
   
// get location name by id
	@SuppressWarnings("unchecked")
	public String getLocationNameById(String groupId)throws NoLocationsAvailableException,Exception
	{

		EntityManager em=null;
		String locationName=null;
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();

			et.begin();
			Query query= em.createQuery("select lo from Location lo where lo.locationId in (select gi.locationId from GroupInfo gi where gi.groupId= ?1)");
			query.setParameter(1, groupId);

			List<Location> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
				for(Location location : rs1)
				{
					locationName =location.getLocationName();
				}
			}
			else
			{
				throw new NoLocationsAvailableException();
			}
			et.commit();


			return locationName;

		}

		catch(NoLocationsAvailableException e)
		{
			throw e;
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
	 //changes done by Bhuvana
		//get sub modules by module
			@SuppressWarnings("unchecked")
			public Map<String,String> getSubModulesBymodule(String moduleId)throws NoGroupsAvailableException,Exception
			{


				EntityManager em=null;
				Map<String,String> subModuleMap = new TreeMap<String, String>();

				try 
				{
					EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
					em=emf.createEntityManager();
					EntityTransaction et= em.getTransaction();

					et.begin();
					Query query= em.createQuery("select sm from SubModule sm where sm.subModuleId= ?1");
					query.setParameter(1, moduleId);

					List<SubModule> rs1 = query.getResultList();

					if(!rs1.isEmpty())
					{
						for(SubModule subModulesList : rs1)
						{
							subModuleMap.put(subModulesList.getSubModuleId(), subModulesList.getSubModuleName());

						}
					}
					else
					{
						throw new NoSubModuleAvailableForGivenModuleException();
					}
					et.commit();

					
					return subModuleMap;

				}

				catch( NoSubModuleAvailableForGivenModuleException e)
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
			}
			//get All solutions
			@SuppressWarnings("unchecked")
			public Map<String,String> getAllVerticals()throws NoSolutionsAvailableException,Exception
			{
				EntityManager em=null;
				Map<String, String> verticalsMap = new TreeMap<String, String>();
				try 
				{
					EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
					em=emf.createEntityManager();
					EntityTransaction et= em.getTransaction();
					et.begin();
					
					Query query= em.createQuery("select v from Vertical v ");
							
					List<Vertical> rs1 = query.getResultList();
					
					if(!rs1.isEmpty())
					{
						for(Vertical vertical : rs1)
							{
							verticalsMap.put(vertical.getVerticalId(), vertical.getVerticalName());
							}
					}
					else
					{
						throw new NoSolutionsAvailableException();
					}
					
					et.commit();
						
				}
				catch(NoSolutionsAvailableException e)
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
				return verticalsMap;
				
			}
			
			
			
			//get All modules
			@SuppressWarnings("unchecked")
			public Map<String,String> getAllModule()throws NoModuleAvailableException,Exception
			{
				EntityManager em=null;
				Map<String, String> moduleMap = new TreeMap<String, String>();
				try 
				{
					EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
					em=emf.createEntityManager();
					EntityTransaction et= em.getTransaction();
					et.begin();
					
					Query query= em.createQuery("select m from Module m ");
							
					List<Module> rs1 = query.getResultList();
					
					if(!rs1.isEmpty())
					{
						for(Module module : rs1)
							{
							moduleMap.put(module.getModuleId(), module.getModuleName());
							}
					}
					else
					{
						throw new NoModuleAvailableException();
					}
					
					et.commit();
						
				}
				catch(NoModuleAvailableException e)
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
				return moduleMap;
				
			}
			
			
			
			// get vertical name by id
			
			
			public Map<String,String> getAllModulesByVertical(String verticalId)throws NoSubModuleAvailableForGivenModuleException,Exception
			{
				EntityManager em=null;
				Map<String, String> modulesMap = new TreeMap<String, String>();
				try 
				{
					EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
					em=emf.createEntityManager();
					EntityTransaction et= em.getTransaction();
					et.begin();
					//"select mr from MasterRequirement mr, GroupInfo gi where mr.groupId = gi.groupId and "
					Query query= em.createQuery("select m from Module m, VerticalModuleMapping vm where m.moduleId = vm.moduleId and vm.verticalId = ?1 ");
					query.setParameter(1,verticalId);
							
					List<Module> rs1 = query.getResultList();
					
					if(!rs1.isEmpty())
					{
						for(Module module : rs1)
						{
							modulesMap.put(module.getModuleId(), module.getModuleName());
						}
					}
					else
					{
						throw new NoSubModuleAvailableForGivenModuleException();
					}
					
					et.commit();
						
				}
				catch(NoSubModuleAvailableForGivenModuleException e)
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
				return modulesMap;
				
			}
			// get module name by module id
						@SuppressWarnings("unchecked")
						public String getModuleNameByModuleId(String moduleId)throws NoModuleAvailableException,Exception
						{
							
							EntityManager em=null;
							String moduleName=null;
							try 
							{
								EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
								em=emf.createEntityManager();
								EntityTransaction et= em.getTransaction();
														
								et.begin();
								Query query= em.createQuery("select m from Module m where m.moduleId= ?1");
								
								query.setParameter(1, moduleId);
								
								List<Module> rs1 = query.getResultList();
								//System.out.println("module list: "+rs1.size());
								
								if(!rs1.isEmpty() && rs1.size()!=0)
								{
									for(Module module : rs1)
										{
										moduleName =module.getModuleName();
										//System.out.println("module name: "+module.getModuleName());
										}
								}
								
								/*else
								{
									throw new NoModuleAvailableException();
								}*/
								et.commit();
								
								
								return moduleName;
										
							}
							
							/*catch( NoModuleAvailableException e)
							{
								throw e;
							}*/
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
						
						// get solution name by id
						@SuppressWarnings("unchecked")
						public String getVerticalNameById(String verticalId)throws NoSolutionsAvailableException,Exception
						{
							
							EntityManager em=null;
							String verticalName=null;
							try 
							{
								EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
								em=emf.createEntityManager();
								EntityTransaction et= em.getTransaction();
														
								et.begin();
								Query query= em.createQuery("select v from Vertical v where v.verticalId= ?1");
								query.setParameter(1, verticalId);
								
								List<Vertical> rs1 = query.getResultList();
								
								if(!rs1.isEmpty())
								{
									for(Vertical vertical : rs1)
										{
										verticalName =vertical.getVerticalName();
										}
								}
								else
								{
									throw new NoModuleAvailableException();
								}
								et.commit();
								
								
								return verticalName;
										
							}
							
							catch( NoModuleAvailableException e)
							{
								throw e;
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
						
						public VerticalTO getVerticalIdByName(String verticalName)throws NoSolutionsAvailableException, Exception
						   {
						        EntityManager em=null;
						        VerticalTO verticalTo = new VerticalTO();
						         try 
						         {
						               EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
						               em=emf.createEntityManager();
						               EntityTransaction et= em.getTransaction();

						               //et.begin();
						               Query query= em.createQuery("select v from Vertical v where v.verticalName= ?1");
						               query.setParameter(1,verticalName);

						               List<Vertical> rs1 = query.getResultList();
						              // System.out.println("total size of solution querylist is: "  + rs1.size());
						               if(!rs1.isEmpty())
						               {
						                     for(Vertical vertical : rs1)
						                     {
						                    	 verticalTo.setVerticalId(vertical.getVerticalId()); 
						                    	 verticalTo.setVerticalName(vertical.getVerticalName());
						                    	                
						                     }
						                     return verticalTo;
						               }
						               else
						               {
						            	   throw new NoSolutionsAvailableException();
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
						
						public String getMRByTitleAndDesc(String moduleId)throws NoModuleAvailableException,Exception
						{
							
							EntityManager em=null;
							String moduleName=null;
							try 
							{
								EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
								em=emf.createEntityManager();
								EntityTransaction et= em.getTransaction();
														
								et.begin();
								Query query= em.createQuery("select m from Module m where m.moduleId= ?1");
								
								query.setParameter(1, moduleId);
								
								List<Module> rs1 = query.getResultList();
								//System.out.println("module list: "+rs1.size());
								
								if(!rs1.isEmpty() && rs1.size()!=0)
								{
									for(Module module : rs1)
										{
										moduleName =module.getModuleName();
										//System.out.println("module name: "+module.getModuleName());
										}
								}
								
								/*else
								{
									throw new NoModuleAvailableException();
								}*/
								et.commit();
								
								
								return moduleName;
										
							}
							
							/*catch( NoModuleAvailableException e)
							{
								throw e;
							}*/
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
						
						
	// get All solutions
	@SuppressWarnings("unchecked")
	public Map<String, String> getAllEmailIds()throws NoSolutionsAvailableException, Exception {
		EntityManager em = null;
		Map<String, String> loginMap = new TreeMap<String, String>();
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("FRMS");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();

			Query query = em.createQuery("select l from Login l ");

			List<Login> rs1 = query.getResultList();

			if (!rs1.isEmpty()) {
				for (Login login : rs1) {
					loginMap.put(login.getEmailId(),
							login.getEmailId());
				}
			} else {
				throw new NoSolutionsAvailableException();
			}

			et.commit();

		} catch (NoSolutionsAvailableException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return loginMap;

	}

	// get group name by id
		@SuppressWarnings("unchecked")
		public String getEmailIdByEmpId(String empId)throws UserDoesNotExistException,Exception
		{
			
			EntityManager em=null;
			String emailId=null;
			try 
			{
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
				em=emf.createEntityManager();
				EntityTransaction et= em.getTransaction();
				System.out.println("selected emsail id"+empId);
										
				et.begin();
				Query query= em.createQuery("select lo.emailId from Login lo where lo.empId= ?1");
				query.setParameter(1, empId);
				
				List<Login> rs1 = query.getResultList();
				
				if(!rs1.isEmpty())
				{
					for(Login login : rs1)
						{
						emailId =login.getEmailId();
						}
				}
				else
				{
					throw new UserDoesNotExistException();
				}
				et.commit();
				
				
				return emailId;
						
			}
			
			catch( UserDoesNotExistException e)
			{
				throw e;
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
