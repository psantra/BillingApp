package com.billing.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileProcessingService {
	
	public void processExcelSheet(MultipartFile file) throws Exception;

}
