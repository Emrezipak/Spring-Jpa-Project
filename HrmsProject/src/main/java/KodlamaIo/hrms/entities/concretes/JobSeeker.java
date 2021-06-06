package KodlamaIo.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "school", "jobSeekerCv", "experience", "foreignLanguage","technology","image" })
public class JobSeeker extends User {

	@Column(name="UserName")
	private String userName;
	
	@Column(name="UserSurname")
	private String userSurname;
	
	@Column(name="IdentificationNo")
	private String identificationNo;
	
	@Column(name="birth_year")
	private Long birthYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Experience> experiences;
		
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<ForeignLanguage> foreignLanguages;
			
			
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<School> schools;
			
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Technology> experience;
			
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerCv> jobSeekeCv;
	
	@OneToOne(mappedBy = "jobSeeker")
	private Image image;
	

	
}
