<%-- 
    Document   : addMatiere
    Created on : 19 déc. 2010, 16:19:56
    Author     : Michael
--%>
<%@page import="fr.iut2.tc4.projet.torque.Classe"%>
<jsp:useBean id="listeClasse" class="fr.iut2.tc4.projet.data.ListeClasse" scope="request" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Style-Type" content="text/css">
        <style type="text/css" >
             <jsp:include page="css/gestion.css" />
        </style>
        <title>Ajouter une Matière</title>
    </head>
    <body>
         <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Ajouter une Matière</h1>
        <table class="table">
            <form method="post" action="/GestionNotesAbsence/do/addedMatière">
            Nom de la matière : <input type="text" name="nom" value=""/>
            Description : <input type="text" name="description" value=""/>
            Professeur : <input type="text" name="prof" value=""/>
            Classes :
            <select name="classe" multiple="multiple" size="<%=listeClasse.getListe().size()%>">
                    <% for(Classe c : listeClasse.getListe()){ %>
                    <option value="<%= c.getClasseId()%>"><%=c%></option>
                    <%}%>
            </select>
            <input type="submit" />
            </form>
        </table>
         </div>
             <jsp:include page="footer.jsp" />
    </body>
</html>
