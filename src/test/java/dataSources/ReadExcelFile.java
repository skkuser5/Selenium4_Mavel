package dataSources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String projPath = System.getProperty("user.dir");
		File xlsFile = new File(projPath+"\\src\\test\\resources\\testData\\UsersData.xlsx");
		XSSFWorkbook workbook=null;
		try {
			FileInputStream fis = new FileInputStream(xlsFile);
			 workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			//row index
			int rowCount = sheet.getLastRowNum()+1;
			
			short colCount = sheet.getRow(0).getLastCellNum();
			
			for(int i=1; i<rowCount;i++)
			{
				for (int j=0;j<colCount;j++)
				{
					
					try {
						XSSFCell cell = sheet.getRow(i).getCell(j);
						//cell.setCellValue("newPassword");
						System.out.println(cell.toString());
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		finally {
			workbook.close();
		}
		
		

	}

}
