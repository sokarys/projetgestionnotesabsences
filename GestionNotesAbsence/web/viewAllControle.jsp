<%--
    Document   : notes
    Created on : 30 nov. 2010, 10:54:17
    Author     : sokarys
--%>

<%@page import="fr.iut2.tc4.projet.torque.Controle"%>
<%@page import="java.util.List"%>
<%@page import="fr.iut2.tc4.projet.torque.Cours"%>
<%@page import="fr.iut2.tc4.projet.torque.Matiere"%>
<jsp:useBean id="listeEtudiant" class="fr.iut2.tc4.projet.data.ListeEtudiant" scope="request" />
<jsp:useBean id="listeControle" class="fr.iut2.tc4.projet.data.ListeControle" scope="request" />
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
        <title>Voir toutes les controles</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Les Controles</h1>
        <div id="groupe">
        <a href="/GestionNotesAbsence/do/viewAllControle?groupe=allgroupe">Tous</a>
        <% for(String s : listeEtudiant.getGroupes() ) { %>
        <a href="/GestionNotesAbsence/do/viewAllControle?groupe=<%=s%>"><%=s%></a>
        <%}%>
        </div>
            <table class="table">
                <tr>
                    <th>Matiere</th>
                    <th>Professeur</th>
                    <th>Coef</th>
                    <th>Date</th>
                    <th>Moyenne</th>
                    <th>Classe</th>
                </tr>
            <% for(Controle c : listeControle.getListe()){%>

                <tr>
                    <td><%= c.getCours().getMatiere().getNom() %></td>
                    <td><%= c.getCours().getMatiere().getProf() %></td>
                    <td><%= c.getCoef() %></td>
                    <td><%= c.getDate() %></td>
                    <td><%= c.getMoyenne() %></td>
                    <td>
                    <a href="/GestionNotesAbsence/do/viewEtudiant?groupe=<%=c.getCours().getClasse() %>"><%=c.getCours().getClasse()%></a><br/>
                    </td>
                    <td><a href="/GestionNotesAbsence/do/viewAnControle?id=<%=c.getControleId()%>"><img src="<%=getServletContext().getContextPath()%>/img/modifier.png" title="Modifer les controles" alt="Modifier"/></a></td>
                </tr>
            <%}%>
         </table>
         <table class="table">
            <tr>
                <th>Ajouter un controle</th>
            </tr>
            <tr>
                <td><a href="/GestionNotesAbsence/do/addControle"><img src="<%=getServletContext().getContextPath()%>/img/ajouter.png" title="Ajouter un controle" alt="Ajouter Controle"/></a></td>
          </tr>
        </table>
    </div>
            <jsp:include page="footer.jsp" />
    </body>
</html>
