package com.yush.users;

import com.yush.dao.UsersDAOImpl;
import com.yush.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsersDelete")
public class UsersDelete extends HttpServlet {
    private static final Logger log = Logger.getLogger(UsersDelete.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("UsersDelete Start");
        User delUser;
        UsersDAOImpl usersDAO = new UsersDAOImpl();
        String userID = request.getParameter("USER_ID");
        log.debug("userID = " + userID);
        response.getWriter().println("userID" + userID);
        if (!userID.isEmpty()) {
            try {
                long id = Long.parseLong(userID);
                log.debug("id = " + id);
                delUser = usersDAO.getByID(id);
                log.debug("setId");
                response.getWriter().println("delProduct" + delUser);
                if (delUser == null) {
                    response.getWriter().println("no product with this id" + userID);
                } else {
                    usersDAO.delete(delUser);
                    log.debug("delete");
                    response.getWriter().println("Delete was successful");
                }
            } catch (Exception e) {
                log.info("Exception in ProductDelete" + e);
            }
        }
        log.debug("UsersDelete End");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
