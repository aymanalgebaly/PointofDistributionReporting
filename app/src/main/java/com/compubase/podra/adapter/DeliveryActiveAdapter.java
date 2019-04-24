package com.compubase.podra.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.data.model.DeliveryActiveModel;

import java.util.List;

public class DeliveryActiveAdapter extends RecyclerView.Adapter<DeliveryActiveAdapter.ViewHolderDeliveryAdapter> {

    private Context context;
    private List<DeliveryActiveModel>deliveryActiveModelList;

    public DeliveryActiveAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderDeliveryAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.delivery_active_design, viewGroup, false);
        return new ViewHolderDeliveryAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDeliveryAdapter viewHolderDeliveryAdapter, int i) {
        DeliveryActiveModel deliveryActiveModel = deliveryActiveModelList.get(i);

        viewHolderDeliveryAdapter.num.setText(deliveryActiveModel.getNum());
        viewHolderDeliveryAdapter.name.setText(deliveryActiveModel.getName());
        viewHolderDeliveryAdapter.status.setText(deliveryActiveModel.getStatus());
    }

    @Override
    public int getItemCount() {
        return deliveryActiveModelList != null ? deliveryActiveModelList.size():0;
    }

    public void setData(List<DeliveryActiveModel> deliveryActiveModels) {
        this.deliveryActiveModelList = deliveryActiveModels;
    }

    public class ViewHolderDeliveryAdapter extends RecyclerView.ViewHolder {

        TextView num,name,status;
        public ViewHolderDeliveryAdapter(@NonNull View itemView) {
            super(itemView);

            num = itemView.findViewById(R.id.num_delivery_active);
            name = itemView.findViewById(R.id.product_name_delivery_active);
            status = itemView.findViewById(R.id.status_delivery_active);
        }
    }
}
