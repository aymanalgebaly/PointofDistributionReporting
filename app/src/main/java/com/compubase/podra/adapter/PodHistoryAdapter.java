package com.compubase.podra.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.data.model.PodHistoryModel;

import java.util.List;

public class PodHistoryAdapter extends RecyclerView.Adapter<PodHistoryAdapter.PodHistoryViewHolder> {

    private Context context;

    public PodHistoryAdapter(Context context) {
        this.context = context;
    }

    private List<PodHistoryModel> podHistoryModelList;


//    public PodHistoryAdapter(List<PodHistoryModel> podHistoryModelList1){
//        this.podHistoryModelList = podHistoryModelList1;
//    }

    @NonNull
    @Override
    public PodHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pod_history_design, viewGroup, false);
        return new PodHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PodHistoryViewHolder podHistoryViewHolder, int i) {

//        String title = podHistoryModelList.get(i).getName();
//        String number = podHistoryModelList.get(i).getNum();
//        String startDate = podHistoryModelList.get(i).getStartDate();
//        String endDate = podHistoryModelList.get(i).getEndDate();

        PodHistoryModel podHistoryModel = podHistoryModelList.get(i);
        podHistoryViewHolder.name.setText(podHistoryModel.getName());
        podHistoryViewHolder.num.setText(podHistoryModel.getNum());
        podHistoryViewHolder.st_date.setText(podHistoryModel.getStartDate());
        podHistoryViewHolder.en_date.setText(podHistoryModel.getEndDate());
    }

    @Override
    public int getItemCount() {
        return podHistoryModelList != null ? podHistoryModelList.size():0;
    }

    public void setData(List<PodHistoryModel> newOrdersModelList) {
        this.podHistoryModelList = newOrdersModelList;
    }


    public class PodHistoryViewHolder extends RecyclerView.ViewHolder {

        TextView name,num,st_date,en_date;

        public PodHistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_history_pod);
            num = itemView.findViewById(R.id.pod_history_num);
            st_date = itemView.findViewById(R.id.st_date_pod_history);
            en_date = itemView.findViewById(R.id.en_date_pod_history);

        }
    }
}
