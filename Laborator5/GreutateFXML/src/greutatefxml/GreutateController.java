package greutatefxml;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class GreutateController {

    @FXML
    private TextField inaltimea;

    @FXML
    private TextField varsta;

    @FXML
    private TextField greutatea;

    @FXML
    private CheckBox gen;

    @FXML
    private Button calcul;

    @FXML
    private Button ies;

    @FXML
    void calculGreutate(ActionEvent event) {
        double hh = Double.parseDouble(inaltimea.getText());
        double vv = Double.parseDouble(varsta.getText());
        double gg = 50. + 0.75 * (hh - 150.) + 0.25 * (vv - 20.);
        if (!gen.isSelected()) {
            gg = gg * 0.9;
        }
        greutatea.setText(String.valueOf(gg));
    }

    @FXML
    void iesire(ActionEvent event) {
        Platform.exit();
    }

}
