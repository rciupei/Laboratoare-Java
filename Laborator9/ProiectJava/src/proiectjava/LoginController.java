package proiectjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginController {

    Baza baza;
    Connection cnx;
    Statement stmt;
    int linia;
    ArrayList<String> lPoze;
    int pozaCurenta;

    public void setBaza(Baza baza) {
        this.baza = baza;
    }

    @FXML
    private TextField util;

    @FXML
    private PasswordField parola;

    @FXML
    private Label msg;
    
    
    @FXML
    private Label confirm;

    @FXML
    void initialize() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/Excubd?characterEncoding=utf8", "root", "");
            System.out.println("Conectare ok.");
            stmt = cnx.createStatement();
            //  Creez multimea de selectie continand datele din 
            //  tabelul Excursii

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void intra(ActionEvent event) {
        validare(util.getText(), parola.getText());

    }

    @FXML
    void adaug(ActionEvent event) {
        baza.incarcTrei();
        initialize();


    }
    
    public void printare(){
        System.out.println("print metoda");
    }

    private void validare(String nume, String parola) {
        String cda = "select * from Utilizatori ";
//                + "where id = "
//                + categ + " order by nume";
        //System.out.println("cda: " + cda);
        ResultSet rs;
        try {
            Statement stm;
            stm = cnx.createStatement();
            rs = stm.executeQuery(cda);

            while (rs.next()) {
                if (nume.equals(rs.getString("Nume")) && parola.equals(rs.getString("Parola")) 
                        &&nume.length()>0 && parola.length()>0)  {

                    baza.incarcDoi();
                    

                    //System.out.println(rs.getInt("Id_util"));
                } else {
                   // System.out.println(rs.getString("Nume"));
                    msg.setText("Utilizator sau parola incorecte");
                    msg.setTextFill(Color.web("red"));
//                    System.out.println("inexistent");
                }
                //System.out.println(rs.getString("Nume"));
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
}
