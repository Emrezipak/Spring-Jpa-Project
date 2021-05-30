package KodlamaIo.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import KodlamaIo.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

	@Query("From JobAdvertisement where jobCondition=true")
	List<JobAdvertisement> getByJobCondition();
	
	List<JobAdvertisement> getByJobConditionIsTrueOrderByReleaseDateAsc();
	
	List<JobAdvertisement> getByJobConditionIsTrueAndEmployer_CompanyName(String companyId);
	
	JobAdvertisement getByIdAndEmployer_CompanyName(int id,String companyName);
	
	
}
	

