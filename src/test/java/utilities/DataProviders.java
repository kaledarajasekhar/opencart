package utilities;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "login")
	public String[][] getData() throws Exception {
		
		ExcelUtility ex = new ExcelUtility(".//testData//OpenCartLogin.xlsx");
		int rowCount = ex.getRowCount("Sheet1");
		int cellCount = ex.getCellCount("Sheet1", 1);

		String s[][] = new String[rowCount-1][cellCount];

		for (int i = 1; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++)
				s[i - 1][j] = ex.getCellData("Sheet1", i, j);
		}
		return s;
	}
}
