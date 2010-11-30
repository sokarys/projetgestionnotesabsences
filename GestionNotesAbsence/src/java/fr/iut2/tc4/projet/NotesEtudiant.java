/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet;

/**
 *
 * @author sokarys
 */
public class NotesEtudiant {
    private Note note;
    private Etudiant etudiant;

    public NotesEtudiant(Note note, Etudiant etudiant) {
        this.note = note;
        this.etudiant = etudiant;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }


}
