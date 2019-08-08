package com.example.posterlist.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.posterlist.R
import com.example.posterlist.viewmodel.TvTrendingViewModel

class TvTrendingFragment : Fragment() {

    companion object {
        fun newInstance() = TvTrendingFragment()
    }

    private lateinit var viewModel: TvTrendingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tv_trending_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TvTrendingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
