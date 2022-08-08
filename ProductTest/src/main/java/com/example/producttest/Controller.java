package com.example.producttest;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    public TextField textGetCost;
    public TextField textGetQuantity;
    public TextField textGetName;
    public ListView<Product> productList = new ListView<>();
    public Label lblName;
    public Label lblQuant;
    public Label lblCost;
    public TextField textAddQuantity;
    public Button btnPurchase;

    private void checkZero(){
        Product temp;
        temp = productList.getSelectionModel().getSelectedItem();
        if (temp.getQuantity() == 0){
            btnPurchase.setDisable(true);
        }
        else{
            btnPurchase.setDisable(false);
        }

    }

    public void addProduct(ActionEvent actionEvent) {
        String name = textGetName.getText();
        int quant = Integer.parseInt(textGetQuantity.getText());
        double cost = Double.parseDouble(textGetCost.getText());
        Product temp = new Product(name, quant, cost);
        productList.getItems().add(temp);

        textGetName.clear();
        textGetQuantity.clear();
        textGetCost.clear();
        btnPurchase.setDisable(true);
    }

    public void displayProduct(MouseEvent mouseEvent) {
        Product temp;
        temp = productList.getSelectionModel().getSelectedItem();
        lblName.setText(temp.name);
        lblQuant.setText(Integer.toString(temp.getQuantity()));
        lblCost.setText("$" + Double.toString(temp.getCost()));
        checkZero();

    }

    public void addQuantity(ActionEvent actionEvent) {
        Product temp;
        temp = productList.getSelectionModel().getSelectedItem();
        double amt;
        amt = Double.parseDouble(textAddQuantity.getText());
        temp.addQuantity(amt);
        textAddQuantity.clear();


        lblQuant.setText(Integer.toString(temp.getQuantity()));

        checkZero();

    }

    public void purchase(ActionEvent actionEvent) {
        Product temp;
        temp = productList.getSelectionModel().getSelectedItem();
        temp.purchase();
        lblQuant.setText(Integer.toString(temp.getQuantity()));
        checkZero();


    }
}