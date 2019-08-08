package com.example.posterlistlib.fragment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posterlistlib.R
import com.example.posterlistlib.model.AllTrending
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rv_list_item.view.*

class AllTrendingAdapter(var list: List<AllTrending>?) : RecyclerView.Adapter<AllTrendingAdapter.AllTrendingViewHolder>() {
    private var results = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllTrendingViewHolder {
        Log.d("ViewHolderMethod", "onCreateViewHolder called");
        return AllTrendingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: AllTrendingViewHolder, position: Int) {
        Log.d("ViewHolderMethod", "onBindViewHolder called");
        /**
         *"poster_sizes": [
        "w92",
        "w154",
        "w185",
        "w342",
        "w500",
        "w780",
        "original"
        ] */
        Log.d("backdroppath", "backdrop_path = " + results!!.get(position).poster_path)
        Picasso.get().load("http://image.tmdb.org/t/p/w342${results!!.get(position).poster_path}").into(holder.poster);
//        holder.title.text = results!!.get(position).title
    }

    override fun getItemCount(): Int {
        if(results.isNullOrEmpty()) {
            return 0;
        }
        return results!!.size
    }

    fun loadItems(newItems: List<AllTrending>){
        Log.d("trendingtitle", "loadItems() called")
        this.results = newItems
//        for (i in 0..results!!.size){
//            Log.d("trendingtitle", "loadItems(): ${results!!.get(i).title} + \n")
//        }
    }

    class AllTrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poster = itemView.poster
//        var title = itemView.title
    }

}