/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Presentation;

import DataBase.SingletonConnexionDB;
import SchoolManagementIMetier.IMetier;
import SchoolManagementIMetier.IMetierImpt;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import persistantClasse.Professeur;

/**
 * FXML Controller class
 *
 * @author ELYOUSFI
 */
public class ProfesseurController implements Initializable {

    @FXML
    private TableView<Professeur> tableView = new TableView<>();
    ;
    @FXML
    private TableColumn<Professeur, String> nom;
    @FXML
    private TableColumn<Professeur, String> prenom;
    @FXML
    private TableColumn<Professeur, String> cin;
    @FXML
    private TableColumn<Professeur, String> adresse;
    @FXML
    private TableColumn<Professeur, String> email;
    @FXML
    private TableColumn<Professeur, String> telephone;
    @FXML
    private TableColumn<Professeur, String> date;

    private final ObservableList<Professeur> professeurs = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Professeur, Integer> id;
    @FXML
    private TextField search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        IMetier metier = new IMetierImpt();

        professeurs.addAll(metier.getAllProfesseurs());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        date.setCellValueFactory(new PropertyValueFactory<>("date_recrutement"));
        tableView.setItems(professeurs);
    }

    @FXML
    private void newProf(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("nvProfesseur.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("nouveau professeur");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent e) {
                    tableView.getItems().clear();
                    IMetier metier = new IMetierImpt();
                    professeurs.addAll(metier.getAllProfesseurs());
                    id.setCellValueFactory(new PropertyValueFactory<>("id"));
                    nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                    cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
                    adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                    email.setCellValueFactory(new PropertyValueFactory<>("email"));
                    telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                    date.setCellValueFactory(new PropertyValueFactory<>("date_recrutement"));
                    tableView.setItems(professeurs);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void delProf(ActionEvent event) {
        int indice = tableView.getSelectionModel().getSelectedIndex();
        if (indice >= 0) {
            try {
                IMetier metier = new IMetierImpt();
                metier.delProfesseur(tableView.getItems().get(indice).getId());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            tableView.getItems().remove(indice);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un élément ");
            alert.show();
        }
    }

    @FXML
    private void updateProf(ActionEvent event) {
    }

    @FXML
    private void afctDprt(ActionEvent event) {
    }

    @FXML
    private void searchProf(KeyEvent event) {
        String keyWord = search.getText();
        tableView.getItems().clear();
        
        IMetier m = new IMetierImpt();
        professeurs.addAll(m.searchProf(keyWord));
        tableView.setItems(professeurs);
    }

}
