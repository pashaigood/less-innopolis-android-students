package innopolis.less.registration.collections;

import java.util.HashMap;
import java.util.Iterator;

import innopolis.less.db.ModelsCollection;
import innopolis.less.db.SearchModel;
import innopolis.less.registration.constants.UserGroup;
import innopolis.less.registration.models.Student;
import innopolis.less.registration.models.User;

public class Users extends ModelsCollection<User> {
    private static User authorized;
    private static Users ourInstance = new Users();
    public static Users getInstance() {
        return ourInstance;
    }

    private Users() {
        FILE_NAME = "users";
    }

    private static HashMap<String, String> collection = new HashMap<>();

    static {
        User admin = new User("admin", "admin");
        admin.setUserGroup(UserGroup.ADMIN);
        register(admin);
    }

    public static boolean isAuthorized() {
        return authorized != null;
    }

    public static boolean auth(String login, String password) {
        if (collection.containsKey(login) && collection.get(login).equals(password)) {
            authorized = getInstance().getByLogin(login);
            return true;
        }
        return false;
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

    public static boolean checkCredentials(String login, String password, String confirm) {
       return password.equals(confirm);
    }

    public static User getCurrent() {
        return authorized;
    }

    public User getByLogin(String login) {
        Iterator<User> users = getInstance().iterator();
        User user;
        while (users.hasNext()) {
            user = users.next();
            if (user.getLogin().equals(login)) return user;
        }

        return null;
    }

    public ModelsCollection<Student> getStudents() {
        return (ModelsCollection<Student>)(ModelsCollection<?>) find(new SearchModel() {
            UserGroup userGroup = UserGroup.STUDENT;
        });
    }
}