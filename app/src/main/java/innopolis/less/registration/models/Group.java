package innopolis.less.registration.models;

import innopolis.less.db.Model;

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
}
