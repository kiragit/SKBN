package db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class DbAdapter extends ContentProvider {

	private static DBOpenHelper helper;
	private static SQLiteDatabase db;

	@Override
	public boolean onCreate() {
		helper = new DBOpenHelper(getContext());
		db = helper.getWritableDatabase();
		Log.d(this.toString(), "db is " + db.getPath());
		return (db != null);
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		String table=uri.getLastPathSegment();
		Log.d(this.toString(),"insert db is " + db.toString());
		Log.d(this.toString(),"insert table is " + table);
		Log.d(this.toString(),"insert uri is " + uri);
		Log.d(this.toString(),"insert values are " + values.toString());
		db.insert(table, null, values);
		return uri;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
			String orderBy) {
		String table=uri.getLastPathSegment();
	    return db.query(table, null, selection, selectionArgs, null, null, orderBy);
	}

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String arg2, String[] arg3) {
		//db.update(uri.getLastPathSegment(),
				//values, whereClause, whereArgs)
		return 0;
	}

	public int getMaxId(Uri uri){
		String table = uri.getLastPathSegment();
		String sql = "select max(point) from " + table +";";
		Cursor c = db.rawQuery(sql, null);
		return c.getInt(1);
	}

}
