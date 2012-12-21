package com.example.sakuban;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.support.v4.app.NavUtils;

public class SKBANGraph2Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skbangraph2);

        //��ʃT�C�Y�̎擾
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        //��ʃT�C�Y��4����1��View�̃T�C�Y�Ƃ��Đݒ肷��
        int width = (int)(display.getWidth());
        //int height = (int)(GraphView.getGraphHeight());
        int height = (int)(GraphView.getGraphHeight());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        findViewById(R.id.view1).setLayoutParams(params);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_skbangraph2, menu);


      //��ʃT�C�Y�̎擾
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        //��ʃT�C�Y��4����1��View�̃T�C�Y�Ƃ��Đݒ肷��
        int width = (int)(display.getWidth() / 2);
        int height = (int)(display.getHeight() / 2);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        findViewById(R.id.view1).setLayoutParams(params);

        return true;
    }

    public void back(View v){
    	Intent i = new Intent(SKBANGraph2Activity.this,SKBNListActivity.class);
    	startActivity(i);
    }

}
