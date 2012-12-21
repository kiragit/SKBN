package com.example.sakuban;

import db.DbAdapter;
import db.OUTPUT_COUNT_DEF;
import db.OUTPUT_FORM_DEF;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class OUTPUTFormActivity extends Activity {

	static DbAdapter dbAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outputform);
        dbAdapter = new DbAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_outputform, menu);
        return true;
    }


    public void registFORM(View v){

    	Uri uri =Uri.parse("content://db/OUTPUT_FORM_DEF");

        ContentValues values = new ContentValues();
        EditText t = (EditText)findViewById(R.id.FormTxt);
    	values.put(OUTPUT_FORM_DEF.getFORM(),t.getText().toString());
		Log.d(this.toString(),"uri is " + uri);

    	dbAdapter.insert(uri, values);
    }

    public void moveToBACK(View v){
    	Intent i = new Intent(OUTPUTFormActivity.this,SelectActivity.class);
    	startActivity(i);
    }

}
