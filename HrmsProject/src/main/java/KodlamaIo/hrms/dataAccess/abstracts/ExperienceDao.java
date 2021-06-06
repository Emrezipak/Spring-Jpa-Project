package KodlamaIo.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.Experience;
import KodlamaIo.hrms.entities.concretes.JobSeekerCv;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {

	List<Experience> getByJobSeeker_idOrderByFinishYear(int id);
	List<Experience> getByJobSeeker_id(int id);
	
	//JobSeeker in içindeki id ulaşmamız gerekiyor...
}
