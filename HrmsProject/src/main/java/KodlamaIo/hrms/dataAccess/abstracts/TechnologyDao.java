package KodlamaIo.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology,Integer>{

	List<Technology> getByJobSeeker_id(int id);


}
