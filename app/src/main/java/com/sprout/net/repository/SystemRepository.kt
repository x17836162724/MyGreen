package com.example.myshop.net.repository

import com.shop.net.RetrofitFactory
import com.sprout.api.ServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.HashMap

/**
 * 数据仓库
 * 用来连接ViewModel和Model
 * 定义业务相关的网络请求接口的api
 */
class SystemRepository {

    private lateinit var serviceApi: ServiceApi

    //TODO 初始化的方法
    init {
        //在这里调用create 创建ServiceApi进行实例化
        serviceApi = RetrofitFactory.instance.create(ServiceApi::class.java)

    }

    //TODO 刷新token
    suspend fun refreshToken() = withContext(Dispatchers.IO) {
        serviceApi.refreshToken()
    }


    //TODO 希望在协程里面进行 所以使用suspend修饰


    //TODO 获取主页数据
    suspend fun getHome() = withContext(Dispatchers.IO) {
        serviceApi.getHome()
    }


}