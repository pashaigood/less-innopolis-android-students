package innopolis.less.registration.models;

import java.util.List;

import innopolis.less.db.Model;
import innopolis.less.db.SearchModel;
import innopolis.less.registration.collections.Users;
import innopolis.less.registration.constants.UserGroup;

public class Group extends Model {
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return (List<Student>)(List<?>) Users.getInstance().find(new SearchModel() {
            Long groupId = Group.this.getId();
            UserGroup userGroup = UserGroup.STUDENT;
        });
    }
}
