package com.mb.juneandroidbatch.roomtest

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


// Dao
interface TaskDao {

    @Insert
    suspend fun insert(task: Task)


    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun getAllTasks(): LiveData<List<Task>>
}

/// coroutiones
// live and architecture