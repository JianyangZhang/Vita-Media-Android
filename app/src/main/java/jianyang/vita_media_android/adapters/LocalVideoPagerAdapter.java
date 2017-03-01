package jianyang.vita_media_android.adapters;

import android.content.Context;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import jianyang.vita_media_android.R;
import jianyang.vita_media_android.beans.MediaBean;
import jianyang.vita_media_android.tools.MyTools;

import static jianyang.vita_media_android.pagers.VideoPager.mediaBeans;

public class LocalVideoPagerAdapter extends BaseAdapter{
    private Context context;
    public LocalVideoPagerAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return mediaBeans.size();
    }

    @Override
    public Object getItem(int i) {
        // return mediaBeans.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LocalVideoHolder holder;
        if (view == null) {
            view = View.inflate(context, R.layout.layout_item_localvideo, null);
            holder = new LocalVideoHolder();
            holder.icon_localvideo = (ImageView) view.findViewById(R.id.icon_localvideo);
            holder.title_localvideo = (TextView) view.findViewById(R.id.title_localvideo);
            holder.duration_localvideo = (TextView) view.findViewById(R.id.duration_localvideo);
            holder.size_localvideo = (TextView) view.findViewById(R.id.size_localvideo);
            view.setTag(holder);
        } else {
            holder = (LocalVideoHolder) view.getTag();
        }

        MediaBean mediaBean = mediaBeans.get(i);
        holder.title_localvideo.setText(mediaBean.getName());
        holder.size_localvideo.setText(Formatter.formatFileSize(context, mediaBean.getSize()));
        holder.duration_localvideo.setText(MyTools.formateMillis(mediaBean.getDuration()));
        return view;
    }

    static class LocalVideoHolder {
        ImageView icon_localvideo;
        TextView title_localvideo;
        TextView duration_localvideo;
        TextView size_localvideo;
    }
}
