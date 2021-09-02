package sample;



import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginMain implements Initializable {
    @FXML
    private Button signup;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private CheckBox remember;
    @FXML
    private Button forgotpassword;
    @FXML
    private Button login;

    private Connection connection;
    private PreparedStatement pst;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void loginAction(ActionEvent event) throws IOException {

        //TEMPORARY , FOR GUI TEST
        login.getScene().getWindow().hide();
        Stage home =new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXMl/HomePage.fxml"));
            Scene scene = new Scene(root);
            home.setScene(scene);
            home.show();

        } catch (IOException e1){
            e1.printStackTrace();
        }

        /* PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(e -> {
            System.out.println("Login Successfully !");
        });
        pt.play();

        // Retrieve data in the database
        String nm =  username.getText();
        String pw = password.getText();
        String q1 = "SELECT * FROM YOUTUBERS WHERE NAME = '"+nm+"' and PASSWORD = '"+pw+"' ";

        try {
            pst = connection.prepareStatement(q1);
            ResultSet rs = pst.executeQuery();
            int count = 0;

            while (rs.next()) count++;
            if (count == 1) {
                login.getScene().getWindow().hide();
                Stage home =new Stage();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/FXMl/HomePage.fxml"));
                    Scene scene = new Scene(root);
                    home.setScene(scene);
                    home.show();

                } catch (IOException e1){
                    e1.printStackTrace();
                }



            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Username/Password not correct.");
                alert.show();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/


    }

    public void signUp(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();
        Stage sign = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/SignUp.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        sign.setScene(scene);
        sign.show();
        sign.setResizable(false);


    }
}
