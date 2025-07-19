package in.ganeshkalyan.dao;

import in.ganeshkalyan.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDAO {
    private JdbcTemplate jdbcTemplate;

    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employee (id, name, department) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getDepartment());
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    public void updateEmployee(Employee emp) {
        String sql = "UPDATE employee SET name = ?, department = ? WHERE id = ?";
        jdbcTemplate.update(sql, emp.getName(), emp.getDepartment(), emp.getId());
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
