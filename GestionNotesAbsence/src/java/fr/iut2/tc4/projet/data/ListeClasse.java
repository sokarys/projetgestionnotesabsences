/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.data;

import fr.iut2.tc4.projet.torque.Classe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olivier
 */
public class ListeClasse {
  private ArrayList<Classe> liste;

    public ListeClasse(){
        this.liste = new ArrayList<Classe>();
    }

     public ArrayList<Classe> getListe() {
        return liste;
    }

    public void setListe(List<Classe> liste){
            this.liste.clear();
            @SuppressWarnings("unchecked")
            boolean addAll = this.liste.addAll(liste);
    }
}
