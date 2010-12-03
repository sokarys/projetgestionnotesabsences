<%-- 
    Document   : voirEtudiant
    Created on : 30 nov. 2010, 11:32:33
    Author     : sokarys
--%>
<%@page import="fr.iut2.tc4.projet.data.Etudiant"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Listes des étudiants</title>
    </head>
    <body>
       <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
        <div id="corps">
        <h1>Listes des étudiants</h1>
        <a href="/GestionNotesAbsence/do/viewEtudiant?groupe=allgroupe">Tous</a>
        <% for(String s : listeEtudiant.getGroupes() ) { %>
        <a href="/GestionNotesAbsence/do/viewEtudiant?groupe=<%=s%>"><%=s%></a>
        <%}%>
         
        <table class="table">
        <tr>
            <td> Nom</td>
            <td> Prenom </td>
            <td> Groupe</td>
            <td> Moyenne</td>
            <td> Nb Absence</td>
            <td> Voir Informations</td>
            <td> Modifier</td>
            <td> Supprimer</td>
        </tr>
        <% for(Etudiant e : listeEtudiant.getListe()) { 
            if(e.getGroupe().equals(groupe) || groupe.equals("allgroupe")){
        %>

        <tr>
            <td><%= e.getNom() %></td>
            <td><%= e.getPrenom() %></td>
            <td><%= e.getGroupe() %></td>
            <td><%= e.getMoyenne() %></td>
            <td><%= e.getNbAbsences() %></td>
            <td><a href="/GestionNotesAbsence/do/viewAnEtudiant?id=<%= String.valueOf(e.getId()) %>"><img src="<%=getServletContext().getContextPath()%>/img/information.png" title="Voir les informations de l'étudiant" alt="Voir info"/></a></td>
            <td><a href="/GestionNotesAbsence/do/modifEtudiant?id=<%=e.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/modifier.png" title="modifier" alt="modifier"/></a></td>
            <td><a href="/GestionNotesAbsence/do/dellEtudiant?id=<%=e.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/supprimer.png" title="supprimer" alt="supprimer"/></a></td>
        </tr>
        <% } }%>
            </table>
            <table class="table">
            <tr><td>Ajouter un étudiant</td><td>Voir notes</td><td>Voir Absence</td></tr>
            <tr>
                <td><a href="/GestionNotesAbsence/do/addEtudiant"><img src="<%=getServletContext().getContextPath()%>/img/ajouter.png" title="ajouter un étudiant" alt="ajouter un étudiant"/></a></td>
                <td><a href="/GestionNotesAbsence/do/viewAllNotes"><img src="<%=getServletContext().getContextPath()%>/img/note.gif" title="Voir la liste des notes" alt="Voir notes"/></a></td>
                <td><a href="/GestionNotesAbsence/do/viewAllAbsence"><img src="<%=getServletContext().getContextPath()%>/img/information.png" title="Voir la liste des Absences" alt="Voir Absence"/></a></td>
            </tr></table>
        </div>
             <jsp:include page="footer.jsp" />
    </body>
</html>
