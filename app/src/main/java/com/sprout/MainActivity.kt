package com.sprout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.sprout.ui.home.HomeFragment
import com.sprout.ui.me.MeFragment
import com.sprout.ui.message.MessageFragment
import com.sprout.ui.search.SearchFragment
import com.sprout.ui.video.MoreEditorActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.MessageFormat

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    lateinit var homeFragment:Fragment
    lateinit var searchFragment:Fragment
    lateinit var messageFragment:Fragment
    lateinit var meFragment:Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

        homeFragment=HomeFragment.instance
        searchFragment=SearchFragment.instance
        messageFragment=MessageFragment.instance
        meFragment=MeFragment.instance
        //初始化第一个fragment
        lateinit var transaction: FragmentTransaction
        transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.framelayout,homeFragment)
        transaction.commit()

        tab_home.setOnClickListener(this)
        tab_search.setOnClickListener(this)
        tab_video.setOnClickListener(this)
        tab_message.setOnClickListener(this)
        tab_me.setOnClickListener(this)
        initData()
    }
    fun initData(){
        
    }

        override fun onClick(v: View?) {
        when(v?.id){
            R.id.tab_home ->{
                lateinit var transaction: FragmentTransaction
                transaction = supportFragmentManager.beginTransaction()
                img_tab_home.setImageResource(R.mipmap.tab_home_select)
                img_tab_search.setImageResource(R.mipmap.tab_search_normal)
                img_tab_message.setImageResource(R.mipmap.tab_message_normal)
                img_tab_me.setImageResource(R.mipmap.tab_me_normal)

                transaction.add(R.id.framelayout,homeFragment)
                transaction.commit()
            }
            R.id.tab_search ->{
                lateinit var transaction: FragmentTransaction
                transaction = supportFragmentManager.beginTransaction()
                img_tab_home.setImageResource(R.mipmap.tab_home_normal)
                img_tab_search.setImageResource(R.mipmap.tab_sercher_select)
                img_tab_message.setImageResource(R.mipmap.tab_message_normal)
                img_tab_me.setImageResource(R.mipmap.tab_me_normal)

                transaction.replace(R.id.framelayout,searchFragment)
                transaction.commit()

            }
            R.id.tab_video ->{
                var intent = Intent(this, MoreEditorActivity::class.java)
                startActivity(intent)
            }

            R.id.tab_message ->{
                lateinit var transaction: FragmentTransaction
                transaction = supportFragmentManager.beginTransaction()
                img_tab_home.setImageResource(R.mipmap.tab_home_normal)
                img_tab_search.setImageResource(R.mipmap.tab_search_normal)
                img_tab_message.setImageResource(R.mipmap.tab_message_select)
                img_tab_me.setImageResource(R.mipmap.tab_me_normal)

                transaction.replace(R.id.framelayout,messageFragment)
                transaction.commit()

            }
            R.id.tab_me ->{
                lateinit var transaction: FragmentTransaction
                transaction = supportFragmentManager.beginTransaction()
                img_tab_home.setImageResource(R.mipmap.tab_home_normal)
                img_tab_search.setImageResource(R.mipmap.tab_search_normal)
                img_tab_message.setImageResource(R.mipmap.tab_message_normal)
                img_tab_me.setImageResource(R.mipmap.tab_me_select)
                transaction.replace(R.id.framelayout,meFragment)
                transaction.commit()

            }
        }
    }


}