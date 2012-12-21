package com.example.sakuban;

import java.util.ArrayList;
import java.util.Iterator;

import db.DbAdapter;
import db.WLOG_DEF;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class SKBNActivity extends Activity {

	static DbAdapter dbAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_skbn);
		dbAdapter = new DbAdapter();
		setSpinner_SAGYO_NO();
		setSpinner_SAGYO_CODE();
		setSpinner_FORM();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_skbn, menu);
		return true;
	}

	public void registSTART(View v) {

		Uri uri = Uri.parse("content://db/WLOG_DEF");

		ContentValues values = new ContentValues();

		DatePicker d = (DatePicker) findViewById(R.id.datePicker1);
		TimePicker t = (TimePicker) findViewById(R.id.timePicker1);
		Spinner no = (Spinner) findViewById(R.id.spinnerNO);
		Spinner code = (Spinner) findViewById(R.id.spinnerCODE);
		Spinner form = (Spinner) findViewById(R.id.spinnerFORM);
		EditText count = (EditText)findViewById(R.id.Count_txt);

		values.put(WLOG_DEF.getYEAR(), d.getYear());
		values.put(WLOG_DEF.getMONTH(), d.getMonth());
		values.put(WLOG_DEF.getDAY(), d.getDayOfMonth());
		values.put(WLOG_DEF.getS_HOUR(), t.getCurrentHour());
		values.put(WLOG_DEF.getS_MIN(), t.getCurrentMinute());
		values.put(WLOG_DEF.getSAGYO_CODE(), code.getSelectedItem().toString());
		values.put(WLOG_DEF.getSAGYO_NO(), no.getSelectedItem().toString());
		values.put(WLOG_DEF.getOUTPUT_FORM(), form.getSelectedItem().toString());
		values.put(WLOG_DEF.getOUTPUT_COUNT(), count.getText().toString());

		Log.d(this.toString(), "uri is " + uri);

		dbAdapter.insert(uri, values);
	}

	public void registEND(View v) {

		Uri uri = Uri.parse("content://db/WLOG_DEF");
		int targetID = dbAdapter.getMaxId(uri);

		Log.d(this.toString(), "max id is "+targetID);

		ContentValues values = new ContentValues();

		DatePicker d = (DatePicker) findViewById(R.id.datePicker1);
		TimePicker t = (TimePicker) findViewById(R.id.timePicker1);
		Spinner form = (Spinner) findViewById(R.id.spinnerNO);
		EditText et = (EditText) findViewById(R.id.Count_txt);

		values.put(WLOG_DEF.getE_HOUR(), t.getCurrentHour());
		values.put(WLOG_DEF.getE_MIN(), t.getCurrentMinute());
		values.put(WLOG_DEF.getOUTPUT_COUNT(), et.getText().toString());
		values.put(WLOG_DEF.getOUTPUT_FORM(), form.getSelectedItem().toString());
		values.put(WLOG_DEF.getSAGYO_NO(), t.getCurrentMinute());
		values.put(WLOG_DEF.getSAGYO_CODE(), t.getCurrentMinute());

		Log.d(this.toString(), "uri is " + uri);

		dbAdapter.update(uri, values, null, null);
	}

	private void setSpinner_SAGYO_NO() {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// �A�C�e����ǉ����܂�
		Uri uri = Uri.parse("content://db/SAGYO_NO_DEF");
		Cursor c = dbAdapter.query(uri, null, null, null, null);
		Log.d(this.toString(), "uri is " + uri);
		Log.d(this.toString(), "cursor is " + c.toString());

		while (c.moveToNext()) {
			for (int i = 0; i < c.getColumnCount(); i++) {
				adapter.add(c.getString(3));
			}
		}
		Spinner spinner = (Spinner) findViewById(R.id.spinnerNO);
		// �A�_�v�^�[��ݒ肵�܂�
		spinner.setAdapter(adapter);
	}

	private void setSpinner_SAGYO_CODE() {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// �A�C�e����ǉ����܂�
		Uri uri = Uri.parse("content://db/SAGYO_CODE_DEF");
		Cursor c = dbAdapter.query(uri, null, null, null, null);
		Log.d(this.toString(), "uri is " + uri);
		Log.d(this.toString(), "cursor is " + c.toString());

		while (c.moveToNext()) {
			for (int i = 0; i < c.getColumnCount(); i++) {
				adapter.add(c.getString(3));
			}
		}
		Spinner spinner = (Spinner) findViewById(R.id.spinnerCODE);
		// �A�_�v�^�[��ݒ肵�܂�
		spinner.setAdapter(adapter);
	}

	private void setSpinner_FORM() {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// �A�C�e����ǉ����܂�
		Uri uri = Uri.parse("content://db/OUTPUT_FORM_DEF");
		Cursor c = dbAdapter.query(uri, null, null, null, null);
		Log.d(this.toString(), "uri is " + uri);
		Log.d(this.toString(), "cursor is " + c.toString() + " coun:t" + c.getColumnCount());

		while (c.moveToNext()) {
			for (int i = 0; i < c.getColumnCount(); i++) {
				adapter.add(c.getString(1));
			}
		}
		Spinner spinner = (Spinner) findViewById(R.id.spinnerFORM);
		// �A�_�v�^�[��ݒ肵�܂�
		spinner.setAdapter(adapter);
	}
	public void moveToList(View v) {
		Intent i = new Intent(SKBNActivity.this, SKBNListActivity.class);
		startActivity(i);
	}

	public void moveToSelect(View v) {
		Intent i = new Intent(SKBNActivity.this, SelectActivity.class);
		startActivity(i);
	}
}
