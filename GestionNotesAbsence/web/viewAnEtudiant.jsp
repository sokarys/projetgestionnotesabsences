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
        <h1>un Etudiant</h1>
        <%= etudiant.toString() %>
        <table class="table">
        <caption>Liste des Notes</caption>
         <% for(int i=0; i<etudiant.getListNote().size(); i++){
             Note n = etudiant.getNote(i);
         %>
            <tr>
                <td><%=n.getMatiere() %></td>
                <td><%=n.getStringNote() %></td>
                 <td><a href="/GestionNotesAbsence/do/dellNoteEtudiant?id=<%=etudiant.getId()%>&idNote=<%=i%>"><img src="<%=getServletContext().getContextPath()%>/img/supprimer.png" title="Supprimer la note" alt="Supprimer"/></a></td>
                  <td><a href="/GestionNotesAbsence/do/modifNoteEtudiant?id=<%=etudiant.getId()%>&idNote=<%=n.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/modifier.png" title="Modifier la note" alt="Modifier"/></a></td>
            </tr>
            <% } %>
        </table>
        <table class="table">
         <caption>Liste des absences</caption>
         <% for(int i=0; i<etudiant.getListAbsences().size(); i++){ 
             Absence a = etudiant.getAbsence(i);
             %>
            <tr>
                <td><%= a.getMotif() %></td>
                <td><%=a.getFormatDate() %></td>
                <td><a href="/GestionNotesAbsence/do/dellAbsenceEtudiant?id=<%=etudiant.getId()%>&idAbsence=<%=i%>"><img src="<%=getServletContext().getContextPath()%>/img/supprimer.png" title="Supprimer l'absence" alt="Supprimer"/></a></td>
                <td><a href="/GestionNotesAbsence/do/modifAbsenceEtudiant?id=<%=etudiant.getId()%>&idAbsence=<%=a.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/modifier.png" title="Modifer l'absence" alt="Modifier"/></a></td>
            </tr>
            <% } %>
        </table>
        <a href="/GestionNotesAbsence/do/addAbsenceEtudiant?id=<%=etudiant.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/ajouter.png" title="Ajouter une absence" alt="Ajouter absence"/></a>
        <a href="/GestionNotesAbsence/do/addNoteEtudiant?id=<%=etudiant.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/ajouter.png" title="Ajouter une note" alt="Ajouter Note"/></a>
    </body>
</html>
