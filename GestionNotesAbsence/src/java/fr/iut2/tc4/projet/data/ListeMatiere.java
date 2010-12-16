/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.data;

import fr.iut2.tc4.projet.torque.Cours;
import fr.iut2.tc4.projet.torque.Matiere;
import java.util.ArrayList;
import java.util.List;
import org.apache.torque.TorqueException;

/**
 *
 * @author Olivier
 */
public class ListeMatiere {
    private ArrayList<Matiere> liste;
    
    public ListeMatiere(){
        this.liste = new ArrayList<Matiere>();
    }

     public ArrayList<Matiere> getListe() {
        return liste;
    }

    public ArrayList<Matiere> getListe(String classe) throws TorqueException {
        ArrayList<Matiere> l = new ArrayList<Matiere>();
        for(Matiere e : liste){
            List<Cours> lc = e.getCourss();
            for(Cours c : lc){
                   if(c.getClasse().toString().equals(classe) || classe.equals("allgroupe")){
                       l.add(e);
                   }
            }
        }
        return l;
    }

    public void setListe(List<Matiere> liste){
            this.liste.clear();
            @SuppressWarnings("unchecked")
            boolean addAll = this.liste.addAll(liste);
            System.out.print("tttt a ala acon " + this.getListe().size());
    }

}
