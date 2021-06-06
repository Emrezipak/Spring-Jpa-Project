package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.TechnologyService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.core.utilities.results.SuccessDataResult;
import KodlamaIo.hrms.core.utilities.results.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.TechnologyDao;
import KodlamaIo.hrms.entities.concretes.ForeignLanguage;
import KodlamaIo.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyDao techonologyDao;
	@Autowired
	public TechnologyManager(TechnologyDao techonologyDao) {
		super();
		this.techonologyDao = techonologyDao;
	}

	@Override
	public Result add(Technology skill) {

		this.techonologyDao.save(skill);
		return new SuccessResult("Teknoloji eklendi...");
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>
		(this.techonologyDao.findAll(),"Beceriler listelendi...");
	}

	@Override
	public DataResult<List<Technology>> getByJobSeeker(int id) {
		return new SuccessDataResult<List<Technology>>(this.techonologyDao.getByJobSeeker_id(id),"Beceriler listelendi...");

	}
	

}
