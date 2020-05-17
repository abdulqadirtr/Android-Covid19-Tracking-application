package app.easylink.healthMonitor.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import app.easylink.healthMonitor.R;
import io.reactivex.annotations.NonNull;


public class PostAdapteer extends RecyclerView.Adapter<PostViewHolder> implements Filterable {

    Context context;
    List<Post> postList;
    private List<Post> exampleListFull;

    public PostAdapteer(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
        exampleListFull = new ArrayList<>(postList);
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.country_name.setText(String.valueOf(postList.get(position).getCountryregion()));
        holder.province_name.setText(String.valueOf(postList.get(position).getProvincestate()));
        holder.confirm.setText(String.valueOf(postList.get(position).getConfirmed()));
        holder.deaths.setText(String.valueOf(postList.get(position).getDeaths()));
        holder.recoverd.setText(String.valueOf(postList.get(position).getRecovered()));

        SharedPreferences pref = context.getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", postList.get(position).getCountryregion()+" has "+postList.get(position).getConfirmed()); // Storing string
        editor.commit();



        //holder.txt_content.setText(new StringBuilder(postList.get(position).body.substring(0,2))
        //.append("...").toString());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            List<Post> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {

                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Post item : exampleListFull) {
                    if (item.getCountryregion().toString().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }

                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            postList.clear();
            postList.addAll((List<Post>) results.values);
            notifyDataSetChanged();


        }
    };

    }
