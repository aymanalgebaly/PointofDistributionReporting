package com.compubase.podra.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.data.model.DeliveryHistoryModel;

import java.util.List;

public class DeliveryHistoryAdapter extends RecyclerView.Adapter<DeliveryHistoryAdapter.ViewHolderDeliveryHistory> {

    private Context context;
    private List<DeliveryHistoryModel>deliveryHistoryModelList;

    public DeliveryHistoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderDeliveryHistory onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.delivery_history_design, viewGroup, false);
        return new ViewHolderDeliveryHistory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDeliveryHistory viewHolderDeliveryHistory, int i) {

        DeliveryHistoryModel deliveryHistoryModel = deliveryHistoryModelList.get(i);

        viewHolderDeliveryHistory.name.setText(deliveryHistoryModel.getName());
        viewHolderDeliveryHistory.date.setText(deliveryHistoryModel.getDate());
    }

    @Override
    public int getItemCount() {
        return deliveryHistoryModelList != null ? deliveryHistoryModelList.size():0;
    }

    public void setData(List<DeliveryHistoryModel> deliveryHistoryModels) {
        this.deliveryHistoryModelList = deliveryHistoryModels;
    }

    public class ViewHolderDeliveryHistory extends RecyclerView.ViewHolder {

        TextView name,date;
        public ViewHolderDeliveryHistory(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_delivery_history);
            date = itemView.findViewById(R.id.date_delivery_history);
        }
    }
}
