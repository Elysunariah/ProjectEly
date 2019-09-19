package com.ely.projectely.FragmentBottomNav.Tablayout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.ely.projectely.BukuAdapter
import com.ely.projectely.BukuContract
import com.ely.projectely.FragmentBottomNav.CreateFragment
import com.ely.projectely.R
import com.ely.projectely.database
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.tablayout_satu.*
import kotlinx.coroutines.selects.select
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.intentFor
import java.lang.reflect.InvocationTargetException

class TablayoutSatu : Fragment() {
//    var adapter: BukuAdapter? = null
//    var ctx : Context? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val v =
       return inflater.inflate(R.layout.tablayout_satu, container, false)
//        ctx = this@TablayoutSatu.activity
//        return v


//        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val list = getListBuku()
//        val layoutManager = LinearLayoutManager(activity!!.applicationContext, LinearLayoutManager.VERTICAL, false)
//        adapter = BukuAdapter(activity!!.applicationContext, list)
//
//        main_rv_list_data.layoutManager = layoutManager
//        main_rv_list_data.adapter = adapter *

    }

//    private fun getListBuku(): List<BukuContract> {
//        var listData: List<BukuContract>? = null
//        try {
//            ctx!!.database.use {
//                val result = select(BukuContract.TABLE_BUKU)
//                listData = result.parseList(classParser<BukuContract>())
//            }
//            return listData!!
//        }catch (e :InvocationTargetException){
//            e.printStackTrace()
//            return emptyList()
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//        val listRefresh = getListBuku()
//        adapter = BukuAdapter(activity!!.applicationContext, listRefresh)
//        adapter?.notifyDataSetChanged()
//        main_rv_list_data.adapter = adapter
}
