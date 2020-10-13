package controllers;

import FileHandling.FileHandling;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

public class settings {

    public JFXTextField steamPath_TextField;
    public JFXTextField id_TextField;
    public JFXPasswordField pass_TextField;

    private String path = "C:\\Users\\Public\\SAS\\";
    private String name = "settings";
    private String extension = "txt";

    public void save(ActionEvent actionEvent) {
        // save the txt file for save this data

        FileHandling fileHandling = new FileHandling(name,path,extension);
        fileHandling.write(steamPath_TextField.getText());
    }
    public void load(){
        FileHandling fileHandling = new FileHandling(name,path,extension);
        System.out.println(fileHandling.getLine());
        //steamPath_TextField.setText(fileHandling.getLine());
    }

    public String getSteamPath_TextField() {
        return steamPath_TextField.getText();
    }
}
