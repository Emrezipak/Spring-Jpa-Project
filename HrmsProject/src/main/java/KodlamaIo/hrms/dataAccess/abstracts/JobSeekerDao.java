package KodlamaIo.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.JobPosition;
import KodlamaIo.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer>{

	List<JobSeeker> findAllByEmail(String Email);
	List<JobSeeker> findAllByidentificationNo(String nationalIdentity);
	JobSeeker getById(int id);
}
