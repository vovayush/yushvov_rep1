package com.yush.servlets.users;

import com.yush.dao.UsersDAOImpl;
import com.yush.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AuthCheck")
public class AuthCheck extends HttpServlet {
    private static final Logger log = Logger.getLogger(AuthCheck.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        if ("on".equals(request.getParameter("isNewClient"))) {
            RequestDispatcher rd = context.getRequestDispatcher("/view/user/NewUserForm.jsp");
            rd.forward(request, response);
        } else {
            try {
                if (checkUser(request.getParameter("login"), request.getParameter("password"))) {
                    response.getWriter().println("User authenticated");
                } else {
                    request.getSession().setAttribute("badAuthentication", true);
                    RequestDispatcher rd = context.getRequestDispatcher("/authentication");
                    rd.forward(request, response);
                }
            } catch (Exception e) {
                log.debug("something wrong");
            }
        }
    }

    private boolean checkUser(String login, String password) throws Exception {

        UsersDAOImpl usersDAO = new UsersDAOImpl();
        User user = usersDAO.getByLogin(login);
        log.debug("User " + user);
        if (user != null && user.getPassword().equals(password)) {
            log.debug("user != null and authenticate");
            return true;
        } else {
            log.debug("User Is Not Present");
            return false;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(request.getParameter("doGet AuthCheck"));
    }
}
