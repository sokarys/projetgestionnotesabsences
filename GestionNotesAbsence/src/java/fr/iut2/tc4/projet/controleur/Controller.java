/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.iut2.tc4.projet.controleur;

/**
 *
 * @author sokarys
 */

import fr.iut2.tc4.projet.data.ListeClasse;
import fr.iut2.tc4.projet.data.ListeControle;
import fr.iut2.tc4.projet.data.ListeEtudiant;
import fr.iut2.tc4.projet.data.ListeMatiere;
import fr.iut2.tc4.projet.torque.Absence;
import fr.iut2.tc4.projet.torque.AbsencePeer;
import fr.iut2.tc4.projet.torque.BaseEtudiantPeer;
import fr.iut2.tc4.projet.torque.Classe;
import fr.iut2.tc4.projet.torque.ClassePeer;
import fr.iut2.tc4.projet.torque.Controle;
import fr.iut2.tc4.projet.torque.ControlePeer;
import fr.iut2.tc4.projet.torque.Cours;
import fr.iut2.tc4.projet.torque.CoursPeer;
import fr.iut2.tc4.projet.torque.Etudiant;
import fr.iut2.tc4.projet.torque.EtudiantPeer;
import fr.iut2.tc4.projet.torque.Matiere;
import fr.iut2.tc4.projet.torque.MatierePeer;
import fr.iut2.tc4.projet.torque.Note;
import fr.iut2.tc4.projet.torque.NotePeer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

