package com.example.farmtotable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val fragmentManager = supportFragmentManager
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registerText = findViewById<TextView>(R.id.register_below)
        registerText.setOnClickListener{
            val setFragment = fragmentManager.beginTransaction()
            setFragment.setReorderingAllowed(true)
            setFragment.replace(R.id.loginFragmentContainer, register_fragment())
            setFragment.addToBackStack(null)
            setFragment.commit()
            registerText.setText("Already a member? Click here to login")
        }
    }
}