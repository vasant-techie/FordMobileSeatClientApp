package com.ford.ch.mobileseat.guiapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    BorderPane layout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("fordMobileSeatApp.fxml"));
        window = primaryStage;
        window.setTitle("Ford - Mobile Seat Booking App");
        //window.getIcons().add(new Image("../images/ford-text.jpg"));

        //VBox vBox = new VBox(menuBar);

        Menu bookingsMenu = new Menu("Bookings");

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(bookingsMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        window.setScene(new Scene(layout, 300, 275));
        window.setMaximized(true);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
