package KodlamaIo.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement job);
	DataResult<List<JobAdvertisement>> getByJobCondition();
	DataResult<List<JobAdvertisement>> getByJobConditionTrueOrderByreleaseDateDesc();
	
	DataResult<List<JobAdvertisement>> getByEmployer_companyName(String companyId);

	Result jobAdvertisementActive(int id,String companyName);
	boolean controlEmployerId(int id);
}
