package com.approck.paycam.modules.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.approck.paycam.R;

import androidx.fragment.app.DialogFragment;

public class BillDailog extends DialogFragment {

    private static final String ARG_PARAM1 = "arg1";
    private static final String ARG_PARAM2 = "arg2";
    private static final String ARG_PARAM3 = "arg3";
    private static final String ARG_PARAM4 = "arg4";
    private static final String ARG_PARAM5 = "arg5";
    /**
     * Android Views
     **/
    private LinearLayout reprint_lin;
    private TextView titel, description, quntity,date;
    private ImageView close;
    private String id,titel_text,desc_text,date_text,quntity_text;
    /**
     * Android Views
     **/
    public static BillDailog newInstance(String id, String titel, String description, String date, String quntity) {
        BillDailog dailog = new BillDailog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, id);
        args.putString(ARG_PARAM2, titel);
        args.putString(ARG_PARAM3, description);
        args.putString(ARG_PARAM4, date);
        args.putString(ARG_PARAM5, quntity);


        dailog.setArguments(args);
        return dailog;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            id = getArguments().getString(ARG_PARAM1);
            titel_text = getArguments().getString(ARG_PARAM2);
            desc_text = getArguments().getString(ARG_PARAM3);
            date_text = getArguments().getString(ARG_PARAM4);
            quntity_text = getArguments().getString(ARG_PARAM5);


        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bill_history_item, container);
        bindViews(view);
        setCancelable(false);
//        titel.setText(titel_text);
//        description.setText(desc_text);
//        quntity.setText(quntity_text+" "+getString(R.string.pice));
//        date.setText(date_text);

        reprint_lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmPrint(quntity_text,titel_text);

            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }

    private void bindViews(View rootView) {

        reprint_lin = rootView.findViewById(R.id.reprint_lin);
        titel = rootView.findViewById(R.id.titel);
        description = rootView.findViewById(R.id.description);
        quntity = rootView.findViewById(R.id.quntity);
        date = rootView.findViewById(R.id.date);
        close=rootView.findViewById(R.id.close);



    }

    @Override
    public void onResume() {
        super.onResume();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }


    private void confirmPrint(String quntity, String titel) {
        new AlertDialog.Builder(getContext())
                .setMessage(getString(R.string.confirmPrint, quntity, titel))
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setCancelable(false)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
//                        showDoneDailog();
                                        dismiss();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
//                        dismiss(this);

                    }
                }).show();


    }

}

