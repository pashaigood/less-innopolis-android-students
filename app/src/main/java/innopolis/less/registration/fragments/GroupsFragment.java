package innopolis.less.registration.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import innopolis.less.db.ModelsCollection;
import innopolis.less.registration.R;
import innopolis.less.registration.activites.GroupsActivity;
import innopolis.less.registration.adapters.RecycleListAdapter;
import innopolis.less.registration.collections.Groups;
import innopolis.less.registration.models.Group;

public class GroupsFragment extends Fragment implements Filterable {
    private View view;
    private RecycleListAdapter<Group> recycleListAdapter;

    public GroupsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static GroupsFragment newInstance() {
        GroupsFragment fragment = new GroupsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(R.string.title_activity_groups);
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_groups, container, false);
        initList();
        return view;
    }

    private void initList() {
        final Context context = getActivity();
        ModelsCollection<Group> groups = Groups.getInstance();
        RecyclerView list = view.findViewById(R.id.list_item);
        recycleListAdapter = new RecycleListAdapter<Group>(groups, android.R.layout.simple_expandable_list_item_1) {
            @Override
            public void onItemCreateView(View view, Group group) {
                TextView text = view.findViewById(android.R.id.text1);
                text.setText(group.getName());
            }

            @Override
            public boolean onFilter(CharSequence charSequence, Group object) {
                return object.getName().contains(charSequence);
            }
        };
        recycleListAdapter.onItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, GroupsActivity.class);
                startActivity(intent);
            }
        });

        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(recycleListAdapter);
    }

    @Override
    public Filter getFilter() {
        return recycleListAdapter.getFilter();
    }
}
