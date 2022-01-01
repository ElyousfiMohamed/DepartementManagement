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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import persistantClasse.Departement;
import persistantClasse.Professeur;

/**
 * FXML Controller class
 *
 * @author ELYOUSFI
 */
public class DepartementController implements Initializable {

    @FXML
    private TableView<Departement> tableView;
    @FXML
    private TableColumn<Departement, Integer> id;
    @FXML
    private TableColumn<Departement, String> nom;
    private ObservableList<Departement> departements = FXCollections.observableArrayList();
    @FXML
    private TextField search;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        IMetier metier = new IMetierImpt();
        departements.addAll(metier.getAllDepartements());
        tableView.setItems(departements);
        
    }    

    @FXML
    private void newDepart(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("nvDepartement.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("nouveau departement");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent e) {
                    tableView.getItems().clear();
                    IMetier metier = new IMetierImpt();
                    departements.addAll(metier.getAllDepartements());
                    id.setCellValueFactory(new PropertyValueFactory<>("id"));
                    nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    tableView.setItems(departements);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void delDepart(ActionEvent event) {
        int indice = tableView.getSelectionModel().getSelectedIndex();
        if (indice >= 0) {
            try {
                IMetier metier = new IMetierImpt();
                metier.delDepartement(tableView.getItems().get(indice).getId());
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
    private void updateDepart(ActionEvent event) {
        int indice = tableView.getSelectionModel().getSelectedIndex();
        if (indice >= 0) {
            try {
                IMetierImpt.departement = tableView.getItems().get(indice);

                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("modifDepart.fxml"));

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("modifier departement");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent e) {
                        tableView.getItems().clear();
                        IMetier metier = new IMetierImpt();
                        departements.addAll(metier.getAllDepartements());
                        id.setCellValueFactory(new PropertyValueFactory<>("id"));
                        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                        tableView.setItems(departements);
                    }
                });
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText(ex.getMessage());
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un élément ");
            alert.show();
        }
    }


    @FXML
    private void profsRelatedShow(ActionEvent event) {
        int indice = tableView.getSelectionModel().getSelectedIndex();
        if (indice >= 0) {
            try {
                IMetierImpt.departement = tableView.getItems().get(indice);

                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("professeursRelated.fxml"));

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Professeurs");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent e) {
                        tableView.getItems().clear();
                        IMetier metier = new IMetierImpt();
                        departements.addAll(metier.getAllDepartements());
                        id.setCellValueFactory(new PropertyValueFactory<>("id"));
                        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                        tableView.setItems(departements);
                    }
                });
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText(ex.getMessage());
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un élément ");
            alert.show();
        }
    }

    @FXML
    private void searchDep(KeyEvent event) {
        String keyWord = search.getText();
        tableView.getItems().clear();
        
        IMetier m = new IMetierImpt();
        departements.addAll(m.searchDep(keyWord));
        tableView.setItems(departements);
    }
    
}
