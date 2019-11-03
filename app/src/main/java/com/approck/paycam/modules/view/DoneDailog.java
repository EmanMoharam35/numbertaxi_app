package com.approck.paycam.modules.view;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.approck.paycam.R;

import androidx.fragment.app.DialogFragment;

public class DoneDailog extends DialogFragment {

    /**
     * Android Views
     **/
    private Button btnOk;

    /**
     * Android Views
     **/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.done_dailog, container);
        bindViews(view);
        setCancelable(false);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    dismiss();

            }
        });

        return view;
    }

    private void bindViews(View rootView) {

        btnOk = rootView.findViewById(R.id.btnOk);


    }

    @Override
    public void onResume() {
        super.onResume();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }


}

