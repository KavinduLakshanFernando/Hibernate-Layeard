package org.example.bo.customer;

import org.example.bo.SuperBo;
import org.example.dto.ItemDTO;

public interface ItemBo extends SuperBo{
    void save(ItemDTO itemDTO);

    void delete(String code);

    ItemDTO search(String code);

    void update(ItemDTO itemDTO);
}
