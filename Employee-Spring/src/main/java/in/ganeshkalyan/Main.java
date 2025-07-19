package in.ganeshkalyan;

import in.ganeshkalyan.config.DataConfig;
import in.ganeshkalyan.dao.EmployeeDAO;
import in.ganeshkalyan.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DataConfig.class);
        JdbcTemplate template = context.getBean(JdbcTemplate.class);

        template.execute("CREATE TABLE employee (id INT PRIMARY KEY, name VARCHAR(50), department VARCHAR(50))");

        EmployeeDAO dao = new EmployeeDAO(template);

        dao.addEmployee(new Employee(1, "John", "Engineering"));
        dao.addEmployee(new Employee(2, "Jane", "HR"));

        List<Employee> employees = dao.getAllEmployees();
        employees.forEach(System.out::println);

        dao.updateEmployee(new Employee(2, "Jane Smith", "Marketing"));

        dao.deleteEmployee(1);

        dao.getAllEmployees().forEach(System.out::println);
    }
}