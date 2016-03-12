package com.yush.users;

import com.yush.dao.UsersDAOImpl;
import com.yush.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "RegisteredCheck")
public class RegisteredCheck extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        if (requestParameterCheck(request)) {
            User createdUser = new User(request.getParameter("firstName"),
                    request.getParameter("lastName"),
                    request.getParameter("login"),
                    request.getParameter("password"),
                    request.getParameter("description"));
            UsersDAOImpl usersDAO = new UsersDAOImpl();
            usersDAO.insert(createdUser);
            request.getSession().setAttribute("badAuthentication", false);
            RequestDispatcher rd = context.getRequestDispatcher("/view/viewAllUser.jsp");
            rd.forward(request, response);

        } else {
            request.getSession().setAttribute("badAuthentication", true);
            RequestDispatcher rd = context.getRequestDispatcher("/authentication");
            rd.forward(request, response);
        }
    }

    private boolean requestParameterCheck(HttpServletRequest request) {
        if (request.getParameter("firstName").isEmpty()
                || request.getParameter("lastName").isEmpty()
                || request.getParameter("login").isEmpty()
                || request.getParameter("password").isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
