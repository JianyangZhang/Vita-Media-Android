package jianyang.vita_media_android.pagers;

import android.content.Context;
import android.view.View;

public abstract class Pager {
    public final Context context;
    public View view;
    public Pager(Context context) {
        this.context = context;
        view = initView();
        initData();
    }
    public abstract View initView();
    public abstract void initData();
}
