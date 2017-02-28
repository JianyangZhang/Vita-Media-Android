package jianyang.vita_media_android.pagers;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import jianyang.vita_media_android.R;

public class VideoPager extends BasePager {
    private ListView listView;
    private TextView textView;
    private ProgressBar progressBar;

    public VideoPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.layout_pager_localvideo, null);
        listView = (ListView) view.findViewById(R.id.list_localvideo);
        textView = (TextView) view.findViewById(R.id.nofile);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_localvideo);
        return view;
    }

    @Override
    public void initData() {

    }
}
