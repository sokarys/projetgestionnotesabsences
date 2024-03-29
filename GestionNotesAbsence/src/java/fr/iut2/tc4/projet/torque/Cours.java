package fr.iut2.tc4.projet.torque;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.torque.TorqueException;
import org.apache.torque.om.Persistent;

/**
 * Table des cours
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Thu Dec 16 14:29:30 CET 2010]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Cours
    extends fr.iut2.tc4.projet.torque.BaseCours
    implements Persistent
{
    /** Serial version */
    private static final long serialVersionUID = 1292506170763L;
    public boolean isInTheseClass(String[] classe){
        for(int i=0; i<classe.length; i++){
            try {
                if (classe[i].equals(this.getClasse().getNom())) {
                    return true;
                }
            } catch (TorqueException ex) {
                Logger.getLogger(Cours.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
