package com.approck.paycam.modules.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.approck.paycam.R;
import com.approck.paycam.modules.models.history_item;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class History_adapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<history_item> categories;
    CLICK click;
    String[] allColors ;

    public History_adapter(Context context) {
        this.context = context;
        allColors= context.getResources().getStringArray(R.array.colors);
    }


    public void setCategories(ArrayList<history_item> categories) {
        this.categories=categories;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.history_item, viewGroup, false);
        return new Data_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Data_Holder data_holder = (Data_Holder) viewHolder;
        SetViewValus(data_holder, position);
    }

    private void SetViewValus(Data_Holder data_holder, final int position) {
        Data_Holder holder = data_holder;
        final history_item item = categories.get(position);
//        holder.name.setText(item.getTitel());


//
        holder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.click_Listner("","","","","");
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public class Data_Holder extends RecyclerView.ViewHolder {
        TextView titel,date;
        CardView itemCardView;

        public Data_Holder(final View itemView) {
            super(itemView);
            itemCardView = (CardView) itemView.findViewById(R.id.itemCardView);
            titel = (TextView) itemView.findViewById(R.id.titel);
            date = (TextView) itemView.findViewById(R.id.date);

        }
    }

    public interface CLICK {
        void click_Listner(String id,String titel,String description, String date, String quntity);

    }

    public void Set_Listner(CLICK click1) {
        this.click = (CLICK) click1;
    }



}



