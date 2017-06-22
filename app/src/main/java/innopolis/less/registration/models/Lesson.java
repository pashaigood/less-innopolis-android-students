package innopolis.less.registration.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import innopolis.less.registration.utils.Generator;

public class Lesson {
    private Long id = Generator.generateId();
    private String name;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;
    private String classRoom;
    private String description;
    private String subject;
    private String lectorName;
    private List<Group> groups = new ArrayList<>();

    public Lesson(String name, LocalDateTime timeFrom, LocalDateTime timeTo, String classRoom, String description, String subject, String lectorName) {
        this.name = name;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.classRoom = classRoom;
        this.description = description;
        this.subject = subject;
        this.lectorName = lectorName;
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

    public LocalDateTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalDateTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalDateTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalDateTime timeTo) {
        this.timeTo = timeTo;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLectorName() {
        return lectorName;
    }

    public void setLectorName(String lectorName) {
        this.lectorName = lectorName;
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
        if (!(obj instanceof Lesson)) {
            return false;
        }

        return ((Lesson) obj).getId().equals(id);
    }
}
