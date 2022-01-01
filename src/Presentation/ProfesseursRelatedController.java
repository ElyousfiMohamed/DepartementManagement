/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Presentation;

import SchoolManagementIMetier.IMetier;
import SchoolManagementIMetier.IMetierImpt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import persistantClasse.Professeur;

/**
 * FXML Controller class
 *
 * @author ELYOUSFI
 */
public class ProfesseursRelatedController implements Initializable {

    private final ObservableList<Professeur> professeurs = FXCollections.observableArrayList();
    @FXML
    private TableView<Professeur> tableView;
    @FXML
    private TableColumn<Professeur, Integer> id;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        IMetier metier = new IMetierImpt();

        professeurs.addAll(metier.getProfesseursByDepart(IMetierImpt.departement.getId()));
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

}
