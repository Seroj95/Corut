package com.example.viewpag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter(val images:List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViwHolder>() {
    inner  class ViewPagerViwHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViwHolder {
     val view= LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return ViewPagerViwHolder(view)
    }

    override fun getItemCount(): Int  =images.size

    override fun onBindViewHolder(holder: ViewPagerViwHolder, position: Int) {
        val curImage= images[position]
        holder.itemView.ivImage.setImageResource(curImage)
    }

}