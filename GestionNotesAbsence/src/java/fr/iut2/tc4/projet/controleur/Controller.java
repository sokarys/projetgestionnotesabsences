/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.controleur;

/**
 *
 * @author sokarys
 */
import fr.iut2.tc4.projet.data.Absence;
import fr.iut2.tc4.projet.data.Etudiant;
import fr.iut2.tc4.projet.data.ListeEtudiant;
import fr.iut2.tc4.projet.data.Note;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

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
        private String urlViewAnEtudiant;


        private ListeEtudiant listeEtudiant;

        public Controller(){}
    @Override
    public void init() throws ServletException {

        listeEtudiant = new ListeEtudiant();
        
        listeEtudiant.getListe().add(new Etudiant(0,"kikoo0","non","3IS"));
        listeEtudiant.getListe().add(new Etudiant(1,"kikoo1","non","3IS"));
        listeEtudiant.getListe().add(new Etudiant(2,"kikoo2","non","3IS"));
        Note n = new Note(12,"ENV1");
        Absence a = new Absence(new GregorianCalendar(),"Neige");
        listeEtudiant.getListe().get(0).addnote(n);
        listeEtudiant.getListe().get(1).addnote(n);
        listeEtudiant.getListe().get(2).addnote(n);
        listeEtudiant.getListe().get(1).addnote(n);
        listeEtudiant.getListe().get(0).addAbsence(a);
        listeEtudiant.getListe().get(1).addAbsence(a);
        listeEtudiant.getListe().get(2).addAbsence(a);
        listeEtudiant.getListe().get(1).addAbsence(a);
        urlViewEtudiant = getServletConfig().getInitParameter("urlViewEtudiant");
        urlViewAnEtudiant = getServletConfig().getInitParameter("urlViewAnEtudiant");
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
                        doAddedEtudiant(request, response);

		}else if (methode.equals("post") && action.equals("/addedAbsenceEtudiant")) {
                        doAddedAbsenceEtudiant(request, response);

		}else if (methode.equals("post") && action.equals("/addedNoteEtudiant")) {
                        doAddedNotesEtudiant(request, response);

		}else if (methode.equals("get") && action.equals("/viewAllNotes")) {
                        doViewAllNotes(request, response);
		}else if (methode.equals("get") && action.equals("/viewAnEtudiant")) {
                        doViewAnEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/addAbsenceEtudiant")) {
                        doAddAbsenceEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/addNoteEtudiant")) {
                        doAddNoteEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/doDellEtudiant")) {
                        doDellEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/doDellNoteEtudiant")) {
                        doDellNoteEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/doDellAbsenceEtudiant")) {
                        doDellAbsenceEtudiant(request, response);
		}else {
                    
                    doEtudiant(request, response);
                }

	}

	

        private void doEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             request.setAttribute("listeEtudiant", listeEtudiant);

            loadJSP(this.urlViewEtudiant, request, response);

        }
         private void doAddAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             int index = Integer.valueOf(request.getParameter("id"));
             request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
             loadJSP(this.urlAddAbsence, request, response);

        }
          private void doAddNoteEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             int index = Integer.valueOf(request.getParameter("id"));
             request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
             loadJSP(this.urlAddNote, request, response);

        }

        private void doViewAnEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             int index = Integer.valueOf(request.getParameter("id"));
             request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
             loadJSP(this.urlViewAnEtudiant, request, response);

        }
        
        private void doAddEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             request.setAttribute("addEtudiant", listeEtudiant);
             loadJSP(this.urlAddEtudiant, request, response);

        }
         private void doAddedEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
             listeEtudiant.getListe().add(new Etudiant(this.listeEtudiant.getListe().size(),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("groupe")) );
              request.setAttribute("listeEtudiant", listeEtudiant);
              
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               System.out.println(date);
               System.out.println(request.getAttributeNames().toString());
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              loadJSP(this.urlViewAllNotes, request, response);

        }

            private void doDellEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              Etudiant remove = listeEtudiant.getListe().remove(index);
              int i =0; // Mise ajour de l'id
              for(Etudiant e : listeEtudiant.getListe() ){
                  e.setId(i);
                  i++;
              }
              request.setAttribute("listeEtudiant", listeEtudiant);
              loadJSP(this.urlViewEtudiant, request, response);
            }
            
            private void doDellNoteEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int indexNote = Integer.valueOf(request.getParameter("idNote"));
              Note remove = listeEtudiant.getListe().get(index).getListNote().remove(indexNote);
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
              loadJSP(this.urlViewAnEtudiant, request, response);
            }

             private void doDellAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int indexAbsence = Integer.valueOf(request.getParameter("idAbsence"));
              listeEtudiant.getListe().get(index).getListAbsences().remove(indexAbsence);
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
              loadJSP(this.urlViewAnEtudiant, request, response);
            }

	

	public void loadJSP(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
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
