package innopolis.less.registration.fragments;

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
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import innopolis.less.db.ModelsCollection;
import innopolis.less.registration.R;
import innopolis.less.registration.activites.StudentActivity;
import innopolis.less.registration.adapters.RecycleListAdapter;
import innopolis.less.registration.collections.Users;
import innopolis.less.registration.models.Student;


public class StudentsFragment extends Fragment implements Filterable {
    private View view;
    private RecycleListAdapter<Student> recycleListAdapter;


    public StudentsFragment() {
        // Required empty public constructor
    }

    public static StudentsFragment newInstance() {
        StudentsFragment fragment = new StudentsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_students, container, false);
        initList();
        return view;
    }

    protected void initList() {
        RecyclerView itemsList = view.findViewById(R.id.list_item);

        final Context context = getActivity();
        final ModelsCollection<Student> students = Users.getInstance().getStudents();
        recycleListAdapter = new RecycleListAdapter<Student>(students, android.R.layout.simple_expandable_list_item_1) {
            @Override
            public void onItemCreateView(View view, Student student) {
                TextView text = view.findViewById(android.R.id.text1);
                text.setText(student.getFullName());
            }
        };

        recycleListAdapter.onItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student student = recycleListAdapter.getItem(i);
                Intent studentIntend = new Intent(context, StudentActivity.class);
                studentIntend.putExtra("id", student.getId());
                startActivity(studentIntend);
            }
        });
        itemsList.setAdapter(recycleListAdapter);
        itemsList.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public Filter getFilter() {
        return recycleListAdapter.getFilter();
    }
}
