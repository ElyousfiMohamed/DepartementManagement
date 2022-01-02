/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SchoolManagementIMetier;

import java.util.List;
import persistantClasse.Departement;
import persistantClasse.Professeur;

/**
 *
 * @author ELYOUSFI
 */
public interface IMetier {

    void addProfesseur(Professeur p);
    List<Professeur> getAllProfesseurs();
    List<Professeur> getProfesseursByDepart(int id);
    void delProfesseur(int id);
    List<Professeur> searchProf(String keyWord);

    void addDepartement(Departement d);
    List<Departement> getAllDepartements();
    Departement getDepartementById(int id);
    void delDepartement(int id);
    List<Departement> searchDep(String keyWord);

}
