package in.ganeshkalyan.customerspringbatch.repository;

import in.ganeshkalyan.customerspringbatch.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
}
