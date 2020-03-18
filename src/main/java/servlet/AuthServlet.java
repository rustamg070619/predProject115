package servlet;


import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class AuthServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/auth.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String password = request.getParameter("password");

        if (userService.isExistUser(new User(firstName, password))) {
            User user = userService.getUserByName(firstName);
            String role = user.getRole();
            if (role.equals("admin")) {
                request.getServletContext().getRequestDispatcher("/home").forward(request, response);
            } else if (role.equals("user")) {
                request.getServletContext().getRequestDispatcher("/update").forward(request, response);
            }
        } else {
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println("Your login or password is incorrect!");
        }

    }
}
