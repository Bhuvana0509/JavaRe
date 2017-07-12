package com.infy.utillities;

import java.util.List;

public class Pagination {
	private int numberOfRowsPerpage;

	public  List nextRecordList(List allRecordList,int pageNumber)
	{
		int startRowNumner=(pageNumber-1)*numberOfRowsPerpage;
		int endRowNumber=(pageNumber*this.numberOfRowsPerpage);
		if(startRowNumner<allRecordList.size())
		{
			if(endRowNumber>=allRecordList.size())
			{
				endRowNumber=allRecordList.size();
			}
			
			List sublist=allRecordList.subList(startRowNumner, endRowNumber);
			return sublist;
			//this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.masterReqList.size();
		}
		else
		{
			pageNumber--;
			return null;
		}

		
		
	}
}
