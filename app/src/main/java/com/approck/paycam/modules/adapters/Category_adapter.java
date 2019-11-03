package com.approck.paycam.modules.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.approck.paycam.R;
import com.approck.paycam.modules.models.catigory_item;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Category_adapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<catigory_item> categories;
    CLICK click;
    String[] allColors ;

    public Category_adapter(Context context) {
        this.context = context;
        allColors= context.getResources().getStringArray(R.array.colors);
    }


    public void setCategories(ArrayList<catigory_item> categories) {
        this.categories=categories;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.category_item, viewGroup, false);
        return new Data_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Data_Holder data_holder = (Data_Holder) viewHolder;
        SetViewValus(data_holder, position);
    }

    private void SetViewValus(Data_Holder data_holder, final int position) {
        Data_Holder holder = data_holder;
        final catigory_item item = categories.get(position);
//        holder.name.setText(item.getTitel());
        Glide.with(context).load(item.getIcon()).into(holder.catigory_icon);


//
        holder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.click_Listner("");
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public class Data_Holder extends RecyclerView.ViewHolder {
        TextView titel,description;
        CardView itemCardView;
        ImageView catigory_icon;

        public Data_Holder(final View itemView) {
            super(itemView);
            itemCardView = (CardView) itemView.findViewById(R.id.itemCardView);
            titel = (TextView) itemView.findViewById(R.id.titel);
            description = (TextView) itemView.findViewById(R.id.description);
            catigory_icon= (ImageView) itemView.findViewById(R.id.catigory_icon);
        }
    }

    public interface CLICK {
        void click_Listner(String id);

    }

    public void Set_Listner(CLICK click1) {
        this.click = (CLICK) click1;
    }



}



