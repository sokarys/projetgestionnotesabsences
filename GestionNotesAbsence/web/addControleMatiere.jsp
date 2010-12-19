<%-- 
    Document   : addControleMatiere
    Created on : 19 déc. 2010, 13:04:49
    Author     : Michael
--%>
<%@page import="fr.iut2.tc4.projet.torque.Etudiant"%>
<%@page import="java.util.List"%>
<%@page import="fr.iut2.tc4.projet.torque.Cours"%>
<jsp:useBean id="matiere" class="fr.iut2.tc4.projet.torque.Matiere" scope="request" />
<jsp:useBean id="date" class="java.lang.String" scope="request" />
<jsp:useBean id="coef" class="java.lang.String" scope="request" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Style-Type" content="text/css">
        <style type="text/css" >
             <jsp:include page="css/gestion.css" />
        </style>
        <title>Ajouter un controle</title>
    </head>
    <body>
         <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Ajouter un controle</h1>
        <table class="table">
            <form method="post" action="/GestionNotesAbsence/do/addControle">
                <caption>Liste des Etudiant de ce controle</caption>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Note</th>
                </tr>
                 <% for(Cours c : (List<Cours>) matiere.getCourss()){
                     for(Etudiant e : (List<Etudiant>) c.getClasse().getEtudiants()){%>
                <tr>
                    <th><%=e.getNom() %></th>
                    <th><%=e.getPrenom() %></th>
                    <th><%=e.getClasse() %></th>
                    <th><input name="<%=e.getEtudiantId()%>" type="text" value=""/></th>
                </tr>
                 <%}}%>
            
            <input type="hidden" name="date" value="<%= date %>"/>
            <input type="hidden" name="coef" value="<%= coef %>"/>
            <input type="hidden" name="idMatiere" value="<%= matiere.getMatiereId() %>"/>
            <input type="submit" />
        
            </form>
        </table>
         </div>
             <jsp:include page="footer.jsp" />
    </body>
</html>
