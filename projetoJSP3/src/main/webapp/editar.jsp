<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="assets/telefone.png">
<link rel="stylesheet" href="assets/style.css">
<title>Editar Contato</title>
<style type="text/css">

	#caixa3{
	padding: 5px;
	margin-bottom: 10px;
	border: 3px solid red;
	border-radius: 8px;
	width: 90px;

}

</style>
</head>
<body>

	<h1>Editar Contato</h1>
	
	<form action="update" name="frmContato">
	
		<table>
		
			<tr>
			
				<td><input id="caixa3" type="text" name="idcon" readonly="readonly" value="<%out.print(request.getAttribute("idcon"));%>"></td>
			
			</tr>
			<tr>
			
				<td><input class="caixa1" type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>"></td>
			
			</tr>
			<tr>
			
				<td><input class="caixa2" type="tel" name="fone" value="<%out.print(request.getAttribute("fone"));%>"></td>
			
			</tr>
			<tr>
			
				<td><input class="caixa1" type="email" name="email" value="<%out.print(request.getAttribute("email"));%>"></td>
			
			</tr>
		</table>
		<input class="botao1" type="button" value="Salvar" onclick="validar()">
	</form>
	<script type="text/javascript" src="scripts/validador.js"></script>
</body>
</html>