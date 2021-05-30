package KodlamaIo.hrms.core.utilities.results;

public class ErorResult extends Result{

	public ErorResult() {
		super(false);
	}
	
	public ErorResult(String message) {
		super(message,false);
	}

}
