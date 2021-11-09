package com.example.meddemo;



import UI.AdminDashboard;
import alert.Error;
import database.DB;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Login extends Application {


    @Override
    public void start(Stage stage) throws Exception {

//        BorderPane wrapper = new BorderPane();
        HBox wrapper = new HBox();

        VBox aside = new VBox(50);

        aside.setPrefWidth(300);
        aside.setStyle("-fx-background-color: blue;" + "-fx-padding: 70px 10px");
        HBox asideContainer = new HBox(30);

        HBox logoContainer = new HBox(10);
        logoContainer.setAlignment(Pos.CENTER);

        Label logo = new Label("Med Demo App");
        logo.setId("logo");

        HBox adminContainer = new HBox(10);
        adminContainer.setAlignment(Pos.CENTER);
        Button adminBtn = new Button("Login As Admin");

        HBox pharmacistContainer = new HBox(10);
        pharmacistContainer.setAlignment(Pos.CENTER);
        Button pharmacistBtn = new Button("Login As Pharmacist");

        HBox salesPersonContainer = new HBox(10);
        salesPersonContainer.setAlignment(Pos.CENTER);
        Button salesPersonBtn = new Button("Login As Sales Person");

        //Main section
        VBox main = new VBox(60);
        main.setStyle("-fx-padding: 50px 70px");
        HBox mainContainer = new HBox(20);

        HBox nameContainer = new HBox(10);

        nameContainer.setAlignment(Pos.CENTER);
        Label name = new Label("Med Org");

        HBox usernameLayout = new HBox(40);
        Label username = new Label("User Name:");
        TextField usernameFld = new TextField();

        HBox passwordLayout = new HBox(10);
        Label password = new Label("Password");
        PasswordField passwordFld = new PasswordField();

        HBox btnLayout = new HBox(10);
        Button loginBtn = new Button();
        loginBtn.setText("LOGIN");

        //Database connection
        DB dbCon = new DB();
        dbCon.MedDB();

        loginBtn.setOnAction(e->{
            String uName = usernameFld.getText();
            String uPassword = passwordFld.getText();

            /*
             Validations:
             - check for all fields
             - check for match for both nName and uPassword
             */

            if(uName.length() == 0 && uPassword.length() == 0){
                System.out.println("All fields are required");
            } else {
                boolean flag = dbCon.login(uName, uPassword);
                if(flag){
                    System.out.println("user exist");
                    usernameFld.clear();
                    passwordFld.clear();
                    AdminDashboard admin = new AdminDashboard();

                } else {
                    System.out.println("no such user exist. check your credentials");
                    Error error = new Error();


                }
            }

        });


        //Add logo to the logo container
        logoContainer.getChildren().add(logo);

        //Add adminBtn to the admin container
        adminContainer.getChildren().add(adminBtn);

        //Add pharmacist btn to the pharmacist container
        pharmacistContainer.getChildren().add(pharmacistBtn);

        //Add sales person btn to the sales person container
        salesPersonContainer.getChildren().add(salesPersonBtn);

        //Add nodes to aside container
//        asideContainer.getChildren().addAll(logoContainer, adminContainer, pharmacistContainer, salesPersonContainer);
        //Add aside container to aside
        aside.getChildren().addAll(logoContainer, adminContainer, pharmacistContainer, salesPersonContainer);

        //Add loginBtn to btn layout
        btnLayout.getChildren().add(loginBtn);

        //Add name to the name container
        nameContainer.getChildren().add(name);

        //Add username to username layout
        usernameLayout.getChildren().addAll(username, usernameFld);

        //Add password to password layout
        passwordLayout.getChildren().addAll(password, passwordFld);

        //Add nodes to main container
//        mainContainer.getChildren().addAll(nameContainer, usernameLayout, passwordLayout, btnLayout);
        main.getChildren().addAll(nameContainer, usernameLayout, passwordLayout, btnLayout);

        //Add aside and main node to wrapper
        wrapper.getChildren().addAll(aside, main);
        Scene scene = new Scene(wrapper, 1200, 700);
        stage.setTitle("Med Demo");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
