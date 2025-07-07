public class DietTracker {
    // Private fields - not directly accessible outside
    private String userName;
    private int dailyCalories;
    private String goal;

    // Constructor
    public DietTracker(String userName, int dailyCalories, String goal) {
        this.userName = userName;
        this.dailyCalories = dailyCalories;
        this.goal = goal;
    }

    // Public getter and setter for userName
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (!userName.isEmpty()) {
            this.userName = userName;
        }
    }

    // Public getter and setter for dailyCalories
    public int getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(int dailyCalories) {
        if (dailyCalories > 0) {
            this.dailyCalories = dailyCalories;
        }
    }

    // Public getter and setter for goal
    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        if (goal.equalsIgnoreCase("lose") || goal.equalsIgnoreCase("maintain") 
        || goal.equalsIgnoreCase("gain")) {
            this.goal = goal;
        }
    }

    public void printStatus() {
        System.out.println("User: " + userName);
        System.out.println("Daily Calorie Limit: " + dailyCalories);
        System.out.println("Goal: " + goal);
    }

    public static void main(String[] args) {
        DietTracker tracker = new DietTracker("Arzoo", 1600, "lose");

        tracker.printStatus();

        // Try setting invalid data
        tracker.setDailyCalories(-500); // Won't update
        tracker.setGoal("bulk");        // Invalid goal

        System.out.println("\nAfter trying invalid updates:");
        tracker.printStatus();
    }
}

