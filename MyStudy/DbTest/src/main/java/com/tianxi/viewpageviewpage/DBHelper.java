package com.tianxi.viewpageviewpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 17/6/5.
 */

public class DBHelper extends SQLiteOpenHelper {
    //类没有实例化,是不能用作父类构造器的参数,必须声明为静态
    private static final String name = "Test"; //数据库名称

    private static final int version = 1; //数据库版本
    private SQLiteDatabase db=this.getWritableDatabase();


    public DBHelper(Context context) {
        super(context, name, null, version);

//        db=this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
         * supplierId
         * goodsId
         * goodsName
         * goodsBrand
         * price
         * picture
         * thumbnail
         * goodsNum
         * goodsUtil
         *
         */

        db.execSQL("CREATE TABLE IF NOT EXISTS Goods (_id integer primary key  AUTOINCREMENT, supplierId varchar(10)," +
                " goodsId varchar(20),goodsName varchar(20),goodsBrand varchar(20),goodsUtil varchar(20),price varchar(20)," +
                "picture varchar(50),thumbnail varchar(50),goodsNum integer)");



    }


    /**
     * 插入
     * @param values
     */
    public void insert(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert("Goods", null, values);
        db.close();
    }

    /**
     * 查询
     * @return
     */
    public Cursor query(String supplierId) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.query("Goods", null,  "supplierId = ?" , new String[]{supplierId}, null, null, null);
        return c;
    }
    /**
     * 删除
     * @param id
     */
    public void del(int id) {
        if (db == null)
            db = getWritableDatabase();
        db.delete(name, "_id=?", new String[] { String.valueOf(id) });
    }

    public void close() {
        if (db != null)
            db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }




}
