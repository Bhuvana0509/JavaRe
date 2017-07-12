package com.infy.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.infy.TOclasses.MasterRequirementAttachmentTO;
import com.infy.TOclasses.MasterRequirementTO;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.exceptions.NoAttachmentFoundException;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoMasterReqAvailableException;
import com.infy.exceptions.NoModuleAvailableException;
import com.infy.exceptions.NoModulesAvailableForGivenSolutionException;
import com.infy.exceptions.NoProductReqAvailableException;
import com.infy.exceptions.NoProductRequirementAssignedToYou;
import com.infy.exceptions.NoSolutionsAvailableException;
import com.infy.exceptions.NoSubModuleAvailableForGivenModuleException;
import com.infy.exceptions.masterRequirementNotAddedException;
import com.infy.service.MasterRequirementService;

public class MasterRequirementManager 
{
	//get All Group names
	public Map<String,String> getAllGroupNames()throws NoGroupsAvailableException,Exception
	{
		
		Map<String, String> groupNamesMap = new TreeMap<String, String>();
		try 
		{
			MasterRequirementService service = new MasterRequirementService();
			groupNamesMap=service.getAllGroupNames();
		}
		catch(NoGroupsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return groupNamesMap;
		
	}
	
	
	//get All solutions
	public Map<String,String> getAllSolutions()throws NoSolutionsAvailableException,Exception
	{
		Map<String, String> solutionsMap = new TreeMap<String, String>();
		try 
		{
			MasterRequirementService service = new MasterRequirementService();
			solutionsMap=service.getAllSolutions();
				
		}
		catch(NoSolutionsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return solutionsMap;
		
	}
	
	//get All email ids
		public Map<String,String> getAllEmailIds()throws NoSolutionsAvailableException,Exception
		{
			Map<String, String> loginMap = new TreeMap<String, String>();
			try 
			{
				MasterRequirementService service = new MasterRequirementService();
				loginMap=service.getAllEmailIds();
					
			}
			catch(NoSolutionsAvailableException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
			
			return loginMap;
			
		}
	
	//get All verticals
		public Map<String,String> getAllVerticals()throws NoSolutionsAvailableException,Exception
		{
			Map<String, String> verticalsMap = new TreeMap<String, String>();
			try 
			{
				MasterRequirementService service = new MasterRequirementService();
				verticalsMap=service.getAllVerticals();
					
			}
			catch(NoSolutionsAvailableException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
			
			return verticalsMap;
			
		}
		
		
		//get All module
				public Map<String,String> getAllModule()throws NoModuleAvailableException,Exception
				{
					Map<String, String> moduleMap = new TreeMap<String, String>();
					try 
					{
						MasterRequirementService service = new MasterRequirementService();
						moduleMap=service.getAllModule();
							
					}
					catch(NoModuleAvailableException e)
					{
						throw e;
					}
					catch(Exception e)
					{
						throw e;
					}
					
					return moduleMap;
					
				}
		
		//get all submodules for selected module
		public Map<String,String> getAllModulesByVertical(String verticalId)throws NoSubModuleAvailableForGivenModuleException,Exception
		{
			Map<String, String> modulesMap = new TreeMap<String, String>();
			try 
			{
				MasterRequirementService service = new MasterRequirementService();
				modulesMap = service.getAllModulesByVertical(verticalId);
			}
			catch(NoSubModuleAvailableForGivenModuleException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
			
			return modulesMap;
		}
	
	//get All modules of selected solution
	public Map<String,String> getAllModulesBySolution(String solutionId)throws NoModulesAvailableForGivenSolutionException,Exception
	{
		Map<String, String> modulesMap = new TreeMap<String, String>();
		try 
		{
			MasterRequirementService service = new MasterRequirementService();
			modulesMap = service.getAllModulesBySolution(solutionId);
			System.out.println("solution id MR Manager: "+solutionId);
		}
		catch(NoModulesAvailableForGivenSolutionException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return modulesMap;
		
	}
	
	//get All verticals of selected solution
	public Map<String,String> getAllVerticalsBySolution(String solutionId)throws NoModulesAvailableForGivenSolutionException,Exception
	{
		Map<String, String> verticalsMap = new TreeMap<String, String>();
		try 
		{
			MasterRequirementService service = new MasterRequirementService();
			verticalsMap = service.getAllVerticalsBySolution(solutionId);
			System.out.println("solution id MR Manager: "+solutionId);
		}
		catch(NoModulesAvailableForGivenSolutionException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return verticalsMap;
		
	}
	
	//changes done by sanket mehta
	//get all submodules for selected module
	public Map<String,String> getAllSubModulesByModule(String moduleId)throws NoSubModuleAvailableForGivenModuleException,Exception
	{
		Map<String, String> modulesMap = new TreeMap<String, String>();
		try 
		{
			MasterRequirementService service = new MasterRequirementService();
			modulesMap = service.getAllSubModulesByModule(moduleId);
		}
		catch(NoSubModuleAvailableForGivenModuleException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return modulesMap;
	}
	//changes completed
	
	//get All modules 
	public Map<String,String> getAllModules()throws NoModulesAvailableForGivenSolutionException,Exception
	{
		Map<String, String> modulesMap = new TreeMap<String, String>();
		try 
		{
			MasterRequirementService service = new MasterRequirementService();
			modulesMap = service.getAllModules();
		}
		catch(NoModulesAvailableForGivenSolutionException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return modulesMap;
		
	}
	
	//get All Master Requirements By Group
	public List<MasterRequirementTO> getAllMasterReqByGroup (String groupId)throws NoMasterReqAvailableException,Exception
	{
		
		List<MasterRequirementTO> masterReqTOList=null;
		try 
		{
			MasterRequirementService service = new MasterRequirementService();
			masterReqTOList=service.getAllMasterReqByGroup(groupId);
				
		}
		catch(NoMasterReqAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		
		return masterReqTOList;
		
	}
	
	
	//get All Master Requirements By status
	public List<MasterRequirementTO> getAllMasterReqByStatus (String status)throws NoMasterReqAvailableException,Exception
	{
		
		List<MasterRequirementTO> masterReqTOList=null;
		try 
		{
			MasterRequirementService service = new MasterRequirementService();
			masterReqTOList=service.getAllMasterReqByStatus(status);
				
		}
		catch(NoMasterReqAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		
		return masterReqTOList;
		
	}
	
	
	//get All Master Requirements By Module
	public List<MasterRequirementTO> getAllMasterReqByModule (String moduleId)throws NoMasterReqAvailableException,Exception
	{
		
		List<MasterRequirementTO> masterReqTOList=null;
		try 
		{
			MasterRequirementService service = new MasterRequirementService();
			masterReqTOList=service.getAllMasterReqByModule(moduleId);
				
		}
		catch(NoMasterReqAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		
		return masterReqTOList;
		
	}
	
	
	//get Master Req Details By Id
	public MasterRequirementTO getMasterReqDetailsById(String masterReqId)throws NoMasterReqAvailableException,Exception
	{
		
		MasterRequirementTO masterReqTo = new MasterRequirementTO();
		try 
		{
			MasterRequirementService service = new MasterRequirementService();
			masterReqTo=service.getMasterReqDetailsById(masterReqId);
		}
		catch(NoMasterReqAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	
		return masterReqTo;
	}

	//add master requirement
	public String addMasterRequirement(MasterRequirementTO masterReqTo, String emailId) throws Exception
	{
		String masterReqId=null;
		try 
		{
			MasterRequirementService service = new MasterRequirementService();
			masterReqId=service.addMasterRequirement(masterReqTo,emailId);			
			return masterReqId;
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
	}
	public void updateMasterRequirement(MasterRequirementTO masterRequirementTO) throws Exception
	{
		try
		{
			MasterRequirementService masterRequirementService=new MasterRequirementService();
			masterRequirementService.updateMasterRequirement(masterRequirementTO);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	 public List<MasterRequirementTO> getAllMasterRequirements()throws NoMasterReqAvailableException,Exception
	 {
		 try
		 {
			 return new MasterRequirementService().getAllMasterRequirements();
		 }
		 catch (NoMasterReqAvailableException e) 
		 {
			throw e;
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
		 
	 }
	 
	 public void abandonMasterRequirement(MasterRequirementTO masterRequirementTO) throws Exception
	 {
		 try
		 {
			new MasterRequirementService().abandonMasterRequirement(masterRequirementTO); 
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }
	 public List<MasterRequirementTO> getMasterRequirementListByOwner(String ownerEmpId) throws NoMasterReqAvailableException, Exception
	 {
		 try
		 {
			 List<MasterRequirementTO> masterRequirementTOList=new MasterRequirementService().getMasterRequirementListByOwner(ownerEmpId);
			 if(masterRequirementTOList.isEmpty())
			 {
				 throw new masterRequirementNotAddedException(); 
			 }
			 return masterRequirementTOList;
		 }
		 catch (NoMasterReqAvailableException e) 
		 {
			 throw e;

		 }
		 catch (Exception e) 
		 {
			 throw e;
		 }
	 }
	 
	 public List<ProductRequirementTO> getProductRequirementsAssignedToMe(String ownerEmpId) throws NoProductReqAvailableException, Exception
	 {
		 try
		 {
			
			 List<ProductRequirementTO> productRequirementTOList = new ArrayList<ProductRequirementTO>();
			 productRequirementTOList=new MasterRequirementService().getProductRequirementsAssignedToMe(ownerEmpId);
			 
			 if(productRequirementTOList!=null && productRequirementTOList.isEmpty())
			 {
					 
				 throw new NoProductRequirementAssignedToYou(); 
			 }
			
			 return productRequirementTOList;
		 }
		 catch (NoProductReqAvailableException e) 
		 {
			 throw e;

		 }
		 catch (Exception e) 
		 {
			 throw e;
		 }
	 }
	 
	 //get product scope items list
	 public List<ProductRequirementTO> getProductScopeItemsList(String ownerEmpId) throws NoProductReqAvailableException, Exception
	 {
		 try
		 {  
			 //System.out.println("I wanted to populate the product scope list 1"+ownerEmpId);
			 List<ProductRequirementTO> productRequirementTOList=new MasterRequirementService().getProductScopeItemsList(ownerEmpId);
			 if(productRequirementTOList!=null && productRequirementTOList.isEmpty())
			 {
					 
				 throw new NoProductRequirementAssignedToYou(); 
			 }
			 return productRequirementTOList;
		 }
		 catch (NoProductReqAvailableException e) 
		 {
			 throw e;

		 }
		 catch (Exception e) 
		 {
			 throw e;
		 }
	 }
	 
	 
	 public void uploadMasterReqList(List<MasterRequirementTO> masterReqListTo) throws Exception
		{	
			MasterRequirementService service = new MasterRequirementService();
			try 
			{
				service.uploadMasterReqList(masterReqListTo);
			} 
			catch (Exception e) 
			{
				throw e;
			}
		}
	 
	
	 
	 public List<MasterRequirementTO> getMasterRequirements(String... searchObjects)throws NoMasterReqAvailableException,Exception
	 {
		 try
		 {
			 List<MasterRequirementTO> masterRequirementTOList=new MasterRequirementService().getMasterRequirements(searchObjects);
			 
			 if(masterRequirementTOList.isEmpty())
			 {
				 throw new NoMasterReqAvailableException(); 
			 }
             System.out.println("getMasterRequirements"+masterRequirementTOList.size());
			 return masterRequirementTOList;
		 }
		 catch (NoMasterReqAvailableException e) 
		 {
			 throw e;

		 }
		 catch (Exception e) 
		 {
			 throw e; 
		 }
	 }
	 
	 public MasterRequirementAttachmentTO uploadMasterRequirementAttachment(MasterRequirementAttachmentTO attachmentTO) throws Exception
	  {
		 try
		 {
			 MasterRequirementAttachmentTO masterRequirementAttachmentTO=new MasterRequirementService().uploadMasterRequirementAttachment(attachmentTO);
			 return masterRequirementAttachmentTO;
			 
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	  }

	 public List<MasterRequirementAttachmentTO> getAttachmentsByMasterReqId(String masterRequirementId)throws Exception,NoAttachmentFoundException
	 {
		 try
		 {
			 List<MasterRequirementAttachmentTO> attachmentTOList=new MasterRequirementService().getAttachmentsByMasterReqId(masterRequirementId);
			 if(attachmentTOList.isEmpty())
			 {
				 throw new NoAttachmentFoundException();
			 }
			 return attachmentTOList;
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }
	 // changes done by Bhuvana starts
	 
	 public Map<String,String> getSubModulesByModule(String moduleId)throws NoGroupsAvailableException,Exception
		{

			Map<String,String> subModulesMap = new TreeMap<String, String>();

			try 
			{
				MasterRequirementService service = new MasterRequirementService();
				subModulesMap = service.getSubModulesBymodule(moduleId);
				return subModulesMap;

			}

			catch( NoGroupsAvailableException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}

		}
}
