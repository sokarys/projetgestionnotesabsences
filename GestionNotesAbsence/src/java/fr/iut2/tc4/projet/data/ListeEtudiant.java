/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.data;

import fr.iut2.tc4.projet.torque.BaseEtudiantPeer;
import fr.iut2.tc4.projet.torque.Classe;
import fr.iut2.tc4.projet.torque.ClassePeer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;
import fr.iut2.tc4.projet.torque.Etudiant;

/**
 *
 * @author sokarys
 */
public class ListeEtudiant {
    public ArrayList<fr.iut2.tc4.projet.torque.Etudiant> liste;

    public ListeEtudiant() {
        this.liste = new ArrayList<Etudiant>();
    }

    public ArrayList<Etudiant> getListe() {
        return liste;
    }

    public ArrayList<Etudiant> getListe(String classe) throws TorqueException{
        ArrayList<Etudiant> l = new ArrayList<Etudiant>();
        for(Etudiant e : liste){
            if(e.getClasse().getNom().equals(classe)){
                l.add(e);
            }
        }
        return l;
    }

    /*public void setListe(ArrayList<Etudiant> liste) {
        this.liste = liste;
    }*/

    public void setListe(List<Etudiant> liste){
            this.liste.clear();
            @SuppressWarnings("unchecked")
            boolean addAll = this.liste.addAll(liste);
            System.out.print("tttt a ala acon " + this.getListe().size());
    }

    public ArrayList<String> getGroupes(){
        ArrayList<String> lg = new ArrayList<String>();
        try {
            List<Classe> l = ClassePeer.doSelect(new Criteria());
            for(Classe c : l){
                if (!lg.contains(c.getNom())) {
                    lg.add(c.getNom());
                }
            }
        } catch (TorqueException ex) {
            Logger.getLogger(ListeEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lg;
    }

    public Etudiant getEtudiantWithId(int index){
        for(Etudiant e : liste){
            if(e.getEtudiantId() == index){
                return e;
            }
        }
        return null;
    }

}
