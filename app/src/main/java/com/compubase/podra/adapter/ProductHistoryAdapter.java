package com.compubase.podra.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.data.model.ProductHistoryModel;

import java.util.List;

public class ProductHistoryAdapter extends RecyclerView.Adapter<ProductHistoryAdapter.ViewHolderProductHistory> {

    private Context context;
    private List<ProductHistoryModel> productHistoryModelList;

    public ProductHistoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderProductHistory onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_history_design, viewGroup, false);
        return new ViewHolderProductHistory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductHistory viewHolderProductHistory, int i) {

        ProductHistoryModel productHistoryModel = productHistoryModelList.get(i);
        viewHolderProductHistory.num.setText(productHistoryModel.getNum());
        viewHolderProductHistory.name.setText(productHistoryModel.getName());
        viewHolderProductHistory.start.setText(productHistoryModel.getStart());
        viewHolderProductHistory.end.setText(productHistoryModel.getEnd());

    }

    @Override
    public int getItemCount() {
        return productHistoryModelList != null ? productHistoryModelList.size():0;
    }

    public void setData(List<ProductHistoryModel> productHistoryModels) {
        this.productHistoryModelList = productHistoryModels;
    }

    public class ViewHolderProductHistory extends RecyclerView.ViewHolder {

        TextView num,name,start,end;
        public ViewHolderProductHistory(@NonNull View itemView) {
            super(itemView);

            num = itemView.findViewById(R.id.num_product_history);
            name = itemView.findViewById(R.id.name_product_history);
            start = itemView.findViewById(R.id.startDate_product_history);
            end = itemView.findViewById(R.id.endDate_product_history);

        }
    }
}
