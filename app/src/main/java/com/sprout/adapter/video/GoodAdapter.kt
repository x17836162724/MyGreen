package com.sprout.adapter.video

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sprout.R
import com.sprout.model.GoodData
import com.sprout.utils.MyItemClick
import kotlinx.android.synthetic.main.layout_tag_item.view.*

/**
 * 商品的adapter
 */
class GoodAdapter( private val mContext: Context?,
                   private val list: List<GoodData.Data?>?): RecyclerView.Adapter<GoodAdapter.ViewHolder>() {

    //定义ViewHolder
    class ViewHolder(item: View) :RecyclerView.ViewHolder(item)



    override fun onBindViewHolder(holder: GoodAdapter.ViewHolder, position: Int) {
        with(holder ?.itemView!!){
            if(list!=null) {
                var bean = list!!.get(position)
                txt_name.setText(bean!!.name)
            }
        }

        //设置接口
        holder.itemView.setOnClickListener{
            myItemClick!!.onItemCilck(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_good_item, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list!!.size
    }

    //定义条目回调接口
    private var myItemClick: MyItemClick? = null
    //set方法
    fun setOnItemClick(myItemClick: MyItemClick){
        this.myItemClick = myItemClick
    }

}