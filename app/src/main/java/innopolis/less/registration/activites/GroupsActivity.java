package innopolis.less.registration.activites;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import innopolis.less.registration.R;
import innopolis.less.registration.adapters.GroupListAdapter;
import innopolis.less.registration.models.Group;

public class GroupsActivity extends Activity {
    RecyclerView groupsRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        groupsRecyclerView = findViewById(R.id.students);

        ArrayList<Group> groups = new ArrayList<Group>() {{
            add(new Group("Android"));
            add(new Group("Server side"));
        }};

        final GroupListAdapter groupListAdapter = new GroupListAdapter(groups);
        groupsRecyclerView.setAdapter(groupListAdapter);
        groupsRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }
}
