package hsy.com.hsy.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "Function";
    //数据库文件名称
    private static final String DATABASE_NAME = "Functions.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_USER = "create table Function ("
            + "id integer primary key autoincrement,"
            + "icon text,"
            + "name text unique,"
            + "state bit)";


    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.delete("Function", null, null);
        onCreate(db);
    }
}
