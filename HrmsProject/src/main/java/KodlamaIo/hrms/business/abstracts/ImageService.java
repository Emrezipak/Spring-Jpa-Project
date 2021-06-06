package KodlamaIo.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.Image;

public interface ImageService{
	
	DataResult<Image> getById(int id);
	
    Result add(Image image,MultipartFile file);
    
	Result getByIdDelete(int imageId);
	
	DataResult<Image> getByJobSeeker_id(int id);




}
