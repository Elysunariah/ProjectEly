package com.ely.projectely.FragmentBottomNav.Tablayout

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ely.projectely.FragmentBottomNav.UserFragment
import com.ely.projectely.R
import kotlinx.android.synthetic.main.tablayout_dua.*

class TablayooutDua : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tablayout_dua, container, false)

        btnbaca.setOnClickListener {
            startActivity(Intent(activity, UserFragment::class.java))
        }
    }

}