package KodlamaIo.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
