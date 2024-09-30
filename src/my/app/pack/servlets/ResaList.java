package my.app.pack.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.app.pack.classes.Resa;
import my.app.pack.dao.ResaDAO;
import my.app.pack.dao.UserDAO;

@WebServlet(value = {"/resalist"})
public class ResaList extends HttpServlet{
    private ResaDAO resaDAO=new ResaDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO=(UserDAO) getServletContext().getAttribute("users");
        req.setAttribute("users", userDAO.findAll());
        req.setAttribute("resas", resaDAO.findAll());
        RequestDispatcher dispat=req.getRequestDispatcher("pages/interface.jsp");
        dispat.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title=req.getParameter("title");
        String dateRequete=req.getParameter("date-resa");
        String heureRequete=req.getParameter("heure");
        String dureeRequete=req.getParameter("duree");
        String operation=req.getParameter("operation");
        if(title==null||dateRequete==null||heureRequete==null||dureeRequete==null||operation==null){
            resp.sendRedirect("/mim/resalist");
        }
        switch(operation){
            case "add":
                LocalDate date=LocalDate.parse(dateRequete);
                LocalTime heure=LocalTime.parse(heureRequete);
                double duree=Double.parseDouble(dureeRequete);
                Resa resa=new Resa(title, date, heure, duree);
                resaDAO.save(resa);
                break;
            case "update":
                // Nothing for now as we didn't touch this yesterday
                break;
        }
        resp.sendRedirect("/mim/resalist");
    }
    
}
