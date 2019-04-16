package com.compubase.podra.ui.fragments.product;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.ui.fragments.POD.ActiveFragment;
import com.compubase.podra.ui.fragments.POD.HistoryFragment;
import com.compubase.podra.ui.fragments.POD.NewFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {


    @BindView(R.id.tabs_Packaging_fragment)
    TabLayout tabsPackagingFragment;
    @BindView(R.id.appBar_Packaging_fragment)
    AppBarLayout appBarPackagingFragment;
    @BindView(R.id.viewPager_Product_frag)
    ViewPager viewPagerPodFrag;
    Unbinder unbinder;

    private View view;
    private TextView Pak_tabOne,Pak_tabTwo,Pak_tabThree;

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        unbinder = ButterKnife.bind(this, view);

        setupViewPager(viewPagerPodFrag);
        tabsPackagingFragment.setupWithViewPager(viewPagerPodFrag);
        setupTabIcons();

        return view;
    }
    private void setupTabIcons() {
        Pak_tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        Pak_tabOne.setText(R.string.New);
        Pak_tabOne.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_frag_product, 0, 0, 0);
        tabsPackagingFragment.getTabAt(0).setCustomView(Pak_tabOne);

        Pak_tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        Pak_tabTwo.setText(R.string.Active);
        Pak_tabTwo.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_frag_product, 0, 0, 0);
        tabsPackagingFragment.getTabAt(1).setCustomView(Pak_tabTwo);

        Pak_tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        Pak_tabThree.setText(R.string.History);
        Pak_tabThree.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_frag_product, 0, 0, 0);
        tabsPackagingFragment.getTabAt(2).setCustomView(Pak_tabThree);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new ProductNewFragment());
        adapter.addFrag(new ProductActiveFragment());
        adapter.addFrag(new ProductHistoryFragment());
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
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
