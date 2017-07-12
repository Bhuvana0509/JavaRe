package com.infy.managedBeans;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import com.infy.TOclasses.MasterRequirementAttachmentTO;
import com.infy.TOclasses.MasterRequirementTO;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoModulesAvailableForGivenSolutionException;
import com.infy.exceptions.NoSolutionsAvailableException;
import com.infy.exceptions.NoSubModuleAvailableForGivenModuleException;
import com.infy.wrapper.FRMS_Wrapper;

public class AddMasterRequirementMB {
	private MasterRequirementTO masterRequirementTO;
	private List<SelectItem> groupNamesList;
	private List<SelectItem> solutionList;
	private List<SelectItem> modulesList;
	
	private List<UploadedFile> uploadFileList;
	private List<MasterRequirementAttachmentTO> attachmentTOList;
	private UploadedFile uploadFile1;
	private UploadedFile uploadFile2;
	private UploadedFile uploadFile3;
	private HttpSession session;
	private String message;
	
	// Changes done by Bhuvana starts
	private String customization;
	private Date mrDate;	
	private String subModuleId;
	private List<SelectItem> subModulesList;
	private Integer flag;
	private List<SelectItem> verticalList;
	private List<SelectItem> modulesList1;
	
	private List<SelectItem> loginList;
	
	public List<SelectItem> getLoginList() {
		return loginList;
	}
	public void setLoginList(List<SelectItem> loginList) {
		this.loginList = loginList;
	}
	public List<SelectItem> getModulesList1() {
		return modulesList1;
	}
	public void setModulesList1(List<SelectItem> modulesList1) {
		this.modulesList1 = modulesList1;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}
	public List<SelectItem> getSubModulesList() {
		return subModulesList;
	}
	public void setSubModulesList(List<SelectItem> subModulesList) {
		this.subModulesList = subModulesList;
	}
	public Date getMrDate() {
		return mrDate;
	}
	public void setMrDate(Date mrDate) {
		this.mrDate = mrDate;
	}
	public String getCustomization() {
		return customization;
	}
	public void setCustomization(String customization) {
		this.customization = customization;
	}
	// Changes completed
	public MasterRequirementTO getMasterRequirementTO() {
		return masterRequirementTO;
	}
	public void setMasterRequirementTO(MasterRequirementTO masterRequirementTO) {
		this.masterRequirementTO = masterRequirementTO;
	}
	public List<SelectItem> getGroupNamesList() {
		return groupNamesList;
	}
	public void setGroupNamesList(List<SelectItem> groupNamesList) {
		this.groupNamesList = groupNamesList;
	}
	public List<SelectItem> getSolutionList() {
		return solutionList;
	}
	public void setSolutionList(List<SelectItem> solutionList) {
		this.solutionList = solutionList;
	}
	public List<SelectItem> getModulesList() {
		return modulesList;
	}
	public void setModulesList(List<SelectItem> modulesList) {
		this.modulesList = modulesList;
	}
	
