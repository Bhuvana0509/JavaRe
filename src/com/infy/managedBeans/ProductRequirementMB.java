package com.infy.managedBeans;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.infy.TOclasses.MasterRequirementTO;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.exceptions.NoProductReqAvailableException;
import com.infy.wrapper.FRMS_Wrapper;


public class ProductRequirementMB {
	
	private List<ProductRequirementTO> productRequirementsAssignedList;
	private List<ProductRequirementTO> productRequirementAssignedPerPageList;
	private HtmlDataTable htmlDataTable;
	private ProductRequirementTO productRequirementTO;
	private MasterRequirementTO masterRequirementTO;
	private String message;
	private Integer pageNumber;
	private Integer rowsPerPage;
	private List<SelectItem> pageNumberList;
	private List<ProductRequirementTO> viewProductReqPerPageList;
	private Integer displayPageNumber;
	private String pageMessage;
	
	
	private FacesContext facesContext;
	private ExternalContext externalContext;
	private HttpSession session;
	
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

	public List<ProductRequirementTO> getProductRequirementAssignedPerPageList() {
		return productRequirementAssignedPerPageList;
	}

	public void setProductRequirementAssignedPerPageList(
			List<ProductRequirementTO> productRequirementAssignedPerPageList) {
		this.productRequirementAssignedPerPageList = productRequirementAssignedPerPageList;
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

	public List<SelectItem> getPageNumberList() {
		return pageNumberList;
	}

	public void setPageNumberList(List<SelectItem> pageNumberList) {
		this.pageNumberList = pageNumberList;
	}

	public List<ProductRequirementTO> getViewProductReqPerPageList() {
		return viewProductReqPerPageList;
	}

	public void setViewProductReqPerPageList(
			List<ProductRequirementTO> viewProductReqPerPageList) {
		this.viewProductReqPerPageList = viewProductReqPerPageList;
	}

	public Integer getDisplayPageNumber() {
		return displayPageNumber;
	}

	public void setDisplayPageNumber(Integer displayPageNumber) {
		this.displayPageNumber = displayPageNumber;
	}

	public String getPageMessage() {
		return pageMessage;
	}

	public void setPageMessage(String pageMessage) {
		this.pageMessage = pageMessage;
	}

	public List<ProductRequirementTO> getProductRequirementsAssignedList() {
		return productRequirementsAssignedList;
	}

	public void setProductRequirementsAssignedList(
			List<ProductRequirementTO> productRequirementsAssignedList) {
		this.productRequirementsAssignedList = productRequirementsAssignedList;
	}

	public HtmlDataTable getHtmlDataTable() {
		return htmlDataTable;
	}

	public void setHtmlDataTable(HtmlDataTable htmlDataTable) {
		this.htmlDataTable = htmlDataTable;
	}

	public ProductRequirementTO getProductRequirementTO() {
		return productRequirementTO;
	}

	public void setProductRequirementTO(ProductRequirementTO productRequirementTO) {
		this.productRequirementTO = productRequirementTO;
	}

	public MasterRequirementTO getMasterRequirementTO() {
		return masterRequirementTO;
	}

	public void setMasterRequirementTO(MasterRequirementTO masterRequirementTO) {
		this.masterRequirementTO = masterRequirementTO;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	private String size;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
   /* //Default Constructor
	public ProductRequirementMB() {
		
		FRMS_Wrapper wrapper=new FRMS_Wrapper();
		try
		{
			  System.out.println("I wanted to populate the product scope list in constructor");
			facesContext=FacesContext.getCurrentInstance();
			externalContext=facesContext.getExternalContext();
			session=(HttpSession)externalContext.getSession(true);
			String ownerEmpId=(String)session.getAttribute("EmployeeId");
					
			//this.ownerMasterRequirementList=wrapper.getMasterRequirementListByOwner(ownerEmpId);
			//this.ownerAllMasterRequirementList=wrapper.getMasterRequirementListByOwner(ownerEmpId);
		
			this.productRequirementsAssignedList=new ArrayList<ProductRequirementTO>();


			String fullEmailId=(String)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("emailId");
	

			String emailId=fullEmailId.substring(0, fullEmailId.length()-12);


	        //this.productRequirementsAssignedList=wrapper.getProductRequirements("assignedTo",emailId);
			
			//added by Bhuvana 
			this.productRequirementsAssignedList=wrapper.getProductRequirementsAssignedToMe(ownerEmpId);
	

			System.out.println("I wanted to populate the product scope list3 "+ownerEmpId);
			//this.productScopeItemsList=wrapper.getProductScopeItemsList(ownerEmpId);
			System.out.println("productScopeItemsList Size: "+productScopeItemsList.size());
			
		    this.size=String.valueOf(productRequirementsAssignedList.size());
			this.pageNumber=1;
			this.rowsPerPage=10;
			int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
			int endRowNumber=this.pageNumber*this.rowsPerPage;
			if(endRowNumber>=this.productRequirementsAssignedList.size())
			{
				endRowNumber=this.productRequirementsAssignedList.size();
			}
			
			this.viewProductReqPerPageList=this.productRequirementsAssignedList.subList(startRowNumner, endRowNumber);
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.productRequirementsAssignedList.size();
			this.pageNumberList=new ArrayList<SelectItem>();
			int totalPageNumbers=(this.productRequirementsAssignedList.size()-1)/10;
			totalPageNumbers++;
			for(Integer i=1;i<=totalPageNumbers;i++)
			{
				this.pageNumberList.add(new SelectItem(i.toString(),i.toString()));
			}
		}
		catch(Exception e)
		{			System.out.println("@@@@" +e.getMessage());
		        
			this.message=e.getMessage();
		}
		

	}*/
	
	
	//Default Constructor
		public ProductRequirementMB() {
			
			FRMS_Wrapper wrapper=new FRMS_Wrapper();
			try
			{
				facesContext=FacesContext.getCurrentInstance();
				externalContext=facesContext.getExternalContext();
				session=(HttpSession)externalContext.getSession(true);
				String ownerEmpId=(String)session.getAttribute("EmployeeId");
				
				this.productRequirementsAssignedList=new ArrayList<ProductRequirementTO>();
				String fullEmailId=(String)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("emailId");
				String emailId=fullEmailId.substring(0, fullEmailId.length()-12);
				//this.productRequirementsAssignedList=wrapper.getProductRequirements("assignedTo",emailId);
				this.productRequirementsAssignedList=wrapper.getProductRequirementsAssignedToMe(ownerEmpId);
				this.pageNumber=1;
				this.rowsPerPage=10;
				int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
				int endRowNumber=this.pageNumber*this.rowsPerPage;
				if(endRowNumber>=this.productRequirementsAssignedList.size())
				{
					endRowNumber=this.productRequirementsAssignedList.size();
				}
				
				this.viewProductReqPerPageList=this.productRequirementsAssignedList.subList(startRowNumner, endRowNumber);
				this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.productRequirementsAssignedList.size();
				this.pageNumberList=new ArrayList<SelectItem>();
				int totalPageNumbers=(this.productRequirementsAssignedList.size()-1)/10;
				totalPageNumbers++;
				for(Integer i=1;i<=totalPageNumbers;i++)
				{
					this.pageNumberList.add(new SelectItem(i.toString(),i.toString()));
				}
			}
			catch(Exception e)
			{
				
				this.message=e.getMessage();
			}
			
			

		}
	
	
	public String showNextRecord()
	{
		this.message=null;
		this.pageNumber++;
		int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
		int endRowNumber=(this.pageNumber*this.rowsPerPage);
		if(startRowNumner<productRequirementsAssignedList.size())
		{
			if(endRowNumber>=this.productRequirementsAssignedList.size())
			{
				endRowNumber=this.productRequirementsAssignedList.size();
			}
			
			this.viewProductReqPerPageList=this.productRequirementsAssignedList.subList(startRowNumner, endRowNumber);
			 
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.productRequirementsAssignedList.size();
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
			 
			this.viewProductReqPerPageList=this.productRequirementsAssignedList.subList(startRowNumner, endRowNumber);
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.productRequirementsAssignedList.size();
			this.displayPageNumber=this.pageNumber;
		}
		
		
		return "show";
	}
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

	
	public String viewProductRequirementDetails()
	{
		try
		{
			this.productRequirementTO=(ProductRequirementTO)htmlDataTable.getRowData();
			this.masterRequirementTO=new FRMS_Wrapper().getMasterReqDetailsById(this.productRequirementTO.getMasterRequirementId());
			return "viewDetails";
		}
		catch(Exception e)
		{
			this.message=e.getMessage();
			return "fail";
		}
	}
	
	public String downloadProductReqList()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		
		try
		{
			String fName=wrapper.downloadProductRequirementsReport(this.productRequirementsAssignedList);
			FileInputStream fileInputStream = new FileInputStream(fName);
			String fileName="ProductRequirementsReport.xls";
			
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
		catch (NoProductReqAvailableException e) 
		{
			
			this.message=e.getMessage();
			return"fail";
		} 
		catch (Exception e)
		{
	
			this.message=e.getMessage();
			return"fail";
		}
   }
	
	
	
}
