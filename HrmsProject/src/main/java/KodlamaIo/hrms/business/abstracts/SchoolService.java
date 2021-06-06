package KodlamaIo.hrms.business.abstracts;

import java.util.List;

import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.entities.concretes.Experience;
import KodlamaIo.hrms.entities.concretes.School;

public interface SchoolService extends CvService<School>{

	DataResult<List<School>> getByFinishSchoolYear(int id);
	DataResult<List<School>> getByJobSeeker(int id);

}
