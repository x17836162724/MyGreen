package com.sprout.api

import com.shop.net.BaseResp
import com.sprout.model.HomeBean
import retrofit2.http.*
import java.util.*

interface ServiceApi {

    //首页 // BaseResp抽取的一个bean类的外层结构 homeData当前接口返回的具体
    @GET("index")
    suspend fun getHome(): BaseResp<HomeBean>
    //刷新token
    @POST("auth/refreshToken")
    suspend fun refreshToken(): BaseResp<String>


}