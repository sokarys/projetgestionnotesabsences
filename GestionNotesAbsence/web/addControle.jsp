<%-- 
    Document   : addControle
    Created on : 19 déc. 2010, 12:40:46
    Author     : Michael
--%>
<%@page import="fr.iut2.tc4.projet.torque.Matiere"%>
<jsp:useBean id="controle" class="fr.iut2.tc4.projet.torque.Controle" scope="request" />
<jsp:useBean id="listeMatiere" class="fr.iut2.tc4.projet.data.ListeMatiere" scope="request" />


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
             $("#datepicker").datepicker({dateFormat:'dd/mm/yy'});
            });
         </script>
        <title>Ajouter un controle</title>
    </head>
    <body>
         <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Ajouter un controle</h1>
        <form method="post" action="/GestionNotesAbsence/do/addControleMatiere">
            <select name="idMatiere">
                 <% for(Matiere m : listeMatiere.getListe()) { %>
                    <option value="<%=m.getMatiereId() %>"><%=m.getNom() %></option>
                 <%}%>
            </select>
            Date : <input type="text" name="date" id="datepicker"/><br />
            Coef : <input type="text" name="coef"/><br />
            <input type="submit" />
        </form>
         </div>
             <jsp:include page="footer.jsp" />
    </body>
</html>
