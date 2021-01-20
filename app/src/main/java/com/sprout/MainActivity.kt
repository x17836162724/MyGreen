package com.sprout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sprout.databinding.ActivityMainBinding
import com.sprout.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var hov:HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        hov = ViewModelProvider(this).get(HomeViewModel::class.java)
        hov.getHomeDetail()
        initData()
    }
    fun initData(){
        hov.channel.observe(this, Observer {
            txt_name.text=it[0].name
        })
    }

}