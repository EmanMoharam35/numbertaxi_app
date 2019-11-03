package com.approck.paycam.modules.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.approck.paycam.R;

public class Confirmation extends AppCompatActivity {
    public Toolbar toolbar;
    private LinearLayout back;
    private TextView toolbar_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        confirmationBindViews();
        setSupportActionBar(toolbar);
        toolbar_title.setText(getString(R.string.Confirmation));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void confirmationBindViews(){
        toolbar=findViewById(R.id.my_toolbar);
        back=findViewById(R.id.en_back);
        toolbar_title=findViewById(R.id.toolbar_title);

    }
    public void print(View view) {
        confirmPrint("12", "Etislate");

    }
    private void confirmPrint(String quntity, String titel) {
        new AlertDialog.Builder(this)
                .setMessage(getString(R.string.confirmPrint, quntity, titel))
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        showDoneDailog();
//                        finish();
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
//                        dismiss(this);

                    }
                }).show();


    }
    private void showDoneDailog() {
        final DoneDailog dailog = new DoneDailog();
        dailog.show(getSupportFragmentManager(), DoneDailog.class.getName());
    }

}
