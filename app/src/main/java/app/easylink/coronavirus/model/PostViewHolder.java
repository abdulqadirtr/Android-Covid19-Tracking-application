package app.easylink.coronavirus.model;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import app.easylink.coronavirus.R;
import io.reactivex.annotations.NonNull;


public class PostViewHolder extends RecyclerView.ViewHolder {
TextView country_name, province_name,last_update, confirm, deaths, recoverd;
    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        country_name=(TextView)itemView.findViewById(R.id.txt_title);
        province_name=(TextView)itemView.findViewById(R.id.text_province);
        confirm=(TextView)itemView.findViewById(R.id.text_confirm);
        deaths =(TextView)itemView.findViewById(R.id.text_death);
        recoverd =(TextView)itemView.findViewById(R.id.text_recover);
    }
}
