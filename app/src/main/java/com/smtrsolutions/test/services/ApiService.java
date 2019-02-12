package com.smtrsolutions.test.services;

import com.smtrsolutions.test.services.callbacks.ResponseProducts;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Edwin alvarado on 9/20/17.
 * Copyright © 2017 Edwin Alvarado. All rights reserved.
 */

public interface ApiService {

    String BASE_URL = "bins/";

    @Headers("Accept: application/json")
    @GET(BASE_URL+"15iu3a") // Change this key for other test "gy28m" or create a new one
    public Call<ArrayList<ResponseProducts>> getStoreProducts();


}
