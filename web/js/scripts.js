//Carrega a lista de animes ao entrar na página
document.addEventListener("DOMContentLoaded", () => {
    mostraAnimes();
});

//Coloca a losta de animes no html
function mostraAnimes(apagou=false)
{   
    if(!apagou)
       event.preventDefault(); 
    var busca = document.getElementById("filtro").value; 
    const URL = 'AnimesController?acao=busca&busca='+busca;
       
    fetch(URL, {method:'get'})
        .then((response) => {
            return response.text()
        })
        .then((result) => {
            document.getElementById('lista-animes').innerHTML = result;
        })
        .then(() => {
            addEventos();
        })
        .catch(function(err){
            console.error(err);
        });
}

var URL = '';
var acaoAlterar;
var acaoExcluir;
var retorno;

//Adiciona eventos de click nos botões de alterar e excluir

//Função ainda não completa 😬
function addEventos(){
    const animes = document.getElementsByClassName('anime');
    for(ani of animes)
    {
        let id = ani.getAttribute('data-id');
        let obj;
        
        //Botão alterar
        acaoAlterar = ani.querySelector('.acao-alterar');
        acaoAlterar.addEventListener('click', () => {          
            formCadastro.classList.remove('esconde');  
            URL = 'AnimesController?acao=alterar&id='+id;
            retornaServlet(URL, "alterar");
        });
    
        //Botão excluir
        acaoExcluir = ani.querySelector('.acao-excluir');
        acaoExcluir.addEventListener('click', () => {
            URL = 'AnimesController?acao=excluir&id='+id;
            if(confirm("Delete this anime ?"))
            {
                retornaServlet(URL,);
                mostraAnimes()
            }  
            console.log(retorno)

        });   
    }
}

//Retorna o resultado do fetch do URL recebido como parâmetro (funciona???!!!)
function retornaServlet(URL, acao = "")
{   
    fetch(URL,{method:'get'/*opcional*/}).then(function(response)
    {
        if(acao != "alterar")
            return response.text();
        
        response.text().then(function(result)  //response é um promisse
        {
            let aux = result; 
            let anime = aux.split(",");
            console.log(anime);
            let form =  document.forms["form-cadastro"]
            console.log(form)
            let src = anime[2].split('/')[1];
            
            form.genero.value = anime[3]
            form.nome.value = anime[1]
            form.imagem.src = src
            form.imagem.className = "d-none"
            form.showFileName.value = src
            form.showFileName.className = "form-control d-block"
            form.cod.value = anime[0]
                        
        });
    }).catch (function(err) {console.error(err);});

}

//Cadatro de animes
const formCadastro = document.getElementById('form-cadastro');
formCadastro.addEventListener('submit', (e) => {
    e.preventDefault();

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
            else
            {
                console.log(retorno);
                formCadastro.reset();
                mostraAnimes(true)
            }
        })
});

//Botão de busca de animes
const formBusca = document.getElementById('form-busca');
formBusca.addEventListener('submit', (e) => {
    e.preventDefault();
    mostraAnimes();
});

//Botão de adicionar novo anime
const btNovo = document.querySelector('.novo-anime');
btNovo.addEventListener('click', () => {
    formCadastro.classList.remove('esconde');
    console.log(formCadastro)
    formCadastro[0].value = " "
    formCadastro[1].value = 1
    formCadastro[2].classList.remove("d-none")
    formCadastro[2].className = "form-control d-block"
    formCadastro[2].src = ""
    
    formCadastro[3].value = ""
    formCadastro[3].className = "d-none"

});

//Botão de fechar o form de cadastro 
const btFechar = document.querySelector('.fechar');
btFechar.addEventListener('click', () => {
    formCadastro.classList.add('esconde');
});