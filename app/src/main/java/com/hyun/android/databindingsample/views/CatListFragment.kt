package com.hyun.android.databindingsample.views


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.hyun.android.databindingsample.R
import com.hyun.android.databindingsample.dao.AppDatabase
import com.hyun.android.databindingsample.factory.CatListViewModelFactory
import com.hyun.android.databindingsample.repository.CatRepository
import com.hyun.android.databindingsample.viewmodel.CatListViewModel

class CatListFragment : Fragment() {
    private var TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var catRepo = CatRepository.getInstance(AppDatabase.getInstance(context!!).catDao())
        var factory = CatListViewModelFactory(catRepo)
        var vm = ViewModelProviders.of(this, factory).get(CatListViewModel::class.java)

        vm.cats.observe(this, Observer {
            Log.d(TAG, "it:: ${it}")

        })
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat_list, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance() = CatListFragment()
    }
}
