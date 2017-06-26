package innopolis.less.registration.models;

import innopolis.less.db.Model;
import innopolis.less.registration.constants.UserGroup;

public class User extends Model {
    private String login;
    private String password;
    protected UserGroup userGroup;

    {
        userGroup = UserGroup.VIEWER;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
}
