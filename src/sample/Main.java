package sample;

import controllers.settings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static AccountList accountList = new AccountList();
    public static String steamPath = "";
    @Override
    public void start(Stage primaryStage) throws Exception{
        accountList.load_accounts();
        settings s = new settings();
        s.load();
        steamPath = s.getSteamPath_TextField();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Main.fxml"));
        primaryStage.setTitle("Steam Account Switcher");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e->{
            System.out.println("closing");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
