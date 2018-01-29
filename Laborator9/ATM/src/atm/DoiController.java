package atm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class DoiController {

    
    Baza baza;

    public void setBaza(Baza baza) {
        this.baza = baza;
    }
    
    @FXML
    private Rectangle welcome;

    @FXML
    private Button magh;

    @FXML
    private Button romana;

    @FXML
    private Button engl;

    @FXML
    private Button fran;

    @FXML
    private void bro(ActionEvent event) {
        // Incarc ecranul trei
        baza.incarcTrei();
    }
    
}
