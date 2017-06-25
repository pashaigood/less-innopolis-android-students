package innopolis.less.registration.activites;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.Date;

import innopolis.less.registration.collections.Groups;
import innopolis.less.registration.collections.Students;
import innopolis.less.registration.collections.Users;
import innopolis.less.registration.models.Group;
import innopolis.less.registration.models.Student;

public class MainActivity extends AppCompatActivity {

    private static final int LOGIN_FORM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (! Users.isAuthorized()) {
            showLogin();
        } else {
            start();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOGIN_FORM && resultCode == Activity.RESULT_OK) {
            start();
        }
        else {
            showLogin();
        }
    }

    private void start() {
        fillMockData();
        startActivity(new Intent(this, GroupsActivity.class));
    }


    private void fillMockData() {
        Groups groups = Groups.getInstance();
        groups.create(new Group("Android"));
        groups.create(new Group("Servlet"));
        groups.create(new Group("Testing"));
        groups.create(new Group("JavaCore"));
        groups.create(new Group("C++"));
        groups.create(new Group("ASM"));
        groups.create(new Group("Frontend"));

        Students students = Students.getInstance();
        students.create(new Student("Pavel", "Belugin", "Andreevich", new Date(90, Calendar.SEPTEMBER, 30), (groups.get(0)).getId()));
        students.create(new Student("Artomonow", "Sergey", "Victorovich", new Date(85, Calendar.OCTOBER, 20), (groups.get(0)).getId()));
        students.create(new Student("Borisow", "Vladimir", "Dmitreevich", new Date(54, Calendar.JANUARY, 12), (groups.get(0)).getId()));
    }

    private void showLogin() {
        Intent loginActivity = new Intent(this, LoginActivity.class);
        startActivityForResult(loginActivity, LOGIN_FORM);
    }
}
