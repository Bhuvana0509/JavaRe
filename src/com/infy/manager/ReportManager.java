package com.infy.manager;

import java.util.List;

import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.MasterRequirementTO;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoMasterReqAvailableException;
import com.infy.exceptions.NoProductReqAvailableException;
import com.infy.service.ReportsService;

public class ReportManager 
{
	public String downloadGroupDetailsReport(List<GroupInfoTO> groupList) throws NoGroupsAvailableException,Exception
		{
			ReportsService service = new ReportsService();
			try 
			{
				String fileName=service.downloadGroupDetailsReport(groupList);
				return fileName;
			} 
			catch (NoGroupsAvailableException e) 
			{
				throw e;
			} 
			catch (Exception e) 
			{
				throw e;
			}
		}
	
	//Master Requirements REPORT
	public String downloadMasterRequirementsReport(List<MasterRequirementTO> masterReqList)throws NoMasterReqAvailableException,Exception
	{
		ReportsService service = new ReportsService();
		try 
		{
			String fileName=service.downloadMasterRequirementsReport(masterReqList);
			return fileName;
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
	
	
	//Product Requirements REPORT
	public String downloadProductRequirementsReport(List<ProductRequirementTO> productReqList)throws NoProductReqAvailableException,Exception
	{
		ReportsService service = new ReportsService();
		try 
		{
			String fileName=service.downloadProductRequirementsReport(productReqList);
			return fileName;
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
	
	//download product requirement report as RCD Tracker	
		public String downloadProductReqListAsRCDTracker(List<ProductRequirementTO> productReqList)throws NoProductReqAvailableException,Exception
		{
			ReportsService service = new ReportsService();
			try 
			{
				String fileName=service.downloadProductReqListAsRCDTracker(productReqList);
				return fileName;
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
		
		//download product requirement report as RCD Tracker	
				public String downloadProductReqListAsRSTracker(List<ProductRequirementTO> productReqList)throws NoProductReqAvailableException,Exception
				{
					ReportsService service = new ReportsService();
					try 
					{
						String fileName=service.downloadProductReqListAsRSTracker(productReqList);
						return fileName;
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
	
	// download master requirement template
	public String downloadMRTemplate()throws Exception,NoGroupsAvailableException
	{
			
		try
		{
			ReportsService service = new ReportsService();
			String fileName=service.downloadMRTemplate();
			if(fileName==null)
			{
				throw new NoGroupsAvailableException();
			}
			return fileName;
		}
		catch(NoGroupsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	// download product requirement template
		public String downloadPRTemplate()throws Exception,NoGroupsAvailableException
		{
				
			try
			{
				ReportsService service = new ReportsService();
				String fileName=service.downloadPRTemplate();
				if(fileName==null)
				{
					throw new NoGroupsAvailableException();
				}
				return fileName;
			}
			catch(NoGroupsAvailableException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
			
		}
	
}
