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
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

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
		
		String sql = "SELECT * FROM users;";
		return jdbc.query(sql, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user = new User();
				
				user.setUserid(rs.getInt("userid"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmpnum(rs.getInt("empnum"));
				user.setRegistered(rs.getDate("registered"));
				user.setDob(rs.getDate("dob"));
				user.setTel(rs.getInt("tel"));
				user.setEmail(rs.getString("email"));
				user.setNationality(rs.getString("nationality"));
				user.setStatus(rs.getInt("statusid"));
				user.setSiteid(rs.getInt("siteid"));
				user.setAddressid(rs.getInt("addressid"));
				
				return user;
				
			}
		});
	}
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GET USER BY ID
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public User getUserById(int userid) {
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userid", userid);
		
		String sql = "SELECT * FROM users WHERE userid=:userid";
		return jdbc.queryForObject(sql, param, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user = new User();
				
				user.setUserid(rs.getInt("userid"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmpnum(rs.getInt("empnum"));
				user.setRegistered(rs.getDate("registered"));
				user.setDob(rs.getDate("dob"));
				user.setTel(rs.getInt("tel"));
				user.setEmail(rs.getString("email"));
				user.setNationality(rs.getString("nationality"));
				user.setStatus(rs.getInt("statusid"));
				user.setSiteid(rs.getInt("siteid"));
				user.setAddressid(rs.getInt("addressid"));
				
				return user;
				
			}
		});
	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// DELETE USER BY ID
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public int deleteUser(int userid){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userid", userid);
		
		String sql = "DELETE FROM users WHERE userid=:userid";
		return jdbc.update(sql, params);
	}
	
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CREATE USER
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public boolean createUser(User user){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		String sql = "INSERT INTO users (firstname, lastname, empnum, registered," +
		" dob, tel, email, nationality, status, siteid, addressid)" +
		" VALUES (:firstname, :lastname, :empnum, :registered, :dob, :tel, :email," +
		" :nationality, :status, :siteid, :addressid)";
		return jdbc.update(sql, params) == 1;
	}
	

	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CREATE BUNCH OF USERS
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public int[] createUsers(List<User> users){
		
		String sql = "INSERT INTO users (firstname, lastname, empnum, registered," +
		" dob, tel, email, nationality, status, siteid, addressid)" +
		" VALUES (:firstname, :lastname, :empnum, :registered, :dob, :tel, :email," +
		" :nationality, :status, :siteid, :addressid)";
		
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(users.toArray());
		
		return jdbc.batchUpdate(sql, batchArgs);
	}
	
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// UPDATE USER
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public int updateUser(User user){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		String sql = "UPDATE users SET firstname=:firstname, lastname=:lastname," +
				" empnum=:empnum, registered=:registered, dob=:dob, tel=:tel," +
				" email=:email, nationality=:nationality, status=:status," +
				" siteid=:siteid, addressid=:addressid" +
				" WHERE userid=:userid";
				return jdbc.update(sql, params);
	}
}
