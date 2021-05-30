package KodlamaIo.hrms.core.mernis.concretes;

import org.springframework.stereotype.Service;

import KodlamaIo.hrms.core.mernis.abstracts.MernisService;
import KodlamaIo.hrms.entities.concretes.JobSeeker;

@Service
public class MernisAdapter implements MernisService{

	@Override
	public boolean mernisCheckService(JobSeeker jobSeeker) {		
		return true;
		
	}

	

}
