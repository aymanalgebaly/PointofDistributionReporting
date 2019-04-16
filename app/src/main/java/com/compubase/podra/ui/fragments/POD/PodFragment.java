package com.compubase.podra.ui.fragments.POD;


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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PodFragment extends Fragment {


    @BindView(R.id.tabs_pod_fragment)
    TabLayout tabsPodFragment;
    @BindView(R.id.appBar_pod_fragment)
    AppBarLayout appBarPodFragment;
    @BindView(R.id.viewPager_pod_frag)
    ViewPager viewPager;
    Unbinder unbinder;

    private View view;
    private TextView tabOne,tabTwo,tabThree;

    public PodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pod, container, false);

        unbinder = ButterKnife.bind(this, view);

        setupViewPager(viewPager);
        tabsPodFragment.setupWithViewPager(viewPager);
        setupTabIcons();

        return view;
    }

    private void setupTabIcons() {
        tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        tabOne.setText(R.string.New);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_frag, 0, 0, 0);
        tabsPodFragment.getTabAt(0).setCustomView(tabOne);

        tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        tabTwo.setText(R.string.Active);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_frag, 0, 0, 0);
        tabsPodFragment.getTabAt(1).setCustomView(tabTwo);

        tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tabs, null);
        tabThree.setText(R.string.History);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_frag, 0, 0, 0);
        tabsPodFragment.getTabAt(2).setCustomView(tabThree);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new NewFragment());
        adapter.addFrag(new ActiveFragment());
        adapter.addFrag(new HistoryFragment());
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
