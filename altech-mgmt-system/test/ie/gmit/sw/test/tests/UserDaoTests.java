package ie.gmit.sw.test.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:ie/gmit/sw/config/dao-context.xml",
		"classpath:ie/gmit/sw/config/security-context.xml",
		"classpath:ie/gmit/sw/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

	@Test
	public void createUserTest(){
		assertEquals("Dummy Test", 1, 1);
	}
}
