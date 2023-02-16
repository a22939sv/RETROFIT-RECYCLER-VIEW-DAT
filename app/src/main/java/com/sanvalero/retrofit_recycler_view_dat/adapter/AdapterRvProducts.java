package com.sanvalero.retrofit_recycler_view_dat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sanvalero.retrofit_recycler_view_dat.R;
import com.sanvalero.retrofit_recycler_view_dat.entities.ProductResult;

import java.util.ArrayList;

public class AdapterRvProducts extends RecyclerView.Adapter<AdapterRvProducts.ViewHolderProduct> {
    Context mCntext;
    ArrayList<ProductResult> productResults;

    public AdapterRvProducts(Context mCntext, ArrayList<ProductResult> productResults) {
        this.mCntext = mCntext;
        this.productResults = productResults;
    }

    @NonNull
    @Override
    public AdapterRvProducts.ViewHolderProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_product_item, null, false);

        return new ViewHolderProduct(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRvProducts.ViewHolderProduct holder, int position) {
        holder.tvTitle.setText(productResults.get(position).getTitle());
        Glide.with(mCntext).load(productResults.get(position).getImage()).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return productResults.size();
    }

    public class ViewHolderProduct extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivImage;

        public ViewHolderProduct(@NonNull View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
        }
    }
}
