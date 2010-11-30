package fr.iut2.tc4.projet;

import java.util.ArrayList;

public class Etudiant {
	
	private Integer id;
	private String prenom;
	private String nom;
	private ArrayList<Absence> listAbsences;
        private ArrayList<Note> listNote;
	private String groupe;
	
	public Etudiant() {
		super();
	}
	
	public Etudiant(Integer id, String prenom, String nom, String groupe) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.listAbsences = new ArrayList<Absence>();
                this.listNote = new ArrayList<Note>();
		this.groupe = groupe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getNbAbsences() {
		return this.listAbsences.size();
	}

        public Absence getAbsence(int index){
            return this.listAbsences.get(index);
        }
        public void addAbsence(Absence a){
            this.listAbsences.add(a);
        }

        public int getNbNote() {
		return this.listNote.size();
	}

        public Note getNote(int index){
            return this.listNote.get(index);
        }
        public void addnote(Note n){
            this.listNote.add(n);
        }

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

        @Override
        public String toString() {
            return nom+" "+prenom+" "+groupe+"\n";
        }

        
}