	public void setUploadFileList(List<UploadedFile> uploadFileList) {
		this.uploadFileList = uploadFileList;
	}
	public List<UploadedFile> getUploadFileList() {
		return uploadFileList;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<MasterRequirementAttachmentTO> getAttachmentTOList() {
		return attachmentTOList;
	}
	public void setAttachmentTOList(
			List<MasterRequirementAttachmentTO> attachmentTOList) {
		this.attachmentTOList = attachmentTOList;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	public UploadedFile getUploadFile1() {
		return uploadFile1;
	}
	public void setUploadFile1(UploadedFile uploadFile1) {
		this.uploadFile1 = uploadFile1;
	}
	
	public UploadedFile getUploadFile2() {
		return uploadFile2;
	}
	public void setUploadFile2(UploadedFile uploadFile2) {
		this.uploadFile2 = uploadFile2;
	}
	public UploadedFile getUploadFile3() {
		return uploadFile3;
	}
	public void setUploadFile3(UploadedFile uploadFile3) {
		this.uploadFile3 = uploadFile3;
	}
	
	
	
	public AddMasterRequirementMB() 
	{ 
		this.groupNamesList=new ArrayList<SelectItem>();
		this.modulesList=new ArrayList<SelectItem>();
		this.solutionList=new ArrayList<SelectItem>();
		//changes done by Bhuvana starts
		this.subModulesList=new ArrayList<SelectItem>();
		this.modulesList1=new ArrayList<SelectItem>();
		this.verticalList=new ArrayList<SelectItem>();
		
		this.loginList=new ArrayList<SelectItem>();
		
		/*loginList.add(new SelectItem( "Admin") );	
		loginList.add(new SelectItem( "Admin1") );	
		loginList.add(new SelectItem( "Admin2") );	
		loginList.add(new SelectItem( "Admin3") );
		loginList.add(new SelectItem( "bdmin1") );	
		loginList.add(new SelectItem( "bdmin2") );	
		loginList.add(new SelectItem( "bdmin3") );*/	
		
		
		//changes completed
		this.masterRequirementTO=new MasterRequirementTO();
		FRMS_Wrapper wrapper=new FRMS_Wrapper();
		this.uploadFileList=new ArrayList<UploadedFile>();
		this.attachmentTOList=new ArrayList<MasterRequirementAttachmentTO>();
		this.attachmentTOList.add(new MasterRequirementAttachmentTO());
		
		// Changes done by Bhuvana starts
		this.customization ="No";
		this.masterRequirementTO.setCustomization("No");
		
		//set default date
		if(getMrDate()== null){
			this.mrDate = new Date();
			System.out.println("Todays Date: "+this.mrDate);
			this.masterRequirementTO.setMrDate(mrDate);
		}
//		else{
//			this.mrDate = mrDate;
//		}
		// Changes completed
		
		
		/*try
		{
			FileItem item=new DiskFileItem(null,null,false,null,0,null);
		
			UploadedFile file=new UploadedFileDefaultFileImpl(item);
			this.uploadFileList.add(file);
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		 
		}
		*/
		try
		{
			 
			this.message=null;
			TreeMap<String,String> groupNamesMap = new TreeMap<String, String>();
			groupNamesMap=(TreeMap<String, String>) wrapper.getAllGroupNames();
			HashMap<String,String> groupNamesHashMap = new HashMap<String, String>();
			groupNamesHashMap = sortHashMap(groupNamesMap);
			
			for (Map.Entry<String,String> entry: groupNamesHashMap.entrySet())
			{
				groupNamesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			TreeMap<String,String> solutionMap = new TreeMap<String, String>();			
			solutionMap= (TreeMap<String, String>) wrapper.getAllSolutions();
			HashMap<String,String> solutionNamesHashMap = new HashMap<String, String>();
			solutionNamesHashMap = sortHashMap(solutionMap);
			
			for (Map.Entry<String,String> entry: solutionNamesHashMap.entrySet())
			{
				//System.out.println("solution entry.getKey()@@@"+entry.getKey()+"*solution entry.getValue()@@@"+entry.getValue());
				solutionList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
			
			
			//added for emailId list
			TreeMap<String,String> loginMap = new TreeMap<String, String>();			
			loginMap= (TreeMap<String, String>) wrapper.getAllEmailIds();
			HashMap<String,String> loginNamesHashMap = new HashMap<String, String>();
			loginNamesHashMap = sortHashMap(loginMap);
			
			for (Map.Entry<String,String> entry: loginNamesHashMap.entrySet())
			{
				//System.out.println("solution entry.getKey()@@@"+entry.getKey()+"*solution entry.getValue()@@@"+entry.getValue());
				loginList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
			
			  
		} 
		
		catch (NoGroupsAvailableException e)
		{
			this.setMessage(e.getMessage());
		} 
		catch (NoSolutionsAvailableException e) 
		{
			this.setMessage(e.getMessage());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			this.setMessage(e.getMessage());
		} 
	}
	
	
	///Sorting Map///////
	private HashMap<String, String> sortHashMap(TreeMap<String, String> input){
	    Map<String, String> tempMap = new HashMap<String, String>();
	    for (String wsState : input.keySet()){
	    	tempMap.put(wsState,input.get(wsState));
	    }

	    List<String> mapKeys = new ArrayList<String>(tempMap.keySet());
	    List<String> mapValues = new ArrayList<String>(tempMap.values());
	    HashMap<String, String> sortedMap = new LinkedHashMap<String, String>();
	    TreeSet<String> sortedSet =new TreeSet<String>();
	    for(int i=0; i<mapValues.size();i++)
	    {
	    	//System.out.println("$$$$$$$$$$"+i+"==="+mapValues.get(i)+"keysss"+mapKeys.get(i));
	    	//System.out.println("keyssss"+mapKeys.get(mapValues.indexOf(mapValues.get(i))));
	    }
	    Collections.sort(mapValues);
	    for (int i=0; i<mapValues.size(); i++){
	    	//System.out.println("key*******"+getKeyByValue(tempMap,(String)mapValues.get(i))+"value*********"+(String)mapValues.get(i));
	        sortedMap.put(getKeyByValue(tempMap,(String)mapValues.get(i)), 
	                      (String)mapValues.get(i));
	    }
	    return sortedMap;
	}

	public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (value.equals(entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	/////////////////////
	
	
	
	public List<SelectItem> getVerticalList() {
		return verticalList;
	}
	public void setVerticalList(List<SelectItem> verticalList) {
		this.verticalList = verticalList;
	}
	public void getModuleListOfSelectedSolution(ValueChangeEvent event)
	{
		String obj=(String)event.getNewValue();
		modulesList = new ArrayList<SelectItem>();
		this.message=null;
		if(obj!=null && !(obj.equals("0")))
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();	
			Map<String,String> modulesMap = new TreeMap<String, String>();
			try 
			{
				modulesMap= wrapper.getAllModulesBySolution(obj);
				 
				for (Map.Entry<String,String> entry: modulesMap.entrySet())
				{
					modulesList.add(new SelectItem(entry.getKey(),entry.getValue() ) ); 
				}
			} 
			catch (NoModulesAvailableForGivenSolutionException e) 
			{
				this.setMessage(e.getMessage());
				 
			}
			catch (Exception e) 
			{
				this.setMessage(e.getMessage());
				 
			}
		}
	}
	/*//changes done by Bhuvana
	//view sub modules Of Selected module
	public void getAllSubModulesByModule(ValueChangeEvent event)
	{
		this.setFlag(0);	
		String obj=(String)event.getNewValue();
		subModulesList = new ArrayList<SelectItem>();
		if(obj!=null && !(obj.equals("0")))
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();	
			Map<String,String> subModulesMap = new TreeMap<String, String>();
			try 
			{
				subModulesMap= wrapper.getAllSubModulesByModule(obj);
				
				for (Map.Entry<String,String> entry: subModulesMap.entrySet())
				{
					subModulesList.add(new SelectItem(entry.getKey(),entry.getValue() ) ); 
				}
			} 
			catch (NoSubModuleAvailableForGivenModuleException e) 
			{
				this.setMessage(e.getMessage());
					 
			}
			catch (Exception e) 
			{
				this.setMessage(e.getMessage());
				 
			}
		}
	}*/
	
	public String addNewMasterRequirement()
	{
		String masterReqId=null;

		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		try 
		{
			 
			session=(HttpSession)(FacesContext.getCurrentInstance().getExternalContext().getSession(true));
			this.masterRequirementTO.setOwnerEmployeeId((String)session.getAttribute("EmployeeId"));
			String emailId=(String)session.getAttribute("emailId");
			masterReqId=wrapper.addMasterRequirement(this.masterRequirementTO,emailId);
			System.out.println("master requirement id="+masterReqId);
			this.masterRequirementTO.setMasterRequirementId(masterReqId);
			
			/* for (MasterRequirementAttachmentTO attachmentTO : this.attachmentTOList) {
				 MasterRequirementAttachmentTO newAttachmentTO=new MasterRequirementAttachmentTO();
				 newAttachmentTO.setFileName(attachmentTO.getUploadedFile().getName());
				 newAttachmentTO.setMasterRequirementId(masterReqId);
				 newAttachmentTO=wrapper.uploadMasterRequirementAttachment(newAttachmentTO);
				String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("MR-Attachment");
				String fileName= filePath+newAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(attachmentTO.getUploadedFile().getBytes());
				outStream.close();
			 }*/
			
			MasterRequirementAttachmentTO newAttachmentTO=new MasterRequirementAttachmentTO();
			newAttachmentTO.setMasterRequirementId(masterReqId);
			String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("MR-Attachment");
			if(uploadFile1!=null)
			{
				
				newAttachmentTO.setFileName(uploadFile1.getName());
				newAttachmentTO=wrapper.uploadMasterRequirementAttachment(newAttachmentTO);
				
				String fileName= filePath+newAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(uploadFile1.getBytes());
				outStream.close();
			}
			if(uploadFile2!=null)
			{
				
				newAttachmentTO.setFileName(uploadFile2.getName());
				newAttachmentTO.setMasterRequirementId(masterReqId);
				newAttachmentTO=wrapper.uploadMasterRequirementAttachment(newAttachmentTO);
				String fileName= filePath+newAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(uploadFile2.getBytes());
				outStream.close();
			}
			if(uploadFile3!=null)
			{
				
				newAttachmentTO.setFileName(uploadFile3.getName());
				newAttachmentTO.setMasterRequirementId(masterReqId);
				newAttachmentTO=wrapper.uploadMasterRequirementAttachment(newAttachmentTO);
				String fileName= filePath+newAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(uploadFile3.getBytes());
				outStream.close();
			}
			
			
			
			this.setMessage("Master Requirement Added Successfully with Master Requirement Id " + masterReqId );
			return "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			this.setMessage(e.getMessage());
			 
			return "failure";
		}
		
	 
	}
	
	public void getVerticalListOfSelectedSolution(ValueChangeEvent event)
	{
		System.out.println("getVerticalListOfSelectedSolution()");
		String obj=(String)event.getNewValue();
		verticalList = new ArrayList<SelectItem>();
		this.message=null;
		if(obj!=null && !(obj.equals("0")))
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();	
			TreeMap<String,String> verticalsMap = new TreeMap<String, String>();
			try 
			{	
				verticalsMap= (TreeMap<String, String>) wrapper.getAllVerticalsBySolution(obj);
				HashMap<String,String> verticalNamesHashMap = new HashMap<String, String>(); 
				verticalNamesHashMap = sortHashMap(verticalsMap);
				 
			    for (Map.Entry<String,String> entry: verticalNamesHashMap.entrySet())
				{
					//System.out.println("entry.getKey()"+entry.getKey()+"entry.getValue()"+entry.getValue());
			    	verticalList.add(new SelectItem(entry.getKey(),entry.getValue() ) ); 
				}
			} 
			catch (NoModulesAvailableForGivenSolutionException e) 
			{
				this.setMessage(e.getMessage());
				 
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				this.setMessage(e.getMessage());
				 
			}
		}
	}
	
	//changes done by Bhuvana
		//view  modules Of Selected vertical
		public void getAllModulesByVertical(ValueChangeEvent event)
		{
			this.setFlag(0);	
			String obj=(String)event.getNewValue();
			modulesList1 = new ArrayList<SelectItem>();
			if(obj!=null && !(obj.equals("0")))
			{
				FRMS_Wrapper wrapper = new FRMS_Wrapper();	
				//Map<String,String> modulesMap = new TreeMap<String, String>();
				TreeMap<String,String> modulesMap = new TreeMap<String, String>();
				try 
				{
					/*modulesMap= wrapper.getAllModulesByVertical(obj);
					
					for (Map.Entry<String,String> entry: modulesMap.entrySet())
					{
						modulesList1.add(new SelectItem(entry.getKey(),entry.getValue() ) ); 
					}*/
					
					modulesMap= (TreeMap<String, String>) wrapper.getAllModulesByVertical(obj);
					HashMap<String,String> moduleNamesHashMap = new HashMap<String, String>(); 
					moduleNamesHashMap = sortHashMap(modulesMap);
					 
				    for (Map.Entry<String,String> entry: moduleNamesHashMap.entrySet())
					{
						//System.out.println("entry.getKey()"+entry.getKey()+"entry.getValue()"+entry.getValue());
				    	modulesList1.add(new SelectItem(entry.getKey(),entry.getValue() ) ); 
					}
					
				} 
				catch (NoSubModuleAvailableForGivenModuleException e) 
				{
					this.setMessage(e.getMessage());
						 
				}
				catch (Exception e) 
				{
					this.setMessage(e.getMessage());
					 
				}
			}
		}
	
	
	public String attachMoreFile()
	{
		attachmentTOList.add(new MasterRequirementAttachmentTO());
		return "added";
	 
		/*try
		{
		FileItem item=new DiskFileItem(null,null,false,null,0,null);
		
		UploadedFile file=new UploadedFileDefaultFileImpl(item);
		this.uploadFileList.add(file);
		return "added";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "fail";
		}*/
	}
	
	public String removeAttachmentFile()
	{
		this.attachmentTOList.remove(this.attachmentTOList.size()-1);
		return "added";
	}
	
	public String reset()
	{ 
		AddMasterRequirementMB addMasterRequirementMB=new AddMasterRequirementMB();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("addMasterRequirementMB", addMasterRequirementMB);
		
		return "reset";
	}

}
