package com.infy.service;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
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
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.util.CellRangeAddressList;

import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.MasterRequirementTO;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoMasterReqAvailableException;
import com.infy.exceptions.NoProductReqAvailableException;


public class ReportsService
{   
	//header styling class
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

	// group details REPORT
	@SuppressWarnings("deprecation")
	public String downloadGroupDetailsReport(List<GroupInfoTO> groupList) throws NoGroupsAvailableException,Exception
	{
		int index =0;

		try{

			if(!groupList.isEmpty())
			{
				//headers
				HSSFWorkbook hwb=new HSSFWorkbook();
				HSSFCellStyle cellStyle = setHeaderStyle(hwb);
				hwb.setBackupFlag(true);
				HSSFSheet sheet1 =  hwb.createSheet("sheet 1");
				
				HSSFRow rowhead=   sheet1.createRow((short)0);

				HSSFCell firstHeaderCell = rowhead.createCell((short)0);
				firstHeaderCell.setCellStyle(cellStyle);
				firstHeaderCell.setCellValue(new HSSFRichTextString("Group Id"));


				HSSFCell secondHeaderCell = rowhead.createCell((short)1);
				secondHeaderCell.setCellStyle(cellStyle);
				secondHeaderCell.setCellValue(new HSSFRichTextString("Group Name"));

				HSSFCell thirdHeaderCell = rowhead.createCell((short)2);
				thirdHeaderCell.setCellStyle(cellStyle);
				thirdHeaderCell.setCellValue(new HSSFRichTextString("Description"));

				HSSFCell fourthHeaderCell = rowhead.createCell((short)3);
				fourthHeaderCell.setCellStyle(cellStyle);
				fourthHeaderCell.setCellValue(new HSSFRichTextString("Initiating Group"));

				HSSFCell fifthHeaderCell = rowhead.createCell((short)4);
				fifthHeaderCell.setCellStyle(cellStyle);
				fifthHeaderCell.setCellValue(new HSSFRichTextString("Source"));

				HSSFCell sixthHeaderCell = rowhead.createCell((short)5);
				sixthHeaderCell.setCellStyle(cellStyle);
				sixthHeaderCell.setCellValue(new HSSFRichTextString("Location"));

				HSSFCell seventhHeaderCell = rowhead.createCell((short)6);
				seventhHeaderCell.setCellStyle(cellStyle);
				seventhHeaderCell.setCellValue(new HSSFRichTextString("Customer/Prospect"));

				HSSFCell eightHeaderCell = rowhead.createCell((short)7);
				eightHeaderCell.setCellStyle(cellStyle);
				eightHeaderCell.setCellValue(new HSSFRichTextString("SPOC"));

				HSSFCell ninthHeaderCell = rowhead.createCell((short)8);
				ninthHeaderCell.setCellStyle(cellStyle);
				ninthHeaderCell.setCellValue(new HSSFRichTextString("Comments"));

				for(int i=0;i<9;i++)
				{
					sheet1.setColumnWidth(i, 5000);
				}

				for (GroupInfoTO groupInfoTO : groupList)
				{
					HSSFRow row=   sheet1.createRow((short)++index);

					row.createCell((short) 0).setCellValue(groupInfoTO.getGroupId());
					row.createCell((short) 1).setCellValue(groupInfoTO.getGroupName());
					row.createCell((short) 2).setCellValue(groupInfoTO.getDescription());
					row.createCell((short) 3).setCellValue(groupInfoTO.getInitiatingGroupName());
					row.createCell((short) 4).setCellValue(groupInfoTO.getSourceName());
					row.createCell((short) 5).setCellValue(groupInfoTO.getLocationName());
					row.createCell((short) 6).setCellValue(groupInfoTO.getCustomer_prospect());
					row.createCell((short) 7).setCellValue(groupInfoTO.getSPOC());
					row.createCell((short) 8).setCellValue(groupInfoTO.getComment());
				}

				String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
				String fileName=filePath+"GroupDetailsReport.xls";
				FileOutputStream fileOut =  new FileOutputStream(fileName);
				hwb.write(fileOut);
				fileOut.close();
				return fileName;
			}

			else
			{
				throw new  NoGroupsAvailableException();
			}
		}
		catch (NoGroupsAvailableException e) 
			{   
				throw(e);
			}   
		
		catch (Exception e) 
			{   
				throw(e);
			}   
		
		
		}
	
	//Master Requirements REPORT
		@SuppressWarnings("deprecation")
		public String downloadMasterRequirementsReport(List<MasterRequirementTO> masterReqList)throws NoMasterReqAvailableException,Exception
		{
			int index =0;
			try{
				
				if(!masterReqList.isEmpty())
				{
					//headers
					HSSFWorkbook hwb=new HSSFWorkbook();
					HSSFCellStyle cellStyle = setHeaderStyle(hwb);
					HSSFSheet sheet1 =  hwb.createSheet("sheet 1");
					HSSFRow rowhead=   sheet1.createRow((short)0);

					HSSFCell firstHeaderCell = rowhead.createCell((short)0);
					firstHeaderCell.setCellStyle(cellStyle);
					firstHeaderCell.setCellValue(new HSSFRichTextString("Master Req Id"));

					HSSFCell secondHeaderCell = rowhead.createCell((short)1);
					secondHeaderCell.setCellStyle(cellStyle);
					secondHeaderCell.setCellValue(new HSSFRichTextString("Master Req Title"));

					HSSFCell thirdHeaderCell = rowhead.createCell((short)2);
					thirdHeaderCell.setCellStyle(cellStyle);
					thirdHeaderCell.setCellValue(new HSSFRichTextString("External Reference No"));

					HSSFCell fourthHeaderCell = rowhead.createCell((short)3);
					fourthHeaderCell.setCellStyle(cellStyle);
					fourthHeaderCell.setCellValue(new HSSFRichTextString("Group Name"));

					//changes done by sanket mehta
					HSSFCell fifthHeaderCell = rowhead.createCell((short)4);
					fifthHeaderCell.setCellStyle(cellStyle);
					fifthHeaderCell.setCellValue(new HSSFRichTextString("Region"));
					//changes complete
					
					HSSFCell sixthHeaderCell = rowhead.createCell((short)5);
					sixthHeaderCell.setCellStyle(cellStyle);
					sixthHeaderCell.setCellValue(new HSSFRichTextString("Solution Name"));

					/*HSSFCell seventhHeaderCell = rowhead.createCell((short)6);
					seventhHeaderCell.setCellStyle(cellStyle);
					seventhHeaderCell.setCellValue(new HSSFRichTextString("Module Name"));*/
					
					HSSFCell seventhHeaderCell = rowhead.createCell((short)6);
					seventhHeaderCell.setCellStyle(cellStyle);
					seventhHeaderCell.setCellValue(new HSSFRichTextString("Vertical Name"));

					/*HSSFCell eightHeaderCell = rowhead.createCell((short)7);
					eightHeaderCell.setCellStyle(cellStyle);
					eightHeaderCell.setCellValue(new HSSFRichTextString("Sub Module Name"));*/
					
					HSSFCell eightHeaderCell = rowhead.createCell((short)7);
					eightHeaderCell.setCellStyle(cellStyle);
					eightHeaderCell.setCellValue(new HSSFRichTextString("Module Name"));
					
					HSSFCell ninthHeaderCell = rowhead.createCell((short)8);
					ninthHeaderCell.setCellStyle(cellStyle);
					ninthHeaderCell.setCellValue(new HSSFRichTextString("Req Description"));

					HSSFCell tenthHeaderCell = rowhead.createCell((short)9);
					tenthHeaderCell.setCellStyle(cellStyle);
					tenthHeaderCell.setCellValue(new HSSFRichTextString("Contact Person"));

					HSSFCell elevanthHeaderCell = rowhead.createCell((short)10);
					elevanthHeaderCell.setCellStyle(cellStyle);
					elevanthHeaderCell.setCellValue(new HSSFRichTextString("Master Req Status"));
					
					//changes done by sanket mehta
					HSSFCell twelvethHeaderCell = rowhead.createCell((short)11);
					twelvethHeaderCell.setCellStyle(cellStyle);
					twelvethHeaderCell.setCellValue(new HSSFRichTextString("Customization"));
					
					HSSFCell thirteenthHeaderCell = rowhead.createCell((short)12);
					thirteenthHeaderCell.setCellStyle(cellStyle);
					thirteenthHeaderCell.setCellValue(new HSSFRichTextString("MRDate"));
					//changes complete

					//cell data from database
					for(int i=0;i<13;i++)
					{
						sheet1.setColumnWidth(i, 5000);
					}

					for (MasterRequirementTO masterReqTo : masterReqList)
					{
						HSSFRow row=   sheet1.createRow((short)++index);

						row.createCell((short) 0).setCellValue(masterReqTo.getMasterRequirementId());
						row.createCell((short) 1).setCellValue(masterReqTo.getMasterRequirementTitle());
						row.createCell((short) 2).setCellValue(masterReqTo.getExternalReferenceNumber());
						row.createCell((short) 3).setCellValue(masterReqTo.getGroupName());
						//changes done by sanket mehta
						row.createCell((short) 4).setCellValue(masterReqTo.getLocationName());
						//changes completed
						row.createCell((short) 5).setCellValue(masterReqTo.getSolutionName());
						//row.createCell((short) 6).setCellValue(masterReqTo.getModuleName());
						row.createCell((short) 6).setCellValue(masterReqTo.getVerticalName());
						//row.createCell((short) 7).setCellValue(masterReqTo.getSubModuleName());
						row.createCell((short) 7).setCellValue(masterReqTo.getModuleName());
						row.createCell((short) 8).setCellValue(masterReqTo.getDescription());
						row.createCell((short) 9).setCellValue(masterReqTo.getContactPerson());
						row.createCell((short) 10).setCellValue(masterReqTo.getStatus());
						//changes done by sanket mehta
						row.createCell((short) 11).setCellValue(masterReqTo.getCustomization());
						Date date = masterReqTo.getMrDate();
						DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
						String formattedDate = null; 
						if(date != null)
						{
							
							formattedDate = df.format(date);
							System.out.println("date in report: " + formattedDate);
						}
						System.out.println("date outside loop in report: " + formattedDate);
						row.createCell((short) 12).setCellValue(formattedDate);
						//changes complete
					}


					String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
					String fileName=filePath+"MasterRequirementsReport.xls";
					FileOutputStream fileOut =  new FileOutputStream(fileName);		

					hwb.write(fileOut);
					fileOut.close();
					return fileName;

				}
				else
				{
					throw new NoMasterReqAvailableException();
				}
			}
			catch (NoMasterReqAvailableException e) 
			{   
				throw(e);
			}  
			catch (Exception e) 
			{   
				throw(e);
			}   
		}
		
