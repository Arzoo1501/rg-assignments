import java.sql.*;

public class EmployeeJDBC {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employees_db";
    private static final String USER = "root";
    private static final String PASS = ""; 

    // CREATE
    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setString(3, emp.getDepartment());
            stmt.executeUpdate();

            System.out.println("Employee added: " + emp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public void viewAllEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"));
                System.out.println(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateEmployee(int id, String newName, String newDept) {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newName);
            stmt.setString(2, newDept);
            stmt.setInt(3, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee updated with ID: " + id);
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted with ID: " + id);
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // MAIN for testing
    public static void main(String[] args) {
        EmployeeJDBC db = new EmployeeJDBC();

        // CREATE
        db.addEmployee(new Employee(1, "Arzoo", "IT"));
        db.addEmployee(new Employee(2, "Aryan", "HR"));

        // READ
        System.out.println("\nAll Employees:");
        db.viewAllEmployees();

        // UPDATE
        db.updateEmployee(1, "Arzoo Singh", "Tech");

        // DELETE
        db.deleteEmployee(2);

        // READ again
        System.out.println("\nAfter Update & Delete:");
        db.viewAllEmployees();
    }
}
