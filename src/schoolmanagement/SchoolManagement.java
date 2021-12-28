/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package schoolmanagement;

import SchoolManagementIMetier.IMetier;
import SchoolManagementIMetier.IMetierImpt;
import java.util.List;
import persistantClasse.Departement;
import persistantClasse.Professeur;

/**
 *
 * @author ELYOUSFI
 */
public class SchoolManagement {
    
    public static void main(String[] args) {
        IMetier metier=new IMetierImpt();
        
        Departement d1=new Departement(1,"math info");
        Departement d2=new Departement(2,"electrique");
        metier.addDepartement(d1);
        metier.addDepartement(d2);
        
        Professeur p1=new Professeur(1,"ELYOUSFI","Mohamed","G41384","N487 bloc W media","mail@mail.mail","0789756564","08/08/2018");
        Professeur p2=new Professeur(2,"ELYOUSFI","Oussama","G78785","N47 bloc S media","mail1@mail1.mail1","0889775864","09/09/2009");
        p1.setDepartement(d2);
        p2.setDepartement(d1);
        metier.addProfesseur(p1);
        metier.addProfesseur(p2);
        
    }
    
}
