package innopolis.less.registration.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public abstract class RecycleListAdapter<T> extends RecyclerView.Adapter implements Filterable {
    private List<T> filteredItems;
    private List<T> items;
    private int layout;
    private AdapterView.OnItemClickListener itemClickListener;


    public RecycleListAdapter(List<T> items, int layout) {
        this.items = items;
        this.filteredItems = items;
        this.layout = layout;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(filteredItems.get(position));
    }

    public T getItem(int position) {
        return filteredItems.get(position);
    }

    @Override
    public int getItemCount() {
        return filteredItems.size();
    }

    public void onItemClickListener(AdapterView.OnItemClickListener clickListener) {
        this.itemClickListener = clickListener;
    }

    public abstract void onItemCreateView(View view, T object);

    public List<T> onFilter(CharSequence charSequence, List<T> items) {
        List<T> result = new ArrayList<>();

        Iterator<T> iterator = items.iterator();
        T object;
        while (iterator.hasNext()) {
            object = iterator.next();
            if (onFilter(charSequence, object)) {
                result.add(object);
            }
        }

        return result;
    }

    public boolean onFilter(CharSequence charSequence, T object) {
        return object.toString().contains(charSequence);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                final FilterResults results = new FilterResults();
                filteredItems = onFilter(charSequence, items);
                results.values = filteredItems;
                results.count = filteredItems.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                RecycleListAdapter.this.notifyDataSetChanged();
            }
        };
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RecycleListAdapter.this.itemClickListener.onItemClick(null, view, getLayoutPosition(), getItemId());
                }
            });
        }

        public void bind(T object) {
            onItemCreateView(itemView, object);
        }
    }
}
