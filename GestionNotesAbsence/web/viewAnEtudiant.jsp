<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : viewAnEtudiant
    Created on : 30 nov. 2010, 19:08:35
    Author     : sokarys
--%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="fr.iut2.tc4.projet.data.Absence"%>
<%@page import="fr.iut2.tc4.projet.data.Note"%>
<jsp:useBean id="etudiant" class="fr.iut2.tc4.projet.data.Etudiant" scope="request" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="" >
            <jsp:include page="css/gestion.css" />
        </style>
        <title>Information de l'étudiant</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Informations Etudiant</h1>
        
        <div class="titre_etudiant">
           Nom : <%= etudiant.getNom() %><br/>
           Prénom : <%= etudiant.getPrenom() %><br/>
           Classe : <%= etudiant.getGroupe() %>
        </div>
        <table class="table">
        <caption>Liste des Notes</caption>
        <tr>
             <th>Matière</th>
             <th>Note</th>             
             <th>Modifier</th>
             <th>Supprimer</th>
         </tr>
         <% for(Note n : etudiant.getListNote()) { %>
            <tr>
                <td><%=n.getMatiere() %></td>
                <td><%=n.getStringNote() %></td>
                <td><a href="/GestionNotesAbsence/do/modifNoteEtudiant?id=<%=etudiant.getId()%>&idNote=<%=n.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/modifier.png" title="Modifier la note" alt="Modifier"/></a></td>
                <td><a href="/GestionNotesAbsence/do/dellNoteEtudiant?id=<%=etudiant.getId()%>&idNote=<%=n.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/supprimer.png" title="Supprimer la note" alt="Supprimer"/></a></td>
            </tr>
            <% } %>
        </table>
        <table class="table">
         <caption>Liste des absences</caption>
         <tr>
             <th>Motif</th>
             <th>Date</th>
             <th>Modifier</th>
             <th>Supprimer</th>            
         </tr>
         <%  for(Absence a : etudiant.getListAbsences() ) {
             %>
            <tr>
                <td><%= a.getMotif() %></td>
                <td><%=a.getFormatDate() %></td> 
                <td><a href="/GestionNotesAbsence/do/modifAbsenceEtudiant?id=<%=etudiant.getId()%>&idAbsence=<%=a.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/modifier.png" title="Modifer l'absence" alt="Modifier"/></a></td>
                <td><a href="/GestionNotesAbsence/do/dellAbsenceEtudiant?id=<%=etudiant.getId()%>&idAbsence=<%=a.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/supprimer.png" title="Supprimer l'absence" alt="Supprimer"/></a></td>
               
            </tr>
            <% } %>
        </table>
        <table class="table">
            <tr>
                <th>Ajouter absence</th>
                <th>Ajouter Note</th>
            </tr>
        <tr>
        <td><a href="/GestionNotesAbsence/do/addAbsenceEtudiant?id=<%=etudiant.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/ajouter.png" title="Ajouter une absence" alt="Ajouter absence"/></a></td>
        <td><a href="/GestionNotesAbsence/do/addNoteEtudiant?id=<%=etudiant.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/ajouter.png" title="Ajouter une note" alt="Ajouter Note"/></a></td>
          </tr>
        </table>
         </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
