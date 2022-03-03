<%@page import="it.gestionetelevisore.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio</title>
</head>
<body>
	<%Televisore televisoreOttenuto =  (Televisore)request.getAttribute("TelevisoreDiCuiSiVoglionoConoscereIDettagli"); %>
	<br>
	Marca: <%= televisoreOttenuto.getMarca() %>
	<br>
	Modello: <%= televisoreOttenuto.getModello() %>
	<br>
	Prezzo: <%= televisoreOttenuto.getPrezzo() %>
	<br>
	Numero di pollici: <%= televisoreOttenuto.getNumeroPollici() %>
	<br>
	Codice: <%= televisoreOttenuto.getCodice() %>
	<br><br>
	<a href="searchForm.jsp">Home</a>
</body>
</html>