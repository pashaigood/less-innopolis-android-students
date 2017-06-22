package innopolis.less.registration.models;

import java.util.ArrayList;
import java.util.List;

import innopolis.less.registration.utils.Generator;

public class Group {
    private Long id = Generator.generateId();
    private String name;
    private List<Student> students;

    public Group(String name) {
        this.name = name;
        this.students = new ArrayList<>();
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

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public int hashCode() {
        return Generator.generateHash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Group)) {
            return false;
        }

        return ((Group) obj).getId().equals(this.id);
    }
}