		//Product Requirements REPORT
		@SuppressWarnings("deprecation")
		public String downloadProductRequirementsReport(List<ProductRequirementTO> productReqList)throws NoProductReqAvailableException,Exception
		{
			int index =0;
			try{
				if(!productReqList.isEmpty())
				{	
					//headers
					HSSFWorkbook hwb=new HSSFWorkbook();
					HSSFCellStyle cellStyle = setHeaderStyle(hwb);
					HSSFSheet sheet1 =  hwb.createSheet("sheet 1");
					HSSFRow rowhead=   sheet1.createRow((short)0);

					HSSFCell firstHeaderCell = rowhead.createCell((short)0);
					firstHeaderCell.setCellStyle(cellStyle);
					firstHeaderCell.setCellValue(new HSSFRichTextString("Product Req Id"));

					HSSFCell secondHeaderCell = rowhead.createCell((short)1);
					secondHeaderCell.setCellStyle(cellStyle);
					secondHeaderCell.setCellValue(new HSSFRichTextString("Product req Title"));

					HSSFCell thirdHeaderCell = rowhead.createCell((short)2);
					thirdHeaderCell.setCellStyle(cellStyle);
					thirdHeaderCell.setCellValue(new HSSFRichTextString("Product Req Version"));

					HSSFCell fourthHeaderCell = rowhead.createCell((short)3);
					fourthHeaderCell.setCellStyle(cellStyle);
					fourthHeaderCell.setCellValue(new HSSFRichTextString("Product Req Description"));

					HSSFCell fifthHeaderCell = rowhead.createCell((short)4);
					fifthHeaderCell.setCellStyle(cellStyle);
					fifthHeaderCell.setCellValue(new HSSFRichTextString("Master Req Id"));

					HSSFCell sixthHeaderCell = rowhead.createCell((short)5);
					sixthHeaderCell.setCellStyle(cellStyle);
					sixthHeaderCell.setCellValue(new HSSFRichTextString("Master Req Title"));

					HSSFCell seventhHeaderCell = rowhead.createCell((short)6);
					seventhHeaderCell.setCellStyle(cellStyle);
					seventhHeaderCell.setCellValue(new HSSFRichTextString("Group Name"));

					//changes done by sanket mehta
					HSSFCell eightHeaderCell = rowhead.createCell((short)7);
					eightHeaderCell.setCellStyle(cellStyle);
					eightHeaderCell.setCellValue(new HSSFRichTextString("Region"));
					//changes completed
					
					/*HSSFCell ninthHeaderCell = rowhead.createCell((short)8);
					ninthHeaderCell.setCellStyle(cellStyle);
					ninthHeaderCell.setCellValue(new HSSFRichTextString("Module Name"));*/
					
					HSSFCell ninthHeaderCell = rowhead.createCell((short)8);
					ninthHeaderCell.setCellStyle(cellStyle);
					ninthHeaderCell.setCellValue(new HSSFRichTextString("Vertical Name"));

					/*HSSFCell tenthHeaderCell = rowhead.createCell((short)9);
					tenthHeaderCell.setCellStyle(cellStyle);
					tenthHeaderCell.setCellValue(new HSSFRichTextString("SubModule Name"));*/
					HSSFCell tenthHeaderCell = rowhead.createCell((short)9);
					tenthHeaderCell.setCellStyle(cellStyle);
					tenthHeaderCell.setCellValue(new HSSFRichTextString("Module Name"));
					
					HSSFCell eleventhHeaderCell = rowhead.createCell((short)10);
					eleventhHeaderCell.setCellStyle(cellStyle);
					eleventhHeaderCell.setCellValue(new HSSFRichTextString("Localization"));

					HSSFCell twelvethHeaderCell = rowhead.createCell((short)11);
					twelvethHeaderCell.setCellStyle(cellStyle);
					twelvethHeaderCell.setCellValue(new HSSFRichTextString("Functional Efforts"));

					HSSFCell thirteenthHeaderCell = rowhead.createCell((short)12);
					thirteenthHeaderCell.setCellStyle(cellStyle);
					thirteenthHeaderCell.setCellValue(new HSSFRichTextString("Developement Efforts"));

					HSSFCell forteenthHeaderCell = rowhead.createCell((short)13);
					forteenthHeaderCell.setCellStyle(cellStyle);
					forteenthHeaderCell.setCellValue(new HSSFRichTextString("DG Owner"));

					HSSFCell cell13 = rowhead.createCell((short)14);
					cell13.setCellStyle(cellStyle);
					cell13.setCellValue(new HSSFRichTextString("Comments"));
					
					 
					HSSFCell cell14 = rowhead.createCell((short)15);
					cell14.setCellStyle(cellStyle);
					cell14.setCellValue(new HSSFRichTextString("FRS ID"));
					
					 
					
					
					//-----FRS-----

					HSSFCell fifteenthHeaderCell = rowhead.createCell((short)16);
					fifteenthHeaderCell.setCellStyle(cellStyle);
					fifteenthHeaderCell.setCellValue(new HSSFRichTextString("FRS Document Name"));
					
					HSSFCell cell15 = rowhead.createCell((short)17);
					cell15.setCellStyle(cellStyle);
					cell15.setCellValue(new HSSFRichTextString("Project Code"));
					
					HSSFCell cell16 = rowhead.createCell((short)18);
					cell16.setCellStyle(cellStyle);
					cell16.setCellValue(new HSSFRichTextString("FRS Owner"));
					
					HSSFCell cell17 = rowhead.createCell((short)19);
					cell17.setCellStyle(cellStyle);
					cell17.setCellValue(new HSSFRichTextString("FRS Status"));
					
					HSSFCell cell18 = rowhead.createCell((short)20);
					cell18.setCellStyle(cellStyle);
					cell18.setCellValue(new HSSFRichTextString("Planned Date For FRS"));
					
					HSSFCell cell19 = rowhead.createCell((short)21);
					cell19.setCellStyle(cellStyle);
					cell19.setCellValue(new HSSFRichTextString("Actual Date For FRS"));
					
					HSSFCell cell20 = rowhead.createCell((short)22);
					cell20.setCellStyle(cellStyle);
					cell20.setCellValue(new HSSFRichTextString("Group Review Date For FRS"));
					
					HSSFCell cell21 = rowhead.createCell((short)23);
					cell21.setCellStyle(cellStyle);
					cell21.setCellValue(new HSSFRichTextString("Remarks"));
					
					
					HSSFCell cell22 = rowhead.createCell((short)24);
					cell22.setCellStyle(cellStyle);
					cell22.setCellValue(new HSSFRichTextString("FRS Checked In TFS"));
					
					//-------------SRS
					
					HSSFCell cell23 = rowhead.createCell((short)25);
					cell23.setCellStyle(cellStyle);
					cell23.setCellValue(new HSSFRichTextString("SRS ID"));
					
					HSSFCell cell24 = rowhead.createCell((short)26);
					cell24.setCellStyle(cellStyle);
					cell24.setCellValue(new HSSFRichTextString("SRS Document Name"));
					
					HSSFCell cell25 = rowhead.createCell((short)27);
					cell25.setCellStyle(cellStyle);
					cell25.setCellValue(new HSSFRichTextString("SRS Owner"));
					
					HSSFCell cell26 = rowhead.createCell((short)28);
					cell26.setCellStyle(cellStyle);
					cell26.setCellValue(new HSSFRichTextString("SRS Status"));
					
					HSSFCell cell27 = rowhead.createCell((short)29);
					cell27.setCellStyle(cellStyle);
					cell27.setCellValue(new HSSFRichTextString("Planned Date for SRS"));
					
					HSSFCell cell28 = rowhead.createCell((short)30);
					cell28.setCellStyle(cellStyle);
					cell28.setCellValue(new HSSFRichTextString("Actual Date for SRS"));
					
					HSSFCell cell29 = rowhead.createCell((short)31);
					cell29.setCellStyle(cellStyle);
					cell29.setCellValue(new HSSFRichTextString("Group Review Date for SRS"));
					
					HSSFCell cell30 = rowhead.createCell((short)32);
					cell30.setCellStyle(cellStyle);
					cell30.setCellValue(new HSSFRichTextString("Reamrks"));
					
					HSSFCell cell31 = rowhead.createCell((short)33);
					cell31.setCellStyle(cellStyle);
					cell31.setCellValue(new HSSFRichTextString("SRS Checked In TFS"));
					
					HSSFCell cell32 = rowhead.createCell((short)34);
					cell32.setCellStyle(cellStyle);
					cell32.setCellValue(new HSSFRichTextString("RA Anchor"));
					
					
					//impacts
					
					HSSFCell cell33 = rowhead.createCell((short)35);
					cell33.setCellStyle(cellStyle);
					cell33.setCellValue(new HSSFRichTextString("ImpactID"));
					
					HSSFCell cell34 = rowhead.createCell((short)36);
					cell34.setCellStyle(cellStyle);
					cell34.setCellValue(new HSSFRichTextString("Archie Impact"));
					
					HSSFCell cell35 = rowhead.createCell((short)37);
					cell35.setCellStyle(cellStyle);
					cell35.setCellValue(new HSSFRichTextString("Core Impact"));
					
					HSSFCell cell36 = rowhead.createCell((short)38);
					cell36.setCellStyle(cellStyle);
					cell36.setCellValue(new HSSFRichTextString("CRM Impact"));
					
					HSSFCell cell37 = rowhead.createCell((short)39);
					cell37.setCellStyle(cellStyle);
					cell37.setCellValue(new HSSFRichTextString("FAS Impact"));
					
					HSSFCell cell38 = rowhead.createCell((short)40);
					cell38.setCellStyle(cellStyle);
					cell38.setCellValue(new HSSFRichTextString("OSD Impact"));
					
					HSSFCell cell39 = rowhead.createCell((short)41);
					cell39.setCellStyle(cellStyle);
					cell39.setCellValue(new HSSFRichTextString("FI Impact"));
					
					HSSFCell cell40 = rowhead.createCell((short)42);
					cell40.setCellStyle(cellStyle);
					cell40.setCellValue(new HSSFRichTextString("E-Banking Impact"));
					
					HSSFCell cell41 = rowhead.createCell((short)43);
					cell41.setCellStyle(cellStyle);
					cell41.setCellValue(new HSSFRichTextString("Direct Banking Impact"));
					
					HSSFCell cell42 = rowhead.createCell((short)44);
					cell42.setCellStyle(cellStyle);
					cell42.setCellValue(new HSSFRichTextString("Origination Impact"));
					
					HSSFCell cell43 = rowhead.createCell((short)45);
					cell43.setCellStyle(cellStyle);
					cell43.setCellValue(new HSSFRichTextString("FDMI Impact"));
					
					HSSFCell cell44 = rowhead.createCell((short)46);
					cell44.setCellStyle(cellStyle);
					cell44.setCellValue(new HSSFRichTextString("Treasury Impact"));
					
					HSSFCell cell45 = rowhead.createCell((short)47);
					cell45.setCellStyle(cellStyle);
					cell45.setCellValue(new HSSFRichTextString("WMS Impact"));
					
					HSSFCell cell46 = rowhead.createCell((short)48);
					cell46.setCellStyle(cellStyle);
					cell46.setCellValue(new HSSFRichTextString("Finanz Tool Impact"));
					
					HSSFCell cell47 = rowhead.createCell((short)49);
					cell47.setCellStyle(cellStyle);
					cell47.setCellValue(new HSSFRichTextString("MultiChannel Impact"));
					
					HSSFCell cell48 = rowhead.createCell((short)50);
					cell48.setCellStyle(cellStyle);
					cell48.setCellValue(new HSSFRichTextString("SSO Impact"));
					
					HSSFCell cell49 = rowhead.createCell((short)51);
					cell49.setCellStyle(cellStyle);
					cell49.setCellValue(new HSSFRichTextString("24X7 Impact"));
					
					HSSFCell cell50 = rowhead.createCell((short)52);
					cell50.setCellStyle(cellStyle);
					cell50.setCellValue(new HSSFRichTextString("SVS Impact"));
					
					HSSFCell cell51 = rowhead.createCell((short)53);
					cell51.setCellStyle(cellStyle);
					cell51.setCellValue(new HSSFRichTextString("FAB Impact"));
					
					HSSFCell cell52 = rowhead.createCell((short)54);
					cell52.setCellStyle(cellStyle);
					cell52.setCellValue(new HSSFRichTextString("CSIS Impact"));
					
					HSSFCell cell53 = rowhead.createCell((short)55);
					cell53.setCellStyle(cellStyle);
					cell53.setCellValue(new HSSFRichTextString("LOS Impact"));
					
					HSSFCell cell54 = rowhead.createCell((short)56);
					cell54.setCellStyle(cellStyle);
					cell54.setCellValue(new HSSFRichTextString("FCA Impact"));
					
					HSSFCell cell55 = rowhead.createCell((short)57);
					cell55.setCellStyle(cellStyle);
					cell55.setCellValue(new HSSFRichTextString("Third Party Impact"));
					
					for(int i=0;i<57;i++)
					{
						sheet1.setColumnWidth(i, 5000);
					}
					for (ProductRequirementTO productReqTo : productReqList)
					{

						HSSFRow row=   sheet1.createRow((short)++index);

						row.createCell((short) 0).setCellValue(productReqTo.getProductRequirementId());
						row.createCell((short) 1).setCellValue(productReqTo.getProductRequirementTitle());
						row.createCell((short) 2).setCellValue(productReqTo.getProductVersion());
						row.createCell((short) 3).setCellValue(productReqTo.getProductRequirementDescription());
						row.createCell((short) 4).setCellValue(productReqTo.getMasterRequirementId());
						row.createCell((short) 5).setCellValue(productReqTo.getMasterRequirementTitle());
						row.createCell((short) 6).setCellValue(productReqTo.getGroupName());
						//changes done by sanket mehta
						row.createCell((short) 7).setCellValue(productReqTo.getLocationName());
						//changes completed
						/*row.createCell((short) 8).setCellValue(productReqTo.getModuleName());
						row.createCell((short) 9).setCellValue(productReqTo.getSubModuleName());*/
						row.createCell((short) 8).setCellValue(productReqTo.getVerticalName());
						row.createCell((short) 9).setCellValue(productReqTo.getModuleName());
						row.createCell((short) 10).setCellValue(productReqTo.getLocalization());
						row.createCell((short) 11).setCellValue(productReqTo.getFunctionalEffort());
						row.createCell((short) 12).setCellValue(productReqTo.getDevelopmentEffort());
						row.createCell((short) 13).setCellValue(productReqTo.getDgOwner());
						row.createCell((short) 14).setCellValue(productReqTo.getComments());
					
						//---FRS
						row.createCell((short) 15).setCellValue(productReqTo.getFrsId()); 
						row.createCell((short) 16).setCellValue(productReqTo.getFRSDocumentName());
						row.createCell((short) 17).setCellValue(productReqTo.getProjectCode());
						row.createCell((short) 18).setCellValue(productReqTo.getFrsOwnerEmailId());
						row.createCell((short) 19).setCellValue(productReqTo.getFrsStatus());
						Date dt=new Date(0,0,0);
						row.createCell((short) 20).setCellValue((productReqTo.getPlannedDateForFRS()!=null)? new SimpleDateFormat("dd-MMM-yyyy").format(productReqTo.getPlannedDateForFRS()):new String());
						row.createCell((short) 21).setCellValue((productReqTo.getActualDateForFRS()!=null) ? new SimpleDateFormat("dd-MMM-yyyy").format(productReqTo.getActualDateForFRS()):new String());
						row.createCell((short) 22).setCellValue((productReqTo.getGroupReviewDateForFRS()!=null) ? new SimpleDateFormat("dd-MMM-yyyy").format(productReqTo.getGroupReviewDateForFRS()):new String());
						row.createCell((short) 23).setCellValue(productReqTo.getFrsRemarks());
						row.createCell((short) 24).setCellValue(productReqTo.getFrsCheckedInTFS());
				
						
						//---SRS
						
						row.createCell((short) 25).setCellValue(productReqTo.getSrsId());
						row.createCell((short) 26).setCellValue(productReqTo.getSRSDocumentName());
						row.createCell((short) 27).setCellValue(productReqTo.getSrsOwnerEmailId());
						row.createCell((short) 28).setCellValue(productReqTo.getSrsStatus());
						row.createCell((short) 29).setCellValue((productReqTo.getPlannedDateForSRS()!=null ) ? new SimpleDateFormat("dd-MMM-yyyy").format(productReqTo.getPlannedDateForSRS()):new String());
						row.createCell((short) 30).setCellValue((productReqTo.getActualDateForSRS()!=null ) ? new SimpleDateFormat("dd-MMM-yyyy").format(productReqTo.getActualDateForSRS()):new String());
						row.createCell((short) 31).setCellValue((productReqTo.getGroupReviewDateForSRS()!=null ) ? new SimpleDateFormat("dd-MMM-yyyy").format(productReqTo.getGroupReviewDateForSRS()):new String());
						row.createCell((short) 32).setCellValue(productReqTo.getSrsRemarks());
						row.createCell((short) 33).setCellValue(productReqTo.getSrsCheckedInTFS());
						row.createCell((short) 34).setCellValue(productReqTo.getSrsRAAnchor());
				
						//---Impacts
						
						
						row.createCell((short) 35).setCellValue(productReqTo.getImpactId());
						row.createCell((short) 36).setCellValue(productReqTo.getArchieImpact());
						row.createCell((short) 37).setCellValue(productReqTo.getCoreImpact());
						row.createCell((short) 38).setCellValue(productReqTo.getCRMImpact());
						row.createCell((short) 39).setCellValue(productReqTo.getFASImpact());
						row.createCell((short) 40).setCellValue(productReqTo.getOdsImpact());
						row.createCell((short) 41).setCellValue(productReqTo.getFiImpact());
						row.createCell((short) 42).setCellValue(productReqTo.getEBankingImpact());
						row.createCell((short) 43).setCellValue(productReqTo.getDirectBankingImpact());
						row.createCell((short) 44).setCellValue(productReqTo.getOriginationImpact());
						row.createCell((short) 45).setCellValue(productReqTo.getFDMImpact());
						row.createCell((short) 46).setCellValue(productReqTo.getTreasuryImpact());
						row.createCell((short) 47).setCellValue(productReqTo.getWMSImpact());
						row.createCell((short) 48).setCellValue(productReqTo.getFinanzToolImpact());
						row.createCell((short) 49).setCellValue(productReqTo.getMultichannelImpact());
						row.createCell((short) 50).setCellValue(productReqTo.getSSOImpact());
						row.createCell((short) 51).setCellValue(productReqTo.getAll24By7Impact());
						row.createCell((short) 52).setCellValue(productReqTo.getSvsImpact());
						row.createCell((short) 53).setCellValue(productReqTo.getFabImpact());
						row.createCell((short) 54).setCellValue(productReqTo.getCsisImpact());
						row.createCell((short) 55).setCellValue(productReqTo.getLOSImpact());
						row.createCell((short) 56).setCellValue(productReqTo.getFCAImpact());
						row.createCell((short) 57).setCellValue(productReqTo.getThirdPartyImpact());
					
						
						 
						
					}

					String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
					String fileName=filePath+"ProductRequirementsReport.xls";
					FileOutputStream fileOut =  new FileOutputStream(fileName);	


					hwb.write(fileOut);
					fileOut.close();
					return fileName;

				}
				else
				{
					throw new NoProductReqAvailableException();
				}
			}
		catch (NoProductReqAvailableException e) 
			{   
				throw(e);
			 
			}   
		catch (Exception e) 
			{   
				throw(e);
			 
			}   
		}
		
	
	
