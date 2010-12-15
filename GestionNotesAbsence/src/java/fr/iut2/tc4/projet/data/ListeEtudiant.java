/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.data;

import fr.iut2.tc4.projet.torque.BaseEtudiantPeer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

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

    public void setListe(List liste){
        try {
            List l = BaseEtudiantPeer.doSelect(new Criteria());
            @SuppressWarnings("unchecked")
            boolean addAll = liste.addAll(l);
        } catch (TorqueException ex) {
            Logger.getLogger(ListeEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
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
