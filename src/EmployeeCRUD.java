import java.util.ArrayList;

public class EmployeeCRUD {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    // CREATE
    public void addEmployee(Employee emp) {
        employeeList.add(emp);
        System.out.println("Employee added: " + emp);
    }

    // READ
    public void viewAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }

    // UPDATE
    public void updateEmployee(int id, String newName, String newDept) {
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                e.setName(newName);
                e.setDepartment(newDept);
                System.out.println("Employee updated: " + e);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // DELETE
    public void deleteEmployee(int id) {
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                employeeList.remove(e);
                System.out.println("Employee removed: " + e);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // MAIN METHOD TO TEST
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        // CREATE
        crud.addEmployee(new Employee(101, "Arzoo", "IT"));
        crud.addEmployee(new Employee(102, "Aryan", "HR"));

        // READ
        System.out.println("\nAll Employees:");
        crud.viewAllEmployees();

        // UPDATE
        System.out.println("\nUpdating Employee ID 101:");
        crud.updateEmployee(101, "Arzoo Singh", "Tech");

        // DELETE
        System.out.println("\nDeleting Employee ID 102:");
        crud.deleteEmployee(102);

        // READ AGAIN
        System.out.println("\nAll Employees After Update & Delete:");
        crud.viewAllEmployees();
    }
}
