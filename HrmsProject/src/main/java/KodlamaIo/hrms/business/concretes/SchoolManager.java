package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.SchoolService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.ErrorDataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.core.utilities.results.SuccessDataResult;
import KodlamaIo.hrms.core.utilities.results.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.SchoolDao;
import KodlamaIo.hrms.entities.concretes.ForeignLanguage;
import KodlamaIo.hrms.entities.concretes.JobSeekerCv;
import KodlamaIo.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{
	
	private SchoolDao schoolDao;

    @Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		
		if(continueSchool(school)) {
			
		}
		this.schoolDao.save(school);
		return new SuccessResult("Okul başarı ile eklendi...");
	}
	
	private boolean continueSchool(School school) {
		
		if(school.getFinishYear()==null) {
			school.setJobCondition(true);
			return true;
		}
		school.setJobCondition(false);
		return false;
	}

	@Override
	public DataResult<List<School>> getByFinishSchoolYear(int id) {
		
	  if(this.schoolDao.getByJobSeeker_idOrderByFinishYear(id).stream().count()==0) {
		  return new ErrorDataResult<>("Aday bulunamadı");
	  }
	   return new SuccessDataResult<List<School>>
	   (this.schoolDao.getByJobSeeker_idOrderByFinishYear(id),"Okul bilgisi tarihe göre sırlandı...");
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>
		(this.schoolDao.findAll(),"Okullar listelendi...");
	}

	@Override
	public DataResult<List<School>> getByJobSeeker(int id) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getByJobSeeker_id(id),"Okul bilgisi listelendi...");
	}
	
	
	  

}
