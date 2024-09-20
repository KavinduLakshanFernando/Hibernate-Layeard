package org.example.dao.customer.IMPL;

import org.example.config.FactoryConfiguration;
import org.example.dao.customer.CustomerDAO;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public void save(Customer customer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("delete from customer where id = ?1");
        query.setParameter(1,id);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void update(Customer customer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public Customer search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);

        transaction.commit();
        session.close();
        return customer;
    }
}
