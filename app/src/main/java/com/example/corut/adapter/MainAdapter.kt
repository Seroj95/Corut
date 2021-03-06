package com.example.corut.adapter

import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.corut.R
import com.example.corut.model.User
import kotlinx.android.synthetic.main.item_layout.view.*
import java.util.ArrayList
import java.util.Collections.addAll

class MainAdapter(private val  users:ArrayList<User>):
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun  bind(user: User){
            itemView.apply {
                textViewUserName.text=user.userName
                textViewUserEmail.text=user.userEmail
                Glide.with(imageViewAvatar.context)
                    .load(user.image)
                    .into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder=
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))

    override fun getItemCount(): Int =users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
   holder.bind(users[position])
    }
    fun addUser(users: List<User>){
        this.users.apply {
            clear()
            addAll(users)
        }
    }
}