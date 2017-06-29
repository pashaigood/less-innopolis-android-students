package innopolis.less.registration.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;

import innopolis.less.db.ModelsCollection;
import innopolis.less.registration.R;
import innopolis.less.registration.activites.StudentActivity;
import innopolis.less.registration.collections.Users;
import innopolis.less.registration.models.Student;


public class StudentsFragment extends Fragment implements Filterable {
    private View view;
    private ArrayAdapter<Student> itemsAdapter;


    public StudentsFragment() {
        // Required empty public constructor
    }

    public static StudentsFragment newInstance() {
        StudentsFragment fragment = new StudentsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            /*mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);*/
        }

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
        final Context context = getActivity();
        final ModelsCollection<Student> students = Users.getInstance().getStudents();
        int size = students.size();
        String[] items = new String[size];

        int i = 0;
        for (Student student: students.toArray(new Student[size])) {
            items[i++] = student.getFullName();
        }

        itemsAdapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_expandable_list_item_1,
                students.toArray(new Student[size])
        );
        ListView itemsList = view.findViewById(R.id.list_item);
        itemsList.setAdapter(itemsAdapter);
        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent studentIntend = new Intent(context, StudentActivity.class);
                studentIntend.putExtra("id", itemsAdapter.getItem(i).getId());
                startActivity(studentIntend);
            }
        });
    }

    @Override
    public Filter getFilter() {
        return itemsAdapter.getFilter();
    }
}
