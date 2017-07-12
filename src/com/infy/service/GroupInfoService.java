package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.io.FilenameUtils;

import com.infy.TOclasses.GroupDetailsAttachmentTO;
import com.infy.TOclasses.GroupInfoTO;
import com.infy.entity.GroupDetailsAttachment;
import com.infy.entity.GroupInfo;
import com.infy.entity.InitiatingGroup;
import com.infy.entity.Localization;
import com.infy.entity.Location;
import com.infy.entity.Source;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoInitiatingGroupsAvailableException;
import com.infy.exceptions.NoLocationsAvailableException;
import com.infy.exceptions.NoSourceAvailableException;



public class GroupInfoService 
{
	private static Integer minimum=1;
	private static Integer maximum=1000;
	//getAllGroups()
	@SuppressWarnings("unchecked")
	public List<GroupInfoTO> getAllGroups() throws Exception
	{

		EntityManager em=null;
		List<GroupInfoTO> toGroupList = new ArrayList<GroupInfoTO>() ;

		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			Query query= em.createQuery("select gp from GroupInfo gp");

			List<GroupInfo> rs1 = query.getResultList();

			for(GroupInfo groupList : rs1)
			{
				GroupInfoTO toObj = new GroupInfoTO();
				toObj.setGroupId(groupList.getGroupId());
				toObj.setGroupName(groupList.getGroupName());
				toObj.setDescription(groupList.getDescription());
				toObj.setComment(groupList.getComments());
				toObj.setCustomer_prospect(groupList.getCustomer_prospect());
				toObj.setInitatingGroupId(groupList.getInitiatingGroupId());
				toObj.setLocationId(groupList.getLocationId());
				toObj.setOwnerEmployeeId(groupList.getOwnerEmployeeId());
				toObj.setSourceId(groupList.getSourceId());
				toObj.setSPOC(groupList.getSPOC());
				toObj.setInitiatingGroupName(getInitiatingGroupNameById(groupList.getInitiatingGroupId()));
				toObj.setSourceName(getSourceNameById(groupList.getSourceId()));
				toObj.setLocationName(getLocationNameById(groupList.getLocationId()));

				toGroupList.add(toObj);

			}
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
		return toGroupList;
	}



	//get All Initiating Groups
	@SuppressWarnings("unchecked")
	public Map<String,String> getAllInitiatingGroups()throws NoInitiatingGroupsAvailableException,Exception
	{
		EntityManager em=null;
		Map<String, String> initatingGroupsMap = new TreeMap<String, String>();
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();

			Query query= em.createQuery("select ig from InitiatingGroup ig ");

			List<InitiatingGroup> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
				for(InitiatingGroup group : rs1)
				{
					initatingGroupsMap.put(group.getInitiatingGroupId(), group.getInitiatingGroupName());

				}
			}
			else
			{
				throw new NoInitiatingGroupsAvailableException();
			}

