<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento nuovo televisore</title>
</head>
<body>
	<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
	<%  }else{ %>
		Inserire dati del nuovo televisore<br>
	<%}    %>
	<br><br>
	<form action="ExecuteInsertServlet" method="post">
		<label for="marcaInputId">MARCA:</label><br>
		<input type="text" name="marcaInput" id="marcaInputId">
		<br><br>
		<label for="modelloInputId">MODELLO:</label><br>
		<input type="text" name="modelloInput" id="modelloInputId">
		<br><br>
		<label for="prezzoInputId">PREZZO:</label><br>
		<input type="text" name="prezzoInput" id="prezzoInputId">
		<br><br>
		<label for="numeroPolliciInputId">NUMERO POLLICI:</label><br>
		<input type="text" name="numeroPolliciInput" id="numeroPolliciInputId">
		<br><br>
		<label for="codiceInputId">CODICE:</label><br>
		<input type="text" name="codiceInput" id="codiceInputId">
		<br><br>
		<input type="submit" value="INSERISCI">
	
	</form>
</body>
</html>