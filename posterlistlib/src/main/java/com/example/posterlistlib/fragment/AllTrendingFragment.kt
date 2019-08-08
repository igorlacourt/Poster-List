package com.example.posterlistlib.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.posterlistlib.viewmodel.AllTrendingViewModel
import com.example.posterlistlib.R
import com.example.posterlistlib.fragment.adapter.AllTrendingAdapter
import com.example.posterlistlib.model.AllTrending
import kotlinx.android.synthetic.main.all_trending_fragment.view.*


class AllTrendingFragment : Fragment() {

    companion object {
        fun newInstance() = AllTrendingFragment()
    }

    private lateinit var viewModel: AllTrendingViewModel
    private var allTrendingAdapter:AllTrendingAdapter?? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("trendingtitle", "onCreateView() called")
        val rootView: View = inflater.inflate(R.layout.all_trending_fragment, container, false)
        allTrendingAdapter = AllTrendingAdapter(ArrayList<AllTrending>())
        rootView.rv_all_trending.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL ,false)
        rootView.rv_all_trending.adapter = allTrendingAdapter
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("trendingtitle", "onActivityCreated() called")
        viewModel = ViewModelProviders.of(this).get(AllTrendingViewModel::class.java)
        viewModel.fetchAllTrending()
        viewModel.trendingsLiveData.observe(this, Observer {
            Log.d("trendingtitle", "trendingsLiveData.observe() called")
            allTrendingAdapter!!.loadItems(it)
            allTrendingAdapter!!.notifyDataSetChanged()
        })
    }

}
