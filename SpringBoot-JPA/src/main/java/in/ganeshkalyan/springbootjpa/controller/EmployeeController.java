package in.ganeshkalyan.springbootjpa.controller;

import in.ganeshkalyan.springbootjpa.model.Employee;
import in.ganeshkalyan.springbootjpa.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        return repository.save(emp);
    }

    @GetMapping
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee emp) {
        Employee existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(emp.getName());
            existing.setDepartment(emp.getDepartment());
            return repository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        repository.deleteById(id);
        return "Deleted";
    }
}
