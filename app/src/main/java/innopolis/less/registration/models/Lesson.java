package innopolis.less.registration.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import innopolis.less.db.Model;

public class Lesson extends Model {
    private String name;
    private Date timeFrom;
    private Date timeTo;
    private String classRoom;
    private String description;
    private String subject;
    private String lectorName;
    private List<Group> groups = new ArrayList<>();

    public Lesson(String name, Date timeFrom, Date timeTo, String classRoom, String description, String subject, String lectorName) {
        this.name = name;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.classRoom = classRoom;
        this.description = description;
        this.subject = subject;
        this.lectorName = lectorName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
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
}
