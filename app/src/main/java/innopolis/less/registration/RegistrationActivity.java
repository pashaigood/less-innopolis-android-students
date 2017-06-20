package innopolis.less.registration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import innopolis.less.registration.collections.Users;

public class RegistrationActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private EditText confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        login = (EditText) findViewById(R.id.registration_login);
        password = (EditText) findViewById(R.id.registration_password);
        confirm = (EditText) findViewById(R.id.registration_confirm);
    }

    public void signUp(View view) {
        if (Users.checkCredentials(login.getText().toString(), password.getText().toString(), confirm.getText().toString())) {
            Users.register(login.getText().toString(), password.getText().toString());
            Toast.makeText(this, "Sing up is successfully, please sign in with your credentials.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Sorry, can't sing up with this credentials.", Toast.LENGTH_LONG).show();
        }
    }

    public void stop(View view) {
        finish();
    }
}
