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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ViewEtudiant</h1>
        <table border="solid">
        <tr>
            <td> Nom</td>
            <td> Prenom </td>
            <td> Groupe</td>
            <td> Nb Absence</td>
        </tr>
        <% for(Etudiant e : listeEtudiant.getListe()) { %>
        <tr>
        
            <td> <center><a href="/GestionNotesAbsence/do/addEtudiant"><%= e.getNom() %></a></center></td>
            <td> <center><%= e.getPrenom() %></center></td>
            <td> <center><%= e.getGroupe() %></center></td>
            <td> <center><%= e.getNbAbsences() %></center></td>
        </tr>
        <%}%>
            </table>
       
      
    </body>
</html>
