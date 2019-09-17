package com.ely.projectely.FragmentBottomNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ely.projectely.R



class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =

        inflater.inflate(R.layout.fragment_user, container, false)


companion object {
    fun newInstance(id: Int): UserFragment {
        val fr = UserFragment()
        val b = Bundle()
        fr.setArguments(b)
        return fr
    }
}
}