package KodlamaIo.hrms.business.abstracts;

import KodlamaIo.hrms.entities.concretes.Employer;

public interface EmployerService extends EntityService<Employer>{
	boolean controlPassword(Employer employer);

}
