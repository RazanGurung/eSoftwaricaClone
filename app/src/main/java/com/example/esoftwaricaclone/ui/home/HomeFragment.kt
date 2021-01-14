package com.example.esoftwaricaclone.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esoftwaricaclone.MainActivity
import com.example.esoftwaricaclone.R
import com.example.esoftwaricaclone.adapter.PostAdapter
import com.example.esoftwaricaclone.model.Student

class HomeFragment : Fragment() {
    private lateinit var postrecycler : RecyclerView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        postrecycler = view.findViewById(R.id.postrecycle)

        val adapterView = PostAdapter(this.activity as Context,MainActivity.studentArrayList)
        postrecycler.layoutManager= LinearLayoutManager(context)
        postrecycler.adapter = adapterView
        return view
    }
}