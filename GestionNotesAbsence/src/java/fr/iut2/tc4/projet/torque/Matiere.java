package fr.iut2.tc4.projet.torque;


import java.util.ArrayList;
import java.util.List;
import org.apache.torque.TorqueException;
import org.apache.torque.om.Persistent;

/**
 * Table des matieres
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Wed Dec 15 08:50:33 CET 2010]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Matiere
    extends fr.iut2.tc4.projet.torque.BaseMatiere
    implements Persistent
{
    /** Serial version */
    private static final long serialVersionUID = 1292399433659L;

    public boolean isInClasse(String classe) throws TorqueException{
        for(Cours c : (List<Cours>) this.getCourss()){
                if(c.getClasse().getNom().equals(classe)){
                    return true;
                }
        }
        return false;
    }

}
