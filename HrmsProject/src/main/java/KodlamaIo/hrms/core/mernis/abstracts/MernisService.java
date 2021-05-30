package KodlamaIo.hrms.core.mernis.abstracts;

import java.util.Date;

import KodlamaIo.hrms.entities.concretes.JobSeeker;

public interface MernisService {

	boolean mernisCheckService(JobSeeker jobSeeker);
}
