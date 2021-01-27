package com.sprout.api

import com.shop.net.BaseResp
import com.sprout.model.BrandData
import com.sprout.model.ChannelData
import com.sprout.model.GoodData
import com.sprout.model.HomeBean
import retrofit2.http.*
import java.util.*

interface ServiceApi {


    /**
     * 获取频道数据
     */
    @GET("channel/channel")
    suspend fun getChannel():BaseResp<ChannelData>

    @GET("tag/brand")
    suspend fun getBrand(@Query("page") page:Int,@Query("size") size:Int):BaseResp<BrandData>

    @GET("tag/goods")
    suspend fun getGood(@Query("page") page:Int,@Query("size") size:Int):BaseResp<GoodData>


}