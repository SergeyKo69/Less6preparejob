package ru.kogut.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;
import java.util.List;

/**
 * @author S.Kogut on 2019-04-06
 */
public class UserRoleRequestWrapper extends HttpServletRequestWrapper {
    private String user;
    private List<String> roles = null;
    private HttpServletRequest realRequest;

    public UserRoleRequestWrapper(String user, List<String> roles, HttpServletRequest request) {
        super(request);
        this.user = user;
        this.roles = roles;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (roles == null) {
            return this.realRequest.isUserInRole(role);
        }
        return roles.contains(role);
    }

    @Override
    public Principal getUserPrincipal() {
        if (this.user == null) {
            return realRequest.getUserPrincipal();
        }

        return new Principal() {
          public String getName() {
                return user;
            }
        };
    }
}
