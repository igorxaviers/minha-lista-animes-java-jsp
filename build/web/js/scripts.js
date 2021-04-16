const formCadastro = document.getElementById("form-cadastro");
formCadastro.addEventListener('submit', function(e){
    e.preventDefault();
    event.preventDefault();

    const URL = 'CadastroAnime';
    let formData = new FormData(formCadastro);

    fetch(URL,{method: 'post',body: formData})
        .then((response)=>{
            return response.text();
        })
        .then((retorno)=>{
            if(retorno.startsWith('Erro'))
                console.log(retorno);
            //dar mensagem de erro
            else
            {
                console.log("dale");
                console.log(retorno);
                formCadastro.reset();
                //atualiza lista de animes
            }
        })
});