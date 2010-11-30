/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.controleur;

/**
 *
 * @author sokarys
 */
import fr.iut2.tc4.projet.data.Etudiant;
import fr.iut2.tc4.projet.data.ListeEtudiant;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import fr.iut2.tc4.jeumvc.data.Jeu;
//import fr.iut2.tc4.jeumvc.data.Resultat;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	private String urlViewEtudiant;
        private String urlAddEtudiant;
        private String urlAddNote;
        private String urlAddAbsence;
        private String urlViewAllAbsence;
        private String urlViewAllNotes;


        public static ListeEtudiant listeEtudiant;

        public Controller(){}
    @Override
    public void init() throws ServletException {

        listeEtudiant = new ListeEtudiant();
        Etudiant e = new Etudiant(0,"kikoo","non","3IS");
        listeEtudiant.getListe().add(e);
        listeEtudiant.getListe().add(e);
        listeEtudiant.getListe().add(e);
        urlViewEtudiant = getServletConfig().getInitParameter("urlViewEtudiant");
        urlAddEtudiant = getServletConfig().getInitParameter("urlAddEtudiant");
        urlAddNote = getServletConfig().getInitParameter("urlAddNote");
        urlAddAbsence = getServletConfig().getInitParameter("urlAddAbsence");
        urlViewAllAbsence = getServletConfig().getInitParameter("urlViewAllAbsence");
        urlViewAllNotes = getServletConfig().getInitParameter("urlViewAllNotes");

    }

	// POST
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// on passe la main au GET
		doGet(request, response);
	}

	// GET
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {


		// On récupère la méthode d'envoi de la requête
		String methode = request.getMethod().toLowerCase();

		// On récupère l'action à exécuter
		String action = request.getPathInfo();
                
               System.out.println("action == " + action + "   met == " + methode + "   " + request.getPathTranslated());
		if (action == null) {
			action = "/ViewEtudiant";
		}
		

		// Exécution action

		if (methode.equals("get") && action.equals("/addEtudiant")) {
			
                        System.out.print("Postttt");
                        doAddEtudiant(request, response);
                        
		}else if (methode.equals("post") && action.equals("/addedEtudiant")) {
                        System.out.print("Postttt");
                        doAddedEtudiant(request, response);

		}else {
                    
                    doEtudiant(request, response);
                }

	}

	

        private void doEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             request.setAttribute("listeEtudiant", Controller.listeEtudiant);

            loadJSP(this.urlViewEtudiant, request, response);

        }
        
        private void doAddEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             request.setAttribute("addEtudiant", Controller.listeEtudiant);
             loadJSP(this.urlAddEtudiant, request, response);

        }
         private void doAddedEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
             System.out.print(request.getParameter("etudiant"));
             Controller.listeEtudiant.getListe().add(new Etudiant(0,request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("groupe")) );
              request.setAttribute("listeEtudiant", Controller.listeEtudiant);
              
             loadJSP(this.urlViewEtudiant, request, response);

        }
	//
	private void doResultat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
                            System.out.print("passe ici");
		// Récupérer l'attribut resultat de la session
	/*	Resultat resultat = (Resultat)request.getSession().getAttribute("resultat");
		if (resultat == null) {
			resultat = new Resultat();
			request.getSession().setAttribute("resultat", resultat);
		}

		// Créer une objet de type jeu
		Jeu jeu = new Jeu();
		jeu.setMainJoueur(request.getParameter("mainJoueur"));

		// Traitement du résultat
		if (jeu.egalite()) {
			resultat.addEgalite();
		} else if (jeu.joueurGagne()) {
			resultat.addGagne();
		} else {
			resultat.addPerdu();
		}

		// Mettre l'objet jeu en attribut de requête
		request.setAttribute("jeu", jeu);
*/
		loadJSP(this.urlViewEtudiant, request, response);
	}


	public void loadJSP(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}

    public ListeEtudiant getListeEtudiant() {
        return listeEtudiant;
    }

    public void setListeEtudiant(ListeEtudiant listeEtudiant) {
        this.listeEtudiant = listeEtudiant;
    }

    public String getUrlAddAbsence() {
        return urlAddAbsence;
    }

    public void setUrlAddAbsence(String urlAddAbsence) {
        this.urlAddAbsence = urlAddAbsence;
    }

    public String getUrlAddEtudiant() {
        return urlAddEtudiant;
    }

    public void setUrlAddEtudiant(String urlAddEtudiant) {
        this.urlAddEtudiant = urlAddEtudiant;
    }

    public String getUrlAddNote() {
        return urlAddNote;
    }

    public void setUrlAddNote(String urlAddNote) {
        this.urlAddNote = urlAddNote;
    }

    public String getUrlViewAllAbsence() {
        return urlViewAllAbsence;
    }

    public void setUrlViewAllAbsence(String urlViewAllAbsence) {
        this.urlViewAllAbsence = urlViewAllAbsence;
    }

    public String getUrlViewAllNotes() {
        return urlViewAllNotes;
    }

    public void setUrlViewAllNotes(String urlViewAllNotes) {
        this.urlViewAllNotes = urlViewAllNotes;
    }

    public String getUrlViewEtudiant() {
        return urlViewEtudiant;
    }

    public void setUrlViewEtudiant(String urlViewEtudiant) {
        this.urlViewEtudiant = urlViewEtudiant;
    }



}
