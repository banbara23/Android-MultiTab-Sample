package com.ikemura.android_multi_tab_sample.multitab.top;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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
 * 最上位のタブ
 */
public class TopTabFragment extends Fragment {
    public static final String TAG = "TopTabFragment";

    private List<PageEntry> mPageEntries = new ArrayList<>();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public TopTabFragment() {
    }

    public static TopTabFragment newInstance() {
        TopTabFragment fragment = new TopTabFragment();
        Bundle args = new Bundle();
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
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }

    private void buildPageEntries() {
        mPageEntries.clear();
        mPageEntries.add(new PageEntry() {
            @Override
            public Fragment create(int position) {
                return NewsTabFragment.newInstance("ニュース");
            }

            @Override
            public CharSequence getPageTitle() {
                return "ニュース";
            }
        });
        mPageEntries.add(new PageEntry() {
            @Override
            public Fragment create(int position) {
                return PlusOneFragment.newInstance("カレンダー");
            }

            @Override
            public CharSequence getPageTitle() {
                return "カレンダー";
            }
        });
        mPageEntries.add(new PageEntry() {
            @Override
            public Fragment create(int position) {
                return MiddleTabFragment.newInstance("ブログ");
            }

            @Override
            public CharSequence getPageTitle() {
                return "ブログ";
            }
        });
        mPageEntries.add(new PageEntry() {
            @Override
            public Fragment create(int position) {
                return PlusOneFragment.newInstance("Instagram");
            }

            @Override
            public CharSequence getPageTitle() {
                return "Instagram";
            }
        });
        mPageEntries.add(new PageEntry() {
            @Override
            public Fragment create(int position) {
                return PlusOneFragment.newInstance("Facebook");
            }

            @Override
            public CharSequence getPageTitle() {
                return "Facebook";
            }
        });
    }
}
