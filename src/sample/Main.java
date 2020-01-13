package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));




        primaryStage.setTitle("Komponent");
        primaryStage.setScene(new Scene(root, 550, 165));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Controller controller = new Controller();
        loader.setController(controller);
        //StackPane stackPane = loader.load();
        XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(new FileOutputStream("data.xml")));
        encoder.writeObject(controller.nastawKolor(Color.RED).toString());

        encoder.close();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
