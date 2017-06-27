package innopolis.less.registration.activites;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import innopolis.less.db.ModelsCollection;
import innopolis.less.registration.R;
import innopolis.less.registration.abstractions.AdminListActivity;
import innopolis.less.registration.collections.Groups;
import innopolis.less.registration.collections.Users;
import innopolis.less.registration.models.Group;
import innopolis.less.registration.models.Student;

public class AdminGroupsActivity extends AdminListActivity {

    protected void initList() {
        int size = Groups.getInstance().size();
        Group[] groups = Groups.getInstance().toArray(new Group[size]);
        String[] items = new String[size];

        int i = 0;
        for (Group group: groups) {
            items[i++] = group.getName();
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

            }
        });
    }
}
