package KodlamaIo.hrms.core.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import KodlamaIo.hrms.core.utilities.results.DataResult;


public interface ImageCheckService {
	
	DataResult<Map> loadFile(MultipartFile image);
}
