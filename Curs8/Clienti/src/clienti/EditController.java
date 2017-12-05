package clienti;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {
    FprincController ctrl;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nume;

    @FXML
    private TextField prenume;

    @FXML
    private TextField email;
    private Object tclienti;
    
     public void populez() {
    // Preiau obiectul selectat in fereastra principala
    Client c = (Client) ctrl.lClienti.get(ctrl.indexSelect);
    nume.setText(c.nume.get());
    prenume.setText(c.prenume.get());
    email.setText(c.email.get());
    // Mut focus-ul pe primul control
    nume.requestFocus();
 }
    @FXML
    void abandon(ActionEvent event) {
Stage stage = (Stage) prenume.getScene().getWindow();
    stage.hide();
    }

    @FXML
    void editez(ActionEvent event) {
         // Creez un Client
    Client c = new Client(nume.getText(), prenume.getText(), email.getText());
    // Inlocuiesc in lista lClienti şi in TableView
    ctrl.lClienti.remove(ctrl.indexSelect);
    ctrl.lClienti.add(ctrl.indexSelect, c);
    // Repopulez tabelul
    ctrl.tclienti.getItems().clear();
        for (Iterator it = ctrl.lClienti.iterator(); it.hasNext();) {
            Client cli = (Client) it.next();
            ctrl.tclienti.getItems().add(cli);
        }
    // Golesc controalele
    nume.setText(null);
    prenume.setText(null);
    email.setText(null);
    // Ascund fereastra
    Stage stage = (Stage) prenume.getScene().getWindow();
    stage.hide();
    }

    
}
