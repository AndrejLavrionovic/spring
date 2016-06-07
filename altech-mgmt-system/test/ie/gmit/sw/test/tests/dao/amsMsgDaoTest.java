package ie.gmit.sw.test.tests.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
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

import ie.gmit.sw.dao.AmsMessage;
import ie.gmit.sw.dao.AmsMsgDao;
import ie.gmit.sw.dao.User;
import ie.gmit.sw.dao.UserDAO;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:ie/gmit/sw/config/dao-context.xml",
		"classpath:ie/gmit/sw/config/security-context.xml",
		"classpath:ie/gmit/sw/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class amsMsgDaoTest {

	@Autowired
	private AmsMsgDao msgdao;
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
	public void createMsgTest(){
		
		User user = new User("user", "user", true, "user@altech.ie", 100001, "User", "User", 1234567890, "hr");
		userdao.createUser(user);
		
		// Create message
		AmsMessage msg = new AmsMessage("message", user);
		assertTrue("Creation of message must return true", msgdao.createMsg(msg));
		
		List<AmsMessage> msgs = msgdao.getAllMsgs();
		assertEquals("Number of messages should be 1", 1, msgs.size());
	}
}
