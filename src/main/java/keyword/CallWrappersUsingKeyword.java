package keyword;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import wrappers.GenericWrappers;

public class CallWrappersUsingKeyword {
	
	public void getAndCallKeyword(String fileName) throws Exception{
		FileInputStream file = new FileInputStream(new File(fileName));
		
		//Create workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		Class<GenericWrappers> wrapper = GenericWrappers.class;
		Object wM = wrapper.newInstance();
		
		//Get first/desired sheet from the workbook
		XSSFSheet sh = workbook.getSheetAt(0);
		for(int i=1; i<=sh.getLastRowNum(); i++){
			String keyword = "";
			String locator = "";
			String data = "";
			try{
				keyword = sh.getRow(i).getCell(0).getStringCellValue();
				locator = sh.getRow(i).getCell(1).getStringCellValue();
				data = sh.getRow(i).getCell(2).getStringCellValue();
			}catch(NullPointerException e){
				e.printStackTrace();
			}
			
			Method[] methodName = wrapper.getDeclaredMethods();
			for(Method method: methodName){
				if(method.getName().toLowerCase().equals(keyword.toLowerCase())){
					if(locator.equals("") && data.equals(""))
						method.invoke(wM);
					else if(locator.equals(""))
						method.invoke(wM,data);
					else if(data.equals(""))
						method.invoke(wM,locator);
					else
						method.invoke(wM,locator,data);
					
					break;
				}
			}
		}
	}

}
