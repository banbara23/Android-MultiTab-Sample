package com.ikemura.android_multi_tab_sample.multitab.top;

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
import com.ikemura.android_multi_tab_sample.multitab.middle.MiddleTabFragment;
import com.ikemura.android_multi_tab_sample.multitab.child.PlusOneFragment;
import com.ikemura.android_multi_tab_sample.multitab.viewpagers.BasicPagerAdapter;
import com.ikemura.android_multi_tab_sample.multitab.viewpagers.PageEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * ２タブを持つフラグメント
 */
public class NewsTabFragment extends Fragment {
    public static final String TAG = "NewsTabFragment";

    private List<PageEntry> mPageEntries = new ArrayList<>();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public NewsTabFragment() {
    }

    public static NewsTabFragment newInstance(String name) {
        NewsTabFragment fragment = new NewsTabFragment();
        Bundle args = new Bundle();
        args.putString(TAG, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_tab, container, false);
        mTabLayout = view.findViewById(R.id.tab);
        mViewPager = view.findViewById(R.id.view_pager);

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
                return MiddleTabFragment.newInstance("ウィークリーニュース");
            }

            @Override
            public CharSequence getPageTitle() {
                return "ウィークリーニュース";
            }
        });
        mPageEntries.add(new PageEntry() {
            @Override
            public Fragment create(int position) {
                return PlusOneFragment.newInstance("専門ショップニュース");
            }

            @Override
            public CharSequence getPageTitle() {
                return "専門ショップニュース";
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
