package innopolis.less.registration.collections;

import java.util.HashMap;

import innopolis.less.db.ModelsCollection;
import innopolis.less.registration.models.User;

public class Users extends ModelsCollection<User> {
    private static Users ourInstance = new Users();
    public static Users getInstance() {
        return ourInstance;
    }

    private Users() {
        FILE_NAME = "users";
    }

    private static HashMap<String, String> collection = new HashMap<>();
    private static boolean isAuthorized = false;

    static {
        register("admin", "admin");
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
        register(new User(login, password));
    }

    public static void register(String login, String password, User user) {
        user.setLogin(login);
        user.setPassword(password);
        register(user);
    }

    public static void register(User user) {
        collection.put(user.getLogin(), user.getPassword());
        getInstance().create(user);
    }

    public static boolean checkCredentials(String login, String password, String confim) {
       return password.equals(confim);
    }
}