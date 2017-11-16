package com.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_view_list_layout.view.*

/**
 * Created by tedliang on 2017/11/16.
 */
class HackerNewsAdapter(val items: List<Item>, val itemClickListener: (Item) -> Unit) : RecyclerView.Adapter<HackerNewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_list_layout, parent, false)
        return ViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val view: View, val itemClickListener: (Item) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bind(item: Item) {
            view.hackernews_id.text = item.s
            view.hackernews_title.text = item.title
            view.setOnClickListener {
                itemClickListener(item)
            }
        }
    }
}
