package com.sprout.ui.home

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.sprout.R
import com.sprout.ui.home.fragment.CityFragment
import com.sprout.ui.home.fragment.LoveFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
var tabs: Array<String> = arrayOf<String>("同城", "关注", "推荐")
var city:CityFragment= CityFragment()
var love:LoveFragment= LoveFragment()

var lsit =listOf<Fragment>(city, love, city)
class HomeFragment : Fragment() {

    companion object{
        val instance:HomeFragment by lazy { HomeFragment() }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var inflater=inflater.inflate(R.layout.fragment_home, container, false)

        initView(inflater)
        return inflater
    }
    fun Tank(context: Context?, attrs: AttributeSet?) {

    }
    fun  initView(inflater: View) {

        inflater.viewpager1.adapter=MyAdapter(lsit,childFragmentManager)
        inflater.tab.setupWithViewPager(viewpager1)

        val inflate =
            LayoutInflater.from(activity).inflate(R.layout.home_layout_tab, null) as TextView
        inflate.setTextColor(ContextCompat.getColor(activity!!, R.color.color_black_pro))
        inflate.textSize = 20f
        inflate.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD)) //加粗

//        inflate.setText(tab.getTabAtdqq`(0)?.text)
//        tab.getTabAt(0)?.setCustomView(inflate)?.select()
       inflater.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val inflate = LayoutInflater.from(activity)
                    .inflate(R.layout.home_layout_tab, null) as TextView
                inflate.setTextColor(ContextCompat.getColor(activity!!, R.color.color_black_pro))
                inflate.textSize = 20f
                inflate.text = tab.text
                inflate.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD)) //加粗
                tab.customView = inflate
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.customView = null
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }


    internal class MyAdapter(var fragments:List<Fragment>,fm: FragmentManager?) :
        FragmentPagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
            return fragments.get(position)
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return tabs[position]
        }
    }
}


