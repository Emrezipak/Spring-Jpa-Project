package KodlamaIo.hrms.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.JobAdvertisementService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/JobAdvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAllJobAdvertisement")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getByJobCondition();
	}
	
	@PostMapping("/addJobAdvertisement")
	public Result save(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	
	@GetMapping("/getAllJobAdvertisementDate")
	public DataResult<List<JobAdvertisement>> getByJobConditionTrueOrderByreleaseDateDesc() {
	return this.jobAdvertisementService.getByJobConditionTrueOrderByreleaseDateDesc();
	}
	
	
	@GetMapping("/getAllJobAdvertisementEmployer")
	public DataResult<List<JobAdvertisement>> getByEmployer_companyName(@RequestParam String companyName) {
		return this.jobAdvertisementService.getByEmployer_companyName(companyName);
	}
	
	@GetMapping("/getAllJobJobAdvertisementActive")
	public Result getByEmployer_CompanyName(@RequestParam int id, @RequestParam String companyName) {
	
		return this.jobAdvertisementService.jobAdvertisementActive(id, companyName);
	}


	
}
