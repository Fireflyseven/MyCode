package web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import service.FileService;
import util.DateTools;
import model.FileModel;

/**
 * @author 岳玉宸
 * FileController：显示文件||上传文件||下载文件||删除文件
 */

@Controller
public class FileController {

	@Autowired
	FileService fileService;

//	 @RequestMapping(value="/{formName}")
//	 public String loginForm(@PathVariable String formName) {
//	 return formName;
//	 }

	//教师：显示文件
	@RequestMapping(value = "/t_file")
	public String loginForm(Model model) {
		List<FileModel> list = fileService.filndAllFiles();
		model.addAttribute("files",list);
		return "teacher/t_file";
	}

	//教师：上传文件
	@RequestMapping(value = "/t_upFile")
	public String upFile(Model model) {
		return "teacher/t_upFile";
	}

	@RequestMapping(value = "/register")
	public String register(HttpServletRequest request, @RequestParam("file") MultipartFile file, Model model)
			throws Exception {
		FileModel fileModel = new FileModel();	
		if (!file.isEmpty()) {
			String Fname = request.getParameter("fileName");
			fileModel.setFilename(Fname);
			String remark = request.getParameter("remark");
			fileModel.setRemark(remark);
			Fname =Fname+remark;
			String time = DateTools.getDate();
			fileModel.setDate(time);
			
			String path = request.getServletContext().getRealPath("/files/");
//			String longname = file.getOriginalFilename();
//			String subfix= longname.substring(longname.length()-4, longname.length());
//			Fname+=subfix;
			File filepath = new File(path, Fname);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			file.transferTo(new File(path + File.separator +  Fname));
						
			if (fileService.insertFile(fileModel)) {
				model.addAttribute("info", "插入成功！");
			} else {
				model.addAttribute("info", "插入失败");
			}
			return "teacher/t_upFile_success";
		} else {
			return "error";
		}

	}
	
	//教师：删除文件
	@RequestMapping(value = "deletefile/{fileid}")
	public String deletefile(@PathVariable String fileid) {
		int id = Integer.parseInt(fileid);
		if(fileService.deletefile(id)){
				
			}
			else {
				
			}
			return "redirect:/t_file";
		}

	//文件下载
	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,Model model) throws Exception {
		String filename = request.getParameter("filename");
		String remark = request.getParameter("remark");
		filename = filename+remark;
		String path = request.getServletContext().getRealPath("/files/");
		File file = new File(path + File.separator + filename);
		HttpHeaders headers = new HttpHeaders();

		String downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");

		headers.setContentDispositionFormData("attachment", downloadFielName);

		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
	
	//学生：查看文件
	@RequestMapping(value = "/s_file")
	public String loginFormStudent(Model model) {
		List<FileModel> list = fileService.filndAllFiles();
		model.addAttribute("files",list);
		return "student/s_file";
	}
}
