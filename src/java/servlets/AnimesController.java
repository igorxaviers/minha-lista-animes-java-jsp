package servlets;

import bd.dal.DALAnime;
import bd.dal.DALGenero;
import bd.entidades.Anime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "AnimesController", urlPatterns = { "/AnimesController" })
public class AnimesController extends HttpServlet {

    // Retorna lista de animes
    public String buscaAnimes(String filtro) {
        String res = "";
        ArrayList<Anime> animes = new DALAnime().getAnime(filtro);
        DALGenero dalG = new DALGenero();
        for (Anime anime : animes) {
            res += String.format("" + "<div class=\"col-6 col-md-3 my-3\">\n" + "<div data-id=" + anime.getId()
                    + " class=\"anime\">\n" + "<div class=\"acoes\">\n"
                    + "<div class=\"acao acao-excluir\"><i class=\"fas fa-trash-alt\"></i></div>\n"
                    + "<div class=\"acao acao-alterar\"><i class=\"fas fa-pencil-alt\"></i></div>\n" + "</div>\n"
                    + "<img src=\" " + anime.getImagem() + " \" alt=\"" + anime.getNome()
                    + "\" class=\"d-block mx-auto\">\n" + "<p class=\"titulo my-3 text-center\"> " + anime.getNome()
                    + " </p>\n" + "<div class=\"mx-auto d-flex justify-content-center\">\n" + "<p class=\"genero\">"
                    + dalG.getGenero(anime.getIdGenero()).getNome() + "</p>\n" + "</div>\n" + "</div>\n" + "</div>");
        }
        return res;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Recebe a ação e decide qual função executar
        String acao = request.getParameter("acao");
        int id;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            id = 0;
        }
        DALAnime dalA = new DALAnime();

        switch (acao.toLowerCase()) {
        case "busca":
            String busca = request.getParameter("busca");
            if (!busca.isEmpty())
                busca = "UPPER(nome) LIKE '%" + busca.toUpperCase() + "%'";
            response.getWriter().print(buscaAnimes(busca));
            break;
        case "excluir":
            dalA.apagar(id);
            break;
        case "alterar":
            Anime anime = dalA.getAnime(id);
            response.getWriter().print(anime + "," + anime.getIdGenero());
            break;
        case "confirmar":

            break;
        }

        try (PrintWriter out = response.getWriter()) {

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
