package com.sanvalero.retrofit_recycler_view_dat.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.sanvalero.retrofit_recycler_view_dat.R;
import com.sanvalero.retrofit_recycler_view_dat.adapter.AdapterRvProducts;
import com.sanvalero.retrofit_recycler_view_dat.entities.ProductResult;
import com.sanvalero.retrofit_recycler_view_dat.utils.ApiClient;
import com.sanvalero.retrofit_recycler_view_dat.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RvProductsActivity extends AppCompatActivity {
    RecyclerView rvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_products);

        initComponents();
        initData();
    }

    private void initComponents() {
        rvProducts = (RecyclerView) findViewById(R.id.rvProducts);
    }

    private void initData() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<ProductResult>> call = apiService.getProducts();
        call.enqueue(new Callback<ArrayList<ProductResult>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductResult>> call, Response<ArrayList<ProductResult>> response) {
                ArrayList<ProductResult> productResults = response.body();
                Toast.makeText(RvProductsActivity.this, "Got Products", Toast.LENGTH_SHORT).show();

                setAdapter(productResults);
            }

            @Override
            public void onFailure(Call<ArrayList<ProductResult>> call, Throwable t) {
                Toast.makeText(RvProductsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter(ArrayList<ProductResult> productResults) {
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        AdapterRvProducts adapterRvProducts = new AdapterRvProducts(this, productResults);
        rvProducts.setAdapter(adapterRvProducts);
    }
}