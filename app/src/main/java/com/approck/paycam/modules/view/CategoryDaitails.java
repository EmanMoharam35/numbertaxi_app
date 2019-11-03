package com.approck.paycam.modules.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.approck.paycam.R;
import com.approck.paycam.common.GoToHelper;

public class CategoryDaitails extends AppCompatActivity {
    public Toolbar toolbar;
    private LinearLayout back;
    private TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_daitails);
        categoryDetailsBindViews();
        setSupportActionBar(toolbar);
        toolbar_title.setText(getString(R.string.Daitail));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
    public void categoryDetailsBindViews(){
        toolbar=findViewById(R.id.my_toolbar);
        back=findViewById(R.id.en_back);
        toolbar_title=findViewById(R.id.toolbar_title);

    }




    public void apply(View view) {
        GoToHelper.gotoConfirmationPage(this);

    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            // Respond to the action bar's Up/Home button
//            case android.R.id.home:
//                onBackPressed();
//
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onBackPressed() {
        GoToHelper.goCategory(this);
        finish();
        super.onBackPressed();
    }
}
