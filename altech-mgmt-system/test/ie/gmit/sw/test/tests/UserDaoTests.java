package ie.gmit.sw.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ie.gmit.sw.dao.User;
import ie.gmit.sw.dao.UserDAO;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:ie/gmit/sw/config/dao-context.xml",
		"classpath:ie/gmit/sw/config/security-context.xml",
		"classpath:ie/gmit/sw/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	
	@Autowired
	private UserDAO userdao;
	
	@Autowired
	private DataSource datasource;

	@Before
	public void init(){
		JdbcTemplate jdbc = new JdbcTemplate(datasource);

		jdbc.execute("delete from systemmsg");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void createUserTest(){
		
		User user = new User("user", "user", true, "user@user.com", 100001, "Andrej", "Andrej", 861234567, "admin");
		assertTrue("Creation user should return true", userdao.createUser(user));

		List<User> users = userdao.getAllUsers();
		assertEquals("Number of users should be 1", 1, users.size());
		
		assertTrue("User should exist", userdao.exists(user.getUsername()));
		
		assertEquals("Created user should be adentical to retrieved user", user, users.get(0));
	}
}
