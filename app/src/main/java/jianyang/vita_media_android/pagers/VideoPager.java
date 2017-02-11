package jianyang.vita_media_android.pagers;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

public class VideoPager extends Pager {
    private TextView textView;
    public VideoPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        textView.setText("video pager");
    }
}
