package com.example.esoftwaricaclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.esoftwaricaclone.R
import com.example.esoftwaricaclone.model.Student

class PostAdapter(
    val context: Context,
    val lstStudent: ArrayList<Student>
): RecyclerView.Adapter<PostAdapter.AdapterViewHolder>(){
    class AdapterViewHolder(view: View):RecyclerView.ViewHolder(view){
        val username : TextView
        val age : TextView
        val address : TextView
        val gender : TextView
        val profile : ImageView
        val delete : ImageButton

        init {
            username = view.findViewById(R.id.username)
            age = view.findViewById(R.id.age)
            address = view.findViewById(R.id.address)
            gender= view.findViewById(R.id.gender)
            profile = view.findViewById(R.id.profile)
            delete = view.findViewById(R.id.delete)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post,parent,false)
        return AdapterViewHolder(view)
    }
    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val post = lstStudent[position]
        holder.username.text = post.name
        holder.age.text = post.age.toString()
        holder.address.text = post.address
        holder.gender.text = post.gender

        Glide.with(context).load(post.Image).into(holder.profile)
        holder.delete.setOnClickListener{
            lstStudent.removeAt(position)
            notifyDataSetChanged()
        }
    }
    override fun getItemCount(): Int {
        return lstStudent.size
    }
}