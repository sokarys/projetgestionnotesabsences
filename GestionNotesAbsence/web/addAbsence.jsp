<%-- 
    Document   : addAbsence
    Created on : 19 déc. 2010, 11:01:41
    Author     : Michael
--%>
<%@page import="fr.iut2.tc4.projet.torque.Etudiant"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="listeEtudiant" class="fr.iut2.tc4.projet.data.ListeEtudiant" scope="request" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Style-Type" content="text/css">
        <style type="text/css" >
             <jsp:include page="/jquery/css/ui-lightness/jquery-ui-1.8.6.custom.css" />
             <jsp:include page="css/gestion.css" />
        </style>
        <script type="text/javascript">
        <jsp:include page="/jquery/js/jquery-1.4.2.min.js" />
        <jsp:include page="/jquery/js/jquery-ui-1.8.6.custom.min.js" />
        jQuery(document).ready(function(){
             $(".datepicker").datepicker({dateFormat:'dd/mm/yy'});
            });
         </script>
        <title>Ajouter une absence</title>
    </head>
    <body>
         <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
        <div id="groupe">
        <a href="/GestionNotesAbsence/do/addAbsence?groupe=allgroupe">Tous</a>
        <% for(String s : listeEtudiant.getGroupes() ) { %>
        <a href="/GestionNotesAbsence/do/addAbsence?groupe=<%=s%>"><%=s%></a>
        <%}%>
        </div>
         <div id="corps">
         <form method="post" action="/GestionNotesAbsence/do/addedAbsence">
            <select name="id">
                 <% for(Etudiant e : listeEtudiant.getListe()) { %>
                    <option value="<%=e.getEtudiantId() %>"><%=e.getNom()%> <%=e.getPrenom()%></option>
                 <%}%>
            </select>

            Date Debut : <input type="text" name="dateDeb" class="datepicker"/><br />
             Date Fin : <input type="text" name="dateFin" class="datepicker"/><br />
            Motif : <input type="text" name="motif" /><br />
            <input type="submit" />
        </form>
         </div>
             <jsp:include page="footer.jsp" />
    </body>
</html>
