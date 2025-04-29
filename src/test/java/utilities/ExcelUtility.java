package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream fis;
	static FileOutputStream fos;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static XSSFCellStyle style;

	static String xlfile;

	public ExcelUtility(String xlfile) {
		this.xlfile = xlfile;
	}

	public int getRowCount(String xlsheet) throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		int row = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return row;
	}

	public  int getCellCount(String xlsheet, int ro) throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(ro);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	}

	public  String getCellData(String xlsheet, int r, int col) throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(r);
		cell = row.getCell(col);
		String data;
		try {
			data = new DataFormatter().formatCellValue(cell);
		} catch (Exception e) {
			return "";
		}
		workbook.close();
		fis.close();
		return data;
	}

	public  void setCellData(String xlsheet, int r, int col, String data) throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		try {
			row = sheet.getRow(r);
		} catch (NullPointerException e) {
			row = sheet.createRow(r);
		}
		cell = row.createCell(col);
		cell.setCellValue(data);
		fos = new FileOutputStream(xlfile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();

	}

	public  void fillGreenColor( String xlsheet, int r, int c) throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(r);
		cell = row.getCell(c);
		style = workbook.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);

		fos = new FileOutputStream(xlfile);
		workbook.write(fos);
		fos.close();
		fis.close();
		workbook.close();

	}

	public  void fillRedColor(String xlsheet, int r, int c) throws Exception {
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(r);
		cell = row.getCell(c);
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fos = new FileOutputStream(xlfile);
		workbook.write(fos);
		workbook.close();
		fos.close();
		fis.close();

	}
}
