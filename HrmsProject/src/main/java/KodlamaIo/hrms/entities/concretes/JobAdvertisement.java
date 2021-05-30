package KodlamaIo.hrms.entities.concretes;


import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisement")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="job_position")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="job_condition")
	private boolean jobCondition;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@ManyToOne()
	@JoinColumn(name="company_name")
	private Employer employer;
	
	@Column(name="open_positions")
	private int openPositions;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@Column(name="job_inform")
	private String jobInform;
	

}
