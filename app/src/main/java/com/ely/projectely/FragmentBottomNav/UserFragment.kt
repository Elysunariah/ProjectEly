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

    }
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

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.optionsmenudua, menu)


        menu!!.findItem(R.id.action_check).isVisible = false

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if (id == R.id.action_settings) {
            Toast.makeText(activity, "Setting", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }




}