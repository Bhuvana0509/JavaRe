package com.infy.manager;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.infy.TOclasses.GroupDetailsAttachmentTO;
import com.infy.TOclasses.GroupInfoTO;
import com.infy.exceptions.GroupNameNotAvailableException;
import com.infy.exceptions.NoAttachmentFoundException;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoInitiatingGroupsAvailableException;
import com.infy.exceptions.NoLocationsAvailableException;
import com.infy.exceptions.NoSourceAvailableException;
import com.infy.service.GroupInfoService;


public class GroupInfoManager 
{
	public Map<String,String> getAllInitiatingGroups()throws NoInitiatingGroupsAvailableException,Exception
	{
		Map<String, String> initatingGroupsMap = new TreeMap<String, String>();
		try 
		{
			GroupInfoService service = new GroupInfoService();
			initatingGroupsMap=service.getAllInitiatingGroups();


		}
		catch(NoInitiatingGroupsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}


		return initatingGroupsMap;

	}

	public Map<String,String> getAllSource()throws NoSourceAvailableException,Exception
	{

		Map<String, String> sourceMap = new TreeMap<String, String>();
		try 
		{
			GroupInfoService service = new GroupInfoService();
			sourceMap=service.getAllSource();
		}
		catch(NoSourceAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}

		return sourceMap;

	}

	public Map<String,String> getAllLocations()throws NoLocationsAvailableException,Exception
	{

		Map<String, String> locationMap = new TreeMap<String, String>();
		try 
		{
			GroupInfoService service = new GroupInfoService();
			locationMap=service.getAllLocations();

		}
		catch(NoLocationsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}

		return locationMap;

	}
	
	//get all localizations
	
	public Map<String,String> getAllLocalizations()throws NoLocationsAvailableException,Exception
	{

		Map<String, String> localizationMap = new TreeMap<String, String>();
		try 
		{
			GroupInfoService service = new GroupInfoService();
			localizationMap=service.getAllLocalizations();

		}
		catch(NoLocationsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}

		return localizationMap;

	}


	public GroupInfoTO addGroup(GroupInfoTO groupInfoTo)throws Exception
	{

		GroupInfoTO groupTO;
		try 
		{
			GroupInfoService service = new GroupInfoService();
			groupTO=service.addGroup(groupInfoTo);
			return groupTO;	
		}

		catch(Exception e)
		{
			throw e;
		}


	}
	public void updateGroup(GroupInfoTO groupInfoTo)throws Exception
	{

		try 
		{
			GroupInfoService service = new GroupInfoService();
			service.updateGroup(groupInfoTo);

		}

		catch(Exception e)
		{
			throw e;
		}


	}

	public Map<String,String> getGroupNamesByGeography(String locationId)throws NoGroupsAvailableException,Exception
	{

		Map<String,String> groupMap = new TreeMap<String, String>();

		try 
		{
			GroupInfoService service = new GroupInfoService();
			groupMap = service.getGroupNamesByGeography(locationId);
			return groupMap;

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

	public GroupInfoTO getGroupDetailsById(String groupId)throws NoGroupsAvailableException , Exception
	{

		GroupInfoTO toObj = new GroupInfoTO();
		GroupInfoService service = new GroupInfoService();

		try
		{
			toObj=service.getGroupDetailsById(groupId);
		} 
		catch (NoGroupsAvailableException e)
		{
			throw e;

		} 
		catch (Exception e)
		{
			throw e;

		} 

		return toObj;

	}

	public Map<String,String> getAllGroupsMap() throws NoGroupsAvailableException, Exception
	{
		try
		{
			List<GroupInfoTO> groupList=new GroupInfoService().getAllGroups();
			if(groupList.isEmpty())
			{
				throw new NoGroupsAvailableException();
			}
			Map<String,String> groupMap=new TreeMap<String, String>();
			for (GroupInfoTO groupInfoTO : groupList) {
				groupMap.put(groupInfoTO.getGroupId(),groupInfoTO.getGroupName());
			}
			return groupMap;
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
	
	public List<GroupInfoTO> getAllGroups() throws NoGroupsAvailableException, Exception
	{
		List<GroupInfoTO> groupList = new ArrayList<GroupInfoTO>();
		try
		{
			groupList=new GroupInfoService().getAllGroups();
			
			return groupList;
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
	
	public GroupInfoTO getGroupByName(String groupName)throws GroupNameNotAvailableException,Exception
	{
		try
		{
			GroupInfoTO groupInfoTO=new GroupInfoService().getGroupByName(groupName);
			if(groupInfoTO==null)
			{
				throw new GroupNameNotAvailableException();
			}
			return groupInfoTO;
		}
		catch(GroupNameNotAvailableException e){
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	//get All Groups By Location
	@SuppressWarnings("unchecked")
	public List<GroupInfoTO> getAllGroupsByLocation(String locationId) throws Exception,NoGroupsAvailableException
	{

		
		List<GroupInfoTO> toGroupList = new ArrayList<GroupInfoTO>() ;

		try 
		{
			GroupInfoService service = new GroupInfoService();
			toGroupList=service.getAllGroupsByLocation(locationId);
		}
		catch(NoGroupsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return toGroupList;
	}
	 public GroupDetailsAttachmentTO uploadGroupAttachment(GroupDetailsAttachmentTO attachmentTO) throws Exception
	 {
		 try
		 {
			 GroupDetailsAttachmentTO detailsAttachmentTO=new GroupInfoService().uploadGroupAttachment(attachmentTO);
			 return detailsAttachmentTO;
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }
	 public List<GroupDetailsAttachmentTO> getAttachmentsByGroupId(String groupId)throws NoAttachmentFoundException,Exception
	 {
		 try
		 {
			 List<GroupDetailsAttachmentTO> attachmentTOList=new GroupInfoService().getAttachmentsByGroupId(groupId);
			 if(attachmentTOList.isEmpty())
			 {
				 throw new NoAttachmentFoundException();
			 }
			 return attachmentTOList;
		 }
		 catch(NoAttachmentFoundException e)
		 {
			 throw e;
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }
	 public int removeGroupAttachmentById(String attachmentId)throws Exception
	 {
		 try
		 {
		  int count=new GroupInfoService().removeGroupAttachmentById(attachmentId);
		  return count;
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }
}
