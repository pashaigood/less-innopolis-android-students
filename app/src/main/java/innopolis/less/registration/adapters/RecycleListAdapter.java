package innopolis.less.registration.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.List;

import innopolis.less.registration.abstractions.RecycleHolder;

public class RecycleListAdapter<T> extends RecyclerView.Adapter implements Filterable {
    private List<T> filteredItems;
    private List<T> items;
    private RecycleHolder viewHolder;
    private int layout;
    private AdapterView.OnItemClickListener itemClickListener;


    public RecycleListAdapter(List<T> items, int layout, RecycleHolder viewHolder) {
        this.items = items;
        this.filteredItems = items;
        this.layout = layout;
        this.viewHolder = viewHolder;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder<T> holder = new ViewHolder<>(v);
        holder.setHolder(viewHolder);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(filteredItems.get(position));
    }

    @Override
    public int getItemCount() {
        return filteredItems.size();
    }

    public void onItemClickListener(AdapterView.OnItemClickListener clickListener) {
        this.itemClickListener = clickListener;
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                final FilterResults results = new FilterResults();
                filteredItems = viewHolder.filter(charSequence, items);
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

    private class ViewHolder<T> extends RecyclerView.ViewHolder {
        private RecycleHolder holder;
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

        public void setHolder(RecycleHolder holder) {
            this.holder = holder;
        }

        public void bind(T object) {
            holder.bind(itemView, object);
        }
    }
}
