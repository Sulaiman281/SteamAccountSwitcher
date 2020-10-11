package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import sample.Account;
import sample.AccountList;
import sample.Main;

import java.io.IOException;

public class main {

    public BorderPane root;
    public ListView list_view;

    @FXML
    void initialize(){
        load_accounts();
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
        load_accounts();
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

    public void load_accounts(){
        list_view.getItems().clear();
        HBox hbox = new HBox();
        hbox.alignmentProperty().setValue(Pos.CENTER);
        Label gName = new Label("Gaming Name");
        gName.setFont(Font.font("Consolas",16));
        Label open_account_label = new Label("Edit Account");
        open_account_label.setFont(Font.font("Consolas",16));
        Label username_label = new Label("Username");
        username_label.setFont(Font.font("Consolas",16));
        Label delete_account_label = new Label("Delete Account");
        delete_account_label.setFont(Font.font("Consolas",16));
        hbox.getChildren().addAll(gName,username_label,open_account_label,delete_account_label);
        hbox.setSpacing(20);
        list_view.getItems().add(hbox);
        AccountList a = Main.accountList;
        for(int i = 0 ; i< a.size(); i++){
            HBox row = new HBox();
            row.alignmentProperty().setValue(Pos.CENTER);
            Hyperlink name = new Hyperlink();
            name.setText(a.get(i).getNickname());
            name.setFont(Font.font("Consolas",16));
            name.setOnAction(e-> {
                System.out.println("open steam account");
            });
            JFXButton edit_button = new JFXButton("Edit Account");
            edit_button.setFont(Font.font("Consolas",16));
            edit_button.setOnAction(e->{
                System.out.println("edit account here");
            });
            Label uName = new Label(a.get(i).getUsername());
            uName.setFont(Font.font("Consolas",16));
            JFXButton deleteBtn = new JFXButton("Delete Account");
            deleteBtn.setFont(Font.font("Consolas",16));
            deleteBtn.setOnAction(e->{
                System.out.println("Delete account code here");
            });
            row.setSpacing(20);
            row.getChildren().addAll(name,uName,edit_button,deleteBtn);
            list_view.getItems().add(row);
        }
    }
}