package innopolis.less.registration.fragments;

import android.app.Fragment;
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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import innopolis.less.db.ModelsCollection;
import innopolis.less.registration.R;
import innopolis.less.registration.abstractions.RecycleHolder;
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
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_groups, container, false);
        initList();
        return view;
    }

    private void initList() {
        ModelsCollection<Group> groups = Groups.getInstance();
        RecyclerView list = view.findViewById(R.id.list_item);
        recycleListAdapter = new RecycleListAdapter<>(
                groups,
                android.R.layout.simple_expandable_list_item_1,
                new RecycleHolder<Group>() {
                    @Override
                    public void bind(View view, Group group) {
                        TextView text = view.findViewById(android.R.id.text1);
                        text.setText(group.getName());
                    }

                    @Override
                    public List<Group> filter(CharSequence charSequence, List<Group> items) {
                        ModelsCollection<Group> result = new ModelsCollection<>();

                        Iterator<Group> iterator = items.iterator();
                        Group group;
                        while (iterator.hasNext()) {
                            group = iterator.next();
                            if (group.getName().contains(charSequence)) {
                                result.create(group);
                            }
                        }

                        return result;
                    }
                }
        );
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(recycleListAdapter);
        recycleListAdapter.onItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(String.format("%s %s", i, l));
            }
        });

    }

    @Override
    public Filter getFilter() {
        return recycleListAdapter.getFilter();
    }
}
