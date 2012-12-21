package com.example.sakuban;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.support.v4.app.NavUtils;

public class SKBNGraphActivity extends Activity {

	LinearLayout linear;
	ScrollView scroll;
	GraphView graphView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        //setContentView(R.layout.activity_skbngraph);
        scroll = new ScrollView(this);
        setContentView(scroll);
        linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);

        scroll.addView(linear);
        //scroll.addView(graphView);
        for(int i=0;i<20;i++){
        	Button b = new Button(this);
        	b.setText("B"+i+1);
        	linear.addView(b);
        }
        graphView = new GraphView(this);
      //���C�A�E�g�̃p�����[�^�ݒ�
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
        		LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        //�䗦(�H)�̐ݒ�
        param.weight=1;
        graphView.setLayoutParams(param);
        linear.addView(graphView);

        */

        graphView = new GraphView(this);
        setContentView(graphView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_skbngraph, menu);
        return true;
    }

    public void moveToListActivity(View v){
    	Intent i = new Intent(SKBNGraphActivity.this,SKBNListActivity.class);
    	startActivity(i);
    }

}
