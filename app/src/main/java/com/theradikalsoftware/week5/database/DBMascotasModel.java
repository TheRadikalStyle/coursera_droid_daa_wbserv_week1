package com.theradikalsoftware.week5.database;

import android.provider.BaseColumns;

public class DBMascotasModel {
    private DBMascotasModel(){}

    public static class TableRank implements BaseColumns{
        public static final String TableName = "rank";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_MASC_ID = "id_mascota";
        public static final String COLUMN_NAME_MASC_NOMBRE = "nombre";
        public static final String COLUMN_NAME_MASC_RANK = "puntaje";
    }
}
