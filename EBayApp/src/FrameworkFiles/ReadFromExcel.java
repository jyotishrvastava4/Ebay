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
			
			 //String p[][]=new String[sSheet.getColumns()][ sSheet.getRows()];
			  for (int i=0;i<=(sSheet.getRows()-1);i++){
				  System.out.println("Rows:" +sSheet.getRows());
				  for (int j=0;j<=(sSheet.getColumns()-1);j++){
					  System.out.println("Column:" +sSheet.getColumns());
					  // p[i][j]=sSheet.getCell(j, i).getContents();
					  
					  System.out.println(i+" "+j+" "+sSheet.getCell(j, i).getContents());
					 if (sSheet.getCell(j, i).getContents().equalsIgnoreCase("Product")) {
						 sData= sSheet.getCell(j, i+1).getContents();
						 System.out.println("Inside if");
					 }  
				  }
			  }
			
			//Cell cCell = sSheet.getCell(2, 1);
			//String sData = cCell.getContents();
			return sData;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "";
		}
	}
}
