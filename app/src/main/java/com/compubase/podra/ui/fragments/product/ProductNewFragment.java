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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductNewFragment extends Fragment {


    @BindView(R.id.Product_img)
    CircleImageView ProductImg;
    @BindView(R.id.txt_Prod_name)
    TextView txtProdName;
    @BindView(R.id.Prod_name)
    EditText ProdName;
    @BindView(R.id.txt_prod_type)
    TextView txtProdType;
    @BindView(R.id.Prod_Type)
    EditText ProdType;
    @BindView(R.id.txt_prod_quantity)
    TextView txtProdQuantity;
    @BindView(R.id.Prod_Quantity)
    EditText ProdQuantity;
    @BindView(R.id.txt_prod_weight)
    TextView txtProdWeight;
    @BindView(R.id.Prod_Weight)
    EditText ProdWeight;
    @BindView(R.id.txt_prod_item_size)
    TextView txtProdItemSize;
    @BindView(R.id.Prod_ItemSize)
    EditText ProdItemSize;
    @BindView(R.id.prod_txt_num_dist)
    TextView prodTxtNumDist;
    @BindView(R.id.Prod_NumOfDistrib)
    EditText ProdNumOfDistrib;
    @BindView(R.id.BTN_Product_SUBMIT)
    Button BTNProductSUBMIT;
    Unbinder unbinder;

    public ProductNewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_new, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.Product_img, R.id.BTN_Product_SUBMIT})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Product_img:
                break;
            case R.id.BTN_Product_SUBMIT:
                DialogNewProduct();
                break;
        }
    }

    private void DialogNewProduct() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog_new_delivery,null);

        builder.setView(mView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button button = mView.findViewById(R.id.BTN_dialog_new_delivery);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
            }
        });
    }
}
