package KodlamaIo.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers_cv")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCv {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="id")
	  private int id;
	
	  @ManyToOne()
	  @JoinColumn(name="job_seeker_id")
	  private JobSeeker jobSeeker;
	
	  @Column(name="explanation")
	  private String explanation;
	  
	  @Column(name="github_adrress")
	  private String githubAdrress;
	  
	  @Column(name="linkedin_adrress")
	  private String linkedinAdrress;
	  
	  
}