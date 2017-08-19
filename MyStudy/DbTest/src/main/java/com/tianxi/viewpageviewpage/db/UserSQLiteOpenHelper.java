package com.tianxi.viewpageviewpage.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserSQLiteOpenHelper extends SQLiteOpenHelper {

	private static String REMOTE_LIVE_DATABASE_NAME = "mytest.db";
	private static int version = 1;
	public static final String DATABASE_TABLE_USER = "user_info";
	public static final String COL_ID = "_id";
	public static final String COL_NAME = "name";
	public static final String COL_PWD = "pwd";
	public static final String COL_TIME = "modifyTime";// modify time
	private final String REMOTE_LIVE_DATABASE_CREATE ="create table IF NOT EXISTS "+DATABASE_TABLE_USER+"("+
			COL_ID +" integer primary key autoincrement,"+
			COL_NAME +" text," +COL_PWD +" text,"+
			COL_TIME+" integer)";
	private static UserSQLiteOpenHelper mInstance = null;
	private static Context mContext;

	public static UserSQLiteOpenHelper getInstance(Context context) {
		if (null == mInstance) {
			mInstance = new UserSQLiteOpenHelper(context);
			mContext = context;
		}
		return mInstance;
	}

	private UserSQLiteOpenHelper(Context context) {
		super(context, REMOTE_LIVE_DATABASE_NAME, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(REMOTE_LIVE_DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

	
}
