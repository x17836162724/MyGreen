package com.sprout.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.shop.net.Injection.repository
import com.sprout.model.Banner
import com.sprout.model.Channel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class HomeViewModel : ViewModel() {
    //采用MutableLiveData进行修饰 并进行实例化

    // 定义轮播图数据对象
    var banner: MutableLiveData<List<Banner>> = MutableLiveData()

    // 定义一个动态栏
    var channel: MutableLiveData<List<Channel>> = MutableLiveData()

    //网络请求的状态值  -1 网络请求错误
    var loadStatue: MutableLiveData<Int> = MutableLiveData()


    //TODO 协程
    fun getHomeDetail() {
        viewModelScope.launch {

        var result = repository.getHome()
        if (result != null) {
            //postValue做线程切换 协程里面是子线程
            banner.postValue(result.data.banner)//轮播图数据
            channel.postValue(result.data.channel)//轮播图数据
            } else {
            loadStatue.postValue(-1)
            }
        }
    }

}