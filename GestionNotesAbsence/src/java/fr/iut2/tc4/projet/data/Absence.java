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
    private int id;

    public Absence(){
        
    }
            
    public Absence(int id, GregorianCalendar date, String motif) {
        this.id = id;
        this.date = date;
        this.motif = motif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
