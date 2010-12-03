<%-- 
    Document   : addNoteEtudiant
    Created on : 30 nov. 2010, 11:32:48
    Author     : sokarys
--%>
<jsp:useBean id="etudiant" class="fr.iut2.tc4.projet.data.Etudiant" scope="request" />
<jsp:useBean id="note" class="fr.iut2.tc4.projet.data.Note" scope="request" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css" >
             <jsp:include page="css/gestion.css" />
        </style>
        <title>Editer une Note d'un étudiant</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Rajouter une note pour <%= etudiant.getNom() +" " +  etudiant.getPrenom() %> </h1>
        <form method="post" action="/GestionNotesAbsence/do/modifiedNoteEtudiant?id=<%=etudiant.getId()%>&idNote=<%=note.getId()%>"> <!-- action : -->
            Note : <input type="text" name="note" value="<%=note.getNote() %>" /><br /> <!-- name = meme nom que la classe etudiant-->
            Matiere : <input type="text" name="matiere" value="<%=note.getMatiere() %>"/><br />
            <input type="submit" />
        </form>
            </div>
            <jsp:include page="footer.jsp" />
    </body>
</html>
