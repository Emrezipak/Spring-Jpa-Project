package KodlamaIo.hrms.business.abstracts;

import java.util.List;

import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService extends CvService<ForeignLanguage>{

	DataResult<List<ForeignLanguage>> getByJobSeeker(int id);

}
