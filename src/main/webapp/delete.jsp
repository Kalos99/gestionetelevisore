<%@page import="it.gestionetelevisore.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancellazione</title>
</head>
<body>
	<form action="ExecuteDeleteServlet" method="post">
		<%Televisore televisoreDaRimuovere =  (Televisore)request.getAttribute("TelevisoreCheSiVuoleEliminare"); %>
		<br>
		Sei sicuro di voler cancellare questo televisore?
		<br><br>
		Marca: <%= televisoreDaRimuovere.getMarca() %>
		<br><br>
		Modello: <%= televisoreDaRimuovere.getModello() %>
		<br><br>
		Prezzo: <%= televisoreDaRimuovere.getPrezzo() %>
		<br><br>
		Numero di pollici: <%= televisoreDaRimuovere.getNumeroPollici() %>
		<br><br>
		Codice: <%= televisoreDaRimuovere.getCodice() %>
		<br><br>
		<input type="hidden" name="idTelevisore" value="<%= televisoreDaRimuovere.getId()%>">
		<input type ="submit" value="OK">
	</form>
</body>
</html>