package KodlamaIo.hrms.entities.dtos;
import java.util.List;

import KodlamaIo.hrms.entities.concretes.Experience;
import KodlamaIo.hrms.entities.concretes.ForeignLanguage;
import KodlamaIo.hrms.entities.concretes.Image;
import KodlamaIo.hrms.entities.concretes.JobSeeker;
import KodlamaIo.hrms.entities.concretes.JobSeekerCv;
import KodlamaIo.hrms.entities.concretes.School;
import KodlamaIo.hrms.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
	 //private JobSeeker jobSeeker;
     private List<JobSeekerCv> jobSeekerCv;
     private List<Experience> experiences;
     private List<School> schools;
     private List<ForeignLanguage> foreignLangauge;
     private Image images;
     private List<Technology> technologies;
     
}
