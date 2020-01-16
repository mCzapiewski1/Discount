package pl.discount.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/files")
public class FilesController {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/user_images";
	
	
	@RequestMapping(value = "/showUploadPage", method = RequestMethod.GET)
	public String showUploadPage() {
		
		return "upload-page";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFiles(Model theModel, @RequestParam("files") MultipartFile[] files) {
		
		StringBuilder fileNames = new StringBuilder();
		for(MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, file.getBytes());
				System.out.println("File wirtten");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/files/showUploadPage";
	}
	
}
