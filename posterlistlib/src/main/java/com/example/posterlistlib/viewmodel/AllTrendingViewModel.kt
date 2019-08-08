package com.example.posterlistlib.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope
import com.example.posterlistlib.model.AllTrending
import com.example.posterlistlib.network.Apifactory
import kotlinx.coroutines.launch

class AllTrendingViewModel : ViewModel() {
    val trendingsLiveData = MutableLiveData<List<AllTrending>>()

    fun fetchAllTrending(){
        Log.d("trendingtitle", "fetchAllTrending() called")
        viewModelScope.launch {
            val trendings = Apifactory.tmdbApi.getAllTrending()
            try {
                var result = trendings.await()
                trendingsLiveData.value = result.results
//                for (i in 0..result.results.size){
//                    Log.d("trendingtitle", "fetchAllTrending(): ${result.results.get(i).title} + \n")
//                }
            } catch (e: Exception) {
                trendingsLiveData.value = ArrayList<AllTrending>()
            }
        }
    }
}
