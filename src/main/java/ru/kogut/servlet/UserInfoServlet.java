package ru.kogut.servlet;

import ru.kogut.model.UserEntity;
import ru.kogut.utils.AppUtils;
import sun.jvmstat.perfdata.monitor.AbstractPerfDataBufferPrologue;

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

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserInfoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/view/userInfo.jsp");

        UserEntity userEntity = AppUtils.getLoginedUser(request.getSession());
        if (userEntity != null){
            request.setAttribute("userName", userEntity.getName());
            request.setAttribute("login", userEntity.getLogin());
            request.setAttribute("password", userEntity.getPassword());
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
