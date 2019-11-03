package com.approck.paycam.modules.view;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.approck.paycam.R;
import com.approck.paycam.base.util.DateUtil;

import java.util.Calendar;

import androidx.fragment.app.DialogFragment;

public class HistoryDateDailog extends DialogFragment {

    /**
     * Android Views
     **/
    private TextView title;
    private LinearLayout btnNo;
    private LinearLayout btnOk;
    private EditText start_date;
    private EditText end_date;

    private Calendar mcalendar;
    private int day, month, year;
    /**
     * Android Views
     **/
//    private View.OnClickListener positiveClickListener, negativeClickListener;
    private HistoryDateControler controler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_date_dailog, container);
        bindViews(view);
        setCancelable(false);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (negativeClickListener != null) {
//                    negativeClickListener.onClick(v);
//                }

                dismiss();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (positiveClickListener != null) {
//                    positiveClickListener.onClick(v);
//                }
                if(end_date.getText().toString().equals("")||start_date.getText().toString().equals("")){
                    Toast.makeText(getContext(),getContext().getString(R.string.selectCorrectDatePreiod),Toast.LENGTH_LONG).show();
                }else{
                    if(controler!=null){
                        controler.applyFilter(start_date.getText().toString(),end_date.getText().toString());
                    }
                    dismiss();
                }
            }
        });
        start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDialog(start_date);
            }
        });
        end_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDialog(end_date);
            }
        });
        return view;
    }

    private void bindViews(View rootView) {
        title = rootView.findViewById(R.id.title);
        btnNo = rootView.findViewById(R.id.btnNo);
        btnOk = rootView.findViewById(R.id.btnOk);
        start_date=rootView.findViewById(R.id.start_date);
        end_date=rootView.findViewById(R.id.end_date);

    }

    @Override
    public void onResume() {
        super.onResume();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

//    public void setPositiveClickListener(View.OnClickListener positiveClickListener) {
//        this.positiveClickListener = positiveClickListener;
//    }
//
//    public void setNegativeClickListener(View.OnClickListener negativeClickListener) {
//        this.negativeClickListener = negativeClickListener;
//    }

    public void DateDialog(EditText edit_text) {
        mcalendar = Calendar.getInstance();
        year = mcalendar.get(Calendar.YEAR);
        month = mcalendar.get(Calendar.MONTH);
        day = mcalendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener listener = (view, year, monthOfYear, dayOfMonth) -> edit_text.setText(DateUtil.getDateOnly(year, monthOfYear, dayOfMonth));
        DatePickerDialog dpDialog = new DatePickerDialog(getContext(), listener, year, month, day);
        dpDialog.show();
    }
    public interface HistoryDateControler{
        void applyFilter(String start, String end);
    }
    public void setListner(HistoryDateControler historyDateControler){
        this.controler=historyDateControler;
    }
}

