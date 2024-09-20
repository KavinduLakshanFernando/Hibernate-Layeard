package org.example.bo.customer.IMPL;

import org.example.bo.customer.CustomerBo;
import org.example.dao.DAOFactory;
import org.example.dao.customer.CustomerDAO;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;

public class CustomerBoImpl implements CustomerBo {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public void save(CustomerDTO i) {
        customerDAO.save(new Customer(i.getId(),i.getName(),i.getAddress(),i.getTel()));

    }

    @Override
    public void delete(String id) {
        customerDAO.delete(id);
    }

    @Override
    public void update(CustomerDTO c) {
        customerDAO.update(new Customer(c.getId(), c.getName(),c.getAddress(), c.getTel()));
    }

    @Override
    public CustomerDTO search(String id) {
        Customer s = customerDAO.search(id);
        return new CustomerDTO(s.getId(),s.getName(),s.getAddress(),s.getTel());
    }
}
