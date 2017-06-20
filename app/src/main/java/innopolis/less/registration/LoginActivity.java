package innopolis.less.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import innopolis.less.registration.collections.Users;

public class LoginActivity extends AppCompatActivity {
    private EditText login;
    private EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (EditText) findViewById(R.id.login_login);
        password = (EditText) findViewById(R.id.login_password);
    }

    @Override
    public void onBackPressed() {
        if (Users.isAuthorized()) {
            super.onBackPressed();
        }
    }

    public void signIn(View view) {
        if (Users.auth(login.getText().toString(), password.getText().toString())) {
            Toast.makeText(this, "Hello!", Toast.LENGTH_LONG).show();
            Intent resultIntent = new Intent();
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        } else {
            Toast.makeText(this, "Sorry, can't sing in, are you singed up?", Toast.LENGTH_LONG).show();
        }
    }

    public void signUp(View view) {
        startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
    }
}
