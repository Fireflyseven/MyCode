package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Answer;
@Repository
public class AnswerRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Answer findAnswer(String usr, String id) {
		String sql = "select * from answer where answerid=?";
		try {
			return this.getJdbcTemplate().queryForObject(sql, new AnswerMapper(), id + usr);
		} catch (Exception e) {
			return null;
		}

	}
	public Answer findAnswerById(String answerid) {
		String sql = "select * from answer where answerid=?";
		try {
			return this.getJdbcTemplate().queryForObject(sql, new AnswerMapper(), answerid);
		} catch (Exception e) {
			return null;
		}
	}


	public boolean isHasAnswer(String answerid) {
		String sql = "select * from answer where answerid=?";
		try {
			if ((this.getJdbcTemplate().queryForObject(sql, new AnswerMapper(), answerid)) != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean saveAnswer(Answer a) {
		if (isHasAnswer(a.getAnswerid())) {
			String sql = "update answer set username=?,questionid=?,answertext=? where answerid=?";
			if (jdbcTemplate.update(sql, a.getUsername(), a.getQuestionid(), a.getAnswertext(), a.getAnswerid()) >= 1) {
				return true;
			} else {
				return false;
			}
		} else {
			String sql = "insert into answer values(?,?,?,?,?)";
			if (jdbcTemplate.update(sql, a.getAnswerid(), a.getUsername(), a.getQuestionid(), a.getAnswertext(),
					0) >= 1) {
				return true;
			} else {
				return false;
			}
		}
	}

	public List<Answer> getAnswerList(String exid) {
		String sql = "select * from answer where questionid like ?";
		return this.jdbcTemplate.query(sql, new AnswerMapper(), exid + "%");
	}

	public Double calcuExGrade(String username, String exid) {
		String sql = "select sum(score) from answer where username=? and questionid like ?";
		return jdbcTemplate.queryForObject(sql, Double.class, username,exid+"%");

	}
	
	public boolean saveGrade(Answer an) {
		String sql = "update answer set username=?,questionid=?,answertext=?, score=? where answerid=?";
		if (jdbcTemplate.update(sql, an.getUsername(), an.getQuestionid(), an.getAnswertext(), an.getScore(),an.getAnswerid()) >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	class AnswerMapper implements RowMapper<Answer> {

		@Override
		public Answer mapRow(ResultSet rs, int rows) throws SQLException {
			Answer a = new Answer();
			a.setAnswerid(rs.getString(1));
			a.setUsername(rs.getString(2));
			a.setQuestionid(rs.getString(3));
			a.setAnswertext(rs.getString(4));
			a.setScore(rs.getDouble(5));
			return a;
		}
	}

	

	

	
}
