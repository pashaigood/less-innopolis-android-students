package innopolis.less.registration.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import innopolis.less.registration.factories.Model;

public class Student extends Model implements Serializable {
    private String firstName;
    private String surename;
    private String secondName;
    private Date dateOfBirth;
    private Long groupId;
    transient private List<Contact> contacts;

    public Student(String firstName, String surename, String secondName, Date dateOfBirth, Long groupId) {
        this.firstName = firstName;
        this.surename = surename;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.groupId = groupId;
        this.contacts = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
