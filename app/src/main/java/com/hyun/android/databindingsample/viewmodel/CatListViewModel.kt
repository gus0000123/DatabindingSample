package com.hyun.android.databindingsample.viewmodel

import androidx.lifecycle.ViewModel
import com.hyun.android.databindingsample.repository.CatRepository

class CatListViewModel(private val catRepo: CatRepository) : ViewModel() {
    var TAG = javaClass.simpleName
    var cats = catRepo.getAllCats()


}