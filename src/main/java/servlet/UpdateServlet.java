package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = null;
        String put = null;
        if (req.getParameter("put") == null) {
            id = Long.parseLong(req.getParameter("id"));
            try {
                User updated = userService.getUserById(id);
                req.setAttribute("id", id);
                req.setAttribute("firstName", updated.getFirstName());
                req.setAttribute("password", updated.getPassword());
                req.setAttribute("role", updated.getRole());
                req.getServletContext().getRequestDispatcher("/jsp/update.jsp").forward(req, resp);
                resp.setStatus(200);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            id = Long.parseLong(req.getParameter("id"));
            String firstName = req.getParameter("firstName");
            String password = req.getParameter("password");
            String role = req.getParameter("role");
            User updated = new User(id, firstName, password, role);
            userService.updateUser(updated);
            req.getServletContext().getRequestDispatcher("/admin").forward(req, resp);
            resp.setStatus(200);
        }
    }

}
