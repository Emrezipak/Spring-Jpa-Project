package KodlamaIo.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="Employer")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User {

	@Column(name="CompanyName")
	private String companyName;
	
	@Column(name="Website")
	private String website;
	
	@Column(name="PhoneNumber")
	private String phoneNumber;
	
}
