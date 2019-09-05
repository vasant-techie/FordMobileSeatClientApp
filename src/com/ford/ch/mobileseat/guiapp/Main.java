package com.ford.ch.mobileseat.guiapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main extends Application {

    String cdsid;
    Stage window;
    BorderPane layout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("fordMobileSeatApp.fxml"));
        window = primaryStage;
        window.setTitle("Ford - Mobile Seat Booking App");
        //window.getIcons().add(new Image("../images/ford-text.jpg"));
        //VBox vBox = new VBox(menuBar);

        boolean loginSuccessful = displayLoginPage(primaryStage);

        if (!loginSuccessful) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Invalid credentials", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        Menu bookingsMenu = new Menu("Bookings");

        MenuItem newBooking = new MenuItem("Book Seat");
        bookingsMenu.getItems().add(newBooking);
        newBooking.setOnAction(e -> {
            //System.out.println("Menu Item 1 Selected");
        });

        MenuItem updateBooking = new MenuItem("Update booking");
        bookingsMenu.getItems().add(updateBooking);
        updateBooking.setOnAction(e -> {
            //System.out.println("Menu Item 2 Selected");
        });

        MenuItem cancelBooking = new MenuItem("Cancel booking");
        bookingsMenu.getItems().add(cancelBooking);
        cancelBooking.setOnAction(e -> {
            //System.out.println("Menu Item 3 Selected");
        });

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(bookingsMenu);


        layout = new BorderPane();
        layout.setTop(menuBar);
        window.setScene(new Scene(layout, 300, 275));
        window.setMaximized(true);
        window.show();
    }

    public boolean displayLoginPage(final Stage owner) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.setTitle("Sign in here");

        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(5);
        grid.setPadding(new Insets(25, 10, 10, 25));

        //Welcome title
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        //Enter username and label
        Label userName = new Label("Enter your Username:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        //Enter Password
        Label pw = new Label("Enter your password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        //Button to login
        Button btn = new Button("Login");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        //Set usernames and passwords
        List<String> userNames = new ArrayList<String>();
        List<String> passWord = new ArrayList<String>();

        //Add them in here
        //userNames.add("A");
        passWord.add("A");

        final AtomicBoolean loginSuccessful = new AtomicBoolean();

        //display login success when button is pressed
        btn.setOnAction((ActionEvent e) -> {
            String username = userTextField.getText();
            String password = pwBox.getText();

            //Check if correct here
            if ( (null != username && !"".equals(username.trim()) )
                && "ford".equals(password)) {
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Login Successful");
                this.cdsid = userTextField.getText();
                loginSuccessful.set(true);
                stage.close();
            } else {
                actiontarget.setFill(Color.RED);
                actiontarget.setText("Login UnSuccessful");
                loginSuccessful.set(false);
                stage.close();
            }
        });

        //Display
        Scene scene = new Scene(grid, 400, 300);
        stage.setScene(scene);
        stage.showAndWait();

        return loginSuccessful.get();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
