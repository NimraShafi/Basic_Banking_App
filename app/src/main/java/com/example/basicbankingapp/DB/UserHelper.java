package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(8493,'Aiman Waqar', 'aiman@gmail.com','5835','03429569517', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7302,'Rayan Anwar', 'rayan@gmail.com','9625','03005641563',7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(9693,'Sohail Ahmed', 'sohail@gmail.com','6418','03127593514', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1846,'Amna Ahad', 'amna@gmail.com','8361','03330199569', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8472,'Areej Rasheed', 'areeej@gmail.com','7730','03215648518', 800)");
        db.execSQL("insert into " + TABLE_NAME + " values(1628,'Abdullah Sheikh', 'abdullah@gmail.com','3386','03225640793', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7492,'Muhammad Rana', 'rana@gmail.com','9251','03429564952', 8300)");
        db.execSQL("insert into " + TABLE_NAME + " values(9371,'Areeba Aslam', 'areeba@gmail.com','4473','03332153907', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(5267,'Emaan Khan', 'emaan@gmail.com','2519','03445652389', 3800)");
        db.execSQL("insert into " + TABLE_NAME + " values(8364,'Laiba Fatima', 'laiba@gmail.com','7255','03008292199', 1750)");
        db.execSQL("insert into " + TABLE_NAME + " values(5261,'Shameen Afridi', 'shameen@gmail.com','1764','03129641255', 6600)");
        db.execSQL("insert into " + TABLE_NAME + " values(6643,'Ayesha Naz', 'ayesha@gmail.com','2517','03420009995', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3862,'Bilal Abbas', 'bilal@gmail.com','7286','03329541750', 8100)");
        db.execSQL("insert into " + TABLE_NAME + " values(9388,'Junaid Ahmed', 'junaid@gmail.com','9937','03006642251', 31500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8355,'Shamim Khalid', 'shamim@gmail.com','9350','03449365819', 15900)");
        db.execSQL("insert into " + TABLE_NAME + " values(9361,'Abida Farooqi', 'abida@gmail.com','1384','03007720160', 14500)");
        db.execSQL("insert into " + TABLE_NAME + " values(5620,'Yasir Qureshi', 'yasir@gmail.com','3051','03340015368', 6400)");
        db.execSQL("insert into " + TABLE_NAME + " values(7457,'Saad Waleed', 'saad@gmail.com','6603','03128240006', 4100)");
        db.execSQL("insert into " + TABLE_NAME + " values(6239,'Waseem Ahmed', 'waseem@gmail.com','8346','03428459990', 9800)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}