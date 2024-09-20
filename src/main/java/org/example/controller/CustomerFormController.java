package org.example.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import org.example.bo.BOFactory;
import org.example.bo.customer.CustomerBo;
import org.example.dto.CustomerDTO;

public class CustomerFormController {
    public TextField txtid;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtTel;

    CustomerBo customerBo = (CustomerBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    public void SaveOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        CustomerDTO customerDTO = new CustomerDTO(id,name,address,tel);
        customerBo.save(customerDTO);
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        txtid.clear();
        txtName.clear();
        txtAddress.clear();
        txtTel.clear();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        CustomerDTO customerDTO = new CustomerDTO(id,name,address,tel);
        customerBo.update(customerDTO);
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        customerBo.delete(id);
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        CustomerDTO customerDTO = customerBo.search(id);
        txtid.setText(customerDTO.getId());
        txtName.setText(customerDTO.getName());
        txtAddress.setText(customerDTO.getAddress());
        txtTel.setText(customerDTO.getTel());
    }

}
