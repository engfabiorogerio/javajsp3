/**
 * Validação de Formulário
 
 	@author Fábio Rogerio
 */
 
 function validar(){
	let nome = frmContato.nome.value;
	let fone = frmContato.fone.value;
	if(nome === ""){
		alert("Preencha o campo nome");
		frmContato.focus();
		return false;
	}else if(fone === ""){
		alert("Preencha o campo fone");
		frmContato.focus();
		return false;
	}else{
		document.forms['frmContato'].submit();
	}
}