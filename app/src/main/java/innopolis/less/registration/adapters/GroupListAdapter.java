package innopolis.less.registration.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import innopolis.less.registration.R;
import innopolis.less.registration.collections.Groups;
import innopolis.less.registration.models.Group;

public class GroupListAdapter extends RecyclerView.Adapter {
    private final Groups groups;
    private View.OnClickListener itemClickListener;

    public GroupListAdapter(List<Group> groups) {
        this.groups = Groups.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        return new GroupHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GroupHolder) holder).bind((Group) groups.get(position));
    }

    @Override
    public long getItemId(int i) {
        return groups.get(i).getId();
    }

    @Override
    public int getItemCount() {
        return groups.count();
    }

    public void delete(int position) {
        groups.remove(position);
        notifyItemRemoved(position);
    }

    public void delete(Group group) {
        int position = groups.indexOf(group);
        delete(position);
    }

    public void startGroup(View view, Group group) {
        itemClickListener.onClick(view);
    }

    public void onItemClickListener(View.OnClickListener clickListener) {
        this.itemClickListener = clickListener;
    }

    private class GroupHolder extends RecyclerView.ViewHolder {

        private final TextView groupName;
        private Group group;

        public GroupHolder(View itemView) {
            super(itemView);
            groupName = (TextView) itemView.findViewById(R.id.group_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startGroup(view, group);
                }
            });
        }

        public void bind(Group group) {
            this.group = group;
            groupName.setText(group.getName());
        }
    }
}
