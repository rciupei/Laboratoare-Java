package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class LoginController {

    Baza baza;
    Connection cnx;
    int categ;
    private String cod;

    public void setBaza(Baza baza) {
        this.baza = baza;
    }

    @FXML
    private PasswordField parola;

    @FXML
    private Label eroare;

    @FXML
    private TextField util;

    @FXML
    void intra(MouseEvent event) {
        //if(util.getText().equals(cod))

        validare(util.getText(),parola.getText());
        //System.out.println("textul este"+util.getText());

        //baza.incarcUnu();
    }

    @FXML
    void initialize() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection // cnx apartine clasei Connection
                    ("jdbc:mysql://localhost/restaurant?characterEncoding=utf8", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UnuController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UnuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //incarc(categ);
    }

    private void incarc() {

        String cda = "select * from utilizator ";
//                + "where id = "
//                + categ + " order by nume";
        //System.out.println("cda: " + cda);
        ResultSet rs;
        try {
            Statement stm;
            stm = cnx.createStatement();
            rs = stm.executeQuery(cda);
//            while (rs.next()) {
//
//                System.out.println(rs.getString("Nume"));
//            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UnuController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    private void validare(String nume,String parola) {

        String cda = "select * from utilizator ";
//                + "where id = "
//                + categ + " order by nume";
        //System.out.println("cda: " + cda);
        ResultSet rs;
        try {
            Statement stm;
            stm = cnx.createStatement();
            rs = stm.executeQuery(cda);
            while (rs.next()) {
                if (nume.equals(rs.getString("Nume"))&&parola.equals(rs.getString("Parola"))) {
                    incarc();
                    baza.incarcUnu();
                    System.out.println(rs.getInt("id"));
                } else {
                    eroare.setText("Utilizator sau parola incorecte");
                    eroare.setTextFill(Color.web("red"));
                    //System.out.println("inexistent");
                }
                //System.out.println(rs.getString("Nume"));
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UnuController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String apostrof(String s) {
        return "'" + s + "'";
    }

}
