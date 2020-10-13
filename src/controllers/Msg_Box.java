package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Msg_Box {

    public Label title_text;
    public Label msg_text;

    @FXML
    void initialize(){
    }

    public void Message(String _title , String _msg, Boolean error_msg){
        if(error_msg)
            this.title_text.setTextFill(Color.web("#e40707"));
        else
            this.title_text.setTextFill(Color.web("#1e2761"));

        title_text.setText(_title);
        msg_text.setText(_msg);
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage)title_text.getScene().getWindow();
        stage.close();
    }
}
