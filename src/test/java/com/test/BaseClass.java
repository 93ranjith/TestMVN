package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class BaseClass {
	
	public static void main(String[] args) throws IOException {
		
		
		File f = new File("C:\\Users\\kumar\\eclipse-workspace\\TestMvn\\External file\\Book1.xlsx ");
		
		FileInputStream file = new FileInputStream(f);
		
		  Workbook Sheet1 = new XSSFWorkbook(file);
		   
		  Sheet sheet = Sheet1.getSheet("Sheet1");
		  
		  for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
			  
			  Row allrow = sheet.getRow(i);
			  
			  for (int j = 0; j <allrow.getPhysicalNumberOfCells(); j++) {
				  
				  Cell allcellValues = allrow.getCell(j);
			
			
				  int cellType = allcellValues.getCellType();
				  
				  if (cellType==1) {
					  
					  String stringValue = allcellValues.getStringCellValue();
					  System.out.println(stringValue);
					
				}else {
					
					double num = allcellValues.getNumericCellValue();
						
					//downcast
					
					long l =(long)num;
					
					//long convert to string
					
					String valueOf = String.valueOf(l);
					System.out.println(valueOf);
					
					
				}
				  
			}
			
		}
		  
		
		
		
		
		
	}
	
	
	
	
}
		
		  
		
		

		
		
		
		
		
		
