<%-- 
    Document   : addEtudiant
    Created on : 30 nov. 2010, 11:32:18
    Author     : sokarys
--%>
<jsp:useBean id="etudiant" class="fr.iut2.tc4.projet.data.Etudiant" scope="request" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= getServletContext().getInitParameter("title")%></title>
    </head>
    <body>
        <h1>Modifie Etudiant</h1>
        <form method="post" action="/GestionNotesAbsence/do/modifedEtudiant?id=<%=etudiant.getId()%>"> <!-- action : -->
            Nom : <input type="text" name="nom" /><br /> <!-- name = meme nom que la classe etudiant-->
            Prenom : <input type="text" name="prenom" /><br />
            Groupe : <input type="text" name="groupe" /><br />
            <input type="submit" />
        </form>
    </body>
</html>