			et.commit();

		}
		catch(NoInitiatingGroupsAvailableException e)
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
		return initatingGroupsMap;

	}

	//get all Source
	@SuppressWarnings("unchecked")
	public Map<String,String> getAllSource()throws NoSourceAvailableException,Exception
	{
		EntityManager em=null;
		Map<String, String> sourceMap = new TreeMap<String, String>();
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();

			Query query= em.createQuery("select s from Source s ");

			List<Source> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
				for(Source src : rs1)
				{
					sourceMap.put(src.getSourceId(),src.getSourceName());

				}
			}
			else
			{
				throw new NoSourceAvailableException();
			}

			et.commit();

		}
		catch(NoSourceAvailableException e)
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
		return sourceMap;

	}

	//get all location
	@SuppressWarnings("unchecked")
	public Map<String,String> getAllLocations()throws NoLocationsAvailableException,Exception
	{
		EntityManager em=null;
		Map<String, String> locationMap = new TreeMap<String, String>();
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();

			Query query= em.createQuery("select l from Location l ");

			List<Location> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
				for(Location loc : rs1)
				{
					locationMap.put(loc.getLocationId(),loc.getLocationName());

				}
			}
			else
			{
				throw new NoSourceAvailableException();
			}

			et.commit();

		}
		catch(NoSourceAvailableException e)
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
		return locationMap;

	}
	
	//get all localizations
	
	//get all location
		@SuppressWarnings("unchecked")
		public Map<String,String> getAllLocalizations()throws NoLocationsAvailableException,Exception
		{
			EntityManager em=null;
			Map<String, String> localizationMap = new TreeMap<String, String>();
			try 
			{
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
				em=emf.createEntityManager();
				EntityTransaction et= em.getTransaction();
				et.begin();

				Query query= em.createQuery("select l from Localization l ");

				List<Localization> rs1 = query.getResultList();

				if(!rs1.isEmpty())
				{
					for(Localization loc : rs1)
					{
						localizationMap.put(loc.getLocalizationId(),loc.getLocalizationName());

					}
				}
				else
				{
					throw new NoSourceAvailableException();
				}

				et.commit();

			}
			catch(NoSourceAvailableException e)
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
			return localizationMap;

		}

	//addGroup
	public GroupInfoTO addGroup(GroupInfoTO groupInfoTo)throws Exception
	{

		EntityManager em=null;
		GroupInfo groupInfoEntityObj = new GroupInfo();
		String groupId;
		int id=0;
		 
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();

			Query query=em.createQuery("select MAX(g.groupId) from  GroupInfo g");
			groupId = (String)query.getSingleResult();
			
			if(groupId==null)
			{

				groupId="";
				id=100;
			}
			else
			{
				id=Integer.parseInt( groupId.substring(2,groupId.length()));
				id++;
			}
			String newId="GR"+String.valueOf(id);

			EntityTransaction et= em.getTransaction();

			groupInfoEntityObj.setGroupId(newId);
			groupInfoEntityObj.setGroupName(groupInfoTo.getGroupName());
			groupInfoEntityObj.setDescription(groupInfoTo.getDescription());
			groupInfoEntityObj.setComments(groupInfoTo.getComment());
			groupInfoEntityObj.setCustomer_prospect(groupInfoTo.getCustomer_prospect());
			groupInfoEntityObj.setInitatingGroupId(groupInfoTo.getInitatingGroupId());
			groupInfoEntityObj.setLocationId(groupInfoTo.getLocationId());
			groupInfoEntityObj.setOwnerEmployeeId(groupInfoTo.getOwnerEmployeeId());
			groupInfoEntityObj.setSourceId(groupInfoTo.getSourceId());
			groupInfoEntityObj.setSPOC(groupInfoTo.getSPOC());
			
			et.begin();
			em.persist(groupInfoEntityObj);
			et.commit();
			
			groupInfoTo.setGroupId(groupInfoEntityObj.getGroupId());
			groupInfoTo.setLocationName(getLocationNameById(groupInfoTo.getLocationId()));
			groupInfoTo.setSourceName(getSourceNameById(groupInfoTo.getSourceId()));
			groupInfoTo.setInitiatingGroupName(getInitiatingGroupNameById(groupInfoTo.getInitatingGroupId()));

			groupId=groupInfoTo.getGroupId();
			return groupInfoTo;	
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

	//updateGroup
	public void updateGroup(GroupInfoTO groupInfoTo)throws Exception
	{

		EntityManager em=null;
		GroupInfo groupInfoEntityObj = new GroupInfo();

		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();
			groupInfoEntityObj= em.find(GroupInfo.class,groupInfoTo.getGroupId() );
			if(groupInfoEntityObj!=null)
			{
				et.begin();
				groupInfoEntityObj.setGroupName(groupInfoTo.getGroupName());
				groupInfoEntityObj.setDescription(groupInfoTo.getDescription());
				groupInfoEntityObj.setComments(groupInfoTo.getComment());
				groupInfoEntityObj.setCustomer_prospect(groupInfoTo.getCustomer_prospect());
				groupInfoEntityObj.setInitatingGroupId(groupInfoTo.getInitatingGroupId());
				groupInfoEntityObj.setLocationId(groupInfoTo.getLocationId());
				groupInfoEntityObj.setOwnerEmployeeId(groupInfoTo.getOwnerEmployeeId());
				groupInfoEntityObj.setSourceId(groupInfoTo.getSourceId());
				groupInfoEntityObj.setSPOC(groupInfoTo.getSPOC());
				et.commit();

			}
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

	//get group name by location
	@SuppressWarnings("unchecked")
	public Map<String,String> getGroupNamesByGeography(String locationId)throws NoGroupsAvailableException,Exception
	{


		EntityManager em=null;
		Map<String,String> groupMap = new TreeMap<String, String>();

		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();

			et.begin();
			Query query= em.createQuery("select gp from GroupInfo gp where gp.locationId= ?1");
			query.setParameter(1, locationId);

			List<GroupInfo> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
				for(GroupInfo groupInfoList : rs1)
				{
					groupMap.put(groupInfoList.getGroupId(), groupInfoList.getGroupName());

				}
			}
			else
			{
				throw new NoGroupsAvailableException();
			}
			et.commit();

			
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
		finally {
			if(em!=null) {
				em.close();
			}
		}


	}

	// get initiating group name by id
	@SuppressWarnings("unchecked")
	public String getInitiatingGroupNameById(String initiatingGroupId)throws NoInitiatingGroupsAvailableException,Exception
	{

		EntityManager em=null;
		String initatingGroupName=null;
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();

			et.begin();
			Query query= em.createQuery("select ig from InitiatingGroup ig where ig.initiatingGroupId= ?1");
			query.setParameter(1, initiatingGroupId);

			List<InitiatingGroup> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
				for(InitiatingGroup groupName : rs1)
				{
					initatingGroupName=groupName.getInitiatingGroupName();

				}
			}
			else
			{
				throw new NoInitiatingGroupsAvailableException();
			}
			et.commit();


			return initatingGroupName;

		}

		catch( NoInitiatingGroupsAvailableException e)
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

	// get source name by id
	@SuppressWarnings("unchecked")
	public String getSourceNameById(String sourceId)throws NoSourceAvailableException,Exception
	{

		EntityManager em=null;
		String sourceName=null;
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();

			et.begin();
			Query query= em.createQuery("select s from Source s where s.sourceId= ?1");
			query.setParameter(1, sourceId);

			List<Source> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
				for(Source sourceNameList : rs1)
				{
					sourceName=sourceNameList.getSourceName();

				}
			}
			else
			{
				throw new NoSourceAvailableException();
			}
			et.commit();


			return sourceName;

		}

		catch( NoSourceAvailableException e)
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

	//get location name by id
	@SuppressWarnings("unchecked")
	public String getLocationNameById(String locationId)throws NoLocationsAvailableException,Exception
	{

		EntityManager em=null;
		String locationName=null;
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();

			et.begin();
			Query query= em.createQuery("select l from Location l where l.locationId= ?1");
			query.setParameter(1, locationId);

			List<Location> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
				for(Location locationNameList : rs1)
				{
					locationName=locationNameList.getLocationName();

				}
			}
			else
			{
				throw new NoLocationsAvailableException();
			}
			et.commit();


			return locationName;

		}

		catch( NoLocationsAvailableException e)
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

	//get group details by group id
	@SuppressWarnings("unchecked")
	public GroupInfoTO getGroupDetailsById(String groupId)throws NoGroupsAvailableException,Exception
	{
		EntityManager em=null;
		GroupInfoTO toObj = new GroupInfoTO();
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();

			et.begin();
			Query query= em.createQuery("select gi from GroupInfo gi where gi.groupId= ?1");
			query.setParameter(1,groupId);

			List<GroupInfo> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
				for(GroupInfo groupInfo : rs1)
				{
					toObj.setGroupId(groupId);
					toObj.setComment(groupInfo.getComments());
					toObj.setCustomer_prospect(groupInfo.getCustomer_prospect());
					toObj.setDescription(groupInfo.getDescription());
					toObj.setGroupName(groupInfo.getGroupName());
					toObj.setInitatingGroupId(groupInfo.getInitiatingGroupId());
					toObj.setLocationId(groupInfo.getLocationId());
					toObj.setSourceId(groupInfo.getSourceId());
					toObj.setSPOC(groupInfo.getSPOC());
					toObj.setInitiatingGroupName(getInitiatingGroupNameById(groupInfo.getInitiatingGroupId()));
					toObj.setSourceName(getSourceNameById(groupInfo.getSourceId()));
					toObj.setLocationName(getLocationNameById(groupInfo.getLocationId()));
					toObj.setOwnerEmployeeId(groupInfo.getOwnerEmployeeId());

				}
			}
			else
			{
				throw new NoGroupsAvailableException();
			}
			et.commit();


			return toObj;

		}

		catch( NoGroupsAvailableException e)
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

	public GroupInfoTO getGroupByName(String groupName)throws Exception
	{
		EntityManager em=null;
		GroupInfoTO toObj = new GroupInfoTO();
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			EntityTransaction et= em.getTransaction();

			et.begin();
			Query query= em.createQuery("select gi from GroupInfo gi where gi.groupName= ?1");
			query.setParameter(1,groupName);

			List<GroupInfo> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
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
					toObj.setInitiatingGroupName(getInitiatingGroupNameById(groupInfo.getInitiatingGroupId()));
					toObj.setSourceName(getSourceNameById(groupInfo.getSourceId()));
					toObj.setLocationName(getLocationNameById(groupInfo.getLocationId()));

				}
				return toObj;
			}
			else
			{
				return null;
			}
 
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
	
	//get All Groups By Location
	@SuppressWarnings("unchecked")
	public List<GroupInfoTO> getAllGroupsByLocation(String locationId) throws Exception , NoGroupsAvailableException
	{

		EntityManager em=null;
		List<GroupInfoTO> toGroupList = new ArrayList<GroupInfoTO>() ;

		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			Query query= em.createQuery("select gp from GroupInfo gp where gp.locationId=?1 ");
			query.setParameter(1,locationId);
			
			List<GroupInfo> rs1 = query.getResultList();

			if(!rs1.isEmpty())
			{
				for(GroupInfo groupList : rs1)
				{
					GroupInfoTO toObj = new GroupInfoTO();
					toObj.setGroupId(groupList.getGroupId());
					toObj.setGroupName(groupList.getGroupName());
					toObj.setDescription(groupList.getDescription());
					toObj.setComment(groupList.getComments());
					toObj.setCustomer_prospect(groupList.getCustomer_prospect());
					toObj.setInitatingGroupId(groupList.getInitiatingGroupId());
					toObj.setLocationId(groupList.getLocationId());
					toObj.setOwnerEmployeeId(groupList.getOwnerEmployeeId());
					toObj.setSourceId(groupList.getSourceId());
					toObj.setSPOC(groupList.getSPOC());
					toObj.setInitiatingGroupName(getInitiatingGroupNameById(groupList.getInitiatingGroupId()));
					toObj.setSourceName(getSourceNameById(groupList.getSourceId()));
					toObj.setLocationName(getLocationNameById(groupList.getLocationId()));

					toGroupList.add(toObj);

				}
			}
			else
			{
				throw new NoGroupsAvailableException();
			}
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
		return toGroupList;
	}
	 public GroupDetailsAttachmentTO uploadGroupAttachment(GroupDetailsAttachmentTO attachmentTO) throws Exception
	   {
		   EntityManager em=null;
	      
	       try 
	       {
	             EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	             em=emf.createEntityManager();
	           
	             Query query=em.createQuery("select max(ga.groupAttachmentId) from GroupDetailsAttachment ga");
	             String attachmentId=(String)query.getSingleResult();
	             int id=100;
	        
	             if(attachmentId!=null)
	             {
	            	id=Integer.parseInt(attachmentId.substring(2, attachmentId.length()));
	     			id++;
	             }
	             String groupAttachmentId="GA"+String.valueOf(id);
	             String extension=FilenameUtils.getExtension(attachmentTO.getFileName());
	             String fileName= FilenameUtils.getBaseName(attachmentTO.getFileName());
	             fileName=fileName+groupAttachmentId+"."+extension;
	             GroupDetailsAttachment attachment=new GroupDetailsAttachment();
	             attachment.setFileName(fileName);
	             attachment.setGroupAttachmentId(groupAttachmentId);
	             attachment.setGroupId(attachmentTO.getGroupId());
	             em.getTransaction().begin();
	             em.persist(attachment);
	             em.getTransaction().commit();
	             attachmentTO.setFileName(fileName);
	             attachmentTO.setGroupAttachmentId(groupAttachmentId);
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
	 public List<GroupDetailsAttachmentTO> getAttachmentsByGroupId(String groupId)throws Exception
	   {
		   EntityManager em=null;
	      
	       try 
	       {
	    	    
	             EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	             em=emf.createEntityManager();
	           
	             Query query=em.createQuery("select ga from GroupDetailsAttachment ga where ga.groupId=?1");
	             query.setParameter(1, groupId);
	             List<GroupDetailsAttachment> attachmentList=query.getResultList();
	             List<GroupDetailsAttachmentTO> attachmentTOList=new ArrayList<GroupDetailsAttachmentTO>();
	             if(!attachmentList.isEmpty())
	             {
	            	 for (GroupDetailsAttachment groupDetailsAttachment : attachmentList) {
	            		 GroupDetailsAttachmentTO attachmentTO=new GroupDetailsAttachmentTO();
	            		 attachmentTO.setFileName(groupDetailsAttachment.getFileName());
	            		 attachmentTO.setGroupId(groupId);
	            		 attachmentTO.setGroupAttachmentId(groupDetailsAttachment.getGroupAttachmentId());
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
	      
	 public int removeGroupAttachmentById(String attachmentId)throws Exception
	   {
		   EntityManager em=null;
	      
	       try 
	       {
	    	    
	             EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	             em=emf.createEntityManager();
	             em.getTransaction().begin();
	             Query query=em.createQuery("delete from GroupDetailsAttachment ga where ga.groupAttachmentId=?1");
	             query.setParameter(1, attachmentId);
	             int count=query.executeUpdate();
	             em.getTransaction().commit();
	             return count;
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
	 

	 
}
