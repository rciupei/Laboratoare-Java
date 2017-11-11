package convertorfxml;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ConvertorController {

    @FXML
    private RadioButton inch;

    @FXML
    private ToggleGroup tg1;

    @FXML
    private RadioButton feet;

    @FXML
    private RadioButton cm;

    @FXML
    private TextField dist;

    @FXML
    private TextField rez;

    @FXML
    private Label um;

    @FXML
    private Button calc;

    @FXML
    private Button iesire;

    @FXML
    void calc(ActionEvent event) {
        double d = Double.parseDouble(dist.getText());

        if (inch.isSelected()) {
            // Transform
            double linch = d * 0.39 * 100;
            // Pun in rez
            rez.setText(String.valueOf(linch));
            um.setText("inch");
            um.setVisible(true);
        } else if (cm.isSelected()) {
            // Transform
            double lcm = d * 100;
            // Pun in rez
            rez.setText(String.valueOf(lcm));
            um.setText("cm");
            um.setVisible(true);
        } else if (feet.isSelected()) {
            // Transform
            double lfeet = d * 3.2808;
            // Pun in rez
            rez.setText(String.valueOf(lfeet));
            um.setText("ft");
            um.setVisible(true);
        }

    }

    @FXML
    void ies(ActionEvent event) {
        Platform.exit();
    }

}
