package innopolis.less.registration.activites;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import innopolis.less.registration.collections.Users;
import innopolis.less.registration.utils.DataFiller;

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
        DataFiller.fill();
        startActivity(new Intent(this, GroupsActivity.class));
    }



    private void showLogin() {
        Intent loginActivity = new Intent(this, LoginActivity.class);
        startActivityForResult(loginActivity, LOGIN_FORM);
    }
}
