package com.example.advuts160421001.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.util.DB_NAME
import com.example.todoapp.util.MIGRATION_1_2

@Database(entities = arrayOf(User::class, Berita::class, Paragraf::class), version =  2)
abstract class HobbyDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun beritaDao(): BeritaDao
    abstract fun paragrafDao(): ParagrafDao

    companion object {
        @Volatile private var instance: HobbyDatabase ?= null
        private val LOCK = Any()

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                HobbyDatabase::class.java,
                DB_NAME)
                .addMigrations(MIGRATION_1_2)
                .build()

        operator fun invoke(context:Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }

    }
}
