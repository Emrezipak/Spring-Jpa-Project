package KodlamaIo.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.ExperienceService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.Experience;
import KodlamaIo.hrms.entities.concretes.JobSeekerCv;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

	private ExperienceService experienceService;

	@Autowired
	public ExperienceController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Experience skill) {
		return this.experienceService.add(skill);
	}
	
	
	@GetMapping("/getByStartsExperienceYear")
	public DataResult<List<Experience>> getByFinishYearCv(@RequestParam int id) {
		return this.experienceService.getByFinishYearCv(id);
	}
	
	
	
	
	
}
