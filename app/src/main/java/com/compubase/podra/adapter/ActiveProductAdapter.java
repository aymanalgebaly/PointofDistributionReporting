package com.compubase.podra.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.data.model.ActiveProductModel;
import com.compubase.podra.ui.activities.HomeActivity;

import java.util.List;

public class ActiveProductAdapter extends RecyclerView.Adapter<ActiveProductAdapter.ViewHolderActiveProduct> {

    private Context context;
    private List<ActiveProductModel>activeProductModelList;

    public ActiveProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderActiveProduct onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_active_design, viewGroup, false);

        return new ViewHolderActiveProduct(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderActiveProduct viewHolderActiveProduct, int i) {

        ActiveProductModel activeProductModel = activeProductModelList.get(i);

        viewHolderActiveProduct.num.setText(activeProductModel.getNum());
        viewHolderActiveProduct.product_name.setText(activeProductModel.getProduct_name());
        viewHolderActiveProduct.quantity.setText(activeProductModel.getQuantity());

        viewHolderActiveProduct.btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,HomeActivity.class));
                HomeActivity.checkfragment = 5;
            }
        });
        viewHolderActiveProduct.btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,HomeActivity.class));
                HomeActivity.checkfragment = 6;
            }
        });
    }

    @Override
    public int getItemCount() {
        return activeProductModelList != null ? activeProductModelList.size():0;
    }

    public void setData(List<ActiveProductModel> activeProductModels) {
        this.activeProductModelList = activeProductModels;
    }

    public class ViewHolderActiveProduct extends RecyclerView.ViewHolder {

        TextView num,product_name,quantity;
        Button btn_view,btn_modify,btn_delete;
        public ViewHolderActiveProduct(@NonNull View itemView) {
            super(itemView);

            num = itemView.findViewById(R.id.num_product_active);
            product_name = itemView.findViewById(R.id.product_name_product_active);
            quantity = itemView.findViewById(R.id.quantity_product_active);

            btn_view = itemView.findViewById(R.id.btn_view_active_product);
            btn_modify = itemView.findViewById(R.id.btn_modify_active_product);
            btn_delete = itemView.findViewById(R.id.btn_delete_active_product);
        }
    }
}
