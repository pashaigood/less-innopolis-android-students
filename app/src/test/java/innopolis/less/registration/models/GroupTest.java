package innopolis.less.registration.models;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import innopolis.less.registration.collections.Users;

import static org.junit.Assert.*;

public class GroupTest {
    @Test
    public void getStudents() throws Exception {
        Group group = new Group("Test group");
        Users students = Users.getInstance();
        Student s1 = new Student("F", "F", "F", new Date(), group.getId());
        Student s2 = new Student("F", "F", "F", new Date(), group.getId());

        students.create(s1);
        students.create(s2);
        students.create(new Student("F", "F", "F", new Date(), 0l));

        List<Student> groupStudents = group.getStudents();
        assertArrayEquals(new Student[] {s1, s2}, groupStudents.toArray());
    }
}