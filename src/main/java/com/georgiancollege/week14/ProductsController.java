package com.georgiancollege.week14;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {

    @FXML
    private TableColumn<?, ?> brandColumn;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private Label productsLabel;

    @FXML
    private TableColumn<?, ?> ratingsColumn;

    @FXML
    private TableColumn<?, ?> stockColumn;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> titleColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Response response = Utility.getProductsFromAPI();
    }
}
