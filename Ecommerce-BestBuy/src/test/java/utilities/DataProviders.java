package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\BestBuy_LoginTestData.xlsx";//taking excel file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for ExcelUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //read the data from excel and storing in two dimensional array
		{		
			for(int j=0;j<totalcols;j++)  //i is rows j is columns
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);
			}
		}
	return logindata;//returning two dimension array
				
	}
}
