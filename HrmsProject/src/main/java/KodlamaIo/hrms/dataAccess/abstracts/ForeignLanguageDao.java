package KodlamaIo.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage,Integer>{
	
	List<ForeignLanguage> getByJobSeeker_id(int id);
	boolean getAllByLanguageName(String languuge);

}
