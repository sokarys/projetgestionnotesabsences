<%-- 
    Document   : addClasse
    Created on : 19 déc. 2010, 15:19:20
    Author     : Michael
--%>

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
        <title>Ajouter une classe</title>
    </head>
    <body>
         <jsp:include page="header.jsp" />
        <jsp:include page="menu.jsp" />
         <div id="corps">
        <h1>Ajouter une Classe</h1>
        <table class="table">
            <form method="post" action="/GestionNotesAbsence/do/addedClasse">
            <input type="text" name="nom" value=""/>
            <input type="submit" />
            </form>
        </table>
         </div>
             <jsp:include page="footer.jsp" />
    </body>
</html>
