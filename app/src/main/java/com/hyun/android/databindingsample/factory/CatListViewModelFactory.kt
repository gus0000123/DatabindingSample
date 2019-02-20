package com.hyun.android.databindingsample.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hyun.android.databindingsample.repository.CatRepository
import com.hyun.android.databindingsample.viewmodel.CatListViewModel
import com.hyun.android.databindingsample.viewmodel.MainViewModel

class CatListViewModelFactory(val catRepository: CatRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CatListViewModel(catRepository) as T
    }
}