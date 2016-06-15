package ie.gmit.sw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
//	@Override
//	public List<User> getAllUsers() {
//		
//		String sql = "SELECT * FROM users;";
//		return jdbc.query(sql, new RowMapper<User>(){
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
//				User user = new User();
//				
//				user.setFirstname(rs.getString("users.firstname"));
//				user.setLastname(rs.getString("users.lastname"));
//				user.setEmpnum(rs.getInt("users.empnum"));
//				user.setTel(rs.getInt("users.tel"));
//				user.setEmail(rs.getString("users.email"));
//				user.setUsername(rs.getString("users.username"));
//				user.setPassword(rs.getString("users.password"));
//				user.setEnabled(rs.getBoolean("users.enabled"));
//				user.setAuthority(rs.getString("users.authority"));
//				
//				return user;
//			}
//		});
//	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GET ALL USERS VERSION 2
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@Override
	public List<User> getAllUsers() {
		
		String sql = "SELECT * FROM users;";
		return jdbc.query(sql, BeanPropertyRowMapper.newInstance(User.class));
	}
	
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GET USER BY EMPLOYEE NUMBER
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@Override
	public User getUserByEmpnum(int empnum) {
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("empnum", empnum);
		
		String sql = "SELECT * FROM users WHERE empnum=:empnum";
		return jdbc.queryForObject(sql, param, new UserRowMapper());
	}
	
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GET USER BY USERNAME
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@Override
	public User getUserByUsername(String username) {
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("username", username);
		
		String sql = "SELECT * FROM users WHERE username=:username";
		return jdbc.queryForObject(sql, param, new UserRowMapper());
	}
	

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
		
		String users = "insert into users (username, password, email, empnum, firstname, lastname, tel, authority)" +
		" VALUES (:username, :password, :email, :empnum, :firstname, :lastname, :tel, :authority)";

		return jdbc.update(users, params) == 1;
	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CREATE BUNCH OF USERS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public int[] createUsers(List<User> users){

		String sql = "insert into users (username, password, email, empnum, firstname, lastname, tel)" +
				" VALUES (:username, :password, :email, :empnum, :firstname, :lastname, :tel)";
		
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(users.toArray());
		
		return jdbc.batchUpdate(sql, batchArgs);
	}
	
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// UPDATE USER
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@Override
	public int updateUser(User user){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		String sql = "UPDATE users SET firstname=:firstname, lastname=:lastname," +
				" tel=:tel, email=:email WHERE username=:username";
				return jdbc.update(sql, params);
	}


	@Override
	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username=:username;",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}
	
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// DELETE USER
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	@Override
	public boolean deleteUser(String username) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);
		
		String sql = "DELETE FROM users WHERE username=:username";
		return jdbc.update(sql, params) == 1;
	}
}
