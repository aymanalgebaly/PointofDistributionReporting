package com.compubase.podra;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.compubase.podra.ui.fragments.HomeFragment;
import com.compubase.podra.ui.fragments.bottomNavigationView.EditProfileFragment;
import com.compubase.podra.ui.fragments.bottomNavigationView.HelpFragment;

public class HomeActivity extends AppCompatActivity {

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
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        HomeFragment homeFragment = new HomeFragment();
        displaySelectedFragment(homeFragment);
    }

    public void displaySelectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.addToBackStack(null).commit();
    }
}
