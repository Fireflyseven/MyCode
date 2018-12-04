package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.FileModel;
import repository.FileRepository;

/**
 * @author 岳玉宸
 * FileService：文件查询||文件增加||文件修改||文件删除
 */
@Service
public class FileService {

	@Autowired
	FileRepository fileRepository;
	
	public boolean updateFile(FileModel fileModel) {
		return this.fileRepository.updateFile(fileModel);
	}
	
	public boolean insertFile(FileModel fileModel) {
		return this.fileRepository.insertFile(fileModel);
	}

	public List<FileModel> filndAllFiles() {
		return this.fileRepository.findAllFiles();
	}

	
	public boolean deletefile(int fileid) {
		return this.fileRepository.deleteFile(fileid);
	}
	
}
