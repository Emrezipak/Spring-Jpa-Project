package KodlamaIo.hrms.business.abstracts;

import java.util.List;

import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.entities.concretes.Experience;

public interface ExperienceService extends CvService<Experience>{
	
	DataResult<List<Experience>> getByFinishYearCv(int id);
	DataResult<List<Experience>> getByJobSeeker(int id);

}
