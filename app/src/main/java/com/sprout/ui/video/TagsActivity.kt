package com.sprout.ui.video

import android.util.Log
import android.util.SparseArray
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.luck.picture.lib.tools.ToastUtils
import com.sprout.BR
import com.sprout.R
import com.sprout.adapter.video.BrandAdapter
import com.sprout.adapter.video.GoodAdapter
import com.sprout.base.BaseActivity
import com.sprout.base.IItemClick
import com.sprout.databinding.ActivityTagsBinding
import com.sprout.model.BrandData
import com.sprout.model.GoodData
import com.sprout.utils.MyItemClick
import com.sprout.vm.more.TagsViewModel
import kotlinx.android.synthetic.main.activity_tags.*

class TagsActivity:
    BaseActivity<TagsViewModel, ActivityTagsBinding>(R.layout.activity_tags,TagsViewModel::class.java) {

    lateinit var brandList:MutableList<BrandData.Data>
    lateinit var brandAdapter: BrandAdapter

    lateinit var goodList:MutableList<GoodData.Data>
    lateinit var goodAdapter: GoodAdapter


    override fun initData() {
        img_brand.setOnClickListener(View.OnClickListener {
            Log.d("TAG", "initData: "+"d2222222222222222")
            if(brandList.size == 0){
                mViewModel.getBrand()
            }else{
                recyTags.adapter = brandAdapter
                brandAdapter.notifyDataSetChanged()
            }
        })

        img_good.setOnClickListener(View.OnClickListener {
            if(goodList.size == 0){
                mViewModel.getGood()
            }else{
                recyTags.adapter = goodAdapter
                goodAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun initVM() {
        mViewModel.bList.observe(this, Observer {
            brandList.clear()
            brandList.addAll(it.data)
            recyTags.adapter = brandAdapter
            brandAdapter.notifyDataSetChanged()
        })

        mViewModel.gList.observe(this, Observer {
            goodList.clear()
            goodList.addAll(it.data)
            recyTags.adapter = goodAdapter
            goodAdapter.notifyDataSetChanged()
        })
    }

    override fun initVariable() {

    }

    override fun initView() {
        recyTags.layoutManager = LinearLayoutManager(this)
        var brandArr = SparseArray<Int>()
        brandArr.put(R.layout.layout_brand_item,BR.brandData)
        brandList = mutableListOf()
        brandAdapter = BrandAdapter(this,brandList,brandArr,BrandClick())

        var goodArr = SparseArray<Int>()
        brandArr.put(R.layout.layout_brand_item,BR.goodData)
        goodList = mutableListOf()
        goodAdapter = GoodAdapter(this,goodList)

        goodAdapter.setOnItemClick(object :MyItemClick{
            override fun onItemCilck(pos:Int) {
                intent.putExtra("name",goodList[pos].name)
                intent.putExtra("id",goodList[pos].id)
                setResult(2,intent)
                finish()
            }
        })

    }


    inner class BrandClick: IItemClick<BrandData.Data> {
        override fun itemClick(data: BrandData.Data?) {
            intent.putExtra("name",data!!.name)
            intent.putExtra("id",data!!.id)
            setResult(1,intent)
            finish()
        }

    }



}