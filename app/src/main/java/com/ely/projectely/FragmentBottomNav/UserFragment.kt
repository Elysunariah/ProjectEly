package com.ely.projectely.FragmentBottomNav

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ely.projectely.BukuAdapter
import com.ely.projectely.BukuContract
import com.ely.projectely.R
import com.ely.projectely.database
import kotlinx.android.synthetic.main.fragment_user.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import java.lang.reflect.InvocationTargetException


class UserFragment : Fragment() {
//    private lateinit var viewPager : ViewPager
//    private lateinit var tabs : TabLayout*

//    var adapter: BukuAdapter? = null

    var adapter: BukuAdapter? = null
    var ctx : Context? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v: View = inflater.inflate(R.layout.fragment_user, container, false)
        ctx = this@UserFragment.activity
        return v
//        viewPager = view.findViewById(R.id.viewpager_main)
//        tabs = view.findViewById(R.id.tabs_main)*



        return view

    }



companion object {
    fun newInstance(id: Int): UserFragment {
        val fr = UserFragment()
        val b = Bundle()
        fr.setArguments(b)
        return fr
    }
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = getListBuku()

        val layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
        adapter = BukuAdapter(activity!!, list)

        main_rv_list_data.layoutManager = layoutManager
        main_rv_list_data.adapter = adapter



//        val fragmentAdapter = MyPagerAdapter(childFragmentManager)
//        viewPager.adapter = fragmentAdapter
//        tabs.setupWithViewPager(viewPager)*
    }
//    private fun getListDataStudent(): List<BukuContract> {
//        var listData: List<BukuContract>? = null
//        ctx!!.database.use {
//            val result = select(BukuContract.TABLE_BUKU)
//            listData = result.parseList(classParser<BukuContract>())
//        }
//        return listData!!
//    }
    private fun getListBuku(): List<BukuContract> {
        var listData: List<BukuContract>? = null
        try {
            ctx!!.database.use {
                val result = select(BukuContract.TABLE_BUKU)
                listData = result.parseList(classParser<BukuContract>())
            }
            return listData!!
        }catch (e : InvocationTargetException) {
            e.printStackTrace()
            return emptyList()
        }}

    override fun onResume() {
        super.onResume()
        val listRefresh = getListBuku()
        adapter = BukuAdapter(activity!!, listRefresh)
        adapter?.notifyDataSetChanged()
        main_rv_list_data.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.optionsmenu, menu)
        return
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()

        if (id == R.id.about) {
            Toast.makeText(activity!!.applicationContext, "About Click", Toast.LENGTH_SHORT).show()
            return true
        }
        if (id == R.id.setting) {
            Toast.makeText(activity!!.applicationContext, "Setting click", Toast.LENGTH_SHORT).show()
            return true
        }
        if (id == R.id.logout) {
            Toast.makeText(activity!!.applicationContext, "logout click", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}