package ie.gmit.sw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AmsMsgRowMapper implements RowMapper<AmsMessage>{

	@Override
	public AmsMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		
		user.setFirstname(rs.getString("users.firstname"));
		user.setLastname(rs.getString("users.lastname"));
		user.setEmail(rs.getString("users.email"));
		user.setUsername(rs.getString("users.username"));
		user.setEmpnum(rs.getInt("users.empnum"));
		user.setTel(rs.getInt("users.tel"));
		user.setAuthority(rs.getString("authority"));
		
		AmsMessage msg = new AmsMessage();
		msg.setMsgid(rs.getInt("systemmsg.msgid"));
		msg.setDate(rs.getDate("systemmsg.date"));
		msg.setMsg(rs.getString("systemmsg.msg"));
		msg.setUser(user);
		
		return msg;
	}
}
