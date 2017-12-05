package colab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdaugController {
    FprincController ctrl;
    @FXML
    private TextField cnume;

    @FXML
    private TextField cprenume;

    @FXML
    private TextField cemail;

    @FXML
    void abandon(ActionEvent event) {
Stage stage = (Stage) cprenume.getScene().getWindow();
      stage.hide();
    }
    

    @FXML
    void salveaza(ActionEvent event) {
      Persoana p = new Persoana(cnume.getText(), cprenume.getText(), cemail.getText());
      // Adaug p in lista lcolab şi p.nume lista (ListView)
      ctrl.lcolab.add(p);
      ctrl.getLista().getItems().add(p.nume);
      // Golesc controalele
      cnume.setText(null);
      cprenume.setText(null);
      cemail.setText(null);
      // Ascund fereastra
      Stage stage = (Stage) cprenume.getScene().getWindow();
      stage.hide();
    }

}
