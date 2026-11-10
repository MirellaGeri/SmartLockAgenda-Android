package com.mirellageri.smartlockagenda.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.mirellageri.smartlockagenda.data.Task

class DatabaseManager(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATA_VERSION){
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(Task.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int
    ) {
        onDestroy(db)
        onCreate(db)
    }
    private fun onDestroy(db: SQLiteDatabase){
        db.execSQL(Task.SQL_DROP_TABLE)
    }

    companion object{
        const val DATABASE_NAME = "task_agenda.db"
        const val DATA_VERSION = 1
    }
}