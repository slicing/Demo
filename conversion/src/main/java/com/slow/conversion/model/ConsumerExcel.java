package com.slow.conversion.model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ConsumerExcel {
	Map<String,Long> data = new HashMap<>();
	public Map<String,Long> getData(){
		File file = new File("");
		readExcel(file);
		return data;
	}

	private void readExcel(File file) {
		try {
			InputStream  is = new FileInputStream(file.getAbsolutePath());
			Workbook wk = Workbook.getWorkbook(is);
			int page_size = wk.getNumberOfSheets();
			for (int inedx  = 0;inedx<page_size;inedx++){
				Sheet sheet = wk.getSheet(inedx);
				for (int i = 0;i<sheet.getRows();i++){
					for (int j = 0;j<sheet.getColumns()-1;j++){
						data.put(sheet.getCell(j,i).getContents(),Long.valueOf(sheet.getCell(j+1,i).getContents()));
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}
}
