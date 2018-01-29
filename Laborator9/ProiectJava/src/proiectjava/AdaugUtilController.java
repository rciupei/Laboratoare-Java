package proiectjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AdaugUtilController {

    Baza baza;
    Connection cnx;
    Statement stmt;

    public void setBaza(Baza baza) {
        this.baza = baza;
    }

    @FXML
    private TextField nume;

    @FXML
    private PasswordField parola;

    @FXML
    private PasswordField rep_parola;

    @FXML
    private Label mesaj;

    @FXML
    private Button ad;

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
    void adauga(ActionEvent event) throws InterruptedException {

        String nume1 = nume.getText();
        String parola1 = parola.getText();
        String rep_parola1 = rep_parola.getText();
        if (parola1.equals(rep_parola1) && parola1.length() > 0) {
            try {

                String cda = "INSERT INTO `Utilizatori`(`Id_util`, `Nume`, `Parola`) VALUES(null,'" + nume1 + "'"
                        + ",'" + parola1 + "')";
                System.out.println(cda); // Pt. testare
                Statement stm = cnx.createStatement();
                stm.executeUpdate(cda);
                stm.close();

            } catch (SQLException ex) {

                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
            //ad.disableProperty();
            mesaj.setText("Utilizator adaugat");
            ad.setDisable(true);
            

            //baza.incarcLogin();
        } else {
            mesaj.setText("Parolele sunt diferite");
            
        }
    }

    @FXML
    void back(ActionEvent event) {
        baza.incarcLogin();
    }

}