	// download master requirement template
	@SuppressWarnings("deprecation")
	public String downloadMRTemplate()throws Exception
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
		
		/*HSSFCell sixthHeaderCell = rowhead.createCell((short)5);
		sixthHeaderCell.setCellStyle(cellStyle);
		sixthHeaderCell.setCellValue(new HSSFRichTextString("Module Name"));*/
		
		HSSFCell sixthHeaderCell = rowhead.createCell((short)5);
		sixthHeaderCell.setCellStyle(cellStyle);
		sixthHeaderCell.setCellValue(new HSSFRichTextString("Vertical Name"));
		
		//changes done by sanket mehta
		/*HSSFCell seventhHeaderCell = rowhead.createCell((short)6);
		seventhHeaderCell.setCellStyle(cellStyle);
		seventhHeaderCell.setCellValue(new HSSFRichTextString("SubModule Name"));*/
		
		HSSFCell seventhHeaderCell = rowhead.createCell((short)6);
		seventhHeaderCell.setCellStyle(cellStyle);
		seventhHeaderCell.setCellValue(new HSSFRichTextString("Module Name"));
		
		//changes completed
		HSSFCell eightHeaderCell = rowhead.createCell((short)7);
		eightHeaderCell.setCellStyle(cellStyle);
		eightHeaderCell.setCellValue(new HSSFRichTextString("Req Description"));
		