//import fr.iut2.tc4.jeumvc.data.Jeu;
//import fr.iut2.tc4.jeumvc.data.Resultat;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	private String urlViewEtudiant;
        private String urlAddEtudiant;
        private String urlAddNote;
        private String urlAddClasse;
        private String urlAddAbsence;
        private String urlModifAnEtudiant;
        private String urlModifNote;
        private String urlModifAllAbsence;
        private String urlViewAllAbsence;
        private String urlViewAllNotes;
        private String urlViewAnEtudiant;
        private String urlViewAllMatiere;
        private String urlViewAllControle;
        private String urlViewAnControle;
        private String urlModifAnControle;
        private String urlAddAbsenceEtudiant;
        private String urlModifAllMatiere;
        private String urlAddControle;
    private String urlAddControleMatiere;


 
       

    public Controller(){}

    @Override
    public void init() throws ServletException {
            urlViewEtudiant = getServletConfig().getInitParameter("urlViewEtudiant");
            urlViewAnEtudiant = getServletConfig().getInitParameter("urlViewAnEtudiant");
            urlAddEtudiant = getServletConfig().getInitParameter("urlAddEtudiant");
            urlAddNote = getServletConfig().getInitParameter("urlAddNote");
            urlAddAbsence = getServletConfig().getInitParameter("urlAddAbsence");
            urlViewAllAbsence = getServletConfig().getInitParameter("urlViewAllAbsence");
            urlViewAllMatiere = getServletConfig().getInitParameter("urlViewAllMatiere");
            urlModifAnEtudiant = getServletConfig().getInitParameter("urlModifAnEtudiant");
            urlModifNote = getServletConfig().getInitParameter("urlModifNoteEtudiant");
            urlModifAllAbsence = getServletConfig().getInitParameter("urlModifAllAbsence");
            urlViewAllControle = getServletConfig().getInitParameter("urlViewAllControle");
            urlViewAnControle =  getServletConfig().getInitParameter("urlViewAnControle");
            urlModifAnControle =  getServletConfig().getInitParameter("urlModifAnControle");
            urlAddAbsenceEtudiant = getServletConfig().getInitParameter("urlAddAbsenceEtudiant");
            urlModifAllMatiere = getServletConfig().getInitParameter("urlModifAllMatiere");
            urlAddClasse = getServletConfig().getInitParameter("urlAddClasse");
            urlAddControle = getServletConfig().getInitParameter("urlAddControle");
            urlAddControleMatiere = getServletConfig().getInitParameter("urlAddControleMatiere");
 
    }

    private ListeMatiere getListeMatiere(){
        ListeMatiere m = new ListeMatiere();
        try {
                m.setListe((List<Matiere>) MatierePeer.doSelect(new Criteria()));
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        return m;
    }

    private ListeControle getListeControle(){
        ListeControle c = new ListeControle();
        try {
                c.setListe((List<Controle>) ControlePeer.doSelect(new Criteria()));
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        return c;
    }

     private ListeEtudiant getListeEtudiant(){
        ListeEtudiant l = new ListeEtudiant();
        try {
                l.setListe(EtudiantPeer.doSelect(new Criteria()));
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        return l;
    }

     private ListeClasse getListeClasse(){
        ListeClasse l = new ListeClasse();
        try {
                l.setListe(ClassePeer.doSelect(new Criteria()));
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        return l;
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

	/*	else if (methode.equals("post") && action.equals("/addedAbsenceEtudiant")) {
                        doAddedAbsenceEtudiant(request, response);
		}else if (methode.equals("post") && action.equals("/addedNoteEtudiant")) {
                        doAddedNotesEtudiant(request, response);

		}else if (methode.equals("get") && action.equals("/viewAllNotes")) {
                        doViewAllNotes(request, response);
		}else*/ if (methode.equals("get") && action.equals("/viewAllAbsence")) {
                        doViewAllAbsence(request, response);
		}else if (methode.equals("get") && action.equals("/viewAnEtudiant")) {
                        doViewAnEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/modifAnEtudiant")) {
                        doModifAnEtudiant(request, response);
		}else if (methode.equals("post") && action.equals("/modifiedAnEtudiant")) {
                        doModifiedAnEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/viewAllMatiere")) {
                        doViewAllMatiere(request, response);
		}else if (methode.equals("get") && action.equals("/viewAllControle")) {
                        doViewAllControle(request, response);
		}else if (methode.equals("get") && action.equals("/viewAnControle")) {
                        doViewAnControle(request, response);
		}else if (methode.equals("get") && action.equals("/modifAnControle")) {
                        doModifAnControle(request, response);
		}else if (methode.equals("post") && action.equals("/modifiedAnControle")) {
                        doModifiedAnControle(request, response);
		}else if (methode.equals("get") && action.equals("/addAbsence")) {
                        doAddAbsence(request, response);
		}else if (methode.equals("post") && action.equals("/addedAbsence")) {
                        doAddedAbsence(request, response);
		}else if (methode.equals("get") && action.equals("/dellAbsenceEtudiant")) { //
                        doDellAbsenceEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/dellAbsence")) {
                        doDellAbsence(request, response);
		}else if (methode.equals("post") && action.equals("/modifiedAllAbsences")) {
                        doModifiedAllAbsence(request, response);
		}else if (methode.equals("get") && action.equals("/modifAllAbsences")) {
                        doModifAllAbsence(request, response);
		}else if (methode.equals("get") && action.equals("/addAbsenceEtudiant")) {
                        doAddAbsenceEtudiant(request, response);
		}else if (methode.equals("post") && action.equals("/addedAbsenceEtudiant")) {
                        doAddedAbsenceEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/dellAnEtudiant")) {
                        doDellAnEtudiant(request, response);
		}else if (methode.equals("post") && action.equals("/addedAnEtudiant")) {
                        doAddedEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/addAnEtudiant")) {
                        doAddAnEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/modifAllMatiere")) {
                        doModifAllMatiere(request, response);
		}else if (methode.equals("post") && action.equals("/modifiedAllMatiere")) {
                        doModifiedAllMatiere(request, response);
		}else if (methode.equals("post") && action.equals("/addedClasse")) {
                        doAddedClasse(request, response);
		}else if (methode.equals("post") && action.equals("/addControleMatiere")) {
                        doAddControleMatiere(request, response);
                }else if (methode.equals("get") && action.equals("/addControle")) {
                        doAddControle(request, response);
                }else if (methode.equals("post") && action.equals("/addedControle")) {
                        doAddedControle(request, response);
                }
            /*else if (methode.equals("post") && action.equals("/modifiedNoteEtudiant")) {
                        doModifiedNoteEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/modifAbsenceEtudiant")) {
                        doModifAbsenceEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/modifEtudiant")) {
                        doModifEtudiant(request, response);
		}else if (methode.equals("get") && action.equals("/modifNoteEtudiant")) {
                        doModifNoteEtudiant(request, response);
		}else if (methode.equals("post") && action.equals("/modifiedEtudiant")) {
                        doModifiedEtudiant(request, response);
		}else */else{

                    doEtudiant(request, response);
                }

	}

     private void doAddControleMatiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                request.setAttribute("date", request.getParameter("date"));
                request.setAttribute("coef", request.getParameter("coef"));
                request.setAttribute("matiere", MatierePeer.retrieveByPK(Integer.valueOf(request.getParameter("idMatiere"))));
                loadJSP(this.urlAddControleMatiere, request, response);
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        private void doAddControle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setAttribute("listeMatiere",getListeMatiere());
          loadJSP(this.urlAddControle, request, response);
        }

         private void doAddedControle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             try {
                Matiere m= MatierePeer.retrieveByPK(Integer.valueOf(request.getParameter("idMatiere")));
                Controle c = new Controle();
                Cours cour =(Cours)m.getCourss().get(0);
                c.setCoursId(cour.getCoursId());
                c.setCoef(Integer.valueOf(request.getParameter("coef")));
                c.setDate(request.getParameter("date"));
                c.save();
                for(Cours unCours : (List<Cours>) m.getCourss()){
                     for(Etudiant e : (List<Etudiant>) unCours.getClasse().getEtudiants()){
                         Note n = new Note();
                         n.setNote(Integer.valueOf(request.getParameter(String.valueOf(e.getEtudiantId()))));
                         n.setEtudiantId(e.getEtudiantId());
                         n.setControleId(c.getControleId());
                         n.save();
                     }
                 }
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

             request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewAllControle, request, response);
        }



        private void doEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
         if (request.getParameter("groupe") == null) {
                    request.setAttribute("groupe", "allgroupe");
                    request.setAttribute("listeEtudiant", getListeEtudiant());
                } else {

                    try {
                    String gp = request.getParameter("groupe");
                    request.setAttribute("groupe",gp );
                    ListeEtudiant le = new ListeEtudiant();
                     le.setListe(getListeEtudiant().getListe(gp));
                     request.setAttribute("listeEtudiant", le);
                     } catch (TorqueException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            loadJSP(this.urlViewEtudiant, request, response);

        }

        private void doDellAnEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //request.setAttribute("etudiant",request.getAttribute("name"));
            int index = Integer.valueOf(request.getParameter("id"));
            Criteria cnote = new Criteria();
            cnote.add(NotePeer.ETUDIANT_ID, index);
            NotePeer.doDelete(cnote);
            Criteria cabs = new Criteria();
            cabs.add(AbsencePeer.ETUDIANT_ID, index);
            AbsencePeer.doDelete(cabs);
            Criteria ce = new Criteria();
            ce.add(EtudiantPeer.ETUDIANT_ID, index);
            EtudiantPeer.doDelete(ce);

            doEtudiant(request,response);
        } catch (TorqueException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        }


         private void doAddAbsence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));

             if (request.getParameter("groupe") == null) {
                    request.setAttribute("groupe", "allgroupe");
                    request.setAttribute("listeEtudiant", getListeEtudiant());
                } else {

                    try {
                    String gp = request.getParameter("groupe");
                    request.setAttribute("groupe",gp );
                    ListeEtudiant le = new ListeEtudiant();
                     le.setListe(getListeEtudiant().getListe(gp));
                     request.setAttribute("listeEtudiant", le);
                     } catch (TorqueException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            loadJSP(this.urlAddAbsence, request, response);

        }
         /*
          private void doAddNoteEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             int index = Integer.valueOf(request.getParameter("id"));
             request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
             loadJSP(this.urlAddNote, request, response);

        }

       */
         private void doAddedAbsence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //request.setAttribute("etudiant",request.getAttribute("name"));
            //response.
            int index = Integer.valueOf(request.getParameter("id"));
            String date = request.getParameter("dateDeb");
            String dateFin = request.getParameter("dateFin");
            String motif = request.getParameter("motif");
            Absence a = new Absence();
            a.setEtudiantId(index);
            a.setMotif(motif);
            a.setDatedebut(date);
            a.setDatefin(dateFin);
            a.save();
            
            doViewAnEtudiant(request,response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
         
         private void doViewAnEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             int index = Integer.valueOf(request.getParameter("id"));
             request.setAttribute("etudiant", getListeEtudiant().getEtudiantWithId(index));
             loadJSP(this.urlViewAnEtudiant, request, response);

        }

        private void doModifAnEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             int index = Integer.valueOf(request.getParameter("id"));
             request.setAttribute("etudiant", getListeEtudiant().getEtudiantWithId(index));
             request.setAttribute("listeClasse", getListeClasse());
             loadJSP(this.urlModifAnEtudiant, request, response);

        }

        private void doModifiedAnEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //request.setAttribute("etudiant",request.getAttribute("name"));
            int index = Integer.valueOf(request.getParameter("id"));
            String name = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            int classe = Integer.valueOf(request.getParameter("classe"));
            Etudiant e = this.getListeEtudiant().getEtudiantWithId(index);
            //Modfi etudiant
            e.setNom(name);
            e.setPrenom(prenom);
            try {
                e.setClasseId(classe);
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            e.save();
            //Modif Note ETu
            Criteria c = new Criteria();
            c.add(NotePeer.ETUDIANT_ID, index);
            List<Note> ln = NotePeer.doSelect(c);
            for (Note n : ln) {
                n.setNote(Integer.valueOf(request.getParameter(n.getNoteId() + "_note")));
                n.save();
              }
            //Modif Abs Etu
            Criteria c2 = new Criteria();
            c2.add(AbsencePeer.ETUDIANT_ID,index);
            List<Absence> la = AbsencePeer.doSelect(c2);
            for(Absence a : la){
                a.setMotif(request.getParameter(a.getAbsenceId() + "_absM"));
                a.setDatedebut(request.getParameter(a.getAbsenceId() + "_absDb"));
                a.setDatefin(request.getParameter(a.getAbsenceId() + "_absDf"));
                a.save();
            }

            doViewAnEtudiant(request, response);
        }catch (TorqueException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 

        }
       private void doAddedClasse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Classe c = new Classe();
            c.setNom(request.getParameter("nom"));
            c.save();
            loadJSP(this.urlViewEtudiant, request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       private void doViewAnControle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             int index = Integer.valueOf(request.getParameter("id"));

             Criteria n = new Criteria();
             n.add(ControlePeer.CONTROLE_ID, index);
             List<Controle> controle;
            try {
                controle = ControlePeer.doSelect(n);
                request.setAttribute("controle", controle.get(0));
                loadJSP(this.urlViewAnControle, request, response);
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void doAddAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

             int index = Integer.valueOf(request.getParameter("id"));
             request.setAttribute("etudiant", this.getListeEtudiant().getEtudiantWithId(index));
             loadJSP(this.urlAddAbsenceEtudiant, request, response);
        }

         private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int index = Integer.valueOf(request.getParameter("id"));
            String dateDeb = request.getParameter("dateDeb");
            String dateFin = request.getParameter("dateFin");
            String motif = request.getParameter("motif");
            request.setAttribute("etudiant", this.getListeEtudiant().getEtudiantWithId(index));
            Absence a = new Absence();
            try {
                a.setEtudiantId(index);
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            a.setMotif(motif);
            a.setDatedebut(dateDeb);
            a.setDatefin(dateFin);
            a.save();
            doViewAnEtudiant(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }

        private void doModifAnControle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             int index = Integer.valueOf(request.getParameter("id"));
             Criteria n = new Criteria();
             n.add(ControlePeer.CONTROLE_ID, index);
             List<Controle> controle;
            try {
                controle = ControlePeer.doSelect(n);
                request.setAttribute("controle", controle.get(0));
                loadJSP(this.urlModifAnControle, request, response);
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }


        }

         private void doModifiedAnControle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             int index = Integer.valueOf(request.getParameter("id"));
             Criteria n = new Criteria();
             n.add(ControlePeer.CONTROLE_ID, index);
             List<Controle> controle;
                try {
                    controle = ControlePeer.doSelect(n);
                    Controle c = (Controle) controle.get(0);
                    c.setCoef(Integer.valueOf(request.getParameter("coef")));
                    c.setDate(request.getParameter("date"));
                    c.save();
                    List<Note> ln = c.getNotes();
                    for(Note note : ln){
                        int noteEtudiant = Integer.valueOf(request.getParameter(String.valueOf(note.getEtudiantId())));
                        note.setNote(noteEtudiant);
                        note.save();
                    }
                    
                    request.setAttribute("controle", controle.get(0));
                    loadJSP(this.urlViewAnControle, request, response);
                } catch (Exception ex) {
                   Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
        }


        private void doViewAllControle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));

           request.setAttribute("listeEtudiant", getListeEtudiant());

            if (request.getParameter("groupe") == null) {
                request.setAttribute("groupe", "allgroupe");
                request.setAttribute("listeControle", getListeControle());
            } else {
            try {
                String gp = request.getParameter("groupe");
                request.setAttribute("groupe", gp);
                ListeControle m = new ListeControle();
                m.setListe(getListeControle().getListe(gp));
                request.setAttribute("listeControle", m);
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
             loadJSP(this.urlViewAllControle, request, response);

        }

       private void doViewAllMatiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setAttribute("listeEtudiant", getListeEtudiant());
            if (request.getParameter("groupe") == null) {
                request.setAttribute("groupe", "allgroupe");
                request.setAttribute("listeMatiere", getListeMatiere());
            } else {
            try {
                String gp = request.getParameter("groupe");
                request.setAttribute("groupe", gp);
                ListeMatiere m = new ListeMatiere();
                m.setListe(getListeMatiere().getListe(gp));
                request.setAttribute("listeMatiere", m);
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
             loadJSP(this.urlViewAllMatiere, request, response);

        }

        private void doModifAllMatiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setAttribute("listeEtudiant", getListeEtudiant());
           request.setAttribute("listeClasse", this.getListeClasse());
            if (request.getParameter("groupe") == null) {
                request.setAttribute("groupe", "allgroupe");
                request.setAttribute("listeMatiere", getListeMatiere());
            } else {
            try {
                String gp = request.getParameter("groupe");
                request.setAttribute("groupe", gp);
                ListeMatiere m = new ListeMatiere();
                m.setListe(getListeMatiere().getListe(gp));
                request.setAttribute("listeMatiere", m);
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
             loadJSP(this.urlModifAllMatiere, request, response);

        }

        private void doModifiedAllMatiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Matiere> lm = (List<Matiere>) MatierePeer.doSelect(new Criteria());
            for(Matiere m : lm){
                m.setNom(request.getParameter(m.getMatiereId() + "_name"));
                m.setProf(request.getParameter(m.getMatiereId() + "_prof"));
                m.setDescription(request.getParameter(m.getMatiereId() + "_descrip"));
               /* String[] lc = request.getParameterValues(m.getMatiereId() + "_classe");
                Criteria cm = new Criteria();
                cm.add(CoursPeer.MATIERE_ID,m.getMatiereId());
                List<Cours> listC = CoursPeer.doSelect(cm);
                ArrayList<Cours> notIn = new ArrayList<Cours>();
                ArrayList<Cours> isIn = new ArrayList<Cours>();
               for(Cours c : listC){
                  if(!c.isInTheseClass(lc)){
                      notIn.add(c);
                  }else{
                      isIn.add(c);
                  }
               }
               for(Cours c : notIn){
                   Criteria isinbd = new Criteria();
                   isinbd.add(CoursPeer.CLASSE_ID,c.getClasseId());
                   isinbd.add(CoursPeer.MATIERE_ID,m.getMatiereId());
                   List<Cours> aDell = CoursPeer.doSelect(isinbd);
                   if(aDell.size()>0){
                       for(Cours del : aDell){
                           Criteria i = new Criteria(); i.add(ControlePeer.COURS_ID,del.getCoursId());
                           ControlePeer.doDelete(i);
                           CoursPeer.doDelete(del);
                       }
                   }else{
                        Cours nc = new Cours();
                        nc.setMatiere(m);
                        nc.setClasseId(c.getClasseId());
                        nc.save();
                   }
               }*/
            }
            doViewAllMatiere(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 

        }

       

        private void doAddAnEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             request.setAttribute("listeClasse", this.getListeClasse());
             loadJSP(this.urlAddEtudiant, request, response);

        }
        
         private void doAddedEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
             try {
                 Etudiant e = new Etudiant();
                 e.setNom(request.getParameter("nom"));
                 e.setPrenom(request.getParameter("prenom"));
                e.setClasseId(Integer.valueOf(request.getParameter("classe")));
                e.save();
            } catch (TorqueException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             request.setAttribute("listeEtudiant", this.getListeEtudiant());
             request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }/*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          *//*

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
               request.setAttribute("groupe", "allgroupe");
             loadJSP(this.urlViewEtudiant, request, response);

        }
          private void doAddedNotesEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int note = Integer.valueOf(request.getParameter("note"));
              String matiere = request.getParameter("matiere");

              listeEtudiant.getListe().get(index).addnote(new Note(listeEtudiant.getListe().get(index).getNbNote(),note,matiere));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

             loadJSP(this.urlViewAnEtudiant, request, response);

        }
           private void doAddedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
               int index = Integer.valueOf(request.getParameter("id"));
               String date = request.getParameter("date");
               String motif = request.getParameter("motif");
               GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));
               Absence a = new Absence(listeEtudiant.getListe().get(index).getListAbsences().size(),gc,motif);
              listeEtudiant.getListe().get(index).addAbsence(a);
              //.addAbsence(new Absence(new GregorianCalendar(request.getAttribute("date"),request.getAttribute("motif"))));
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));

              loadJSP(this.urlViewAnEtudiant, request, response);

        }
          private void doViewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              request.setAttribute("listeEtudiant", listeEtudiant);
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                 }else{
                     request.setAttribute("groupe", request.getParameter("groupe"));
                }
              loadJSP(this.urlViewAllNotes, request, response);

        }

          */ private void doViewAllAbsence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                request.setAttribute("listeEtudiant", getListeEtudiant());
                 }else{
                    try {
                        String gp = request.getParameter("groupe");
                        request.setAttribute("groupe", gp);
                        ListeEtudiant le = new ListeEtudiant();
                        le.setListe(getListeEtudiant().getListe(gp));
                        request.setAttribute("listeEtudiant", le);
                    } catch (TorqueException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
              loadJSP(this.urlViewAllAbsence, request, response);

        }

          private void doModifAllAbsence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              if( request.getParameter("groupe") == null){
                request.setAttribute("groupe", "allgroupe");
                request.setAttribute("listeEtudiant", getListeEtudiant());
                 }else{
                    try {
                        String gp = request.getParameter("groupe");
                        request.setAttribute("groupe", gp);
                        ListeEtudiant le = new ListeEtudiant();
                        le.setListe(getListeEtudiant().getListe(gp));
                        request.setAttribute("listeEtudiant", le);
                    } catch (TorqueException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
              loadJSP(this.urlModifAllAbsence, request, response);

        }

          private void doModifiedAllAbsence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                List<Absence> la = AbsencePeer.doSelect(new Criteria());
                for(Absence a : la){
                    String db = request.getParameter(a.getAbsenceId()+"_db");
                    String df = request.getParameter(a.getAbsenceId()+"_df");
                    String m = request.getParameter(a.getAbsenceId()+"_m");
                    a.setDatedebut(db);
                    a.setDatefin(df);
                    a.setMotif(m);
                    a.save();
                }

            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            doViewAllAbsence(request,response);

        }
          
/*
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
               request.setAttribute("groupe", "allgroupe");
              loadJSP(this.urlViewEtudiant, request, response);
            }

            private void doDellNoteEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.
              int index = Integer.valueOf(request.getParameter("id"));
              int indexNote = Integer.valueOf(request.getParameter("idNote"));
              if(indexNote < listeEtudiant.getListe().get(index).getListNote().size()){
                  Note remove = listeEtudiant.getListe().get(index).getListNote().remove(indexNote);
                  for(int i=0; i<listeEtudiant.getListe().get(index).getNbNote(); i++){
                      listeEtudiant.getListe().get(index).getListNote().get(i).setId(i);
                  }
              }
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
              loadJSP(this.urlViewAnEtudiant, request, response);
            }

             */


           private void doDellAbsence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

              int index = Integer.valueOf(request.getParameter("id"));
              int indexAbsence = Integer.valueOf(request.getParameter("idAbsence"));

              Etudiant e = this.getListeEtudiant().getEtudiantWithId(index);
              Criteria c = new Criteria();
              c.add(AbsencePeer.ABSENCE_ID,indexAbsence );
                try {
                    AbsencePeer.doDelete(c);
                } catch (TorqueException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

                 doViewAllAbsence(request,response);
            }

           private void doDellAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

              int index = Integer.valueOf(request.getParameter("id"));
              int indexAbsence = Integer.valueOf(request.getParameter("idAbsence"));

              Etudiant e = this.getListeEtudiant().getEtudiantWithId(index);
              Criteria c = new Criteria();
              c.add(AbsencePeer.ABSENCE_ID,indexAbsence );
                try {
                    AbsencePeer.doDelete(c);
                } catch (TorqueException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

                 doViewAnEtudiant(request,response);
            }
             /*

           private void doModifiedAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));

              int index = Integer.valueOf(request.getParameter("id"));
              int indexAbsence = Integer.valueOf(request.getParameter("idAbsence"));

             String date = request.getParameter("date");
               String motif = request.getParameter("motif");

              //listeEtudiant.getListe().get(index).getListAbsences().remove(indexAbsence);
             GregorianCalendar gc = new GregorianCalendar();
               gc.set(Integer.valueOf(date.split("/")[2]), Integer.valueOf(date.split("/")[1])-1, Integer.valueOf(date.split("/")[0]));

               listeEtudiant.getListe().get(index).getAbsence(indexAbsence).setDate(gc);
               listeEtudiant.getListe().get(index).getAbsence(indexAbsence).setMotif(motif);
              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
              loadJSP(this.urlViewAnEtudiant, request, response);
            }

          private void doModifiedNoteEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));

              int index = Integer.valueOf(request.getParameter("id"));
              int indexNote = Integer.valueOf(request.getParameter("idNote"));

              double note = 0.0;
              try {
                  note = Double.valueOf(request.getParameter("note"));
              }catch(Exception e){
                  note = Integer.valueOf(request.getParameter("note"));
              }
              String matiere = request.getParameter("matiere");

              //listeEtudiant.getListe().get(index).getListAbsences().remove(indexAbsence);
               listeEtudiant.getListe().get(index).getNote(indexNote).setNote(note);
               listeEtudiant.getListe().get(index).getNote(indexNote).setMatiere(matiere);
               request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
               loadJSP(this.urlViewAnEtudiant, request, response);
            }

              private void doModifAbsenceEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.

              int index = Integer.valueOf(request.getParameter("id"));
              int indexAbsence = Integer.valueOf(request.getParameter("idAbsence"));

              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
              request.setAttribute("absence", listeEtudiant.getListe().get(index).getAbsence(indexAbsence));
              loadJSP(this.urlModifAbsence, request, response);
            }

            private void doModifEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

              int index = Integer.valueOf(request.getParameter("id"));

              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
              loadJSP(this.urlModifEtudiant, request, response);
            }

             private void doModifiedEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

              int index = Integer.valueOf(request.getParameter("id"));
              String nom = request.getParameter("nom");
              String prenom = request.getParameter("prenom");
              String groupe = request.getParameter("groupe");

              this.listeEtudiant.getListe().get(index).setNom(nom);
              this.listeEtudiant.getListe().get(index).setPrenom(prenom);
              this.listeEtudiant.getListe().get(index).setGroupe(groupe);
              request.setAttribute("listeEtudiant", listeEtudiant);
               request.setAttribute("groupe", "allgroupe");
              loadJSP(this.urlViewEtudiant, request, response);
            }



          private void doModifNoteEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //request.setAttribute("etudiant",request.getAttribute("name"));
             //response.

              int index = Integer.valueOf(request.getParameter("id"));
              int indexNote = Integer.valueOf(request.getParameter("idNote"));

              request.setAttribute("etudiant", listeEtudiant.getListe().get(index));
              request.setAttribute("note", listeEtudiant.getListe().get(index).getNote(indexNote));
              loadJSP(this.urlModifNote, request, response);
            }
	*/

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
