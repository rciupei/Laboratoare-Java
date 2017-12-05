package clienti;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FprincController {
    
    int indexSelect;
    Stage adaugStage; // Se adauga in zona de declaratii a clasei
    AdaugController ctrlAdaug;
    ArrayList lClienti;
    Stage editStage; // Se adauga in zona de declaratii a clasei
    EditController ctrlEdit;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    TableView<Client> tclienti;

    @FXML
    private TableColumn<Client, String> cNume;

    @FXML
    private TableColumn<Client, String> cPrenume;

    @FXML
    private TableColumn<Client, String> cEmail;

    @FXML
    void adauga(ActionEvent event) {
        adaugStage.showAndWait();
    }

    @FXML
    void editeaza(ActionEvent event) {
        if (indexSelect >= 0) {
            ctrlEdit.populez();
            editStage.showAndWait();
        }
    }

    @FXML
    void iesire(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void sterge(ActionEvent event) {
         if (indexSelect >= 0) {
       // Sterg din lista
       lClienti.remove(indexSelect);  //  Anterior s-a selectat in tabel!
       // Repopulez tabelul folosind un ob. observableList
       tclienti.setItems(FXCollections.observableList(lClienti));
       indexSelect = -1;
    }
    }

    @FXML
    void initialize() {
        lClienti = new ArrayList();

        cNume.setCellValueFactory(cellData -> cellData.getValue().nume);
        cPrenume.setCellValueFactory(cellData -> cellData.getValue().prenume);
        cEmail.setCellValueFactory(cellData -> cellData.getValue().email);
        
        
        try {
            // Load the fxml file and create a new stage for the popup
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Adaug.fxml"));
            AnchorPane container = (AnchorPane) loader.load();
            // Obtin obiectul controller al noii ferestre
            ctrlAdaug = loader.getController();
            adaugStage = new Stage();
            adaugStage.setTitle("Client nou");
            adaugStage.initModality(Modality.APPLICATION_MODAL);  //  Va fi o fereastra modala
            Scene scena = new Scene(container);
            adaugStage.setScene(scena);
            ctrlAdaug.ctrl = this;
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }
        
        tclienti.getSelectionModel().selectedIndexProperty().
    addListener((obiect, valVeche, valNoua) -> {
       // Se trateaza schimbarea starii.
       indexSelect = (int) valNoua;
    });
        try {
            // Load the fxml file and create a new stage for the popup
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Edit.fxml"));
            AnchorPane container = (AnchorPane) loader.load();
            // Obtin obiectul controller
            ctrlEdit = loader.getController();
            editStage = new Stage();
            editStage.setTitle("Editare");
            editStage.initModality(Modality.APPLICATION_MODAL);
            Scene scena = new Scene(container);
            editStage.setScene(scena);
            ctrlEdit.ctrl = this;
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }
    }
}
