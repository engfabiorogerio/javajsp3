/**
 * Confirmação de Exclusão de um contato
	  @author Fábio Rogério
	  @param idcon
 */

function confirmar(idcon) {
	let resposta = confirm("Deseja excluir o registro?");
	if (resposta === true) {		
		window.location.href = "delete?idcon=" + idcon;
	}
}

