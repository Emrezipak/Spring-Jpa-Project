package KodlamaIo.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.JobAdvertisementService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.ErrorDataResult;
import KodlamaIo.hrms.core.utilities.results.ErrorResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.core.utilities.results.SuccessDataResult;
import KodlamaIo.hrms.core.utilities.results.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.EmployerDao;
import KodlamaIo.hrms.dataAccess.abstracts.JobAdvertisementDao;
import KodlamaIo.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,EmployerDao employerDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao=employerDao;
	}

	@Override
	public Result add(JobAdvertisement job) {
		
		if(job.getMaxSalary()<=0 || job.getMinSalary()<=0) {
			return new ErrorResult("Geçerli bir maaş bilgisi giriniz");
		}
		if(job.getCity().getId()<=0 || job.getEmployer().getId()<=0 || job.getJobPosition().getId()<=0) {
			return new ErrorResult("Gerekli alanları doldurunuz...");
		}
		if(!controlEmployerId(job.getEmployer().getId())) {
			return new ErrorResult("Kayıtlı bir şirket yok...");
		}
		this.jobAdvertisementDao.save(job);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobCondition() {
		
	   return new SuccessDataResult
		<List<JobAdvertisement>>(this.jobAdvertisementDao.getByJobCondition(),"Aktif iş ilanları listelendi...");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobConditionTrueOrderByreleaseDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByJobConditionIsTrueOrderByReleaseDateAsc(),"İş ilanları tarihe göre listelendi...");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_companyName(String companyName) {
		if(jobAdvertisementDao.getByJobConditionIsTrueAndEmployer_CompanyName(companyName).stream().count()==0) {
			return new ErrorDataResult<List<JobAdvertisement>>("Şirket için açık bir ilan bulunamadı...");
		}
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByJobConditionIsTrueAndEmployer_CompanyName(companyName),"Şirketin tüm iş ilanları listelendi...");
	}

	@Override
	public Result jobAdvertisementActive(int id, String companyName) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.getByIdAndEmployer_CompanyName(id, companyName);
		if(jobAdvertisement==null) {
			return new ErrorResult("Bu isimde bir iş ilanı bulunmuyor...");
		}
		jobAdvertisement.setJobCondition(!jobAdvertisement.isJobCondition());
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı güncellendi");
	}

	@Override
	public boolean controlEmployerId(int id) {
	
		if(employerDao.getById(id)==null) {
			return false;
		}
		return true;

	}

}
