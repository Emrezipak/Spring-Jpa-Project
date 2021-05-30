package KodlamaIo.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.JobPositionService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.JobPosition;


@RestController
@RequestMapping("/jobPosition")
public class JobPositionController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/jobPosition")
	public DataResult<List<JobPosition>>  getAll(){
		return jobPositionService.getAll();
	}
	
	@PostMapping("/add")
	public Result save(@RequestBody JobPosition jobPosition) {
		
		return this.jobPositionService.save(jobPosition);
	}
	
	
}
