package innopolis.less.registration.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import innopolis.less.registration.R;
import innopolis.less.registration.models.Journal;

public class JournalListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Journal> journals;

    public JournalListAdapter(Context context, List<Journal> journals) {
        super();
        this.journals = journals;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return journals.size();
    }

    @Override
    public Object getItem(int i) {
        return journals.get(i);
    }

    @Override
    public long getItemId(int i) {
        return journals.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.partial_journal_item, viewGroup, false);
        }

        TextView pupil = (TextView) view.findViewById(R.id.pupil);
        TextView subject = (TextView) view.findViewById(R.id.subject);
        ImageView presence = (ImageView) view.findViewById(R.id.presence);

        Journal journal = (Journal) getItem(i);

        pupil.setText("test pupil");
        subject.setText("Test subject");
        presence.setImageResource(R.drawable.ic_check_black_24dp);

        return view;
    }
}
