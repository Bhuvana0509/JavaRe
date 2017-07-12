package com.infy.managedBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Date;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.infy.TOclasses.MasterRequirementAttachmentTO;
import com.infy.TOclasses.MasterRequirementTO;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.exceptions.AlreadyAcceptedException;
import com.infy.exceptions.InvalidFileExtensionException;
import com.infy.exceptions.InvalidFileFormatException;
import com.infy.exceptions.MasterReqListIsEmptyException;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.service.DownloadService;

import com.infy.wrapper.FRMS_Wrapper;

public class UploadListMB 
{
	private UploadedFile uploadedFile;  
	private String message=null;
		
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UploadedFile getUploadedFile() 
	{         
		return uploadedFile;   
	}   
	public void setUploadedFile(UploadedFile uploadedFile)
	{        
		this.uploadedFile = uploadedFile;  
	} 
	
	public UploadListMB() {
		this.message=null;
	}
	
	
	@SuppressWarnings("unchecked")
	public String uploadData()
	{ 
		this.message=null;
		
		if(this.uploadedFile==null)
		{
			this.message="Please select a file to upload";
			return "fail";
		}
		Integer flag=1;
		File file=null;
		 
		String fileName =FilenameUtils.getName(uploadedFile.getName()); 
		String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
		String inputFile=filePath+fileName;
		String fileExtension=FilenameUtils.getExtension(uploadedFile.getName());
		FileInputStream fileInputStream=null;
	
		 
		

		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		try 
		{
			if(fileExtension.equalsIgnoreCase("xls")== true)
			{
				
				
				file = new File( filePath +fileName); 
				try
				{
					FileOutputStream output=new FileOutputStream(file);

					output.write(uploadedFile.getBytes());
					output.close();


				}
				catch(Exception e)
				{
					e.printStackTrace();
					this.message="OOPS!! Error uploading file, Try Again!";
					return "fail";
				}   
				
				



				List<MasterRequirementTO> masterReqList = new ArrayList<MasterRequirementTO>();


				 fileInputStream = new FileInputStream(inputFile); 

				/* 
				 * Create a new instance for POIFSFileSystem class 
				 */ 

				POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream); 

				/* 
				 * Create a new instance for HSSFWorkBook Class 
				 */ 

				HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem); 
				HSSFSheet hssfSheet = workBook.getSheetAt(0); 

				/* 
				 * Iterate the rows and cells of the spreadsheet to get all the data. 
				 */ 

				Iterator rowIterator = hssfSheet.rowIterator(); 

				int cnt=0;
				while (rowIterator.hasNext()) 
				{ 
					
					HSSFRow hssfRow = (HSSFRow) rowIterator.next(); 
					MasterRequirementTO toObj = new MasterRequirementTO();
					List cellTempList = new ArrayList();
//					Iterator iterator = hssfRow.cellIterator();
					
					//changes done by sanket mehta
					for(int cellValue = 0; cellValue < hssfRow.getLastCellNum(); ++cellValue)
					{
						HSSFCell hssfCell  = hssfRow.getCell(cellValue,Row.CREATE_NULL_AS_BLANK );
						cellTempList.add(hssfCell);
					}
//					while (iterator.hasNext()) 
//					{ 
//						
////						HSSFCell hssfCell = (HSSFCell) iterator.next(); 
//						 iterator.next();
//						cellTempList.add(hssfCell);
//					} 
					//changes completed

					if(flag==1)
					{
						if(cellTempList.isEmpty())
						{
							throw new InvalidFileFormatException();
						}
						else if(cellTempList.get(0).toString().equalsIgnoreCase("Sr no") &&
								cellTempList.get(1).toString().equalsIgnoreCase("Master Req Title") &&
								cellTempList.get(2).toString().equalsIgnoreCase("External Reference No") &&
								cellTempList.get(3).toString().equalsIgnoreCase("Group Name") &&
								cellTempList.get(4).toString().equalsIgnoreCase("Solution Name") &&
								cellTempList.get(5).toString().equalsIgnoreCase("Vertical Name") &&
								//changes done by sanket mehta
								cellTempList.get(6).toString().equalsIgnoreCase("Module Name") &&
								//changes completed
								cellTempList.get(7).toString().equalsIgnoreCase("Req Description") &&
								cellTempList.get(8).toString().equalsIgnoreCase("Contact Person") &&
								cellTempList.get(9).toString().equalsIgnoreCase("Customization") &&
								cellTempList.get(10).toString().equalsIgnoreCase("MR Date")
						)
						{
							flag=0;
							
						}
						else
						{
							flag=0;
							throw new InvalidFileFormatException();
						}
					}

						toObj.setMasterRequirementTitle(cellTempList.get(1).toString().trim());
                        toObj.setExternalReferenceNumber(cellTempList.get(2).toString().trim());
                        System.out.println("name of  group before setting is: " + cellTempList.get(3).toString());
                        toObj.setGroupName(cellTempList.get(3).toString().trim());
                        System.out.println("name of  group after setting is: " + toObj.getGroupName());
                        toObj.setSolutionName(cellTempList.get(4).toString().trim());
                        //toObj.setModuleName(cellTempList.get(5).toString().trim());
                        toObj.setVerticalName(cellTempList.get(5).toString().trim());
                        System.out.println(" vertical name in UploadListMB: "+toObj.getVerticalName());
                        //toObj.setSubModuleName(cellTempList.get(6).toString().trim());
                        toObj.setModuleName(cellTempList.get(6).toString().trim());
                        System.out.println(" module name in UploadListMB: "+toObj.getModuleName());
                        toObj.setDescription(cellTempList.get(7).toString().trim());
                        toObj.setContactPerson(cellTempList.get(8).toString().trim());
                        System.out.println("contact no in xls file after setting: " + toObj.getContactPerson());
//                        System.out.println("customization in xls file before setting: " + cellTempList.get(7).toString());
                        toObj.setCustomization(cellTempList.get(9).toString().trim());
                        System.out.println("customization in xls file after setting: " + toObj.getCustomization());
//                        System.out.println("date in xls file after setting: " + cellTempList.get(8).toString());
                        String dateString = cellTempList.get(10).toString().trim();
                        System.out.println("date in xls file after setting: " + toObj.getMrDate());
                        if(!dateString.equalsIgnoreCase("MR Date") && !dateString.equalsIgnoreCase("customization"))
                        {
//                        	System.out.println("MR date string in upload: " + dateString);
//                        	Date date = new SimpleDateFormat().parse(dateString);
                        	Date date = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH).parse(dateString);
//                        	System.out.println("MR date in upload: " + date);
//                        
                        	if(date != null)
                        	{
                        		toObj.setMrDate(date);
                        	}
                        }
                        else
                        {
                        	toObj.setMrDate(null);
                        }
                        String ownerId=(String)(((HttpSession)(FacesContext.getCurrentInstance().getExternalContext().getSession(true))).getAttribute("EmployeeId"));
                        toObj.setOwnerEmployeeId(ownerId);
                        masterReqList.add(toObj);
				} 

