package innopolis.less.registration.activites;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import innopolis.less.db.ModelsCollection;
import innopolis.less.registration.R;
import innopolis.less.registration.abstractions.AdminListActivity;
import innopolis.less.registration.collections.Users;
import innopolis.less.registration.models.Student;

public class AdminStudentsActivity extends AdminListActivity {

    protected void initList() {
        final ModelsCollection<Student> students = Users.getInstance().getStudents();
        int size = students.size();
        String[] items = new String[size];

        int i = 0;
        for (Student student: students.toArray(new Student[size])) {
            items[i++] = student.getFullName();
        }

        itemsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                items
        );
        itemsList = (ListView) findViewById(R.id.list_item);
        itemsList.setAdapter(itemsAdapter);
        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent studentIntend = new Intent(AdminStudentsActivity.this, StudentActivity.class);
                studentIntend.putExtra("id", students.get(i).getId());
                startActivity(studentIntend);
            }
        });
    }
}
