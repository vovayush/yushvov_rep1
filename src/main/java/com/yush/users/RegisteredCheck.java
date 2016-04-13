package com.yush.users;

import com.yush.dao.UsersDAOImpl;
import com.yush.entity.User;
import com.yush.entity.components.Address;
import com.yush.entity.components.Email;
import com.yush.entity.components.Phone;

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
        Email email = null;
        Address address = null;
        Phone phone = null;

        if (requestParameterCheck(request)) {
            User createdUser = new User(request.getParameter("firstName"),
                    request.getParameter("lastName"),
                    request.getParameter("login"),
                    request.getParameter("password"),
                    request.getParameter("description"));
            UsersDAOImpl usersDAO = new UsersDAOImpl();
            if (!request.getParameter("email").isEmpty()) {
                email = new Email(request.getParameter("email"));
                createdUser.getEmails().add(email);
            }
            if (!request.getParameter("address").isEmpty()) {
               /* address = new Address(request.getParameter("address"));
                createdUser.getAddresses().add(address);*/
            }
            if (!request.getParameter("phone").isEmpty()) {
                phone = new Phone(request.getParameter("phone"));
                createdUser.getPhones().add(phone);
            }


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
