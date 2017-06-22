package innopolis.less.registration.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import innopolis.less.registration.R;
import innopolis.less.registration.adapters.GroupListAdapter;
import innopolis.less.registration.models.Group;

public class GroupsActivity extends AppCompatActivity {
    RecyclerView groupsRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        groupsRecyclerView = (RecyclerView) findViewById(R.id.students);

        ArrayList<Group> groups = new ArrayList<Group>() {{
            add(new Group("Android"));
            add(new Group("Server side"));
        }};

        final GroupListAdapter groupListAdapter = new GroupListAdapter(groups);
        groupsRecyclerView.setAdapter(groupListAdapter);
        groupsRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        groupListAdapter.onItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GroupsActivity.this, StudentActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {}
}
