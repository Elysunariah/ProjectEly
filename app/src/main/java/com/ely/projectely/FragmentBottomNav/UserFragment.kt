package com.ely.projectely.FragmentBottomNav

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ely.projectely.*
import com.ely.projectely.R
import com.ely.projectely.activity.Adapter
import com.ely.projectely.activity.User
import com.ely.projectely.prefshelper.PrefsHelper
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_user.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.startActivity
import java.lang.reflect.InvocationTargetException


class UserFragment : Fragment() {

    lateinit var ref : DatabaseReference
    lateinit var list  :MutableList<User>
    lateinit var listView: ListView

    lateinit var fAuth : FirebaseAuth

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

        ref = FirebaseDatabase.getInstance().getReference("USER")
        list = mutableListOf()
        listView = view!!.findViewById(R.id.listView)

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){

                    for (h in p0.children){
                        val user = h.getValue(User::class.java)
                        if (user != null) {
                            list.add(user)
                        }
                    }
                    val adapter = Adapter(activity!!,R.layout.item_grid,list)
                    listView.adapter = adapter
                }
            }


        })

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//        val list = getListBuku()
//
//        val layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
//        adapter = BukuAdapter(activity!!, list)
//
//        main_rv_list_data.layoutManager = layoutManager
//        main_rv_list_data.adapter = adapter
//
//    }
//    private fun getListBuku(): List<BukuContract> {
//        var listData: List<BukuContract>? = null
//        try {
//            ctx!!.database.use {
//                val result = select(BukuContract.TABLE_BUKU)
//                listData = result.parseList(classParser<BukuContract>())
//            }
//            return listData!!
//        }catch (e : InvocationTargetException) {
//            e.printStackTrace()
//            return emptyList()
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//        val listRefresh = getListBuku()
//        adapter = BukuAdapter(activity!!, listRefresh)
//        adapter?.notifyDataSetChanged()
//        main_rv_list_data.adapter = adapter
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        setHasOptionsMenu(true)
//        super.onCreate(savedInstanceState)
//    }
//
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.optionsmenudua, menu)


        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if (id == R.id.action_logout) {
            logout()
            val prefsHelper= PrefsHelper(activity!!.applicationContext)
            prefsHelper.SaveLogin(false)
            startActivity(Intent(activity, LoginAct::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
    private fun logout() {
        FirebaseAuth.getInstance().signOut()
    }




}