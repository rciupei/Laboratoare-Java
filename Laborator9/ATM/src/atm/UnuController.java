package atm;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class UnuController {

    Baza baza; 

    public void setBaza(Baza baza) {
        this.baza = baza;
    }
    
    @FXML
    private Rectangle welcome;

    @FXML
    private ImageView im1;

    @FXML
    void intra(MouseEvent event) {
        // Incarc ecranul doi
        baza.incarcDoi();
    }
    

}
