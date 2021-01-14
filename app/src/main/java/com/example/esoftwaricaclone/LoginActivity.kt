package com.example.esoftwaricaclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var login : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)

        login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.login ->{
                var user = username.text.toString()
                var pass = password.text.toString()

                if (user == "softwarica" && pass == "coventry"){
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}