package in.ganeshkalyan;

import java.util.ArrayList;

public class EmployeeJDBCDemo {
    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();

        employeeJDBC.addEmployee("John Doe", "Engineering");
        employeeJDBC.addEmployee("Jane Smith", "Marketing");
        employeeJDBC.addEmployee("Alice Johnson", "Finance");

        System.out.println("All Employees:");
        printEmployees(employeeJDBC.getAllEmployees());

        employeeJDBC.deleteEmployee(1);
        System.out.println("\nAfter Deleting Employee with ID 1:");
        printEmployees(employeeJDBC.getAllEmployees());

        employeeJDBC.updateEmployee(2, "Jane Doe", "Sales");
        System.out.println("\nAfter Updating Employee with ID 2:");
        printEmployees(employeeJDBC.getAllEmployees());

        employeeJDBC.addEmployee("Bob Brown", "HR");
        System.out.println("\nAfter Adding New Employee:");
        printEmployees(employeeJDBC.getAllEmployees());
    }

    private static void printEmployees(ArrayList<Employee> employees) {
        for (Employee emp : employees) {
            System.out.println(emp.getId() + " - " + emp.getName() + " - " + emp.getDepartment());
        }
    }
}
