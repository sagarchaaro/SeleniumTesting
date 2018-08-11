package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilities.Constant;

public class ExcelConfig {
	
	public static FileInputStream fis;
	public static  XSSFWorkbook wbk;
	public static  XSSFSheet sh;
	
	public static void setExcelPath(String testDataPath, String sheetName) throws Exception{
		fis= new FileInputStream(testDataPath);
		 wbk=new XSSFWorkbook(fis);
		 sh =wbk.getSheet(sheetName);
	}
	
	public static int getRow(String testDataPath, String sheetName) throws Exception{
		int row=0;
		setExcelPath(testDataPath, sheetName);
			for( row=0;row<=sh.getLastRowNum();row++)
			{
				if(sh.getRow(row).getCell(0).getStringCellValue().equalsIgnoreCase(Constant.Test_Id))
				{
					System.out.println("Match Test is found");
					break;					
				}
			}
		return row;
	}
	
	public static String getCellData (int row_no, int col_no)
	{
		String data=sh.getRow(row_no).getCell(col_no).getStringCellValue();
		return data;	
	}
	
	
	public static void setCellData(String sData, int row_no, int col_no) {
		sh.getRow(row_no).getCell(col_no).setCellValue(sData);
	}
}