		HSSFCell ninthHeaderCell = rowhead.createCell((short)8);
		ninthHeaderCell.setCellStyle(cellStyle);
		ninthHeaderCell.setCellValue(new HSSFRichTextString("Contact Person"));
		
		// Changes done by Bhuvana
		HSSFCell tenthHeaderCell = rowhead.createCell((short)9);
		tenthHeaderCell.setCellStyle(cellStyle);
		tenthHeaderCell.setCellValue(new HSSFRichTextString("Customization"));
		
		// changes complete
	
		HSSFCell eleventhHeaderCell = rowhead.createCell((short)10);
		eleventhHeaderCell.setCellStyle(cellStyle);
		eleventhHeaderCell.setCellValue(new HSSFRichTextString("MR Date"));
		try
		{
			String groupNameArray[]=getAllGroups();
			// Changes made by Bhuvana
			String[] customization= {"Yes","No"};
			//System.out.println("****"+ Arrays.toString(customization));
			String fileName = null;
			// Changes completed
			if(groupNameArray.length!=0)
			{
				
                HSSFSheet hidden = hwb.createSheet("hidden");
//              System.out.println("length of grouplist is: "+  groupNameArray.length);
                for (int i = 0, length= groupNameArray.length; i < length; i++)
                {    
                       String name = groupNameArray[i];
//                     System.out.println("name of group is: "+  name);
                       HSSFRow row = hidden.createRow(i);
                       HSSFCell cell = row.createCell(0);    
                       cell.setCellValue(name);  
                } 
                Name namedCell = hwb.createName();  
                namedCell.setNameName("hidden");  
                namedCell.setRefersToFormula("hidden!$A$1:$A$" + groupNameArray.length);  
                DVConstraint constraint = DVConstraint.createFormulaListConstraint("hidden");  
                CellRangeAddressList addressList = new CellRangeAddressList(1, -1, 3, 3);  
                HSSFDataValidation validation = new HSSFDataValidation(addressList, constraint);  
                hwb.setSheetHidden(1, true);  
                
                sheet1.addValidationData(/*dataValidation*/validation);
                String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
                fileName=filePath+"MasterRequirementTemplate.xls";
                File file=new File(fileName);
                FileOutputStream fileOut = new FileOutputStream(file);
                hwb.write(fileOut);
                fileOut.close();
                }
			
			// changes made by Bhuvana
			if(customization.length!=0)
			{
				//System.out.println("hello");
				CellRangeAddressList customizationList= new CellRangeAddressList(1, -1, 9, 9);
				//System.out.println("****Address List ****"+customizationList);
				DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(customization);
				DataValidation dataValidation = new HSSFDataValidation(customizationList,dvConstraint);
				dataValidation.setSuppressDropDownArrow(false);
				sheet1.addValidationData(dataValidation);
				String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
				fileName=filePath+"MasterRequirementTemplate.xls";
				File file=new File(fileName);
				FileOutputStream fileOut = new FileOutputStream(file);
				hwb.write(fileOut);
				fileOut.close();
				
			}
			// changes completed
			return fileName;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	//get all groups array for dynamically populating the drop down list in the master req template
	public String[] getAllGroups()throws Exception
	{
		EntityManager em=null;
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	
		List<GroupInfoTO> toGroupList = new ArrayList<GroupInfoTO>() ;
		String groupNameArray[];
		try 
		{
			em=emf.createEntityManager();
			Query query= em.createQuery("select gp.groupName from GroupInfo gp");

			List<String> rs1 = query.getResultList();
			String st=rs1.toString();
			
			groupNameArray=st.substring(1,st.length()-1).split(",");
			System.out.println("group list is: " + groupNameArray);
			
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
	 

	/*
	
	public static void  linkedDropDownLists(String workbookName) { 
        File file = null; 
        FileOutputStream fos = null; 
        Workbook workbook = null; 
        Sheet sheet = null; 
        DataValidationHelper dvHelper = null; 
        DataValidationConstraint dvConstraint = null; 
        DataValidation validation = null; 
        CellRangeAddressList addressList = null; 
        try { 

            // Using the ss.usermodel allows this class to support both binary 
            // and xml based workbooks. The choice of which one to create is 
            // made by checking the file extension. 
             
                workbook = new HSSFWorkbook(); 
            
            
            // Build the sheet that will hold the data for the validations. This 
            // must be done first as it will create names that are referenced 
            // later. 
            sheet = workbook.createSheet("Linked Validations"); 
            ReportsService.buildDataSheet(sheet); 

            // Build the first data validation to occupy cell A1. Note 
            // that it retrieves it's data from the named area or region called 
            // CHOICES. Further information about this can be found in the 
            // static buildDataSheet() method below. 
            addressList = new CellRangeAddressList(0, 0, 0, 0); 
            dvHelper = sheet.getDataValidationHelper(); 
            dvConstraint = dvHelper.createFormulaListConstraint("CHOICES"); 
            validation = dvHelper.createValidation(dvConstraint, addressList); 
            sheet.addValidationData(validation); 
            
            // Now, build the linked or dependent drop down list that will 
            // occupy cell B1. The key to the whole process is the use of the 
            // INDIRECT() function. In the buildDataSheet(0 method, a series of 
            // named regions are created and the names of three of them mirror 
            // the options available to the user in the first drop down list 
            // (in cell A1). Using the INDIRECT() function makes it possible 
            // to convert the selection the user makes in that first drop down 
            // into the addresses of a named region of cells and then to use 
            // those cells to populate the second drop down list.
            addressList = new CellRangeAddressList(0, 0, 1, 1); 
            //dvHelper = sheet.getDataValidationHelper(); 
            dvConstraint = dvHelper.createFormulaListConstraint("INDIRECT(UPPER($A$1))"); 
            validation = dvHelper.createValidation(dvConstraint, addressList); 
            sheet.addValidationData(validation); 
            
            file = new File(workbookName); 
            fos = new FileOutputStream(file); 
            workbook.write(fos); 
        } catch (IOException ioEx) { 
            System.out.println("Caught a: " + ioEx.getClass().getName()); 
            System.out.println("Message: " + ioEx.getMessage()); 
            System.out.println("Stacktrace follws:....."); 
            ioEx.printStackTrace(System.out); 
        } finally { 
            try { 
                if (fos != null) { 
                    fos.close(); 
                    fos = null; 
                } 
            } catch (IOException ioEx) { 
                System.out.println("Caught a: " + ioEx.getClass().getName()); 
                System.out.println("Message: " + ioEx.getMessage()); 
                System.out.println("Stacktrace follws:....."); 
                ioEx.printStackTrace(System.out); 
            } 
        } 
    } 

    *//** 
     * Called to populate the named areas/regions. The contents of the cells on 
     * row one will be used to populate the first drop down list. The contents of 
     * the cells on rows two, three and four will be used to populate the second 
     * drop down list, just which row will be determined by the choice the user 
     * makes in the first drop down list. 
     * 
     * In all cases, the approach is to create a row, create and populate cells 
     * with data and then specify a name that identifies those cells. With the 
     * exception of the first range, the names that are chosen for each range 
     * of cells are quite important. In short, each of the options the user 
     * could select in the first drop down list is used as the name for another 
     * range of cells. Thus, in this example, the user can select either 
     * 'Animal', 'Vegetable' or 'Mineral' in the first drop down and so the 
     * sheet contains ranges named 'ANIMAL', 'VEGETABLE' and 'MINERAL'. 
     * 
     * @param dataSheet An instance of a class that implements the Sheet Sheet 
     *        interface (HSSFSheet or XSSFSheet). 
     *//* 
    private static final void buildDataSheet(Sheet dataSheet) { 
        Row row = null; 
        Cell cell = null; 
        Name name = null; 

        // The first row will hold the data for the first validation. 
        row = dataSheet.createRow(10); 
        cell = row.createCell(0); 
        cell.setCellValue("Animal"); 
        cell = row.createCell(1); 
        cell.setCellValue("Vegetable"); 
        cell = row.createCell(2); 
        cell.setCellValue("Mineral"); 
        name = dataSheet.getWorkbook().createName(); 
        name.setRefersToFormula("$A$11:$C$11"); 
        name.setNameName("CHOICES"); 

        // The next three rows will hold the data that will be used to 
        // populate the second, or linked, drop down list. 
        row = dataSheet.createRow(11); 
        cell = row.createCell(0); 
        cell.setCellValue("Lion"); 
        cell = row.createCell(1); 
        cell.setCellValue("Tiger"); 
        cell = row.createCell(2); 
        cell.setCellValue("Leopard"); 
        cell = row.createCell(3); 
        cell.setCellValue("Elephant"); 
        cell = row.createCell(4); 
        cell.setCellValue("Eagle"); 
        cell = row.createCell(5); 
        cell.setCellValue("Horse"); 
        cell = row.createCell(6); 
        cell.setCellValue("Zebra"); 
        name = dataSheet.getWorkbook().createName(); 
        name.setRefersToFormula("$A$12:$G$12"); 
        name.setNameName("ANIMAL"); 

        row = dataSheet.createRow(12); 
        cell = row.createCell(0); 
        cell.setCellValue("Cabbage"); 
        cell = row.createCell(1); 
        cell.setCellValue("Cauliflower"); 
        cell = row.createCell(2); 
        cell.setCellValue("Potato"); 
        cell = row.createCell(3); 
        cell.setCellValue("Onion"); 
        cell = row.createCell(4); 
        cell.setCellValue("Beetroot"); 
        cell = row.createCell(5); 
        cell.setCellValue("Asparagus"); 
        cell = row.createCell(6); 
        cell.setCellValue("Spinach"); 
        cell = row.createCell(7); 
        cell.setCellValue("Chard"); 
        name = dataSheet.getWorkbook().createName(); 
        name.setRefersToFormula("$A$13:$H$13"); 
        name.setNameName("VEGETABLE"); 

        row = dataSheet.createRow(13); 
        cell = row.createCell(0); 
        cell.setCellValue("Bauxite"); 
        cell = row.createCell(1); 
        cell.setCellValue("Quartz"); 
        cell = row.createCell(2); 
        cell.setCellValue("Feldspar"); 
        cell = row.createCell(3); 
        cell.setCellValue("Shist"); 
        cell = row.createCell(4); 
        cell.setCellValue("Shale"); 
        cell = row.createCell(5); 
        cell.setCellValue("Mica"); 
        name = dataSheet.getWorkbook().createName(); 
        name.setRefersToFormula("$A$14:$F$14"); 
        name.setNameName("MINERAL"); 
    } */
	
	
	// download master requirement template
		@SuppressWarnings("deprecation")
		public String downloadPRTemplate()throws Exception
		{
			HSSFWorkbook hwb=new HSSFWorkbook();
			HSSFCellStyle cellStyle = setHeaderStyle(hwb);
			HSSFSheet sheet1 =  hwb.createSheet("Product Requirement Template");
			HSSFRow rowhead=   sheet1.createRow((short)0);
			
			HSSFCell cell0 = rowhead.createCell((short)0);
			cell0.setCellStyle(cellStyle);
			cell0.setCellValue(new HSSFRichTextString("SR No"));			
			
			HSSFCell firstHeaderCell = rowhead.createCell((short)1);
			firstHeaderCell.setCellStyle(cellStyle);
			firstHeaderCell.setCellValue(new HSSFRichTextString("MR ID"));
			
			HSSFCell secondHeaderCell = rowhead.createCell((short)2);
			secondHeaderCell.setCellStyle(cellStyle);
			secondHeaderCell.setCellValue(new HSSFRichTextString("Product Req Title"));
			
			HSSFCell thirdHeaderCell = rowhead.createCell((short)3);
			thirdHeaderCell.setCellStyle(cellStyle);
			thirdHeaderCell.setCellValue(new HSSFRichTextString("Product Req Description"));
			
			HSSFCell fourthHeaderCell = rowhead.createCell((short)4);
			fourthHeaderCell.setCellStyle(cellStyle);
			fourthHeaderCell.setCellValue(new HSSFRichTextString("Product Version"));		
			
			/*HSSFCell cell5 = rowhead.createCell((short)4);
			cell5.setCellStyle(cellStyle);
			cell5.setCellValue(new HSSFRichTextString("Group Name"));*/
			
			HSSFCell cell6 = rowhead.createCell((short)5);
			cell6.setCellStyle(cellStyle);
			cell6.setCellValue(new HSSFRichTextString("Localization"));			
				
			HSSFCell cell7 = rowhead.createCell((short)6);
			cell7.setCellStyle(cellStyle);
			cell7.setCellValue(new HSSFRichTextString("Functional Effort"));			
					
			HSSFCell cell8 = rowhead.createCell((short)7);
			cell8.setCellStyle(cellStyle);
			cell8.setCellValue(new HSSFRichTextString("Development Effort"));
	
			HSSFCell cell9 = rowhead.createCell((short)8);
			cell9.setCellStyle(cellStyle);
			cell9.setCellValue(new HSSFRichTextString("DG Owner"));
			
			HSSFCell cell10 = rowhead.createCell((short)9);
			cell10.setCellStyle(cellStyle);
			cell10.setCellValue(new HSSFRichTextString("Comments"));
			
			HSSFCell cell11 = rowhead.createCell((short)10);
			cell11.setCellStyle(cellStyle);
			cell11.setCellValue(new HSSFRichTextString("FRS Owner"));			
		
			HSSFCell cell12 = rowhead.createCell((short)11);
			cell12.setCellStyle(cellStyle);
			cell12.setCellValue(new HSSFRichTextString("FRS Planned Date"));
			
			HSSFCell cell13 = rowhead.createCell((short)12);
			cell13.setCellStyle(cellStyle);
			cell13.setCellValue(new HSSFRichTextString("SRS Owner"));
			
			HSSFCell cell14 = rowhead.createCell((short)13);
			cell14.setCellStyle(cellStyle);
			cell14.setCellValue(new HSSFRichTextString("SRS Planned Date"));			

			HSSFCell cell15 = rowhead.createCell((short)14);
			cell15.setCellStyle(cellStyle);
			cell15.setCellValue(new HSSFRichTextString("Archie Impact"));
			
			HSSFCell cell16 = rowhead.createCell((short)15);
			cell16.setCellStyle(cellStyle);
			cell16.setCellValue(new HSSFRichTextString("Core Impact"));			
		
			HSSFCell cell17 = rowhead.createCell((short)16);
			cell17.setCellStyle(cellStyle);
			cell17.setCellValue(new HSSFRichTextString("CRM Impact"));
			
			HSSFCell cell18 = rowhead.createCell((short)17);
			cell18.setCellStyle(cellStyle);
			cell18.setCellValue(new HSSFRichTextString("FAS Impact"));
			
			HSSFCell cell19 = rowhead.createCell((short)18);
			cell19.setCellStyle(cellStyle);
			cell19.setCellValue(new HSSFRichTextString("ODS Impact"));
			
			HSSFCell cell20 = rowhead.createCell((short)19);
			cell20.setCellStyle(cellStyle);
			cell20.setCellValue(new HSSFRichTextString("FI Impact"));
			
			HSSFCell cell21 = rowhead.createCell((short)20);
			cell21.setCellStyle(cellStyle);
			cell21.setCellValue(new HSSFRichTextString("E-Banking Impact"));			
		
			HSSFCell cell22 = rowhead.createCell((short)21);
			cell22.setCellStyle(cellStyle);
			cell22.setCellValue(new HSSFRichTextString("DirectBanking Impact"));
			
			HSSFCell cell23 = rowhead.createCell((short)22);
			cell23.setCellStyle(cellStyle);
			cell23.setCellValue(new HSSFRichTextString("Origination Impact"));
			
			HSSFCell cell24 = rowhead.createCell((short)23);
			cell24.setCellStyle(cellStyle);
			cell24.setCellValue(new HSSFRichTextString("FDM Impact"));
			
			HSSFCell cell25 = rowhead.createCell((short)24);
			cell25.setCellStyle(cellStyle);
			cell25.setCellValue(new HSSFRichTextString("Treasury Impact"));
			
			HSSFCell cell26 = rowhead.createCell((short)25);
			cell26.setCellStyle(cellStyle);
			cell26.setCellValue(new HSSFRichTextString("WMS Impact"));
			
			HSSFCell cell27 = rowhead.createCell((short)26);
			cell27.setCellStyle(cellStyle);
			cell27.setCellValue(new HSSFRichTextString("FinanzTool Impact"));
			
			HSSFCell cell28 = rowhead.createCell((short)27);
			cell28.setCellStyle(cellStyle);
			cell28.setCellValue(new HSSFRichTextString("Multichannel Impact"));
			
			HSSFCell cell29 = rowhead.createCell((short)28);
			cell29.setCellStyle(cellStyle);
			cell29.setCellValue(new HSSFRichTextString("SSO Impact"));
			
			HSSFCell cell30 = rowhead.createCell((short)29);
			cell30.setCellStyle(cellStyle);
			cell30.setCellValue(new HSSFRichTextString("All24By7 Impact"));
			
			HSSFCell cell31 = rowhead.createCell((short)30);
			cell31.setCellStyle(cellStyle);
			cell31.setCellValue(new HSSFRichTextString("SVS Impact"));
			
			HSSFCell cell32 = rowhead.createCell((short)31);
			cell32.setCellStyle(cellStyle);
			cell32.setCellValue(new HSSFRichTextString("FAB Impact"));			
						
			HSSFCell cell33 = rowhead.createCell((short)32);
			cell33.setCellStyle(cellStyle);
			cell33.setCellValue(new HSSFRichTextString("CSIS Impact"));
			
			HSSFCell cell34 = rowhead.createCell((short)33);
			cell34.setCellStyle(cellStyle);
			cell34.setCellValue(new HSSFRichTextString("LOS Impact"));

			HSSFCell cell35 = rowhead.createCell((short)34);
			cell35.setCellStyle(cellStyle);
			cell35.setCellValue(new HSSFRichTextString("FCA Impact"));
			
			HSSFCell cell36 = rowhead.createCell((short)35);
			cell36.setCellStyle(cellStyle);
			cell36.setCellValue(new HSSFRichTextString("ThirdParty Impact"));
			
			/*try
			{
				
		            String fileName = null;
				
	                DVConstraint constraint = DVConstraint.createFormulaListConstraint("hidden");   
	                CellRangeAddressList addressList = new CellRangeAddressList(1, -1, 3, 3); 
	                HSSFDataValidation validation = new HSSFDataValidation(addressList, constraint);  
	                hwb.setSheetHidden(1, true);  
	                
	                sheet1.addValidationData(dataValidationvalidation);
	                String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
	                fileName=filePath+"ProductRequirementTemplate.xls";
	                File file=new File(fileName);
	                FileOutputStream fileOut = new FileOutputStream(file);
	                hwb.write(fileOut);
	                fileOut.close();
	             
				return fileName;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}*/
			
			try
			{
				String versionArray[]=getAllVersions();
				// Changes made by Bhuvana
				//String[] customization= {"Yes","No"};
				//System.out.println("****"+ Arrays.toString(customization));
				String fileName = null;
				// Changes completed
				if(versionArray.length!=0)
				{
					
	                HSSFSheet hidden = hwb.createSheet("hidden");
//	              System.out.println("length of grouplist is: "+  groupNameArray.length);
	                for (int i = 0, length= versionArray.length; i < length; i++)
	                {    
	                       String name = versionArray[i];
//	                       System.out.println("name of group is: "+  name);
	                       HSSFRow row = hidden.createRow(i);
	                       HSSFCell cell = row.createCell(0);    
	                       cell.setCellValue(name);  
	                } 
	                Name namedCell = hwb.createName();  
	                namedCell.setNameName("hidden");  
	                namedCell.setRefersToFormula("hidden!$A$1:$A$" + versionArray.length);  
	                DVConstraint constraint = DVConstraint.createFormulaListConstraint("hidden");  
	                CellRangeAddressList addressList = new CellRangeAddressList(1, -1, 4, 4);  
	                HSSFDataValidation validation = new HSSFDataValidation(addressList, constraint);  
	                hwb.setSheetHidden(1, true);  
	                
	                sheet1.addValidationData(/*dataValidation*/validation);
	                String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
	                System.out.println("file path: "+filePath);
	                fileName=filePath+"ProductRequirementTemplate.xls";
	                File file=new File(fileName);
	                FileOutputStream fileOut = new FileOutputStream(file);
	                hwb.write(fileOut);
	                fileOut.close();
	                }
		
				String localizationArray[]=getAllLocalization();
				// changes made by Bhuvana
				if(localizationArray.length!=0)
				{
					//System.out.println("hello");
					CellRangeAddressList customizationList= new CellRangeAddressList(1, -1, 5, 5);
					//System.out.println("****Address List ****"+customizationList);
					DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(localizationArray);
					DataValidation dataValidation = new HSSFDataValidation(customizationList,dvConstraint);
					dataValidation.setSuppressDropDownArrow(false);
					sheet1.addValidationData(dataValidation);
					String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
					fileName=filePath+"ProductRequirementTemplate.xls";
					File file=new File(fileName);
					FileOutputStream fileOut = new FileOutputStream(file);
					hwb.write(fileOut);
					fileOut.close();
					
				}
				// changes completed
				
				
				return fileName;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
			
		}
		
		//get all versions array for dynamically populating the drop down list in the product requirement template
		public String[] getAllVersions()throws Exception
		{
			EntityManager em=null;
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
		
			List<ProductRequirementTO> toversionList = new ArrayList<ProductRequirementTO>() ;
			String versionArray[];
			try 
			{
				em=emf.createEntityManager();
				Query query= em.createQuery("select pv.versionName from ProductVersion pv");

				List<String> rs1 = query.getResultList();
				String st=rs1.toString();
				
				versionArray=st.substring(1,st.length()-1).split(",");
				System.out.println("version list is: " + versionArray);
				
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
			return versionArray;
		
		}
		
		//get all localization array for dynamically populating the drop down list in the product requirement template
				public String[] getAllLocalization()throws Exception
				{
					EntityManager em=null;
					EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
				
					List<ProductRequirementTO> tolocalizationList = new ArrayList<ProductRequirementTO>() ;
					String localizationArray[];
					try 
					{
						em=emf.createEntityManager();
						Query query= em.createQuery("select lo.localizationName from Localization lo");

						List<String> rs1 = query.getResultList();
						String st=rs1.toString();
						
						localizationArray=st.substring(1,st.length()-1).split(",");
						System.out.println("version list is: " + localizationArray);
						
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
					return localizationArray;
				
				}
		
		
		//download product requirement report as RCD Tracker

				@SuppressWarnings("deprecation")
				public String downloadProductReqListAsRCDTracker(List<ProductRequirementTO> productReqList)throws NoProductReqAvailableException,Exception
				{
					int index =0;
					try{
						if(!productReqList.isEmpty())
						{	
							//headers
							HSSFWorkbook hwb=new HSSFWorkbook();
							HSSFCellStyle cellStyle = setHeaderStyle(hwb);
							HSSFSheet sheet1 =  hwb.createSheet("sheet 1");
							HSSFRow rowhead=   sheet1.createRow((short)0);
							
							HSSFCell cell1 = rowhead.createCell((short)0);
							cell1.setCellStyle(cellStyle);
							cell1.setCellValue(new HSSFRichTextString("Version Number"));

							HSSFCell cell2 = rowhead.createCell((short)1);
							cell2.setCellStyle(cellStyle);
							cell2.setCellValue(new HSSFRichTextString("Master Req Id"));
							
							HSSFCell cell3 = rowhead.createCell((short)2);
							cell3.setCellStyle(cellStyle);
							cell3.setCellValue(new HSSFRichTextString("MR Description"));

							HSSFCell cell4 = rowhead.createCell((short)3);
							cell4.setCellStyle(cellStyle);
							cell4.setCellValue(new HSSFRichTextString("Enhancement Type"));							

							HSSFCell cell5 = rowhead.createCell((short)4);
							cell5.setCellStyle(cellStyle);
							cell5.setCellValue(new HSSFRichTextString("Solution Name"));
							
							HSSFCell cell6 = rowhead.createCell((short)5);
							cell6.setCellStyle(cellStyle);
							cell6.setCellValue(new HSSFRichTextString("Vertical Name"));
							
							HSSFCell cell7 = rowhead.createCell((short)6);
							cell7.setCellStyle(cellStyle);
							cell7.setCellValue(new HSSFRichTextString("Module Name"));
							
							HSSFCell cell8 = rowhead.createCell((short)7);
							cell8.setCellStyle(cellStyle);
							cell8.setCellValue(new HSSFRichTextString("Module Anchor"));

							HSSFCell cell9 = rowhead.createCell((short)8);
							cell9.setCellStyle(cellStyle);
							cell9.setCellValue(new HSSFRichTextString("Functional PLM"));
													
							HSSFCell cell10 = rowhead.createCell((short)9);
							cell10.setCellStyle(cellStyle);
							cell10.setCellValue(new HSSFRichTextString("DG Owner"));

							HSSFCell cell11 = rowhead.createCell((short)10);
							cell11.setCellStyle(cellStyle);
							cell11.setCellValue(new HSSFRichTextString("Development Effort"));
							
							HSSFCell cell12 = rowhead.createCell((short)11);
							cell12.setCellStyle(cellStyle);
							cell12.setCellValue(new HSSFRichTextString("Region"));

							HSSFCell cell13 = rowhead.createCell((short)12);
							cell13.setCellStyle(cellStyle);
							cell13.setCellValue(new HSSFRichTextString("Customer"));

							HSSFCell cell14 = rowhead.createCell((short)13);
							cell14.setCellStyle(cellStyle);
							cell14.setCellValue(new HSSFRichTextString("Source"));

							HSSFCell cell15 = rowhead.createCell((short)14);
							cell15.setCellStyle(cellStyle);
							cell15.setCellValue(new HSSFRichTextString("Dropped From Scope"));
							
							HSSFCell cell16 = rowhead.createCell((short)15);
							cell16.setCellStyle(cellStyle);
							cell16.setCellValue(new HSSFRichTextString("Project Code"));
							
							HSSFCell cell17 = rowhead.createCell((short)16);
							cell17.setCellStyle(cellStyle);
							cell17.setCellValue(new HSSFRichTextString("Checked In TFS"));
							
							HSSFCell cell18 = rowhead.createCell((short)17);
							cell18.setCellStyle(cellStyle);
							cell18.setCellValue(new HSSFRichTextString("SRS Name"));

							HSSFCell cell19 = rowhead.createCell((short)18);
							cell19.setCellStyle(cellStyle);
							cell19.setCellValue(new HSSFRichTextString("Comments"));
							
							HSSFCell cell20 = rowhead.createCell((short)19);
							cell20.setCellStyle(cellStyle);
							cell20.setCellValue(new HSSFRichTextString("ImpactID"));
							
							HSSFCell cell21= rowhead.createCell((short)20);
							cell21.setCellStyle(cellStyle);
							cell21.setCellValue(new HSSFRichTextString("Archie Impact"));
							
							HSSFCell cell22 = rowhead.createCell((short)21);
							cell22.setCellStyle(cellStyle);
							cell22.setCellValue(new HSSFRichTextString("Core Impact"));
							
							HSSFCell cell23 = rowhead.createCell((short)22);
							cell23.setCellStyle(cellStyle);
							cell23.setCellValue(new HSSFRichTextString("CRM Impact"));
							
							HSSFCell cell24 = rowhead.createCell((short)23);
							cell24.setCellStyle(cellStyle);
							cell24.setCellValue(new HSSFRichTextString("FAS Impact"));
							
							HSSFCell cell25 = rowhead.createCell((short)24);
							cell25.setCellStyle(cellStyle);
							cell25.setCellValue(new HSSFRichTextString("OSD Impact"));
							
							HSSFCell cell26 = rowhead.createCell((short)25);
							cell26.setCellStyle(cellStyle);
							cell26.setCellValue(new HSSFRichTextString("FI Impact"));
							
							HSSFCell cell27 = rowhead.createCell((short)26);
							cell27.setCellStyle(cellStyle);
							cell27.setCellValue(new HSSFRichTextString("E-Banking Impact"));
							
							HSSFCell cell28 = rowhead.createCell((short)27);
							cell28.setCellStyle(cellStyle);
							cell28.setCellValue(new HSSFRichTextString("Direct Banking Impact"));
							
							HSSFCell cell29 = rowhead.createCell((short)28);
							cell29.setCellStyle(cellStyle);
							cell29.setCellValue(new HSSFRichTextString("Origination Impact"));
							
							HSSFCell cell30 = rowhead.createCell((short)29);
							cell30.setCellStyle(cellStyle);
							cell30.setCellValue(new HSSFRichTextString("FDMI Impact"));
							
							HSSFCell cell31 = rowhead.createCell((short)30);
							cell31.setCellStyle(cellStyle);
							cell31.setCellValue(new HSSFRichTextString("Treasury Impact"));
							
							HSSFCell cell32 = rowhead.createCell((short)31);
							cell32.setCellStyle(cellStyle);
							cell32.setCellValue(new HSSFRichTextString("WMS Impact"));
							
							HSSFCell cell33 = rowhead.createCell((short)32);
							cell33.setCellStyle(cellStyle);
							cell33.setCellValue(new HSSFRichTextString("Finanz Tool Impact"));
							
							HSSFCell cell34 = rowhead.createCell((short)33);
							cell34.setCellStyle(cellStyle);
							cell34.setCellValue(new HSSFRichTextString("MultiChannel Impact"));
							
							HSSFCell cell35 = rowhead.createCell((short)34);
							cell35.setCellStyle(cellStyle);
							cell35.setCellValue(new HSSFRichTextString("SSO Impact"));
							
							HSSFCell cell36 = rowhead.createCell((short)35);
							cell36.setCellStyle(cellStyle);
							cell36.setCellValue(new HSSFRichTextString("24X7 Impact"));
							
							HSSFCell cell37 = rowhead.createCell((short)36);
							cell37.setCellStyle(cellStyle);
							cell37.setCellValue(new HSSFRichTextString("SVS Impact"));
							
							HSSFCell cell38 = rowhead.createCell((short)37);
							cell38.setCellStyle(cellStyle);
							cell38.setCellValue(new HSSFRichTextString("FAB Impact"));
							
							HSSFCell cell39 = rowhead.createCell((short)38);
							cell39.setCellStyle(cellStyle);
							cell39.setCellValue(new HSSFRichTextString("CSIS Impact"));
							
							HSSFCell cell40 = rowhead.createCell((short)39);
							cell40.setCellStyle(cellStyle);
							cell40.setCellValue(new HSSFRichTextString("LOS Impact"));
							
							HSSFCell cell41 = rowhead.createCell((short)40);
							cell41.setCellStyle(cellStyle);
							cell41.setCellValue(new HSSFRichTextString("FCA Impact"));
							
							HSSFCell cell42 = rowhead.createCell((short)41);
							cell42.setCellStyle(cellStyle);
							cell42.setCellValue(new HSSFRichTextString("Third Party Impact"));
							
							for(int i=0;i<57;i++)
							{
								sheet1.setColumnWidth(i, 5000);
							}
							for (ProductRequirementTO productReqTo : productReqList)
							{

								HSSFRow row=   sheet1.createRow((short)++index);

								row.createCell((short) 0).setCellValue(productReqTo.getProductVersion());
								row.createCell((short) 1).setCellValue(productReqTo.getMasterRequirementId());
								
								row.createCell((short) 2).setCellValue(productReqTo.getMasterRequirementDescription());	
								row.createCell((short) 3).setCellValue(productReqTo.getEnhancementType());
															
								row.createCell((short) 4).setCellValue(productReqTo.getSolutionName());
								row.createCell((short) 5).setCellValue(productReqTo.getVerticalName());
								row.createCell((short) 6).setCellValue(productReqTo.getModuleName());
								row.createCell((short) 7).setCellValue(productReqTo.getModuleAnchor());
								row.createCell((short) 8).setCellValue(productReqTo.getFunctionalPLM());
								row.createCell((short) 9).setCellValue(productReqTo.getDgOwner());
								row.createCell((short) 10).setCellValue(productReqTo.getDevelopmentEffort());
								row.createCell((short) 11).setCellValue(productReqTo.getLocationName());
								row.createCell((short) 12).setCellValue(productReqTo.getCustomer());
								row.createCell((short) 13).setCellValue(productReqTo.getSource());
								row.createCell((short) 14).setCellValue(productReqTo.getDroppedFromScope());
								row.createCell((short) 15).setCellValue(productReqTo.getProjectCode());
								row.createCell((short) 16).setCellValue(productReqTo.getSrsCheckedInTFS());
								row.createCell((short) 17).setCellValue(productReqTo.getSrsName());
								row.createCell((short) 18).setCellValue(productReqTo.getComments());		    				    
												
								row.createCell((short) 19).setCellValue(productReqTo.getImpactId());
								row.createCell((short) 20).setCellValue(productReqTo.getArchieImpact());
								row.createCell((short) 21).setCellValue(productReqTo.getCoreImpact());
								row.createCell((short) 22).setCellValue(productReqTo.getCRMImpact());
								row.createCell((short) 23).setCellValue(productReqTo.getFASImpact());
								row.createCell((short) 24).setCellValue(productReqTo.getOdsImpact());
								row.createCell((short) 25).setCellValue(productReqTo.getFiImpact());
								row.createCell((short) 26).setCellValue(productReqTo.getEBankingImpact());
								row.createCell((short) 27).setCellValue(productReqTo.getDirectBankingImpact());
								row.createCell((short) 28).setCellValue(productReqTo.getOriginationImpact());
								row.createCell((short) 29).setCellValue(productReqTo.getFDMImpact());
								row.createCell((short) 30).setCellValue(productReqTo.getTreasuryImpact());
								row.createCell((short) 31).setCellValue(productReqTo.getWMSImpact());
								row.createCell((short) 32).setCellValue(productReqTo.getFinanzToolImpact());
								row.createCell((short) 33).setCellValue(productReqTo.getMultichannelImpact());
								row.createCell((short) 34).setCellValue(productReqTo.getSSOImpact());
								row.createCell((short) 35).setCellValue(productReqTo.getAll24By7Impact());
								row.createCell((short) 36).setCellValue(productReqTo.getSvsImpact());
								row.createCell((short) 37).setCellValue(productReqTo.getFabImpact());
								row.createCell((short) 38).setCellValue(productReqTo.getCsisImpact());
								row.createCell((short) 39).setCellValue(productReqTo.getLOSImpact());
								row.createCell((short) 40).setCellValue(productReqTo.getFCAImpact());
								row.createCell((short) 41).setCellValue(productReqTo.getThirdPartyImpact());
							
								
							}

							String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
							String fileName=filePath+"ProductRequirementsReportAsRCDTracker.xls";
							FileOutputStream fileOut =  new FileOutputStream(fileName);	


							hwb.write(fileOut);
							fileOut.close();
							return fileName;

						}
						else
						{
							throw new NoProductReqAvailableException();
						}
					}
				catch (NoProductReqAvailableException e) 
					{   
						throw(e);
					 
					}   
				catch (Exception e) 
					{   
						throw(e);
					 
					}   
				}
				
				
				//download product requirement report as RS Tracker
				@SuppressWarnings("deprecation")
				public String downloadProductReqListAsRSTracker(List<ProductRequirementTO> productReqList)throws NoProductReqAvailableException,Exception
				{
					int index =0;
					try{
						if(!productReqList.isEmpty())
						{	
							//headers
							HSSFWorkbook hwb=new HSSFWorkbook();
							HSSFCellStyle cellStyle = setHeaderStyle(hwb);
							HSSFSheet sheet1 =  hwb.createSheet("sheet 1");
							HSSFRow rowhead=   sheet1.createRow((short)0);
							
							HSSFCell cell1 = rowhead.createCell((short)0);
							cell1.setCellStyle(cellStyle);
							cell1.setCellValue(new HSSFRichTextString("Version Number"));

							HSSFCell cell2 = rowhead.createCell((short)1);
							cell2.setCellStyle(cellStyle);
							cell2.setCellValue(new HSSFRichTextString("Solution Name"));

							HSSFCell cell3 = rowhead.createCell((short)2);
							cell3.setCellStyle(cellStyle);
							cell3.setCellValue(new HSSFRichTextString("MR ID"));

							HSSFCell cell4 = rowhead.createCell((short)3);
							cell4.setCellStyle(cellStyle);
							cell4.setCellValue(new HSSFRichTextString("Vertical Name"));

							HSSFCell cell5 = rowhead.createCell((short)4);
							cell5.setCellStyle(cellStyle);
							cell5.setCellValue(new HSSFRichTextString("Functional PLM"));

							HSSFCell cell6 = rowhead.createCell((short)5);
							cell6.setCellStyle(cellStyle);
							cell6.setCellValue(new HSSFRichTextString("Functional Effort"));

							HSSFCell cell7 = rowhead.createCell((short)6);
							cell7.setCellStyle(cellStyle);
							cell7.setCellValue(new HSSFRichTextString("Functional Project Code"));

							HSSFCell cell8 = rowhead.createCell((short)7);
							cell8.setCellStyle(cellStyle);
							cell8.setCellValue(new HSSFRichTextString("FRS Document Name"));

							HSSFCell cell9 = rowhead.createCell((short)8);
							cell9.setCellStyle(cellStyle);
							cell9.setCellValue(new HSSFRichTextString("FRS Owner"));
													
							HSSFCell cell10 = rowhead.createCell((short)9);
							cell10.setCellStyle(cellStyle);
							cell10.setCellValue(new HSSFRichTextString("FRS Status"));

							HSSFCell cell11 = rowhead.createCell((short)10);
							cell11.setCellStyle(cellStyle);
							cell11.setCellValue(new HSSFRichTextString("FRS Planned Date"));
							
							HSSFCell cell12 = rowhead.createCell((short)11);
							cell12.setCellStyle(cellStyle);
							cell12.setCellValue(new HSSFRichTextString("FRS Actual Date"));

							HSSFCell cell13 = rowhead.createCell((short)12);
							cell13.setCellStyle(cellStyle);
							cell13.setCellValue(new HSSFRichTextString("FRS Checked in TFS"));

							HSSFCell cell14 = rowhead.createCell((short)13);
							cell14.setCellStyle(cellStyle);
							cell14.setCellValue(new HSSFRichTextString("SRS Document Name"));

							HSSFCell cell15 = rowhead.createCell((short)14);
							cell15.setCellStyle(cellStyle);
							cell15.setCellValue(new HSSFRichTextString("SRS Owner"));

							HSSFCell cell16 = rowhead.createCell((short)15);
							cell16.setCellStyle(cellStyle);
							cell16.setCellValue(new HSSFRichTextString("SRS Group Review Date"));
							
							HSSFCell cell17 = rowhead.createCell((short)16);
							cell17.setCellStyle(cellStyle);
							cell17.setCellValue(new HSSFRichTextString("SRS Planned Date"));

							HSSFCell cell18 = rowhead.createCell((short)17);
							cell18.setCellStyle(cellStyle);
							cell18.setCellValue(new HSSFRichTextString("SRS Actual Date"));
							
							HSSFCell cell19 = rowhead.createCell((short)18);
							cell19.setCellStyle(cellStyle);
							cell19.setCellValue(new HSSFRichTextString("DG Owner"));

							HSSFCell cell20 = rowhead.createCell((short)19);
							cell20.setCellStyle(cellStyle);
							cell20.setCellValue(new HSSFRichTextString("SRS Status"));
							
							HSSFCell cell21 = rowhead.createCell((short)20);
							cell21.setCellStyle(cellStyle);
							cell21.setCellValue(new HSSFRichTextString("SRS Checked in TFS"));
												
							HSSFCell cell22 = rowhead.createCell((short)21);
							cell22.setCellStyle(cellStyle);
							cell22.setCellValue(new HSSFRichTextString("ImpactID"));
							
							HSSFCell cell23 = rowhead.createCell((short)22);
							cell23.setCellStyle(cellStyle);
							cell23.setCellValue(new HSSFRichTextString("Archie Impact"));
							
							HSSFCell cell24 = rowhead.createCell((short)23);
							cell24.setCellStyle(cellStyle);
							cell24.setCellValue(new HSSFRichTextString("Core Impact"));
							
							HSSFCell cell25 = rowhead.createCell((short)24);
							cell25.setCellStyle(cellStyle);
							cell25.setCellValue(new HSSFRichTextString("CRM Impact"));
							
							HSSFCell cell26 = rowhead.createCell((short)25);
							cell26.setCellStyle(cellStyle);
							cell26.setCellValue(new HSSFRichTextString("FAS Impact"));
							
							HSSFCell cell27 = rowhead.createCell((short)26);
							cell27.setCellStyle(cellStyle);
							cell27.setCellValue(new HSSFRichTextString("OSD Impact"));
							
							HSSFCell cell28 = rowhead.createCell((short)27);
							cell28.setCellStyle(cellStyle);
							cell28.setCellValue(new HSSFRichTextString("FI Impact"));
							
							HSSFCell cell29 = rowhead.createCell((short)28);
							cell29.setCellStyle(cellStyle);
							cell29.setCellValue(new HSSFRichTextString("E-Banking Impact"));
							
							HSSFCell cell30 = rowhead.createCell((short)29);
							cell30.setCellStyle(cellStyle);
							cell30.setCellValue(new HSSFRichTextString("Direct Banking Impact"));
							
							HSSFCell cell31 = rowhead.createCell((short)30);
							cell31.setCellStyle(cellStyle);
							cell31.setCellValue(new HSSFRichTextString("Origination Impact"));
							
							HSSFCell cell32 = rowhead.createCell((short)31);
							cell32.setCellStyle(cellStyle);
							cell32.setCellValue(new HSSFRichTextString("FDMI Impact"));
							
							HSSFCell cell33 = rowhead.createCell((short)32);
							cell33.setCellStyle(cellStyle);
							cell33.setCellValue(new HSSFRichTextString("Treasury Impact"));
							
							HSSFCell cell34 = rowhead.createCell((short)33);
							cell34.setCellStyle(cellStyle);
							cell34.setCellValue(new HSSFRichTextString("WMS Impact"));
							
							HSSFCell cell35 = rowhead.createCell((short)34);
							cell35.setCellStyle(cellStyle);
							cell35.setCellValue(new HSSFRichTextString("Finanz Tool Impact"));
							
							HSSFCell cell36 = rowhead.createCell((short)35);
							cell36.setCellStyle(cellStyle);
							cell36.setCellValue(new HSSFRichTextString("MultiChannel Impact"));
							
							HSSFCell cell37 = rowhead.createCell((short)36);
							cell37.setCellStyle(cellStyle);
							cell37.setCellValue(new HSSFRichTextString("SSO Impact"));
							
							HSSFCell cell38 = rowhead.createCell((short)37);
							cell38.setCellStyle(cellStyle);
							cell38.setCellValue(new HSSFRichTextString("24X7 Impact"));
							
							HSSFCell cell39 = rowhead.createCell((short)38);
							cell39.setCellStyle(cellStyle);
							cell39.setCellValue(new HSSFRichTextString("SVS Impact"));
							
							HSSFCell cell40 = rowhead.createCell((short)39);
							cell40.setCellStyle(cellStyle);
							cell40.setCellValue(new HSSFRichTextString("FAB Impact"));
							
							HSSFCell cell41 = rowhead.createCell((short)40);
							cell41.setCellStyle(cellStyle);
							cell41.setCellValue(new HSSFRichTextString("CSIS Impact"));
							
							HSSFCell cell42 = rowhead.createCell((short)41);
							cell42.setCellStyle(cellStyle);
							cell42.setCellValue(new HSSFRichTextString("LOS Impact"));
							
							HSSFCell cell43 = rowhead.createCell((short)42);
							cell43.setCellStyle(cellStyle);
							cell43.setCellValue(new HSSFRichTextString("FCA Impact"));
							
							HSSFCell cell44 = rowhead.createCell((short)43);
							cell44.setCellStyle(cellStyle);
							cell44.setCellValue(new HSSFRichTextString("Third Party Impact"));
							
							for(int i=0;i<57;i++)
							{
								sheet1.setColumnWidth(i, 5000);
							}
							for (ProductRequirementTO productReqTo : productReqList)
							{

								HSSFRow row=   sheet1.createRow((short)++index);

								row.createCell((short) 0).setCellValue(productReqTo.getProductVersion());
								row.createCell((short) 1).setCellValue(productReqTo.getSolutionName());
								row.createCell((short) 2).setCellValue(productReqTo.getMasterRequirementId());
								row.createCell((short) 3).setCellValue(productReqTo.getVerticalName());
								row.createCell((short) 4).setCellValue(productReqTo.getFunctionalPLM());
								row.createCell((short) 5).setCellValue(productReqTo.getFunctionalEffort());
								row.createCell((short) 6).setCellValue(productReqTo.getProjectCode());
								System.out.println("Functional Project Code: "+productReqTo.getProjectCode());
								row.createCell((short) 7).setCellValue(productReqTo.getFRSDocumentName());
								System.out.println("FRS Document Name: "+productReqTo.getFRSDocumentName());
								row.createCell((short) 8).setCellValue(productReqTo.getFrsName());
								row.createCell((short) 9).setCellValue(productReqTo.getFrsStatus());
								
								Date dt=new Date(0,0,0);
								row.createCell((short) 10).setCellValue((productReqTo.getPlannedDateForFRS()!=null)? new SimpleDateFormat("dd-MMM-yyyy").format(productReqTo.getPlannedDateForFRS()):new String());
								row.createCell((short) 11).setCellValue((productReqTo.getActualDateForFRS()!=null) ? new SimpleDateFormat("dd-MMM-yyyy").format(productReqTo.getActualDateForFRS()):new String());
							
								row.createCell((short) 12).setCellValue(productReqTo.getFrsCheckedInTFS());
							    row.createCell((short) 13).setCellValue(productReqTo.getSRSDocumentName());	
							    row.createCell((short) 14).setCellValue(productReqTo.getSrsName());
							    
							    row.createCell((short) 15).setCellValue((productReqTo.getGroupReviewDateForSRS()!=null)? new SimpleDateFormat("dd-MMM-yyyy").format(productReqTo.getGroupReviewDateForSRS()):new String());
							    
							    row.createCell((short) 16).setCellValue((productReqTo.getPlannedDateForSRS()!=null)? new SimpleDateFormat("dd-MMM-yyyy").format(productReqTo.getPlannedDateForSRS()):new String());
							    row.createCell((short) 17).setCellValue((productReqTo.getActualDateForSRS()!=null)? new SimpleDateFormat("dd-MMM-yyyy").format(productReqTo.getActualDateForSRS()):new String());
							  
							    row.createCell((short) 18).setCellValue(productReqTo.getDgOwner());
							    row.createCell((short) 19).setCellValue(productReqTo.getSrsStatus());
							    row.createCell((short) 20).setCellValue(productReqTo.getSrsCheckedInTFS());
							    											
							    row.createCell((short) 21).setCellValue(productReqTo.getImpactId());
								row.createCell((short) 22).setCellValue(productReqTo.getArchieImpact());
								row.createCell((short) 23).setCellValue(productReqTo.getCoreImpact());
								row.createCell((short) 24).setCellValue(productReqTo.getCRMImpact());
								row.createCell((short) 25).setCellValue(productReqTo.getFASImpact());
								row.createCell((short) 26).setCellValue(productReqTo.getOdsImpact());
								row.createCell((short) 27).setCellValue(productReqTo.getFiImpact());
								row.createCell((short) 28).setCellValue(productReqTo.getEBankingImpact());
								row.createCell((short) 29).setCellValue(productReqTo.getDirectBankingImpact());
								row.createCell((short) 30).setCellValue(productReqTo.getOriginationImpact());
								row.createCell((short) 31).setCellValue(productReqTo.getFDMImpact());
								row.createCell((short) 32).setCellValue(productReqTo.getTreasuryImpact());
								row.createCell((short) 33).setCellValue(productReqTo.getWMSImpact());
								row.createCell((short) 34).setCellValue(productReqTo.getFinanzToolImpact());
								row.createCell((short) 35).setCellValue(productReqTo.getMultichannelImpact());
								row.createCell((short) 36).setCellValue(productReqTo.getSSOImpact());
								row.createCell((short) 37).setCellValue(productReqTo.getAll24By7Impact());
								row.createCell((short) 38).setCellValue(productReqTo.getSvsImpact());
								row.createCell((short) 39).setCellValue(productReqTo.getFabImpact());
								row.createCell((short) 40).setCellValue(productReqTo.getCsisImpact());
								row.createCell((short) 41).setCellValue(productReqTo.getLOSImpact());
								row.createCell((short) 42).setCellValue(productReqTo.getFCAImpact());
								row.createCell((short) 43).setCellValue(productReqTo.getThirdPartyImpact());
							
								
							}

							String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("file-temp-path");
							String fileName=filePath+"ProductRequirementsReportAsRSTracker.xls";
							FileOutputStream fileOut =  new FileOutputStream(fileName);	


							hwb.write(fileOut);
							fileOut.close();
							return fileName;

						}
						else
						{
							throw new NoProductReqAvailableException();
						}
					}
				catch (NoProductReqAvailableException e) 
					{   
						throw(e);
					 
					}   
				catch (Exception e) 
					{  
					e.printStackTrace();
						throw(e);
					 
					}   
				}
} 



