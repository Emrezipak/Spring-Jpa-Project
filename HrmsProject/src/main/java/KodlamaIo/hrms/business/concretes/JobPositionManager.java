package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.JobPositionService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.ErorResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.core.utilities.results.SuccessDataResult;
import KodlamaIo.hrms.core.utilities.results.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.JobPositionDao;
import KodlamaIo.hrms.entities.concretes.Employer;
import KodlamaIo.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"Job position listelendi");
	}

	@Override
	public Result save(JobPosition user) {
		user.setJobName(user.getJobName().toLowerCase());
		if(user.getJobName()==null || user.getJobName().trim().equals("")) {
			return new ErorResult("Gerekli alanları doldurunuz...");
		}
		else if(control(user)) {
			return new ErorResult("Bu isimli bir pozisyon mevcut...");
		}
		
		this.jobPositionDao.save(user);
		return new SuccessResult("added job position");
	}

	@Override
	public boolean control(JobPosition user) {
		
		if(jobPositionDao.findByjobName(user.getJobName().toLowerCase()).stream().count()!=0) {
				return true;
		}
		return false;
	}

}
