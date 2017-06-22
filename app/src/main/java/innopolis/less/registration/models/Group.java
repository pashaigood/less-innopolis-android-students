package innopolis.less.registration.models;

import innopolis.less.registration.factories.Model;
import innopolis.less.registration.utils.Generator;

public class Group extends Model {
    private Long id = Generator.generateId();
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
