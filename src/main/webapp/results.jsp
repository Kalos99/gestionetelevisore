<%@page import="java.util.List"%>
<%@page import="it.gestionetelevisore.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina dei risultati</title>
<style type="text/css">
	table, th, td {
	  border: 1px solid black;
	}
	
	th, td {
	  padding: 10px;
	}
	.center {
		margin-left: auto;
		margin-right: auto;
	}
</style>

</head>
<body>
	<table class="center">
		<thead>
			<tr>
				<th>Marca</th>
				<th>Modello</th>
				<th>Prezzo</th>
				<th>Azione</th>
			</tr>
		</thead>
		
		<% List<Televisore> listaDaServlet = (List<Televisore>)request.getAttribute("listTelevisori");
							for(Televisore televisoreItem : listaDaServlet){
				%>
				<tr>
					<td><%=televisoreItem.getMarca() %></td>
					<td><%=televisoreItem.getModello() %></td>
					<td><%=televisoreItem.getPrezzo() %></td>
					<td>
						<a href="VisualizzaDettaglioServlet?idDaInviareComeParametro=<%=televisoreItem.getId() %>">Dettaglio</a>
						<a href="PrepareUpdateServlet?idDaInviareComeParametro=<%=televisoreItem.getId() %>">Modifica</a>
						<a href="PrepareDeleteServlet?idDaInviareComeParametro=<%=televisoreItem.getId() %>">Elimina</a>
					</td>
				</tr>
		<%	}%>
	
		<tr>
			<th>
				<a class ="center" href=PrepareInsertServlet>Inserisci nuovo televisore</a>
			</th>
		</tr>
	
	</table>
	
	<br><br>
</body>

</html>