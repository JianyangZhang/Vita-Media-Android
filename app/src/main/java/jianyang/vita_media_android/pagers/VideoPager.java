package jianyang.vita_media_android.pagers;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jianyang.vita_media_android.R;
import jianyang.vita_media_android.beans.MediaBean;

public class VideoPager extends BasePager {
    private ListView listView;
    private TextView textView;
    private ProgressBar progressBar;
    public static Context context;
    public static List<MediaBean> mediaBeans;

    private static final int LOCAL_VIDEO_SEARCH_COMPLETE = 102;
    public VideoPager(Context context) {
        super(context);
        this.context = context;
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
        mediaBeans = new ArrayList<>();
        findLocalVideos();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mediaBeans!= null && mediaBeans.size() > 0) {
                listView.setAdapter();
            }
        }
    };

    private void findLocalVideos() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                ContentResolver cr = context.getContentResolver();
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                String[] objs = {
                        MediaStore.Video.Media.DISPLAY_NAME,
                        MediaStore.Video.Media.DURATION,
                        MediaStore.Video.Media.SIZE,
                        MediaStore.Video.Media.DATA, // video's absolute path to SDcard
                        MediaStore.Video.Media.ARTIST
                };
                Cursor cursor = cr.query(uri, objs, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        MediaBean mediaBean = new MediaBean();
                        String name = cursor.getString(0);
                        long duration = cursor.getLong(1);
                        long size = cursor.getLong(2);
                        String data = cursor.getString(3);
                        String artist = cursor.getString(4);
                        mediaBean.setName(name);
                        mediaBean.setDuration(duration);
                        mediaBean.setSize(size);
                        mediaBean.setData(data);
                        mediaBean.setArtist(artist);
                        mediaBeans.add(mediaBean);
                    }
                }
                cursor.close();
                handler.sendEmptyMessage(LOCAL_VIDEO_SEARCH_COMPLETE);
            }

        }.start();
    }
}
