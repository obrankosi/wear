import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.User;
import educar.models.userNotFound;


public class UserTest {
	@Before
	public void setUp() throws Exception {
		User u = new User("franco", "abcdefg", "admin");
		u.save();
	}

	@Test
	public void IShouldNotBeAbleToSaveAnUserWithoutName(){
		User u = new User("franco", "asdfgh", "admin");
		assertEquals(u.save(), false);
	}

	@After
	public void tearDown(){
		try {
			User.getUserByUsername("franco").destroy();
		} catch (userNotFound e) {
			e.printStackTrace();
		}
	}
}
