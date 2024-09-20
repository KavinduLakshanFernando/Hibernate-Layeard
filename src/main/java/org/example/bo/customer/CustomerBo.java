package org.example.bo.customer;

import org.example.bo.SuperBo;
import org.example.dto.CustomerDTO;

public interface CustomerBo extends SuperBo {
    void save(CustomerDTO customerDTO);

    void delete(String id);

    void update(CustomerDTO customerDTO);

    CustomerDTO search(String id);
}
