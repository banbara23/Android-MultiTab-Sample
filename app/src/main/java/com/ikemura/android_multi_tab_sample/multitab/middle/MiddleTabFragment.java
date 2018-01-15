package com.ikemura.android_multi_tab_sample.multitab.middle;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ikemura.android_multi_tab_sample.R;
import com.ikemura.android_multi_tab_sample.multitab.child.MyListFragment;
import com.ikemura.android_multi_tab_sample.multitab.child.PlusOneFragment;
import com.ikemura.android_multi_tab_sample.multitab.viewpagers.BasicPagerAdapter;
import com.ikemura.android_multi_tab_sample.multitab.viewpagers.PageEntry;

import java.util.ArrayList;
import java.util.List;

public class MiddleTabFragment extends Fragment {
    public static final String TAG = "MiddleTabFragment";

    private List<PageEntry> mPageEntries = new ArrayList<>();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public MiddleTabFragment() {
    }

    public static MiddleTabFragment newInstance(String name) {
        MiddleTabFragment fragment = new MiddleTabFragment();
        Bundle args = new Bundle();
        args.putString(TAG, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_middle_tab, container, false);
        mTabLayout = view.findViewById(R.id.tab_middle);
        mViewPager = view.findViewById(R.id.view_pager_middle);

        //タブ設定
        buildPageEntries();
        FragmentPagerAdapter pagerAdapter = new BasicPagerAdapter(getChildFragmentManager(), mPageEntries);
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        return view;
    }

    private void buildPageEntries() {
        mPageEntries.clear();
        mPageEntries.add(new PageEntry() {
            @Override
            public Fragment create(int position) {
                return MyListFragment.newInstance(1, "子タブ1");
            }

            @Override
            public CharSequence getPageTitle() {
                return "子タブ1";
            }
        });
        mPageEntries.add(new PageEntry() {
            @Override
            public Fragment create(int position) {
                return MyListFragment.newInstance(1, "子タブ2");
            }

            @Override
            public CharSequence getPageTitle() {
                return "子タブ2";
            }
        });
        mPageEntries.add(new PageEntry() {
            @Override
            public Fragment create(int position) {
                return MyListFragment.newInstance(1, "子タブ3");
            }

            @Override
            public CharSequence getPageTitle() {
                return "子タブ3";
            }
        });
        mPageEntries.add(new PageEntry() {
            @Override
            public Fragment create(int position) {
                return MyListFragment.newInstance(1, "子タブ4");
            }

            @Override
            public CharSequence getPageTitle() {
                return "子タブ4";
            }
        });
        mPageEntries.add(new PageEntry() {
            @Override
            public Fragment create(int position) {
                return PlusOneFragment.newInstance("子タブ5");
            }

            @Override
            public CharSequence getPageTitle() {
                return "子タブ5";
            }
        });
    }

    private String getName() {
        return getArguments().getString(TAG, "");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, getName());
    }
}
