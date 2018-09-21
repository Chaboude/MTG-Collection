package com.thomaschaboud.mtg_collection.Vue.Fragment;

import android.support.v4.app.Fragment;
import android.content.Context;

import com.thomaschaboud.mtg_collection.Vue.Activity.MainActivity;

/**
 * Created by Thomas on 20/09/2018.
 */

public class BaseFragment extends Fragment{

    //region variable

    MainActivity activity;

    //endregion

    //region methodes
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity)context;
    }

    public void showFragment(Fragment f) {
        this.activity.showFragment(f);
    }
    //endregion
}
