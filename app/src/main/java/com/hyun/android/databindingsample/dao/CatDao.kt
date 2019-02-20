package com.hyun.android.databindingsample.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hyun.android.databindingsample.model.Cat

@Dao
interface CatDao {
    @Query("SELECT * FROM cats")
    fun getAll(): LiveData<List<Cat>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cats: List<Cat>)
}