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
import com.compubase.podra.data.model.FristPersonnelModel;
import com.compubase.podra.data.model.PodModifyModel;
import com.compubase.podra.ui.activities.HomeActivity;

import java.util.List;

public class PodModifyAdapter extends RecyclerView.Adapter<PodModifyAdapter.ViewHolderPodModify> {

    private Context context;
    private List<PodModifyModel>podModifyModelList;
    private PodModifyAdapter.onItemClickListner onItemClickedListner;


    public interface onItemClickListner {
        void onClick(PodModifyModel podModifyModel);//pass your object types.
    }

    public void onItemClickedListner(PodModifyAdapter.onItemClickListner onItemClickListner) {
        this.onItemClickedListner = onItemClickListner;
    }

    public PodModifyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderPodModify onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pod_active_orders_design, viewGroup, false);
        return new ViewHolderPodModify(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPodModify viewHolderPodModify, final int i) {

        final PodModifyModel podModifyModel = podModifyModelList.get(i);

        viewHolderPodModify.num.setText(podModifyModel.getNum());
        viewHolderPodModify.name.setText(podModifyModel.getName());
        viewHolderPodModify.status.setText(podModifyModel.getStatus());

        viewHolderPodModify.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,HomeActivity.class));
                HomeActivity.checkfragment = 1;
//                PodModifyModel podModifyModel1 = podModifyModelList.get(i);
//                onItemClickedListner.onClick(podModifyModel1);
            }
        });
        viewHolderPodModify.modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,HomeActivity.class));
                HomeActivity.checkfragment = 2;
//                PodModifyModel podModifyModel1 = podModifyModelList.get(i);
//                onItemClickedListner.onClick(podModifyModel1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return podModifyModelList != null ? podModifyModelList.size():0;
    }

    public void setData(List<PodModifyModel> podModifyModels) {
        this.podModifyModelList = podModifyModels;
    }

    public class ViewHolderPodModify extends RecyclerView.ViewHolder {

        TextView num,name,status;
        Button view,modify,delete;
        public ViewHolderPodModify(@NonNull View itemView) {
            super(itemView);

            num = itemView.findViewById(R.id.pod_active_num);
            name = itemView.findViewById(R.id.name_active_pod);
            status = itemView.findViewById(R.id.status_active_pod);

            view = itemView.findViewById(R.id.BTN_View_pod_modify);
            modify = itemView.findViewById(R.id.BTN_Modify_pod_modify);
            delete = itemView.findViewById(R.id.BTN_Delete_pod_modify);
        }
    }
}
