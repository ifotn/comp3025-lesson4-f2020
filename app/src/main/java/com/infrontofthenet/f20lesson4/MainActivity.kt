package com.infrontofthenet.f20lesson4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // event handler for Details button -> load Details activity using an explicit intent
        detailButton.setOnClickListener {
            // create a new intent using our app's context, and the Detail activities java class object
            val i = Intent(applicationContext, DetailActivity::class.java)
            startActivity(i)
        }
    }
}