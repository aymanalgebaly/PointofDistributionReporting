package com.compubase.podra.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.data.model.FristPersonnelModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FirstPersonnelAdapter extends RecyclerView.Adapter<FirstPersonnelAdapter.ViewHolderFristPersonnel> {

    private Context context;
    private List<FristPersonnelModel>fristPersonnelModelList;
    private onItemClickListner onItemClickedListner;


    public interface onItemClickListner {
        void onClick(FristPersonnelModel fristPersonnelModel);//pass your object types.
    }

    public void onItemClickedListner(FirstPersonnelAdapter.onItemClickListner onItemClickListner) {
        this.onItemClickedListner = onItemClickListner;
    }

    public FirstPersonnelAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderFristPersonnel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.agents_list_design, viewGroup, false);
        return new ViewHolderFristPersonnel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFristPersonnel viewHolderFristPersonnel, final int i) {

        final FristPersonnelModel fristPersonnelModel = fristPersonnelModelList.get(i);

        viewHolderFristPersonnel.disc.setText(fristPersonnelModel.getDiscribtion());

        Picasso.get().load(fristPersonnelModel.getImg()).into(viewHolderFristPersonnel.circleImageView);

        viewHolderFristPersonnel.View_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FristPersonnelModel fristPersonnelModel1 = fristPersonnelModelList.get(i);

                onItemClickedListner.onClick(fristPersonnelModel1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fristPersonnelModelList != null ? fristPersonnelModelList.size():0;
    }

    public void setData(List<FristPersonnelModel> fristPersonnelModels) {
        this.fristPersonnelModelList = fristPersonnelModels;
    }

    public class ViewHolderFristPersonnel extends RecyclerView.ViewHolder {

        TextView disc;
        CircleImageView circleImageView;
        Button View_BTN;
        public ViewHolderFristPersonnel(@NonNull View itemView) {
            super(itemView);

            disc = itemView.findViewById(R.id.frist_personnel_disc);
            circleImageView = itemView.findViewById(R.id.IMG_First_Personnel);

            View_BTN = itemView.findViewById(R.id.BTN_View_First_Personnel);
        }
    }
}
