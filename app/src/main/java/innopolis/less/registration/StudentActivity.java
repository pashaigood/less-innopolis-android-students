package innopolis.less.registration;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import innopolis.less.registration.adapters.JournalListAdapter;
import innopolis.less.registration.models.Journal;

public class StudentActivity extends Activity {

    private ListView listJournal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        initContacts();
        initJournal();
    }

    private void initContacts() {
        ListView listContacts = findViewById(R.id.contacts);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, new String[] {
                "+7 926 123 456 78 78",
                "+7 926 123 435 45 4554",
                "test@gmail.com",
                "test2@innopolis.com",
                "vk.com",
                "http://github.com/pashaigood",
        });

        listContacts.setAdapter(arrayAdapter);

        listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("clicked");
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
