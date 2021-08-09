package main.java.com.nomre.restservice.Repository;

import main.java.com.nomre.restservice.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
