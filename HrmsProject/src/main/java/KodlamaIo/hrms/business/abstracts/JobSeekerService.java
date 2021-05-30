package KodlamaIo.hrms.business.abstracts;

import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService extends EntityService<JobSeeker>{
	boolean controlPassword(JobSeeker jobSeeker);
	Result mernisCheckService(JobSeeker jobSeeker);

}
