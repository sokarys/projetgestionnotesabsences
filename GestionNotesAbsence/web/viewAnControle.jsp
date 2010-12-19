<%--
    Document   : notes
    Created on : 30 nov. 2010, 10:54:17
    Author     : sokarys
--%>

<%@page import="fr.iut2.tc4.projet.torque.Note"%>
<%@page import="fr.iut2.tc4.projet.torque.Controle"%>
<%@page import="java.util.List"%>
<%@page import="fr.iut2.tc4.projet.torque.Cours"%>
<%@page import="fr.iut2.tc4.projet.torque.Matiere"%>
<jsp:useBean id="controle" class="fr.iut2.tc4.projet.torque.Controle" scope="request" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css" >
            <jsp:include page="css/gestion.css" />
        </style>
        <title>Voir toutes les controles</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Un Controle</h1>
            <table class="table">
                <tr>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Note</th>
                    <th>Classe</th>
                </tr>
            <% for(Note n : (List<Note>) controle.getNotes() ){ %>

                <tr>
                    <td><%= n.getEtudiant().getNom() %></td>
                    <td><%= n.getEtudiant().getPrenom() %></td>
                    <td><%= n.getNote() %></td>
                    <td><%= n.getEtudiant().getClasse() %></td>
                </tr>
            <%}%>
         </table>
         <table class="table">
            <tr>
                 <th>Modifier le controle</th>
            </tr>
            <tr>
                <td><a href="/GestionNotesAbsence/do/modifAnControle?id=<%=controle.getControleId()%>"><img src="<%=getServletContext().getContextPath()%>/img/modifier.png" title="Modifer les controles" alt="Modifier"/></a></td>
          </tr>
        </table>
    </div>
            <jsp:include page="footer.jsp" />
    </body>
</html>
