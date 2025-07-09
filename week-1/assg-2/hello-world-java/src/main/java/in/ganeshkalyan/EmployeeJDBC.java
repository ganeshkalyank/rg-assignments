package in.ganeshkalyan;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeJDBC {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "test@123";

    public EmployeeJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure driver is loaded
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee(String name, String department) {
        String query = "INSERT INTO employees (name, department) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, department);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(int id, String name, String department) {
        String query = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, department);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                employees.add(new Employee(id, name, department));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}

