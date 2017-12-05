package colab;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FprincController {
    Stage adaugStage;
   AdaugController ctrlAdaug;

    @FXML
    private ListView<String> lista;

    public ListView<String> getLista() {
        return lista;
    }


    @FXML
    private TextField nume;

    @FXML
    private TextField prenume;

    @FXML
    private TextField email;
      ArrayList<Persoana> lcolab;

     @FXML
   void adaug(ActionEvent event) {
      adaugStage.showAndWait();
   }
   @FXML
   void initialize() {
      lista.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
      lcolab = new ArrayList();

      lista.getSelectionModel().selectedIndexProperty().addListener((obiect, valVeche, valNoua) -> {
         // Se trateaza schimbarea starii.
         int index = (int) valNoua;
         // Populez controalele
         Persoana p = lcolab.get(index);
         nume.setText(p.nume);
         prenume.setText(p.prenume);
         email.setText(p.email);
      });
      try {
         // Load the fxml file and create a new stage for the popup
         FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Adaug.fxml"));
         AnchorPane container = (AnchorPane) loader.load();

         // Obtin obiectul controller
         ctrlAdaug = loader.getController();
         adaugStage = new Stage();
         adaugStage.setTitle("Contact nou");
         adaugStage.initModality(Modality.APPLICATION_MODAL);
         Scene scena = new Scene(container);
         adaugStage.setScene(scena);
         ctrlAdaug.ctrl = this;
      } catch (IOException e) {
         // Exception gets thrown if the fxml file could not be loaded
         e.printStackTrace();
      }
   }
}
