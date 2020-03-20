package servlet;


import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/auth.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String password = req.getParameter("password");

        if (UserService.getInstance().isExistUser(new User(firstName, password))) {
            HttpSession session = req.getSession();
            session.setAttribute("user", firstName);
            req.getServletContext().getRequestDispatcher("/admin").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth");
        }
    }
}
