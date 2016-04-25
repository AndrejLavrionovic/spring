package ie.gmit.sw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDAO {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GET ALL USERS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@Override
	public List<User> getAllUsers() {
		
		String sql = "SELECT * FROM users inner join authorities on users.userid = authorities.userid;";
		return jdbc.query(sql, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user = new User();
				
				user.setUserid(rs.getInt("users.userid"));
				user.setFirstname(rs.getString("users.firstname"));
				user.setLastname(rs.getString("users.lastname"));
				user.setEmpnum(rs.getInt("users.empnum"));
				user.setTel(rs.getInt("users.tel"));
				user.setEmail(rs.getString("users.email"));
				user.setUsername(rs.getString("users.username"));
				user.setPassword(rs.getString("users.password"));
				user.setEnabled(rs.getBoolean("users.enabled"));
				user.setAuthority(rs.getString("authorities.authority"));
				
				return user;
			}
		});
	}
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GET USER BY ID
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//	public User getUserByEmpnum(int empnum) {
//		
//		MapSqlParameterSource param = new MapSqlParameterSource();
//		param.addValue("empnum", empnum);
//		
//		String sql = "SELECT * FROM users WHERE empnum=:empnum";
//		return jdbc.queryForObject(sql, param, new RowMapper<User>(){
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
//				User user = new User();
//
//				user.setFirstname(rs.getString("firstname"));
//				user.setLastname(rs.getString("lastname"));
//				user.setEmpnum(rs.getInt("empnum"));
//				user.setRegDate(rs.getDate("regDate"));
//				user.setTel(rs.getString("tel"));
//				user.setEmail(rs.getString("email"));
//				user.setNationality(rs.getString("nationality"));
//				user.setStatusid(rs.getInt("statusid"));
//				user.setPositionid(rs.getInt("positionid"));
//				
//				return user;
//			}
//		});
//	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// DELETE USER BY ID
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//	public int deleteUser(int userid){
//		
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("userid", userid);
//		
//		String sql = "DELETE FROM users WHERE userid=:userid";
//		return jdbc.update(sql, params);
//	}
	
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CREATE USER
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@Transactional
	public boolean createUser(User user){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		String users = "insert into users (userid, username, password, email, empnum, firstname, lastname, tel)" +
		" VALUES (:userid, :username, :password, :email, :empnum, :firstname, :lastname, :tel)";
		
		String authorities = "insert into authorities (username, authority, userid) values(:username, :authority, :userid)";

		jdbc.update(users, params);
		return jdbc.update(authorities, params) == 1;
	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CREATE BUNCH OF USERS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public int[] createUsers(List<User> users){

		String sql = "INSERT INTO users (firstname, lastname, empnum, regDate," +
		" tel, email, nationality, statusid, positionid)" +
		" VALUES (:firstname, :lastname, :empnum, NOW(), :tel, :email," +
		" :nationality, :statusid, :positionid)";
		
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(users.toArray());
		
		return jdbc.batchUpdate(sql, batchArgs);
	}
	
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// UPDATE USER
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public int updateUser(User user){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		String sql = "UPDATE users SET firstname=:firstname, lastname=:lastname," +
				" empnum=:empnum, regDate=:regDate, tel=:tel," +
				" email=:email, nationality=:nationality, statusid=:statusid," +
				" positionid=:positionid" +
				" WHERE userid=:userid";
				return jdbc.update(sql, params);
	}


	@Override
	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username=:username;",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}
}
