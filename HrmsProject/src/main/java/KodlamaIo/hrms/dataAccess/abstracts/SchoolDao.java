package KodlamaIo.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School,Integer> {

	List<School> getByJobSeeker_idOrderByFinishYear(int id);
	List<School> getByJobSeeker_id(int id);

}
