package com.compubase.podra.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.data.model.DeliveryHistoryModel;
import com.compubase.podra.data.model.FristPersonnelModel;

import java.util.List;

public class DeliveryHistoryAdapter extends RecyclerView.Adapter<DeliveryHistoryAdapter.ViewHolderDeliveryHistory> {

    private Context context;
    private List<DeliveryHistoryModel>deliveryHistoryModelList;
    private DeliveryHistoryAdapter.onItemClickListner onItemClickedListner;


    public interface onItemClickListner {
        void onClick(DeliveryHistoryModel deliveryHistoryModel);//pass your object types.
    }

    public void onItemClickedListner(DeliveryHistoryAdapter.onItemClickListner onItemClickListner) {
        this.onItemClickedListner = onItemClickListner;
    }

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
    public void onBindViewHolder(@NonNull ViewHolderDeliveryHistory viewHolderDeliveryHistory, final int i) {

        DeliveryHistoryModel deliveryHistoryModel = deliveryHistoryModelList.get(i);

        viewHolderDeliveryHistory.name.setText(deliveryHistoryModel.getName());
        viewHolderDeliveryHistory.date.setText(deliveryHistoryModel.getDate());

        viewHolderDeliveryHistory.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeliveryHistoryModel deliveryHistoryModel1 = deliveryHistoryModelList.get(i);

                onItemClickedListner.onClick(deliveryHistoryModel1);
            }
        });
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
        Button view;
        public ViewHolderDeliveryHistory(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_delivery_history);
            date = itemView.findViewById(R.id.date_delivery_history);

            view = itemView.findViewById(R.id.BTN_View_Delivery_History);
        }
    }
}
