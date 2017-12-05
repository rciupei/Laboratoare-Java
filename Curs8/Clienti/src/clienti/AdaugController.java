package clienti;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdaugController {
    FprincController ctrl;
    @FXML
    private TextField nume;

    @FXML
    private TextField prenume;

    @FXML
    private TextField email;

    @FXML
    void abandon(ActionEvent event) {
    Stage stage = (Stage) prenume.getScene().getWindow();
    stage.hide();
    }

    @FXML
    void adaug(ActionEvent event) {
    Client c = new Client(nume.getText(), prenume.getText(),
    email.getText());
    ctrl.lClienti.add(c);
    ctrl.tclienti.getItems().add(c);
    nume.setText(null);
    prenume.setText(null);
    email.setText(null);
    Stage stage = (Stage) nume.getScene().getWindow();
    stage.hide();
    }

}
