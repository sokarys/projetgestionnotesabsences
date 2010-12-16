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
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Les Notes</h1>
        <div id="groupe">
        <a href="/GestionNotesAbsence/do/viewAllMatiere?groupe=allgroupe">Tous</a>
        <% for(String s : listeEtudiant.getGroupes() ) { %>
        <a href="/GestionNotesAbsence/do/viewAllMatiere?groupe=<%=s%>"><%=s%></a>
        <%}%>
        </div>
        
            <% for(Matiere m : listeMatiere.getListe()){%>
            <table class="table">
                <tr>
                    <th>Matiere : <%=m.getNom()%></th>
                </tr>
                <% for(Cours c : (List<Cours>) m.getCourss()){ %>
                    <tr><td><a href="/GestionNotesAbsence/do/viewEtudiant?groupe=<%=c.getClasse()%>"><%=c.getClasse()%></a></td></tr>
                <%}%>
                </table>
            <%}%>
        
    </div>
            <jsp:include page="footer.jsp" />
    </body>
</html>
