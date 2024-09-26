package org.example.dao.customer.IMPL;

import org.example.config.FactoryConfiguration;
import org.example.dao.customer.ItemDAO;
import org.example.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public void save(Item item) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(String code) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("delete from item where code = ?1");
        query.setParameter(1,code);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public Item search(String code) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Item item = session.get(Item.class,code);
        transaction.commit();
        session.close();
        return item;
    }

    @Override
    public void update(Item item) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(item);
        transaction.commit();
        session.close();
    }
}

