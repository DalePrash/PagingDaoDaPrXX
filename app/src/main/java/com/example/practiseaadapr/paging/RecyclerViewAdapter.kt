package com.example.rickymortydapr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.practiseaadapr.R
import com.example.practiseaadapr.data.NewsPojo

class RecyclerViewAdapter(): PagingDataAdapter<NewsPojo, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {

        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)

        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

      // val imageView: ImageView = view.findViewById(R.id.imageView)
        val tvName: TextView = view.findViewById(R.id.textaaa)
        val tvDesc: TextView = view.findViewById(R.id.textaaa)

        fun bind(data: NewsPojo) {
          //  tvName.text = data.name
            tvDesc.text = data.author

            /*
            Glide.with(imageView)
                .load(data.image)
                .circleCrop()
                .into(imageView)

             */

        }
    }

    class DiffUtilCallBack: DiffUtil.ItemCallback<NewsPojo>() {
        override fun areItemsTheSame(oldItem: NewsPojo, newItem: NewsPojo): Boolean {
           return oldItem.author == newItem.author
        }

        override fun areContentsTheSame(oldItem: NewsPojo, newItem: NewsPojo): Boolean {
            return oldItem.author == newItem.author

        }

    }

}