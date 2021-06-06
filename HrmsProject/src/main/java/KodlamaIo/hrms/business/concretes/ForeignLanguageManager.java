package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.ForeignLanguageService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.core.utilities.results.SuccessDataResult;
import KodlamaIo.hrms.core.utilities.results.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.ForeignLanguageDao;
import KodlamaIo.hrms.entities.concretes.Experience;
import KodlamaIo.hrms.entities.concretes.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

	private ForeignLanguageDao languageDao;
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public Result add(ForeignLanguage language) {
		this.languageDao.save(language);
		return new SuccessResult("Yabancı dil eklendi...");
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>
		(this.languageDao.findAll(),"Yabancı diller listelendi...");
	}

	@Override
	public DataResult<List<ForeignLanguage>> getByJobSeeker(int id) {
		return new SuccessDataResult<List<ForeignLanguage>>(this.languageDao.getByJobSeeker_id(id),"Dil bilgisi listelendi...");

	}

}
