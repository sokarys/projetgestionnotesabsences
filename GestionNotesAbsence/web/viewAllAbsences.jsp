<%-- 
    Document   : absences
    Created on : 30 nov. 2010, 10:54:29
    Author     : sokarys
--%>
<%@page import="fr.iut2.tc4.projet.data.Absence"%>
<%@page import="fr.iut2.tc4.projet.data.Etudiant"%>
<jsp:useBean id="listeEtudiant" class="fr.iut2.tc4.projet.data.ListeEtudiant" scope="request" />
<jsp:useBean id="groupe" class="java.lang.String" scope="request" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <style type="text/css" >
            <jsp:include page="css/gestion.css" />
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
          <h1>Les Notes</h1>
        <a href="/GestionNotesAbsence/do/viewAllAbsence?groupe=allgroupe">Tous</a>
        <% for(String s : listeEtudiant.getGroupes() ) { %>
        <a href="/GestionNotesAbsence/do/viewAllAbsence?groupe=<%=s%>"><%=s%></a>
        <%}%>
        <table class="table">
            <tr>
                <td>Nom</td>
                <td>Prenom</td>
                <td>Groupe</td>
                <td>Date</td>
                <td>Motif</td>
            </tr>
            <% for(Etudiant e : listeEtudiant.getListe()){
                if(e.getGroupe().equals(groupe) || groupe.equals("allgroupe")){
            %>
                <% for(Absence a : e.getListAbsences()){ %>
                <tr>
                    <td><%=e.getNom()%></td>
                    <td><%=e.getPrenom()%></td>
                    <td><%=e.getGroupe()%></td>
                    <td><%=a.getFormatDate() %></td>
                    <td><%=a.getMotif() %></td>
                </tr>
            <% } } }%>
            <tr
        </table>
         </div>
            <jsp:include page="footer.jsp" />

    </body>
</html>
