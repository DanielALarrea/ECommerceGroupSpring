package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class FileUploadController {
	
	@Autowired
	ServletContext context;

//	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	private static final String LOCAL_PROJECT = "D:/GitHub Repos/ECommerceGroupSpring";
	
	private static final String UPLOAD_DIRECTORY = LOCAL_PROJECT + "/WebContent/resources/theme1/assets/productpics";

	@PostMapping("/uploadFile")
	public ModelAndView uploadFileHandler(@RequestParam CommonsMultipartFile file, HttpSession session) throws Exception {
//		String path  =session.getServletContext().getRealPath("/");  
		String path = UPLOAD_DIRECTORY;
//		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = "image2" + ".png";  

		System.out.println(path + " " + filename);  
		try{  
			byte barr[] = file.getBytes();  

			BufferedOutputStream bout=new BufferedOutputStream(  
					new FileOutputStream(path + "/" + filename));  
			bout.write(barr);  
			bout.flush();  
			bout.close();  

		} catch (Exception e) {System.out.println(e);}  
		return new ModelAndView("test/upload-success", "filename", path + "/" + filename); 
	}

}
