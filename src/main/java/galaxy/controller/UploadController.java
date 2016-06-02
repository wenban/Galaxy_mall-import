package galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import galaxy.model.KindEDResult;
import galaxy.service.UploadService;


@Controller
public class UploadController {

	@Autowired
	private UploadService uploadService;
	
	
	@RequestMapping(value = "/KindED", method = RequestMethod.POST)
	@ResponseBody
	// @RequestParam MultipartFile[] imgFile
	public KindEDResult uploadFile(MultipartFile imgFile) {
		try {
			return new KindEDResult(0, uploadService.uploadFile(imgFile));
		} catch (Exception e) {
			e.printStackTrace();
			return new KindEDResult(1, "上传失败, 原因看控制台");
		}
	}
}
