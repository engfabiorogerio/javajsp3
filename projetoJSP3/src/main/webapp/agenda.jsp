<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.ArrayList"%>
   <%@ page import="com.engfabiorogerio.projetojsp3.model.JavaBeans" %>
   <%
   
   		ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>)request.getAttribute("contatos");
   
   		   
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="assets/telefone.png">
<link rel="stylesheet" href="assets/style.css">
<title>Agenda de Contatos</title>
</head>
<body>

	<h1>Agenda de Contatos</h1>
	
	<a href="novo_contato.html" class="botao1">Novo Contato</a>
	
	<table class="tabela" style="margin-top: 30px; width: 70vw;">		
		<thead style="background-color: #66bbff; color: white;">
			<tr>
				<th style="border: 1px solid gray;">Id</th>
				<th style="border: 1px solid gray;">Nome</th>
				<th style="border: 1px solid gray;">Fone</th>
				<th style="border: 1px solid gray;">Email</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i = 0; i < lista.size(); i++){ %>
				
				<tr >
					<td style="border: 1px solid gray; text-align: center;"><%= lista.get(i).getIdcon() %></td>
					<td style="border: 1px solid gray;"><%= lista.get(i).getNome() %></td>
					<td style="border: 1px solid gray;"><%= lista.get(i).getFone() %></td>
					<td style="border: 1px solid gray;"><%= lista.get(i).getEmail() %></td>
				</tr>
				
			<%} %>
		</tbody>
	</table>

</body>
</html>