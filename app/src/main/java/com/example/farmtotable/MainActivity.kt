package com.example.farmtotable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val fragmentManager = supportFragmentManager
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeAppButton = findViewById<ImageView>(R.id.homeIcon)
        homeAppButton.setOnClickListener{
                val setFragment = fragmentManager.beginTransaction()
                setFragment.setReorderingAllowed(true)
                setFragment.replace(R.id.fragmentContainerView, Homepage_fragment())
                setFragment.addToBackStack(null)
                setFragment.commit()
        }
        val cartAppButton = findViewById<ImageView>(R.id.cartIcon)
        cartAppButton.setOnClickListener{
            val setFragment = fragmentManager.beginTransaction()
                setFragment.setReorderingAllowed(true)
                setFragment.replace(R.id.fragmentContainerView, cart_fragment())
                setFragment.addToBackStack(null)
                setFragment.commit()
        }
    }
}