package com.infy.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.util.CellRangeAddressList;

import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.MasterRequirementAttachmentTO;
import com.infy.entity.GroupInfo;
import com.infy.entity.MasterRequirmentAttachment;

public class DownloadService {
	private EntityManager em;
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	
	private HSSFCellStyle setHeaderStyle(HSSFWorkbook hwb)  
	{  
	 HSSFFont font = hwb.createFont();  
	 font.setFontName(HSSFFont.FONT_ARIAL);  
	 font.setColor(HSSFFont.COLOR_RED);  
	 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
	 HSSFCellStyle cellStyle = hwb.createCellStyle();  
	 cellStyle.setFont(font);  
	 return cellStyle;  
	 }  

	
	public void downloadMRTemplate()throws Exception
	{
		HSSFWorkbook hwb=new HSSFWorkbook();
		HSSFCellStyle cellStyle = setHeaderStyle(hwb);
		HSSFSheet sheet1 =  hwb.createSheet("Master Requirement Template");
		HSSFRow rowhead=   sheet1.createRow((short)0);
		
		HSSFCell firstHeaderCell = rowhead.createCell((short)0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("SR No"));
		
		HSSFCell secondHeaderCell = rowhead.createCell((short)1);
		secondHeaderCell.setCellStyle(cellStyle);
		secondHeaderCell.setCellValue(new HSSFRichTextString("Master Req Title"));
		
		HSSFCell thirdHeaderCell = rowhead.createCell((short)2);
		thirdHeaderCell.setCellStyle(cellStyle);
		thirdHeaderCell.setCellValue(new HSSFRichTextString("External Reference No"));
		
		HSSFCell fourthHeaderCell = rowhead.createCell((short)3);
		fourthHeaderCell.setCellStyle(cellStyle);
		fourthHeaderCell.setCellValue(new HSSFRichTextString("Group Name"));
		
		
		HSSFCell fifthHeaderCell = rowhead.createCell((short)4);
		fifthHeaderCell.setCellStyle(cellStyle);
		fifthHeaderCell.setCellValue(new HSSFRichTextString("Solution Name"));
		
		HSSFCell sixthHeaderCell = rowhead.createCell((short)5);
		sixthHeaderCell.setCellStyle(cellStyle);
		sixthHeaderCell.setCellValue(new HSSFRichTextString("Module Name"));
		
		HSSFCell seventhHeaderCell = rowhead.createCell((short)6);
		seventhHeaderCell.setCellStyle(cellStyle);
		seventhHeaderCell.setCellValue(new HSSFRichTextString("Req Description"));
		
		HSSFCell eightHeaderCell = rowhead.createCell((short)7);
		eightHeaderCell.setCellStyle(cellStyle);
		eightHeaderCell.setCellValue(new HSSFRichTextString("Contact Person"));
		
		
		
		try
		{
			String groupNameArray[]=getAllGroups();
			if(groupNameArray.length!=0)
			{
				CellRangeAddressList groupAddressList = new CellRangeAddressList(1, -1, 3, 3);
				DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(groupNameArray);
				DataValidation dataValidation = new HSSFDataValidation(groupAddressList,dvConstraint);
				dataValidation.setSuppressDropDownArrow(false);
				sheet1.addValidationData(dataValidation);
				File file=new File("MasterRequirementTemplate.xls");
				FileOutputStream fileOut = new FileOutputStream(file);
				hwb.write(fileOut);
				fileOut.close();
			}
		}
		catch(Exception e)
		{
			
			throw e;
		}
		
		
		
	}
	
	public String[] getAllGroups()throws Exception
	{
		EntityManager em=null;
		List<GroupInfoTO> toGroupList = new ArrayList<GroupInfoTO>() ;
		String groupNameArray[];
		try 
		{
			
			 
			em=emf.createEntityManager();
			Query query= em.createQuery("select gp.groupName from GroupInfo gp");

			List<String> rs1 = query.getResultList();
			String st=rs1.toString();
		 
			groupNameArray=st.substring(1,st.length()-1).split(",");
			
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
		return groupNameArray;
	
	}
	
	public boolean addAttachement(MasterRequirementAttachmentTO attachmentTO)throws Exception
	{

		EntityManager em=null;
		MasterRequirmentAttachment attachmentEntity=new MasterRequirmentAttachment();
		 
		try 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
			em=emf.createEntityManager();
			Query query=em.createQuery("select MAX(ma.MRAttachmentId) from  MasterRequirmentAttachment ma");
			String attachmentId = (String)query.getSingleResult();
			int id=0;
			if(attachmentId==null)
			{

				attachmentId="";
				id=100;
			}
			else
			{
				id=Integer.parseInt(attachmentId.substring(2,attachmentId.length()));
				id++;
			}
			String newId="MA"+String.valueOf(id);

		
			em.getTransaction().begin();
			attachmentEntity.setMasterRequirementId(attachmentTO.getMasterRequirementId());
			attachmentEntity.setFileName(attachmentTO.getFileName());
			 
			em.persist(attachmentEntity);
			em.getTransaction().commit();
			return true;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
