package com.example.appsepatu.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appsepatu.database.dao.DatabaseDao
import com.example.appsepatu.model.ModelDatabase



@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}