package KodlamaIo.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="experiences")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@Column(name="workplace_name")
	private String workplaceName;
	
	@NotNull
	@Column(name="job_position")
	private String jobPosition;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="starts_job_year")
	private Date startsYear;
	
	@Temporal(TemporalType.DATE)
	@Column(name="finish_job_year")
	private Date finishYear;
	
	@Column(name="job_condition")
	private boolean jobCondition;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
}
