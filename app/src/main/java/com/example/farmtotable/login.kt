package com.example.farmtotable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val fragmentManager = supportFragmentManager
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginBut = findViewById<Button>(R.id.loginBttn)
        loginBut.setOnClickListener(){
            val intention = Intent(this@login, MainActivity::class.java)
            startActivity(intention)
        }
        val registerNew = findViewById<Button>(R.id.registerBttn)
        registerNew.setOnClickListener(){
            val switchFragment = fragmentManager.beginTransaction()
            switchFragment.add(R.id.loginFragmentContainer,register_fragment())
            switchFragment.addToBackStack(null)
            switchFragment.commit()
        }
    }
}