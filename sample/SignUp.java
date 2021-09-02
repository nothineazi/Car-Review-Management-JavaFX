package sample;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class SignUp implements Initializable {

    @FXML
    private AnchorPane parentPane;
    @FXML
    private TextField name;
    @FXML
    private Button loginBack;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    @FXML
    private TextField location;

    @FXML
    private PasswordField password;
    @FXML
    private Button signup;


    //private DBConnection connection  = new DBConnection();
    Properties info;
    private Connection connection;//= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "yasser","1234");
    private final Map<String, String> credentials = new HashMap<>();
    private PreparedStatement pst ;



    @Override
    public void initialize (URL location, ResourceBundle resources){

    }


    @FXML
    public  void signUpDone (ActionEvent ae1) throws IOException {
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished( event -> {
            System.out.println("SignUp Succesfully !");
        });
        pt.play();

        //Saving data
        String nm= name.getText();
        String psw = password.getText();
        String addr= location.getText();
        String  gd= getGender();
        String insert = "INSERT INTO YOUTUBERS(NAME, PASSWORD, GENDER, ADDRESS) VALUES ('"+nm+"', '"+psw+"', '"+gd+"', '"+addr+"')";

        try {
            pst = connection.prepareStatement(insert);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        try {
            pst.executeUpdate();
            System.out.println("recorded");
        } catch (SQLException e1){
            e1.printStackTrace();
        }

        // Problem trying to insert data in the database

    }

    @FXML
    public void loginAction(ActionEvent ae2) throws IOException {

        loginBack.getScene().getWindow().hide();
        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/LoginMain.fxml"));
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.show();
        login.setResizable(false);
    }

    public String getGender(){
        String gen = "";
        if (male.isSelected()) gen = "Male";
        else if (female.isSelected()) gen = "Female";
        return gen;
    }
}
