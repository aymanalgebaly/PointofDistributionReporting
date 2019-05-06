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
import com.compubase.podra.data.model.FristPersonnelModel;
import com.compubase.podra.data.model.ViewPersonnelModel;

import java.util.List;

public class ViewPersonnelAdapter extends RecyclerView.Adapter<ViewPersonnelAdapter.ViewHolderViewPersonnel> {

    private Context context;
    private List<ViewPersonnelModel>viewPersonnelModelList;
    private ViewPersonnelAdapter.onItemClickListner onItemClickedListner;


    public interface onItemClickListner {
        void onClick(ViewPersonnelModel viewPersonnelModel);//pass your object types.
    }

    public void onItemClickedListner(ViewPersonnelAdapter.onItemClickListner onItemClickListner) {
        this.onItemClickedListner = onItemClickListner;
    }

    public ViewPersonnelAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderViewPersonnel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_personnel_design, viewGroup, false);
        return new ViewHolderViewPersonnel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderViewPersonnel viewHolderViewPersonnel, final int i) {

        ViewPersonnelModel viewPersonnelModel = viewPersonnelModelList.get(i);

        viewHolderViewPersonnel.num.setText(viewPersonnelModel.getNum());
        viewHolderViewPersonnel.name.setText(viewPersonnelModel.getName());
        viewHolderViewPersonnel.location.setText(viewPersonnelModel.getLocation());
        viewHolderViewPersonnel.phone.setText(viewPersonnelModel.getPhone());

        viewHolderViewPersonnel.btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPersonnelModel viewPersonnelModel1 = viewPersonnelModelList.get(i);
                onItemClickedListner.onClick(viewPersonnelModel1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return viewPersonnelModelList != null ? viewPersonnelModelList.size():0;
    }

    public void setData(List<ViewPersonnelModel> viewPersonnelModels) {
        this.viewPersonnelModelList = viewPersonnelModels;
    }

    public class ViewHolderViewPersonnel extends RecyclerView.ViewHolder {

        TextView num,name,location,phone;
        Button btn_view;
        public ViewHolderViewPersonnel(@NonNull View itemView) {
            super(itemView);

            num = itemView.findViewById(R.id.txt_num_view_personnel_design);
            name = itemView.findViewById(R.id.agent_name_view_personnel_design);
            location = itemView.findViewById(R.id.agent_location_view_personnel_design);
            phone = itemView.findViewById(R.id.phone_num_view_personnel_design);

            btn_view = itemView.findViewById(R.id.BTN_View_View_Personnel);
        }
    }
}
