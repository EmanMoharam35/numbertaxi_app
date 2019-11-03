package com.approck.paycam.common;

import android.content.Context;
import android.content.Intent;

import com.approck.paycam.base.base_view;
import com.approck.paycam.modules.view.CategoryDaitails;
import com.approck.paycam.modules.view.CategoryItemsView;
import com.approck.paycam.modules.view.Login;
import com.approck.paycam.modules.view.Confirmation;

public class GoToHelper {
    public static void goTo(Context context, Class act) {
        Intent go = new Intent(context, act);
        context.startActivity(go);
    }

    public static void goHome(Context context) {
        goTo(context, base_view.class);
    }

    public static void goLogin(Context context) {
        goTo(context, Login.class);
    }
    public static void goCategoryDetails(Context context) {
        goTo(context, CategoryDaitails.class);
    }


    public static void goCategory(Context context) {
        goTo(context, CategoryItemsView.class);
    }

    public static void gotoConfirmationPage(Context context) {
        goTo(context, Confirmation.class);
    }
}
