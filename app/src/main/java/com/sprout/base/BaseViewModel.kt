package com.shop.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import butterknife.internal.Constants
import com.example.myshop.net.repository.SystemRepository
import com.example.myshop.utils.MyMmkv
import com.sprout.app.Constants.Companion.token
import kotlinx.coroutines.launch

open class BaseViewModel(val repository: SystemRepository):ViewModel() {

    //TODO 定义一个网络请求状态的处理
    // MutableLiveData通过这个变量（带有声明周期） 可以把数据显示到界面
    protected var status:MutableLiveData<String> = MutableLiveData()

    //TODO  token刷新通知界面的数据状态
    var refreshToken:MutableLiveData<Int> = MutableLiveData()



}