package innopolis.less.registration;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import innopolis.less.registration.activites.GroupsActivity;
import innopolis.less.registration.collections.Users;

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
        System.out.println("result");
    }

    private void start() {
        startActivity(new Intent(this, GroupsActivity.class));
    }

    private void showLogin() {
        Intent loginActivity = new Intent(this, LoginActivity.class);
        startActivityForResult(loginActivity, LOGIN_FORM);
    }

}
