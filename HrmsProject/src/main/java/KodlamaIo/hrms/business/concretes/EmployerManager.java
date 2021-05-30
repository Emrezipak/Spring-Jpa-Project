package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.EmployerService;
import KodlamaIo.hrms.business.abstracts.UserService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.ErorResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.core.utilities.results.SuccessDataResult;
import KodlamaIo.hrms.core.utilities.results.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.EmployerDao;
import KodlamaIo.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	//private EmailService emailService;
	private EmployerDao employerDao;
	private UserService userService;
	@Autowired

	public EmployerManager(EmployerDao employerDao,UserService userService) {
		this.employerDao = employerDao;
		this.userService=userService;
	}

	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Employer listelendi");
	}

	@Override
	public Result save(Employer user) {
		if(user.getEmail().trim().equals("")||
		   user.getEmail()==null||
		   user.getCompanyName().trim().equals("")||
		   user.getCompanyName()==null||
		   user.getPassword().trim().equals("")||
		   user.getPassword()==null||
		   user.getWebsite().trim().equals("")||
		   user.getWebsite()==null) 
		{
			return new ErorResult("Belirli alanları doldurunuz...");
		}
		if(control(user)) {
			return new ErorResult("Daha önce kullanılmıştır...");
		}
		if(controlPassword(user)) {
			return new ErorResult("şifreler uyuşmamaktadır...");
		}
		this.employerDao.save(user);
		this.userService.sendMesagge(user.getEmail());
		return new SuccessResult("added employer");
	}


	@Override
	public boolean control(Employer employer) {
		
		if(employerDao.findAllByEmail(employer.getEmail()).stream().count()!=0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean controlPassword(Employer employer) {
		if(!employer.getPassword().equals(employer.getConfirmPassword())) {
			return true;
		}
		return false;
	}
	



}
