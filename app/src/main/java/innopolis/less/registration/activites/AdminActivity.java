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
                String className = entities[i];

                Intent intent = new Intent(AdminActivity.this, AdminListActivity.class);
                intent.putExtra("fragment", className);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {}
}
