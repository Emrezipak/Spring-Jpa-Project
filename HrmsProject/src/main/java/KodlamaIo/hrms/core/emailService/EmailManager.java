package KodlamaIo.hrms.core.emailService;

import org.springframework.stereotype.Service;

import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.core.utilities.results.SuccessResult;
@Service
public class EmailManager implements EmailService {

	@Override
	public Result sendMessage(String message) {
		return new SuccessResult("Email onaylandı : "+message);
	}

}
