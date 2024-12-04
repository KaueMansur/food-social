package controller;
import database.ReceitaDAO;
import org.apache.commons.codec.digest.DigestUtils;
import database.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Receita;
import model.Usuario;

@WebServlet(name = "ReceitaController", urlPatterns = {"/receita-controller"})
public class ReceitaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String pagina = request.getParameter("pagina");
        
        if (pagina.equals("login")) {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

           

            try {

                if (r.login()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("autenticado", true);
                    response.sendRedirect("inicio.jsp");
                } else {
                    response.sendRedirect("index.html");
                }

            } catch (SQLException | ClassNotFoundException erro) {
                System.err.println(erro);
            }
        }
        if (pagina.equals("cadastro")) {

            String nome = request.getParameter("nome");
            String ingredientes = request.getParameter("ingredientes");
            String tempoDePreparo = request.getParameter("tempoDePreparo");
            String rendimento = request.getParameter("rendimento");
            String tipo = request.getParameter("tipo");
            String categorias = request.getParameter("categorias");
            String receitas = request.getParameter("receitas");
            String seguidores = request.getParameter("seguidores");
            String avaliacaoMedia = request.getParameter("avaliacaoMedia");

            Receita r = new Receita(nome, ingredientes,tempoDePreparo, rendimento, tipo,categorias,  receitas, seguidores,avaliacaoMedia);

            try {

                ReceitaDAO rDAO = new ReceitaDAO();
                rDAO.setNewUser(r);
                response.sendRedirect("index.html");

            } catch (SQLException | ClassNotFoundException erro) {
                System.err.println(erro);
            }
        }
        if (pagina.equals("excluir")) {
            int id = Integer.parseInt(request.getParameter("id"));

            try {
                ReceitaDAO dao = new ReceitaDAO();
                dao.deleteUser(id);
                response.sendRedirect("inicio.jsp");
            } catch (ClassNotFoundException | SQLException erro) {
                System.err.println(erro);
            }
        }
        if (pagina.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            try {
                ReceitaDAO dao = new ReceitaDAO();
                Receita r = dao.getOneUser(id);
                request.setAttribute("user", r);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                
            } catch (ClassNotFoundException | SQLException erro) {
                System.err.println(erro);
            }
        }

        if (pagina.equals("atualizar")) {
            int id = Integer.parseInt(request.getParameter("id"));
             
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String nascimento = request.getParameter("nasc");
            String  alergias = (request.getParameter("alergias"));
            String receitas = request.getParameter("receitas");
            String seguidores = request.getParameter("seguidores");
            String avaliacaoMedia = request.getParameter("avaliacaoMedia");

            Receita r = new Receita(nome, email, telefone, nascimento, alergias,receitas, seguidores, avaliacaoMedia, avaliacaoMedia);

            try {

                ReceitaDAO rDAO = new ReceitaDAO();
                rDAO.updateUser(r);
                response.sendRedirect("inicio.jsp");

            } catch (SQLException | ClassNotFoundException erro) {
                System.err.println(erro);
            }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws controller.ServletException
     * @throws controller.ServletException
     * @throws controller.ServletException
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
