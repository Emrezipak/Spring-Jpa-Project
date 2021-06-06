package KodlamaIo.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.JobSeekerCvService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.JobSeekerCv;
import KodlamaIo.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/jobSeekerCv")
public class JobSeekerCvController {
	
	private JobSeekerCvService jobSeekerCvService;
	
	@Autowired
	public JobSeekerCvController(JobSeekerCvService jobSeekerCvService) {
		super();
		this.jobSeekerCvService = jobSeekerCvService;
	}	
	
	@GetMapping("/getAllCv")
	public DataResult<List<JobSeekerCv>> getAllCv(){
		return this.jobSeekerCvService.getAll();
	}
	
	@PostMapping("/addCv")
	public Result add(@RequestBody JobSeekerCv cv) {
		return this.jobSeekerCvService.add(cv);
	}
	
	@GetMapping("/getByIdAndIdentificationNo")
	public DataResult<List<JobSeekerCv>> getByIdCv(@RequestParam int id,@RequestParam String identificationNo) {
		return this.jobSeekerCvService.getByIdCv(id, identificationNo);
	}
	
	@GetMapping("/getByIdCv")
	public DataResult<CvDto> getByIdCv(@RequestParam int id) {
		return this.jobSeekerCvService.getByIdCv(id);
	}


	
	
}
