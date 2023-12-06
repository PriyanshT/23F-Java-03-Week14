package com.georgiancollege.week14;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {

    @FXML
    private TableColumn<Product, String> brandColumn;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TableColumn<Product, Integer> idColumn;

    @FXML
    private TableColumn<Product, Float> priceColumn;

    @FXML
    private Label productsLabel;

    @FXML
    private TableColumn<Product, Float> ratingsColumn;

    @FXML
    private TableColumn<Product, Integer> stockColumn;

    @FXML
    private TableView<Product> tableView;

    @FXML
    private TableColumn<Product, String> titleColumn;

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Response response = Utility.getProductsFromAPI();
        System.out.println(response);

        // initializing all the columns with the getters
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        ratingsColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

        // add all the data to the table view
        tableView.getItems().addAll(response.getProductsArray());

        // add a listener to the tableview
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldProduct, newProduct) -> {
                    productsLabel.setText(newProduct.getTitle());
                    descriptionTextArea.setText(newProduct.getDescription());

                    // to add an image
                    imageView.setImage(new Image(newProduct.getImages()[0]));
                }
        );
    }
}
