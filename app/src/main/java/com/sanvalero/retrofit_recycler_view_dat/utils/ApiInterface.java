package com.sanvalero.retrofit_recycler_view_dat.utils;

import com.sanvalero.retrofit_recycler_view_dat.entities.ProductResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("products")
    Call<ArrayList<ProductResult>> getProducts();

}
