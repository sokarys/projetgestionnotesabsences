/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.controleur;

/**
 *
 * @author sokarys
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import fr.iut2.tc4.jeumvc.data.Jeu;
//import fr.iut2.tc4.jeumvc.data.Resultat;

@SuppressWarnings("serial")
public class Controleur extends HttpServlet {

	private String urlJeu;
	private String urlResultat;

	// INIT
    @Override
	public void init() throws ServletException {
		urlJeu = getServletConfig().getInitParameter("urlJeu");
		urlResultat = getServletConfig().getInitParameter("urlResultat");
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
		if (action == null) {
			action = "/jeu";
			System.out.println("action == null");
		}
		System.out.println(action);

		// Exécution action
		if (methode.equals("get") && action.equals("/jeu")) {
			doJeu(request, response);

		} else if (methode.equals("post") && action.equals("/resultat")) {
			doResultat(request, response);

		} else {
			// Autres cas
			doJeu(request, response);
		}
	}

	//
	private void doJeu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		loadJSP(urlJeu, request, response);
	}

	//
	private void doResultat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

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

		loadJSP(urlResultat, request, response);*/
	}


	public void loadJSP(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}


}
