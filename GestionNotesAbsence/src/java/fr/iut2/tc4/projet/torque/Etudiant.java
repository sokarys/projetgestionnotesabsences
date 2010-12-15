package fr.iut2.tc4.projet.torque;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.torque.TorqueException;
import org.apache.torque.om.Persistent;

/**
 * Table des etudiant
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Wed Dec 15 08:50:33 CET 2010]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Etudiant
    extends fr.iut2.tc4.projet.torque.BaseEtudiant
    implements Persistent
{
    /** Serial version */
    private static final long serialVersionUID = 1292399433659L;

    public String getGroupe(){
        try {
            if (this.getClasses().size() > 0) {
                return ((fr.iut2.tc4.projet.torque.Classe) this.getClasses().get(0)).getNom();
            }
        } catch (TorqueException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public double getMoyenne(){
        try {
            double moy = 0.0;
            double coef = 0;
            List<Classe> clist = this.getClasses();
            for (Classe c : clist) {
                try {
                    System.out.println(c.getNom());
                    List<Controle> controleList = c.getMatiere().getControles();
                    for(Controle cont : controleList){
                        coef += cont.getCoef();
                        moy += cont.getNote().getNote()*coef;
                    }
                } catch (TorqueException ex) {
                    Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return moy/coef;
        } catch (TorqueException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }



}
