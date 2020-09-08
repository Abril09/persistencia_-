package com.database.database

import com.database.database.database.Task
import com.database.database.database.TaskDao

class TaskRepository(private val mTaskDao: TaskDao) {

    // Este value va a contener todos los datos de la bbdd
    val listAllTask : List<Task> = mTaskDao.getAllTaskFromDb()

    //Esta funcion va a insertar la info.
    fun insertTask(mTask: Task) {
        mTaskDao.insertOneTask(mTask)
    }





}