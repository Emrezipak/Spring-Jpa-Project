package KodlamaIo.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.SchoolService;
import KodlamaIo.hrms.core.utilities.results.DataResult;
import KodlamaIo.hrms.core.utilities.results.Result;
import KodlamaIo.hrms.entities.concretes.JobSeekerCv;
import KodlamaIo.hrms.entities.concretes.School;

@RestController
@RequestMapping("api/school")
public class SchoolController {

	private SchoolService schoolService;
	
	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/addSchool")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@GetMapping("/getByStartsSchoolYear")
	public DataResult<List<School>> getByStartsSchoolYear(@RequestParam int id) {

		return this.schoolService.getByFinishSchoolYear(id);
	}

}
