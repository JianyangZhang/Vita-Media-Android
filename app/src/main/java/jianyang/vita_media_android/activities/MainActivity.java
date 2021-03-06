package jianyang.vita_media_android.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import java.util.ArrayList;

import jianyang.vita_media_android.R;
import jianyang.vita_media_android.fragments.PagerFragment;
import jianyang.vita_media_android.pagers.BasePager;
import jianyang.vita_media_android.pagers.MusicPager;
import jianyang.vita_media_android.pagers.SearchPager;
import jianyang.vita_media_android.pagers.VideoPager;
import jianyang.vita_media_android.pagers.YoutubePager;

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
        basePagers.add(new MusicPager(this));
        basePagers.add(new VideoPager(this));
        basePagers.add(new YoutubePager(this));
        basePagers.add(new SearchPager(this));

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
        ft.replace(R.id.layout_pagers, new PagerFragment());
        ft.commit();
    }
}
