package KodlamaIo.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import KodlamaIo.hrms.business.abstracts.ImageService;
import KodlamaIo.hrms.core.cloudinary.ImageCheckService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.ErrorDataResult;
import KodlamaIo.hrms.core.utilities.results.ErrorResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.core.utilities.results.SuccessDataResult;
import KodlamaIo.hrms.core.utilities.results.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.ImageDao;
import KodlamaIo.hrms.dataAccess.abstracts.JobSeekerDao;
import KodlamaIo.hrms.entities.concretes.Image;
import KodlamaIo.hrms.entities.concretes.JobSeeker;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	private ImageCheckService imageCheckService;
	private JobSeekerDao jobSeekerDao;
	@Autowired

	public ImageManager(ImageDao imageDao, ImageCheckService imageCheckService, JobSeekerDao jobSeekerDao) {
		super();
		this.imageDao = imageDao;
		this.imageCheckService = imageCheckService;
		this.jobSeekerDao = jobSeekerDao;
	}


	@Override
	public Result add(Image image, MultipartFile file) {
		
		Map<String,String> photo=(Map<String,String>) this.imageCheckService.loadFile(file).getData();
		String url=photo.get("url");
		image.setImageUrl(url);
		this.imageDao.save(image);
	    return new SuccessResult("Resim eklendi...");
	}

	
	public DataResult<Image> getById(int id){
		
		if(this.imageDao.getById(id)==null) {
			return new ErrorDataResult<>("Fotoğraf bilgisi bulunmuyor...");
		}
		
		return new SuccessDataResult<Image>(this.imageDao.getById(id));
		
	}


	@Override
	public Result getByIdDelete(int imageId) {
		this.imageDao.deleteById(imageId);
		return new SuccessResult("resim silindi");
	}


	@Override
	public DataResult<Image> getByJobSeeker_id(int id) {
		
		return new SuccessDataResult<Image>(this.imageDao.getByJobSeeker_id(id),"resim listelendi");
	}

}
