<%--
    Document   : absences
    Created on : 30 nov. 2010, 10:54:29
    Author     : sokarys
--%>
<%@page import="java.util.List"%>
<%@page import="fr.iut2.tc4.projet.torque.Absence"%>
<%@page import="fr.iut2.tc4.projet.torque.Etudiant"%>
<jsp:useBean id="listeEtudiant" class="fr.iut2.tc4.projet.data.ListeEtudiant" scope="request" />
<jsp:useBean id="groupe" class="java.lang.String" scope="request" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <style type="text/css" >
            <jsp:include page="css/gestion.css" />
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
          <h1>Les Absences</h1>
        <div id="groupe">
        <a href="/GestionNotesAbsence/do/viewAllAbsence?groupe=allgroupe">Tous</a>
        <% for(String s : listeEtudiant.getGroupes() ) { %>
        <a href="/GestionNotesAbsence/do/viewAllAbsence?groupe=<%=s%>"><%=s%></a>
        <%}%>
        </div>
        <table class="table">
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Groupe</th>
                <th>Date Debut</th>
                <th>Date Fin</th>
                <th>Motif</th>
                <th>Voir Informations</th>
                <th>Supprimer</th>

            </tr>
            
            <% for(Etudiant e : listeEtudiant.getListe()){
            %>
            <form method="post" action="/GestionNotesAbsence/do/modifiedAllAbsences?groupe=<%=groupe%>">
                <% for(Absence a : (List<Absence>) e.getAbsences()){ %>
                <tr>
                    <td><%=e.getNom()%></td>
                    <td><%=e.getPrenom()%></td>
                    <td><%=e.getClasse()%></td>
                    <td><input type="text" name="<%=a.getAbsenceId() +"_db"%>" value="<%=a.getDatedebut()%>" /></td>
                    <td><input type="text" name="<%=a.getAbsenceId() +"_df"%>" value="<%=a.getDatefin()%>" /></td>
                    <td><input type="text" name="<%=a.getAbsenceId() +"_m"%>" value="<%=a.getMotif()%>" /></td>
                    <td><a href="/GestionNotesAbsence/do/viewAnEtudiant?id=<%= String.valueOf(e.getEtudiantId()) %>"><img src="<%=getServletContext().getContextPath()%>/img/information.png" title="Voir les informations de l'étudiant" alt="Voir info"/></a></td>
                    <td><a href="/GestionNotesAbsence/do/dellAbsence?id=<%=e.getEtudiantId()%>&idAbsence=<%=a.getAbsenceId()%>"><img src="<%=getServletContext().getContextPath()%>/img/supprimer.png" title="Supprimer l'absence" alt="Supprimer"/></a></td>
                </tr>
            <% }}%>
            <input type="submit" />
            </form>
        </table>
        <table class="table">
            <tr>
                <th>Ajouter une absence</th>
            </tr>
            <tr>
                <td><a href="/GestionNotesAbsence/do/addAbsence?groupe=<%=groupe%>"><img src="<%=getServletContext().getContextPath()%>/img/ajouter.png" title="Ajouter une absence" alt="Ajouter Absence"/></a></td>
          </tr>
        </table>
         </div>
            <jsp:include page="footer.jsp" />

    </body>
</html>
