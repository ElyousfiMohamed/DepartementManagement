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
    void addProfesseur(Professeur c);
    void delProfesseur(Professeur c);
    List<Professeur> getAllProfesseurs();
    void addProfToDepart();
    
    void addDepartement(Departement c);
    void delDepartement(Departement c);
    List<Departement> getAllDepartements();
}
