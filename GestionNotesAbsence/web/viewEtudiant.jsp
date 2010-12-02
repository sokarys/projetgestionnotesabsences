<%-- 
    Document   : voirEtudiant
    Created on : 30 nov. 2010, 11:32:33
    Author     : sokarys
--%>
<%@page import="fr.iut2.tc4.projet.data.Etudiant"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="listeEtudiant" class="fr.iut2.tc4.projet.data.ListeEtudiant" scope="request" />


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
        <h1>ViewEtudiant</h1>
        <table class="table">
        <tr>
            <td> Nom</td>
            <td> Prenom </td>
            <td> Groupe</td>
            <td> Moyenne</td>
            <td> Nb Absence</td>
        </tr>
        <% for(Etudiant e : listeEtudiant.getListe()) { %>
        <tr>
        
            <td> <center><a href="/GestionNotesAbsence/do/viewAnEtudiant?id=<%= String.valueOf(e.getId()) %>"><%= e.getNom() %></a></center></td>
            <td> <center><%= e.getPrenom() %></center></td>
            <td> <center><%= e.getGroupe() %></center></td>
            <td> <center><%= e.getMoyenne() %></center></td>
            <td> <center><%= e.getNbAbsences() %></center></td>
             <td><a href="/GestionNotesAbsence/do/dellEtudiant?id=<%=e.getId()%>">Supprimer</a></td>
        </tr>
        <%}%>
            </table>

            <a href="/GestionNotesAbsence/do/addEtudiant">Rajouter un Etudiant</a><br />
            <a href="/GestionNotesAbsence/do/viewAllNotes">Voir les notes</a>
       
      
    </body>
</html>
