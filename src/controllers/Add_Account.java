package controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Account;
import sample.Main;

import java.io.IOException;

public class Add_Account {

    public JFXTextField gName_TextField;
    public JFXTextField username_TextField;
    public JFXPasswordField pass_TextField;

    public void add(ActionEvent actionEvent) {
        if(username_TextField.getText().isEmpty()) return;
        if(pass_TextField.getText().isEmpty()) return;
        if(gName_TextField.getText().isEmpty()) return;

        Account account = new Account();
        account.setNickname(gName_TextField.getText());
        account.setUsername(username_TextField.getText());
        account.setPassword(pass_TextField.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/msgpage.fxml"));
        BorderPane model_app = null;
        try {
             model_app = loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Msg_Box controller = loader.getController();

        if(!Main.accountList.add(account)){
            // notify user that this account username is already in the list
            controller.Message("Failed","This username is already in the list",true);
        }else{
            // notify user that account is successfully created
            controller.Message("Success","Account has been added successfully",false);
        }
        Stage model_stage = new Stage();
        model_stage.setScene(new Scene(model_app));
        model_stage.initModality(Modality.APPLICATION_MODAL);
        model_stage.initStyle(StageStyle.TRANSPARENT);
        model_stage.show();

    }

    public void cancel(ActionEvent actionEvent) {
        gName_TextField.setText("");
        username_TextField.setText("");
        pass_TextField.setText("");
    }
}
