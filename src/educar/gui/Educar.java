package educar.gui;

import educar.models.Session;

public class Educar {

    private static Session session;
    private static LoginView view;

    /**
     * @param args
     */
    public static void main(String[] args) {
    	view = new LoginView();
    	session = new Session();
    }

}
