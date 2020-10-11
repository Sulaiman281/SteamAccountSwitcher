package controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import sample.Account;
import sample.AccountList;
import sample.Main;

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
        System.out.println(account.toString());
        Main.accountList.add(account);
    }

    public void cancel(ActionEvent actionEvent) {
        gName_TextField.setText("");
        username_TextField.setText("");
        pass_TextField.setText("");
    }
}
