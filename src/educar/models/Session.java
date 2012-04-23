package educar.models;

public class Session {
	private static User currentUser = null;
	private static Session session;
	
	public synchronized static Session getSession(){
		if (session == null)
			session = new Session();
		return session;
	}

	public Session() {
		Session.setCurrentUser(null);
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		Session.currentUser = currentUser;
	}
}
