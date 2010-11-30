/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.data;

import java.util.ArrayList;

/**
 *
 * @author sokarys
 */
public class ListeEtudiant {
    public ArrayList<Etudiant> liste;

    public ListeEtudiant() {
        this.liste = new ArrayList<Etudiant>();
    }

    public ArrayList<Etudiant> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Etudiant> liste) {
        this.liste = liste;
    }

}
