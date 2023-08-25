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
<style>
	th{
		border: 1px solid gray;
	}
	
	td{
		border: 1px solid gray;
		text-align: center;
	}
	
	.botao2{
		color: white;
		text-decoration: none;
		background-color: #66bbff;
		font-size: 1.5em;
		margin: 2px 4px;
		border-radius: 3px;
	}
	
	.botao2:hover{
		background-color: yellow;
		color: black;
		box-shadow: 1px 2px;
	}
	
	.botao3{
		color: white;
		background-color: red;
		text-decoration: none;
		font-size: 1.5em;
		margin: 2px 4px;
		border-radius: 3px;
	}
	
	.botao3:hover{
		background-color: white;
		color: red;
		box-shadow: 1px 2px;
		
	}
</style>
<title>Agenda de Contatos</title>
</head>
<body>

	<h1>Agenda de Contatos</h1>
	
	<a href="novo_contato.html" class="botao1">Novo Contato</a>
	
	<table class="tabela" style="margin-top: 30px; width: 70vw;">		
		<thead style="background-color: #66bbff; color: white;">
			<tr>
				<th >Id</th>
				<th >Nome</th>
				<th >Fone</th>
				<th >Email</th>
				<th >Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i = 0; i < lista.size(); i++){ %>
				
				<tr >
					<td ><%= lista.get(i).getIdcon() %></td>
					<td ><%= lista.get(i).getNome() %></td>
					<td ><%= lista.get(i).getFone() %></td>
					<td ><%= lista.get(i).getEmail() %></td>
					<td><a href="select?idcon=<%=lista.get(i).getIdcon() %>" class="botao2">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getIdcon() %>)" class="botao3">Excluir</a></td>
				</tr>
				
			<%} %>
		</tbody>
	</table>
	<script type="text/javascript" src="scripts/confirmador.js"></script>
</body>
</html>