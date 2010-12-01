<%-- 
    Document   : notes
    Created on : 30 nov. 2010, 10:54:17
    Author     : sokarys
--%>
<%@page import="fr.iut2.tc4.projet.data.Note"%>
<%@page import="fr.iut2.tc4.projet.data.Etudiant"%>
<jsp:useBean id="listeEtudiant" class="fr.iut2.tc4.projet.data.ListeEtudiant" scope="request" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Les Notes</h1>
        <table>
            <tr>
                <td>Nom</td>
                <td>Groupe</td>
                <td>Matiere</td>
                <td>Notes</td>
            </tr>
            <% for(Etudiant e : listeEtudiant.getListe()){ %>
            <% for(Note n : e.getListNote()){ %>
            <tr>
                <td><%=e.getNom() + " " + e.getPrenom()%></td>
                <td><%=e.getGroupe()%></td>
                <td><%=n.getMatiere() %></td>
                <td><%=n.getStringNote() %></td>
            </tr>
            <% } } %>
            <tr
        </table>
    </body>
</html>
