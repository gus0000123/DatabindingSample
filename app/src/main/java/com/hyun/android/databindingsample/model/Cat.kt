package com.hyun.android.databindingsample.model

import androidx.databinding.BaseObservable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cats")
data class Cat(

    @PrimaryKey @ColumnInfo(name = "id") var catId: Int = 0
    , @ColumnInfo(name = "name") var name: String = ""
    , @ColumnInfo(name = "image_url") var imageURL: String = ""
)