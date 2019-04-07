package ru.kogut.servlet;

import ru.kogut.model.UserEntity;
import ru.kogut.model.UserRoleEntity;
import ru.kogut.service.UserRoleService;
import ru.kogut.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author S.Kogut on 2019-04-07
 */

@WebServlet("/registration")
public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/view/registration.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        String email = req.getParameter("email");

        String errorMessage = "";
        if (userName.equals("") || login.equals("") || password.equals("")){
            errorMessage = "Fild is empty";
        }

        if (!password.equals(repassword)){
            errorMessage = "Fild password and fild repassword not equals";
        }

        final UserService userService = new UserService();
        final UserRoleService userRoleService = new UserRoleService();

        UserEntity userEntity = userService.findByLogin(login);

        if (userEntity != null){
            errorMessage = "This login already exists";
        }else {
            userEntity = new UserEntity();
            String userId = UUID.randomUUID().toString();
            userEntity.setId(userId);
            userEntity.setLogin(login);
            userEntity.setName(userName);
            userEntity.setPassword(password);
            userEntity.seteMail(email);
            userService.create(userEntity);
            final UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setId(UUID.randomUUID().toString());
            userRoleEntity.setRoleId("2"); // Заглушка роль user
            userRoleEntity.setUserId(userId);
            userRoleService.create(userRoleEntity);
        }

        if (!errorMessage.isEmpty()) {
            req.setAttribute("errorString", errorMessage);

            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/view/registration.jsp");

            dispatcher.forward(req, resp);
            return;
        }else{
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/view/login.jsp");
            dispatcher.forward(req, resp);
            return;
        }
    }
}
