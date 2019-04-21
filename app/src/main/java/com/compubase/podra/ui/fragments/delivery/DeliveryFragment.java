package com.compubase.podra.ui.fragments.delivery;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.ui.fragments.POD.ActiveFragment;
import com.compubase.podra.ui.fragments.POD.HistoryFragment;
import com.compubase.podra.ui.fragments.POD.NewFragment;
import com.compubase.podra.ui.fragments.POD.PodFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryFragment extends Fragment {


    @BindView(R.id.tabs_Del_fragment)
    TabLayout tabsDelFragment;
    @BindView(R.id.appBar_Del_fragment)
    AppBarLayout appBarDelFragment;
    @BindView(R.id.viewPager_Del_frag)
    ViewPager viewPagerDelFrag;
    Unbinder unbinder;

    private TextView Del_tabOne,Del_tabTwo,Del_tabThree;

    public DeliveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery, container, false);

        unbinder = ButterKnife.bind(this, view);

        setupViewPager(viewPagerDelFrag);
        tabsDelFragment.setupWithViewPager(viewPagerDelFrag);
        setupTabIcons();

        return view;
    }
    private void setupTabIcons() {
        Del_tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        Del_tabOne.setText(R.string.New);
        Del_tabOne.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_frag_delivery, 0, 0, 0);
        tabsDelFragment.getTabAt(0).setCustomView(Del_tabOne);

        Del_tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        Del_tabTwo.setText(R.string.Active);
        Del_tabTwo.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_frag_delivery, 0, 0, 0);
        tabsDelFragment.getTabAt(1).setCustomView(Del_tabTwo);

        Del_tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        Del_tabThree.setText(R.string.History);
        Del_tabThree.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_frag_delivery, 0, 0, 0);
        tabsDelFragment.getTabAt(2).setCustomView(Del_tabThree);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new DeliveryNewFragment());
        adapter.addFrag(new ModifyDeliveryFragment());
        adapter.addFrag(new DeliveryHistoryFragment());
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);

        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
