package com.AvionSchool.lms.generic.fileutlity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheet,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/Avion_School_Test_Script_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(rownum).getCell(cellnum).toString();
		wb.close();
		return data;
	}
	public String getDataFromExcel(String url,String Sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(url);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet);
		String value = sh.getRow(row).getCell(cell).toString();
		wb.close();
		return value;
	}
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/ExcelFor10Assignments.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rownum=wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return rownum;
	}
	public void setDataintoExcel(String sheet,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/ExcelFor10Assignments.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell col = wb.getSheet(sheet).getRow(rownum).createCell(cellnum);
		col.setCellType(CellType.STRING);
		col.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./testdata/ExcelFor10Assignments.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	


}
