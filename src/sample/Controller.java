package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javax.swing.*;
import javax.xml.stream.XMLStreamWriter;
import java.beans.XMLEncoder;
import java.io.*;

public class Controller implements Serializable {

    @FXML
    private ImageView imageView1,imageView2,imageView3,imageView4;
    @FXML
    private Button button;
    @FXML
    private Pane pane;
    @FXML
    private TextField textField;
    @FXML
    private ProgressBar progress;
    @FXML
    private HBox hbox;
    private int jednosci;
    private int dziesiatki;
    private int setki;
    private int tysiace;
    private double liczba;
    private String string;
    private Image image,image1,image2,image3;
    private static final String FILENAME = "testbeanlist.xml";


    public Controller(){


    }
    public Integer getJednosci(){
        return setki;
    }
    @FXML
     void initialize(){
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                string = "0."+textField.getText();
                liczba = new Double(string);
                progress.setProgress(liczba);
                if(progress.getProgress() <= 0.2){
                    nastawVoltomierz(0,2,4,0);
                    progress.setEffect(nastawKolor(Color.ORANGE));
                }
                if(progress.getProgress() >= 0.2 && progress.getProgress() <= 0.5){
                    nastawVoltomierz(0,3,5,0);
                    progress.setEffect(nastawKolor(Color.YELLOW));
                }


        if(progress.getProgress() >= 0.5 && progress.getProgress() <= 0.8){
            nastawVoltomierz(0,3,8,5);
            progress.setEffect(nastawKolor(Color.GREEN));
        }
        if(progress.getProgress() >= 0.8 && progress.getProgress() <= 1.0){
            nastawVoltomierz(0,4,2,0);
            progress.setEffect(nastawKolor(Color.RED));
        }

    }};

        textField.addEventHandler(ActionEvent.ACTION,eventHandler);
      /*  EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //pane.getChildren().clear();
               // System.out.println(progress.getTranslateX());
                liczba = Integer.parseInt(textField.getText());
                if(liczba >= 0 && liczba <10000) {
                    jednosci = liczba % 10;
                    dziesiatki = liczba / 10 % 10;
                    setki = liczba / 100 % 10;
                    tysiace = liczba / 1000 % 10;
                    image = new Image("file:src/red/czer" + tysiace + ".png");
                    imageView1.setImage(image);

                    image1 = new Image("file:src/red/czer" + setki + ".png");
                    imageView2.setImage(image1);

                    image2 = new Image("file:src/red/czer" + dziesiatki + ".png");
                    imageView3.setImage(image2);

                    image3 = new Image("file:src/red/czer" + jednosci + ".png");
                    imageView4.setImage(image3);
                }
                else{
                    System.out.println("cos zjebales");}

            }
        };

        textField.addEventHandler(ActionEvent.ACTION,eventHandler);*/

    }
    public void nastawVoltomierz(int tysiace, int setki,int dziesiatki,int jednosci){

        image = new Image("file:src/red/czer" + tysiace + ".png");
        imageView1.setImage(image);

        image1 = new Image("file:src/red/czer" + setki + ".png");
        imageView2.setImage(image1);

        image2 = new Image("file:src/red/czer" + dziesiatki + ".png");
        imageView3.setImage(image2);

        image3 = new Image("file:src/red/czer" + jednosci + ".png");
        imageView4.setImage(image3);


    }


    public Effect nastawKolor(Color kolor){
        DropShadow glowEffect= new DropShadow();
        glowEffect.setColor(kolor);
      return glowEffect;
    }




}
