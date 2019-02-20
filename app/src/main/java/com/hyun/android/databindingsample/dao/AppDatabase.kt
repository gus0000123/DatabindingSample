package com.hyun.android.databindingsample.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.hyun.android.databindingsample.model.Cat
import com.hyun.android.databindingsample.wokers.CatDBWoker


@Database(entities = [Cat::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun catDao(): CatDao


    companion object {
        val DB_NAME = "databinding-db"

        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        var request = OneTimeWorkRequest.Builder(CatDBWoker::class.java).build()
                        WorkManager.getInstance().enqueue(request)
                    }
                }).build()
        }

    }
}