package KodlamaIo.hrms.business.abstracts;

import java.util.List;

import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.entities.concretes.JobSeekerCv;
import KodlamaIo.hrms.entities.dtos.CvDto;

public interface JobSeekerCvService extends CvService<JobSeekerCv>{

	DataResult<List<JobSeekerCv>> getByIdCv(int id,String identificationNo);
	DataResult<List<JobSeekerCv>> getByJobSeeker(int id);
	DataResult<CvDto> getByIdCv(int id);



}
