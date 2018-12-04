package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Ask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AskRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Ask> findAllAsk() {
		String sql = "select * from ask";
		return this.getJdbcTemplate().query(sql, new AskMapper());
	}
	public List<Ask> findAskByUsername(String username) {
		String sql = "select * from Ask where username=?";
		return this.getJdbcTemplate().query(sql, new AskMapper(),username);
	}
	public Ask findAskById(String id) {
		String sql = "select * from ask where askid=?";
		try {
			return this.getJdbcTemplate().queryForObject(sql, new AskMapper(), id);
		} catch (Exception e) {
			return null;
		}

	}

	class AskMapper implements RowMapper<Ask> {

		@Override
		public Ask mapRow(ResultSet rs, int rows) throws SQLException {
			Ask ask = new Ask();
			ask.setAskid(rs.getString(1));
			ask.setUsername(rs.getString(2));
			ask.setAsktitle(rs.getString(3));
			ask.setAsktext(rs.getString(4));
			
			return ask;
		}
	}
	public boolean addAsk(Ask ask) {
		String sql = "insert into Ask(username,askid,asktitle,asktext) values(?,?,?,?)";
		if (jdbcTemplate.update(sql, ask.getUsername(),ask.getAskid(),ask.getAsktitle(), ask.getAsktext()) >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteAsk(String id) {
		String sql = "delete from Ask where askid=?";
		if (jdbcTemplate.update(sql, id) >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
			
					
}
