<%@page import="it.gestionetelevisore.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiornamento televisore</title>
</head>
<body>
	<%Televisore televisoreDaAggiornare =  (Televisore)request.getAttribute("TelevisoreCheSiVuoleAggiornare"); %>
	<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
	<%  }else{ %>
		Inserire dati per modificare televisore<br>
	<%}    %>
	<br><br>
	<form action="ExecuteUpdateServlet" method="post">
		<label for="marcaInputId">MARCA:</label><br>
		<input type="text" name="marcaInput" value = <%=televisoreDaAggiornare.getMarca() %> id="marcaInputId">
		<br><br>
		<label for="modelloInputId">MODELLO:</label><br>
		<input type="text" name="modelloInput" value = <%=televisoreDaAggiornare.getModello() %> id="modelloInputId">
		<br><br>
		<label for="prezzoInputId">PREZZO:</label><br>
		<input type="text" name="prezzoInput" value = <%=televisoreDaAggiornare.getPrezzo() %> id="prezzoInputId">
		<br><br>
		<label for="numeroPolliciInputId">NUMERO POLLICI:</label><br>
		<input type="text" name="numeroPolliciInput" value = <%=televisoreDaAggiornare.getNumeroPollici() %> id="numeroPolliciInputId">
		<br><br>
		<label for="codiceInputId">CODICE:</label><br>
		<input type="text" name="codiceInput" value = <%=televisoreDaAggiornare.getCodice() %> id="codiceInputId">
		<br><br>
		<input type="hidden" name="idTelevisore" value="<%= televisoreDaAggiornare.getId()%>">
		<input type="submit" value="Aggiorna">
	
	</form>
</body>
</html>