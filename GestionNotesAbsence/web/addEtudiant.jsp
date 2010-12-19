<%-- 
    Document   : addEtudiant
    Created on : 30 nov. 2010, 11:32:18
    Author     : sokarys
--%>

<%@page import="fr.iut2.tc4.projet.torque.Classe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeClasse" class="fr.iut2.tc4.projet.data.ListeClasse" scope="request" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css" >
             <jsp:include page="css/gestion.css" />
        </style> 
        <title><%= getServletContext().getInitParameter("title")%></title>
    </head>
    <body> <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Hello World!</h1>
        <form method="post" action="/GestionNotesAbsence/do/addedAnEtudiant"> <!-- action : -->
            Nom : <input type="text" name="nom" /><br /> <!-- name = meme nom que la classe etudiant-->
            Prenom : <input type="text" name="prenom" /><br />
            Classe : <select name="classe">
               <% for(Classe cs : listeClasse.getListe()){ %>
               <option value="<%=cs.getClasseId()%>"><%=cs.getNom()%></option>
               <%}%>
               </select><br />
            <input type="submit" />
        </form>
         </div>
        <jsp:include page="footer.jsp" />

    </body>
</html>
