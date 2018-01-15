package com.ikemura.android_multi_tab_sample.multitab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ikemura.android_multi_tab_sample.R;
import com.ikemura.android_multi_tab_sample.multitab.child.MyListFragment;
import com.ikemura.android_multi_tab_sample.multitab.child.dummy.DummyContent;
import com.ikemura.android_multi_tab_sample.multitab.top.TopTabFragment;

public class MultiTabActivity extends AppCompatActivity implements MyListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_tab);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, TopTabFragment.newInstance())
                .commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.d("MultiTabActivity", item.toString());
    }
}
