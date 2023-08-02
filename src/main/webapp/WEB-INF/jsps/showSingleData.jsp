<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Single Data</title>
</head>
<body>
      <%
            out.print("The CrudTest data is: ");
            out.print(session.getAttribute("crudTest"));
      
      
      %>
      <br>
      <h2>By Expression language can also print the object</h2>
      $(crudTest)

</body>
</html>