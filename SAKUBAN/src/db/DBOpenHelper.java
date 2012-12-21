package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.Fragment.InstantiationException;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper {

	private static final String DB_NAME = "mydb1";
	private static final int DB_VERSION = 2;
	private static final String[] TABLES = {
		"db.OUTPUT_COUNT_DEF",
		"db.OUTPUT_FORM_DEF",
		"db.PATERN_DEF",
		"db.PERSON_DEF",
		"db.SAGYO_CODE_DEF",
		"db.SAGYO_NO_DEF",
		"db.WLOG_DEF"
	};

	public DBOpenHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			for(int i=0;i<TABLES.length;i++){
				Log.d(this.getClass().toString(), "TABLES[i] is " + TABLES[i]);
				Class table = Class.forName(TABLES[i]);
				Log.d(this.getClass().toString(), "table is " + table);
				TABLE_DEFINITION td = (TABLE_DEFINITION)table.newInstance();
				Log.d(this.getClass().toString(), "query is " + td.getCreateQuery());
				db.execSQL(td.getCreateQuery());
			}
		}catch (ClassNotFoundException e){
			//@TODO
			Log.d(this.getClass().toString(), "�e�[�u���̐V�K�쐬�ɂ����ς����܂����B");
		}catch(IllegalAccessException e){
			Log.d(this.getClass().toString(), "�f�[�^�x�[�X�̃A�N�Z�X�Ɏ��s���܂����B");
		}catch(InstantiationException e){
			Log.d(this.getClass().toString(), "???");
		} catch (java.lang.InstantiationException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//
	}
}

