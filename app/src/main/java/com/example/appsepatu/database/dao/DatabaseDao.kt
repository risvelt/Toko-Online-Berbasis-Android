package com.example.appsepatu.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appsepatu.model.ModelDatabase



@Dao
interface DatabaseDao {

    @Query("SELECT * FROM tbl_appsepatu")
    fun getAll(): LiveData<List<ModelDatabase>>

    @Query("SELECT SUM(harga) FROM tbl_appsepatu")
    fun getSaldo(): LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(modelDatabases: ModelDatabase)

    @Query("DELETE FROM tbl_appsepatu WHERE uid= :uid")
    fun deleteSingleData(uid: Int)

}