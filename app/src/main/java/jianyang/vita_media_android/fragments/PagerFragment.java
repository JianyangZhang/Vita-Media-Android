package jianyang.vita_media_android.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jianyang.vita_media_android.activities.MainActivity;
import jianyang.vita_media_android.pagers.Pager;

public class PagerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Pager pager = getPager();
        if (pager != null) {
            return pager.view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private Pager getPager() {
        int page = MainActivity.page;
        Pager pager = MainActivity.pagers.get(page);
        return pager;
    }
}
