package innopolis.less.registration.activites;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import innopolis.less.registration.R;
import innopolis.less.registration.adapters.JournalListAdapter;
import innopolis.less.registration.collections.Users;
import innopolis.less.registration.constants.UserGroup;
import innopolis.less.registration.models.Journal;
import innopolis.less.registration.models.Student;
import innopolis.less.registration.models.User;

public class StudentActivity extends AppCompatActivity {
    private ListView listJournal;
    private Student student;
    private EditText surename;
    private EditText name;
    private EditText patronymic;
    private ImageView photo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        student = (Student) Users.getInstance().read(getIntent().getLongExtra("id", 0l));

        if (student == null || ! student.getUserGroup().equals(UserGroup.STUDENT)) {
            finish();
        }


        initUserInfo();
        initContacts();
        initJournal();
    }

    private void initUserInfo() {
        surename = (EditText) findViewById(R.id.surename);
        name = (EditText) findViewById(R.id.name);
        patronymic = (EditText) findViewById(R.id.patronymic);
        photo = (ImageView) findViewById(R.id.photo);

        surename.setText(student.getSurename());
        name.setText(student.getName());
        patronymic.setText(student.getPatronymic());
        if (student.hashPhoto()) {
            photo.setImageResource(student.getPhoto());
            photo.setColorFilter(R.color.colorWhite, PorterDuff.Mode.LIGHTEN);

        } else {
            photo.setImageResource(R.drawable.ic_account_circle_black_24dp);
        }
    }

    private void initContacts() {
        ListView listContacts = (ListView) findViewById(R.id.contacts);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                new String[] {
                    "+7 926 123 456 78 78",
                    "+7 926 123 435 45 4554",
                    "test@gmail.com",
                    "test2@innopolis.com",
                    "vk.com",
                    "http://github.com/pashaigood",
                }
        );

        listContacts.setAdapter(arrayAdapter);

        listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView clicked = view.findViewById(android.R.id.text1);
                Toast.makeText(StudentActivity.this, clicked.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initJournal() {
        ArrayList<Journal> journals = new ArrayList<Journal>() {{
            add(new Journal(0L, 0L));
        }};
        listJournal = (ListView) findViewById(R.id.journal);
        listJournal.setAdapter(new JournalListAdapter(this, journals));
    }
}
