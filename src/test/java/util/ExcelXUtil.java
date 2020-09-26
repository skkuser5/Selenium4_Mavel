package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelXUtil {
	FileInputStream fis = null;
	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	
	public ExcelXUtil(String path)
	{
		try {
			fis=new FileInputStream(new File(path));
			workbook=new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This is to read the row count of excel sheet
	 * @return
	 */
	
	public int getRowCount(String sheetName) {
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//row index
		int rowCount = sheet.getLastRowNum()+1;
		
		return rowCount;
		
	}
	
	/**
	 * This is to read the column count of excel sheet
	 * @return
	 */
	public int getColumnCount(String sheetName, int rowIndex) {
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowIndex);
		return row.getLastCellNum();
		
	}
	
	/**
	 * This is to read the cell value from excel sheet
	 * @return
	 */
	public String getCellValue(String sheetName,int rowIndex, int colIndex) {
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowIndex);
		XSSFCell cell = row.getCell(colIndex);
		
		return cell.toString();
		
		
	}
	
	public static void main(String[] args) {
		String projPath = System.getProperty("user.dir");
		String xlsFilePath = projPath+"\\src\\test\\resources\\testData\\UsersData.xlsx";
		ExcelXUtil excel = new ExcelXUtil(xlsFilePath);
		
		System.out.println("row count "+excel.getRowCount("Sheet1"));
		System.out.println("col count "+excel.getColumnCount("Sheet1", 1));
		System.out.println("cell Value "+excel.getCellValue("Sheet1", 1, 1));
		
	}
	
	

}
