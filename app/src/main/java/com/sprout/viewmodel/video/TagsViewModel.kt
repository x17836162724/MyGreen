package com.sprout.vm.more

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.shop.net.Injection
import com.shop.net.Injection.repository
import com.sprout.base.BaseViewModel
import com.sprout.model.BrandData
import com.sprout.model.GoodData
import kotlinx.coroutines.launch

class TagsViewModel : BaseViewModel(Injection.repository) {

    var bList:MutableLiveData<BrandData> = MutableLiveData()
    var gList:MutableLiveData<GoodData> = MutableLiveData()

    var bpage = 0
    var gpage = 0
    var size = 10
    //网络请求的状态值  -1 网络请求错误
    var loadStatue: MutableLiveData<Int> = MutableLiveData()

    fun getBrand(){
        viewModelScope.launch {
            var result = Injection.repository.getBrand(bpage,size)
            if(result.errno == 0){
                bList.postValue(result.data)
            }
        }
    }

    fun getGood(){
        viewModelScope.launch {
            var result = repository.getGood(gpage,size)
            if(result.errno == 0){
                gList.postValue(result.data)
            }
        }
    }

}