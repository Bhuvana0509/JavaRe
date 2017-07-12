package com.infy.managedBeans;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.infy.TOclasses.MasterRequirementAttachmentTO;
import com.infy.TOclasses.MasterRequirementTO;
import com.infy.exceptions.NoMasterReqAvailableException;
import com.infy.exceptions.NoModulesAvailableForGivenSolutionException;
import com.infy.exceptions.NoSubModuleAvailableForGivenModuleException;
import com.infy.wrapper.FRMS_Wrapper;

public class MasterRequirementMB {
	
	private MasterRequirementTO masterRequirementTO;
	private List<SelectItem> solutionList;
	private List<SelectItem> modulesList;
	private HtmlDataTable ownerMasterReqHtmlDataTable;
	private List<MasterRequirementTO> ownerMasterRequirementList;
	private MasterRequirementTO updateMasterRequirementTO;
	private String masterRequirementId;
	private List<MasterRequirementTO> ownerAllMasterRequirementList;
	
	private UploadedFile uploadFile1;
	private UploadedFile uploadFile2;
	private UploadedFile uploadFile3;
	private FacesContext facesContext;
	private ExternalContext externalContext;
	private HttpSession session;
	private Integer pageNumber;
	private Integer rowsPerPage;
	private List<SelectItem> pageNumberList;
	
	private Integer displayPageNumber;
	private String message;
	private String pageMessage;
	//changes done by Bhuvana starts
	private List<SelectItem> subModuleList;
	
	private List<SelectItem> verticalList;
	/*private String subModuleId;
	
	public String getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}*/

	public List<SelectItem> getVerticalList() {
		return verticalList;
	}

	public void setVerticalList(List<SelectItem> verticalList) {
		this.verticalList = verticalList;
	}

	public List<SelectItem> getSubModuleList() {
		return subModuleList;
	}

	public void setSubModuleList(List<SelectItem> subModuleList) {
		this.subModuleList = subModuleList;
	}
	// Changes done by Bhuvana starts
	private String customization;
	 
	public String getCustomization() {
		return customization;
	}

	public void setCustomization(String customization) {
		this.customization = customization;
	}
	// Changes completed
	private MasterRequirementTO[] mrArray;
	                            
	public MasterRequirementTO[] getMrArray() {
		return mrArray;
	}

	public void setMrArray(MasterRequirementTO[] mrArray) {
		this.mrArray = mrArray;
	}

	public MasterRequirementTO getMasterRequirementTO() {
		return masterRequirementTO;
	}

