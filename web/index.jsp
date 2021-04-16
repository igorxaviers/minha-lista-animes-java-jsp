<%-- 
    Document   : index
    Created on : 14/04/2021, 15:23:27
    Author     : igorr
--%>

<%@page import="bd.dal.DALGenero"%>
<%@page import="bd.entidades.Genero"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/a8349f7f3a.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="col-md-8 mx-auto">
        <header class="text-center py-5">
            <h1><a href="">Minha Lista <strong>Animes</strong></a></h1>
        </header>
        <main>
            <form method="GET" id="form-busca" class="busca mb-5 col-8 mx-auto">
                <div class="input-group rounded-3">
                    <input type="text" class="form-control py-3 border-0" placeholder="Busque por animes..." aria-label="Busque por animes...">
                    <button class="btn btn-green px-5" type="submit" id="button-addon2"><i class="fas fa-search"></i></button>
                </div>
            </form>

            <div class="novo-anime-form col-md-5 col-12 mx-auto p-4 mb-5 bg-white rounded-3">
                <h4 class="mb-5">Novo anime: </h4>
                <form method="POST" action="CadastroAnime" enctype="multipart/form-data" id="form-cadastro">

                    <div class="mb-3 row">
                        <label for="nome" class="col-sm-2 col-form-label">Nome: </label>
                        <div class="col-sm-10">
                            <input type="text" name="nome" class="form-control" id="nome">
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <label for="genero" class="col-sm-2 col-form-label">Gênero: </label>
                        <div class="col-sm-10">
                            <select class="form-select" name="genero" id="genero">
                                <%
                                    ArrayList<Genero> lista = new DALGenero().getGeneros("");
                                    for(Genero g : lista){
                                        out.println("<option value='"+g.getId()+"'>"+g.getNome()+"</option>");
                                    }
                                    out.println("<option>aaa</option>");
                                %>
                                <option selected>Escolha o gênero</option>
                            </select>
                        </div>
                    </div>

                    <div class="mb-5 row">
                        <label for="imagem" class="col-sm-2 col-form-label">Imagem: </label>
                        <div class="col-sm-10">
                            <input class="form-control" type="file" name="imagem" id="imagem">
                        </div>
                    </div>

                    <button class="btn btn-green px-5 w-100 py-2" type="submit" id="button-addon2">Cadastrar </button>

                </form>
            </div>

            <div>
                <div class="row justify-content-center">
                    <div class="col-6 col-md-3 ">
                        <div class="anime">
                            <div class="acoes">
                                <div class="acao"><i class="fas fa-trash-alt"></i></div>
                                <div class="acao"><i class="fas fa-pencil-alt"></i></div>
                            </div>
                            <img src="images/33657.jpg" alt="" class="d-block mx-auto">
                            <p class="titulo my-3 text-center">Hunter x Hunter</p>
                            <div class="mx-auto d-flex justify-content-center">
                                <p class="genero">Hentai</p>
                                <p class="genero">Hentai</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-md-3 ">
                        <div class="anime">
                            <div class="acoes">
                                <div class="acao"><i class="fas fa-trash-alt"></i></div>
                                <div class="acao"><i class="fas fa-pencil-alt"></i></div>
                            </div>
                            <img src="images/33657.jpg" alt="" class="d-block mx-auto">
                            <p class="titulo my-3 text-center">Hunter x Hunter</p>
                            <div class="mx-auto d-flex justify-content-center">
                                <p class="genero">Hentai</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-md-3 ">
                        <div class="anime">
                            <div class="acoes">
                                <div class="acao"><i class="fas fa-trash-alt"></i></div>
                                <div class="acao"><i class="fas fa-pencil-alt"></i></div>
                            </div>
                            <img src="images/33657.jpg" alt="" class="d-block mx-auto">
                            <p class="titulo my-3 text-center">Hunter x Hunter</p>
                            <div class="mx-auto d-flex justify-content-center">
                                <p class="genero">Hentai</p>
                                <p class="genero">Hentai</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-md-3 ">
                        <div class="anime">
                            <div class="acoes">
                                <div class="acao"><i class="fas fa-trash-alt"></i></div>
                                <div class="acao"><i class="fas fa-pencil-alt"></i></div>
                            </div>
                            <img src="images/33657.jpg" alt="" class="d-block mx-auto">
                            <p class="titulo my-3 text-center">Hunter x Hunter</p>
                            <div class="mx-auto d-flex justify-content-center">
                                <p class="genero">Hentai</p>
                                <p class="genero">Hentai</p>
                                <p class="genero">Hentai</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="novo-anime">
                <i class="fas fa-plus"></i><br>
                novo anime
            </div>
        </main>
        <footer>

        </footer>
        <svg class="svg-bg" width="651" height="675" viewBox="0 0 651 675" fill="none" xmlns="http://www.w3.org/2000/svg">
            <rect x="360.33" width="490.073" height="472.017" rx="126" transform="rotate(53.6832 360.33 0)" fill="#00D6A2"/>
        </svg>
        <!-- <script src="js/scripts.js"></script> -->
            
    </body>
</html>
