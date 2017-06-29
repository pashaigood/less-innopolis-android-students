package innopolis.less.registration.activites;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.Toast;

import innopolis.less.registration.R;


public class AdminListActivity extends AppCompatActivity {
    protected EditText searchField;
    private Filterable adminList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_list);

        initSearchFields();
        initList();
    }

    private void initSearchFields() {
        searchField = (EditText) findViewById(R.id.search_field);
        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adminList.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void initList() {
        String fragmentName = getIntent().getStringExtra("fragment");
        System.out.println(fragmentName);

        try {
            Class AdminFragment = Class.forName(String.format("innopolis.less.registration.fragments.%sFragment", fragmentName));
            Fragment fragment = (Fragment) AdminFragment.newInstance();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.list_item, fragment);
            fragmentTransaction.commit();
            adminList = (Filterable) fragment;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Sorry, can't find list.", Toast.LENGTH_LONG).show();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        System.out.println("restore");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        System.out.println("save");
        super.onSaveInstanceState(outState);
    }
}
