package in.ganeshkalyan;

public class EmployeeCRUDDemo {
    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();

        employeeCRUD.addEmployee("John Doe", "Engineering");
        employeeCRUD.addEmployee("Jane Smith", "Marketing");
        employeeCRUD.addEmployee("Alice Johnson", "Finance");

        System.out.println("All Employees:");
        for (Employee employee : employeeCRUD.getAllEmployees()) {
            System.out.println(employee);
        }

        employeeCRUD.deleteEmployee(1);
        System.out.println("\nAfter Deleting Employee with ID 1:");
        for (Employee employee : employeeCRUD.getAllEmployees()) {
            System.out.println(employee);
        }

        employeeCRUD.updateEmployee(2, "Jane Doe", "Sales");
        System.out.println("\nAfter Updating Employee with ID 2:");
        for (Employee employee : employeeCRUD.getAllEmployees()) {
            System.out.println(employee);
        }

        employeeCRUD.addEmployee("Bob Brown", "HR");
        System.out.println("\nAfter Adding New Employee:");
        for (Employee employee : employeeCRUD.getAllEmployees()) {
            System.out.println(employee);
        }
    }
}
