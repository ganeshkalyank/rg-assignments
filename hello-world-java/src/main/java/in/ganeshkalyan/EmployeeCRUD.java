package in.ganeshkalyan;

import java.util.ArrayList;

public class EmployeeCRUD {
    private final ArrayList<Employee> employees;
    private Integer nextId;

    public EmployeeCRUD() {
        employees = new ArrayList<>();
        nextId = 1;
    }

    public void addEmployee(String name, String department) {
        Employee employee = new Employee(nextId++, name, department);
        employees.add(employee);
    }

    public void updateEmployee(int id, String name, String department) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(name);
                emp.setDepartment(department);
                break;
            }
        }
    }

    public void deleteEmployee(int id) {
        employees.removeIf(emp -> emp.getId() == id);
    }

    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }
}
