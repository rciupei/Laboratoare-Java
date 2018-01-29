package atm;

import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TreiController {

    Baza baza;
    private String cod = "1234";

    public void setBaza(Baza baza) {
        this.baza = baza;
    }

    @FXML
    private Rectangle welcome;

    @FXML
    private PasswordField pin;

    @FXML
    private Label msj;

    @FXML
    void anulare(ActionEvent event) {

    }

    @FXML
    void corectare(ActionEvent event) {

    }

    @FXML
    void ok(ActionEvent event) {
        //baza.incarcPatru();
        if (pin.getText().equals(cod)) {
            System.out.println("ok");
            msj.setText("Pin corect");
            msj.setTextFill(Color.web("green"));
        }
        
        else{
        System.out.println("pin gresit");
            msj.setText("Pin gresit");
            msj.setTextFill(Color.web("red"));
        }
    }
    
    @FXML
    void inapoi (ActionEvent event){
        baza.incarcDoi();
        
    }

}
