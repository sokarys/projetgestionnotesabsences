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
    private double note;
    private String matiere;
    private int id;

    public Note(){}
    public Note(int id, double note,String matiere) {
        this.id = id;
        this.note = note;
        this.matiere = matiere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public double getNote() {
        return note;
    }

     public String getStringNote() {
        return String.valueOf(note);
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    



}
