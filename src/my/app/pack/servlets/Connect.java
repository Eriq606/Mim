package my.app.pack.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.app.pack.classes.User;
import my.app.pack.dao.UserDAO;

@WebServlet(value = {"/connect"})
public class Connect extends HttpServlet{
    @Override
    public void init() throws ServletException {
        ServletContext context=getServletContext();
        UserDAO userDAO=new UserDAO();
        context.setAttribute("users", userDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispat=req.getRequestDispatcher("pages/connect.jsp");
        dispat.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom=req.getParameter("nom");
        String motDePasse=req.getParameter("mot-de-passe");
        User nouveau=new User(nom, motDePasse);
        ServletContext context=getServletContext();
        UserDAO userDAO=(UserDAO) context.getAttribute("users");
        userDAO.save(nouveau);
        resp.sendRedirect("/mim/resalist");
    }
    
}
