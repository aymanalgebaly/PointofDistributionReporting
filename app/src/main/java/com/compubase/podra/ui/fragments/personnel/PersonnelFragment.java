package com.compubase.podra.ui.fragments.personnel;


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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonnelFragment extends Fragment {


    @BindView(R.id.tabs_Pers_fragment)
    TabLayout tabsPersFragment;
    @BindView(R.id.appBar_pod_fragment)
    AppBarLayout appBarPodFragment;
    @BindView(R.id.viewPager_Pers_frag)
    ViewPager viewPagerPersFrag;
    Unbinder unbinder;

    private TextView Pers_tabOne,Pers_tabTwo,Pers_tabThree;

    public PersonnelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personnel, container, false);

        unbinder = ButterKnife.bind(this, view);

        setupViewPager(viewPagerPersFrag);
        tabsPersFragment.setupWithViewPager(viewPagerPersFrag);

        setupTabIcons();
        return view;
    }

    private void setupTabIcons() {
        Pers_tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        Pers_tabOne.setText(R.string.Personnel);
        Pers_tabOne.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pers_frag, 0, 0, 0);
        tabsPersFragment.getTabAt(0).setCustomView(Pers_tabOne);

        Pers_tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        Pers_tabTwo.setText(R.string.Active);
        Pers_tabTwo.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pers_frag, 0, 0, 0);
        tabsPersFragment.getTabAt(1).setCustomView(Pers_tabTwo);

        Pers_tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        Pers_tabThree.setText(R.string.History);
        Pers_tabThree.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pers_frag, 0, 0, 0);
        tabsPersFragment.getTabAt(2).setCustomView(Pers_tabThree);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new PersonnelFristFragment());
        adapter.addFrag(new ActivePersonnelFragment());
        adapter.addFrag(new HistoryPersonnelFragment());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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

}
