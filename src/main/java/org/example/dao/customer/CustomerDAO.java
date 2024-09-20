package org.example.dao.customer;
import org.example.config.FactoryConfiguration;
import org.example.dao.SuperDAO;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface CustomerDAO extends SuperDAO {

    void save(Customer customer);

    void delete(String id);

    void update(Customer customer);

    Customer search(String id);
}
