package com.theradikalsoftware.week5.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBMascotas extends SQLiteOpenHelper {
    private static String dbName = "DBMascotas.db";
    private static int dbVersion = 1;
    private static final String TEXT_TYPE = " TEXT ";
    private static final String INTEGER_TYPE = " INTEGER ";
    private static final String REAL_TYPE = " REAL ";
    private static final String NOT_NULL = " NOT NULL";
    private static final String COMMA = ",";

    public DBMascotas(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CreateTableRank);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private static String CreateTableRank = "CREATE TABLE " + DBMascotasModel.TableRank.TableName + "(" +
        DBMascotasModel.TableRank.COLUMN_NAME_ID + INTEGER_TYPE + NOT_NULL + " PRIMARY KEY AUTOINCREMENT" + COMMA +
        DBMascotasModel.TableRank.COLUMN_NAME_MASC_ID + INTEGER_TYPE + NOT_NULL + COMMA +
        DBMascotasModel.TableRank.COLUMN_NAME_MASC_NOMBRE + TEXT_TYPE + NOT_NULL + COMMA +
        DBMascotasModel.TableRank.COLUMN_NAME_MASC_RANK + INTEGER_TYPE + NOT_NULL + ")";
}
