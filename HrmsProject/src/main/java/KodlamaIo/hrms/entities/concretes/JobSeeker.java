package KodlamaIo.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.*;

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
public class JobSeeker extends User {

	@Column(name="UserName")
	private String userName;
	
	@Column(name="UserSurname")
	private String userSurname;
	
	@Column(name="IdentificationNo")
	private String identificationNo;
	
	@Column(name="birth_year")
	private Long birthYear;
}
