/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bd.dal.DALAnime;
import bd.dal.DALGenero;
import bd.entidades.Anime;
import java.util.ArrayList;

@MultipartConfig(location = "/", fileSizeThreshold = 1024 * 1024, // 1MB *
        maxFileSize = 1024 * 1024 * 100, // 100MB **
        maxRequestSize = 1024 * 1024 * 10 * 10 // 100MB ***
)

@WebServlet(name = "CadastroAnime", urlPatterns = { "/CadastroAnime" })
public class CadastroAnime extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensagem;
        Exception ex = null;
        try (PrintWriter out = response.getWriter()) {
            int cod = Integer.parseInt(request.getParameter("cod"));
            int idGenero = Integer.parseInt(request.getParameter("genero"));
            String nome = request.getParameter("nome");
            DALAnime da = new DALAnime();
            Anime anime = null;
            
            if(cod != 0 )
            {
                anime = da.getAnime(cod);
                anime.setIdGenero(idGenero);
                anime.setNome(nome); 
                da.alterar(anime);
                //nao da pra mudar imagem pois mt estressante
            }
            

            String path = getServletContext().getRealPath("/images") + "/";
            String filePath = "images/", fileRealName = "";
            mensagem = "dados e foto recebidos com sucesso";
            Part imagem = request.getPart("imagem");
            
            byte[] img = new byte[(int) imagem.getSize()];
            imagem.getInputStream().read(img);
            FileOutputStream arquivo = new FileOutputStream(new File(path + imagem.getSubmittedFileName()));
            fileRealName = filePath + imagem.getSubmittedFileName();

            arquivo.write(img);
            arquivo.close();
    
            anime = new Anime(0, idGenero, nome, fileRealName);

            da.salvar(anime);

        } catch (Exception e) {
            mensagem = "Erro ao cadastrar";
            ex = e;
        }

        try (PrintWriter out = response.getWriter()) {
            out.print(ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
