import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.User;
import educar.models.userNotFound;


public class AsAnUnauthenticatedUser {

	@Before
	public void setUp() throws Exception {
		User u = new User("franco", "abcdefg", "admin");
		u.save();
	}

	@Test
	public void IWantToBeLoggedIfIProvideTheRightCredentials() {
		assertEquals(User.authenticate("franco", "abcdefg"), true);
	}
	
	@Test
	public void IShouldNotBeLoggedInIfIProvideBadCredentials(){
		assertEquals(User.authenticate("franc", "abcdefg"), false);
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
