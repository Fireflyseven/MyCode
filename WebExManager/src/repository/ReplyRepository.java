package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Reply findReply(String id) {
		String sql = "select * from reply where replyid=?";
		try {
			return this.getJdbcTemplate().queryForObject(sql,
					new ReplyMapper(), id);
		} catch (Exception e) {
			return null;
		}

	}

	public List<Reply> getReplyList(String askid) {
		String sql = "select * from reply where askid=? ";
		return this.jdbcTemplate.query(sql, new ReplyMapper(),askid);
	}

	class ReplyMapper implements RowMapper<Reply> {

		@Override
		public Reply mapRow(ResultSet rs, int rows) throws SQLException {
			Reply reply = new Reply();
			reply.setReplyid(rs.getString(1));
			reply.setAskid(rs.getString(2));
			reply.setUsername(rs.getString(3));
			reply.setReplytext(rs.getString(4));

			return reply;
		}
	}
	public boolean submitReply(Reply p) {
		String sql = "insert into reply(replyid,askid,username,replytext) values(?,?,?,?)";
		if (jdbcTemplate.update(sql, p.getReplyid(),p.getAskid(), p.getUsername(),
				 p.getReplytext()) >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateReply(Reply reply) {
		String sql = "update reply set replytext=? wherere plyid=?";
		if (jdbcTemplate.update(sql, reply.getReplytext(),reply.getReplyid()) >= 1) {
			return true;
		} else {
			return false;
		}
	}


	public boolean deleteReply(String id) {
		String sql = "delete from reply where replyid=?";
		if (jdbcTemplate.update(sql, id) >= 1) {
			return true;
		} else {
			return false;
		}
	}



}
