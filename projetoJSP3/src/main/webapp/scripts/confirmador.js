/**
 * Confirmação de Exclusão de um contato
 	@author Fábio Rogério
 */
 
 function confirmar(idcon){
	let resposta = confirm("Deseja excluir o registro?");
	if(resposta === true){
		//alert(idcon);
		window.location.href = "delete?idcon=" + idcon;
	}
}
 
 