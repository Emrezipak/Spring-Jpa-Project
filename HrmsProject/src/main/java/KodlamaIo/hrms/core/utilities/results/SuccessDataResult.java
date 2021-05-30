package KodlamaIo.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data, String message) {
		super(data, message, true);
	}

	public SuccessDataResult(String message) {
		super(null, message, true);
	}

	public SuccessDataResult(T data) {
		super(true, data);
	} 
	
	public SuccessDataResult() {
		super(true,null);
	}

	
	
	

}
