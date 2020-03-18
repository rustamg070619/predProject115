package servlet;

import model.User;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<User> users = userService.getAllUser();
            req.setAttribute("usersFromServer", users);
            req.getServletContext().getRequestDispatcher("/jsp/admin.jsp").forward(req, resp);
            resp.setStatus(200);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<User> users = userService.getAllUser();
            req.setAttribute("usersFromServer", users);
            req.getServletContext().getRequestDispatcher("/jsp/admin.jsp").forward(req, resp);
            resp.setStatus(200);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
