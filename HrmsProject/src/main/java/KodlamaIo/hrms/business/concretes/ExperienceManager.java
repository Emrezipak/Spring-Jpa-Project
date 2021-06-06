package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.ExperienceService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.ErrorDataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.core.utilities.results.SuccessDataResult;
import KodlamaIo.hrms.core.utilities.results.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.ExperienceDao;
import KodlamaIo.hrms.entities.concretes.Experience;
import KodlamaIo.hrms.entities.concretes.JobSeekerCv;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}	

	@Override
	public Result add(Experience skill) {
		if(continueWorkplace(skill)) {
			
		}
		this.experienceDao.save(skill);
		return new SuccessResult("Deneyimler eklendi...");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll());
	}
	
	private boolean continueWorkplace(Experience skill) {
		
		if(skill.getFinishYear()==null) {
			skill.setJobCondition(true);
			return true;
		}
		
		skill.setJobCondition(false);
		return false;
	}
	
	
	@Override
	public DataResult<List<Experience>> getByFinishYearCv(int id) {
		
		if(this.experienceDao.getByJobSeeker_idOrderByFinishYear(id).stream().count()==0) {
			return new ErrorDataResult<>("Aday bulunamadı...");
		}
	
		return new SuccessDataResult<List<Experience>>
		(this.experienceDao.getByJobSeeker_idOrderByFinishYear(id),"Deneyimler tarihe sıralandı...");
	}

	@Override
	public DataResult<List<Experience>> getByJobSeeker(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByJobSeeker_id(id),"Deneyimler listelendi...");
	}

}
