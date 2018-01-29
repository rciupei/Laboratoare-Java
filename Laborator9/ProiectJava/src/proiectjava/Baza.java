/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectjava;

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            fereastra = primaryStage;
            fereastra.setTitle("Calatorii");
            incarcLogin();
            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    LoginController ctrUnu;

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
        ctrUnu = loader.getController();
        ctrUnu.setBaza(this);
    }

    EcPrincipalController ctrDoi;

    public void incarcDoi() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("EcPrincipal.fxml"));
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
    
     AdaugUtilController ctrTrei;

    public void incarcTrei() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AdaugUtil.fxml"));
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
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
