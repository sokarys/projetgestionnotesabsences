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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>un Etudiant</h1>
        <%= etudiant.toString() %>
        <table>
         <% for(int i=0; i<etudiant.getListNote().size(); i++){
             Note n = etudiant.getNote(i);
         %>
            <tr>
                <td><%=n.getMatiere() %></td>
                <td><%=n.getStringNote() %></td>
                 <td><a href="/GestionNotesAbsence/do/dellNoteEtudiant?id=<%=etudiant.getId()%>&idNote=<%=i%>">Supprimer</a></td>
                  <td><a href="/GestionNotesAbsence/do/modifNoteEtudiant?id=<%=etudiant.getId()%>&idNote=<%=n.getId()%>">Modif</a></td>
            </tr>
            <% } %>
        </table>
        <table>
         <% for(int i=0; i<etudiant.getListAbsences().size(); i++){ 
             Absence a = etudiant.getAbsence(i);
             %>
            <tr>
                <td><%= a.getMotif() %></td>
                <td><%=a.getDate().get(GregorianCalendar.DAY_OF_MONTH) %>/<%=a.getDate().get(GregorianCalendar.MONTH)+1 %>/<%=a.getDate().get(GregorianCalendar.YEAR) %></td>
                <td><a href="/GestionNotesAbsence/do/dellAbsenceEtudiant?id=<%=etudiant.getId()%>&idAbsence=<%=i%>">Supprimer</a></td>
                <td><a href="/GestionNotesAbsence/do/modifAbsenceEtudiant?id=<%=etudiant.getId()%>&idAbsence=<%=a.getId()%>">Modif</a></td>
            </tr>
            <% } %>
        </table>

        <a href="/GestionNotesAbsence/do/addAbsenceEtudiant?id=<%=etudiant.getId()%>">Rajouter une absence</a>
        <a href="/GestionNotesAbsence/do/addNoteEtudiant?id=<%=etudiant.getId()%>">Rajouter une Note</a>
    </body>
</html>
