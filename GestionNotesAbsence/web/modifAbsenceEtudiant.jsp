<%-- 
    Document   : addAbsenceEtudiant
    Created on : 30 nov. 2010, 11:33:00
    Author     : sokarys
--%>
<jsp:useBean id="etudiant" class="fr.iut2.tc4.projet.data.Etudiant" scope="request" />
<jsp:useBean id="absence" class="fr.iut2.tc4.projet.data.Absence" scope="request" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css" >
            <jsp:include page="css/gestion.css" />
        </style> 
        <title>Modifier l'absence d'un étudiant</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Rajouter une Absence pour <%= etudiant.getNom() +" " +  etudiant.getPrenom() %> </h1>
        <form method="post" action="/GestionNotesAbsence/do/modifiedAbsenceEtudiant?id=<%=etudiant.getId()%>&idAbsence=<%=absence.getId() %>"> <!-- action : -->
            Date : <input type="text" name="date" value="<%=absence.getFormatDate() %>"/><br /> <!-- name = meme nom que la classe etudiant-->
            Motif : <input type="text" name="motif" value="<%=absence.getMotif() %>"/><br />
            <input type="submit" />
        </form>
         </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
