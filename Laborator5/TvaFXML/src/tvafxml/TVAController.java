package tvafxml;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TVAController {

    @FXML
    private TextField pret;

    @FXML
    private TextField cota;

    @FXML
    private TextField cat;

    @FXML
    private Button calcul;

    @FXML
    void calculTVA(ActionEvent event) {
        double ppret = Double.parseDouble(pret.getText());
        double ccota = Double.parseDouble(cota.getText());
        double tvap = ppret * ccota / 100;
        cat.setText(String.valueOf(tvap));
    }

           @FXML
    void Iesire(ActionEvent event) {
        Platform.exit();
    }
}
