package com.database.database.database

import androidx.room.*

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOneTask(mTask: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultipleTask(mListTask: List<Task>)

    @Update
    fun updateOneTask(mTask: Task)

    @Delete
    fun deleteOneTask(mTask: Task)

    @Query("SELECT * FROM table_task")
    fun getAllTaskFromDb(): List<Task>

    @Query("SELECT * FROM table_task WHERE id =:mId")
    fun getOneTaskByID(mId: Int): Task


}