				if(masterReqList.size()<=1)
				{
					fileInputStream.close();
					throw new MasterReqListIsEmptyException();
				}
				fileInputStream.close();
				wrapper.uploadMasterReqList(masterReqList);

				this.setMessage("File uploaded successfully");
			}
			else
			{
				throw new InvalidFileExtensionException();
			}
		}	 
		catch (InvalidFileExtensionException e) 
		{ 
			e.printStackTrace();
			this.setMessage(e.getMessage());

		} 
		catch (InvalidFileFormatException e) 
		{ 
			if(fileInputStream!=null)
			{
				try
				{
					fileInputStream.close();
				}
				catch(Exception ex)
				{
					e.printStackTrace();
					this.setMessage(ex.getMessage());
				}
				if(file!=null)
				{

					boolean result=file.delete();

					
				}
			}
			this.setMessage(e.getMessage());

		} 
		catch (MasterReqListIsEmptyException e) 
		{ 
			this.setMessage(e.getMessage());

		} 
		catch (Exception e) 
		{ 
			e.printStackTrace();
			this.setMessage(e.getMessage());
			
		} 

		return "uploaded"; 
	} 
	
	public String storeFile()
	{
		File file;
		String fileName =FilenameUtils.getName(uploadedFile.getName()); 
		String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-upload");
		 
		
		file = new File( filePath +fileName); 
		try
		{
		FileOutputStream output=new FileOutputStream(file);
		
		output.write(uploadedFile.getBytes());
		output.close();
		return "saved";
		
		}
		catch(Exception e)
		{
			
			return "fail";
		}
	}

		    
	public String downloadTemplate()
	{
		try
		{
			FRMS_Wrapper wrapper=new FRMS_Wrapper();
			String fName=wrapper.downloadMRTemplate();
			FileInputStream fileInputStream = new FileInputStream(fName);
			String fileName="MasterRequirementTemplate.xls";
			
			
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			HSSFWorkbook bidsReport = new HSSFWorkbook(fsFileSystem); 
			
			// Prepare response to show a Save As dialogue with Excel report.   
			FacesContext facesContext = FacesContext.getCurrentInstance();  
			ExternalContext externalContext = facesContext.getExternalContext();   
			
			HttpServletResponse response=(HttpServletResponse)externalContext.getResponse();
			response.setContentType("application/vnd.ms-excel");    
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); 
			// Write Excel report to response body.     
			bidsReport.write(response.getOutputStream());     
			// Inform JSF that response is completed and it thus doesn't have to navigate.  
			facesContext.responseComplete(); 
			
			
			this.setMessage(" Template downloaded successfully ");
			return "uploaded";
		}
		catch(NoGroupsAvailableException e)
		{
			this.message="Template can not be downloaded now as no Groups, Solutions or Modules available! Please add and then try downloading again";
			return "fail";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "fail";
		}
	 
	}
	
	// method for downloading PR Template
	public String downloadPRTemplate()
	{
		try
		{
			FRMS_Wrapper wrapper=new FRMS_Wrapper();
			String fName=wrapper.downloadPRTemplate();
			FileInputStream fileInputStream = new FileInputStream(fName);
			String fileName="ProductRequirementTemplate.xls";
			
			
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			HSSFWorkbook bidsReport = new HSSFWorkbook(fsFileSystem); 
			
			// Prepare response to show a Save As dialogue with Excel report.   
			FacesContext facesContext = FacesContext.getCurrentInstance();  
			ExternalContext externalContext = facesContext.getExternalContext();   
			
			HttpServletResponse response=(HttpServletResponse)externalContext.getResponse();
			response.setContentType("application/vnd.ms-excel");    
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); 
			// Write Excel report to response body.     
			bidsReport.write(response.getOutputStream());     
			// Inform JSF that response is completed and it thus doesn't have to navigate.  
			facesContext.responseComplete(); 
			
			
			this.setMessage(" Template downloaded successfully ");
			return "uploaded";
		}
		catch(NoGroupsAvailableException e)
		{
			this.message="Template can not be downloaded now as no Groups, Solutions or Modules available! Please add and then try downloading again";
			return "fail";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "fail";
		}
	 
	}
	
	
	
	public String downloadSample()
	{
		try
		{
			 
			
			String name="123.xls";
			String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-upload");
			String fileName= filePath+name;
			 
			FileInputStream fileInputStream = new FileInputStream(fileName);
			
			byte[] byteArray=new byte[1000000];
			int i=fileInputStream.read(byteArray);
			
			// Prepare response to show a Save As dialogue with Excel report.   
			FacesContext facesContext = FacesContext.getCurrentInstance();  
			ExternalContext externalContext = facesContext.getExternalContext();   
			
			HttpServletResponse response=(HttpServletResponse)externalContext.getResponse();
			response.setContentType("application/download");    
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); 
			// Write Excel report to response body.     
			//bidsReport.write(response.getOutputStream());    
			response.getOutputStream().write(byteArray);
			// Inform JSF that response is completed and it thus doesn't have to navigate.  
			facesContext.responseComplete(); 
			
			
			this.setMessage(" Template downloaded successfully ");
			return "uploaded";
		}
		catch(Exception e)
		{
			
			return "fail";
		}
	 
	}
	
	@SuppressWarnings("unchecked")
	public String uploadPRData()
	{ 
		System.out.println("inside uploadPRData function");
		this.message=null;
		ArrayList<String> MrId = new ArrayList<String>();
		
		if(this.uploadedFile==null)
		{
			this.message="Please select a file to upload";
			return "fail";
		}
		Integer flag=1;
		File file=null;
		 
		String fileName =FilenameUtils.getName(uploadedFile.getName()); 
		System.out.println("file name: "+fileName);
		String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
		System.out.println("file path: "+filePath);
		String inputFile=filePath+fileName;
		String fileExtension=FilenameUtils.getExtension(uploadedFile.getName());
		System.out.println("file extension: "+fileExtension);
		FileInputStream fileInputStream=null;
	
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		try 
		{
			if(fileExtension.equalsIgnoreCase("xls")== true)
			{
				
				
				file = new File(filePath +fileName); 
				try
				{
					FileOutputStream output=new FileOutputStream(file);

					output.write(uploadedFile.getBytes());
					output.close();


				}
				catch(Exception e)
				{
					e.printStackTrace();
					this.message="OOPS!! Error uploading file, Try Again!";
					return "fail";
				}   
				
				List<ProductRequirementTO> productReqList = new ArrayList<ProductRequirementTO>();


				 fileInputStream = new FileInputStream(inputFile); 

				/* 
				 * Create a new instance for POIFSFileSystem class 
				 */ 

				POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream); 

				/* 
				 * Create a new instance for HSSFWorkBook Class 
				 */ 

				HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem); 
				HSSFSheet hssfSheet = workBook.getSheetAt(0); 

				/* 
				 * Iterate the rows and cells of the spreadsheet to get all the data. 
				 */ 

				Iterator rowIterator = hssfSheet.rowIterator(); 

				int cnt=0;
				while (rowIterator.hasNext()) 
				{ 
					
					HSSFRow hssfRow = (HSSFRow) rowIterator.next(); 
					ProductRequirementTO toObj = new ProductRequirementTO();
					List cellTempList = new ArrayList();
//					Iterator iterator = hssfRow.cellIterator();
					
					//changes done by sanket mehta
					for(int cellValue = 0; cellValue < hssfRow.getLastCellNum(); ++cellValue)
					{
						HSSFCell hssfCell  = hssfRow.getCell(cellValue,Row.CREATE_NULL_AS_BLANK );
						cellTempList.add(hssfCell);
					}
//					while (iterator.hasNext()) 
//					{ 
//						
////						HSSFCell hssfCell = (HSSFCell) iterator.next(); 
//						 iterator.next();
//						cellTempList.add(hssfCell);
//					} 
					//changes completed
					System.out.println("size of celltemplist"+cellTempList.size()+"  num of iterations"+cnt);

					if(flag==1)
					{
						
						
						if(cellTempList.isEmpty())
						{
							throw new InvalidFileFormatException();
						}
						else if(cellTempList.get(0).toString().equalsIgnoreCase("SR No") &&
								cellTempList.get(1).toString().equalsIgnoreCase("MR ID") &&
								cellTempList.get(2).toString().equalsIgnoreCase("Product Req Title") &&
								cellTempList.get(3).toString().equalsIgnoreCase("Product Req Description") &&
								cellTempList.get(4).toString().equalsIgnoreCase("Product Version") &&
								/*cellTempList.get(4).toString().equalsIgnoreCase("Group Name") &&*/
								cellTempList.get(5).toString().equalsIgnoreCase("Localization") &&
								cellTempList.get(6).toString().equalsIgnoreCase("Functional Effort") &&
								cellTempList.get(7).toString().equalsIgnoreCase("Development Effort") &&
								cellTempList.get(8).toString().equalsIgnoreCase("DG Owner") &&
								cellTempList.get(9).toString().equalsIgnoreCase("Comments") &&
								cellTempList.get(10).toString().equalsIgnoreCase("FRS Owner") &&
								cellTempList.get(11).toString().equalsIgnoreCase("FRS Planned Date") &&
								cellTempList.get(12).toString().equalsIgnoreCase("SRS Owner") &&
								cellTempList.get(13).toString().equalsIgnoreCase("SRS Planned Date") &&
								cellTempList.get(14).toString().equalsIgnoreCase("Archie Impact") &&
								cellTempList.get(15).toString().equalsIgnoreCase("Core Impact") &&
								cellTempList.get(16).toString().equalsIgnoreCase("CRM Impact") &&
								cellTempList.get(17).toString().equalsIgnoreCase("FAS Impact") &&
								cellTempList.get(18).toString().equalsIgnoreCase("ODS Impact") &&
								cellTempList.get(19).toString().equalsIgnoreCase("FI Impact") &&
								cellTempList.get(20).toString().equalsIgnoreCase("E-Banking Impact") &&
								cellTempList.get(21).toString().equalsIgnoreCase("DirectBanking Impact") &&
								cellTempList.get(22).toString().equalsIgnoreCase("Origination Impact") &&
								cellTempList.get(23).toString().equalsIgnoreCase("FDM Impact") &&
								cellTempList.get(24).toString().equalsIgnoreCase("Treasury Impact") &&
								cellTempList.get(25).toString().equalsIgnoreCase("WMS Impact") &&
								cellTempList.get(26).toString().equalsIgnoreCase("FinanzTool Impact") &&								
								cellTempList.get(27).toString().equalsIgnoreCase("Multichannel Impact") &&
								cellTempList.get(28).toString().equalsIgnoreCase("SSO Impact") &&
								cellTempList.get(29).toString().equalsIgnoreCase("All24By7 Impact") &&
								cellTempList.get(30).toString().equalsIgnoreCase("SVS Impact") &&
								cellTempList.get(31).toString().equalsIgnoreCase("FAB Impact") &&								
								cellTempList.get(32).toString().equalsIgnoreCase("CSIS Impact") &&
								cellTempList.get(33).toString().equalsIgnoreCase("LOS Impact") &&	
								cellTempList.get(34).toString().equalsIgnoreCase("FCA Impact") &&
								cellTempList.get(35).toString().equalsIgnoreCase("ThirdParty Impact")
								
						)
						{
							flag=0;
							
						}
						else
						{
							flag=0;
							throw new InvalidFileFormatException();
						}
					}
					    toObj.setMasterRequirementId(cellTempList.get(1).toString().trim());
						/*toObj.setProductRequirementTitle(cellTempList.get(2).toString().trim());
                        toObj.setProductRequirementDescription(cellTempList.get(3).toString().trim());
                        toObj.setProductVersion(cellTempList.get(4).toString().trim());
                        toObj.setGroupName(cellTempList.get(4).toString().trim());
                        toObj.setLocalization(cellTempList.get(5).toString().trim());
                        toObj.setFunctionalEffort(cellTempList.get(6).toString().trim());
                        toObj.setDevelopmentEffort(cellTempList.get(7).toString().trim());                      
                        toObj.setDgOwner(cellTempList.get(8).toString().trim());
                        toObj.setComments(cellTempList.get(9).toString().trim());                      
                        toObj.setFrsName(cellTempList.get(10).toString().trim());
                        String dateString = cellTempList.get(11).toString().trim();                        
                       System.out.println("date in xls file before setting: " + toObj.getPlannedDateForFRS());
                        if(!dateString.equalsIgnoreCase("FRS Planned Date"))
                        {
                        	                     
                        	Date date = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH).parse(dateString);
                      	    System.out.println("FRS Planned Date in upload: " + date);
//                        
                        	if(date != null)
                        	{
                        		toObj.setPlannedDateForFRS(date);
                        	}
                        }
                        else
                        {
                        	toObj.setPlannedDateForFRS(null);
                        }
                        
                        toObj.setSrsName(cellTempList.get(12).toString().trim());
                        
                        String dateString1 = cellTempList.get(13).toString().trim();                        
                        //System.out.println("date in xls file after setting: " + toObj.getPlannedDateForSRS());
                        if(!dateString1.equalsIgnoreCase("SRS Planned Date"))
                        {      
                        	Date date1 = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH).parse(dateString1);
                       	    System.out.println("SRS Planned Date: " + date1);
                       
                        	if(date1 != null)
                        	{
                        		toObj.setPlannedDateForSRS(date1);
                        	}
                        }
                        else
                        {
                        	toObj.setPlannedDateForSRS(null);
                        }*/
                        
                        for(int i=2 ;cellTempList.size()>2 && i<cellTempList.size() ;i++){
                        	if(cellTempList.get(i).toString().trim()!=null && !cellTempList.get(i).toString().trim().isEmpty())
                        	{
                        		if(i==2)
                        			toObj.setProductRequirementTitle(cellTempList.get(i).toString().trim());
                        		if(i==3)
                        			toObj.setProductRequirementDescription(cellTempList.get(i).toString().trim());
                        		if(i==4)
                                    toObj.setProductVersion(cellTempList.get(i).toString().trim());
                        		if(i==5)
                        			toObj.setLocalization(cellTempList.get(i).toString().trim());
                        		if(i==6)
                        			toObj.setFunctionalEffort(cellTempList.get(i).toString().trim());
                        		if(i==7)
                        			toObj.setDevelopmentEffort(cellTempList.get(i).toString().trim()); 
                        		if(i==8)
                        			toObj.setDgOwner(cellTempList.get(i).toString().trim());
                        		if(i==9)
                        			toObj.setComments(cellTempList.get(i).toString().trim()); 
                        		if(i==10)
                        			toObj.setFrsName(cellTempList.get(i).toString().trim());
                        		if(i==11)
                        		{
                        			String dateString2 = cellTempList.get(i).toString().trim();                        
                                System.out.println("date in xls file before setting: " + toObj.getPlannedDateForFRS());
                                if(!dateString2.equalsIgnoreCase("FRS Planned Date"))
                                {
                                	                     
                                	Date date = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH).parse(dateString2);
                              	    System.out.println("FRS Planned Date in upload: " + date);
//                                
                                	if(date != null)
                                	{
                                		toObj.setPlannedDateForFRS(date);
                                	}
                                }
                                else
                                {
                                	toObj.setPlannedDateForFRS(null);
                                }
                        		}
                        		if(i==12)
                        			toObj.setSrsName(cellTempList.get(i).toString().trim());
                        		if(i==13)
                        		{
                        			 String dateString3 = cellTempList.get(i).toString().trim();                        
                                     //System.out.println("date in xls file after setting: " + toObj.getPlannedDateForSRS());
                                     if(!dateString3.equalsIgnoreCase("SRS Planned Date"))
                                     {      
                                     	Date date1 = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH).parse(dateString3);
                                    	    System.out.println("SRS Planned Date: " + date1);
                                    
                                     	if(date1 != null)
                                     	{
                                     		toObj.setPlannedDateForSRS(date1);
                                     	}
                                     }
                                     else
                                     {
                                     	toObj.setPlannedDateForSRS(null);
                                     }
                        		}
                        		
                        		if(i==14)
                        		 toObj.setArchieImpact(cellTempList.get(i).toString().trim());
                        	if(i==15)
                        		  toObj.setCoreImpact(cellTempList.get(i).toString().trim());
                        	if(i==16)
                        		 toObj.setCRMImpact(cellTempList.get(i).toString().trim());
                        	if(i==17)
                        		 toObj.setFASImpact(cellTempList.get(i).toString().trim());
                        	if(i==18)
                        		 toObj.setOdsImpact(cellTempList.get(i).toString().trim());
                        	if(i==19)
                        		  toObj.setFiImpact(cellTempList.get(i).toString().trim());
                        	if(i==20)
                        		   toObj.setEBankingImpact(cellTempList.get(i).toString().trim());
                        	if(i==21)
                        		  toObj.setDirectBankingImpact(cellTempList.get(i).toString().trim());	
                        	if(i==22)
                        		  toObj.setOriginationImpact(cellTempList.get(i).toString().trim());
                        	if(i==23)
                        		   toObj.setFDMImpact(cellTempList.get(i).toString().trim());
                        	if(i==24)
                        	       toObj.setTreasuryImpact(cellTempList.get(i).toString().trim());
                        	if(i==25)
                        		   toObj.setWMSImpact(cellTempList.get(i).toString().trim());
                        	if(i==26)
                        		   toObj.setFinanzToolImpact(cellTempList.get(i).toString().trim());
                        	if(i==27)
                        		   toObj.setSSOImpact(cellTempList.get(i).toString().trim());
                        	if(i==28)
                        		   toObj.setAll24By7Impact(cellTempList.get(i).toString().trim());
                        	if(i==29)
                        		   toObj.setSvsImpact(cellTempList.get(i).toString().trim());
                        	if(i==30)
                        		   toObj.setFabImpact(cellTempList.get(i).toString().trim());
                        	if(i==31)
                        		   toObj.setFDMImpact(cellTempList.get(i).toString().trim());
                        	if(i==32)
                        		   toObj.setCsisImpact(cellTempList.get(i).toString().trim());
                        	if(i==33)
                        		   toObj.setLOSImpact(cellTempList.get(i).toString().trim());
                        	if(i==34)
                        		   toObj.setFCAImpact(cellTempList.get(i).toString().trim());
                        	if(i==35)
                        		   toObj.setThirdPartyImpact(cellTempList.get(i).toString().trim());        
                        	}
                        		
                        }
                        
                                           
                         cnt++;
                         int checkMrStatus =0 ;
                         //System.out.println("my productlistsize"+productReqList.size());
                      	System.out.println("id im passing"+toObj.getMasterRequirementId());
                         checkMrStatus=wrapper.checkMrId(toObj.getMasterRequirementId());
                         //System.out.println("status value"+checkMrStatus);
                         if(checkMrStatus==0)                         
                        productReqList.add(toObj);
                         else
                        	 MrId.add(toObj.getMasterRequirementId());
                        	 
				} 

				/*if(productReqList.size()<=1)
				{
					fileInputStream.close();
					throw new MasterReqListIsEmptyException();
				}
				*/
				/*if()
				{
					fileInputStream.close();
					throw new AlreadyAcceptedException();
				}*/
				
				
				fileInputStream.close();
				if(productReqList.size()>1){
				wrapper.uploaProductReqList(productReqList);
				this.setMessage("File uploaded successfully");
				IdsAccepted(MrId);
				}
				else{
					if(MrId.size()>0)
					IdsAccepted(MrId);
					else{
						fileInputStream.close();
						throw new MasterReqListIsEmptyException();
					}
				}
					
				

				
			
			}
			else
			{
				throw new InvalidFileExtensionException();
			}
		}	 
		catch (InvalidFileExtensionException e) 
		{ 
			e.printStackTrace();
			this.setMessage(e.getMessage());

		} 
		catch (InvalidFileFormatException e) 
		{ 
			if(fileInputStream!=null)
			{
				try
				{
					fileInputStream.close();
				}
				catch(Exception ex)
				{
					e.printStackTrace();
					this.setMessage(ex.getMessage());
				}
				if(file!=null)
				{

					boolean result=file.delete();

					
				}
			}
			e.printStackTrace();
			this.setMessage(e.getMessage());

		} 
		catch (MasterReqListIsEmptyException e) 
		{ 
			e.printStackTrace();
			this.setMessage(e.getMessage());

		} 
		catch (Exception e) 
		{ 
			e.printStackTrace();
			this.setMessage(e.getMessage());
			
		} 

		return "uploaded"; 
	} 
	
	public void IdsAccepted(ArrayList<String> MrID){
		
		
		if(MrID.size()>0){
			String iDs =null;
			for(int i=0 ;i<MrID.size();i++){
				if(i==0)
				iDs=MrID.get(i);
				else
					iDs=iDs+","+MrID.get(i);
			}
			if(this.getMessage()!=null)
			this.setMessage(this.getMessage()+" and the given "+iDs+" already accepted as Product requirements.");
			else this.setMessage("The given "+iDs+" are already accepted as Product requirements.");
		
	}
	
}}
