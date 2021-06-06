package KodlamaIo.hrms.business.abstracts;

import java.util.List;

import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.Technology;

public interface CvService<T> {
	
	Result add(T t);
	DataResult<List<T>> getAll();



}