	public void setMasterRequirementTO(MasterRequirementTO masterRequirementTO) {
		this.masterRequirementTO = masterRequirementTO;
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

	public String getMasterRequirementId() {
		return masterRequirementId;
	}

	public void setMasterRequirementId(String masterRequirementId) {
		this.masterRequirementId = masterRequirementId;
	}

 
	public MasterRequirementTO getUpdateMasterRequirementTO() {
		return updateMasterRequirementTO;
	}

	public void setUpdateMasterRequirementTO(
			MasterRequirementTO updateMasterRequirementTO) {
		this.updateMasterRequirementTO = updateMasterRequirementTO;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public ExternalContext getExternalContext() {
		return externalContext;
	}

	public void setExternalContext(ExternalContext externalContext) {
		this.externalContext = externalContext;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}



	public List<MasterRequirementTO> getOwnerMasterRequirementList() {
		return ownerMasterRequirementList;
	}

	public void setOwnerMasterRequirementList(
			List<MasterRequirementTO> ownerMasterRequirementList) {
		this.ownerMasterRequirementList = ownerMasterRequirementList;
	}

	

	public List<MasterRequirementTO> getOwnerAllMasterRequirementList() {
		return ownerAllMasterRequirementList;
	}

	public void setOwnerAllMasterRequirementList(
			List<MasterRequirementTO> ownerAllMasterRequirementList) {
		this.ownerAllMasterRequirementList = ownerAllMasterRequirementList;
	}

	public HtmlDataTable getOwnerMasterReqHtmlDataTable() {
		return ownerMasterReqHtmlDataTable;
	}

	public void setOwnerMasterReqHtmlDataTable(
			HtmlDataTable ownerMasterReqHtmlDataTable) {
		this.ownerMasterReqHtmlDataTable = ownerMasterReqHtmlDataTable;
	}

	 public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(Integer rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public String getPageMessage() {
		return pageMessage;
	}

	public void setPageMessage(String pageMessage) {
		this.pageMessage = pageMessage;
	}
	

	
	public List<SelectItem> getPageNumberList() {
		return pageNumberList;
	}

	public void setPageNumberList(List<SelectItem> pageNumberList) {
		this.pageNumberList = pageNumberList;
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
	
	public Integer getDisplayPageNumber() {
		return displayPageNumber;
	}

	public void setDisplayPageNumber(Integer displayPageNumber) {
		this.displayPageNumber = displayPageNumber;
	}

	public MasterRequirementMB() 
	{
		
		//default constructor stub
		this.masterRequirementTO=null;
		this.pageNumber=1;
		this.rowsPerPage=10;
		this.message=null;
		
		// Changes done by Bhuvana starts
		this.customization = "No";
		// Changes completed
		
		this.masterRequirementTO=new MasterRequirementTO();
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		//subModuleList = new ArrayList<SelectItem>();
		modulesList = new ArrayList<SelectItem>();
		verticalList = new ArrayList<SelectItem>();
		solutionList = new ArrayList<SelectItem>();
		//modulesList = new ArrayList<SelectItem>();
		 
		try 
		{

			facesContext=FacesContext.getCurrentInstance();
			externalContext=facesContext.getExternalContext();
			session=(HttpSession)externalContext.getSession(true);
			String ownerEmpId=(String)session.getAttribute("EmployeeId");
			//this.ownerMasterRequirementList=wrapper.getMasterRequirementListByOwner(ownerEmpId);
			this.ownerAllMasterRequirementList=wrapper.getMasterRequirementListByOwner(ownerEmpId);
			System.out.println("ownerAllMasterRequirementList size: "+ownerAllMasterRequirementList.size());
			int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
			int endRowNumber=this.pageNumber*this.rowsPerPage;
			if(endRowNumber>=this.ownerAllMasterRequirementList.size())
			{
				endRowNumber=this.ownerAllMasterRequirementList.size();
			}
			this.ownerMasterRequirementList=this.ownerAllMasterRequirementList.subList(startRowNumner, endRowNumber);
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.ownerAllMasterRequirementList.size();
			this.pageNumberList=new ArrayList<SelectItem>();
			int totalPageNumbers=(this.ownerAllMasterRequirementList.size()-1)/10;
			totalPageNumbers++;
			for(Integer i=1;i<=totalPageNumbers;i++)
			{
				this.pageNumberList.add(new SelectItem(i.toString(),i.toString()));
			}
			//this.mrArray=(MasterRequirementTO[])this.ownerMasterRequirementList.toArray();
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			this.message=e.getMessage();
		}
		 
	}
	
	public String editMasterRequirement()
	{
		this.message=null;
		this.masterRequirementTO=(MasterRequirementTO)ownerMasterReqHtmlDataTable.getRowData();
		return this.update();
		
	}
	public String update()
	{
		FRMS_Wrapper wrapper=new FRMS_Wrapper();
		//this.subModuleList = new ArrayList<SelectItem>();
		try
		{

			updateMasterRequirementTO=new MasterRequirementTO();
			updateMasterRequirementTO.setContactPerson(masterRequirementTO.getContactPerson());
			updateMasterRequirementTO.setDescription(masterRequirementTO.getDescription());
			updateMasterRequirementTO.setExternalReferenceNumber(masterRequirementTO.getExternalReferenceNumber());
			updateMasterRequirementTO.setGroupId(masterRequirementTO.getGroupId());
			updateMasterRequirementTO.setGroupName(masterRequirementTO.getGroupName());
			updateMasterRequirementTO.setMasterRequirementId(masterRequirementTO.getMasterRequirementId());
			updateMasterRequirementTO.setMasterRequirementTitle(masterRequirementTO.getMasterRequirementTitle());
			updateMasterRequirementTO.setVerticalId(masterRequirementTO.getVerticalId());
			updateMasterRequirementTO.setVerticalName(masterRequirementTO.getVerticalName());
			updateMasterRequirementTO.setOwnerEmployeeId(masterRequirementTO.getOwnerEmployeeId());
			updateMasterRequirementTO.setSolutionId(masterRequirementTO.getSolutionId());
			updateMasterRequirementTO.setSolutionName(masterRequirementTO.getSolutionName());
			
			updateMasterRequirementTO.setModuleId(masterRequirementTO.getModuleId());
			updateMasterRequirementTO.setModuleName(masterRequirementTO.getModuleName());
			
			//changes done by Bhuvana starts
			//updateMasterRequirementTO.setSubModuleId(masterRequirementTO.getSubModuleId());
			//System.out.println("sub module id in MasterRequirementMB: "+masterRequirementTO.getSubModuleId());
			//updateMasterRequirementTO.setSubModuleName(masterRequirementTO.getSubModuleName());
			//System.out.println("sub module name: "+masterRequirementTO.getSubModuleId());
			//changes completed
			updateMasterRequirementTO.setStatus(masterRequirementTO.getStatus());
			// Changes done by Bhuvana starts
			updateMasterRequirementTO.setCustomization(masterRequirementTO.getCustomization());
			// Changes completed

			//changes done by sanket mehta
//			System.out.println("date before update: " + masterRequirementTO.getMrDate());
			updateMasterRequirementTO.setMrDate(masterRequirementTO.getMrDate());
			//changes complete
			
			/*solutionList = new ArrayList<SelectItem>();
			Map<String,String> solutionMap = new TreeMap<String, String>();
			solutionMap=new FRMS_Wrapper().getAllSolutions();
			for (Map.Entry<String,String> entry: solutionMap.entrySet())
			{
				solutionList.add(new SelectItem( entry.getKey(),entry.getValue() ) );

			}*/
			
			TreeMap<String,String> solutionMap = new TreeMap<String, String>();		
			solutionMap= (TreeMap<String, String>) wrapper.getAllSolutions();
			HashMap<String,String> solutionNamesHashMap = new HashMap<String, String>();
			solutionNamesHashMap = sortHashMap(solutionMap);
			
			for (Map.Entry<String,String> entry: solutionNamesHashMap.entrySet())
			{
				//System.out.println("solution entry.getKey()@@@"+entry.getKey()+"*solution entry.getValue()@@@"+entry.getValue());
				solutionList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
			
			/*this.verticalList=new ArrayList<SelectItem>();
			Map<String,String> verticalMap = new TreeMap<String, String>();
			verticalMap= new FRMS_Wrapper().getAllVerticalsBySolution(this.updateMasterRequirementTO.getSolutionId());
			for (Map.Entry<String,String> entry: verticalMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );

				 
			}*/
			
			TreeMap<String,String> verticalMap = new TreeMap<String, String>();		
			verticalMap= (TreeMap<String, String>) wrapper.getAllVerticals();
			HashMap<String,String> verticalHashMap = new HashMap<String, String>();
			verticalHashMap = sortHashMap(verticalMap);
			
			for (Map.Entry<String,String> entry: verticalHashMap.entrySet())
			{
				//System.out.println("solution entry.getKey()@@@"+entry.getKey()+"*solution entry.getValue()@@@"+entry.getValue());
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
			
			/*this.modulesList=new ArrayList<SelectItem>();
			Map<String,String> moduleNamesMap =  new TreeMap<String, String>();
			moduleNamesMap= new FRMS_Wrapper().getAllModulesBySolution(this.updateMasterRequirementTO.getSolutionId());
			for (Map.Entry<String,String> entry: moduleNamesMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );

				 
			}*/
			
			TreeMap<String,String> moduleMap = new TreeMap<String, String>();		
			moduleMap= (TreeMap<String, String>) wrapper.getAllModule();
			HashMap<String,String> moduleHashMap = new HashMap<String, String>();
			moduleHashMap = sortHashMap(moduleMap);
			
			for (Map.Entry<String,String> entry: moduleHashMap.entrySet())
			{
				//System.out.println("solution entry.getKey()@@@"+entry.getKey()+"*solution entry.getValue()@@@"+entry.getValue());
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
			
			// changes done by Bhuvana
			
//			

			return "update";
		}
		catch (Exception e) {
			
			e.printStackTrace();
			this.message=e.getMessage();
			return "fail";
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
		
	//update master requirement added by me
	public String updateMasterRequirement()
	{
		try
		{
			this.message=null;
			FRMS_Wrapper wrapper=new FRMS_Wrapper();
			wrapper.updateMasterRequirement(this.updateMasterRequirementTO);
			this.masterRequirementTO=this.updateMasterRequirementTO;
			MasterRequirementAttachmentTO newAttachmentTO=new MasterRequirementAttachmentTO();
			String masterReqId=masterRequirementTO.getMasterRequirementId();
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
			this.message="Master Requirement Updated Successfully";
			return "success";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			this.message=e.getMessage();
			return "fail";
		}

	}
	
	public String cancelUpdateRequirement()
	{
		// changes if any to be made before canceling the update
		return "cancel";
	}



	
	public String showNextRecord()
	{
		this.message=null;
		this.pageNumber++;
		int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
		int endRowNumber=(this.pageNumber*this.rowsPerPage);
		if(startRowNumner<ownerAllMasterRequirementList.size())
		{
			if(endRowNumber>=this.ownerAllMasterRequirementList.size())
			{
				endRowNumber=this.ownerAllMasterRequirementList.size();
			}
		
			this.ownerMasterRequirementList=this.ownerAllMasterRequirementList.subList(startRowNumner, endRowNumber);
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.ownerAllMasterRequirementList.size();
		}
		else
		{
			pageNumber--;
		}

		this.displayPageNumber=this.pageNumber;
		return "show";
	}
	
	public String showPreviousRecord()
	{
		this.message=null;
		if(pageNumber>1)
		{
			this.pageNumber--;
			int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
			int endRowNumber=(this.pageNumber*this.rowsPerPage);
			
			this.ownerMasterRequirementList=this.ownerAllMasterRequirementList.subList(startRowNumner, endRowNumber);
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.ownerAllMasterRequirementList.size();
			this.displayPageNumber=this.pageNumber;
		}
		
		
		return "show";
	}
	
	
	public void getModuleListOfSelectedSolution(ValueChangeEvent event)
	{
		
		String obj=(String)event.getNewValue();
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		this.message=null;
		modulesList = new ArrayList<SelectItem>();
		//Map<String,String> modulesMap = new TreeMap<String, String>();
		
		TreeMap<String,String> moduleMap = new TreeMap<String, String>();

		try 
		{
			moduleMap= (TreeMap<String, String>) wrapper.getAllModulesByVertical(obj);
			HashMap<String,String> moduleHashMap = new HashMap<String, String>();
			moduleHashMap = sortHashMap(moduleMap);
			for (Map.Entry<String,String> entry: moduleHashMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) ); 
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
	
	
	//changes done by Bhuvana
	//view sub modules Of Selected module				
	public void getAllSubModulesByModule(ValueChangeEvent e)
	{
		String obj=(String)e.getNewValue();
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		this.message=null;
		//subModuleList = new ArrayList<SelectItem>();
		Map<String,String> subModuleMap = new TreeMap<String, String>();	
			
		try {
			   subModuleMap = wrapper.getAllSubModulesByModule(obj);

				for (Map.Entry<String,String> entry: subModuleMap.entrySet())
				{
					subModuleList.add(new SelectItem(entry.getKey(),entry.getValue() ) );
				}
			} catch (NoSubModuleAvailableForGivenModuleException e1) {
	 
				//e1.printStackTrace();
				this.setMessage(e1.getMessage());
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
				this.setMessage(e1.getMessage());
			}
		}
		// changes completed
	
	//view sub modules Of Selected module				
		public void getAllModulesByVertical(ValueChangeEvent e)
		{
			String obj=(String)e.getNewValue();
			FRMS_Wrapper wrapper = new FRMS_Wrapper();
			this.message=null;
			
			//Map<String,String> moduleMap = new TreeMap<String, String>();
			TreeMap<String,String> moduleMap = new TreeMap<String, String>();
				
			try {
				moduleMap= (TreeMap<String, String>) wrapper.getAllModulesByVertical(obj);
				HashMap<String,String> moduleHashMap = new HashMap<String, String>();
				moduleHashMap = sortHashMap(moduleMap);

				for (Map.Entry<String,String> entry: moduleHashMap.entrySet())
				{
					//System.out.println("solution entry.getKey()@@@"+entry.getKey()+"*solution entry.getValue()@@@"+entry.getValue());
					modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				}
				} catch (NoSubModuleAvailableForGivenModuleException e1) {
		 
					//e1.printStackTrace();
					this.setMessage(e1.getMessage());
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
					this.setMessage(e1.getMessage());
				}
			}
		
		
		/*TreeMap<String,String> moduleMap = new TreeMap<String, String>();		
		moduleMap= (TreeMap<String, String>) wrapper.getAllModulesByVertical(this.updateMasterRequirementTO.getVerticalId());
		HashMap<String,String> moduleHashMap = new HashMap<String, String>();
		moduleHashMap = sortHashMap(moduleMap);
		
		for (Map.Entry<String,String> entry: moduleHashMap.entrySet())
		{
			//System.out.println("solution entry.getKey()@@@"+entry.getKey()+"*solution entry.getValue()@@@"+entry.getValue());
			modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
		}*/
		
			// changes completed
	
	public void selectPageNumber(ValueChangeEvent e)
	{
		try
		{ 
			Integer val=(Integer)e.getNewValue();
			if(val!=null)
			{ 
				if(val!=0)
				{
					this.pageNumber=val;
					this.pageNumber--;
					this.showNextRecord();
				}
			}
		}
		catch (Exception ex) {
			this.message=ex.getMessage();
		}

	}
	public String downloadMasterReqList()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		
		try
		{
			String fName=wrapper.downloadMasterRequirementsReport(this.ownerAllMasterRequirementList);
			FileInputStream fileInputStream = new FileInputStream(fName);
			String fileName="MasterRequirementsReport.xls";
			
			
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			HSSFWorkbook groupsReport =    new HSSFWorkbook(fsFileSystem); 
			
			// Prepare response to show a Save As dialogue with Excel report.   
			FacesContext facesContext = FacesContext.getCurrentInstance();  
			ExternalContext externalContext = facesContext.getExternalContext();   
			
			HttpServletResponse response=(HttpServletResponse)externalContext.getResponse();
			response.setContentType("application/vnd.ms-excel");    
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); 
			// Write Excel report to response body.     
			groupsReport.write(response.getOutputStream());     
			// Inform JSF that response is completed and it thus doesn't have to navigate.  
			facesContext.responseComplete(); 
			fileInputStream.close();
			return"success";
		}
		catch (NoMasterReqAvailableException e) 
		{
			this.setMessage(e.getMessage());
			return"fail";
		} 
		catch (Exception e)
		{
			//e.printStackTrace();
			this.setMessage(e.getMessage());
			//
			return"fail";		
		}
	}
	 
}
