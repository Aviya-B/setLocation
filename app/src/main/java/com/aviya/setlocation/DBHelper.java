package com.aviya.setlocation;

//public class DBHelper extends  {
//}


        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Hashtable;
        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.DatabaseUtils;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SetLocationDB.db";
    public static final String SETTINGS_TABLE_NAME = "settings";
    public static final String SETTINGS_COLUMN_ID = "id";
    public static final String SETTINGS_COLUMN_LOCATION_NAME = "locationName";
    public static final String SETTINGS_COLUMN_RADIUS = "radius";
    public static final String SETTINGS_COLUMN_IS_SILENT = "isSilent";
    public static final String SETTINGS_COLUMN_SMS = "numForSMS";

    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table settings " +
                        "(id integer primary key, locationName text,radius integer,isSilent boolean, numForSMS integer)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS settings");
        onCreate(db);
    }

    public boolean insertContact (String locationName, Integer radius,Boolean isSilent, Integer numForSMS) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("locationName", locationName);
        contentValues.put("radius", radius);
        contentValues.put("isSilent", isSilent);
        contentValues.put("numForSMS", numForSMS);

        db.insert("settings", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from settings where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, SETTINGS_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id,String locationName, Integer radius,Boolean isSilent, Integer numForSMS)  {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("locationName", locationName);
        contentValues.put("radius", radius);
        contentValues.put("isSilent", isSilent);
        contentValues.put("numForSMS", numForSMS);
        db.update("settings", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("settings",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllSettings() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from settings", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(SETTINGS_COLUMN_LOCATION_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}