package com.hyun.android.databindingsample.views

import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.ysmg.adm.util.extend.replaceFragment
import com.hyun.android.databindingsample.R
import com.hyun.android.databindingsample.databinding.ActivityMainBinding
import com.hyun.android.databindingsample.factory.MainViewModelFactory
import com.hyun.android.databindingsample.model.User
import com.hyun.android.databindingsample.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)

        var binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
//        binding.tvSample.text = "이종현의 개발블로그입니다."//id: tv_sample
        subscribeUi(binding)
        setView(binding)


    }

    private fun subscribeUi(binding: ActivityMainBinding) {

        var factory = MainViewModelFactory()
        var viewModel: MainViewModel = ViewModelProviders.of(this, factory).get(
            MainViewModel::class.java
        )

        viewModel.clickConverter.observe(this, Observer {
            Toast.makeText(this, "${binding.user?.name}, ${binding.user?.address}", Toast.LENGTH_SHORT).show()
        })

        binding.user = User("이종현", "서울시", R.drawable.profile_sample)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
    }

    private fun setView(binding: ActivityMainBinding) {
        replaceFragment(this, binding.flContainer.id, CatListFragment.newInstance())


    }
}
