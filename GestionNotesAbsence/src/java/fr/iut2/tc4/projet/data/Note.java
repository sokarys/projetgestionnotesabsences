/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.data;

/**
 *
 * @author sokarys
 */
public class Note {
    private int note;
    private String matiere;

    public Note(){}
    public Note(int note) {
        this.note = note;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    



}
