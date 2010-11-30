<%-- 
    Document   : index
    Created on : 30 nov. 2010, 10:13:25
    Author     : sokarys
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fr.iut2.tc4.projet.Etudiant"%>
<%@page import="fr.iut2.tc4.projet.TestAbsences"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            ArrayList<Etudiant> l = new ArrayList<Etudiant>();
            Etudiant e = new Etudiant(1,"kikoo","non","3IS");
          //  l.add(e);
        %>
        <%
            l.add(e);
            l.add(e);
            l.add(e);
        %>
    
    <% for(Etudiant e : l){ %>
    <%=     e.toString() %>
    <%}%>
    
    </body>
</html>
