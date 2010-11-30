/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.data;

import java.util.GregorianCalendar;

/**
 *
 * @author Michael
 */
public class Absence {
    private GregorianCalendar date;
    private String motif;

    public Absence(){
        
    }
            
    public Absence(GregorianCalendar date, String motif) {
        this.date = date;
        this.motif = motif;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }


}
