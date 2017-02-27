package jianyang.vita_media_android.pagers;

import android.content.Context;
import android.view.View;

public abstract class BasePager {
    public final Context context;
    public View view;
    public boolean isInitiated;

    public BasePager(Context context) {
        this.context = context;
        isInitiated = false;
        view = initView();
    }
    public abstract View initView();
    public abstract void initData();
}
