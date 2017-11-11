package judete;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class JudController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> jud;

    @FXML
    private TextField supraf;

    @FXML
    private TextField populatie;

    @FXML
    private TextField capitala;

    private ArrayList<Judet> lJudete;

    @FXML
    void afiseaza(ActionEvent event) {
        
 // Preiau pozitia elementului selectat in controlul jud
 int poz = jud.getSelectionModel().getSelectedIndex();
 // preiau obiectul corespunzator din lista lJudete
 Judet jSelectat = lJudete.get(poz);
 // Populez controalele ferestrei
 supraf.setText(String.valueOf(jSelectat.getSupraf()));
 populatie.setText(String.valueOf(jSelectat.getLocuitori()));
 capitala.setText(jSelectat.getCapitala()); 

    }

    @FXML
    void initialize() {
//        assert jud != null : "fx:id=\"jud\" was not injected: check your FXML file 'Jud.fxml'.";
//        assert supraf != null : "fx:id=\"supraf\" was not injected: check your FXML file 'Jud.fxml'.";
//        assert populatie != null : "fx:id=\"populatie\" was not injected: check your FXML file 'Jud.fxml'.";
//        assert capitala != null : "fx:id=\"capitala\" was not injected: check your FXML file 'Jud.fxml'.";
        lJudete = new ArrayList();
        // Cream obiecte din clasa jud si le adaugam in lista lJudete
        Judet unJudet = new Judet("Alba", 6242, 342376, "Alba Iulia");
        lJudete.add(unJudet);
        unJudet = new Judet("Arad", 7754, 430629, "Arad");
        lJudete.add(unJudet);
        unJudet = new Judet("Arges", 6826, 612431, "Pitesti");
        lJudete.add(unJudet);
        unJudet = new Judet("Bacau", 6621, 616168, "Bacau");
        lJudete.add(unJudet);
        // Se populeaza jud (ComboBox)
 for (Judet j : lJudete) {
 jud.getItems().add(j.getNume());
 }
    }
    public void iesire(ActionEvent event) {
 // handle the event here
 Platform.exit();
 } 
}
