package KodlamaIo.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.entities.concretes.JobSeekerCv;
import KodlamaIo.hrms.entities.dtos.CvDto;

public interface JobSeekerCvDao extends JpaRepository<JobSeekerCv, Integer> {

	List<JobSeekerCv> getByIdOrJobSeeker_identificationNo(int id,String identificationNo);
	List<JobSeekerCv> getByJobSeeker_id(int id);
	

}
