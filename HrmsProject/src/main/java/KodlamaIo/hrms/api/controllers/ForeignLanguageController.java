package KodlamaIo.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.ForeignLanguageService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.ForeignLanguage;

@RestController
@RequestMapping("/api/foreignlanguage")
public class ForeignLanguageController {
	
	private ForeignLanguageService languageService;
	@Autowired
	public ForeignLanguageController(ForeignLanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping("/addLanguage")
	public Result add(@RequestBody ForeignLanguage language) {
		return this.languageService.add(language);
	}
	
	@GetMapping("/getAllLanguage")
	public DataResult<List<ForeignLanguage>> getAll(){
		return this.languageService.getAll();
	}
	

}
