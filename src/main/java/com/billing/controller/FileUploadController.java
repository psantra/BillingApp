package com.billing.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.billing.service.FileProcessingService;

@Controller
public class FileUploadController {
    //private static String UPLOADED_FOLDER = "R://tempUpload//";
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private FileProcessingService fileProcessingService;

    

	@RequestMapping(value = "/uploadStatus", method = RequestMethod.GET)
    public String uploadStatus() {
        return "uploadStatus";
    }

    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public String uploadFile(Model model, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        logger.info("Inside File Upload Controller !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        if (file.isEmpty()) {
            //redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
        	model.addAttribute("errorMessage", "Please select a file to upload");
            return "fileUpload";
        }

        try {
            logger.info("Preparing to upload a file");
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(file.getOriginalFilename());
            logger.info("file.getOriginalFilename() :" +file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            logger.info("File Uploaded");
            try {
            	fileProcessingService.processExcelSheet(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

	
    @Autowired
    public void setFileProcessingService(FileProcessingService fileProcessingService) {
		this.fileProcessingService = fileProcessingService;
	}

}
