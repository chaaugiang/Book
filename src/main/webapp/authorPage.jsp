<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
    <% String table = (String) request.getAttribute("table"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sci Fi </title>
</head>

<h1>Books written by <%= request.getParameter("author") %></h1>

<body>

<%= table %>
<br>
<a href="read">Back to Library</a>

</body>
</html>