package jianyang.vita_media_android.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import jianyang.vita_media_android.R;
import jianyang.vita_media_android.fragments.PagerFragment;
import jianyang.vita_media_android.pagers.BasePager;
import jianyang.vita_media_android.pagers.MusicBasePager;
import jianyang.vita_media_android.pagers.SearchBasePager;
import jianyang.vita_media_android.pagers.VideoBasePager;
import jianyang.vita_media_android.pagers.YoutubeBasePager;

public class MainActivity extends FragmentActivity {
    public static int page;
    public static ArrayList<BasePager> basePagers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // FrameLayout pagers_layout = (FrameLayout) findViewById(R.id.pagers_layout);
        RadioGroup button_group = (RadioGroup) findViewById(R.id.button_group);
        basePagers = new ArrayList<>();
        basePagers.add(new MusicBasePager(this));
        basePagers.add(new VideoBasePager(this));
        basePagers.add(new YoutubeBasePager(this));
        basePagers.add(new SearchBasePager(this));

        button_group.setOnCheckedChangeListener(new ButtonGroupListener());
        button_group.check(R.id.button_localMusic);

    }
    class ButtonGroupListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.button_localMusic:
                    page = 0;
                    break;
                case R.id.button_localVideo:
                    page = 1;
                    break;
                case R.id.button_youtube:
                    page = 2;
                    break;
                case R.id.button_search:
                    page = 3;
                    break;
                default:
                    page = 0;
                    break;
            }
            setFragment();
        }
    }

    private void setFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.pagers_layout, new PagerFragment());
        ft.commit();
    }
}
