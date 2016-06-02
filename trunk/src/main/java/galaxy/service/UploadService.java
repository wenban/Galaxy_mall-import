package galaxy.service;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	@Value("${upload.file}")
	private String uploadDir;

	@Value("${upload.domain}")
	private String imagesDomain;

	public String uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String newName = new Random().nextInt() + suffix;
		
		file.transferTo(new File(uploadDir+newName));

		return imagesDomain + newName;

	}
}
