package org.example.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import org.example.bo.BOFactory;
import org.example.bo.customer.ItemBo;
import org.example.dto.ItemDTO;

public class ItemFormController {
    public TextField txtCode;
    public TextField txtqty;
    public TextField txtUPrice;
    public TextField txtDescription;

    ItemBo itemBo = (ItemBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);
    public void SaveOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        String unitPrice = txtUPrice.getText();
        String qty = txtqty.getText();

        ItemDTO itemDTO = new ItemDTO(code,description,unitPrice,qty);
        itemBo.save(itemDTO);
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        txtCode.clear();
        txtDescription.clear();
        txtUPrice.clear();
        txtqty.clear();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        String unitPrice = txtUPrice.getText();
        String qty = txtqty.getText();

        ItemDTO itemDTO = new ItemDTO(code,description,unitPrice,qty);
        itemBo.update(itemDTO);
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        itemBo.delete(code);
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        ItemDTO itemDTO = itemBo.search(code);
        txtCode.setText(itemDTO.getCode());
        txtDescription.setText(itemDTO.getDescription());
        txtUPrice.setText(itemDTO.getUnitPrice());
        txtqty.setText(itemDTO.getQty());
    }
}
