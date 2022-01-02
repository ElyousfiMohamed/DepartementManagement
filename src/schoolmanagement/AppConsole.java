/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanagement;

import SchoolManagementIMetier.*;
import persistantClasse.*;

/**
 *
 * @author ELYOUSFI
 */
public class AppConsole {
    public static void main(String[] args) {
        IMetier metier = new IMetierImpt();
        
        Departement d1 = new Departement("Departement Génie Mécanique");
        Departement d2 = new Departement("Departement Génie Electrique");
        
        metier.addDepartement(d1);
        metier.addDepartement(d2);
        
        metier.getAllDepartements().forEach(d -> {
            System.out.println(d);
        });
        
        Professeur p1 = new Professeur("ELYOUSFI", "Mohamed", "S248796", "Rue x Numero y Bloc z", "mohamed@contact.me", 
                                       "+212658974587", "08/12/2008");
        Professeur p2 = new Professeur("TAIFAOUI", "Abdellah", "Q879797", "Rue a Numero b Bloc c", "abdellah@contact.me", 
                                       "+212658749685", "15/02/2020");
        
        metier.addProfesseur(p1);
        metier.addProfesseur(p2);
        
        metier.getAllProfesseurs().forEach(p -> {
            System.out.println(p);
        });
        
    }
}
