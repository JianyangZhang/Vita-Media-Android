package jianyang.vita_media_android.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jianyang.vita_media_android.activities.MainActivity;
import jianyang.vita_media_android.pagers.BasePager;

public class PagerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BasePager basePager = getPager();
        if (basePager == null) {
            return null;
        }
        if (!basePager.isInitiated) {
            basePager.initData();
            basePager.isInitiated = true;
        }
        return basePager.view;
    }

    private BasePager getPager() {
        int page = MainActivity.page;
        BasePager basePager = MainActivity.basePagers.get(page);
        return basePager;
    }
}
