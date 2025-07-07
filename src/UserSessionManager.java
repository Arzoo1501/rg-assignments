public class UserSessionManager {

    // private static variable to hold the single instance
    private static UserSessionManager instance;

    private String currentUser;

    // private constructor prevents instantiation from other classes
    private UserSessionManager() {
        System.out.println("UserSessionManager initialized");
    }

    // public static method to get the singleton instance
    public static UserSessionManager getInstance() {
        if (instance == null) {
            instance = new UserSessionManager();
        }
        return instance;
    }

    public void login(String username) {
        currentUser = username;
        System.out.println("User " + currentUser + " has logged in.");
    }

    public void logout() {
        System.out.println("User " + currentUser + " has logged out.");
        currentUser = null;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public static void main(String[] args) {
        // Get the singleton instance
        UserSessionManager session1 = UserSessionManager.getInstance();
        session1.login("Arzoo");

        // Try getting another instance
        UserSessionManager session2 = UserSessionManager.getInstance();

        System.out.println("Current User from session2: " + session2.getCurrentUser());

        // Both session1 and session2 refer to the same object
        System.out.println("Are both sessions same? " + (session1 == session2));

        session2.logout();
    }
}    