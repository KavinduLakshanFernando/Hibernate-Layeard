package org.example.dao.customer;

import org.example.dao.SuperDAO;
import org.example.entity.Item;

public interface ItemDAO extends SuperDAO {

    void save(Item item);

    void delete(String code);

    Item search(String code);

    void update(Item item);
}
