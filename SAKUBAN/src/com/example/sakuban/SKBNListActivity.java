package com.example.sakuban;

import java.util.ArrayList;
import java.util.Iterator;

import db.DbAdapter;
import db.WLOG_DEF;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class SKBNListActivity extends Activity {

	static DbAdapter dbAdapter;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skbnlist);
        dbAdapter = new DbAdapter();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_skbnlist, menu);
        return true;
    }

    public void moveToMainActivity(View v){
    	Intent i = new Intent(SKBNListActivity.this,SKBNActivity.class);
    	startActivity(i);
    }

    public void moveToGraphActivity(View v){
    	Intent i = new Intent(SKBNListActivity.this,SKBANGraph2Activity.class);
    	startActivity(i);
    }

    public void printSAKUBAN(View v){

        	Uri uri =Uri.parse("content://db/WLOG_DEF");
        	TextView txt = (TextView)findViewById(R.id.textView1);
        	txt.setText("");
        	Cursor c = dbAdapter.query(uri, null, null, null, null);

        	while(c.moveToNext()){
        		for(int i=1;i<c.getColumnCount();i++){
        			txt.append(c.getString(i)+" ");
        		}
        		txt.append(System.getProperty("line.separator"));
        	}

    }

    public void sendMail(View v){
    	GmailSend gs = new GmailSend();
    	TextView txt = (TextView)findViewById(R.id.textView1);
    	gs.setMainTxt(txt.getText().toString());
    	gs.sendMail();
    	Log.d(this.toString(), "���[�����M");
    }
}
