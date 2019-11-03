package com.approck.paycam.modules.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.approck.paycam.R;
import com.approck.paycam.common.GoToHelper;
import com.approck.paycam.modules.adapters.Home_adapter;
import com.approck.paycam.modules.models.catigory_item;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class HomeFragment extends Fragment implements Home_adapter.CLICK{
    public static final String ARG_TITLE = "arg_title";

    RecyclerView main_recycleView;
    ProgressBar progressBar;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    ArrayList<catigory_item> categories;
    Home_adapter home_adapter;
    int[] icons = {R.drawable.icon1, R.drawable.icon2, R.drawable.fax, R.drawable.icon3, R.drawable.icon4, R.drawable.icon5,R.drawable.icon1, R.drawable.icon2};

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance()  {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
//        args.putInt(ARG_PARAM1, user_id);
//        args.putInt(ARG_PARAM2, option_value_id);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            user_id = getArguments().getInt(ARG_PARAM1);
//            option_value_id = getArguments().getInt(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_recycle_view, container, false);

        homeBindViews(rootView);
        categories = new ArrayList<>();
        bindCategory_RecyclerView(categories);
        getCatigories();

        return rootView;
    }

    private void homeBindViews(View rootView) {
        main_recycleView = (RecyclerView) rootView.findViewById(R.id.main_recycleView);
        progressBar = rootView.findViewById(R.id.progress);
    }

    public void bindCategory_RecyclerView(ArrayList<catigory_item> main_arry) {
//        Collections.reverse(main_arry);

        home_adapter = new Home_adapter(getContext());
        home_adapter.Set_Listner(this);
        staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(
                        2, //The number of Columns in the grid
                        LinearLayoutManager.VERTICAL);
//        layoutManager = new LinearLayoutManager(this,LinearLayout.HORIZONTAL,true);
        main_recycleView.setLayoutManager(staggeredGridLayoutManager);
        main_recycleView.setHasFixedSize(false);
        main_recycleView.setAdapter(home_adapter);
    }

    private void getCatigories() {
        for (int i = 0; i < 17; i++) {
        catigory_item item = new catigory_item();
        item.setTitel("etisalat " + i);
        item.setIcon(icons[i%icons.length]);
        categories.add(item);
    }
        home_adapter.setCategories(categories);
}

    @Override
    public void click_Listner(String id) {
        GoToHelper.goCategory(getContext());
//        getActivity().finish();
    }
}
