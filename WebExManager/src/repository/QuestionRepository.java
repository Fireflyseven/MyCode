package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Question;

@Repository
public class QuestionRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Question> findQuestionsByExId(String id) {
		String sql = "select * from question where ExperimentID=?";
		return this.getJdbcTemplate().query(sql, new QuestionMapper(), id);
	}

	public Question findQuestionsById(String id) {
		String sql = "select * from question where QuestionID=?";
		try {
			return this.getJdbcTemplate().queryForObject(sql, new QuestionMapper(), id);
		} catch (Exception e) {
			return null;
		}

	}

	public boolean addAQuestion(Question q) {
		String sql = "insert into  question values(?,?,?,?,?,?)";
		if (jdbcTemplate.update(sql, q.getQuestionid(), q.getExperimentid(), q.getQuestiontitle(), q.getQuestiontext(),
				q.getAnswer(), q.getScore()) >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateQuestion(Question qu) {
		String sql = "update question set questiontitle=?,questiontext=?,answer=?,score=? where questionid=?";
		if (jdbcTemplate.update(sql, qu.getQuestiontitle(), qu.getQuestiontext(), qu.getAnswer(), qu.getScore(),
				qu.getQuestionid()) >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteQuestion(String id) {
		String sql = "delete from question where questionid=?";
		if (jdbcTemplate.update(sql, id) >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public int countQuestion(String exid) {
		String sql = "select count(*) from question where experimentID=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, exid);
	}

	class QuestionMapper implements RowMapper<Question> {

		@Override
		public Question mapRow(ResultSet rs, int rows) throws SQLException {
			Question q = new Question();
			q.setQuestionid(rs.getString(1));
			q.setExperimentid(rs.getString(2));
			q.setQuestiontitle(rs.getString(3));
			q.setQuestiontext(rs.getString(4));
			q.setAnswer(rs.getString(5));
			q.setScore(rs.getDouble(6));
			return q;
		}
	}

}
