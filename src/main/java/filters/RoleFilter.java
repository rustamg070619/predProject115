package filters;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/admin")
public class RoleFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String firstName = servletRequest.getParameter("firstName");
        String password = servletRequest.getParameter("password");
        try {
            String role = UserService.getInstance().getRoleByUser(new User(firstName, password));
            if (role.equals("admin")) {
                servletRequest.getServletContext().getRequestDispatcher("/admin").forward(servletRequest, servletResponse);
            } else if (role.equals("user")) {
                servletRequest.getServletContext().getRequestDispatcher("/user").forward(servletRequest, servletResponse);
            }
        } catch (IndexOutOfBoundsException e) {
            servletRequest.getServletContext().getRequestDispatcher("/jsp/auth.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
