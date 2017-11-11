package zodie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculZodieController {

    @FXML
    private TextField luna;

    @FXML
    private TextField ziua;

    @FXML
    private Button calcul;

    @FXML
    private TextField zodia;

    @FXML
    void CalculZodie(ActionEvent event) {
        String Zod;
        int Zi = Integer.parseInt(ziua.getText());
        int L = Integer.parseInt(luna.getText());
        if ((L == 12 && Zi >= 22 && Zi <= 31) || (L == 1 && Zi >= 1 && Zi <= 19)) {
            Zod = "Capricorn";
        } else if ((L == 1 && Zi >= 20 && Zi <= 31) || (L == 2 && Zi >= 1 && Zi <= 17)) {
            Zod = "Varsator";
        } else if ((L == 2 && Zi >= 18 && Zi <= 29) || (L == 3 && Zi >= 1 && Zi <= 19)) {
            Zod = "Pesti";
        } else if ((L == 3 && Zi >= 20 && Zi <= 31) || (L == 4 && Zi >= 1 && Zi <= 19)) {
            Zod = "Berbec";
        } else if ((L == 4 && Zi >= 20 && Zi <= 30) || (L == 5 && Zi >= 1 && Zi <= 20)) {
            Zod = "Taur";
        } else if ((L == 5 && Zi >= 21 && Zi <= 31) || (L == 6 && Zi >= 1 && Zi <= 20)) {
            Zod = "Gemeni";
        } else if ((L == 6 && Zi >= 21 && Zi <= 30) || (L == 7 && Zi >= 1 && Zi <= 22)) {
            Zod = "Rac";
        } else if ((L == 7 && Zi >= 23 && Zi <= 31) || (L == 8 && Zi >= 1 && Zi <= 22)) {
            Zod = "Leu";
        } else if ((L == 8 && Zi >= 23 && Zi <= 31) || (L == 9 && Zi >= 1 && Zi <= 22)) {
            Zod = "Fecioara";
        } else if ((L == 9 && Zi >= 23 && Zi <= 30) || (L == 10 && Zi >= 1 && Zi <= 22)) {
            Zod = "Balanta";
        } else if ((L == 10 && Zi >= 23 && Zi <= 31) || (L == 11 && Zi >= 1 && Zi <= 21)) {
            Zod = "Scorpion";
        } else if ((L == 11 && Zi >= 22 && Zi <= 30) || (L == 12 && Zi >= 1 && Zi <= 21)) {
            Zod = "Sagetator";
        } else {
            Zod = "Nu e o zodie!";
        }
        zodia.setText(Zod);
    }

}
