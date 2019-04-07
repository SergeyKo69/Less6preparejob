package ru.kogut.servlet;

import ru.kogut.model.UserEntity;
import ru.kogut.service.UserService;
import ru.kogut.utils.AppUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author S.Kogut on 2019-04-06
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/view/login.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String errorMessage = "";
        if (login.isEmpty()){
            errorMessage = "Login is empty";
        }
        if (password.isEmpty()){
            errorMessage = "Password is empty";
        }

        final UserService userService = new UserService();
        UserEntity userAccount = userService.findByLoginAndPassword(login, password);

        if (userAccount == null) {
            errorMessage = "Invalid userName or Password";
        }

        if (!errorMessage.isEmpty()){
            request.setAttribute("errorString", errorMessage);

            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/view/login.jsp");

            dispatcher.forward(request, response);
            return;
        }
        AppUtils.storeLoginedUser(request.getSession(), userAccount);

        //
        int redirectId = -1;
        try {
            redirectId = Integer.parseInt(request.getParameter("redirectId"));
        } catch (Exception e) {
        }
        String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
        if (requestUri != null) {
            response.sendRedirect(requestUri);
        } else {
            // По умолчанию после успешного входа в систему
            // перенаправить на страницу /userInfo
            response.sendRedirect(request.getContextPath() + "/userInfo");
        }

    }
}
