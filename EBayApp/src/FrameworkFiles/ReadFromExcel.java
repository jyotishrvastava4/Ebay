package FrameworkFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadFromExcel {

	
	public String ReadCategoryFromExcel() throws IOException{
		try{
			String sUserDirectory = System.getProperty("user.dir");
			String sFileLocation = sUserDirectory + "\\Data.xls";
			File file=new File(sFileLocation);
			Workbook wBook = Workbook.getWorkbook(file);
			Sheet sSheet =wBook.getSheet(0);
			Cell cCell = sSheet.getCell(2, 1);
			String sData = cCell.getContents();
			return sData;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "";
		}
	}
}
