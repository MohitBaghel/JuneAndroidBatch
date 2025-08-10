package com.mb.juneandroidbatch.roomtest

import androidx.room.Entity
import androidx.room.PrimaryKey


//Entity class

@Entity(tableName = "Tasks")
data class Task(
    @PrimaryKey val id : Int  = 0,
    val title : String,
    val description : String
)
