package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.FileModel;

/**
 * @author 宀崇帀瀹�
 * FileRepository锛氫娇鐢↗DBCTemplate杩涜鏁版嵁搴撹繛鎺ワ紝杩涜鏂囦欢鐨勬煡璇€�佸鍔犮�佷慨鏀逛互鍙婂垹闄ゆ搷浣溿��
 */
@Repository
public class FileRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public boolean insertFile(FileModel fileModel) {
		String sql = "insert into file(FileName,Remark,Date) values(?,?,?)";
		int i = jdbcTemplate.update(sql,fileModel.getFilename(),fileModel.getRemark(),fileModel.getDate());
		if( i >= 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean updateFile(FileModel fileModel) {
		String sql = "update file set FileName=?,Remark=?,date=? where FileID=?";
		
		if(jdbcTemplate.update(sql,fileModel.getFilename(),fileModel.getRemark(),fileModel.getDate(),fileModel.getFileid())>=1) {
			return true;
		}else {
			return false;
		}
	}

	public List<FileModel> findAllFiles() {
		String sql = "select * from file";
		return this.getJdbcTemplate().query(sql, new FileMapper());
		
	}
	class FileMapper implements RowMapper<FileModel> {

		@Override
		public FileModel mapRow(ResultSet rs, int rows) throws SQLException {
			FileModel fileModel = new FileModel();
			fileModel.setFileid(rs.getInt(1));
			fileModel.setFilename(rs.getString(2));
			fileModel.setRemark(rs.getString(3));
			fileModel.setDate(rs.getString(4));
			return fileModel;
		}
	}
	public boolean deleteFile(int fileid) {
		String sql = "delete from file where Fileid=?";
		if (jdbcTemplate.update(sql, fileid) >= 1) {
			return true;
		} else {
			return false;
		}
	}
}
