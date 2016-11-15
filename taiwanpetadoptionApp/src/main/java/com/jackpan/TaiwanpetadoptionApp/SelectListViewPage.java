package com.jackpan.TaiwanpetadoptionApp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.adbert.AdbertListener;
import com.adbert.AdbertLoopADView;
import com.adbert.AdbertOrientation;
import com.adbert.ExpandVideoPosition;
import com.google.android.gms.ads.AdSize;


public class SelectListViewPage extends Activity {
    private ListView mListView;
    private String[] name = {"認養動物資訊","動物醫院資訊","贊助開發者"};
    private ArrayAdapter<String> listAdapter;
    AdbertLoopADView adbertView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //設定隱藏APP標題
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_two_2);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_select_list_view_page);
        showAdbert();
        context = SelectListViewPage.this;
        mListView = (ListView) findViewById(R.id.select_listview);
        listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,name);
        mListView.setAdapter(listAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 switch (position){
                     case 0:
                         Intent a = new Intent();
                         a.setClass(context,MainActivity.class);
                         startActivity(a);
                         break;
                     case  1:
                         Intent b = new Intent();
                         b.setClass(context, com.hos.MainActivity.class);
                         startActivity(b);
                         break;
                     case 2:
                         Intent iap = new Intent();
                         iap.setClass(context,InAppBillingActivity.class);
                         startActivity(iap);
                         break;

                 }
            }
        });


    }
    private void showAdbert() {
        adbertView = (AdbertLoopADView)findViewById(R.id.adbertADView);
        adbertView.setMode(AdbertOrientation.NORMAL);
        adbertView.setExpandVideo(ExpandVideoPosition.BOTTOM);
        adbertView.setFullScreen(false);
        adbertView.setBannerSize(AdSize.BANNER);
        adbertView.setAPPID("20161111000002", "5a73897de2c53f95333b6ddaf23639c7");
        adbertView.setListener(new AdbertListener() {
            @Override
            public void onReceive(String msg) {

            }

            @Override
            public void onFailedReceive(String msg) {


            }
        });
        adbertView.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        adbertView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adbertView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adbertView.destroy();
    }
}
