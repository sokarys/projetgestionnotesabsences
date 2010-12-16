/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.data;

import fr.iut2.tc4.projet.torque.Controle;
import fr.iut2.tc4.projet.torque.Cours;
import fr.iut2.tc4.projet.torque.Matiere;
import java.util.ArrayList;
import java.util.List;
import org.apache.torque.TorqueException;

/**
 *
 * @author Olivier
 */
public class ListeControle {
    private ArrayList<Controle> liste;
    
    public ListeControle(){
        this.liste = new ArrayList<Controle>();
    }

     public ArrayList<Controle> getListe() {
        return liste;
    }

    public ArrayList<Controle> getListe(String classe) throws TorqueException {
        if(classe.equals("allgroupe")){ return liste; }
        ArrayList<Controle> l = new ArrayList<Controle>();
        for(Controle e : liste){
            if(e.getCours().getClasse().toString().equals(classe)){
                       l.add(e);
            }
        }
        return l;
    }

    public void setListe(List<Controle> liste){
            this.liste.clear();
            @SuppressWarnings("unchecked")
            boolean addAll = this.liste.addAll(liste);
    }

}
