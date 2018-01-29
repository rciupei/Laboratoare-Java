/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author razvan
 */
public class Baza extends Application {

    Stage fereastra;
    Baza baza;

    public void setBaza(Baza baza) {
        this.baza = baza;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            fereastra = primaryStage;
            fereastra.setTitle("ATM");
            incarcLogin();
            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    LoginController login;

    public void incarcLogin() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Login.fxml"));
        AnchorPane container;
        try {
            container = (AnchorPane) loader.load();
            Scene scene = new Scene(container);
            fereastra.setScene(scene);
            fereastra.sizeToScene();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        login = loader.getController();
        login.setBaza(this);
    }
    
    UnuController ctrUnu;

    public void incarcUnu() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("unu.fxml"));
        AnchorPane container;
        try {
            container = (AnchorPane) loader.load();
            Scene scene = new Scene(container);
            fereastra.setScene(scene);
            fereastra.sizeToScene();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ctrUnu = loader.getController();
        ctrUnu.setBaza(this);
    }

    DoiController ctrDoi;

    public void incarcDoi() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("doi.fxml"));
        AnchorPane container;
        try {
            container = (AnchorPane) loader.load();
            Scene scene = new Scene(container);
            fereastra.setScene(scene);
            fereastra.sizeToScene();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ctrDoi = loader.getController();
        ctrDoi.setBaza(this);
    }
    
    TreiController ctrTrei;
    
    public void incarcTrei() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("trei.fxml"));
        AnchorPane container;
        try {
            container = (AnchorPane) loader.load();
            Scene scene = new Scene(container);
            fereastra.setScene(scene);
            fereastra.sizeToScene();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ctrTrei = loader.getController();
        ctrTrei.setBaza(this);
    }

//    PatruController ctrPatru;
//    
//    public void incarcPatru() {
//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("patru.fxml"));
//        AnchorPane container;
//        try {
//            container = (AnchorPane) loader.load();
//            Scene scene = new Scene(container);
//            fereastra.setScene(scene);
//            fereastra.sizeToScene();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        ctrTrei = loader.getController();
//        ctrTrei.setBaza(this);
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
