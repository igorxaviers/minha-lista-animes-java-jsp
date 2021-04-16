function MostraPaises(apagou=false)
{   if(!apagou)
       event.preventDefault(); // evita refresh da tela, mas só pode ser utilizado 
                               // quando a função é chamada a partir de um evento
    var filtro=document.getElementById("filtro").value; // verifica o filtro
    const URL_TO_FETCH='CadastroAnime?acao=consultar&filtro='+filtro;
       
    fetch(URL_TO_FETCH, {method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('preview').innerHTML = result;
        });
    }).catch (function(err) {console.error(err);});

}


const formCadastro = document.getElementById("form-cadastro");
formCadastro.addEventListener('submit', function(e){
    e.preventDefault();
    event.preventDefault();

    const URL = 'CadastroAnime';
    let formData = new FormData(formCadastro);
    console.log(formData);

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