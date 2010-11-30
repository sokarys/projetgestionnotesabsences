package fr.iut2.tc4.projet;

public class Etudiant {
	
	private Integer id;
	private String prenom;
	private String nom;
        private String groupe;
	
	public Etudiant() {
		super();
	}
	
	public Etudiant(Integer id, String prenom, String nom, String groupe) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;		
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
