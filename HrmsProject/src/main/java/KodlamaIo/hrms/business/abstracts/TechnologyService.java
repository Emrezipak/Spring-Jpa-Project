package KodlamaIo.hrms.business.abstracts;

import java.util.List;

import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.entities.concretes.Technology;

public interface TechnologyService extends CvService<Technology>{
	
	DataResult<List<Technology>> getByJobSeeker(int id);
	//Result<Technology> getAllByTecnologyName(String skill);


}
