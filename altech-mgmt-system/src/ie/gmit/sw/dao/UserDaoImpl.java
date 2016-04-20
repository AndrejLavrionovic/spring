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
				user.setRegDate(rs.getDate("regDate"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setNationality(rs.getString("nationality"));
				user.setStatusid(rs.getInt("statusid"));
				user.setPositionid(rs.getInt("positionid"));
				
				return user;
			}
		});
	}
	
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GET USER BY ID
	//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public User getUserByEmpnum(int empnum) {
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("empnum", empnum);
		
		String sql = "SELECT * FROM users WHERE empnum=:empnum";
		return jdbc.queryForObject(sql, param, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user = new User();

				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmpnum(rs.getInt("empnum"));
				user.setRegDate(rs.getDate("regDate"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setNationality(rs.getString("nationality"));
				user.setStatusid(rs.getInt("statusid"));
				user.setPositionid(rs.getInt("positionid"));
				
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
		
//		String sql = "INSERT INTO users (firstname, lastname)" +
//				" VALUES (:firstname, :lastname)";
		
		String sql = "INSERT INTO users (firstname, lastname, empnum," +
		" tel, regDate, email, nationality, statusid, positionid)" +
		" VALUES (:firstname, :lastname, :empnum, :tel, DATE(NOW()), :email," +
		" :nationality, :statusid, :positionid)";
		return jdbc.update(sql, params) == 1;
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
}
