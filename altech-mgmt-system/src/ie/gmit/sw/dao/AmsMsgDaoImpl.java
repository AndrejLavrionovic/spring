package ie.gmit.sw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("amsMsgDaoImpl")
public class AmsMsgDaoImpl implements AmsMsgDao {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GET ALL MESSAGES
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@Override
	public List<AmsMessage> getAllMsgs() {
		
		String sql = "select * from systemmsg, users where systemmsg.username = users.username order by systemmsg.date desc, systemmsg.msgid desc limit 10;";
		return jdbc.query(sql, new RowMapper<AmsMessage>(){
			public AmsMessage mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				User user = new User();
				user.setFirstname(rs.getString("users.firstname"));
				user.setLastname(rs.getString("users.lastname"));
				user.setEmail(rs.getString("users.email"));
				user.setUsername(rs.getString("users.username"));
				user.setEmpnum(rs.getInt("users.empnum"));
				user.setTel(rs.getInt("users.tel"));
				
				AmsMessage msg = new AmsMessage();
				msg.setMsgid(rs.getInt("systemmsg.msgid"));
				msg.setDate(rs.getDate("systemmsg.date"));
				msg.setMsg(rs.getString("systemmsg.msg"));
				msg.setUser(user);
				
				return msg;
			}
		});
	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CREATE MESSAGE
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@Override
	public boolean createMsg(AmsMessage msg){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(msg);
		
		String sql = "insert into systemmsg (date, msg, username) values (DATE(NOW()), :msg, :username);";
		
		return jdbc.update(sql, params) == 1;
	}
}
