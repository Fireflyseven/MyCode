package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User findAUser(String username) {
		String sql = "select * from user where username like ?";
		User user = jdbcTemplate.queryForObject(sql, new UserMapper(), username);
		return user;
	}
	
	public List<User> findUsersByType(int stutype) {
		String sql = "select * from user where usertypeid=?";
		return this.getJdbcTemplate().query(sql, new UserMapper(),stutype);
		
	}

	class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rows) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setUsertypeid(rs.getInt(2));
			user.setPassword(rs.getString(3));
			user.setName(rs.getString(4));
			user.setSex(rs.getString(5));
			return user;
		}
	}

	
}
