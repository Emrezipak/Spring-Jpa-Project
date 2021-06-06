package KodlamaIo.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.TechnologyService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.Technology;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {
	
	private TechnologyService technologyService;
	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Technology skill) {
		return this.technologyService.add(skill);
	}
	
	@GetMapping("/getAllSkills")
	public DataResult<List<Technology>> getAll() {
		return this.technologyService.getAll();
	}

}
