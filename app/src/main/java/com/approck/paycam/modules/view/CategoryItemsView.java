package com.approck.paycam.modules.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.approck.paycam.R;
import com.approck.paycam.common.GoToHelper;
import com.approck.paycam.modules.adapters.Category_adapter;
import com.approck.paycam.modules.models.catigory_item;

import java.util.ArrayList;

public class CategoryItemsView extends AppCompatActivity implements Category_adapter.CLICK {
    RecyclerView main_recycleView;
    ProgressBar progressBar;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    ArrayList<catigory_item> categories;
    Category_adapter adapter;
    int[] icons = {R.drawable.icon1, R.drawable.icon2, R.drawable.fax, R.drawable.icon3, R.drawable.icon4, R.drawable.icon5, R.drawable.icon1, R.drawable.icon2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_recycle_view);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Etisalat");

        categoryBindViews();

        categories = new ArrayList<>();
        bindCategory_RecyclerView(categories);
        getCatigories();
    }

    private void categoryBindViews() {
        main_recycleView = (RecyclerView) findViewById(R.id.main_recycleView);
        progressBar = findViewById(R.id.progress);
    }

    public void bindCategory_RecyclerView(ArrayList<catigory_item> main_arry) {
//        Collections.reverse(main_arry);

        adapter = new Category_adapter(this);
        adapter.Set_Listner(this);
        staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(
                        1, //The number of Columns in the grid
                        LinearLayoutManager.VERTICAL);
//        layoutManager = new LinearLayoutManager(this,LinearLayout.HORIZONTAL,true);
        main_recycleView.setLayoutManager(staggeredGridLayoutManager);
        main_recycleView.setHasFixedSize(false);
        main_recycleView.setAdapter(adapter);
    }

    private void getCatigories() {
        for (int i = 0; i < 17; i++) {
            catigory_item item = new catigory_item();
            item.setTitel("etisalat " + i);
            item.setIcon(icons[i % icons.length]);
            categories.add(item);
        }
        adapter.setCategories(categories);
    }

    @Override
    public void click_Listner(String id) {
        GoToHelper.goCategoryDetails(this);
        finish();
    }
}
