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
        
        //Botão alterar
        acaoAlterar = ani.querySelector('.acao-alterar');
        acaoAlterar.addEventListener('click', () => {
            console.log('altera');
            URL = 'AnimesController?acao=alterar&id='+id;
            retorno = retornaServlet(URL);
            console.log(retorno);
        });
    
        //Botão excluir
        acaoExcluir = ani.querySelector('.acao-excluir');
        acaoExcluir.addEventListener('click', () => {
            console.log('exlcuir');
            URL = 'AnimesController?acao=excluir&id='+id;
        });   
    }
}

//Retorna o resultado do fetch do URL recebido como parâmetro (funciona???!!!)
function retornaServlet(URL)
{
    fetch(URL, {method:'get'})
    .then((response) => {
        return response.text();
    }).then((retorno) => {
        return retorno;
    });
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
});

//Botão de fechar o form de cadastro 
const btFechar = document.querySelector('.fechar');
btFechar.addEventListener('click', () => {
    formCadastro.classList.add('esconde');
});