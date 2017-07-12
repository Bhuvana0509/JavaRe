package com.infy.manager;

import java.util.ArrayList;
import java.util.Map;

import java.util.List;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.exceptions.InvalidProductRequirementIdException;
import com.infy.exceptions.NoProductReqAvailableException;
import com.infy.exceptions.NoProductRequirementAssignedException;
import com.infy.exceptions.NoProductRequirementFoundException;
import com.infy.exceptions.NoProductRequirementsToApproveException;
import com.infy.exceptions.NoVersionFoundException;
import com.infy.service.ProductRequirementService;

public class ProductRequirementManager {
	public List<String> getAllVersions()throws NoVersionFoundException,Exception
	{
		try
		{
			List<String> verstionList=new ProductRequirementService().getAllVersions();
			if(verstionList.isEmpty())
			{
				throw new NoVersionFoundException();
			}
			return verstionList;
		}
		catch (NoVersionFoundException e) {

			throw e;
		}
		catch (Exception e) {
			throw e;
		}

	}
	
	/*public Map<String,String> getAllVersions()throws NoVersionFoundException,Exception
	{
		try
		{
			Map<String,String> versionMap=new ProductRequirementService().getAllVersions();
			if(versionMap.isEmpty())
			{
				throw new NoVersionFoundException();
			}
			return versionMap;
		}
		catch (NoVersionFoundException e) {

			throw e;
		}
		catch (Exception e) {
			throw e;
		}

	}*/

	
	
	public ProductRequirementTO getProductRequirmentById(String requirmentId) throws NoProductRequirementFoundException,Exception {

		ProductRequirementTO productRequirementTO=null;
		try 
		{
			ProductRequirementService productRequirementService=new ProductRequirementService();
			productRequirementTO=productRequirementService.getProductRequirmentById(requirmentId);
			if(productRequirementTO==null)
			{
				throw new NoProductRequirementFoundException();
			}
			return productRequirementTO;
		}
		catch (NoProductRequirementFoundException e) {
			// TODO: handle exception
			throw e;
		}
		catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public boolean updateProductRequirement(ProductRequirementTO productRequirementTO) throws InvalidProductRequirementIdException,Exception
	{
		try
		{
			boolean result=new ProductRequirementService().updateProductRequirement(productRequirementTO);
			if(result==false)
			{
				throw new InvalidProductRequirementIdException();
			}
			return result;
		}
		catch(InvalidProductRequirementIdException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public List<ProductRequirementTO> getProductRequirementsByMasterId(String masterRequirementId) throws NoProductRequirementFoundException, Exception
	{
		try
		{
			List<ProductRequirementTO> productRequirementToList=new ProductRequirementService().getProductRequirementsByMasterId(masterRequirementId);
			if(productRequirementToList==null)
			{
				throw new NoProductRequirementFoundException();
			}
			return productRequirementToList;
		}
		catch (NoProductRequirementFoundException e) {
			throw e;
		}
		catch (Exception e) {
			throw e;
		}
	}
	public void saveSplitedRequriements(List<ProductRequirementTO> productRequirementTOList) throws Exception
	{
		try
		{
			new ProductRequirementService().saveSplitedRequriements(productRequirementTOList);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	//get all product requirements
	public List<ProductRequirementTO> getAllProductRequirements()throws NoProductReqAvailableException,Exception
	{
		
		List<ProductRequirementTO> toProductReq = new ArrayList<ProductRequirementTO>() ;
		try 
		{
			ProductRequirementService  service = new ProductRequirementService();
			toProductReq=service.getAllProductRequirements();
				
		}
		catch(NoProductReqAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
			
		return toProductReq;
	}
	
	//Product Requirement Assigned to Employee
	public List<ProductRequirementTO> getAllProductRequirementAssignedToEmployee(String employeeId) throws NoProductRequirementAssignedException,Exception
	{
		List<ProductRequirementTO> produtctReqTOList=null;
		try
		{
			ProductRequirementService service=new ProductRequirementService();
			produtctReqTOList=service.getAllProductRequirementAssignedToEmployee(employeeId);
			if(produtctReqTOList.isEmpty())
			{
				throw new NoProductRequirementAssignedException();
			}
			return produtctReqTOList;
		}
		catch(NoProductRequirementAssignedException e){
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	

	
	
	//view and update
    
    
    
    
    public List<ProductRequirementTO> getProductRequirements(String... searchObjects)throws Exception
    {
          try 
          {

                List<ProductRequirementTO> productReqTOList=new ProductRequirementService().getProductRequirements(searchObjects);
                if(productReqTOList.isEmpty())
                {
                      throw new NoProductRequirementFoundException();
                }
                return productReqTOList;
          }
          catch (NoProductRequirementFoundException e) {

                throw e;
          }
          catch(Exception e)
          {
                throw e;
          }

    }

    public ProductRequirementTO saveNewProductRequirement(ProductRequirementTO productRequirementTO)throws Exception
	{
		try
		{
			ProductRequirementTO requirementTO=new ProductRequirementService().saveNewProductRequirement(productRequirementTO);
			return requirementTO;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
    
    public void uploaProductReqList(List<ProductRequirementTO> productReqListTo) throws Exception
	{	
		ProductRequirementService service = new ProductRequirementService();
		try 
		{
			service.uploadProductReqList(productReqListTo);
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}
    
    
    public int checkMRid(String masterReq) throws Exception
  	{	int mrIdStatus =0 ;
  		ProductRequirementService service = new ProductRequirementService();
  		try 
  		{
  			mrIdStatus=service.checkMRid(masterReq);
  		} 
  		catch (Exception e) 
  		{
  			throw e;
  		}
  		return mrIdStatus;
  	}

}
