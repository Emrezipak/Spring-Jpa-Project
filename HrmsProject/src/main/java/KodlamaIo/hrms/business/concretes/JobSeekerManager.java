package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.JobSeekerService;
import KodlamaIo.hrms.business.abstracts.UserService;
import KodlamaIo.hrms.core.mernis.abstracts.MernisService;
import KodlamaIo.hrms.core.utilities.results.*;
import KodlamaIo.hrms.dataAccess.abstracts.JobSeekerDao;
import KodlamaIo.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserService userService;
	private MernisService mernisService;
	@Autowired
	
	public JobSeekerManager(JobSeekerDao jobSeekerDao,UserService userService,MernisService mernisService) {
		this.jobSeekerDao = jobSeekerDao;
		this.userService=userService;
		this.mernisService=mernisService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(),"JobSeeker listelendi...");
	}

	@Override
	public Result save(JobSeeker user) {
		
		if(user.getUserName()==null || user.getUserName().trim().equals("")||
		   user.getUserSurname()==null || user.getUserSurname().trim().equals("")||
		   user.getPassword()==null || user.getPassword().trim().equals("") ||
		   user.getIdentificationNo()==null || user.getIdentificationNo().trim().equals("")||
		   user.getEmail()==null || user.getEmail().trim().equals("")) {
			return new ErorResult("Gerekli alanları doldurunuz...");
		}
		if(control(user)) {
			return new ErorResult("Gmail ya da kimlik no daha önceden kayıtlı...");
		}
		else if(controlPassword(user)) {
			return new ErorResult("Şifreler uyuşmamaktadır...");
		}		
		
		this.jobSeekerDao.save(user);
		this.mernisCheckService(user);
		this.userService.sendMesagge(user.getEmail());
		return new SuccessResult("added JobSeeker");
	}

	@Override
	public boolean control(JobSeeker user) {
		
		if(jobSeekerDao.findAllByEmail(user.getEmail()).stream().count()!=0 ||
		   jobSeekerDao.findAllByidentificationNo(user.getIdentificationNo()).stream().count()!=0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean controlPassword(JobSeeker jobSeeker) {
		if(!jobSeeker.getPassword().equals(jobSeeker.getConfirmPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public Result mernisCheckService(JobSeeker jobSeeker) {
		
		return new SuccessResult("Mernis doğrulaması başarılı...");
	}


}
