package com.billing.service.impl;

import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.billing.service.FileProcessingService;

@Service
public class FileProcessingServiceImpl implements FileProcessingService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void processExcelSheet(MultipartFile file) throws Exception {
		InputStream stream = file.getInputStream();
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		// Sample code - Logic needs to be written here
		while (rowIterator.hasNext()) {
			// Skip read heading

			// get first cell of current row
			String name = rowIterator.next().getCell(0).toString();
			// Now you can assign this value to domain property
			logger.info("name:" + name);

		}

	}
}
