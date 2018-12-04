package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Experiment;

@Repository
public class ExperimentRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Experiment> findAllExperiment() {
		String sql = "select * from experiment";
		return this.getJdbcTemplate().query(sql, new ExperimentMapper());
	}

	public List<Experiment> findExperimentByStuType(int type) {
		String sql = "select * from experiment where stutype=?";
		return this.getJdbcTemplate().query(sql, new ExperimentMapper(), type);
	}

	public Experiment findExperimentById(String id) {
		String sql = "select * from experiment where experimentid=?";
		return this.getJdbcTemplate().queryForObject(sql, new ExperimentMapper(), id);
	}

	public boolean addAnEX(Experiment ex) {
		String sql = "insert into experiment (experimentid, stutype,experimenttitle,deadline,teachername,state) values (?,?,?,?,?,?)";
		int i = jdbcTemplate.update(sql, ex.getExperimentid(), ex.getStutype(), ex.getExperimenttitle(),
				ex.getDeadline(), ex.getTeachername(), ex.getState());
		if (i >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateExperiment(Experiment e) {
		String sql = "update experiment set Experimenttitle=?,Stutype=?,"
				+ " Deadline=?,Teachername=?,State=? where Experimentid=?";
		if (jdbcTemplate.update(sql, e.getExperimenttitle(), e.getStutype(), e.getDeadline(), e.getTeachername(),
				e.getState(), e.getExperimentid()) >= 1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean deleteExperiment(String id) {
		String sql = "delete from experiment where experimentid=?";
		if (jdbcTemplate.update(sql, id) >= 1) {
			return true;
		} else {
			return false;
		}
	}

	class ExperimentMapper implements RowMapper<Experiment> {

		@Override
		public Experiment mapRow(ResultSet rs, int rows) throws SQLException {
			Experiment ex = new Experiment();
			ex.setExperimentid(rs.getString(1));
			ex.setStutype(rs.getInt(2));
			ex.setExperimenttitle(rs.getString(3));
			ex.setDeadline(rs.getString(4));
			ex.setTeachername(rs.getString(5));
			ex.setState(rs.getString(6));
			return ex;
		}
	}

	

}
