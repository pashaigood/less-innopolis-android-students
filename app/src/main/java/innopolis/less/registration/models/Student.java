package innopolis.less.registration.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import innopolis.less.registration.constants.UserGroup;

public class Student extends User {
    private String surename;
    private String name;
    private String patronymic;
    private Date dateOfBirth;
    private Long groupId;
    private int photo = 0;
    transient private List<Contact> contacts;

    {
        setUserGroup(UserGroup.STUDENT);
        this.contacts = new ArrayList<>();
    }

    public Student(String surename, String name, String patronymic, Date dateOfBirth, Long groupId) {
        super(surename, "");
        this.surename = surename;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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

    public String getFullName() {
        return String.format("%s %s %s", surename, name, patronymic).trim();
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public boolean hashPhoto() {
        return photo != 0;
    }
}
