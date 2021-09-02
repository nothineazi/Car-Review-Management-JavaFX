package sample;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePage implements Initializable {

    public Button btnHome;
    public Button btnAddCars;
    public Button btnMyCars;
    @FXML
    AnchorPane holderPane;
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnExit;
    AnchorPane home;


    @Override
    public void initialize (URL arg0, ResourceBundle arg1){



        createPage();
    }





    private void setNode(Node node){
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft= new FadeTransition(Duration.millis(1500), node);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();

    }

    private void createPage(){
        try {
            home = FXMLLoader.load(getClass().getResource("/FXML/HOME.fxml"));
            setNode(home);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void exitAction(ActionEvent event) {
        Platform.exit();
    }

    public void logOutAction(ActionEvent event) throws IOException {
        btnLogOut.getScene().getWindow().hide();
        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/LoginMain.fxml"));
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.show();
        login.setResizable(false);
    }



    public void contactUs(ActionEvent event) {
    }

    public void addCarsAction(ActionEvent event) {
    }

    public void myCarsAction(ActionEvent event) {
    }

    public void homeAction(ActionEvent event) {
        setNode(home);
    }
}
