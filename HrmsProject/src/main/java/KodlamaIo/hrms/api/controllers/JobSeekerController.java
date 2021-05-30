package KodlamaIo.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.JobSeekerService;
import KodlamaIo.hrms.core.utilities.results.*;
import KodlamaIo.hrms.entities.concretes.JobSeeker;


@RestController
@RequestMapping("/jobSeeker")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;
    @Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
    
    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll(){
    	return this.jobSeekerService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobSeeker jobSeeker) {
    	return this.jobSeekerService.save(jobSeeker);
    }
}
