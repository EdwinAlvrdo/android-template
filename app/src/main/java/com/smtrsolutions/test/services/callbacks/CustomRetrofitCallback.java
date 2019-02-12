package com.smtrsolutions.test.services.callbacks;

import android.app.Activity;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by edwinalvarado on 2/12/19.
 * Copyright © 2019 edwinalvarado. All rights reserved.
 */

public abstract class CustomRetrofitCallback<T> implements Callback<T> {

    private static final String TAG = "CustomRetrofitCallback" ;
    private static Boolean manageError = true;

    public CustomRetrofitCallback(Activity activity) {
        Log.d(TAG, "CustomRetrofitCallback: test");

    }

    public CustomRetrofitCallback(Activity activity, boolean showLoader) {
        Log.d(TAG, "CustomRetrofitCallback: test");
    }

    public CustomRetrofitCallback(Activity activity, boolean showLoader, boolean manageError) {
        Log.d(TAG, "CustomRetrofitCallback: test");
        this.manageError = manageError;
    }

    public CustomRetrofitCallback(boolean showLoader, boolean manageError) {
        Log.d(TAG, "CustomRetrofitCallback: test");
        this.manageError = manageError;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()){
            handleSuccess(response);
        }else{
            handleError();
        }
        Log.i(TAG,"Response message"+response.message());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        //Show failure message
        Log.i("CustomRetrofitCallback:", "Failure");
    }

    public abstract void handleSuccess(Response response);
    public abstract void handleError();

}