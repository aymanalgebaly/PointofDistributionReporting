package com.compubase.podra.ui.fragments.product;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.ui.activities.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyProductFragment extends Fragment {


    @BindView(R.id.Product_Modify_img)
    CircleImageView ProductModifyImg;
    @BindView(R.id.txt_Prod_modify_name)
    TextView txtProdModifyName;
    @BindView(R.id.Prod_Modify_Name)
    EditText ProdModifyName;
    @BindView(R.id.txt_prod_modify_type)
    TextView txtProdModifyType;
    @BindView(R.id.Prod_Modify_Type)
    EditText ProdModifyType;
    @BindView(R.id.txt_prod_modify_quantity)
    TextView txtProdModifyQuantity;
    @BindView(R.id.Prod_Modify_Quantity)
    EditText ProdModifyQuantity;
    @BindView(R.id.txt_prod_modify_weight)
    TextView txtProdModifyWeight;
    @BindView(R.id.Prod_Modify_Weight)
    EditText ProdModifyWeight;
    @BindView(R.id.txt_prod_modify_item_size)
    TextView txtProdModifyItemSize;
    @BindView(R.id.Prod_Modify_ItemSize)
    EditText ProdModifyItemSize;
    @BindView(R.id.prod_modify_txt_num_dist)
    TextView prodModifyTxtNumDist;
    @BindView(R.id.Prod_Modify_NumOfDistrib)
    EditText ProdModifyNumOfDistrib;
    @BindView(R.id.Prod_BTN_SAVE)
    Button ProdBTNSAVE;
    Unbinder unbinder;


    public ModifyProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modify_product, container, false);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.Product_Modify_img, R.id.Prod_BTN_SAVE})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Product_Modify_img:
                break;
            case R.id.Prod_BTN_SAVE:
                DialogModifyProduct();
                break;
        }
    }

    private void DialogModifyProduct() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog_edite_profile,null);

        builder.setView(mView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button button = mView.findViewById(R.id.BTN_edit_profile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
            }
        });
    }
}
