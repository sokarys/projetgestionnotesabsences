<%@page import="java.util.List"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : viewAnEtudiant
    Created on : 30 nov. 2010, 19:08:35
    Author     : sokarys
--%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="fr.iut2.tc4.projet.torque.Absence"%>
<%@page import="fr.iut2.tc4.projet.torque.Note"%>
<jsp:useBean id="etudiant" class="fr.iut2.tc4.projet.torque.Etudiant" scope="request" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css" >
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
           Classe : <%= etudiant.getClasse() %>
        </div>
        <table class="table">
           <% if(etudiant.getNotes().size()==0){%>style="display : none ;"<%}%>
        <caption>Liste des Notes</caption>
        <tr>
             <th>Matière</th>
             <th>Note</th>
             <th>Coef</th>
         </tr>
         <% for(Note n : (List<Note>) etudiant.getNotes()) { %>
            <tr>
                <td><%=n.getControle().getCours().getMatiere().getNom() %></td>
                <td><%=n.getNote() %></td>
                <td><%=n.getControle().getCoef() %></td>               
            </tr>
            <% } %>
        </table>
        <table class="table" <% if(etudiant.getAbsences().size()==0){%>style="display : none ;"<%}%>>
         <caption>Liste des absences</caption>
         <tr>
             <th>Motif</th>
             <th>Date Debut</th>
             <th>Date Fin</th>             
             <th>Supprimer</th>            
         </tr>
         <%  for(Absence a :(List<Absence>) etudiant.getAbsences() ) {
             %>
            <tr>
                <td><%= a.getMotif() %></td>
                <td><%=a.getDatedebut() %></td>
                <td><%=a.getDatefin() %></td>
                <td><a href="/GestionNotesAbsence/do/dellAbsenceEtudiant?id=<%=etudiant.getEtudiantId()%>&idAbsence=<%=a.getAbsenceId()%>"><img src="<%=getServletContext().getContextPath()%>/img/supprimer.png" title="Supprimer l'absence" alt="Supprimer"/></a></td>
           </tr>
            <% } %>
        </table>
        <table class="table">
            <tr>
                <th>Ajouter absence</th>
                 <th>Modifier l'étudiant</th>
            </tr>
        <tr>
        <td><a href="/GestionNotesAbsence/do/addAbsenceEtudiant?id=<%=etudiant.getEtudiantId() %>"><img src="<%=getServletContext().getContextPath()%>/img/ajouter.png" title="Ajouter une absence" alt="Ajouter absence"/></a></td>
        <td><a href="/GestionNotesAbsence/do/modifAnEtudiant?id=<%=etudiant.getEtudiantId()%>"><img src="<%=getServletContext().getContextPath()%>/img/modifier.png" title="Modifer les informations de l'étudiant" alt="Modifier"/></a></td>
        </tr>
        </table>
        <div id="datepicker"></div>
         </div>
          
    <jsp:include page="footer.jsp" />
    </body>
</html>
