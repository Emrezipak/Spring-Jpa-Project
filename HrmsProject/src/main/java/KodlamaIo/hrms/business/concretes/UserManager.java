package KodlamaIo.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.UserService;
import KodlamaIo.hrms.core.emailService.EmailService;
import KodlamaIo.hrms.core.utilities.results.ErrorResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private EmailService emailService;
	@Autowired
	public UserManager(EmailService emailService) {
		this.emailService = emailService;
	}

	@Override
	public void sendMesagge(String message) {
		this.emailService.sendMessage(message);
	}
}
