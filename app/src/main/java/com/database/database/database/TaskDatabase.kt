package com.database.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATA_BASE_NAME = "task_db"
@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDao


    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return  tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                    TaskDatabase::class.java,
                    DATA_BASE_NAME
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}