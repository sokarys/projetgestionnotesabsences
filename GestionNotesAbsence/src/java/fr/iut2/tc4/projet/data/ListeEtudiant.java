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

    public ArrayList<Etudiant> getListe(String groupe) {
        ArrayList<Etudiant> l = new ArrayList<Etudiant>();
        for(Etudiant e : liste){
            if(e.getGroupe().equals(groupe)){
                l.add(e);
            }
        }
        return l;
    }

    public void setListe(ArrayList<Etudiant> liste) {
        this.liste = liste;
    }

    public ArrayList<String> getGroupes(){
        ArrayList<String> lg = new ArrayList<String>();
        for(Etudiant e : liste){
            if(!lg.contains(e.getGroupe())){
                lg.add(e.getGroupe());
            }
        }
        return lg;
    }

}
