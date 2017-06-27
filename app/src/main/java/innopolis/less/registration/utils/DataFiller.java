package innopolis.less.registration.utils;

import java.util.Calendar;
import java.util.Date;

import innopolis.less.db.SearchModel;
import innopolis.less.registration.R;
import innopolis.less.registration.collections.Groups;
import innopolis.less.registration.collections.Users;
import innopolis.less.registration.models.Group;
import innopolis.less.registration.models.Student;

public class DataFiller {
    public static void fill() {
        fillGroups();
        fillStudents();
    }

    private static void fillGroups() {
        Groups groups = Groups.getInstance();
        groups.create(new Group("Android"));
        groups.create(new Group("Servlet"));
        groups.create(new Group("Testing"));
        groups.create(new Group("JavaCore"));
        groups.create(new Group("C++"));
        groups.create(new Group("ASM"));
        groups.create(new Group("Frontend"));
    }

    private static void fillStudents() {
        Group group = Groups.getInstance().find(new SearchModel() {
            String name = "Android";
        }).get(0);

        Users.register(new Student("Belugin", "Pavel", "Andreevich", new Date(90, Calendar.SEPTEMBER, 30), group.getId()){{
            setPhoto(R.drawable.pbelugin);
        }});
        Users.register(new Student("Artomonow", "Sergey", "Victorovich", new Date(85, Calendar.OCTOBER, 20), group.getId()));
        Users.register(new Student("Borisow", "Vladimir", "Dmitreevich", new Date(54, Calendar.JANUARY, 12), group.getId()));
    }
}
