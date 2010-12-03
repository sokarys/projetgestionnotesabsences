<%-- 
    Document   : notes
    Created on : 30 nov. 2010, 10:54:17
    Author     : sokarys
--%>
<%@page import="fr.iut2.tc4.projet.data.Note"%>
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
        <div id="groupe">
        <a href="/GestionNotesAbsence/do/viewAllNotes?groupe=allgroupe">Tous</a>
        <% for(String s : listeEtudiant.getGroupes() ) { %>
        <a href="/GestionNotesAbsence/do/viewAllNotes?groupe=<%=s%>"><%=s%></a>
        <%}%>
        </div>
        <table class="table">
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Groupe</th>
                <th>Matiere</th>
                <th>Notes</th>
                <th>Voir Informations</th>
                <th>Modifier</th>
                <th>Supprimer</th>
            </tr>
            <% for(Etudiant e : listeEtudiant.getListe()){
                if(e.getGroupe().equals(groupe) || groupe.equals("allgroupe")){
            %>
                <% for(Note n : e.getListNote()){ %>
                <tr>
                    <td><%=e.getNom()%></td>
                    <td><%=e.getPrenom()%></td>
                    <td><%=e.getGroupe()%></td>
                    <td><%=n.getMatiere() %></td>
                    <td><%=n.getStringNote() %></td>
                    <td><a href="/GestionNotesAbsence/do/viewAnEtudiant?id=<%= String.valueOf(e.getId()) %>"><img src="<%=getServletContext().getContextPath()%>/img/information.png" title="Voir les informations de l'étudiant" alt="Voir info"/></a></td>
                    <td><a href="/GestionNotesAbsence/do/modifNoteEtudiant?id=<%=e.getId()%>&idNote=<%=n.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/modifier.png" title="Modifier la note" alt="Modifier"/></a></td>
                    <td><a href="/GestionNotesAbsence/do/dellNoteEtudiant?id=<%=e.getId()%>&idNote=<%=n.getId()%>"><img src="<%=getServletContext().getContextPath()%>/img/supprimer.png" title="Supprimer la note" alt="Supprimer"/></a></td>

                </tr>
            <% } } }%>
            <tr
        </table>
    </div>
            <jsp:include page="footer.jsp" />
    </body>
</html>
