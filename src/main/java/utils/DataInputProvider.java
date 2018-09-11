package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;

import wrappers.GenericWrappers;

public class DataInputProvider extends GenericWrappers{
	
	public static String[][] getSheet(String dataSheetName){
		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(new File("./data/"+dataSheetName+".xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			//get the number of rows
			int rowCount = sheet.getLastRowNum();
			
			//get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][rowCount];
			
			//loop through the rows
			for(int i=1;i<rowCount+1;i++){
				try{
					XSSFRow row = sheet.getRow(i);
					for(int j=0;j<columnCount;j++){
						//loop through the columns
						try{
							String cellValue = "";
							try{
								cellValue = row.getCell(j).getStringCellValue();
							}catch(NullPointerException e){
								e.printStackTrace();
							}
							//add to the data array
							data[i-1][j] = cellValue;
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}

}