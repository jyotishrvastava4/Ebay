package FrameworkFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import jxl.Cell;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadFromExcel {

	
	public String ReadCategoryFromExcel() throws IOException{
		try{
			String sData="";
			String sUserDirectory = System.getProperty("user.dir");
			String sFileLocation = sUserDirectory + "\\Data.xls";
			File file=new File(sFileLocation);
			Workbook wBook = Workbook.getWorkbook(file);
			Sheet sSheet =wBook.getSheet(0);
			  for (int i=0;i<=(sSheet.getRows()-1);i++){
				  for (int j=0;j<=(sSheet.getColumns()-1);j++){
					 if (sSheet.getCell(j, i).getContents().equalsIgnoreCase("Product")) {
						 sData= sSheet.getCell(j, i+1).getContents();
					 }  
				  }
			  }
			return sData;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "";
		}
	}
}
