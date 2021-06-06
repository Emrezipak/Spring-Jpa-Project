package KodlamaIo.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import KodlamaIo.hrms.business.abstracts.ImageService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.Image;
import KodlamaIo.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping(value="/api/loadImage")
public class ImageController {
	
	private ImageService imageService;
    @Autowired
	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}
    
    @PostMapping("/addImage")
	public Result add(@RequestParam int id, @RequestParam MultipartFile file) {
    	Image image=new Image();
		JobSeeker jobSeeker=new JobSeeker();
		jobSeeker.setId(id);
		image.setJobSeeker(jobSeeker);
    	return this.imageService.add(image, file);
    }
    
    @DeleteMapping("/deleteImage")
	public Result deleteImage(@RequestParam int id) {
    	
    	return this.imageService.getByIdDelete(id);
    }
    
    @GetMapping("/getImage")
	public DataResult<Image> getByJobSeeker_id(int id) {
    	return this.imageService.getByJobSeeker_id(id);
    }



	   
	   

}
