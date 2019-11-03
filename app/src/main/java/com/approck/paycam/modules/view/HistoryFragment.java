package com.approck.paycam.modules.view;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.approck.paycam.R;
import com.approck.paycam.modules.adapters.History_adapter;
import com.approck.paycam.modules.adapters.Home_adapter;
import com.approck.paycam.modules.models.catigory_item;
import com.approck.paycam.modules.models.history_item;

import java.util.ArrayList;
import java.util.Calendar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class HistoryFragment extends Fragment implements History_adapter.CLICK{
    public static final String ARG_TITLE = "arg_title";

    RecyclerView main_recycleView;
    ProgressBar progressBar;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    ArrayList<history_item> categories;
    History_adapter adapter;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance() {//int user_id, int option_value_id, String image,String name) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
//        args.putInt(ARG_PARAM1, user_id);
//        args.putInt(ARG_PARAM2, option_value_id);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        if (getArguments() != null) {
//            user_id = getArguments().getInt(ARG_PARAM1);
//            option_value_id = getArguments().getInt(ARG_PARAM2);
//            image = getArguments().getString(ARG_PARAM3);


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

    public void bindCategory_RecyclerView(ArrayList<history_item> main_arry) {
//        Collections.reverse(main_arry);

        adapter = new History_adapter(getContext());
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
        for (int i = 0; i < 6; i++) {
            history_item item = new history_item();
//            item.setTitel("etisalat " + i);
//            item.setIcon(icons[i]);
            categories.add(item);
        }
        adapter.setCategories(categories);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.filter_menu, menu);
    }

    ////////////
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();


        if (itemId == R.id.action_filter) {

            final HistoryDateDailog historyDateDailog = new HistoryDateDailog();
            historyDateDailog.setListner(new HistoryDateDailog.HistoryDateControler() {
                @Override
                public void applyFilter(String start, String end) {
                    Toast.makeText(getContext(), "filter date with from " + start + " to " + end, Toast.LENGTH_LONG).show();
                }
            });
            historyDateDailog.show(getFragmentManager(), HistoryDateDailog.class.getName());
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void click_Listner(String id,String titel,String description, String date, String quntity) {
        showBillDailog(id,titel,description,date,quntity);
    }

    private void showBillDailog(String id,String titel,String description, String date, String quntity) {
        final BillDailog billDailog =  BillDailog.newInstance(id,titel,description,date,quntity);
//        billDailog.setListner(new HistoryDateDailog.HistoryDateControler() {
//            @Override
//            public void applyFilter(String start, String end) {
//                Toast.makeText(getContext(), "filter date with from " + start + " to " + end, Toast.LENGTH_LONG).show();
//            }
//        });
        billDailog.show(getFragmentManager(), HistoryDateDailog.class.getName());
    }
}