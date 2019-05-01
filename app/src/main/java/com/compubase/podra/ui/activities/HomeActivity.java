package com.compubase.podra.ui.activities;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.ui.fragments.HomeFragment;
import com.compubase.podra.ui.fragments.POD.ModifyPodFragment;
import com.compubase.podra.ui.fragments.POD.ViewPodFragment;
import com.compubase.podra.ui.fragments.bottomNavigationView.EditProfileFragment;
import com.compubase.podra.ui.fragments.bottomNavigationView.HelpFragment;
import com.compubase.podra.ui.fragments.delivery.ModifyDeliveryFragment;
import com.compubase.podra.ui.fragments.delivery.ViewDeliveryFragment;
import com.compubase.podra.ui.fragments.product.ModifyProductFragment;
import com.compubase.podra.ui.fragments.product.ViewProductFragment;

public class HomeActivity extends AppCompatActivity {

    public static int checkfragment = 0;
    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    EditProfileFragment editProfileFragment = new EditProfileFragment();
                    displaySelectedFragment(editProfileFragment);
//                    mTextMessage.setText(R.string.profile);
                    return true;
                case R.id.navigation_Home:
                    HomeFragment homeFragment = new HomeFragment();
                    displaySelectedFragment(homeFragment);
//                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_help:
                    HelpFragment helpFragment = new HelpFragment();
                    displaySelectedFragment(helpFragment);
//                    mTextMessage.setText(R.string.help);
                    return true;
        }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_Home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (checkfragment == 0){
            HomeFragment homeFragment = new HomeFragment();
            displaySelectedFragment(homeFragment);
        }else if (checkfragment == 1){
            ViewPodFragment viewPodFragment = new ViewPodFragment();
            displaySelectedFragmentNew(viewPodFragment);
        }else if (checkfragment == 2){
            ModifyPodFragment modifyPodFragment = new ModifyPodFragment();
            displaySelectedFragmentNew(modifyPodFragment);
        }else if (checkfragment == 3){
            ViewDeliveryFragment viewDeliveryFragment = new ViewDeliveryFragment();
            displaySelectedFragmentNew(viewDeliveryFragment);
        }else if (checkfragment == 4){
            ModifyDeliveryFragment modifyDeliveryFragment = new ModifyDeliveryFragment();
            displaySelectedFragmentNew(modifyDeliveryFragment);
        }else if (checkfragment == 5) {
            ViewProductFragment viewProductFragment = new ViewProductFragment();
            displaySelectedFragmentNew(viewProductFragment);
        }else if (checkfragment == 6) {
            ModifyProductFragment modifyProductFragment = new ModifyProductFragment();
            displaySelectedFragmentNew(modifyProductFragment);
        }
    }

    public void displaySelectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.addToBackStack(null).commit();
    }
    public void displaySelectedFragmentNew(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

}
