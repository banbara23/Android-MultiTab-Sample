package com.ikemura.android_multi_tab_sample.multitab.viewpagers;

import android.support.v4.app.Fragment;

public interface PageEntry {

    Fragment create(int position);

    CharSequence getPageTitle();
}
