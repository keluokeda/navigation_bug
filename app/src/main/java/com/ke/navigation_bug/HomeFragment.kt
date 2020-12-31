package com.ke.navigation_bug

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment : BaseFragment(R.layout.fragment_home) {


    private val adapter =
        object : BaseQuickAdapter<String, BaseViewHolder>(android.R.layout.simple_list_item_1) {
            override fun convert(holder: BaseViewHolder, item: String) {
                holder.setText(android.R.id.text1, item)
            }

        }

    private val mainViewModel: MainViewModel by activityViewModels()

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = adapter
        mainViewModel.mainFragmentLifecycleMethodList.observe(viewLifecycleOwner) {
            adapter.setNewInstance(it.toMutableList())
        }
        val header = view.findViewById<TextView>(R.id.header)

       header.text =  homeViewModel.text
    }


    override fun onResume() {
        super.onResume()
        setTranslucentStatus(true)
        mainViewModel.add("onResume $this")
    }

    override fun onPause() {
        super.onPause()
        setTranslucentStatus(false)
        mainViewModel.add("onPause $this")

    }
}