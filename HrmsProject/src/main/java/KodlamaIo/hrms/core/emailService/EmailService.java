package KodlamaIo.hrms.core.emailService;

import KodlamaIo.hrms.core.utilities.results.Result;

public interface EmailService {

	Result sendMessage(String message);
}
