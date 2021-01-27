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


    /**
     * 获取频道数据接口 给VM调用
     */
    suspend fun getChannel() = withContext(Dispatchers.IO){
        serviceApi.getChannel()
    }


    suspend fun getBrand(page:Int,size:Int) = withContext(Dispatchers.IO){
        serviceApi.getBrand(page,size)
    }

    suspend fun getGood(page:Int,size:Int) = withContext(Dispatchers.IO){
        serviceApi.getGood(page,size)
    }


}