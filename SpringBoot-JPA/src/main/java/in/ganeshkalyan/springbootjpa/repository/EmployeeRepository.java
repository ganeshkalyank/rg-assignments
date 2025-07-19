package in.ganeshkalyan.springbootjpa.repository;

import in.ganeshkalyan.springbootjpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
