package org.agile4tyro.nytcoder.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MimeTypeInputMethod {
	
	@RequestMapping(value = "uploadFile", method = RequestMethod.POST)
	public String  uploadFile(@RequestParam("file") MultipartFile multipartFile) {
		/* To hit this call by Postman choose "form-data" in request body and put "file" in key file option 
		 * from text and file drop down and choose desired file in value option for key file   */
		return "file name " + multipartFile.getOriginalFilename();
	}
	
	@RequestMapping(value = "storeFile", method = RequestMethod.POST)
	public void  storeFile(@RequestParam("file") MultipartFile multipartFile) throws IllegalStateException, IOException {
		String filePath = "F:\\project\\spring\\spring boot\\project\\spring-boot-samples\\images\\" + multipartFile.getOriginalFilename();
		File file = new File(filePath);
		multipartFile.transferTo(file);
	}
	
	@RequestMapping(value = "deleteAll", method = RequestMethod.GET)
    public void deleteAll() {
		/*It deletes all files in images folder and folder itself.*/
		Path rootLocation = Paths.get("F:\\project\\spring\\spring boot\\project\\spring-boot-samples\\images");
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
	@RequestMapping(value = "downloadFile/{fileName}", method = RequestMethod.GET)
	public ResponseEntity<Resource>  downloadFile(@PathVariable(value = "fileName") String filename) throws MalformedURLException {
		Path rootLocation = Paths.get("F:\\project\\spring\\spring boot\\project\\spring-boot-samples\\images");
		Path file = rootLocation.resolve(filename);
		Resource resource = new UrlResource(file.toUri());
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
}
