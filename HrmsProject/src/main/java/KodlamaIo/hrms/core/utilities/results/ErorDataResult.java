package KodlamaIo.hrms.core.utilities.results;

public class ErorDataResult<T> extends DataResult<T>{

	public ErorDataResult(T data, String message) {
		super(data, message, false);
	}

	public ErorDataResult(String message) {
		super(null, message, false);
	}

	public ErorDataResult(T data) {
		super(false, data);
	} 
	
	public ErorDataResult() {
		super(false,null);
	}
}
