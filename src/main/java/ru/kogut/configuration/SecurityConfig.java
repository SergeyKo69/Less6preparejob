package ru.kogut.configuration;

import java.util.*;

/**
 * @author S.Kogut on 2019-04-06
 */

//Заглушка иммитация таблицы с разроешениями к страницам.
public class SecurityConfig {
    public static final String ROLE_ADMIN = "Administrator";
    public static final String ROLE_USER = "User";

    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {

        List<String> urlAdmin = new ArrayList<String>();

        urlAdmin.add("/adminPage");
        urlAdmin.add("/index");
        urlAdmin.add("/");

        mapConfig.put(ROLE_ADMIN, urlAdmin);

        List<String> urlUser = new ArrayList<String>();

        urlUser.add("/userPage");
        urlUser.add("/index");
        urlUser.add("/");

        mapConfig.put(ROLE_USER, urlUser);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
