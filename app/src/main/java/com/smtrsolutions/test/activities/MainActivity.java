package com.smtrsolutions.test.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.smtrsolutions.test.R;
import com.smtrsolutions.test.services.ApiService;
import com.smtrsolutions.test.services.ServiceGenerator;
import com.smtrsolutions.test.services.callbacks.CustomRetrofitCallback;
import com.smtrsolutions.test.services.callbacks.ResponseProducts;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by Edwin alvarado on 9/20/17.
 * Copyright © 2017 Edwin Alvarado. All rights reserved.
 */

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.txt_result)
    TextView txtResults;

    @Bind(R.id.btn_process_store)
    Button btnProcessStore;

    List<ResponseProducts> responseProducts = new ArrayList<ResponseProducts>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fetchStoreData();
    }

    public void fetchStoreData(){

        ServiceGenerator.getService(ApiService.class)
                        .getStoreProducts()
                        .enqueue(new CustomRetrofitCallback<ArrayList<ResponseProducts>>(this) {
                            @Override
                            public void handleSuccess(Response response) {
                                //Get resulst and set values
                                responseProducts = (ArrayList<ResponseProducts>) response.body();

                            }

                            @Override
                            public void handleError() {
                                //Show error message
                            }
                        });

    }

    @OnClick(R.id.btn_process_store)
    public void processStore(){

        String text = "";

        for(int i = 0; i < this.responseProducts.size(); i++)
            text += this.getProcessedText(this.responseProducts.get(i));

        txtResults.setText(text);
    }

    public String getProcessedText(ResponseProducts p){

        return "A total of ".concat(p.getBasketSum())
                            .concat(" ").concat(p.getName())
                            .concat("were sold, in ").concat(p.getBasketStringCount())
                            .concat(" baskets. \n\n");

    }

}
