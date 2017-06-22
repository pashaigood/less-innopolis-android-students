package innopolis.less.registration.collections;

import java.util.HashMap;

public class Users {
    private static HashMap<String, String> collection = new HashMap<>();
    private static boolean isAuthorized = true;

    static {
        collection.put("admin", "admin");
    }

    public static boolean isAuthorized() {
        return isAuthorized;
    }

    public static boolean auth(String login, String password) {
        if (collection.containsKey(login) && collection.get(login).equals(password)) {
            isAuthorized = true;
        }
        return isAuthorized;
    }

    public static void register(String login, String password) {
        collection.put(login, password);
    }

    public static boolean checkCredentials(String login, String password, String confim) {
       return true;
    }
}
