package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.ExperienceService;
import KodlamaIo.hrms.business.abstracts.ForeignLanguageService;
import KodlamaIo.hrms.business.abstracts.ImageService;
import KodlamaIo.hrms.business.abstracts.JobSeekerCvService;
import KodlamaIo.hrms.business.abstracts.JobSeekerService;
import KodlamaIo.hrms.business.abstracts.SchoolService;
import KodlamaIo.hrms.business.abstracts.TechnologyService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.ErrorDataResult;
import KodlamaIo.hrms.core.utilities.results.ErrorResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.core.utilities.results.SuccessDataResult;
import KodlamaIo.hrms.core.utilities.results.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.JobSeekerCvDao;
import KodlamaIo.hrms.dataAccess.abstracts.JobSeekerDao;
import KodlamaIo.hrms.entities.concretes.JobSeekerCv;
import KodlamaIo.hrms.entities.dtos.CvDto;

@Service
public class JobSeekerCvManager implements JobSeekerCvService{

	private JobSeekerCvDao jobSeekerCvDao;
	private JobSeekerDao jobSeekerDao;
	private ExperienceService experienceService;
	private ForeignLanguageService foreignLanguageService;
	private SchoolService schoolService;
	private TechnologyService technologyService;
	private ImageService imageService;
	
	@Autowired
	public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao, JobSeekerDao jobSeekerDao,
			ExperienceService experienceService, ForeignLanguageService foreignLanguageService,
			SchoolService schoolService, TechnologyService technologyService, ImageService imageService) {
		super();
		this.jobSeekerCvDao = jobSeekerCvDao;
		this.jobSeekerDao = jobSeekerDao;
		this.experienceService = experienceService;
		this.foreignLanguageService = foreignLanguageService;
		this.schoolService = schoolService;
		this.technologyService = technologyService;
		this.imageService = imageService;
	}

	@Override
	public Result add(JobSeekerCv cv) {
		
		if(cv.getJobSeeker().getId()<=0) {
			return new ErrorResult("İş arayan seçilmedi...");
		}
		this.jobSeekerCvDao.save(cv);
		return new SuccessResult("Cv eklendi...");
	}

	@Override
	public DataResult<List<JobSeekerCv>> getAll() {
		return new SuccessDataResult<List<JobSeekerCv>>
		(this.jobSeekerCvDao.findAll(),"Cv'ler listelendi");
	}

	@Override
	public DataResult<List<JobSeekerCv>> getByIdCv(int id, String identificationNo) {
		
		if(!controlIdentificationNo(identificationNo)) {
			return new ErrorDataResult<>("Bu numarada bir iş arayan mevcut değil");
		}
		else if(id<=0 || identificationNo.trim().equals("")) {
			return new ErrorDataResult<>("Gerekli alanları doldurun");
		}
		return new SuccessDataResult<List<JobSeekerCv>>
		(this.jobSeekerCvDao.getByIdOrJobSeeker_identificationNo(id, identificationNo),"Cv'ler listelendi");
	}
	
	private boolean controlIdentificationNo(String identificationNo) {
		
	   if(jobSeekerDao.findAllByidentificationNo(identificationNo).stream().count()==0){
		   return false;
	   }
	   return true;
	}
	

	@Override
	public DataResult<List<JobSeekerCv>> getByJobSeeker(int id) {
		return new SuccessDataResult<List<JobSeekerCv>>(this.jobSeekerCvDao.getByJobSeeker_id(id));
	}
	
	@Override
	public DataResult<CvDto> getByIdCv(int id) {
	CvDto cvDto=new CvDto();
	cvDto.setJobSeekerCv(this.getByJobSeeker(id).getData());
	cvDto.setExperiences(this.experienceService.getByJobSeeker(id).getData());
	cvDto.setForeignLangauge(this.foreignLanguageService.getByJobSeeker(id).getData());
	cvDto.setSchools(this.schoolService.getByJobSeeker(id).getData());
	cvDto.setTechnologies(this.technologyService.getByJobSeeker(id).getData());
	cvDto.setImages(this.imageService.getById(id).getData());
	return new SuccessDataResult<CvDto>(cvDto,"Tüm cv bilgisi getirildi");
	
	}
	
	 
	
	

}
