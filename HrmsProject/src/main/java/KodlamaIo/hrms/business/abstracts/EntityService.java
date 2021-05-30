package KodlamaIo.hrms.business.abstracts;

import java.util.List;

import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;

public interface EntityService <T>{

	DataResult<List<T>> getAll();
	Result save(T user);
	boolean control(T user);

}
