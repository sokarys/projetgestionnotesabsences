<%-- 
    Document   : addAbsenceEtudiant
    Created on : 30 nov. 2010, 11:33:00
    Author     : sokarys
--%>
<jsp:useBean id="etudiant" class="fr.iut2.tc4.projet.data.Etudiant" scope="request" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Style-Type" content="text/css">
        <style type="text/css" >
             <jsp:include page="/jquery/css/ui-lightness/jquery-ui-1.8.6.custom.css" />
        </style>      
        <script type="text/javascript">
        <jsp:include page="/jquery/js/jquery-1.4.2.min.js" />
        <jsp:include page="/jquery/js/jquery-ui-1.8.6.custom.min.js" />
        jQuery(document).ready(function(){
             $("#datepicker").datepicker({dateFormat:'dd/mm/yy'});
            });
         </script>
        <title>Ajouter une absence</title>
    </head>
    <body>
         <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Rajouter une Absence pour <%= etudiant.getNom() +" " +  etudiant.getPrenom() %> </h1>
        <form method="post" action="/GestionNotesAbsence/do/addedAbsenceEtudiant?id=<%=etudiant.getId()%>"> <!-- action : -->
            Date : <input type="text" name="date" id="datepicker"/><br /> <!-- name = meme nom que la classe etudiant-->
            Motif : <input type="text" name="motif" /><br />
            <input type="submit" />
        </form>
         </div>
             <jsp:include page="footer.jsp" />
    </body>
</html>
