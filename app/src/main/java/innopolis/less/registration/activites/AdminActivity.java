package innopolis.less.registration.activites;

import android.content.Intent;
import android.support.v4.util.TimeUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import innopolis.less.registration.R;

public class AdminActivity extends AppCompatActivity {

    private ListView entitiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        initEntities();
    }

    private void initEntities() {
        entitiesList = (ListView) findViewById(R.id.entities);
        final String[] entities = new String[] {
                getString(R.string.title_activity_groups),
                getString(R.string.title_activity_students),
                getString(R.string.title_activity_journal)
        };
        ArrayAdapter<String> entitiesAdapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_expandable_list_item_1,
            entities
        );

        entitiesList.setAdapter(entitiesAdapter);
        entitiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println();
                String className = entities[i];

                Class<?> classObject = null;
                if(className != null) {
                    try {
                        classObject = Class.forName(String.format("innopolis.less.registration.activites.Admin%sActivity", className));

                        Intent intent = new Intent(AdminActivity.this, classObject);
                        startActivity(intent);
                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        Toast.makeText(AdminActivity.this, String.format("Sorry, can't find interface for %s", className.toLowerCase()), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
