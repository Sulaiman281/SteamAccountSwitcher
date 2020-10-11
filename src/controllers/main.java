package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class main {

    public BorderPane root;
    public ListView list_view;

    @FXML
    void initialize(){

    }

    public void add_account(ActionEvent actionEvent) {
        try {
            AnchorPane page = FXMLLoader.load(getClass().getResource("../fxml/add_account.fxml"));
            root.setCenter(page);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void accounts(ActionEvent actionEvent) {
        root.setCenter(list_view);
    }

    public void settings(ActionEvent actionEvent) {
        try {
            AnchorPane page = FXMLLoader.load(getClass().getResource("../fxml/settings.fxml"));
            root.setCenter(page);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close_application(ActionEvent actionEvent) {
    }
}