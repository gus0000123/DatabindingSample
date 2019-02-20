package com.hyun.android.databindingsample.repository

import com.hyun.android.databindingsample.dao.CatDao

class CatRepository private constructor(private val catDao: CatDao) {
    fun getAllCats() = catDao.getAll()

    companion object {
        @Volatile
        private var instance: CatRepository? = null

        fun getInstance(catDao: CatDao) =
            instance ?: synchronized(this) {
                instance ?: CatRepository(catDao).also { instance = it }
            }

    }
}