package jianyang.vita_media_android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import jianyang.vita_media_android.R;

public class ToolBar extends LinearLayout implements View.OnClickListener {
    private TextView textView;
    private ImageView imageView;
    Context context;
    public ToolBar(Context context) {
        this(context, null);
    }

    public ToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        imageView = (ImageView) getChildAt(0);
        imageView.setOnClickListener(this);
        textView = (TextView) getChildAt(1);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_logo:
                Toast.makeText(context, "OPEN SOURCE AT:\nhttps://github.com/\nJianyangZhang/Vita-Media-Android", Toast.LENGTH_LONG).show();
                break;
            case R.id.toolbar_search:
                Toast.makeText(context, "good to search", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
