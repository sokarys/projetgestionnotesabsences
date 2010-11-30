/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet;

import java.util.ArrayList;

/**
 *
 * @author sokarys
 */
public class ListeNotesEtudiants {
    private ArrayList<NotesEtudiant> liste;

    public ListeNotesEtudiants(){
        liste = new ArrayList<NotesEtudiant>();
    }

    public void addNoteEtudiant(Note n, Etudiant e){
        liste.add(new NotesEtudiant(n,e));
    }

     public void addNoteEtudiant(NotesEtudiant n){
        liste.add(n);
    }

     public NotesEtudiant getNoteEtudiant(int index){
         return liste.get(index);
     }

     public ArrayList<Etudiant> getEtudiantHaveNoteJustNote(int note){
         ArrayList<Etudiant> listEtu = new ArrayList<Etudiant>();
         for(NotesEtudiant e : liste){
             if(e.getNote().getNote() == note){
                 listEtu.add(e.getEtudiant());
             }
         }
         return listEtu;
     }

     public ArrayList<Etudiant> getEtudiantHaveMatiereJustMatiere(String matiere){
         ArrayList<Etudiant> listEtu = new ArrayList<Etudiant>();
         for(NotesEtudiant e : liste){
             if(e.getNote().getMatiere().toUpperCase().equals(matiere.toUpperCase())){
                 listEtu.add(e.getEtudiant());
             }
         }
         return listEtu;
     }

     public ArrayList<Etudiant> getEtudiantHaveNote(int note, String matiere){
         ArrayList<Etudiant> listEtu = new ArrayList<Etudiant>();
         for(NotesEtudiant e : liste){
             if(e.getNote().getMatiere().toUpperCase().equals(matiere.toUpperCase()) && e.getNote().getNote() == note){
                 listEtu.add(e.getEtudiant());
             }
         }
         return listEtu;
     }

     public ArrayList<Etudiant> getEtudiantHaveNote(Note n){
         ArrayList<Etudiant> listEtu = new ArrayList<Etudiant>();
         for(NotesEtudiant e : liste){
             if(e.getNote().getMatiere().toUpperCase().equals(n.getMatiere().toUpperCase()) && e.getNote().getNote() == n.getNote()){
                 listEtu.add(e.getEtudiant());
             }
         }
         return listEtu;
     }
}
