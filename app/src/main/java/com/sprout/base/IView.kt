package com.sprout.base
interface IView {
    fun showLoading()

    /**
     * 显示提示信息
     */
    fun showTips(tips:String)
}