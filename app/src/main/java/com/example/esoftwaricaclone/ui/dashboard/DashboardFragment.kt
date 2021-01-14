package com.example.esoftwaricaclone.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.esoftwaricaclone.R
import com.example.esoftwaricaclone.adapter.Communicator

class DashboardFragment : Fragment(), View.OnClickListener {
    private lateinit var id : EditText
    private lateinit var name : EditText
    private lateinit var age : EditText
    private lateinit var address : EditText
    private lateinit var image : EditText
    private lateinit var male : RadioButton
    private lateinit var female : RadioButton
    private lateinit var addstudent : Button
    private var gender = ""

    private lateinit var communicator : Communicator
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        id = view.findViewById(R.id.uid)
        name = view.findViewById(R.id.Name)
        age = view.findViewById(R.id.Age)
        address = view.findViewById(R.id.Address)
        image = view.findViewById(R.id.image)
        male = view.findViewById(R.id.male)
        female = view.findViewById(R.id.female)
        addstudent = view.findViewById(R.id.submit)

        male.setOnClickListener(this)
        female.setOnClickListener(this)
        addstudent.setOnClickListener(this)
        return view
    }
    private fun addStudent(){
        val uid = id.text.toString().toInt()
        val uname = name.text.toString()
        val uage = age.text.toString().toInt()
        val uaddress = address.text.toString()
        val uimage = image.text.toString()
        val ugender = gender

        communicator = activity as Communicator

        communicator.passData(uid,uname,uage,ugender,uaddress,uimage)
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.male ->{
                gender = "male"
            }
            R.id.female ->{
                gender = "female"
            }
            R.id.submit ->{
                addStudent()
            }
        }
    }
}