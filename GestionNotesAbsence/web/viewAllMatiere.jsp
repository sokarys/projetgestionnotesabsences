<%-- 
    Document   : notes
    Created on : 30 nov. 2010, 10:54:17
    Author     : sokarys
--%>

<%@page import="java.util.List"%>
<%@page import="fr.iut2.tc4.projet.torque.Cours"%>
<%@page import="fr.iut2.tc4.projet.torque.Matiere"%>
<jsp:useBean id="listeEtudiant" class="fr.iut2.tc4.projet.data.ListeEtudiant" scope="request" />
<jsp:useBean id="listeMatiere" class="fr.iut2.tc4.projet.data.ListeMatiere" scope="request" />
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
        <title>Voir toutes les matières</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Les Matières</h1>
        <div id="groupe">
        <a href="/GestionNotesAbsence/do/viewAllMatiere?groupe=allgroupe">Tous</a>
        <% for(String s : listeEtudiant.getGroupes() ) { %>
        <a href="/GestionNotesAbsence/do/viewAllMatiere?groupe=<%=s%>"><%=s%></a>
        <%}%>
        </div>
            <table class="table">
                <tr><th>Nom</th><th>Description</th><th>Professeur</th><th>Classes</th></tr>
            <% for(Matiere m : listeMatiere.getListe()){%>            
                <tr>
                <td><%=m.getNom()%></td>
                <td><%=m.getDescription()%></td>
                <td><%=m.getProf()%></td>
                <td>
                <% for(Cours c : (List<Cours>) m.getCourss()){ %>
                    <a href="/GestionNotesAbsence/do/viewEtudiant?groupe=<%=c.getClasse()%>"><%=c.getClasse()%></a><br/>
                <%}%>
                    </td>
                </tr>
            <%}%>
         </table>
          <table class="table">
            <tr>
                <th>Ajouter une matière</th>
                 <th>Modifier les matières</th>
            </tr>
            <tr>
                <td><a href="/GestionNotesAbsence/do/addMatiere"><img src="<%=getServletContext().getContextPath()%>/img/ajouter.png" title="Ajouter une matière" alt="Ajouter Matière"/></a></td>
                <td><a href="/GestionNotesAbsence/do/modifMatiere"><img src="<%=getServletContext().getContextPath()%>/img/modifier.png" title="Modifer les matières" alt="Modifier"/></a></td>
          </tr>
        </table>
    </div>
            <jsp:include page="footer.jsp" />
    </body>
</html>
