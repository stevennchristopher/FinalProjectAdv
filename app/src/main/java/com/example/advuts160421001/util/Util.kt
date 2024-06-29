package com.example.todoapp.util

import android.content.Context
import androidx.room.Room
import com.example.advuts160421001.model.HobbyDatabase

val DB_NAME = "hobbyappdb"

//val MIGRATION_1_2 = object : Migration(1, 2) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL(
//            "ALTER TABLE user ADD COLUMN priority INTEGER DEFAULT 3 not null")
//    }
//}

//val MIGRATION_2_3 = object : Migration(2, 3) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL(
//            "ALTER TABLE todo ADD COLUMN is_done INTEGER DEFAULT 0 not null")
//    }
//}

fun buildDb(context: Context): HobbyDatabase {
    val db = Room.databaseBuilder(context,
        HobbyDatabase::class.java, DB_NAME)
//        .addMigrations(MIGRATION_1_2)
        .build()

    return db
}
