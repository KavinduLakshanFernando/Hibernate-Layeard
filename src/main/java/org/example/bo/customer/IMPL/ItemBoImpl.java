package org.example.bo.customer.IMPL;

import org.example.bo.customer.ItemBo;
import org.example.dao.DAOFactory;
import org.example.dao.customer.ItemDAO;
import org.example.dto.ItemDTO;
import org.example.entity.Item;


public class ItemBoImpl implements ItemBo {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public void save(ItemDTO i) {
        itemDAO.save(new Item(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQty()));
    }

    @Override
    public void delete(String code) {
        itemDAO.delete(code);
    }

    @Override
    public ItemDTO search(String code) {
        Item i = itemDAO.search(code);
        return new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQty());
    }

    @Override
    public void update(ItemDTO i) {
        itemDAO.update(new Item(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQty()));
    }
}
